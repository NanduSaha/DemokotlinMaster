package india.chat.demokotlin.data.pref

interface PreferencesHelper {


    fun getCurrentUserId(): String

    fun setCurrentUserId(userId: String)

    fun getCurrentFirstName(): String

    fun setCurrentFirstName(firstName: String)

    fun getCurrentLastName(): String

    fun setCurrentLastName(lastName: String)

    fun getCurrentMobileNumber(): String

    fun setCurrentMobileNumber(lastName: String)

    fun getCurrentUserEmail(): String

    fun setCurrentUserEmail(email: String)

    fun getCurrentUserProfilePicUrl(): String

    fun setCurrentUserProfilePicUrl(profilePicUrl: String)

    fun getCurrentUserGender(): String

    fun setCurrentUserGender(gender: String)

    fun getLastIntaractionTimestamp(): Long

    fun setLastIntaractionTimestamp(timeStamp: Long)

    fun destroyPref()

    fun setRegistrationType(registrationType: String)

    fun getRegistrationType(): String
}