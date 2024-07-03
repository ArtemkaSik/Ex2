package ru.itis.summer24.ex2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import ru.itis.summer24.ex2.databinding.FragmentFilmsBinding


class FilmsFragment : Fragment(R.layout.fragment_films) {

    private var binding: FragmentFilmsBinding? = null
    private var adapter: FilmsAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFilmsBinding.bind(view)

        initAdapter()
    }

    private fun initAdapter(){
        adapter = FilmsAdapter(
            list = FilmsRepository.films,
            glide = Glide.with(this),
            onClick = { filmId ->
                val bundle = Bundle().apply {
                    putInt("film_id", filmId)
                }
                findNavController().navigate(
                    R.id.action_filmsFragment_to_screenFilmFragment,
                    bundle
                )
            }

        )

        binding?.apply {
            rvFilms.adapter = adapter
            rvFilms.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}