package india.chat.demokotlin.data

import india.chat.demokotlin.data.network.ApiHelper
import india.chat.demokotlin.data.pref.PreferencesHelper

interface DataManager:ApiHelper,PreferencesHelper {

fun logout()
}