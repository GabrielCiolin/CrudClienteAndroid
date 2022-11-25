package com.example.trabalhocrud

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.trabalhocrud.Model.Pessoa
import com.example.trabalhocrud.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        var pessoas: List<Pessoa>? = null;
        Thread{

            val applicationContext = activity?.applicationContext;
            val db = Room.databaseBuilder(
                applicationContext!!,
                AppDatabase::class.java, "banco"
            ).build()

            val pessoaDao = db.pessoaDao()
//            pessoaDao.insert(fulano)
            pessoas = pessoaDao.getAll()
            Log.e("Pessoa ",pessoas.toString())



            var mLayoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
            binding.rv!!.layoutManager = mLayoutManager
            val mAdapter = Myadapter(pessoas)
            binding.rv!!.adapter = mAdapter


        }.start()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}