package id.ac.smpn8bks.ardiansyah.onlineservice.helpers

import android.content.Context
import android.content.SharedPreferences
import id.ac.smpn8bks.ardiansyah.onlineservice.models.User
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class SessionHandler(mContext: Context) {

    private val PREF_NAME =
        "UserSession"

    private val KEY_ID =
        "id"

    private val KEY_FIRSTNAME =
        "firstName"

    private val KEY_LASTNAME =
        "lastName"

    private val KEY_EMAIL =
        "email"

    private val KEY_IMAGE =
        "image"

    private val KEY_EXPIRES =
        "expires"

    private val KEY_EMPTY =
        ""

    private var mEditor:
            SharedPreferences.Editor? = null

    private var mPreferences:
            SharedPreferences? = null

    init {

        mPreferences =
            mContext.getSharedPreferences(
                PREF_NAME,
                Context.MODE_PRIVATE
            )

        mEditor =
            mPreferences?.edit()
    }

    // Simpan data user
    fun saveUser(user: User) {

        mEditor!!.putInt(
            KEY_ID,
            user.id
        )

        mEditor!!.putString(
            KEY_FIRSTNAME,
            user.firstName
        )

        mEditor!!.putString(
            KEY_LASTNAME,
            user.lastName
        )

        mEditor!!.putString(
            KEY_EMAIL,
            user.email
        )

        mEditor!!.putString(
            KEY_IMAGE,
            user.image
        )

        val date = Date()

        // Session berlaku 1 jam
        val millis: Long =
            date.time + 60 * 60 * 1000

        mEditor!!.putLong(
            KEY_EXPIRES,
            millis
        )

        mEditor!!.commit()
    }

    // Cek login
    fun isLoggedIn(): Boolean {

        val currentDate =
            Date()

        val millis =
            mPreferences!!.getLong(
                KEY_EXPIRES,
                0
            )

        if (millis == 0L) {

            return false
        }

        val expiryDate =
            Date(millis)

        return currentDate.before(
            expiryDate
        )
    }

    // Ambil data user
    fun getUser(): User? {

        if (!isLoggedIn()) {

            return null
        }

        val user = User()

        user.id =
            mPreferences!!.getInt(
                KEY_ID,
                0
            )

        user.firstName =
            mPreferences!!.getString(
                KEY_FIRSTNAME,
                KEY_EMPTY
            )

        user.lastName =
            mPreferences!!.getString(
                KEY_LASTNAME,
                KEY_EMPTY
            )

        user.email =
            mPreferences!!.getString(
                KEY_EMAIL,
                KEY_EMPTY
            )

        user.image =
            mPreferences!!.getString(
                KEY_IMAGE,
                KEY_EMPTY
            )

        return user
    }

    // Ambil waktu expired session
    fun getExpiredTime(): String {

        val millis =
            mPreferences!!.getLong(
                KEY_EXPIRES,
                0
            )

        val formatter =
            SimpleDateFormat(
                "dd-MM-yyyy HH:mm:ss",
                Locale.getDefault()
            )

        val date =
            Date(millis)

        return formatter.format(date)
    }

    // Logout
    fun removeUser() {

        mEditor!!.clear()

        mEditor!!.commit()
    }
}