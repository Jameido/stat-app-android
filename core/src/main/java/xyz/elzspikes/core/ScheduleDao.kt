package xyz.elzspikes.core

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

/**
 * Created by Jameido on 17/09/2018.
 */
@Dao
interface ScheduleDao{

    @Query("SELECT count(id) FROM schedule LIMIT 1")
    fun forceOnCreate(): List<String>

    @Query("SELECT * FROM schedule")
    fun getAll(): List<ScheduleDay>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg days: ScheduleDay)

    @Query("DELETE FROM schedule")
    fun clear()

    @Query("DELETE FROM schedule WHERE day = :day")
    fun deleteDay(day: Long)
}