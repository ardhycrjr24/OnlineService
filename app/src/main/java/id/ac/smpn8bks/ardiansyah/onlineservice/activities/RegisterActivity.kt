package id.ac.smpn8bks.ardiansyah.onlineservice.activities

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import id.ac.smpn8bks.ardiansyah.onlineservice.databinding.ActivityRegisterBinding
import id.ac.smpn8bks.ardiansyah.onlineservice.models.DefaultResponse
import id.ac.smpn8bks.ardiansyah.onlineservice.models.User
import id.ac.smpn8bks.ardiansyah.onlineservice.services.ServiceBuilder
import id.ac.smpn8bks.ardiansyah.onlineservice.services.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding:
            ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding =
            ActivityRegisterBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {

            val nama =
                binding.etNama.text.toString()

            val tanggalLahir =
                binding.etTanggalLahir.text.toString()

            val jenisKelamin =
                binding.spJenisKelamin.selectedItem.toString()

            val nomorHP =
                binding.etNomorHP.text.toString()

            val alamat =
                binding.etAlamat.text.toString()

            val email =
                binding.etEmail.text.toString()

            val password =
                binding.etPassword.text.toString()

            val konfirmasiPassword =
                binding.etKonfirmasiPassword.text.toString()

            // VALIDASI

            if (TextUtils.isEmpty(nama)) {

                binding.etNama.error =
                    "Nama tidak boleh kosong!"

                binding.etNama.requestFocus()

                return@setOnClickListener
            }

            if (TextUtils.isEmpty(tanggalLahir)) {

                binding.etTanggalLahir.error =
                    "Tanggal lahir tidak boleh kosong!"

                binding.etTanggalLahir.requestFocus()

                return@setOnClickListener
            }

            if (jenisKelamin == "Jenis Kelamin") {

                Toast.makeText(
                    applicationContext,
                    "Silahkan pilih jenis kelamin!",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            if (TextUtils.isEmpty(nomorHP)) {

                binding.etNomorHP.error =
                    "Nomor HP tidak boleh kosong!"

                binding.etNomorHP.requestFocus()

                return@setOnClickListener
            }

            if (TextUtils.isEmpty(alamat)) {

                binding.etAlamat.error =
                    "Alamat tidak boleh kosong!"

                binding.etAlamat.requestFocus()

                return@setOnClickListener
            }

            if (TextUtils.isEmpty(email)) {

                binding.etEmail.error =
                    "Email tidak boleh kosong!"

                binding.etEmail.requestFocus()

                return@setOnClickListener
            }

            if (TextUtils.isEmpty(password)) {

                binding.etPassword.error =
                    "Password tidak boleh kosong!"

                binding.etPassword.requestFocus()

                return@setOnClickListener
            }

            if (TextUtils.isEmpty(konfirmasiPassword)) {

                binding.etKonfirmasiPassword.error =
                    "Konfirmasi password tidak boleh kosong!"

                binding.etKonfirmasiPassword.requestFocus()

                return@setOnClickListener
            }

            if (password != konfirmasiPassword) {

                binding.etKonfirmasiPassword.error =
                    "Password tidak sama!"

                binding.etKonfirmasiPassword.requestFocus()

                return@setOnClickListener
            }

            // Karena DummyJSON tidak support register custom,
            // kita hanya simulasi register berhasil

            showLoading(true)

            binding.root.postDelayed({

                showLoading(false)

                Toast.makeText(
                    this,
                    "Registrasi berhasil!",
                    Toast.LENGTH_LONG
                ).show()

                val intent = Intent(
                    applicationContext,
                    LoginActivity::class.java
                )

                intent.flags =
                    Intent.FLAG_ACTIVITY_NEW_TASK or
                            Intent.FLAG_ACTIVITY_CLEAR_TASK

                startActivity(intent)

            }, 2000)
        }
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