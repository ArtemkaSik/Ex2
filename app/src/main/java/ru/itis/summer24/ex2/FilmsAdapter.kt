package ru.itis.summer24.ex2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ru.itis.summer24.ex2.databinding.ItemFilmBinding

class FilmsAdapter(
    private val list: List<Films>,
    private val glide: RequestManager,
    private val onClick: (Int) -> Unit,
) : RecyclerView.Adapter<FilmsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsHolder {
        return FilmsHolder(
            ItemFilmBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            glide = glide,
            onClick = onClick,
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: FilmsHolder, position: Int) {
        holder.onBind(list[position])
    }
}