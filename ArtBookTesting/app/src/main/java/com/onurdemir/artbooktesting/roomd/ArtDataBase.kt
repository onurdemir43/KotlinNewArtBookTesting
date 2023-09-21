package com.onurdemir.artbooktesting.roomd

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Art::class],version = 1)
abstract class ArtDatabase : RoomDatabase() {
    abstract fun artDao() : ArtDao
}

/*
@Database(entities = [Art::class], version = 1)
abstract class ArtDataBase : RoomDatabase() {
    abstract fun artDao() : ArtDao
}

 */
