package com.example.tastebuds.ui.account

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.tastebuds.R
import com.example.tastebuds.ui.MainActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private val sharedViewModel: AccountViewModel by activityViewModels()
    private var param1: String? = null
    private var param2: String? = null
    private var mAuth = FirebaseAuth.getInstance()
    private val activity = MainActivity().getMain()
    var navController: NavController? = null

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
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (!sharedViewModel.loggedIn()!!) {
            super.onViewCreated(view, savedInstanceState)

            val displayNameText = view.findViewById<TextInputEditText>(R.id.displayName_field)
            val firstNameText = view.findViewById<TextInputEditText>(R.id.firstName_field)
            val lastNameText = view.findViewById<TextInputEditText>(R.id.lastName_field)
            val emailText = view.findViewById<TextInputEditText>(R.id.email_field)
            val passwordText = view.findViewById<TextInputEditText>(R.id.password_field)
            val confirmPasswordText = view.findViewById<TextInputEditText>(R.id.confirm_password_field)

            // Register
            val registerButton = view.findViewById<MaterialButton>(R.id.register_button)
            registerButton.setOnClickListener { view ->
                if (isComplete(displayNameText, firstNameText, lastNameText, emailText, passwordText, confirmPasswordText)) {
                    if (passwordText.text.toString() == confirmPasswordText.text.toString() && passwordText.text.toString().length >= 8) {
                        mAuth.createUserWithEmailAndPassword(
                            emailText.text.toString(),
                            passwordText.text.toString()
                        ).addOnCompleteListener(activity) { task ->
                            if (task.isSuccessful) {
                                registerUser(emailText.toString(), emailText.toString(), emailText.toString(), emailText.toString())
                                showMessage(view, getString(R.string.register_success))
                                Navigation.findNavController(view).navigate(R.id.action_navigation_register_to_navigation_account)
                            } else {
                                closeKeyBoard()
                                showMessage(view, getString(R.string.register_failed))
                            }
                        }
                    } else if (passwordText.text.toString().length >= 8) {
                        passwordText.error = getString(R.string.password_too_short)
                        passwordText.requestFocus()
                    } else {
                        confirmPasswordText.error = getString(R.string.password_no_match)
                        confirmPasswordText.requestFocus()
                    }
                } else if (emailText.text.toString() == "") {
                    emailText.error = getString(R.string.empty_email)
                    emailText.requestFocus()
                } else if (passwordText.text.toString() == "" || confirmPasswordText.text.toString() == "") {
                    passwordText.error = getString(R.string.empty_password)
                    passwordText.requestFocus()
                    confirmPasswordText.requestFocus()
                } else {
                    //TODO
                }
            }

            // Login
            val loginButton = view.findViewById<MaterialButton>(R.id.login_page_button)
            loginButton.setOnClickListener { view ->
                navController = Navigation.findNavController(view)
                navController?.navigate(R.id.action_navigation_register_to_navigation_login)
            }
        }
    }

    private fun isComplete(field1: TextInputEditText, field2: TextInputEditText, field3: TextInputEditText, field4: TextInputEditText, field5: TextInputEditText, field6: TextInputEditText): Boolean {
        return field1.text.toString() != "" &&
                field2.text.toString() != "" &&
                field3.text.toString() != "" &&
                field4.text.toString() != "" &&
                field5.text.toString() != "" &&
                field6.text.toString() != ""
    }

    private fun registerUser(email: String, displayName: String, firstName: String, lastName: String) {
        val newUser = User(email, displayName, firstName, lastName)

        val user = mAuth.currentUser
        sharedViewModel.setEmail(user?.email.toString())
        sharedViewModel.logIn()

        Firebase.database.getReference("Users").child(user!!.uid).setValue(newUser)
    }

    private fun showMessage (view: View, message: String) {
        Snackbar.make (view, message, Snackbar.LENGTH_LONG).show()
    }

    private fun closeKeyBoard() {
        val view = activity.currentFocus
        if (view != null) {
            val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegisterFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegisterFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
