package com.tv.ana.elegion_week_4.Fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tv.ana.elegion_week_4.MainActivity
import com.tv.ana.elegion_week_4.R
import com.tv.ana.elegion_week_4.SearchEnginesData
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment() {

    val SE_GOOGLE_SEARCH_LINK = "http://www.google.com//search?q="
    val SE_YANDEX_SEARCH_LINK = "https://www.yandex.ru/search/?text="
    val SE_BING_SEARCH_LINK = "http://www.bing.com//search?q="

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btnSearch.setOnClickListener {

            val url: String
            when ((activity as MainActivity).getSelectedSE()) {
                SearchEnginesData.SE_YANDEX -> url = SE_YANDEX_SEARCH_LINK
                SearchEnginesData.SE_BING -> url = SE_BING_SEARCH_LINK
                else -> {
                    url = SE_GOOGLE_SEARCH_LINK
                }
            }
            val intent = Intent(Intent.ACTION_VIEW).setData(Uri.parse(url + etSearch.text.toString().replace(" ", "+")))
            startActivity(intent)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
                SearchFragment()
    }
}
