package xyz.elzspikes.statapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    private val adapter = RecordsAdapter(emptyList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this, MainViewModelFactory(this))
                .get(MainViewModel::class.java)

        viewModel.allRecords.observe(this, Observer {
            adapter.loadItems(it ?: emptyList())
            adapter.notifyDataSetChanged()
        })

        viewModel.currentRecord.observe(this, Observer {
            findViewById<View>(R.id.button_record).isEnabled = true
        })

        findViewById<RecyclerView>(R.id.recycler_records).adapter = adapter

        findViewById<View>(R.id.button_record).setOnClickListener {
            viewModel.toggle(this)
        }
    }
}
