package xyz.elzspikes.statapp

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import xyz.elzspikes.core.TimeRecord

/**
 * Created by Jameido on 22/09/2018.
 */
class RecordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(timeRecord: TimeRecord){
        itemView.findViewById<AppCompatTextView>(R.id.text_record).text = "start: ${timeRecord.start} end:${timeRecord.end}"
    }
}