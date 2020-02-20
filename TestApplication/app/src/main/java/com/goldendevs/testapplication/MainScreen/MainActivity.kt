package com.goldendevs.testapplication.MainScreen

import android.content.Context
import android.content.Intent
import android.graphics.Movie
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.goldendevs.testapplication.MovieDetails.MovieDetailsActivity
import com.goldendevs.testapplication.R
import com.goldendevs.testapplication.common.MOVIE_DETAILS
import com.goldendevs.testapplication.model.MovieDetailsEntity
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_nav.view.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var mainActViewModel : MainActivityViewModel
    private lateinit var adapter: MovieAdapter
    private val context: Context = this
    var name : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActViewModel = ViewModelProviders.of(this)[MainActivityViewModel::class.java]

        subscribeUi()
        initView()
        setupList()
        setDate()
    }


    fun setDate(){
        val sdf = SimpleDateFormat("dd/MM/yyyy ")
        val currentDate = sdf.format(Date())
        tv_date.text = currentDate
    }


    // for livedata
    private fun subscribeUi() {
        mainActViewModel.getDbMovies()
        mainActViewModel.getMovies()

        mainActViewModel.getDataResponse().observe(this, Observer { t ->
            t.results?.let {
                for (r in it){
                    name += r.artistName + "\n"
                }

            }
        })

        mainActViewModel.getDbMovies().observe(this, Observer {
            it.let {
                adapter.updateData(it)
            }
        })


    }

    private fun setupList() {
        val layoutManager = LinearLayoutManager(this)
        rv_moview_list.layoutManager = layoutManager

        rv_moview_list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL ,false)
        adapter = MovieAdapter(mutableListOf(), context)


        // add AddOnScrollListener
        rv_moview_list.adapter = adapter

        val selectMovie = adapter.getSelectedRoute()
        selectMovie?.let {movie ->
             mainActViewModel.getDbMovieById(movie.id!!.toInt()).observe(this, Observer {
                 it.let{movieDetailsEntity ->

                 }
             })
        }


    }

    // for toolbar
    fun initView(){
        toolbar.navigation_menu.setOnClickListener{
            drawer_layout.openDrawer()
        }
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        drawer_layout.closeDrawer(Gravity.START)
        return false
    }
}
