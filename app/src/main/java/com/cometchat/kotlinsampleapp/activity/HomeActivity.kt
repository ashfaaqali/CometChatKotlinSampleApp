package com.cometchat.kotlinsampleapp.activity

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.cometchat.chat.core.CometChat
import com.cometchat.chat.exceptions.CometChatException
import com.cometchat.chatuikit.shared.cometchatuikit.CometChatUIKit
import com.cometchat.chatuikit.shared.resources.theme.CometChatTheme
import com.cometchat.chatuikit.shared.resources.theme.Palette
import com.cometchat.chatuikit.shared.resources.utils.Utils
import com.cometchat.kotlinsampleapp.AppUtils.changeIconTintToBlack
import com.cometchat.kotlinsampleapp.AppUtils.changeIconTintToWhite
import com.cometchat.kotlinsampleapp.AppUtils.isNightMode
import com.cometchat.kotlinsampleapp.AppUtils.switchDarkMode
import com.cometchat.kotlinsampleapp.AppUtils.switchLightMode
import com.cometchat.kotlinsampleapp.R
import com.cometchat.kotlinsampleapp.constants.StringConstants

class HomeActivity : AppCompatActivity() {
    private lateinit var darkMode: ImageView
    private lateinit var lightMode: ImageView
    private lateinit var logout: ImageView
    private lateinit var parentView: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        darkMode = findViewById(R.id.dark_mode)
        lightMode = findViewById(R.id.light_mode)
        parentView = findViewById(R.id.parent_view)
        logout = findViewById(R.id.logout)
        setUpUI()
        findViewById<View>(R.id.chats).setOnClickListener { view: View? ->
            handleIntent(
                StringConstants.CONVERSATIONS
            )
        }
        findViewById<View>(R.id.users).setOnClickListener { view: View? ->
            handleIntent(
                StringConstants.USERS
            )
        }
        findViewById<View>(R.id.groups).setOnClickListener { view: View? ->
            handleIntent(
                StringConstants.GROUPS
            )
        }
        findViewById<View>(R.id.messages).setOnClickListener { view: View? ->
            handleIntent(
                StringConstants.MESSAGES
            )
        }
        findViewById<View>(R.id.shared).setOnClickListener { view: View? ->
            handleIntent(
                StringConstants.SHARED
            )
        }
        findViewById<View>(R.id.calls).setOnClickListener { view: View? ->
            handleIntent(
                StringConstants.CALLS
            )
        }
        logout.setOnClickListener(View.OnClickListener { view: View? ->
            CometChatUIKit.logout(object : CometChat.CallbackListener<String?>() {
                override fun onSuccess(s: String?) {
                    startActivity(
                        Intent(
                            this@HomeActivity,
                            MainActivity::class.java
                        )
                    )
                    finishAffinity()
                }

                override fun onError(e: CometChatException) {}
            })
        })
        darkMode.setOnClickListener({ view: View? -> toggleDarkMode() })
        lightMode.setOnClickListener({ view: View? -> toggleDarkMode() })
    }

    private fun setUpUI() {
        if (isNightMode(this)) {
            changeIconTintToWhite(this, darkMode)
            changeIconTintToWhite(this, lightMode)
            changeIconTintToWhite(this, logout)
            Utils.setStatusBarColor(this, ContextCompat.getColor(this, R.color.app_background_dark))
            parentView.setBackgroundTintList(
                ColorStateList.valueOf(
                    ContextCompat.getColor(
                        this,
                        R.color.app_background_dark
                    )
                )
            )
            darkMode.setVisibility(View.GONE)
            lightMode.setVisibility(View.VISIBLE)
        } else {
            changeIconTintToBlack(this, darkMode)
            changeIconTintToBlack(this, lightMode)
            changeIconTintToBlack(this, logout)
            Utils.setStatusBarColor(this, getResources().getColor(R.color.app_background))
            parentView.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.app_background)))
            darkMode.setVisibility(View.VISIBLE)
            lightMode.setVisibility(View.GONE)
        }
    }

    private fun toggleDarkMode() {
        if (isNightMode(this)) {
            Palette.getInstance(this).mode(CometChatTheme.MODE.LIGHT)
            switchLightMode()
        } else {
            Palette.getInstance(this).mode(CometChatTheme.MODE.DARK)
            switchDarkMode()
        }
    }

    private fun handleIntent(module: String) {
        val intent = Intent(this, ComponentListActivity::class.java)
        intent.putExtra(StringConstants.MODULE, module)
        startActivity(intent)
    }
}