package com.syafei.chapter5binartask.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.syafei.chapter5binartask.MainActivity
import com.syafei.chapter5binartask.databinding.FragmentTwoBinding


class FragmentTwo : Fragment() {

    var output: String? = ""
    private var binding: FragmentTwoBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        /*val view = inflater.inflate(R.layout.fragment_two, container, false)
        val texView : TextView = view.findViewById(R.id.tv_fragmenttwo)
        output = arguments?.getString(MainActivity.KEY_FRAGSECOND)
        texView.text = output

        return view*/

        /*binding = FragmentTwoBinding.inflate(inflater)
        val textView = binding?.tvFragmenttwo
        output = arguments?.getString(MainActivity.KEY_FRAGSECOND)
        textView?.text = output

        val imageView = binding?.ivFragmenttwo
        val outIv = arguments?.getInt(MainActivity.KEY_IMAGE)
        outIv?.let { imageView?.setImageResource(it) }*/

        /* binding?.run {

             output = arguments?.getString(MainActivity.KEY_FRAGSECOND)
             tvFragmenttwo?.text = output

             val outIv = arguments?.getInt(MainActivity.KEY_IMAGE)
             outIv?.let { ivFragmenttwo?.setImageResource(it) }
         }

         return binding?.root*/

        binding = FragmentTwoBinding.inflate(inflater, container, false)
        return binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.run {

            output = arguments?.getString(MainActivity.KEY_FRAGSECOND)
            tvFragmenttwo.text = output

            val outIv = arguments?.getInt(MainActivity.KEY_IMAGE)
            outIv?.let { ivFragmenttwo.setImageResource(it) }
        }
    }

}