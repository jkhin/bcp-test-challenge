package pe.com.test.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pe.com.test.R
import pe.com.test.databinding.ActivityMainBinding
import pe.com.test.ui.fragments.DashboardFragment


// @AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setSupportActionBar(binding.toolbar)

        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment_content_main, DashboardFragment()).commit()

    }



}