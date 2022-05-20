package com.syafei.chapter5binartask.activityBringData

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.syafei.chapter5binartask.databinding.ActivityDataIntentResultBinding

class DataIntentActivityResult : AppCompatActivity() {
    var _binding: ActivityDataIntentResultBinding? = null
    private lateinit var binding: ActivityDataIntentResultBinding

    companion object {
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val RESULT_CODE = 110
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDataIntentResultBinding.inflate(layoutInflater)
        binding = requireNotNull(_binding)
        setContentView(binding.root)

        getResult()

    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}