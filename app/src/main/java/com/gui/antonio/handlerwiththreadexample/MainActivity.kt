package com.gui.antonio.handlerwiththreadexample

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.widget.ArrayAdapter
import com.gui.antonio.handlerwiththreadexample.handler.MyHandler
import com.gui.antonio.handlerwiththreadexample.thread.MyThread
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var handler: Handler
    private lateinit var thread: MyThread
    private var list: ArrayList<String>? = null
    private var arrayAdapter: ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        constructHandler()
        constructThread()
    }

    override fun onResume() {
        super.onResume()
        startThread()
    }

    private fun constructHandler() {
        handler = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                Log.v("TAG", "what: ${msg.what} - obj: ${msg.obj}")
                val itemReceived = "what: ${msg.what} - obj: ${msg.obj}"
                setAdapterListView(itemReceived)
            }
        }
    }

    private fun setAdapterListView(itemReceived: String) {
        if (list == null) {
            list = arrayListOf()
        }

        list?.add(itemReceived)

        if (arrayAdapter == null) {
            arrayAdapter = ArrayAdapter(
                this@MainActivity,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                list!!
            )
            listView.adapter = arrayAdapter
        }

        arrayAdapter?.notifyDataSetChanged()
        listView.smoothScrollToPosition(list!!.size.minus(1))
    }

    private fun constructThread() {
        thread = MyThread(handler)
    }

    private fun startThread() {
        thread.start()
    }
}
