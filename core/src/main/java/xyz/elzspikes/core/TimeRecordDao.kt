package xyz.elzspikes.core

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * Created by Jameido on 17/09/2018.
 */
@Dao
interface TimeRecordDao {

    @Query("SELECT count(id) FROM records LIMIT 1")
    fun forceOnCreate(): List<String>

    @Query("SELECT * FROM records")
    fun getAll(): LiveData<List<TimeRecord>>

    @Query("SELECT * FROM records WHERE end == 0 ORDER BY start LIMIT 1")
    fun getCurrent(): LiveData<TimeRecord>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg days: TimeRecord)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(vararg days: TimeRecord)

    @Delete()
    fun delete(vararg days: TimeRecord)

    @Query("DELETE FROM records")
    fun clear()

    @Query("DELETE FROM records WHERE id = :id")
    fun delete(id: Long)
}