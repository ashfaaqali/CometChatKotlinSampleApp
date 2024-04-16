package com.example.cometchatsampleappkotlin.activity

import android.content.res.ColorStateList
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.cometchat.chatuikit.shared.resources.utils.Utils
import com.cometchat.javasampleapp.fragments.shared.views.BadgeCountFragment
import com.example.cometchatsampleappkotlin.AppUtils
import com.example.cometchatsampleappkotlin.fragments.calls.CallButtonFragment
import com.example.cometchatsampleappkotlin.R
import com.example.cometchatsampleappkotlin.fragments.shared.views.AudioBubbleFragment
import com.example.cometchatsampleappkotlin.fragments.shared.views.FileBubbleFragment
import com.example.cometchatsampleappkotlin.fragments.shared.views.VideoBubbleFragment
import com.example.cometchatsampleappkotlin.fragments.shared.views.CardBubbleFragment
import com.example.cometchatsampleappkotlin.fragments.shared.views.FormBubbleFragment
import com.example.cometchatsampleappkotlin.fragments.calls.CallLogDetailsFragment
import com.example.cometchatsampleappkotlin.fragments.calls.CallLogHistoryFragment
import com.example.cometchatsampleappkotlin.fragments.calls.CallLogParticipantsFragment
import com.example.cometchatsampleappkotlin.fragments.calls.CallLogRecordingFragment
import com.example.cometchatsampleappkotlin.fragments.calls.CallLogWithDetailsFragment
import com.example.cometchatsampleappkotlin.fragments.calls.CallLogsFragment
import com.example.cometchatsampleappkotlin.fragments.conversations.ContactsFragment
import com.example.cometchatsampleappkotlin.fragments.conversations.ConversationsFragment
import com.example.cometchatsampleappkotlin.fragments.conversations.ConversationsWithMessagesFragment
import com.example.cometchatsampleappkotlin.fragments.groups.AddMemberFragment
import com.example.cometchatsampleappkotlin.fragments.groups.BannedMembersFragment
import com.example.cometchatsampleappkotlin.fragments.groups.CreateGroupFragment
import com.example.cometchatsampleappkotlin.fragments.groups.GroupDetailsFragment
import com.example.cometchatsampleappkotlin.fragments.groups.GroupMembersFragment
import com.example.cometchatsampleappkotlin.fragments.groups.GroupsFragment
import com.example.cometchatsampleappkotlin.fragments.groups.GroupsWithMessagesFragment
import com.example.cometchatsampleappkotlin.fragments.groups.JoinProtectedGroupFragment
import com.example.cometchatsampleappkotlin.fragments.groups.TransferOwnershipFragment
import com.example.cometchatsampleappkotlin.fragments.messages.MessageComposerFragment
import com.example.cometchatsampleappkotlin.fragments.messages.MessageHeaderFragment
import com.example.cometchatsampleappkotlin.fragments.messages.MessageInformationFragment
import com.example.cometchatsampleappkotlin.fragments.messages.MessageListFragment
import com.example.cometchatsampleappkotlin.fragments.messages.MessagesFragment
import com.example.cometchatsampleappkotlin.fragments.shared.resources.LocalizeFragment
import com.example.cometchatsampleappkotlin.fragments.shared.resources.SoundManagerFragment
import com.example.cometchatsampleappkotlin.fragments.shared.resources.ThemeFragment
import com.example.cometchatsampleappkotlin.fragments.shared.views.AvatarFragment
import com.example.cometchatsampleappkotlin.fragments.shared.views.ImageBubbleFragment
import com.example.cometchatsampleappkotlin.fragments.shared.views.ListItemFragment
import com.example.cometchatsampleappkotlin.fragments.shared.views.MediaRecorderFragment
import com.example.cometchatsampleappkotlin.fragments.shared.views.MessageReceiptFragment
import com.example.cometchatsampleappkotlin.fragments.shared.views.SchedulerBubbleFragment
import com.example.cometchatsampleappkotlin.fragments.shared.views.StatusIndicatorFragment
import com.example.cometchatsampleappkotlin.fragments.shared.views.TextBubbleFragment
import com.example.cometchatsampleappkotlin.fragments.users.UserDetailsFragment
import com.example.cometchatsampleappkotlin.fragments.users.UsersFragment
import com.example.cometchatsampleappkotlin.fragments.users.UsersWithMessagesFragment

class ComponentLaunchActivity : AppCompatActivity() {
    private var parentView: LinearLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_component_launch)
        val id = intent.getIntExtra("component", 0)
        parentView = findViewById(R.id.container)
        setUpUI()
        when (id) {
            R.id.conversationWithMessages -> {
                loadFragment(ConversationsWithMessagesFragment())
            }
            R.id.conversations -> {
                loadFragment(ConversationsFragment())
            }
            R.id.userWithMessages -> {
                loadFragment(UsersWithMessagesFragment())
            }
            R.id.users -> {
                loadFragment(UsersFragment())
            }
            R.id.user_details -> {
                loadFragment(UserDetailsFragment())
            }
            R.id.groupWithMessages -> {
                loadFragment(GroupsWithMessagesFragment())
            }
            R.id.call_button -> {
                loadFragment(CallButtonFragment())
            }
            R.id.groups -> {
                loadFragment(GroupsFragment())
            }
            R.id.create_group -> {
                loadFragment(CreateGroupFragment())
            }
            R.id.join_protected_group -> {
                loadFragment(JoinProtectedGroupFragment())
            }
            R.id.group_member -> {
                loadFragment(GroupMembersFragment())
            }
            R.id.add_member -> {
                loadFragment(AddMemberFragment())
            }
            R.id.transfer_ownership -> {
                loadFragment(TransferOwnershipFragment())
            }
            R.id.banned_members -> {
                loadFragment(BannedMembersFragment())
            }
            R.id.group_details -> {
                loadFragment(GroupDetailsFragment())
            }
            R.id.messages -> {
                loadFragment(MessagesFragment())
            }
            R.id.messageList -> {
                loadFragment(MessageListFragment())
            }
            R.id.messageHeader -> {
                loadFragment(MessageHeaderFragment())
            }
            R.id.messageComposer -> {
                loadFragment(MessageComposerFragment())
            }
            R.id.avatar -> {
                loadFragment(AvatarFragment())
            }
            R.id.badgeCount -> {
                loadFragment(BadgeCountFragment())
            }
            R.id.messageReceipt -> {
                loadFragment(MessageReceiptFragment())
            }
            R.id.statusIndicator -> {
                loadFragment(StatusIndicatorFragment())
            }
            R.id.soundManager -> {
                loadFragment(SoundManagerFragment())
            }
            R.id.theme -> {
                loadFragment(ThemeFragment())
            }
            R.id.localize -> {
                loadFragment(LocalizeFragment())
            }
            R.id.list_item -> {
                loadFragment(ListItemFragment())
            }
            R.id.text_bubble -> {
                loadFragment(TextBubbleFragment())
            }
            R.id.image_bubble -> {
                loadFragment(ImageBubbleFragment())
            }
            R.id.video_bubble -> {
                loadFragment(VideoBubbleFragment())
            }
            R.id.audio_bubble -> {
                loadFragment(AudioBubbleFragment())
            }
            R.id.files_bubble -> {
                loadFragment(FileBubbleFragment())
            }
            R.id.form_bubble -> {
                loadFragment(FormBubbleFragment())
            }
            R.id.card_bubble -> {
                loadFragment(CardBubbleFragment())
            }
            R.id.scheduler_bubble -> {
                loadFragment(SchedulerBubbleFragment())
            }
            R.id.media_recorder -> {
                loadFragment(MediaRecorderFragment())
            }
            R.id.contacts -> {
                loadFragment(ContactsFragment())
            }
            R.id.messageInformation -> {
                loadFragment(MessageInformationFragment())
            }
            R.id.call_logs -> {
                loadFragment(CallLogsFragment())
            }
            R.id.call_logs_details -> {
                loadFragment(CallLogDetailsFragment())
            }
            R.id.call_logs_with_details -> {
                loadFragment(CallLogWithDetailsFragment())
            }
            R.id.call_log_participants -> {
                loadFragment(CallLogParticipantsFragment())
            }
            R.id.call_log_recording -> {
                loadFragment(CallLogRecordingFragment())
            }
            R.id.call_log_history -> {
                loadFragment(CallLogHistoryFragment())
            }
        }
    }

    private fun setUpUI() {
        if (AppUtils.isNightMode(this)) {
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
            Utils.setStatusBarColor(this, getResources().getColor(R.color.app_background))
            parentView!!.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.app_background)))
        }
    }

    private fun loadFragment(fragment: Fragment?) {
        if (fragment != null) {
            supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
        }
    }
}