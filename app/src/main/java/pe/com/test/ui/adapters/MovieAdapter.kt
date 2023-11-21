package pe.com.test.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import pe.com.test.databinding.ItemMovieBinding
import pe.com.test.ui.adapters.diffutils.MovieDiffUtils
import pe.com.test.ui.fragments.DashboardFragmentDirections
import pe.com.test.ui.models.MovieModel
import pe.com.test.utils.setImage

class MovieAdapter
    : ListAdapter<MovieModel, MovieAdapter.MovieViewHolder>(MovieDiffUtils()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = MovieViewHolder(
        ItemMovieBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(
        holder: MovieAdapter.MovieViewHolder,
        position: Int
    ) = holder.bind(getItem(position))

    inner class MovieViewHolder(
        private val binding: ItemMovieBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: MovieModel) = with(binding) {
            posterImageView.setImage(
                "https://image.tmdb.org/t/p/w185/${model.posterPath}",
                true
            )
            itemView.setOnClickListener {
                it.findNavController()
                    .navigate(
                        DashboardFragmentDirections.goToMovieDetail(model)
                    )
            }

        }
    }
}
