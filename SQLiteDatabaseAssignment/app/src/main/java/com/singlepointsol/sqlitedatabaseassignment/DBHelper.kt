package com.singlepointsol.sqlitedatabaseassignment

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.EditText


class DBHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION) {
    companion object {


        const val DATABASE_NAME="employees.db"
        const val DATABASE_VERSION=1
        const val DATABASE_TABLE="emp_table"
        const val KEY_ID = "_ID"
        const val KEY_NAME="Name"
        const val KEY_EMAIL="Email"
        const val KEY_PASSWORD="Password"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable=" create table $DATABASE_TABLE ( $KEY_ID INTEGER PRIMARY KEY AUTOINCREMENT , $KEY_NAME TEXT , $KEY_EMAIL TEXT , $KEY_PASSWORD TEXT)"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("drop table if exists $DATABASE_TABLE")
        onCreate(db)
    }

    // Insert a new user
    fun insertUser(name: String, password: String,email: String): Long {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(KEY_NAME, name)
            put(KEY_EMAIL,email)
            put(KEY_PASSWORD, password)
        }
        return db.insert(DATABASE_TABLE, null, values)
    }

    // Check if a user exists
    fun isUserValid( password: String, email: String): Boolean {
        val db = this.readableDatabase
        val query = "SELECT * FROM $DATABASE_TABLE WHERE  $KEY_EMAIL = ? AND $KEY_PASSWORD = ?"
        val cursor = db.rawQuery(query, arrayOf( email, password))
        val isValid = cursor.count > 0
        cursor.close()
        return isValid
    }

}

