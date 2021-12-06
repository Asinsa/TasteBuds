package com.example.tastebuds.ui.home

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tastebuds.R
import com.example.tastebuds.ui.MainActivity
import kotlin.random.Random

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val activity = MainActivity().getMain()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // List of restaurants
        val restaurantArrayList = populateList()

        val recyclerView = view.findViewById<View>(R.id.trending_recycler_view) as RecyclerView // Bind to the recyclerview in the layout

        val layoutManager = LinearLayoutManager(activity) // Get the layout manager
        recyclerView.layoutManager = layoutManager
        val mAdapter = RestaurantAdapter(restaurantArrayList)
        recyclerView.adapter = mAdapter

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    /*
 * A function to add names of F1 teams and logos to a list of MyModel
 */
    private fun populateList(): ArrayList<Restaurant> {
        val list = ArrayList<Restaurant>()
        val myImageList = arrayOf(R.drawable.turtle_bay, R.drawable.tacobell, R.drawable.banana_leaf, R.drawable.fave_chicken, R.drawable.dominos, R.drawable.brewdog, R.drawable.monnis, R.drawable.kaspas, R.drawable.five_guys, R.drawable.nandos, R.drawable.tgi_fridays)
        val myImageNameList = arrayOf(R.string.turtle_bay, R.string.tacobell, R.string.banana_leaf, R.string.fave_chicken, R.string.dominos, R.string.brewdog, R.string.monnis, R.string.kaspas, R.string.five_guys, R.string.nandos, R.string.tgi_fridays)
        val ratingList = doubleArrayOf(5.0,4.8,4.6,4.4,4.2,4.0,3.8,3.6,3.4,2.0,1.0)

        for (i in 0..10) {
            val restaurant = Restaurant()
            restaurant.setNames(getString(myImageNameList[i]))
            restaurant.setImages(myImageList[i])
            val randomValue = Random.nextInt(0, 5)
            restaurant.setRestaurantDistance(randomValue)
            restaurant.setRestaurantRating(ratingList[i])
            list.add(restaurant)
        }
        return list
    }
}