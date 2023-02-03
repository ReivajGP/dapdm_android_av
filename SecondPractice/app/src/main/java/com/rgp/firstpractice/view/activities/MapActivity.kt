package com.rgp.firstpractice.view.activities

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.rgp.firstpractice.R
import com.rgp.firstpractice.databinding.ActivityMapBinding
import com.rgp.firstpractice.utils.Constants

class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var binding: ActivityMapBinding
    private lateinit var map: GoogleMap
    private lateinit var artistName: String
    private var artistOriginLatitude: Double = Constants.DEFAULT_DOUBLE_VALUE
    private var artistOriginLongitude: Double = Constants.DEFAULT_DOUBLE_VALUE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        artistName = intent.getStringExtra(Constants.INTENT_ARTIST_ID).toString()
        artistOriginLatitude = intent.getDoubleExtra(Constants.INTENT_ARTIST_ORIGIN_LATITUDE, Constants.DEFAULT_DOUBLE_VALUE)
        artistOriginLongitude = intent.getDoubleExtra(Constants.INTENT_ARTIST_ORIGIN_LONGITUDE, Constants.DEFAULT_DOUBLE_VALUE)

        val mapFragment: SupportMapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap) {
        this.map = map

        val coordinates = LatLng(artistOriginLatitude.toDouble(), artistOriginLongitude.toDouble())

        val marker = MarkerOptions()
            .position(coordinates)
            .title(artistName)
            .snippet(Constants.LOCATION_SNIPPET)
            .icon(BitmapDescriptorFactory.fromBitmap(generateSmallIcon()))


        map.addMarker(marker)

        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, Constants.MAP_STARTING_ANIMATION_ZOOM),
            Constants.MAP_STARTING_ANIMATION_MILLISECONDS,
            null
        )
    }

    private fun generateSmallIcon(): Bitmap {
        val height = Constants.RESIZED_ICON_HEIGHT
        val width = Constants.RESIZED_ICON_WIDTH
        val bitmap = BitmapFactory.decodeResource(this.resources, R.drawable.musicpin)
        return Bitmap.createScaledBitmap(bitmap, width, height, false)
    }
}