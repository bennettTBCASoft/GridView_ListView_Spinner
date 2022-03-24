package com.example.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView


class MyAdapter(context: Context, private val layout: Int , data: ArrayList<Item>): ArrayAdapter<Item>(context, layout, data) {

    // 覆寫 getView
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // 依據傳入的Layout建立畫面
        val view = View.inflate(parent.context, layout, null)
        // 依據position取得對應的資料內容
        val item = getItem(position) ?: return view
        // 將圖片指派給Item內的ImageView
        val img_photo = view.findViewById<ImageView>(R.id.img_photo)
        img_photo.setImageResource(item.photo)
        // 將訊息指派給Item內的TextView，若是垂直，將回傳名稱，否則為名稱及價錢
        val tv_msg = view.findViewById<TextView>(R.id.tv_msg)
        tv_msg.text = if (layout == R.layout.adapter_vertical)
            item.name
        else
            "${item.name}: ${item.price}元"
        // 回傳此項目的畫面
        return view
    }
}