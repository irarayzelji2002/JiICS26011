package com.example.ics26011_activity_102623

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlin.random.Random
import java.util.ArrayList

class HashMap : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hash_map)
        //var newHash : HashMap<String, String> = HashMap<String, String>()

        var randomNum = Random
        var newHash = hashMapOf<Int, HashData>()
        var hashWords = hashMapOf<Int, String>()
        val textView = findViewById<TextView>(R.id.textView)

        hashWords.put(0, "Zero")
        hashWords.put(1, "One")
        hashWords.put(2, "Zero")
        hashWords.put(3, "Zero")
        hashWords.put(4, "Zero")
        hashWords.put(5, "Zero")
        hashWords.put(6, "Zero")
        hashWords.put(7, "Zero")
        hashWords.put(8, "Zero")
        hashWords.put(9, "Zero")

        var randomAgain = Random

        var oneNum = randomNum.nextInt(10)
        var newData1 = HashData(oneNum, hashWords.get(oneNum).toString(), randomAgain.nextInt(3))
        var twoNum = randomNum.nextInt(10)
        var newData2 = HashData(twoNum, hashWords.get(twoNum).toString(), randomAgain.nextInt(3))
        var threeNum = randomNum.nextInt(10)
        var newData3 = HashData(threeNum, hashWords.get(threeNum).toString(), randomAgain.nextInt(3))

        var arraylistMap  = ArrayList<HashData>()
        arraylistMap.add(newData1)
        arraylistMap.add(newData2)
        arraylistMap.add(newData3)

        newHash.put(0, arraylistMap[0])
        newHash.put(1, arraylistMap[1])
        newHash.put(2, arraylistMap[2])



        //var ranging = randomAgain.nextInt(intValue)
        //ranging++
        Log.i("infoHash", newHash.get(randomAgain.nextInt(3))!!.third.toString())
        //Log.i("infoHash", newHash.get(randomAgain.nextInt(3)).toString())
        var data : String = newHash.get(randomAgain.nextInt(3))!!.third.toString()
        var result : Boolean
        if(data=="0") {
            result = false
            textView.text = result.toString()
            Log.i("result", result.toString())
        } else if(data=="1") {
            result = true
            textView.text = result.toString()
            Log.i("result", result.toString())
        } else {
            textView.text = "null"
        }
    }
}