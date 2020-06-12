package com.example.levanhomework7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.levanhomework7.adapters.MockAdapter
import com.example.levanhomework7.api.ApiModel
import com.example.levanhomework7.api.RetrofitClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var mockAdapter: MockAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager = LinearLayoutManager(this)
        apiRecyclerView.layoutManager = layoutManager
        mockAdapter = MockAdapter(ArrayList())
        apiRecyclerView.adapter = mockAdapter

        getData()
    }

    private fun getData() {
        RetrofitClient.mockApi.getInfo()
            .enqueue(object : Callback<List<ApiModel>> {
                override fun onFailure(call: Call<List<ApiModel>>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<List<ApiModel>>,
                    response: Response<List<ApiModel>>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        mockAdapter.updateRecycler(response.body()!!)
                    }
                }

            })
    }
}
