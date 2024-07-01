package ru.itis.summer24.ex2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.itis.summer24.ex2.databinding.FragmentFilmsBinding
import ru.itis.summer24.ex2.databinding.FragmentProfileBinding

class FilmsFragment : Fragment(R.layout.fragment_films) {

    private var binding: FragmentFilmsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFilmsBinding.bind(view)

        binding?.apply {

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}