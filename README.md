# 清單元件 Adapter ListView GridView Spinner

## What is Adapter
>在app中，資料的處理和清單元件顯示的資訊是分開的操作，只有在清單元件要顯示資訊的時候，才會將資料轉換成資訊，**一筆資訊的內容稱為『項目』（Item），而負責進行轉換動作的調配者就是『Adapter』，Adapter介於資料與畫面之間，他會為項目產生一個項目畫面（View）**，並將資訊放入其中，而螢幕畫面中的清單元件如同容器，Adapter會決定容器內要放入的項目畫面。

![](https://i.imgur.com/IZFhXK2.png)

>以生活例子來說，容器就像是一間飯店，飯店內的房間就是View，Adapter是飯店的接待人員，Data是客人，客人（data）要入住飯店內的房間(view)，需要詢問接待人員（adapter），接待人員會安排客人要入住的房間

## ListView 、 GridView、Spinner
> **清單的主要組成元件：**

1. Data(通常是陣列，`ArrayList<String>`)
2. View(xml)
3. Adatper(一般的純文字：android.R.layout.simple_item_1 / Customized Adapter)

### Adapter
1. 使用系統的
    - 參數2（樣式）:`Android.R.layout.simple_list_item_1`
    - 參數3（Data）：通常傳入字串陣列
![](https://i.imgur.com/3XUoqnV.png)

2. 使用客製化的
- 另外寫一個calss
![](https://i.imgur.com/bGf2tid.png)
----
- 參數要有 **context**、**layout**、**data**
- 且要繼承ArrayAdapter<傳入資料格式>
![](https://i.imgur.com/obxTpNn.png)
----
- 覆寫 getView
- 裡面要傳入layout樣式（inflate）
- 傳入資料 getItem(postion)
- 實作這個item裡面會有的元件(component)
![](https://i.imgur.com/5yKEiGa.png)

### ListView / GridView / Spinner


1. 宣告元件
![](https://i.imgur.com/AmKMAiZ.png)

2. 實作資料    
![](https://i.imgur.com/ttef2c9.png)

3. 串接Adapter
![](https://i.imgur.com/VE9AzWF.png)

## 完整程式碼
### MainActivity
![](https://i.imgur.com/mY0zJHC.png) 
![](https://i.imgur.com/SOaXPj9.png)

### MyAdapter(客製化Adapter)
![](https://i.imgur.com/Xe5Ev51.png)

### 圖檔
![](https://i.imgur.com/PYsWOIr.png)


### activity_main.xml
![](https://i.imgur.com/rKsA4of.png)


### adapter_horicontal.xml(layout)
![](https://i.imgur.com/6XzkcND.png)

### adapter_vertical.xml(layout)
![](https://i.imgur.com/fSNwzng.png)

### values->strings
![](https://i.imgur.com/vi1yTcc.png)




###### tags: `kotlin`
