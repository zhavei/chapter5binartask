package com.syafei.chapter5binartask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.syafei.chapter5binartask.adapters.RecyclerAdapter
import com.syafei.chapter5binartask.adapters.SliderAdapter
import com.syafei.chapter5binartask.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var binding: FragmentFirstBinding? = null
    private var vpSlider: ViewPager? = null //with viewBinding
    //private lateinit var vpSlider: ViewPager //no viewBinding

    //recyclerView
    // private var layoutManager : RecyclerView.LayoutManager? = null
    //private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //val view = inflater.inflate(R.layout.fragment_first, container, false)
        binding = FragmentFirstBinding.inflate(inflater, container, false)

        //vpSlider = view.findViewById(R.id.vp_first_fragment)
        vpSlider = binding?.vpFirstFragment
        val vpAdapter = SliderAdapter(childFragmentManager)

        val secondFragment = SecondFragment()
        val tridhFragment = TridhFragment()

        val fragmentList = listOf(secondFragment, tridhFragment)

        vpAdapter.addFragmentList(fragmentList)
        vpSlider?.adapter = vpAdapter
        vpSlider?.offscreenPageLimit = 3

        //return view
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerview = view.findViewById<RecyclerView>(R.id.rv_first_fragment)
        recyclerview.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = RecyclerAdapter(context)
        }
    }
}