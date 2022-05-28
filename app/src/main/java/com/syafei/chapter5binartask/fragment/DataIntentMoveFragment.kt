package com.syafei.chapter5binartask.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.syafei.chapter5binartask.R
import com.syafei.chapter5binartask.databinding.FragmentDataIntentMoveFragmentBinding

class DataIntentMoveFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentDataIntentMoveFragmentBinding? = null
    private lateinit var binding: FragmentDataIntentMoveFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDataIntentMoveFragmentBinding.inflate(inflater, container, false)
        binding = requireNotNull(_binding)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnDataIntentMoveFragment.setOnClickListener(this@DataIntentMoveFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btn_data_intent_move_fragment){

        }
    }

}