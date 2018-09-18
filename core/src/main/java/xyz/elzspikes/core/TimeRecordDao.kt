package xyz.elzspikes.core

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

/**
 * Created by Jameido on 17/09/2018.
 */
@Dao
interface TimeRecordDao{

    @Query("SELECT count(id) FROM records LIMIT 1")
    fun forceOnCreate(): List<String>

    @Query("SELECT * FROM records")
    fun getAll(): List<TimeRecord>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg days: TimeRecord)

    @Query("DELETE FROM records")
    fun clear()

    @Query("DELETE FROM records WHERE id = :id")
    fun delete(id: Long)
}