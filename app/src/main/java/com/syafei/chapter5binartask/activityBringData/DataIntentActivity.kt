package com.syafei.chapter5binartask.activityBringData

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.syafei.chapter5binartask.databinding.ActivityDataIntentBinding

class DataIntentActivity : AppCompatActivity() {

    private var _binding: ActivityDataIntentBinding? = null
    private lateinit var binding: ActivityDataIntentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityDataIntentBinding.inflate(layoutInflater)
        binding = requireNotNull(_binding)
        setContentView(binding.root)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
