package ru.itis.summer24.ex2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import ru.itis.summer24.ex2.databinding.FragmentScreenFilmBinding

class ScreenFilmFragment : Fragment(R.layout.fragment_screen_film) {

    private var binding: FragmentScreenFilmBinding? = null
    private var glide: RequestManager? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentScreenFilmBinding.bind(view)
        glide = Glide.with(this)

        val filmId = arguments?.getInt("film_id") ?: -1
        val film = FilmsRepository.films.find { it.id == filmId }

        binding?.apply{
            film?.let {
                tvTitle.text = it.name
                glide
                    ?.load(it.url)
                    ?.error(R.drawable.ic_error)
                    ?.placeholder(R.drawable.ic_loading)
                    ?.into(tvImage)
                tvRating.text = it.rating.toString()
                tvDescription.text = it.description
            }

            sendTextBtn.setOnClickListener{
                findNavController().navigate(
                    resId = R.id.action_screenFilmFragment_to_filmsFragment
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}