package com.example.trabalhocrud.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "pessoas")
data class Pessoa (
//    @PrimaryKey(autoGenerate = true) val id: Int,
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "nome") val nome: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "telefone") val celular: String

    )
//{
//    constructor(nome: String, email: String, celular: String) : this(0, nome, email, celular) // Após sobrescrever o constructor, não é necessário adicionar o ID manual
//}

