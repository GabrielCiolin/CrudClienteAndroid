package com.example.trabalhocrud

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.example.trabalhocrud.Model.Pessoa
import com.example.trabalhocrud.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val applicationContext = activity?.applicationContext;
        Thread {
            val db = Room.databaseBuilder(
                applicationContext!!,
                AppDatabase::class.java, "banco"
            ).build()

            var fulano: Pessoa = Pessoa(
                5,
                "Gabriel Ciolin",
                "gabriel@hotmail.com",
                "44999981716"
            )

            val pessoaDao = db.pessoaDao()
//            pessoaDao.insert(fulano)
            val pessoas = pessoaDao.getAll()
            Log.e("Pessoa ",pessoas.toString())
        }.start()
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}