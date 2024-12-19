package com.singlepointsol.sqlitedatabase

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION) {
    companion object {
        const val DATABASE_NAME="employees.db"
        const val DATABASE_VERSION=1
        const val DATABASE_TABLE="emp_table"
        const val KEY_ID = "_ID"
        const val KEY_NAME="Name"
        const val KEY_EMAIL="Email"
        const val KEY_PHONE="Phone"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable=" create table $DATABASE_TABLE ( $KEY_ID INTEGER PRIMARY KEY AUTOINCREMENT , $KEY_NAME TEXT , $KEY_EMAIL TEXT , $KEY_PHONE TEXT)"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("drop table if exists $DATABASE_TABLE")
        onCreate(db)
    }
    fun addEmployee(employee:Employee):Long{
        val db = this.writableDatabase
        val contentValues=ContentValues()
        contentValues.put(KEY_NAME,employee.name)
        contentValues.put(KEY_EMAIL,employee.email)
        contentValues.put(KEY_PHONE,employee.phone)
        return db.insert(DATABASE_TABLE,null,contentValues)
    }
    fun getEmployees():ArrayList<Employee>{
        val employeesArrayList:ArrayList<Employee> = ArrayList()
        val db=this.readableDatabase
        val cursor:Cursor = db.rawQuery("select * from $DATABASE_TABLE",null)
        while(cursor.moveToNext()){
            val name=cursor.getString(1)
            val email=cursor.getString(2)
            val phone=cursor.getString(3)
            val emp=Employee(name,email, phone)
            employeesArrayList.add(emp)
        }
        cursor.close()
        db.close()
        return employeesArrayList
    }
    fun updateEmployee( id:String,name:String,email:String,phone:String):Boolean{
        val db=writableDatabase
        val contentValues=ContentValues()
        contentValues.put(KEY_ID,id)
        contentValues.put(KEY_NAME,name)
        contentValues.put(KEY_EMAIL,email)
        contentValues.put(KEY_PHONE,phone)
        db.update(DATABASE_TABLE,contentValues,"$KEY_ID=?", arrayOf(id))
        return true
    }
    fun deleteEmployee(id: String):Int{
        val db=writableDatabase
        return db.delete(DATABASE_TABLE,"$KEY_ID=?", arrayOf(id))
    }
}