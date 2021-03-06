package com.fahim.example_employee_app.di.appModule

import android.content.Context
import androidx.room.Room
import com.fahim.example_employee_app.db.EmployeeDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDB(context : Context) : EmployeeDatabase {
        synchronized(EmployeeDatabase::class) {
            return Room.databaseBuilder(context, EmployeeDatabase::class.java,EmployeeDatabase.DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
        }
    }

    @Provides
    @Singleton
    fun provideDao(database: EmployeeDatabase) = database.employeeDao()
}