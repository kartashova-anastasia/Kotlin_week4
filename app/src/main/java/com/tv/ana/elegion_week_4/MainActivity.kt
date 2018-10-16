package com.tv.ana.elegion_week_4

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.tv.ana.elegion_week_4.Fragments.MainFragment
import com.tv.ana.elegion_week_4.Fragments.SearchFragment
import com.tv.ana.elegion_week_4.Fragments.SettingsFragment

class MainActivity : AppCompatActivity() {

    private var selectedEngine: SearchEnginesData = SearchEnginesData.SE_GOOGLE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val savedSelectedSE = SharedPreferencesHelper.getStringData(this, SharedPreferencesHelper.SETTINGS_SEARCH_ENGINE_SELECTION)
        if ((savedSelectedSE != null)) {
            when (savedSelectedSE) {
                SearchEnginesData.SE_YANDEX.toString() -> selectedEngine = SearchEnginesData.SE_YANDEX
                SearchEnginesData.SE_BING.toString() -> selectedEngine = SearchEnginesData.SE_BING
                else -> selectedEngine = SearchEnginesData.SE_GOOGLE
            }
        }

        supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .addToBackStack(MainFragment::class.java.name)
                .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_activity_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.menuSettings -> {
                Toast.makeText(this, getString(R.string.Settings), Toast.LENGTH_SHORT).show()
                supportFragmentManager.beginTransaction()
                        .replace(R.id.container, SettingsFragment.newInstance())
                        .addToBackStack(SettingsFragment::class.java.name)
                        .commit()
            }
            R.id.menuSearch -> {
                Toast.makeText(this, getString(R.string.Search), Toast.LENGTH_SHORT).show()
                supportFragmentManager.beginTransaction()
                        .replace(R.id.container, SearchFragment.newInstance())
                        .addToBackStack(SearchFragment::class.java.name)
                        .commit()
            }
            R.id.menuExit -> {
                Toast.makeText(this, getString(R.string.Exit), Toast.LENGTH_SHORT).show()
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun onSelectSE(checkbox: SearchEnginesData) {
        selectedEngine = checkbox
    }

    fun getSelectedSE(): SearchEnginesData = selectedEngine
}
