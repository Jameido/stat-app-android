package xyz.elzspikes.core

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Created by Jameido on 17/09/2018.
 */
@Dao
interface ScheduleDao {

    @Query("SELECT count(id) FROM schedule LIMIT 1")
    fun forceOnCreate(): List<String>

    @Query("SELECT * FROM schedule")
    fun getAll(): LiveData<List<ScheduleDay>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg days: ScheduleDay)

    @Query("DELETE FROM schedule")
    fun clear()

    @Query("DELETE FROM schedule WHERE id = :id")
    fun deleteDay(id: Long)
}