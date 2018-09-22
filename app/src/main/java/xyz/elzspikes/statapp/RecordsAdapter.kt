package xyz.elzspikes.statapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import xyz.elzspikes.core.TimeRecord

/**
 * Created by Jameido on 22/09/2018.
 */
class RecordsAdapter(private var timeRecords: List<TimeRecord>) : RecyclerView.Adapter<RecordViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordViewHolder {
        return RecordViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_record, parent, false))
    }

    override fun getItemCount(): Int {
        return timeRecords.size
    }

    override fun onBindViewHolder(holder: RecordViewHolder, position: Int) {
        holder.bind(timeRecords[position])
    }

    fun loadItems(newItems: List<TimeRecord>) {
        timeRecords = newItems
    }
}