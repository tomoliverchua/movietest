package com.goldendevs.testapplication.MovieDetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat.EXTRA_PEOPLE
import com.goldendevs.testapplication.R
import com.goldendevs.testapplication.common.MOVIE_DETAILS
import com.goldendevs.testapplication.model.MovieDetailsEntity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetailsActivity : AppCompatActivity() {

    var movieDetailEntity : MovieDetailsEntity? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

            // get data from mainActivity
        movieDetailEntity = intent.getSerializableExtra(MOVIE_DETAILS) as? MovieDetailsEntity



        initUi()
    }

    // init data from intent extras
    fun initUi(){
        tv_type.text = movieDetailEntity?.primaryGenreName
        tv_advisory.text = movieDetailEntity?.contentAdvisoryRating


        // details
        data1.text = movieDetailEntity?.artistName
        data2.text = movieDetailEntity?.collectionName
        data3.text = movieDetailEntity?.collectionCensoredName
        data4.text = movieDetailEntity?.trackName
        data5.text = movieDetailEntity?.trackCensoredName
        data6.text = movieDetailEntity?.collectionPrice.toString()
        data7.text = movieDetailEntity?.trackPrice.toString()
        data8.text = movieDetailEntity?.releaseDate.toString()
        data9.text = movieDetailEntity?.collectionExplicitness
        data10.text = movieDetailEntity?.country
        data11.text = movieDetailEntity?.currency

        //title
        tv_movie_title.text = movieDetailEntity?.artistName

        // Picasso
        Picasso.get().load(movieDetailEntity?.artworkUrl100).into(img_artWorkUrl100)
        Picasso.get().load(movieDetailEntity?.artworkUrl100).into(img_artWorkUrl60)
        Picasso.get().load(movieDetailEntity?.artworkUrl100).into(img_artWorkUrl30)

        //Description
        tv_description_long.text = movieDetailEntity?.shortDescription
        tv_description_short.text = movieDetailEntity?.longDescription


        // urls
        tv_url1.text = movieDetailEntity?.trackViewUrl
        tv_url2.text = movieDetailEntity?.previewUrl

    }
}

