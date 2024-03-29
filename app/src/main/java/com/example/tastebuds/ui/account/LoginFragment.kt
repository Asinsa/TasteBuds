package com.example.tastebuds.ui.account

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.tastebuds.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AccountFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private val sharedViewModel: AccountViewModel by activityViewModels()
    private var param1: String? = null
    private var param2: String? = null
    private var mAuth = FirebaseAuth.getInstance()
    //private val activity = MainActivity().getMain()
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
            return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val emailText = view.findViewById<TextInputEditText>(R.id.email_field)
        val passwordText = view.findViewById<TextInputEditText>(R.id.password_field)

        // Login
        val loginButton = view.findViewById<MaterialButton>(R.id.login_button)
        loginButton.setOnClickListener { view ->
            if (emailText.text.toString() != "" && passwordText.text.toString() != "") {
                activity?.let {
                    mAuth.signInWithEmailAndPassword(
                        emailText.text.toString(),
                        passwordText.text.toString()
                    ).addOnCompleteListener(it) { task ->
                        if (task.isSuccessful) {
                            val user = mAuth.currentUser
                            sharedViewModel.setUser(user!!)
                            sharedViewModel.setEmail(user?.email.toString())
                            sharedViewModel.logIn()
                            Navigation.findNavController(view)
                                .navigate(R.id.action_navigation_login_to_navigation_account)
                        } else {
                            closeKeyBoard()
                            showMessage(view, getString(R.string.login_failed))
                        }
                    }
                }
            } else if (emailText.text.toString() == "") {
                emailText.error = getString(R.string.empty_email)
                emailText.requestFocus()
            } else {
                passwordText.error = getString(R.string.empty_password)
                passwordText.requestFocus()
            }
        }

        // Sign up
        val registerButton = view.findViewById<MaterialButton>(R.id.sign_up_page_button)
        registerButton.setOnClickListener { view ->
            navController = Navigation.findNavController(view)
            navController?.navigate(R.id.action_navigation_login_to_navigation_register)
        }
    }

    private fun showMessage (view: View, message: String) {
        Snackbar.make (view, message, Snackbar.LENGTH_LONG).show()
    }

    private fun closeKeyBoard() {
        val view = activity?.currentFocus
        if (view != null) {
            val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
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
         * @return A new instance of fragment AccountFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AccountFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}