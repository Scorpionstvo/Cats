package com.example.cats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cats.databinding.FragmentBreedsBinding

class BreedsFragment : Fragment() {
    private var binding: FragmentBreedsBinding? = null
    private val dataModel: DataModel by viewModels()
    lateinit var adapter: BreedAdapter


    companion object {
        fun newInstance() = BreedsFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBreedsBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = BreedAdapter(context!!)
        binding?.rcBreeds?.adapter = adapter
        binding?.rcBreeds?.layoutManager = LinearLayoutManager(context)

        dataModel.breedModelList.observe(viewLifecycleOwner, {
            adapter.updateList(it as ArrayList<BreedModel>)
        })

        fillAdapter()
    }

    private fun fillAdapter() {
        dataModel.loadBreeds()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }


}
