package id.ac.smpn8bks.ardiansyah.onlineservice.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class User(

    // ID USER

    @SerializedName("id")
    var id: Int = 0,

    // FIRST NAME

    @SerializedName("firstName")
    var firstName: String? = null,

    // LAST NAME

    @SerializedName("lastName")
    var lastName: String? = null,

    // EMAIL

    @SerializedName("email")
    var email: String? = null,

    // FOTO PROFILE

    @SerializedName("image")
    var image: String? = null,

    // PASSWORD

    @SerializedName("password")
    var password: String? = null

) : Serializable