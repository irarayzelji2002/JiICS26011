package com.example.ics26011_activity_110723_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var regularProperty = 1
    lateinit var recyclerView: RecyclerView
    lateinit var dataList : ArrayList<DataClass>
    lateinit var imageList : Array<Int>
    lateinit var titleList : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageList = arrayOf(
            R.mipmap.ic_launcher,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background
        )

        titleList = arrayOf(
            "TitleOne",
            "TitleTwo",
            "TitleThree",
            "TitleFour",
            "TitleFive",
            "TitleSix",
            "TitleSeven",
            "TitleEight",
            "TitleNine",
            "TitleTen"
        )

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        dataList = arrayListOf<DataClass>()
        getData()

        /*var newInnerInstance = newInnerClass()
        newInnerInstance.newInnerFunction(this, "Hi!")*/
    }

    /*inner class newInnerClass() {
        var innerProperty : String = ""
        fun newInnerFunction(innerContext : Context, innerMessage : String) {
            regularProperty ++
            Toast.makeText(innerContext, innerMessage +""+ regularProperty, Toast.LENGTH_SHORT).show()
        }
    }*/

    private fun getData() {
        for(i in imageList.indices) {
            var dataClass = DataClass(imageList[i], titleList[i])
            dataList.add(dataClass)
        }

        recyclerView.adapter = AdapterClass(dataList)
    }
}