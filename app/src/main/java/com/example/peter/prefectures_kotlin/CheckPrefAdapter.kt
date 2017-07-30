package com.example.peter.prefectures_kotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox


import java.util.ArrayList

/**
 * CheckPrefAdapter
 * チェックボックス画面用CustomAdapter
 * @author :ryo.yamada
 * *
 * @since :1.0 :2017/07/28
 */

class CheckPrefAdapter
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
        /** Checkbox */
        internal var checkBox: CheckBox? = null
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
        var holder: ViewHolder? = null

        if (view == null) {
            view = layoutInflater.inflate(R.layout.check_item_list, null)

            holder = ViewHolder()
            holder.checkBox = view!!.findViewById<View>(R.id.checkbox_id) as CheckBox
            view.tag = holder

            holder.checkBox!!.setOnClickListener { view ->
                val cb = view as CheckBox
                val pref = cb.tag as Prefecture
                pref.isSelected = cb.isChecked
            }

        } else {
            holder = view.tag as ViewHolder
        }

        val pref = list[position]
        holder.checkBox!!.isChecked = pref.isSelected
        holder.checkBox!!.text = pref.prefName
        holder.checkBox!!.tag = pref

        return view
    }
}

