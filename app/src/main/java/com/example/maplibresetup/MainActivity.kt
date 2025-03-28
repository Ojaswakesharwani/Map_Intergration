package com.example.maplibresetup

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import org.maplibre.android.MapLibre
import org.maplibre.android.camera.CameraPosition
import org.maplibre.android.geometry.LatLng
import org.maplibre.android.maps.MapView

class MainActivity : AppCompatActivity() {

    private lateinit var mapView: MapView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MapLibre.getInstance(this)

        val inflater = LayoutInflater.from(this)
        val rootView = inflater.inflate(R.layout.activity_main, null)
        setContentView(rootView)

        mapView = rootView.findViewById(R.id.mapView)

        setupMap("https://demotiles.maplibre.org/style.json")
        findViewById<Button>(R.id.btn_street).setOnClickListener {
            setupMap("https://api.maptiler.com/maps/streets-v2/style.json?key=gXws6DRBGz2gvXFIxuFH")
        }

        findViewById<Button>(R.id.btn_demo).setOnClickListener {
            setupMap("https://demotiles.maplibre.org/style.json")

        }

        findViewById<Button>(R.id.btn_aquarelle).setOnClickListener {
            setupMap("https://api.maptiler.com/maps/aquarelle/style.json?key=gXws6DRBGz2gvXFIxuFH")

        }

        findViewById<Button>(R.id.btn_satellite).setOnClickListener {
            setupMap("https://api.maptiler.com/maps/satellite/style.json?key=gXws6DRBGz2gvXFIxuFH")

        }

        findViewById<Button>(R.id.btn_street_map).setOnClickListener {
            setupMap("https://api.maptiler.com/maps/openstreetmap/style.json?key=gXws6DRBGz2gvXFIxuFH")

        }
    }

       private fun setupMap(style : String){
           mapView.getMapAsync { map ->
               map.setStyle(style)
               map.cameraPosition = CameraPosition.Builder().target(LatLng(0.0, 0.0)).zoom(1.0).build()
           }
       }

        override fun onStart() {
            super.onStart()
            mapView.onStart()
        }

        override fun onResume() {
            super.onResume()
            mapView.onResume()
        }

        override fun onPause() {
            super.onPause()
            mapView.onPause()
        }

        override fun onStop() {
            super.onStop()
            mapView.onStop()
        }

        override fun onLowMemory() {
            super.onLowMemory()
            mapView.onLowMemory()
        }

        override fun onDestroy() {
            super.onDestroy()
            mapView.onDestroy()
        }

        override fun onSaveInstanceState(outState: Bundle) {
            super.onSaveInstanceState(outState)
            mapView.onSaveInstanceState(outState)
        }


}