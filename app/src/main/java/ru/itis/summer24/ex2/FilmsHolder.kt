package ru.itis.summer24.ex2

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import ru.itis.summer24.ex2.databinding.ItemFilmBinding

class FilmsHolder(
    private val binding: ItemFilmBinding,
    private val glide: RequestManager,
    private val onClick: (Int) -> Unit,
) : ViewHolder(binding.root) {

    fun onBind(films: Films){
        binding.apply {
            tvName.text = films.name
            tvRating.text = films.rating.toString()

            glide
                .load(films.url)
                .error(R.drawable.ic_error)
                .placeholder(R.drawable.ic_loading)
                .into(ivImage)

            root.setOnClickListener {
                onClick.invoke(films.id)
            }
        }
    }

}