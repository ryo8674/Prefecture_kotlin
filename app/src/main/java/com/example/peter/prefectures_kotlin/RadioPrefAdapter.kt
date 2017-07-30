package com.example.peter.prefectures_kotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.RadioButton

import java.util.ArrayList

/**
 * RadioPrefAdapter
 * ラジオボタン画面用CustomAdapter
 * @author :ryo.yamada
 * *
 * @since :1.0 :2017/07/28
 */
class RadioPrefAdapter
/**
 * コンストラクタ
 * @param context クラスのオブジェクト
 * *
 * @param resourceId リソースID
 * *
 * @param list データのリスト
 */
(context: Context, resourceId: Int, list: List<Prefecture>) : ArrayAdapter<Prefecture>(context, resourceId, list) {

    /** 都道府県のリスト  */
    internal var list: MutableList<Prefecture>
    /** LayoutInflater  */
    private val layoutInflater: LayoutInflater

    init {
        this.list = ArrayList<Prefecture>()
        this.list.addAll(list)

        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    /**
     * ViewHolder
     */
    private inner class ViewHolder {
        /** Radiobutton  */
        internal var radioBtn: RadioButton? = null
    }

    /**
     * getViewメソッド
     * @param position リストの番号
     * *
     * @param convertView リストのView情報
     * *
     * @param parent 親のView
     * *
     * @return view view
     */
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var view = convertView
        val holder: ViewHolder

        if (view == null) {
            view = layoutInflater.inflate(R.layout.radio_item_list, null)

            holder = ViewHolder()
            holder.radioBtn = view!!.findViewById<RadioButton>(R.id.radio_id)
            view.tag = holder

        } else {
            holder = view.tag as ViewHolder
        }

        val pref = list[position]
        holder.radioBtn!!.isChecked = pref.isSelected
        holder.radioBtn!!.text = pref.prefName

        holder.radioBtn!!.setOnClickListener {
            // すべてのチェックをクリア
            for (i in list.indices) {
                list[i].isSelected = false
            }
            // クリックしたボタンのみチェックする
            pref.isSelected = true
            // アダプタ内容を即時反映
            notifyDataSetChanged()
        }

        return view
    }
}

