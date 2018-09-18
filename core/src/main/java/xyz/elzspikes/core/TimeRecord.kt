package xyz.elzspikes.core

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by Jameido on 17/09/2018.
 */
@Entity(tableName = "records")
data class TimeRecord(@PrimaryKey(autoGenerate = true) var id: Long?,
                      @ColumnInfo(name = "start") var start: Long,
                      @ColumnInfo(name = "end") var end: Long) {
    constructor() : this(null, 0, 0)
}