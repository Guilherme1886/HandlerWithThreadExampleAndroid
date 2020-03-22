package com.gui.antonio.handlerwiththreadexample.handler

import android.os.Handler
import android.os.Looper
import android.os.Message

class MyHandler : Handler(Looper.getMainLooper()) {
    override fun handleMessage(msg: Message) {
        super.handleMessage(msg)


    }
}