package jp.numero.motion_example.sharedaxis

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import jp.numero.motion_example.databinding.ActivitySharedAxisBinding

class SharedAxisActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySharedAxisBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharedAxisBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, SharedAxisActivity::class.java)
    }
}