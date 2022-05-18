package com.syafei.chapter5binartask

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.syafei.chapter5binartask.activityBringData.DataIntentActivity
import com.syafei.chapter5binartask.activityBringData.DataIntentActivityTwo
import com.syafei.chapter5binartask.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private var binding : FragmentSecondBinding? = null
    private lateinit var communicator: Communicator

    companion object{
        const val INTENT_KEY_1 = "intent_1"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*// Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(inflater)
        val btn = binding?.btSecondfrag
        val editText = binding?.etSecondfrag
        communicator = activity as Communicator
        btn?.setOnClickListener {
            communicator.editextData(editText?.text.toString(), id) //id means refer to an id

            //communicator.editextData(editText?.text.toString())
            //communicator.imageView(id)
        }*/


        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding?.root

        /*val view = inflater.inflate(R.layout.fragment_second, container, false)
        val btn : Button = view.findViewById(R.id.bt_secondfrag)
        val editText: EditText = view.findViewById(R.id.tv_fragmenttwo)*/

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inflate the layout for this fragment
        val btn = binding?.btSecondfrag
        val editText = binding?.etSecondfrag
        communicator = activity as Communicator
        btn?.setOnClickListener {
            communicator.editextData(editText?.text.toString(), id) //id means refer to an id but wich id?

           /* //communicator.editextData(editText?.text.toString())
            //communicator.imageView(id)*/
        }

        //navigate with nav controler
        val textView = binding?.tvSecondFragment
        textView?.setOnClickListener {
            val action = SecondFragmentDirections.naviSecondFragmentToFragmentTwo(56)
                //this navigate to frgmentTwo
            Navigation.findNavController(view).navigate(action)
        }

        val btnToDataIntent = binding?.btnSecondfragTodataIntent
        btnToDataIntent?.setOnClickListener {
            val intent = Intent(context, DataIntentActivity::class.java)
            startActivity(intent)
        }

        val btnToDataIntent2 = binding?.btnSecondfragTodataIntent2
        btnToDataIntent2?.setOnClickListener {
            val intent = Intent(context, DataIntentActivityTwo::class.java)
            intent.putExtra(INTENT_KEY_1 , "ini intent bawa data putString")
        }



    }

}