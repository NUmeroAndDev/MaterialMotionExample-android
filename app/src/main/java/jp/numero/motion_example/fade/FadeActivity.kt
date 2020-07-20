package jp.numero.motion_example.fade

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.transition.TransitionManager
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.transition.MaterialFade
import jp.numero.motion_example.R
import jp.numero.motion_example.databinding.ActivityFadeBinding

class FadeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFadeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFadeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        setupViews()
    }

    private fun setupViews() {
        binding.visibilityCardToggleGroup.addOnButtonCheckedListener { _, checkedId, isChecked ->
            if (!isChecked) return@addOnButtonCheckedListener
            when (checkedId) {
                R.id.show_button -> showFab()
                R.id.hide_button -> hideFab()
            }
        }
        binding.fab.setOnClickListener {
            Snackbar.make(binding.container, "Clicked FAB", Snackbar.LENGTH_SHORT)
                    .setAnchorView(R.id.fab)
                    .show()
        }
    }

    private fun showFab() {
        val materialFade = MaterialFade().apply {
            duration = 150L
        }
        TransitionManager.beginDelayedTransition(binding.container, materialFade)
        binding.fab.isVisible = true
    }

    private fun hideFab() {
        val materialFade = MaterialFade().apply {
            duration = 75L
        }
        TransitionManager.beginDelayedTransition(binding.container, materialFade)
        binding.fab.isVisible = false
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, FadeActivity::class.java)
    }
}