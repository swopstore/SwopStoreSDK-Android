package com.swopstore.sdk

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity


import com.swopstore.sdk.sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        SwopStoreSDK.initSdk(1095)

        SwopStoreSDK.getCurrentOrder().
        withCustomerFirstName("TEST USER NAME")

        val banner = SwopStoreSDK.getBannerWithCurrentOrder(3132)

        binding.bannerView.showBanner(banner)

    }


}