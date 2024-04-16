package com.example.cometchatsampleappkotlin.activity

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.cometchat.chatuikit.shared.resources.utils.Utils
import com.example.cometchatsampleappkotlin.AppUtils.changeIconTintToBlack
import com.example.cometchatsampleappkotlin.AppUtils.changeIconTintToWhite
import com.example.cometchatsampleappkotlin.AppUtils.isNightMode
import com.example.cometchatsampleappkotlin.R
import com.example.cometchatsampleappkotlin.constants.StringConstants

class ComponentListActivity : AppCompatActivity() {
    var parentView: LinearLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_component_list)
        parentView = findViewById<LinearLayout>(R.id.parent_view)
        val title = findViewById<TextView>(R.id.title)
        setUpUI()
        if (intent != null) {
            title.text = intent.getStringExtra(StringConstants.MODULE)
            if (intent.getStringExtra(StringConstants.MODULE)
                    .equals(StringConstants.CONVERSATIONS, ignoreCase = true)
            ) {
                findViewById<View>(R.id.moduleChats).visibility = View.VISIBLE
            } else if (intent.getStringExtra(StringConstants.MODULE)
                    .equals(StringConstants.USERS, ignoreCase = true)
            ) {
                findViewById<View>(R.id.moduleUsers).visibility = View.VISIBLE
            } else if (intent.getStringExtra(StringConstants.MODULE)
                    .equals(StringConstants.GROUPS, ignoreCase = true)
            ) {
                findViewById<View>(R.id.noduleGroups).visibility = View.VISIBLE
            } else if (intent.getStringExtra(StringConstants.MODULE)
                    .equals(StringConstants.MESSAGES, ignoreCase = true)
            ) {
                findViewById<View>(R.id.moduleMessages).visibility = View.VISIBLE
            } else if (intent.getStringExtra(StringConstants.MODULE)
                    .equals(StringConstants.SHARED, ignoreCase = true)
            ) {
                findViewById<View>(R.id.shared).visibility = View.VISIBLE
            } else if (intent.getStringExtra(StringConstants.MODULE)
                    .equals(StringConstants.CALLS, ignoreCase = true)
            ) {
                findViewById<View>(R.id.module_calls).visibility = View.VISIBLE
            }
        }
        //back
        findViewById<View>(R.id.backIcon).setOnClickListener { view: View? -> onBackPressed() }

        //chats
        findViewById<View>(R.id.conversationWithMessages).setOnClickListener { view: View? ->
            handleIntent(
                R.id.conversationWithMessages
            )
        }
        findViewById<View>(R.id.conversations).setOnClickListener { view: View? ->
            handleIntent(
                R.id.conversations
            )
        }
        findViewById<View>(R.id.contacts).setOnClickListener { view: View? ->
            handleIntent(
                R.id.contacts
            )
        }

        //users
        findViewById<View>(R.id.userWithMessages).setOnClickListener { view: View? ->
            handleIntent(
                R.id.userWithMessages
            )
        }
        findViewById<View>(R.id.users).setOnClickListener { view: View? ->
            handleIntent(
                R.id.users
            )
        }
        findViewById<View>(R.id.user_details).setOnClickListener { view: View? ->
            handleIntent(
                R.id.user_details
            )
        }

        //groups
        findViewById<View>(R.id.groupWithMessages).setOnClickListener { view: View? ->
            handleIntent(
                R.id.groupWithMessages
            )
        }
        findViewById<View>(R.id.groups).setOnClickListener { view: View? ->
            handleIntent(
                R.id.groups
            )
        }
        findViewById<View>(R.id.create_group).setOnClickListener { view: View? ->
            handleIntent(
                R.id.create_group
            )
        }
        findViewById<View>(R.id.join_protected_group).setOnClickListener { view: View? ->
            handleIntent(
                R.id.join_protected_group
            )
        }
        findViewById<View>(R.id.group_member).setOnClickListener { view: View? ->
            handleIntent(
                R.id.group_member
            )
        }
        findViewById<View>(R.id.add_member).setOnClickListener { view: View? ->
            handleIntent(
                R.id.add_member
            )
        }
        findViewById<View>(R.id.transfer_ownership).setOnClickListener { view: View? ->
            handleIntent(
                R.id.transfer_ownership
            )
        }
        findViewById<View>(R.id.banned_members).setOnClickListener { view: View? ->
            handleIntent(
                R.id.banned_members
            )
        }
        findViewById<View>(R.id.group_details).setOnClickListener { view: View? ->
            handleIntent(
                R.id.group_details
            )
        }

        //messages
        findViewById<View>(R.id.messages).setOnClickListener { view: View? ->
            handleIntent(
                R.id.messages
            )
        }
        findViewById<View>(R.id.messageList).setOnClickListener { view: View? ->
            handleIntent(
                R.id.messageList
            )
        }
        findViewById<View>(R.id.messageHeader).setOnClickListener { view: View? ->
            handleIntent(
                R.id.messageHeader
            )
        }
        findViewById<View>(R.id.messageComposer).setOnClickListener { view: View? ->
            handleIntent(
                R.id.messageComposer
            )
        }
        findViewById<View>(R.id.messageInformation).setOnClickListener { view: View? ->
            handleIntent(
                R.id.messageInformation
            )
        }

        //calls
        findViewById<View>(R.id.call_button).setOnClickListener { view: View? ->
            handleIntent(
                R.id.call_button
            )
        }
        findViewById<View>(R.id.call_logs).setOnClickListener { view: View? ->
            handleIntent(
                R.id.call_logs
            )
        }
        findViewById<View>(R.id.call_logs_details).setOnClickListener { view: View? ->
            handleIntent(
                R.id.call_logs_details
            )
        }
        findViewById<View>(R.id.call_logs_with_details).setOnClickListener { view: View? ->
            handleIntent(
                R.id.call_logs_with_details
            )
        }
        findViewById<View>(R.id.call_log_participants).setOnClickListener { view: View? ->
            handleIntent(
                R.id.call_log_participants
            )
        }
        findViewById<View>(R.id.call_log_recording).setOnClickListener { view: View? ->
            handleIntent(
                R.id.call_log_recording
            )
        }
        findViewById<View>(R.id.call_log_history).setOnClickListener { view: View? ->
            handleIntent(
                R.id.call_log_history
            )
        }

        //shared

        //views
        findViewById<View>(R.id.avatar).setOnClickListener { view: View? ->
            handleIntent(
                R.id.avatar
            )
        }
        findViewById<View>(R.id.badgeCount).setOnClickListener { view: View? ->
            handleIntent(
                R.id.badgeCount
            )
        }
        findViewById<View>(R.id.messageReceipt).setOnClickListener { view: View? ->
            handleIntent(
                R.id.messageReceipt
            )
        }
        findViewById<View>(R.id.statusIndicator).setOnClickListener { view: View? ->
            handleIntent(
                R.id.statusIndicator
            )
        }
        findViewById<View>(R.id.list_item).setOnClickListener { view: View? ->
            handleIntent(
                R.id.list_item
            )
        }
        findViewById<View>(R.id.text_bubble).setOnClickListener { view: View? ->
            handleIntent(
                R.id.text_bubble
            )
        }
        findViewById<View>(R.id.image_bubble).setOnClickListener { view: View? ->
            handleIntent(
                R.id.image_bubble
            )
        }
        findViewById<View>(R.id.video_bubble).setOnClickListener { view: View? ->
            handleIntent(
                R.id.video_bubble
            )
        }
        findViewById<View>(R.id.audio_bubble).setOnClickListener { view: View? ->
            handleIntent(
                R.id.audio_bubble
            )
        }
        findViewById<View>(R.id.files_bubble).setOnClickListener { view: View? ->
            handleIntent(
                R.id.files_bubble
            )
        }
        findViewById<View>(R.id.form_bubble).setOnClickListener { view: View? ->
            handleIntent(
                R.id.form_bubble
            )
        }
        findViewById<View>(R.id.card_bubble).setOnClickListener { view: View? ->
            handleIntent(
                R.id.card_bubble
            )
        }
        findViewById<View>(R.id.scheduler_bubble).setOnClickListener { view: View? ->
            handleIntent(
                R.id.scheduler_bubble
            )
        }
        findViewById<View>(R.id.media_recorder).setOnClickListener { view: View? ->
            handleIntent(
                R.id.media_recorder
            )
        }

        //resources
        findViewById<View>(R.id.soundManager).setOnClickListener { view: View? ->
            handleIntent(
                R.id.soundManager
            )
        }
        findViewById<View>(R.id.theme).setOnClickListener { view: View? ->
            handleIntent(
                R.id.theme
            )
        }
        findViewById<View>(R.id.localize).setOnClickListener { view: View? ->
            handleIntent(
                R.id.localize
            )
        }
    }

    private fun setUpUI() {
        if (isNightMode(this)) {
            changeIconTintToWhite(this, findViewById<ImageView>(R.id.backIcon))
            changeIconTintToWhite(this, findViewById<ImageView>(R.id.image_cwm))
            changeIconTintToWhite(this, findViewById<ImageView>(R.id.image_c))
            changeIconTintToWhite(this, findViewById<ImageView>(R.id.image_contacts))
            changeIconTintToWhite(this, findViewById<ImageView>(R.id.image_uwm))
            changeIconTintToWhite(this, findViewById<ImageView>(R.id.image_u))
            changeIconTintToWhite(this, findViewById<ImageView>(R.id.image_ud))
            changeIconTintToWhite(this, findViewById<ImageView>(R.id.image_gwm))
            changeIconTintToWhite(this, findViewById<ImageView>(R.id.image_g))
            changeIconTintToWhite(this, findViewById<ImageView>(R.id.image_cg))
            changeIconTintToWhite(this, findViewById<ImageView>(R.id.image_jp))
            changeIconTintToWhite(this, findViewById<ImageView>(R.id.image_gm))
            changeIconTintToWhite(this, findViewById<ImageView>(R.id.image_ad))
            changeIconTintToWhite(this, findViewById<ImageView>(R.id.image_to))
            changeIconTintToWhite(this, findViewById<ImageView>(R.id.image_bm))
            changeIconTintToWhite(this, findViewById<ImageView>(R.id.image_gd))
            changeIconTintToWhite(this, findViewById<ImageView>(R.id.image_message))
            changeIconTintToWhite(this, findViewById<ImageView>(R.id.image_message_header))
            changeIconTintToWhite(this, findViewById<ImageView>(R.id.image_message_list))
            changeIconTintToWhite(this, findViewById<ImageView>(R.id.image_message_composer))
            changeIconTintToWhite(this, findViewById<ImageView>(R.id.image_message_information))
            changeIconTintToWhite(this, findViewById<ImageView>(R.id.image_call_button))
            changeIconTintToWhite(this, findViewById<ImageView>(R.id.image_audio))
            changeIconTintToWhite(this, findViewById<ImageView>(R.id.image_translate))
            changeIconTintToWhite(this, findViewById<ImageView>(R.id.image_avatar))
            changeIconTintToWhite(this, findViewById<ImageView>(R.id.image_badge_count))
            changeIconTintToWhite(this, findViewById<ImageView>(R.id.image_message_receipt))
            changeIconTintToWhite(this, findViewById<ImageView>(R.id.image_status_indicator))
            changeIconTintToWhite(this, findViewById<ImageView>(R.id.image_text_bubble))
            changeIconTintToWhite(this, findViewById<ImageView>(R.id.image_image_bubble))
            changeIconTintToWhite(this, findViewById<ImageView>(R.id.image_video_bubble))
            changeIconTintToWhite(this, findViewById<ImageView>(R.id.image_audio_bubble))
            changeIconTintToWhite(this, findViewById<ImageView>(R.id.image_file_bubble))
            changeIconTintToWhite(this, findViewById<ImageView>(R.id.image_form_bubble))
            changeIconTintToWhite(this, findViewById<ImageView>(R.id.image_card_bubble))
            changeIconTintToWhite(this, findViewById<ImageView>(R.id.image_scheduler_bubble))
            changeIconTintToWhite(this, findViewById<ImageView>(R.id.image_mic))
            changeIconTintToWhite(this, findViewById<ImageView>(R.id.image_list_item))
            Utils.setStatusBarColor(this, ContextCompat.getColor(this, R.color.app_background_dark))
            parentView!!.setBackgroundTintList(
                ColorStateList.valueOf(
                    ContextCompat.getColor(
                        this,
                        R.color.app_background_dark
                    )
                )
            )
        } else {
            changeIconTintToBlack(this, findViewById<ImageView>(R.id.backIcon))
            changeIconTintToBlack(this, findViewById<ImageView>(R.id.image_cwm))
            changeIconTintToBlack(this, findViewById<ImageView>(R.id.image_c))
            changeIconTintToBlack(this, findViewById<ImageView>(R.id.image_contacts))
            changeIconTintToBlack(this, findViewById<ImageView>(R.id.image_uwm))
            changeIconTintToBlack(this, findViewById<ImageView>(R.id.image_u))
            changeIconTintToBlack(this, findViewById<ImageView>(R.id.image_ud))
            changeIconTintToBlack(this, findViewById<ImageView>(R.id.image_gwm))
            changeIconTintToBlack(this, findViewById<ImageView>(R.id.image_g))
            changeIconTintToBlack(this, findViewById<ImageView>(R.id.image_cg))
            changeIconTintToBlack(this, findViewById<ImageView>(R.id.image_jp))
            changeIconTintToBlack(this, findViewById<ImageView>(R.id.image_gm))
            changeIconTintToBlack(this, findViewById<ImageView>(R.id.image_ad))
            changeIconTintToBlack(this, findViewById<ImageView>(R.id.image_to))
            changeIconTintToBlack(this, findViewById<ImageView>(R.id.image_bm))
            changeIconTintToBlack(this, findViewById<ImageView>(R.id.image_gd))
            changeIconTintToBlack(this, findViewById<ImageView>(R.id.image_message))
            changeIconTintToBlack(this, findViewById<ImageView>(R.id.image_message_header))
            changeIconTintToBlack(this, findViewById<ImageView>(R.id.image_message_list))
            changeIconTintToBlack(this, findViewById<ImageView>(R.id.image_message_composer))
            changeIconTintToBlack(this, findViewById<ImageView>(R.id.image_message_information))
            changeIconTintToBlack(this, findViewById<ImageView>(R.id.image_call_button))
            changeIconTintToBlack(this, findViewById<ImageView>(R.id.image_audio))
            changeIconTintToBlack(this, findViewById<ImageView>(R.id.image_translate))
            changeIconTintToBlack(this, findViewById<ImageView>(R.id.image_avatar))
            changeIconTintToBlack(this, findViewById<ImageView>(R.id.image_badge_count))
            changeIconTintToBlack(this, findViewById<ImageView>(R.id.image_message_receipt))
            changeIconTintToBlack(this, findViewById<ImageView>(R.id.image_status_indicator))
            changeIconTintToBlack(this, findViewById<ImageView>(R.id.image_text_bubble))
            changeIconTintToBlack(this, findViewById<ImageView>(R.id.image_image_bubble))
            changeIconTintToBlack(this, findViewById<ImageView>(R.id.image_video_bubble))
            changeIconTintToBlack(this, findViewById<ImageView>(R.id.image_audio_bubble))
            changeIconTintToBlack(this, findViewById<ImageView>(R.id.image_file_bubble))
            changeIconTintToBlack(this, findViewById<ImageView>(R.id.image_form_bubble))
            changeIconTintToBlack(this, findViewById<ImageView>(R.id.image_card_bubble))
            changeIconTintToBlack(this, findViewById<ImageView>(R.id.image_scheduler_bubble))
            changeIconTintToBlack(this, findViewById<ImageView>(R.id.image_mic))
            changeIconTintToBlack(this, findViewById<ImageView>(R.id.image_list_item))
            Utils.setStatusBarColor(this, getResources().getColor(R.color.app_background))
            parentView!!.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.app_background)))
        }
    }

    private fun handleIntent(id: Int) {
        val intent = Intent(this, ComponentLaunchActivity::class.java)
        intent.putExtra("component", id)
        startActivity(intent)
    }
}