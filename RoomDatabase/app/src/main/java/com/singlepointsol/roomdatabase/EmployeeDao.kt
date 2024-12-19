package com.singlepointsol.roomdatabase

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface EmployeeDao {
    @Insert
    fun addEmployee(employee: Employee)
}