package com.example.trabalhocrud

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.trabalhocrud.Model.Pessoa
import com.example.trabalhocrud.Model.PessoaDao

@Database(
    entities = [
        Pessoa::class,
    ],
    version = 1
)
abstract class AppDatabase: RoomDatabase(){

    abstract fun pessoaDao(): PessoaDao

}