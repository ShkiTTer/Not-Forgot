package com.notforgot.data.db.common

import androidx.room.Database
import androidx.room.RoomDatabase
import com.notforgot.data.db.session.SessionDao
import com.notforgot.data.db.session.model.SessionEntity

@Database(entities = [SessionEntity::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getSessionDao(): SessionDao
}