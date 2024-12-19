package com.singlepointsol.sqlitedatabasetest

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION) {
    companion object {
        const val DATABASE_NAME="flowers.db"
        const val DATABASE_VERSION=1
        const val DATABASE_TABLE="flw_table"
        const val KEY_ID = "_ID"
        const val KEY_NAME="Name"
        const val KEY_TYPE="TYPE"
        const val KEY_COLOR="Color"
        const val KEY_SYMBOLISM="Symbolism"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable=" create table $DATABASE_TABLE ( $KEY_ID INTEGER PRIMARY KEY AUTOINCREMENT , $KEY_NAME TEXT , $KEY_TYPE TEXT , $KEY_COLOR TEXT , $KEY_SYMBOLISM TEXT)"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("drop table if exists $DATABASE_TABLE")
        onCreate(db)
    }

    fun addFlowers(flowers: Flowers):Long{
        val db = this.writableDatabase
        val contentValues=ContentValues()
        contentValues.put(KEY_NAME,flowers.name)
        contentValues.put(KEY_TYPE,flowers.type)
        contentValues.put(KEY_COLOR,flowers.color)
        contentValues.put(KEY_SYMBOLISM,flowers.symbolism)
        return db.insert(DATABASE_TABLE,null,contentValues)
    }
    fun getFlowers():ArrayList<Flowers>{
        val flowersArrayList:ArrayList<Flowers> = ArrayList()
        val db=this.readableDatabase
        val cursor: Cursor = db.rawQuery("select * from $DATABASE_TABLE",null)
        while(cursor.moveToNext()){
            val name=cursor.getString(1)
            val type=cursor.getString(2)
            val color=cursor.getString(3)
            val symbolism=cursor.getString(4)
            val flw=Flowers(name,type, color, symbolism)
            flowersArrayList.add(flw)
        }
        cursor.close()
        db.close()
        return flowersArrayList
    }
    fun updateFlowers( id:String,name:String,type:String,color:String,symbolism:String):Boolean{
        val db=writableDatabase
        val contentValues=ContentValues()
        contentValues.put(KEY_ID,id)
        contentValues.put(KEY_NAME,name)
        contentValues.put(KEY_TYPE,type)
        contentValues.put(KEY_COLOR,color)
        contentValues.put(KEY_SYMBOLISM,symbolism)
        db.update(DATABASE_TABLE,contentValues,"$KEY_ID=?", arrayOf(id))
        return true
    }
    fun deleteFlowers(id: String):Int{
        val db=writableDatabase
        return db.delete(DATABASE_TABLE,"$KEY_ID=?", arrayOf(id))
    }

}