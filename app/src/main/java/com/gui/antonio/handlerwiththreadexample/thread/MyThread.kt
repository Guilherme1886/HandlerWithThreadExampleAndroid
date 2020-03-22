package com.gui.antonio.handlerwiththreadexample.thread

import android.os.Handler
import android.os.Message

class MyThread(val handler: Handler) : Thread() {

    override fun run() {
        super.run()
        setupAndSendMessage()
    }

    private fun setupAndSendMessage() {
        for (i in 0..50) {
            val m = Message()
            m.what = 1
            m.obj = "Download number $i"
            handler.sendMessage(m)
            sleep(500)
        }
        val m = Message()
        m.what = 2
        m.obj = "Finish execution downloads"
        handler.sendMessage(m)
    }
}