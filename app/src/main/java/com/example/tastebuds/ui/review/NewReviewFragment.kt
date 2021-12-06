package com.example.tastebuds.ui.review

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.tastebuds.R
import com.example.tastebuds.ui.account.AccountViewModel
import com.example.tastebuds.ui.account.User
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

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
    private val sharedViewModel: AccountViewModel by activityViewModels()
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

        super.onViewCreated(view, savedInstanceState)

        val restaurantName = view.findViewById<TextInputEditText>(R.id.restaurant_name)
        val restaurantLocation = view.findViewById<TextInputEditText>(R.id.restaurant_location)
        val reviewTitle = view.findViewById<TextInputEditText>(R.id.review_title)
        val starRating = view.findViewById<RatingBar>(R.id.ratingBar)
        val reviewBody = view.findViewById<TextInputEditText>(R.id.review_body)

        // Rating bar
        starRating.setOnRatingBarChangeListener { p0, p1, p2 ->

        }

        //On Submit
        val submitButton = view.findViewById<MaterialButton>(R.id.submit_button)
        submitButton.setOnClickListener { view ->
            val complete = isComplete(restaurantName, restaurantLocation, reviewTitle, starRating, reviewBody)

            saveAndSubmitReview(
                complete, restaurantName.text.toString(),
                restaurantLocation.text.toString(),
                reviewTitle.text.toString(),
                starRating.rating.toDouble(),
                reviewBody.text.toString()
            )

            if (complete) {
                showMessage(view, getString(R.string.review_success))
                Navigation.findNavController(view).navigate(R.id.action_navigation_new_review_to_navigation_review)
            } else {
                showMessage(view, getString(R.string.review_fail))
                showMessage(view, getString(R.string.save_review))
                Navigation.findNavController(view).navigate(R.id.action_navigation_new_review_to_navigation_review)
            }
        }
    }

    private fun isComplete(field1: TextInputEditText, field2: TextInputEditText, field3: TextInputEditText, field4: RatingBar, field5: TextInputEditText): Boolean {
        return field1.text.toString() != "" &&
                field2.text.toString() != "" &&
                field3.text.toString() != "" &&
                field4.rating != null &&
                field5.text.toString() != ""
    }

    private fun saveAndSubmitReview(isComplete: Boolean, restaurantName: String, restaurantLocation: String, reviewTitle: String, starRating: Double, reviewBody: String) {
        val review = Review(restaurantName, restaurantLocation, reviewTitle, starRating, reviewBody)
        val user = sharedViewModel.getUser()

        if (isComplete) {
            Firebase.database.getReference("Reviews").child(user.uid).setValue(review)
        } else {
            Firebase.database.getReference("DraftReviews").child(user.uid).setValue(review)
        }
    }

    private fun showMessage (view: View, message: String) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
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