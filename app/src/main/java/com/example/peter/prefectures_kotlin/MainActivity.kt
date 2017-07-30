package com.example.peter.prefectures_kotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

/**
 * メイン画面

 * @author :ryo.yamada
 * *
 * @since :1.0 :2017/07/28
 */
class MainActivity : AppCompatActivity() {

    /**
     *
     * メイン画面
     *  * Checkboxボタン押下でCheckActivityに遷移
     *  * Radiobuttonボタン押下でRadioActivityに遷移
     * @param savedInstanceState savedInstanceState
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Checkbox画面に遷移
        findViewById(R.id.button_check).setOnClickListener {
            val intent = Intent(this@MainActivity, CheckActivity::class.java)
            startActivity(intent)
        }

        // Radiobutton画面に遷移
        findViewById(R.id.button_radio).setOnClickListener {
            val intent = Intent(this@MainActivity, RadioActivity::class.java)
            startActivity(intent)
        }


    }
}
