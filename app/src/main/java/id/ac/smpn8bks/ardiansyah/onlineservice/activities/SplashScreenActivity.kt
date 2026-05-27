package id.ac.smpn8bks.ardiansyah.onlineservice.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import id.ac.smpn8bks.ardiansyah.onlineservice.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding:
            ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding =
            ActivitySplashScreenBinding.inflate(layoutInflater)

        setContentView(binding.root)

        Handler(mainLooper).postDelayed({

            startActivity(
                Intent(
                    this@SplashScreenActivity,
                    LoginActivity::class.java
                )
            )

            finish()

        }, 3000)
    }
}