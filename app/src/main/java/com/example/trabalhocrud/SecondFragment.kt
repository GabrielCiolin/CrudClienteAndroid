package com.example.trabalhocrud

import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.example.trabalhocrud.Model.Pessoa
import com.example.trabalhocrud.databinding.FragmentSecondBinding
import com.google.android.material.snackbar.Snackbar

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

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCadastrar.setOnClickListener {
            val id = binding.idPessoa.text.toString()
            val novoId= Integer.parseInt(id)
            val nome = binding.nome.text.toString()
            val email = binding.email.text.toString()
            val celular = binding.celular.text.toString()
            var fulano: Pessoa = Pessoa(
                novoId,
                nome,
                email,
                celular
            )

            Thread {
                val applicationContext = activity?.applicationContext;
                val db = Room.databaseBuilder(
                    applicationContext!!,
                    AppDatabase::class.java, "banco"
                ).build()

                val pessoaDao = db.pessoaDao()
                pessoaDao.insert(fulano)
                val pessoa = pessoaDao.get(novoId)
                Log.e("Pessoa ",pessoa.toString())
            }.start()
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)

        }

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}