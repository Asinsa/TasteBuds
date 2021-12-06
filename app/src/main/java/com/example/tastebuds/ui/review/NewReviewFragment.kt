package com.example.tastebuds.ui.review

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.navigation.Navigation
import com.example.tastebuds.R
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NewReviewFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewReviewFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_review, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Give actionbar a back button
        val actionBar = view.findViewById<Toolbar>(R.id.review_toolbar) as Toolbar
        actionBar.setNavigationIcon(R.drawable.ic_back_24)
        actionBar.setNavigationOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_navigation_new_review_to_navigation_review)
        }

        val restaurantName = view.findViewById<TextInputEditText>(R.id.restaurant_name)
        val restaurantLocation = view.findViewById<TextInputEditText>(R.id.restaurant_location)
        val reviewTitle = view.findViewById<TextInputEditText>(R.id.review_title)
        val starRating = view.findViewById<RatingBar>(R.id.ratingBar)
        val reviewBody = view.findViewById<TextInputEditText>(R.id.review_body)

        // Rating bar
        starRating.setOnRatingBarChangeListener { p0, p1, p2 -> }

        super.onViewCreated(view, savedInstanceState)


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NewReviewFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NewReviewFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}