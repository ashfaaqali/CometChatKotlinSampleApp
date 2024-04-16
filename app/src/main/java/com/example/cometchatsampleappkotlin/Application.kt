package com.example.cometchatsampleappkotlin

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import com.cometchat.chat.core.Call
import com.cometchat.chat.core.CometChat
import com.cometchat.chatuikit.calls.CometChatCallActivity
import com.cometchat.chatuikit.shared.resources.theme.CometChatTheme
import com.cometchat.chatuikit.shared.resources.theme.Palette
import com.example.cometchatsampleappkotlin.AppUtils.isNightMode

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        LISTENER_ID = System.currentTimeMillis().toString() + ""
        if (isNightMode(this)) {
            Palette.getInstance(this).mode(CometChatTheme.MODE.DARK)
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (isNightMode(this)) {
            Palette.getInstance(this).mode(CometChatTheme.MODE.DARK)
        } else {
            Palette.getInstance(this).mode(CometChatTheme.MODE.LIGHT)
        }
    }

    companion object {
        private var LISTENER_ID = ""
        fun addCallListener(context: Context?) {
            CometChat.addCallListener(LISTENER_ID, object : CometChat.CallListener() {
                override fun onIncomingCallReceived(call: Call?) {
                    CometChatCallActivity.launchIncomingCallScreen(context, call, null)
                }
                override fun onOutgoingCallAccepted(call: Call?) {}
                override fun onOutgoingCallRejected(call: Call?) {}
                override fun onIncomingCallCancelled(call: Call?) {}
            })
        }
    }
}
