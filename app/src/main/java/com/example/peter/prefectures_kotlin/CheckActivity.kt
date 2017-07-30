package com.example.peter.prefectures_kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import java.util.ArrayList


/**
 * チェックボタンで選択し、選択したアイテムを表示するクラス

 * @author :ryo.yamada
 * *
 * @since :1.0 :2017/07/28
 */
class CheckActivity : AppCompatActivity() {
    /** ListView  */
    internal lateinit var listView: ListView
    /** 都道府県インスタンス  */
    internal lateinit var pref: Prefecture
    /** 都道府県のリスト  */
    internal lateinit var prefList: MutableList<Prefecture>
    /** Adapter  */
    internal lateinit var arrayAdapter: CheckPrefAdapter

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
        arrayAdapter = CheckPrefAdapter(this, R.layout.check_item_list, prefList)
        listView = findViewById(R.id.list_view) as ListView
        listView.adapter = arrayAdapter

    }


    /**
     * onCreate
     * @param savedInstanceState savedInstanceState
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check)

        createPrefList()

        findViewById(R.id.button_ok).setOnClickListener {
            val responseText = StringBuilder()
            val prefList = arrayAdapter.list
            for (i in prefList.indices) {
                val pref = prefList[i]
                if (pref.isSelected) {
                    if (responseText.length != 0) {
                        responseText.append(", ")
                    }
                    responseText.append(pref.prefName)
                }
            }
            if (responseText.length == 0) {
                responseText.append("選択なし")
            }

            Toast.makeText(this@CheckActivity, responseText.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}

