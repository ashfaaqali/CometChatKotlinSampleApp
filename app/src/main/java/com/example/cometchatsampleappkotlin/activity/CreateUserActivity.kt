package com.example.cometchatsampleappkotlin.activity

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.cometchat.chat.core.CometChat
import com.cometchat.chat.exceptions.CometChatException
import com.cometchat.chat.models.User
import com.cometchat.chatuikit.shared.cometchatuikit.CometChatUIKit
import com.example.cometchatsampleappkotlin.AppUtils.changeTextColorToBlack
import com.example.cometchatsampleappkotlin.AppUtils.changeTextColorToWhite
import com.example.cometchatsampleappkotlin.AppUtils.fetchDefaultObjects
import com.example.cometchatsampleappkotlin.AppUtils.isNightMode
import com.example.cometchatsampleappkotlin.R
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class CreateUserActivity : AppCompatActivity() {
    private lateinit var uid: TextInputEditText
    private lateinit var name: TextInputEditText
    private lateinit var createUserBtn: AppCompatButton
    private lateinit var progressBar: ProgressBar
    private lateinit var parentView: RelativeLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)

        parentView = findViewById<RelativeLayout>(R.id.parent_view)
        progressBar = findViewById<ProgressBar>(R.id.createUserPb)
        uid = findViewById<TextInputEditText>(R.id.etUID)
        name = findViewById<TextInputEditText>(R.id.etName)
        createUserBtn = findViewById<AppCompatButton>(R.id.createUserBtn)
        createUserBtn.setTextColor(getResources().getColor(R.color.white))
        createUserBtn.setOnClickListener(View.OnClickListener {
            if (uid.getText().toString()
                    .isEmpty()
            ) uid.error = getResources().getString(R.string.fill_this_field) else if (name.getText()
                    .toString().isEmpty()
            ) name.error = getResources().getString(R.string.fill_this_field) else {
                progressBar.visibility = View.VISIBLE
                createUserBtn.isClickable = false
                val user = User()
                user.uid = uid.getText().toString()
                user.name = name.getText().toString()
                CometChatUIKit.createUser(
                    user,
                    object : CometChat.CallbackListener<User>() {
                        override fun onSuccess(user: User) {
                            login(user)
                        }

                        override fun onError(e: CometChatException) {
                            createUserBtn.isClickable = true
                            Toast.makeText(
                                this@CreateUserActivity,
                                "Failed to create user",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    })
            }
        })
        setUpUI()
    }

    private fun login(user: User) {
        CometChatUIKit.login(user.uid, object : CometChat.CallbackListener<User?>() {
            override fun onSuccess(user: User?) {
                fetchDefaultObjects()
                startActivity(Intent(this@CreateUserActivity, HomeActivity::class.java))
                finishAffinity()
            }

            override fun onError(e: CometChatException) {
                if (uid != null) Snackbar.make(
                    uid.getRootView(),
                    "Unable to login",
                    Snackbar.LENGTH_INDEFINITE
                ).setAction(
                    "Try Again"
                ) {
                    startActivity(
                        Intent(
                            this@CreateUserActivity,
                            LoginActivity::class.java
                        )
                    )
                }.show()
            }
        })
    }

    private fun setUpUI() {
        if (isNightMode(this)) {
            changeTextColorToWhite(this, findViewById<TextView>(R.id.tvTitle))
            changeTextColorToWhite(this, findViewById<TextView>(R.id.tvDes2))
            uid.setTextColor(getResources().getColor(R.color.white))
            name.setTextColor(getResources().getColor(R.color.white))
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