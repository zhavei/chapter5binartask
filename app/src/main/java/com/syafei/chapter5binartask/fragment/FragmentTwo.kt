package com.syafei.chapter5binartask.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.syafei.chapter5binartask.MainActivity
import com.syafei.chapter5binartask.R
import com.syafei.chapter5binartask.databinding.FragmentTwoBinding

class FragmentTwo : Fragment(), View.OnClickListener {

    companion object {
        const val SAVE_RESULT = "save state"
    }

    //navigation arguments
    private val args: FragmentTwoArgs by navArgs()

    var output: String? = ""
    private var binding: FragmentTwoBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        /*val view = inflater.inflate(R.layout.fragment_two, container, false)
        val texView : TextView = view.findViewById(R.id.tv_fragmenttwo)
        output = arguments?.getString(MainActivity.KEY_FRAGSECOND)
        texView.text = output

        return view

        binding = FragmentTwoBinding.inflate(inflater)
        val textView = binding?.tvFragmenttwo
        output = arguments?.getString(MainActivity.KEY_FRAGSECOND)
        textView?.text = output

        val imageView = binding?.ivFragmenttwo
        val outIv = arguments?.getInt(MainActivity.KEY_IMAGE)
        outIv?.let { imageView?.setImageResource(it) }

         binding?.run {

             output = arguments?.getString(MainActivity.KEY_FRAGSECOND)
             tvFragmenttwo?.text = output

             val outIv = arguments?.getInt(MainActivity.KEY_IMAGE)
             outIv?.let { ivFragmenttwo?.setImageResource(it) }
         }

         return binding?.root*/

        // Inflate the layout for this fragment
        binding = FragmentTwoBinding.inflate(inflater, container, false)
        return binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //to save result on savedInstance when UI changed
        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(SAVE_RESULT)
            binding?.tvFragmenttwoHasil?.text = result
        }

        binding?.run {

            output = arguments?.getString(MainActivity.KEY_FRAGSECOND)
            tvFragmenttwo.text = output

            val outIv = arguments?.getInt(MainActivity.KEY_IMAGE)
            outIv?.let {
                ivFragmenttwo.setImageResource(it)
            }

            //set value on navigation argument
            val tvArgs = args.number
            tvFragmenttwoHello.text = tvArgs.toString()

            //to first fragment on clik texView
            //jika ada datanya klik ini malah jadi crash tapi klik textview hasil datanya justru malah pindah ke frgmentTwo how??
            val tvfragtwo = binding?.ivFragmenttwo
            tvfragtwo?.setOnClickListener {
                Navigation.findNavController(view).navigate(R.id.navi_fragmentTwo_to_firstFragment)
            }

            //button calculateb
            btnFragmenttwoHitung.setOnClickListener(this@FragmentTwo)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    //to save result calcultion on savedInstance when UI changed
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(SAVE_RESULT, binding?.tvFragmenttwoHasil?.text.toString())
    }

    //onclik on button calculate
    override fun onClick(view: View?) {
        if (view?.id == R.id.btn_fragmenttwo_hitung) {
            val panjang = binding?.etFragmenttwoPanjang?.text.toString().trim()
            val lebar = binding?.etFragmenttwoLebar?.text.toString().trim()
            val tinggi = binding?.etFragmenttwoTinggi?.text.toString().trim()

            binding?.run {
                var isEmptyField = false
                if (panjang.isEmpty()) {
                    isEmptyField = true
                    etFragmenttwoPanjang.error = "field cannot be empty"
                }
                if (lebar.isEmpty()) {
                    isEmptyField = true
                    etFragmenttwoLebar.error = "field cannot be empty"
                }
                if (tinggi.isEmpty()) {
                    isEmptyField = true
                    etFragmenttwoTinggi.error = "field cannot be empty"
                }
                if (!isEmptyField) {
                    val volume = panjang.toDouble() * lebar.toDouble() * tinggi.toDouble()
                    binding?.tvFragmenttwoHasil?.text = volume.toString()
                }
            }
        }
    }

}