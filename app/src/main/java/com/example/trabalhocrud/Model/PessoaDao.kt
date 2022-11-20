package com.example.trabalhocrud.Model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface PessoaDao{

    @Query("SELECT * FROM pessoas")
    fun getAll(): List<Pessoa>

    @Query("SELECT * FROM pessoas WHERE id = :id")
    fun get(id: Int): Pessoa

    @Insert
    fun insert(vararg pessoa: Pessoa)

    @Delete
    fun delete(vararg pessoa: Pessoa)

    @Update
    fun update(vararg pessoa: Pessoa)

}