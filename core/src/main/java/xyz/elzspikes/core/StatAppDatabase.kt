package xyz.elzspikes.core

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Created by Jameido on 17/09/2018.
 *
 * The Room database that contains the schedule and history
 */
@Database(entities = arrayOf(TimeRecord::class, ScheduleDay::class), version = 1)
abstract class StatAppDatabase : RoomDatabase() {

    companion object {

        @Volatile
        private var sINSTANCE: StatAppDatabase? = null

        fun getInstance(context: Context): StatAppDatabase =
                sINSTANCE ?: synchronized(this) {
                    sINSTANCE ?: buildDatabase(context).also { sINSTANCE = it }
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        StatAppDatabase::class.java, "StatApp.db")
                        .build()
    }

    abstract fun timeRecordDao(): TimeRecordDao

    abstract fun scheduleDao(): ScheduleDao
}