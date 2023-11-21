package pe.com.test.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel
import pe.com.test.databinding.FragmentDashboardBinding
import pe.com.test.ui.view_models.MovieViewModel
import pe.com.test.ui.adapters.MovieAdapter
import pe.com.test.utils.setup

class DashboardFragment : Fragment() {

    private lateinit var binding: FragmentDashboardBinding

    private val viewModel: MovieViewModel by viewModel()

    private val upcomingMoviesAdapter by lazy { MovieAdapter() }
    private val popularMoviesAdapter by lazy { MovieAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.moviePopularRecyclerView.setup(popularMoviesAdapter)
        binding.movieUpcomingRecyclerView.setup(upcomingMoviesAdapter)

        viewModel.popularMovies.observe(viewLifecycleOwner) {
            popularMoviesAdapter.submitList(it)
        }

        viewModel.upcomingMovies.observe(viewLifecycleOwner) {
            upcomingMoviesAdapter.submitList(it)
        }

        viewModel.error.observe(viewLifecycleOwner) { error ->
            Snackbar.make(binding.baseView, error, Snackbar.LENGTH_LONG).show()
        }

        viewModel.fetchData()
    }
}