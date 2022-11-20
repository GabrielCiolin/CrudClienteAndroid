package com.example.trabalhocrud.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "pessoas")
data class Pessoa (

    @PrimaryKey val id: Int,
    @ColumnInfo(name = "nome") val nome: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "telefone") val celular: String

    )

