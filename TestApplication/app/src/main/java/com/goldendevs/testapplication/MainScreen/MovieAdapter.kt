package com.goldendevs.testapplication.MainScreen

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.goldendevs.testapplication.MovieDetails.MovieDetailsActivity
import com.goldendevs.testapplication.R
import com.goldendevs.testapplication.common.MOVIE_DETAILS
import com.goldendevs.testapplication.model.MovieDetailsEntity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_details.*
import kotlinx.android.synthetic.main.listview_item.view.*


class MovieAdapter(private val routes: MutableList<MovieDetailsEntity>, context: Context) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private var selectRouteCallback: OnSelectRouteCallback? = null
    private var selectedPosition = -1
    private var context: Context = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.listview_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = routes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(routes[position])
    }

    fun updateData(newDataSet: List<MovieDetailsEntity>) {
        routes.clear()
        routes.addAll(newDataSet)
        notifyDataSetChanged()
    }

    fun addData(newDataSet: List<MovieDetailsEntity>){
        routes.addAll(newDataSet)
        notifyDataSetChanged()
    }

    fun setSelectRouteCallback(callback: OnSelectRouteCallback) {
        selectRouteCallback = callback
    }

    fun getSelectedRoute(): MovieDetailsEntity? {
        if (selectedPosition < 0) return null
        return routes[selectedPosition]
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val rootContainer: LinearLayout = itemView.rootContainer
        private val trackName: TextView = itemView.tvTrackName
        private val itemId: TextView = itemView.tv_id
        private val logo: ImageView = itemView.img_logo
        private val genre: TextView = itemView.tv_genre

        fun bind(movieDetailsEntity: MovieDetailsEntity) {

            trackName.text = movieDetailsEntity.trackName
            itemId.text = movieDetailsEntity.collectionHdPrice.toString()
            Picasso.get().load(movieDetailsEntity?.artworkUrl100).into(logo)
            genre.text = movieDetailsEntity.primaryGenreName

            // If the item is selected update its image source
            if (selectedPosition == adapterPosition) {
                rootContainer.setBackgroundResource(R.drawable.cardview_selected_bg)

                var intent = Intent(context, MovieDetailsActivity::class.java)
                intent.putExtra(MOVIE_DETAILS, movieDetailsEntity)
                context.startActivity(intent)

            }
            else{
                rootContainer.setBackgroundResource(R.drawable.cardview_bg)
            }

            rootContainer.setOnClickListener {
                selectedPosition = adapterPosition
                notifyDataSetChanged()

                selectRouteCallback?.onSelect(movieDetailsEntity)
            }
        }

        }

    }

    interface OnSelectRouteCallback {
        fun onSelect(route: MovieDetailsEntity)
    }
