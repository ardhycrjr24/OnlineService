package id.ac.smpn8bks.ardiansyah.onlineservice.activities

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import id.ac.smpn8bks.ardiansyah.onlineservice.databinding.ActivityLoginBinding
import id.ac.smpn8bks.ardiansyah.onlineservice.helpers.SessionHandler
import id.ac.smpn8bks.ardiansyah.onlineservice.models.LoginResponse
import id.ac.smpn8bks.ardiansyah.onlineservice.models.User
import id.ac.smpn8bks.ardiansyah.onlineservice.services.ServiceBuilder
import id.ac.smpn8bks.ardiansyah.onlineservice.services.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private lateinit var binding:
            ActivityLoginBinding

    private lateinit var session:
            SessionHandler

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        // Session handler
        session =
            SessionHandler(applicationContext)

        // Jika user masih login
        if (session.isLoggedIn()) {

            loadMainActivity()
        }

        binding =
            ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // Intent ke RegisterActivity
        binding.tvDaftar.setOnClickListener {

            val intent = Intent(
                applicationContext,
                RegisterActivity::class.java
            )

            startActivity(intent)
        }

        // Button Login
        binding.btnLogin.setOnClickListener {

            val username =
                binding.etEmail.text.toString()

            val password =
                binding.etPassword.text.toString()

            // Validasi username
            if (TextUtils.isEmpty(username)) {

                binding.etEmail.error =
                    "Username tidak boleh kosong!"

                binding.etEmail.requestFocus()

                return@setOnClickListener
            }

            // Validasi password
            if (TextUtils.isEmpty(password)) {

                binding.etPassword.error =
                    "Password tidak boleh kosong!"

                binding.etPassword.requestFocus()

                return@setOnClickListener
            }

            // Retrofit service
            val userService: UserService =
                ServiceBuilder.buildService(
                    UserService::class.java
                )

            // Request login
            val requestCall:
                    Call<LoginResponse> =
                userService.loginUser(
                    username,
                    password
                )

            showLoading(true)

            requestCall.enqueue(
                object : Callback<LoginResponse> {

                    override fun onFailure(
                        call: Call<LoginResponse>,
                        t: Throwable
                    ) {

                        showLoading(false)

                        Toast.makeText(
                            this@LoginActivity,
                            "Error : ${t.message}",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                    override fun onResponse(
                        call: Call<LoginResponse>,
                        response: Response<LoginResponse>
                    ) {

                        showLoading(false)

                        if (response.isSuccessful &&
                            response.body() != null
                        ) {

                            val userData =
                                response.body()

                            // Simpan ke model User
                            val user = User()

                            user.id =
                                userData!!.id

                            user.firstName =
                                userData.firstName

                            user.lastName =
                                userData.lastName

                            user.email =
                                userData.email

                            user.image =
                                userData.image

                            // Simpan session
                            session.saveUser(user)

                            Toast.makeText(
                                this@LoginActivity,
                                "Login berhasil ${user.firstName}",
                                Toast.LENGTH_LONG
                            ).show()

                            loadMainActivity()

                        } else {

                            Toast.makeText(
                                this@LoginActivity,
                                "Login gagal!",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
            )
        }
    }

    private fun loadMainActivity() {

        val intent = Intent(
            applicationContext,
            MainActivity::class.java
        )

        intent.flags =
            Intent.FLAG_ACTIVITY_NEW_TASK or
                    Intent.FLAG_ACTIVITY_CLEAR_TASK

        startActivity(intent)
    }

    private fun showLoading(
        isLoading: Boolean
    ) {

        binding.progressBar.visibility =
            if (isLoading)
                View.VISIBLE
            else
                View.GONE
    }
}