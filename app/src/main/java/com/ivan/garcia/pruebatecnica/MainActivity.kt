package com.ivan.garcia.pruebatecnica
import ListAdapter
import UsersData
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ivan.garcia.pruebatecnica.view.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ListViewModel
    private var mutableList: MutableList<UsersData> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[ListViewModel::class.java]
        listRecyclerView.layoutManager = LinearLayoutManager(this)
        listRecyclerView.adapter = ListAdapter{

        }

        viewModel.getDataList()

        viewModel.usersList.observe(this) { list ->
            (listRecyclerView.adapter as ListAdapter).setData(list)
            mutableList =
                (listRecyclerView.adapter as ListAdapter).usersList as MutableList<UsersData>
        }

        edtSearch.addTextChangedListener { userFilter ->
            val listFiltered = mutableList.filter {
                    list -> list.nombre.lowercase().contains(userFilter.toString().lowercase())
            }
            viewModel.usersList.observe(this) {
                (listRecyclerView.adapter as ListAdapter).updateData(listFiltered)
            }
        }
    }
}