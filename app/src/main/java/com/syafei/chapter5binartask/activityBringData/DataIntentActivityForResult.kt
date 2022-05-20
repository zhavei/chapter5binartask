package com.syafei.chapter5binartask.activityBringData

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.syafei.chapter5binartask.R

class DataIntentActivityForResult : AppCompatActivity() {

    private var binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_intent_for_result)

        getResult()
    }

    private fun getResult() {
        binding.run {
            btnDataIntentActivityResult.setOnClickListener {
                if (rgDataintentactivityresult.checkedRadioButtonId > 0) {
                    var value = 0
                    when (rgDataintentactivityresult.checkedRadioButtonId) {
                        rbDataIntentActivityResult1.id -> value = 50
                        rbDataIntentActivityResult2.id -> value = 100
                        rbDataIntentActivityResult3.id -> value = 150
                        rbDataIntentActivityResult4.id -> value = 200
                    }
                    val resulIntent = Intent()
                    resulIntent.putExtra(DataIntentActivityResult.EXTRA_SELECTED_VALUE, value)
                    setResult(DataIntentActivityResult.RESULT_CODE, resulIntent)
                    finish()
                }
            }
        }
    }
}