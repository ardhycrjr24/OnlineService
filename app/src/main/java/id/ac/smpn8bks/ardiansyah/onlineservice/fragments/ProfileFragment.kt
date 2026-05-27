package id.ac.smpn8bks.ardiansyah.onlineservice.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.ac.smpn8bks.ardiansyah.onlineservice.R
import id.ac.smpn8bks.ardiansyah.onlineservice.activities.EditProfileActivity
import id.ac.smpn8bks.ardiansyah.onlineservice.activities.LoginActivity
import id.ac.smpn8bks.ardiansyah.onlineservice.databinding.FragmentProfileBinding
import id.ac.smpn8bks.ardiansyah.onlineservice.helpers.SessionHandler
import id.ac.smpn8bks.ardiansyah.onlineservice.models.User
import id.ac.smpn8bks.ardiansyah.onlineservice.services.ServiceBuilder
import id.ac.smpn8bks.ardiansyah.onlineservice.services.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileFragment : Fragment() {

    private var _binding:
            FragmentProfileBinding? = null

    private val binding
        get() =
            _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding =
            FragmentProfileBinding.inflate(
                inflater,
                container,
                false
            )

        val root: View =
            binding.root

        val session =
            SessionHandler(requireContext())

        val user: User? =
            session.getUser()

        val titikDua = ": "

        // Tampilkan data user
        if (user != null) {

            Glide.with(requireContext())
                .load(user.image)
                .apply(
                    RequestOptions()
                        .placeholder(R.drawable.user)
                        .error(R.drawable.user)
                )
                .into(binding.imgLogo)

            binding.tvNama.text =
                titikDua +
                        user.firstName +
                        " " +
                        user.lastName

            binding.tvTanggalLahir.text =
                titikDua + "12 Mei 1998"

            binding.tvJenisKelamin.text =
                titikDua + "Perempuan"

            binding.tvNomorHP.text =
                titikDua + "08123456789"

            binding.tvAlamat.text =
                titikDua + "Bengkalis - Riau"

            binding.tvEmail.text =
                titikDua + user.email

            binding.tvWaktuSesi.text =
                titikDua +
                        session.getExpiredTime()
        }

        // BUTTON EDIT PROFILE

        binding.btnEditProfil.setOnClickListener {

            val intent = Intent(
                context,
                EditProfileActivity::class.java
            )

            startActivity(intent)
        }

        // BUTTON HAPUS USER

        binding.btnHapusUser.setOnClickListener {

            val builder =
                AlertDialog.Builder(
                    requireContext()
                )

            builder.setTitle(
                "Hapus Akun"
            )

            builder.setMessage(
                "Apakah anda yakin menghapus akun?"
            )

            builder.setIcon(
                R.drawable.baseline_delete_forever_24
            )

            builder.setPositiveButton(
                "Ya"
            ) { dialog, _ ->

                val userService:
                        UserService =
                    ServiceBuilder.buildService(
                        UserService::class.java
                    )

                showLoading(true)

                val requestCall:
                        Call<User> =
                    userService.deleteUser(
                        user?.id!!
                    )

                requestCall.enqueue(
                    object : Callback<User> {

                        override fun onFailure(
                            call: Call<User>,
                            t: Throwable
                        ) {

                            showLoading(false)

                            Toast.makeText(
                                context,
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

                                session.removeUser()

                                Toast.makeText(
                                    context,
                                    "Akun berhasil dihapus",
                                    Toast.LENGTH_LONG
                                ).show()

                                val intent =
                                    Intent(
                                        context,
                                        LoginActivity::class.java
                                    )

                                intent.flags =
                                    Intent.FLAG_ACTIVITY_NEW_TASK or
                                            Intent.FLAG_ACTIVITY_CLEAR_TASK

                                startActivity(intent)

                            } else {

                                Toast.makeText(
                                    context,
                                    "Gagal menghapus akun",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }
                    }
                )

                dialog.dismiss()
            }

            builder.setNegativeButton(
                "Tidak"
            ) { dialog, _ ->

                dialog.dismiss()
            }

            val alertDialog =
                builder.create()

            alertDialog.show()
        }

        return root
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

    override fun onDestroyView() {

        super.onDestroyView()

        _binding = null
    }
}