package com.syafei.chapter5binartask.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.syafei.chapter5binartask.databinding.FragmentDataIntentActivityBinding

class FragmentDataIntentActivity : Fragment(), View.OnClickListener {

     var _binding: FragmentDataIntentActivityBinding? = null
     lateinit var binding: FragmentDataIntentActivityBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDataIntentActivityBinding.inflate(inflater, container, false)
        binding = requireNotNull(_binding)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnFragmentDataIntentActivity.setOnClickListener(this@FragmentDataIntentActivity)



    }

    override fun onClick(view: View?) {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}