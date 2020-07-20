package jp.numero.motion_example.container

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import jp.numero.motion_example.R
import jp.numero.motion_example.databinding.ActivityContainerTransformBinding

class ContainerTransitionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContainerTransformBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContainerTransformBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val navController = checkNotNull(
                supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
        ).findNavController()

        val appBarConfiguration = AppBarConfiguration(setOf(R.id.list_screen))
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp() = checkNotNull(
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
    ).findNavController().navigateUp()

    companion object {
        fun createIntent(context: Context) = Intent(context, ContainerTransitionActivity::class.java)
    }
}