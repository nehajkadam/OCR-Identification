package `in`.neha.rqcodescanerapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.zxing.integration.android.IntentIntegrator

class MainActivity : AppCompatActivity() {

    lateinit var mBtn_camera : Button
    lateinit var mBtn_gallery : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mBtn_camera = findViewById<Button>(R.id.button1)
        mBtn_gallery = findViewById<Button>(R.id.button2)

        mBtn_camera.setOnClickListener(BtnCameraOnclick())
        mBtn_gallery.setOnClickListener(BtnGalleryOnclick())



    }

    inner private class BtnCameraOnclick : View.OnClickListener{
        override fun onClick(v: View?) {

            val scanner = IntentIntegrator(this@MainActivity)
            scanner.initiateScan()



        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (resultCode == Activity.RESULT_OK) {

            val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
            if (result != null) {
                if (result.contents == null) {
                    Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Scanned: " + result.contents, Toast.LENGTH_LONG).show()
                }
            } else {
                super.onActivityResult(requestCode, resultCode, data)
            }
        }
    }

    inner private class BtnGalleryOnclick: View.OnClickListener{
        override fun onClick(v: View?) {



        }
    }


    }
