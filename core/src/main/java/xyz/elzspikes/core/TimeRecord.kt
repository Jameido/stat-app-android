package xyz.elzspikes.core

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Jameido on 17/09/2018.
 */
@Entity(tableName = "records")
data class TimeRecord(@PrimaryKey(autoGenerate = true) var id: Long?,
                      @ColumnInfo(name = "start") var start: Long,
                      @ColumnInfo(name = "end") var end: Long) {
    constructor() : this(null, System.currentTimeMillis(), 0)
}