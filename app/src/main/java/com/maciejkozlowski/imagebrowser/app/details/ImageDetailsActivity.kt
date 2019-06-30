package com.maciejkozlowski.imagebrowser.app.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.maciejkozlowski.imagebrowser.R
import com.maciejkozlowski.imagebrowser.base.base.BaseActivity

/**
 * Created by Maciej Kozłowski on 2019-06-30.
 */

fun Context.startImageDetailsActivity() {
    val intent = Intent(this, ImageDetailsActivity::class.java)
    startActivity(intent)
}

class ImageDetailsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_details)
    }
}