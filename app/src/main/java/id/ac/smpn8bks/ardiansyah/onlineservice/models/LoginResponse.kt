package id.ac.smpn8bks.ardiansyah.onlineservice.models

import com.google.gson.annotations.SerializedName

data class LoginResponse(

    @SerializedName("id")
    val id: Int,

    @SerializedName("firstName")
    val firstName: String,

    @SerializedName("lastName")
    val lastName: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("image")
    val image: String
)