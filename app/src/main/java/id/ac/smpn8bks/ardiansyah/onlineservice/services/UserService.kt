package id.ac.smpn8bks.ardiansyah.onlineservice.services

import id.ac.smpn8bks.ardiansyah.onlineservice.models.LoginResponse
import id.ac.smpn8bks.ardiansyah.onlineservice.models.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface UserService {

    // =========================
    // LOGIN USER
    // =========================

    @FormUrlEncoded
    @POST("auth/login")
    fun loginUser(

        @Field("username")
        username: String,

        @Field("password")
        password: String

    ): Call<LoginResponse>

    // =========================
    // UPDATE PROFILE USER
    // =========================

    @PUT("users/{id}")
    fun updateUser(

        @Path("id")
        id: Int,

        @Body
        updatedUser: User

    ): Call<User>

    // =========================
    // DELETE USER
    // =========================

    @DELETE("users/{id}")
    fun deleteUser(

        @Path("id")
        id: Int

    ): Call<User>
}