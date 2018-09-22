package xyz.elzspikes.statapp

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import xyz.elzspikes.core.TimeRecord
import xyz.elzspikes.core.TimeRecordDataAccess

/**
 * Created by Jameido on 22/09/2018.
 */
class MainViewModel(context: Context) : ViewModel() {

    var currentRecord: LiveData<TimeRecord>
    var allRecords: LiveData<List<TimeRecord>>

    init {
        val dataAccess = TimeRecordDataAccess()

        currentRecord = dataAccess.getCurrentRecord(context)
        allRecords = dataAccess.getAllRecords(context)
    }

    fun ongoing(): Boolean {
        return currentRecord.value != null && currentRecord.value!!.end == 0L
    }

    fun toggle(context: Context) {
        if (ongoing()) {
            end(context)
        } else {
            start(context)
        }
    }

    fun start(context: Context) {
        val dataAccess = TimeRecordDataAccess()

        dataAccess.insertRecord(context, TimeRecord())
    }

    fun end(context: Context) {
        currentRecord.value?.let {
            it.end = System.currentTimeMillis()

            val dataAccess = TimeRecordDataAccess()
            dataAccess.updateRecord(context, it)
        }
    }
}