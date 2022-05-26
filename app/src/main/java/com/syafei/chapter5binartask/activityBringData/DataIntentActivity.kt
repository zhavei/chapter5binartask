package com.syafei.chapter5binartask.activityBringData

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.syafei.chapter5binartask.R
import com.syafei.chapter5binartask.databinding.ActivityDataIntentBinding
import com.syafei.chapter5binartask.fragment.FragmentDataIntentActivity

class DataIntentActivity : AppCompatActivity() {

    companion object {
        const val TAG = "DataIntentActivity"
    }

    private var _binding: ActivityDataIntentBinding? = null
    private lateinit var binding: ActivityDataIntentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityDataIntentBinding.inflate(layoutInflater)
        binding = requireNotNull(_binding)
        setContentView(binding.root)

        val mFragmentManager = supportFragmentManager
        val mFragmentDataIntentActivity = FragmentDataIntentActivity()
        val fragment =
            mFragmentManager.findFragmentByTag(FragmentDataIntentActivity::class.java.simpleName)

        if (fragment !is FragmentDataIntentActivity) {
            Log.i(TAG, "fragment Name: " + FragmentDataIntentActivity::class.java.simpleName)
            mFragmentManager
                .beginTransaction().add(
                    R.id.fragment_on_activity_dataintent,
                    mFragmentDataIntentActivity,
                    FragmentDataIntentActivity::class.java.simpleName
                )
                .commit()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
