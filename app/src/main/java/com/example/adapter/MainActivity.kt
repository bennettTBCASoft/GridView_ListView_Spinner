package com.example.adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.ListView
import android.widget.Spinner
import android.widget.Toast

// 設計新的類別定義水果的資料結構
data class Item(val photo: Int, val name: String, val price: Int)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 將變數與XML綁定
        val gridView = findViewById<GridView>(R.id.gridView)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val listView = findViewById<ListView>(R.id.listView)

        val count = ArrayList<String>() // 儲存購買數量
        val item = ArrayList<Item>()    // 除誰水果資訊
        val priceRange = IntRange(10, 100)  // 設定範圍，待會要做random取值
        val array = resources.obtainTypedArray(R.array.image_list)  // 從R類別讀取圖檔

        for (i in 0 until array.length()) {
            val photo = array.getResourceId(i, 0)   // 水果圖檔Id
            val name = "水果${i+1}"   // 新增水果名
            val price = priceRange.random() // 新增亂數
            count.add("${i+1}個")    // 新增可購買數量資訊
            item.add(Item(photo, name, price))  // 新增水果資訊
        }

        array.recycle() //釋放圖檔資源

        // 建立ArrayAdapter 物件，並傳入字串與simple_list_item_1.xml
        spinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, count)
        // 建立MyAdapter物件，並傳入adapter_vertical作為畫面
        gridView.adapter = MyAdapter(this, R.layout.adapter_vertical, item)
        // 設定橫向顯示列數
        gridView.numColumns = 3
        // 建立MyAdapter物件，並傳入adapter_horizontal作為畫面
        listView.adapter = MyAdapter(this, R.layout.adapter_horizontal, item)


    }
}