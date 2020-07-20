package jp.numero.motion_example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import jp.numero.motion_example.container.ContainerTransitionActivity
import jp.numero.motion_example.databinding.ActivityMainBinding
import jp.numero.motion_example.fade.FadeActivity
import jp.numero.motion_example.fadethrough.FadeThroughActivity
import jp.numero.motion_example.sharedaxis.SharedAxisActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        binding.containerTransitionButton.setOnClickListener {
            startActivity(ContainerTransitionActivity.createIntent(this))
        }
        binding.sharedAxisButton.setOnClickListener {
            startActivity(SharedAxisActivity.createIntent(this))
        }
        binding.fadeThroughButton.setOnClickListener {
            startActivity(FadeThroughActivity.createIntent(this))
        }
        binding.fadeButton.setOnClickListener {
            startActivity(FadeActivity.createIntent(this))
        }
    }

    override fun onSupportNavigateUp() = checkNotNull(
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
    ).findNavController().navigateUp()
}