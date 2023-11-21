package pe.com.test.ui.adapters.diffutils

import androidx.recyclerview.widget.DiffUtil
import pe.com.test.ui.models.MovieModel

class MovieDiffUtils : DiffUtil.ItemCallback<MovieModel>() {
    override fun areItemsTheSame(
        oldItem: MovieModel,
        newItem: MovieModel
    ): Boolean = oldItem === newItem

    override fun areContentsTheSame(
        oldItem: MovieModel,
        newItem: MovieModel
    ): Boolean = oldItem.id == newItem.id
}