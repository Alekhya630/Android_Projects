package com.singlepointsol.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var myntra: Button
    lateinit var nykaa:Button
    lateinit var amazon:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        myntra=findViewById(R.id.Myntra_button)
        nykaa=findViewById(R.id.nykaa_button)
        amazon=findViewById(R.id.amazon_button)

        myntra.setOnClickListener(this)
        nykaa.setOnClickListener(this)
        amazon.setOnClickListener(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(view: View?) {
        if (view !=null) {
            when (view.id) {
                R.id.Myntra_button -> {
                    val MyntraIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.myntra.com/?utm_source=dms_google&utm_medium=searchbrand_cpc&utm_campaign=dms_google_searchbrand_cpc_Search_Brand_Myntra_Brand_India_BM_TROAS_SOK_New&gad_source=1&gclid=CjwKCAiA3ZC6BhBaEiwAeqfvyiFdQkKnKvpp9VHnnZXlPMCqXohSavSxkBYcYPY4HVnOIvpfxaPhjxoCZV4QAvD_BwE")
                    )
                    startActivity(MyntraIntent)
                }

                R.id.nykaa_button -> {
                    val nykaaIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.nykaa.com/?utm_content=ads&utm_source=GooglePaid&utm_medium=search&utm_campaign=Search_Nykaa_NCA&hlp=hlpa&gad_source=1&gclid=CjwKCAiA3ZC6BhBaEiwAeqfvygBJOo7PUo93AHRbSUCkC2dVI-3J1uUsDh4RjjxDEyyF1Rju87xbahoCsCQQAvD_BwE")
                    )
                    startActivity(nykaaIntent)
                }

                R.id.amazon_button -> {
                    val browseIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_5szpgfto9i_e&adgrpid=155259813593&hvpone=&hvptwo=&hvadid=713930225169&hvpos=&hvnetw=g&hvrand=13061429128912821286&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9198632&hvtargid=kwd-64107830&hydadcr=14452_2402225&gad_source=1")
                    )
                    startActivity(browseIntent)
                }
            }
        }
    }
}