package com.goldendevs.testapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "movie_details")
data class MovieDetailsEntity(

    @ColumnInfo(name = "artistId") val artistId: Int?,
    @ColumnInfo(name = "artistName") val artistName: String?,
    @ColumnInfo(name = "artistViewUrl") val artistViewUrl: String?,
    @ColumnInfo(name = "artworkUrl100") val artworkUrl100: String,
    @ColumnInfo(name = "artworkUrl30") val artworkUrl30: String?,
    @ColumnInfo(name = "artworkUrl60") val artworkUrl60: String?,
    @ColumnInfo(name = "artworkUrl600") val artworkUrl600: String?,
    @ColumnInfo(name = "collectionArtistId") val collectionArtistId: Int?,
    @ColumnInfo(name = "collectionArtistViewUrl") val collectionArtistViewUrl: String?,
    @ColumnInfo(name = "collectionCensoredName") val collectionCensoredName: String?,
    @ColumnInfo(name = "collectionExplicitness") val collectionExplicitness: String?,
    @ColumnInfo(name = "collectionHdPrice") val collectionHdPrice: Double?,
    @ColumnInfo(name = "collectionId") val collectionId: Int?,
    @ColumnInfo(name = "collectionName") val collectionName: String?,
    @ColumnInfo(name = "collectionPrice") val collectionPrice: Double?,
    @ColumnInfo(name = "collectionViewUrl") val collectionViewUrl: String?,
    @ColumnInfo(name = "contentAdvisoryRating") val contentAdvisoryRating: String?,
    @ColumnInfo(name = "copyright") val copyright: String?,
    @ColumnInfo(name = "country") val country: String?,
    @ColumnInfo(name = "currency") val currency: String?,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "discCount") val discCount: Int?,
    @ColumnInfo(name = "discNumber") val discNumber: Int?,
    @ColumnInfo(name = "feedUrl") val feedUrl: String?,
    @ColumnInfo(name = "hasITunesExtras") val hasITunesExtras: Boolean?,
    @ColumnInfo(name = "isStreamable") val isStreamable: Boolean?,
    @ColumnInfo(name = "kind") val kind: String?,
    @ColumnInfo(name = "longDescription") val longDescription: String?,
    @ColumnInfo(name = "previewUrl") val previewUrl: String?,
    @ColumnInfo(name = "primaryGenreName") val primaryGenreName: String?,
    @ColumnInfo(name = "releaseDate") val releaseDate: String?,
    @ColumnInfo(name = "shortDescription") val shortDescription: String?,
    @ColumnInfo(name = "trackCensoredName") val trackCensoredName: String?,
    @ColumnInfo(name = "trackCount") val trackCount: Int?,
    @ColumnInfo(name = "trackExplicitness") val trackExplicitness: String?,
    @ColumnInfo(name = "trackHdPrice") val trackHdPrice: Double?,
    @ColumnInfo(name = "trackHdRentalPrice") val trackHdRentalPrice: Double?,
    @ColumnInfo(name = "trackId") val trackId: Int?,
    @ColumnInfo(name = "trackName") val trackName: String?,
    @ColumnInfo(name = "trackNumber") val trackNumber: Int?,
    @ColumnInfo(name = "trackPrice") val trackPrice: Double?,
    @ColumnInfo(name = "trackRentalPrice") val trackRentalPrice: Double?,
    @ColumnInfo(name = "trackTimeMillis") val trackTimeMillis: Int?,
    @ColumnInfo(name = "trackViewUrl") val trackViewUrl: String?,
    @ColumnInfo(name = "wrapperType") val wrapperType: String?
):Serializable{
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}