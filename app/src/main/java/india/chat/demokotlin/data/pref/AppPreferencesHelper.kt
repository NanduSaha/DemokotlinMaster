package india.chat.demokotlin.data.pref

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import india.chat.demokotlin.di.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AppPreferencesHelper:PreferencesHelper {


    private var mPrefs: SharedPreferences

    @Inject
    constructor(@ApplicationContext context: Context){
        mPrefs = PreferenceManager.getDefaultSharedPreferences(context)
    }


    override fun getCurrentUserId(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setCurrentUserId(userId: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCurrentFirstName(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setCurrentFirstName(firstName: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCurrentLastName(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setCurrentLastName(lastName: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCurrentMobileNumber(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setCurrentMobileNumber(lastName: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCurrentUserEmail(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setCurrentUserEmail(email: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCurrentUserProfilePicUrl(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setCurrentUserProfilePicUrl(profilePicUrl: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCurrentUserGender(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setCurrentUserGender(gender: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLastIntaractionTimestamp(): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setLastIntaractionTimestamp(timeStamp: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setRegistrationType(registrationType: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRegistrationType(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun destroyPref() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}