package pe.com.test.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import pe.com.test.databinding.FragmentDetailBinding
import pe.com.test.utils.setImage

class MovieDetailFragment : Fragment() {

    private lateinit var binding : FragmentDetailBinding
    private val args by navArgs<MovieDetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() = with(binding) {
        args.movie.let {
            textViewName.text = it.title
            textViewDescription.text = it.overview
            imageViewBackground.setImage("https://image.tmdb.org/t/p/w185/${it.backdropPath}")
            imageViewPoster.setImage("https://image.tmdb.org/t/p/w185/${it.posterPath}")
        }
    }

}