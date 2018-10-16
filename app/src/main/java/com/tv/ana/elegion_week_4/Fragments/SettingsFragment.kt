package com.tv.ana.elegion_week_4.Fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tv.ana.elegion_week_4.MainActivity
import com.tv.ana.elegion_week_4.R
import com.tv.ana.elegion_week_4.SearchEnginesData
import com.tv.ana.elegion_week_4.SharedPreferencesHelper
import kotlinx.android.synthetic.main.fragment_settings.*

class SettingsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onStart() {
        super.onStart()
        val savedSelectedSE = SharedPreferencesHelper.getStringData(context, SharedPreferencesHelper.SETTINGS_SEARCH_ENGINE_SELECTION)
        if ((savedSelectedSE != null)) {
            if ((savedSelectedSE == "")) {
                rgSettingsSE.check(rgSettingsSE.getChildAt(0).id)
            } else {
                when (SharedPreferencesHelper.getStringData(context, SharedPreferencesHelper.SETTINGS_SEARCH_ENGINE_SELECTION)) {
                    SearchEnginesData.SE_YANDEX.toString() -> rgSettingsSE.check(rgSettingsSE.getChildAt(1).id)
                    SearchEnginesData.SE_BING.toString() -> rgSettingsSE.check(rgSettingsSE.getChildAt(2).id)
                    else -> {
                        rgSettingsSE.check(rgSettingsSE.getChildAt(0).id)
                    }
                }
            }
        }

        rgSettingsSE.setOnCheckedChangeListener { group, checkedId ->
            when (rgSettingsSE.checkedRadioButtonId) {
                R.id.rbGoogle -> {
                    SharedPreferencesHelper.putStringData(context, SharedPreferencesHelper.SETTINGS_SEARCH_ENGINE_SELECTION
                            , SearchEnginesData.SE_GOOGLE.toString())
                    (activity as MainActivity).onSelectSE(SearchEnginesData.SE_GOOGLE)
                }
                R.id.rbYandex -> {
                    SharedPreferencesHelper.putStringData(context, SharedPreferencesHelper.SETTINGS_SEARCH_ENGINE_SELECTION
                            , SearchEnginesData.SE_YANDEX.toString())
                    (activity as MainActivity).onSelectSE(SearchEnginesData.SE_YANDEX)
                }
                R.id.rbBing -> {
                    SharedPreferencesHelper.putStringData(context, SharedPreferencesHelper.SETTINGS_SEARCH_ENGINE_SELECTION
                            , SearchEnginesData.SE_BING.toString())
                    (activity as MainActivity).onSelectSE(SearchEnginesData.SE_BING)
                }
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
                SettingsFragment()
    }
}
