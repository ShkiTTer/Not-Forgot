package com.notforgot.data.db.session

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.notforgot.data.db.session.model.SessionEntity

@Dao
interface SessionDao {
    @Query("SELECT * FROM Sessions ORDER BY id DESC LIMIT 1")
    fun getSession(): SessionEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createSession(data: SessionEntity)

    @Query("DELETE FROM Sessions")
    fun clearSessions()
}