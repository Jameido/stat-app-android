package xyz.elzspikes.core

import android.content.Context
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import java.lang.ref.WeakReference

/**
 * Created by Jameido on 22/09/2018.
 */
class TimeRecordDataAccess() {

    fun getCurrentRecord(context: Context): LiveData<TimeRecord> {
        return StatAppDatabase.getInstance(context).timeRecordDao().getCurrent()
    }

    fun getAllRecords(context: Context): LiveData<List<TimeRecord>> {
        return StatAppDatabase.getInstance(context).timeRecordDao().getAll()
    }

    fun insertRecord(context: Context, record: TimeRecord) {
        InsertAsyncTask(context).execute(record)
    }

    fun updateRecord(context: Context, record: TimeRecord) {
        UpdateAsyncTask(context).execute(record)
    }

    private class InsertAsyncTask internal constructor(context: Context) : AsyncTask<TimeRecord, Void, Void>() {

        private val mContext: WeakReference<Context> = WeakReference(context)

        override fun doInBackground(vararg params: TimeRecord): Void? {
            if (mContext.get() != null) {
                StatAppDatabase.getInstance(mContext.get()!!).timeRecordDao().insert(params[0])
            }
            return null
        }
    }

    private class UpdateAsyncTask internal constructor(context: Context) : AsyncTask<TimeRecord, Void, Void>() {

        private val mContext: WeakReference<Context> = WeakReference(context)

        override fun doInBackground(vararg params: TimeRecord): Void? {
            if (mContext.get() != null) {
                StatAppDatabase.getInstance(mContext.get()!!).timeRecordDao().update(params[0])
            }
            return null
        }
    }
}