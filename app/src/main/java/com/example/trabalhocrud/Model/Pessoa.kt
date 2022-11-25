package com.example.trabalhocrud.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "pessoas")
data class Pessoa (
    @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo(name = "nome") var nome: String,
    @ColumnInfo(name = "email") var email: String,
    @ColumnInfo(name = "telefone") var celular: String

    )
//{
//    constructor(nome: String, email: String, celular: String) : this(0, nome, email, celular)
//}

