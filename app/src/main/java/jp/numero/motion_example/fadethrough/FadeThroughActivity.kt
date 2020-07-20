package jp.numero.motion_example.fadethrough

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import jp.numero.motion_example.R
import jp.numero.motion_example.databinding.ActivityFadeThroughBinding

class FadeThroughActivity : AppCompatActivity() {

    private val topLevelDestinationIds = setOf(
            R.id.home_screen,
            R.id.dashboard_screen,
            R.id.notifications_screen
    )

    private lateinit var binding: ActivityFadeThroughBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFadeThroughBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val navController = checkNotNull(
                supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
        ).findNavController()
        navController.addOnDestinationChangedListener { _, destination, _ ->
            val isTopScreen = topLevelDestinationIds.contains(destination.id)
            binding.navView.isVisible = isTopScreen
        }
        val appBarConfiguration = AppBarConfiguration(topLevelDestinationIds)
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp() = checkNotNull(
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
    ).findNavController().navigateUp()

    companion object {
        fun createIntent(context: Context) = Intent(context, FadeThroughActivity::class.java)
    }
}