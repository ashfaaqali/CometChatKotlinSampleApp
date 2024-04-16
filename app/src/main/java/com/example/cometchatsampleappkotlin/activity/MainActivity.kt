package com.example.cometchatsampleappkotlin.activity

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.cometchat.chat.core.CometChat
import com.cometchat.chat.exceptions.CometChatException
import com.cometchat.chat.models.User
import com.cometchat.chatuikit.shared.cometchatuikit.CometChatUIKit
import com.cometchat.chatuikit.shared.cometchatuikit.UIKitSettings.UIKitSettingsBuilder
import com.cometchat.chatuikit.shared.resources.utils.Utils
import com.example.cometchatsampleappkotlin.AppUtils.fetchDefaultObjects
import com.example.cometchatsampleappkotlin.AppUtils.isNightMode
import com.example.cometchatsampleappkotlin.Application
import com.example.cometchatsampleappkotlin.AppConstants
import com.example.cometchatsampleappkotlin.R
import com.google.android.material.card.MaterialCardView
import org.json.JSONObject
import com.example.cometchatsampleappkotlin.BuildConfig

class MainActivity : AppCompatActivity() {
    private lateinit var superhero1: MaterialCardView
    private lateinit var superhero2: MaterialCardView
    private lateinit var superhero3: MaterialCardView
    private lateinit var superhero4: MaterialCardView
    private lateinit var ivLogo: AppCompatImageView
    private lateinit var tvCometChat: AppCompatTextView
    private lateinit var parentView: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        parentView = findViewById(R.id.parent_view)
        Utils.setStatusBarColor(this, getResources().getColor(R.color.white))
        val uiKitSettings =
            UIKitSettingsBuilder().setRegion(AppConstants.REGION).setAppId(AppConstants.APP_ID)
                .setAuthKey(AppConstants.AUTH_KEY).subscribePresenceForAllUsers().build()
        CometChatUIKit.init(this, uiKitSettings, object : CometChat.CallbackListener<String?>() {
            override fun onSuccess(s: String?) {
                CometChat.setDemoMetaInfo(appMetadata)
                if (CometChatUIKit.getLoggedInUser() != null) {
                    Application.addCallListener(this@MainActivity)
                    fetchDefaultObjects()
                    startActivity(Intent(this@MainActivity, HomeActivity::class.java))
                    finish()
                }
            }

            override fun onError(e: CometChatException) {
                Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_SHORT).show()
            }
        })
        superhero1 = findViewById(R.id.superhero1)
        superhero2 = findViewById(R.id.superhero2)
        superhero3 = findViewById(R.id.superhero3)
        superhero4 = findViewById(R.id.superhero4)
        ivLogo = findViewById(R.id.ivLogo)
        tvCometChat = findViewById(R.id.tvComet)
        findViewById<View>(R.id.login).setOnClickListener { view: View? ->
            startActivity(
                Intent(
                    this@MainActivity,
                    LoginActivity::class.java
                )
            )
        }
        superhero1.setOnClickListener(View.OnClickListener { view: View? ->
            findViewById<View>(R.id.superhero1Progressbar).visibility = View.VISIBLE
            login("superhero1")
        })
        superhero2.setOnClickListener(View.OnClickListener { view: View? ->
            findViewById<View>(R.id.superhero2Progressbar).visibility = View.VISIBLE
            login("superhero2")
        })
        superhero3.setOnClickListener(View.OnClickListener { view: View? ->
            findViewById<View>(R.id.superhero3Progressbar).visibility = View.VISIBLE
            login("superhero3")
        })
        superhero4.setOnClickListener(View.OnClickListener { view: View? ->
            findViewById<View>(R.id.superhero4Progressbar).visibility = View.VISIBLE
            login("superhero4")
        })
        if (Utils.isDarkMode(this)) {
            ivLogo.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.white)))
        } else {
            ivLogo.setImageTintList(ColorStateList.valueOf(getResources().getColor(com.cometchat.chatuikit.R.color.cometchat_primary_text_color)))
        }
        setUpUI()
    }

    private fun login(uid: String) {
        CometChatUIKit.login(uid, object : CometChat.CallbackListener<User?>() {
            override fun onSuccess(user: User?) {
                Application.addCallListener(this@MainActivity)
                fetchDefaultObjects()
                startActivity(Intent(this@MainActivity, HomeActivity::class.java))
                finish()
            }

            override fun onError(e: CometChatException) {
                Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setUpUI() {
        if (isNightMode(this)) {
            Utils.setStatusBarColor(this, ContextCompat.getColor(this, R.color.app_background_dark))
            parentView.setBackgroundTintList(
                ColorStateList.valueOf(
                    ContextCompat.getColor(
                        this,
                        R.color.app_background_dark
                    )
                )
            )
            tvCometChat.setTextColor(getResources().getColor(R.color.app_background))
        } else {
            Utils.setStatusBarColor(this, getResources().getColor(R.color.app_background))
            parentView.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.app_background)))
            tvCometChat.setTextColor(getResources().getColor(R.color.app_background_dark))
        }
    }

    private val appMetadata: JSONObject
        get() {
            val jsonObject = JSONObject()
            try {
                jsonObject.put("name", getResources().getString(R.string.app_name))
                jsonObject.put("type", "sample")
                jsonObject.put("version", BuildConfig.VERSION_NAME)
                jsonObject.put("bundle", BuildConfig.APPLICATION_ID)
                jsonObject.put("platform", "android")
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return jsonObject
        }

    fun createUser(view: View?) {
        startActivity(Intent(this, CreateUserActivity::class.java))
    }
}