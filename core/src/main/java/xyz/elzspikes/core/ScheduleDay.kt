package xyz.elzspikes.core

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Jameido on 17/09/2018.
 */
@Entity(tableName = "schedule")
data class ScheduleDay(@PrimaryKey(autoGenerate = true) var id: Long?,
                       @ColumnInfo(name = "dayOfWeek") var dayOfWeek: Short,
                       @ColumnInfo(name = "durationSecs") var durationSecs: Long,
                       @ColumnInfo(name = "startTime") var startTime: Long,
                       @ColumnInfo(name = "endTime") var endTime: Long) {
    constructor() : this(null, 0, 0, 0, 0)
}