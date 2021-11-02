package com.nicholas.tuchat;

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.preference.EditTextPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager


class SettingsFragment : PreferenceFragmentCompat() {
    //this class supports the fragment UI
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings, rootKey)

        //referencing the account settings from preferences
        val accountSettingsPref = findPreference<Preference>("key_account_settings")

        //implement an OnPreferenceClickListener on the method
        accountSettingsPref?.setOnPreferenceClickListener {
            //add an action and note that the preference object is only accessible within the hierachy
            val navHostFragment = activity?.supportFragmentManager?.findFragmentById(R.id.nav_host_frag) as NavHostFragment
            val navController = navHostFragment.navController
            val action = SettingsFragmentDirections.actionSettingsToAccSettings()//created from the Id of the action within our nav_graph
            //under the tag <action> in our settings fragment
            navController.navigate(action)// in here using our navController we can navigate to the action above
            true

            //TO read the values of the Preference there are two steps
            //step 1: Get reference of the sharedPreference(Xml)
//            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
//            //step 2: Get the 'value' using the key
//            val autoReplyTime = sharedPreferences.getString("key_auto_reply_time", " ")
//            Log.i("SettingsFragment", "Auto Reply: $autoReplyTime")



        }
    }
    
}
