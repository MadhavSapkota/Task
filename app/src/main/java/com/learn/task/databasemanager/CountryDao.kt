package com.learn.task.databasemanager
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
 interface CountryDao {

    @Insert
    fun insertSingleCard(countryDbModel: List<CountryDbModel>)

    @Query("SELECT * FROM tbl_grammar  ORDER BY countryId ASC")
    fun getFavList(): List<CountryDbModel>

    @Query("DELETE FROM tbl_grammar")
    fun deleteFav1(): Int
}