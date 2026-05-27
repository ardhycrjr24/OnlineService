package id.ac.smpn8bks.ardiansyah.onlineservice.activities

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import id.ac.smpn8bks.ardiansyah.onlineservice.databinding.ActivityEditProfileBinding
import id.ac.smpn8bks.ardiansyah.onlineservice.helpers.SessionHandler
import id.ac.smpn8bks.ardiansyah.onlineservice.models.User
import id.ac.smpn8bks.ardiansyah.onlineservice.services.ServiceBuilder
import id.ac.smpn8bks.ardiansyah.onlineservice.services.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditProfileActivity : AppCompatActivity() {

    private lateinit var binding:
            ActivityEditProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding =
            ActivityEditProfileBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val session =
            SessionHandler(applicationContext)

        val user =
            session.getUser()

        // Tampilkan data user
        if (user != null) {

            binding.etNama.setText(
                "${user.firstName} ${user.lastName}"
            )

            binding.etEmail.setText(
                user.email
            )
        }

        binding.btnSubmit.setOnClickListener {

            val nama =
                binding.etNama.text.toString()

            val email =
                binding.etEmail.text.toString()

            val password =
                binding.etPassword.text.toString()

            val konfirmasiPassword =
                binding.etKonfirmasiPassword.text.toString()

            // Validasi
            if (TextUtils.isEmpty(nama)) {

                binding.etNama.error =
                    "Nama tidak boleh kosong!"

                return@setOnClickListener
            }

            if (TextUtils.isEmpty(email)) {

                binding.etEmail.error =
                    "Email tidak boleh kosong!"

                return@setOnClickListener
            }

            if (password.isNotEmpty()) {

                if (password != konfirmasiPassword) {

                    binding.etKonfirmasiPassword.error =
                        "Password tidak sama!"

                    return@setOnClickListener
                }
            }

            val updatedUser = User()

            updatedUser.id =
                user!!.id

            updatedUser.firstName =
                nama

            updatedUser.email =
                email

            if (password.isNotEmpty()) {

                updatedUser.password =
                    password
            }

            val userService =
                ServiceBuilder.buildService(
                    UserService::class.java
                )

            showLoading(true)

            val requestCall =
                userService.updateUser(
                    user.id,
                    updatedUser
                )

            requestCall.enqueue(
                object : Callback<User> {

                    override fun onFailure(
                        call: Call<User>,
                        t: Throwable
                    ) {

                        showLoading(false)

                        Toast.makeText(
                            this@EditProfileActivity,
                            "Error : ${t.message}",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                    override fun onResponse(
                        call: Call<User>,
                        response: Response<User>
                    ) {

                        showLoading(false)

                        if (response.isSuccessful) {

                            session.saveUser(
                                updatedUser
                            )

                            Toast.makeText(
                                this@EditProfileActivity,
                                "Profile berhasil diubah!",
                                Toast.LENGTH_LONG
                            ).show()

                            finish()

                        } else {

                            Toast.makeText(
                                this@EditProfileActivity,
                                "Gagal update profile!",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
            )
        }
    }

    override fun onSupportNavigateUp():
            Boolean {

        finish()

        return true
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