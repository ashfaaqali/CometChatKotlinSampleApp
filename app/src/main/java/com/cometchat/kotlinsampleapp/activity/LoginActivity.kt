package com.cometchat.kotlinsampleapp.activity

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.TextView.OnEditorActionListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.cometchat.chat.core.CometChat
import com.cometchat.chat.exceptions.CometChatException
import com.cometchat.chat.models.User
import com.cometchat.chatuikit.shared.cometchatuikit.CometChatUIKit
import com.cometchat.kotlinsampleapp.AppUtils.changeTextColorToBlack
import com.cometchat.kotlinsampleapp.AppUtils.changeTextColorToWhite
import com.cometchat.kotlinsampleapp.AppUtils.fetchDefaultObjects
import com.cometchat.kotlinsampleapp.AppUtils.isNightMode
import com.cometchat.kotlinsampleapp.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    private lateinit var inputLayout: TextInputLayout
    private lateinit var progressBar: ProgressBar
    private lateinit var uid: TextInputEditText
    private lateinit var parentView: RelativeLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        uid = findViewById(R.id.etUID)
        progressBar = findViewById(R.id.loginProgress)
        inputLayout = findViewById(R.id.inputUID)
        parentView = findViewById(R.id.parent_view)
        uid.setOnEditorActionListener(OnEditorActionListener { textView: TextView?, i: Int, keyEvent: KeyEvent? ->
            if (i == EditorInfo.IME_ACTION_DONE) {
                if (uid.getText().toString().isEmpty()) {
                    uid.error = "Enter UID"
                } else {
                    uid.error = null
                    progressBar.visibility = View.VISIBLE
                    inputLayout.isEndIconVisible = false
                    login(uid.getText().toString())
                }
            }
            true
        })
        findViewById<View>(R.id.tvSignIn).setOnClickListener { view: View? ->
            if (uid.text.toString().isEmpty()) {
                uid.error = "Enter UID"
            } else {
                progressBar.visibility = View.VISIBLE
                inputLayout.isEndIconVisible = false
                login(uid.getText().toString())
            }
        }
        setUpUI()
    }

    private fun login(uid: String) {
        CometChatUIKit.login(uid, object : CometChat.CallbackListener<User?>() {
            override fun onSuccess(user: User?) {
                startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
                fetchDefaultObjects()
                finishAffinity()
            }

            override fun onError(e: CometChatException) {
                inputLayout.isEndIconVisible = true
                progressBar.visibility = View.GONE
                Toast.makeText(this@LoginActivity, e.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun createUser(view: View?) {
        startActivity(Intent(this@LoginActivity, CreateUserActivity::class.java))
    }

    private fun setUpUI() {
        if (isNightMode(this)) {
            changeTextColorToWhite(this, findViewById<TextView>(R.id.tvTitle))
            changeTextColorToWhite(this, findViewById<TextView>(R.id.tvDes2))
            inputLayout.editText!!.setTextColor(getResources().getColor(R.color.white))
            parentView.setBackgroundTintList(
                ColorStateList.valueOf(
                    ContextCompat.getColor(
                        this,
                        R.color.app_background_dark
                    )
                )
            )
        } else {
            changeTextColorToBlack(this, findViewById<TextView>(R.id.tvTitle))
            changeTextColorToBlack(this, findViewById<TextView>(R.id.tvDes2))
            parentView.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.app_background)))
        }
    }
}