package com.example.myanimelist.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.animelist.view.viewModels.MainViewModel
import com.example.myanimelist.data.entities.AnimeEntity
import com.example.myanimelist.data.entities.Genre
import com.example.myanimelist.databinding.ActivityMainBinding
import com.example.myanimelist.view.utils.SpacingDecoration
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    private lateinit var binding: ActivityMainBinding
    private val animeListAdapter = AnimeListAdapter()

    private val genresList = listOf(
        Genre.SHOUNEN, Genre.DRAMA, Genre.ISSEKAI, Genre.MECHA, Genre.SEINEN
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.initData()
        initViews()
        initObservers()
        initListeners()
    }

    private fun initListeners() {
        binding.fabAdd.setOnClickListener {
            viewModel.insertEntity(generateAnimeEntity())
        }
    }

    private fun initViews() {
        binding.rvAnimeList.apply {
            adapter = animeListAdapter
            addItemDecoration(SpacingDecoration(OFFSET))
        }
    }

    private fun initObservers() {
        viewModel.animeLisLiveData.observe(this) {
            animeListAdapter.submitList(it)
        }
    }

    private fun generateAnimeEntity(): AnimeEntity {
        return AnimeEntity(
            name = "Anime name ${Random.nextInt()}",
            creationTime = System.currentTimeMillis(),
            review = "Review number ${Random.nextInt()}",
            genre = genresList.random().toString(),
            year = Random.nextInt(1950, 2023),
            userRating = Random.nextInt(1, 10),
            seriesCount = Random.nextInt(4, 800)
        )
    }

    companion object {
        private const val OFFSET = 15
    }

}