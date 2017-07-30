package com.example.peter.prefectures_kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.Toast

import java.util.ArrayList

/**
 * ラジオボタンで選択し、選択したアイテムを表示するクラス

 * @author :ryo.yamada
 * *
 * @since :1.0 :2017/07/28
 */
class RadioActivity : AppCompatActivity() {
    /** ListView  */
    internal lateinit var listView: ListView
    /** 都道府県インスタンス  */
    internal lateinit var pref: Prefecture
    /** 都道府県のリスト  */
    internal lateinit var prefList: MutableList<Prefecture>
    /** Adapter  */
    internal lateinit var arrayAdapter: RadioPrefAdapter

    /**
     * 都道府県のリストを表示するメソッド
     */
    fun createPrefList() {
        prefList = ArrayList<Prefecture>()
        val prefName = resources.getStringArray(R.array.prefectures)

        for (i in prefName.indices) {
            pref = Prefecture(prefName[i], false)
            prefList.add(pref)
        }
        arrayAdapter = RadioPrefAdapter(this, R.layout.radio_item_list, prefList)

        if (!arrayAdapter.isEmpty) {
            arrayAdapter.getItem(0)!!.isSelected = true
        }

        listView = findViewById(R.id.list_view2) as ListView
        listView.choiceMode = ListView.CHOICE_MODE_SINGLE
        listView.adapter = arrayAdapter
    }

    /**
     * onCreate
     * @param savedInstanceState savedInstanceState
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio)

        //リストの表示
        createPrefList()

        // OKボタン押下時の処理
        findViewById(R.id.button_ok2).setOnClickListener {
            var responseText = String()
            prefList = arrayAdapter.list
            for (i in prefList.indices) {
                val pref = prefList[i]
                if (pref.isSelected) {
                    responseText = pref.prefName!!
                }
            }

            Toast.makeText(this@RadioActivity, responseText.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}
