package com.learn.task.databasemanager
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_grammar")
data class CountryDbModel(
    @PrimaryKey(autoGenerate = true) var tblId: Int = 0,
    @ColumnInfo(name = "countryId") var countryId: Int,
    @ColumnInfo(name = "countryName") var countryName: String,
    @ColumnInfo(name = "countryDescription") var countryDescription:String)
