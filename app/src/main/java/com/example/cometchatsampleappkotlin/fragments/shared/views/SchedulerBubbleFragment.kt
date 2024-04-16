package com.example.cometchatsampleappkotlin.fragments.shared.views

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cometchat.chat.constants.CometChatConstants
import com.cometchat.chatuikit.shared.cometchatuikit.CometChatUIKit
import com.cometchat.chatuikit.shared.models.interactiveactions.APIAction
import com.cometchat.chatuikit.shared.models.interactiveelements.ButtonElement
import com.cometchat.chatuikit.shared.models.interactivemessage.SchedulerMessage
import com.cometchat.chatuikit.shared.models.interactivemessage.TimeRange
import com.cometchat.chatuikit.shared.resources.theme.CometChatTheme
import com.cometchat.chatuikit.shared.views.CometChatAvatar.AvatarStyle
import com.cometchat.chatuikit.shared.views.CometChatQuickView.QuickViewStyle
import com.cometchat.chatuikit.shared.views.CometChatSchedulerBubble.CometChatSchedulerBubble
import com.cometchat.chatuikit.shared.views.CometChatSchedulerBubble.ScheduleStyle
import com.cometchat.chatuikit.shared.views.CometChatSchedulerBubble.SchedulerBubbleStyle
import com.cometchat.chatuikit.shared.views.calender.CalenderStyle
import com.cometchat.chatuikit.shared.views.timeslotitem.TimeSlotItemStyle
import com.cometchat.chatuikit.shared.views.timeslotselector.TimeSlotSelectorStyle
import com.example.cometchatsampleappkotlin.AppUtils
import com.example.cometchatsampleappkotlin.R
import com.google.android.material.card.MaterialCardView
import java.util.TimeZone

class SchedulerBubbleFragment : Fragment() {
    private lateinit var schedulerBubble: CometChatSchedulerBubble
    private lateinit var cardView: MaterialCardView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_scheduler_bubble, container, false)
        schedulerBubble = view.findViewById(R.id.scheduler_bubble)
        cardView = view.findViewById(R.id.scheduler_bubble_card)
        schedulerBubble.setStyle(schedulerBubbleStyle)
        schedulerBubble.setSchedulerMessage(schedulerMessage)
        cardView.setCardBackgroundColor(CometChatTheme.getInstance(context).palette.accent50)
        return view
    }

    private val schedulerBubbleStyle: SchedulerBubbleStyle
        get() {
            val theme = CometChatTheme.getInstance(context)
            val schedulerBubbleStyle = SchedulerBubbleStyle()
            schedulerBubbleStyle.setAvatarStyle(
                AvatarStyle().setOuterCornerRadius(100f)
                    .setInnerBackgroundColor(theme.palette.accent600)
                    .setTextColor(theme.palette.accent900).setTextAppearance(theme.typography.name)
            )
            schedulerBubbleStyle.setCalenderStyle(
                CalenderStyle().setTitleTextAppearance(theme.typography.name)
                    .setTitleTextColor(theme.palette.accent)
            )
            schedulerBubbleStyle.setTimeSlotSelectorStyle(
                TimeSlotSelectorStyle()
                    .setCalenderImageTint(theme.palette.accent)
                    .setEmptyTimeSlotIconColor(theme.palette.accent500)
                    .setChosenDateTextAppearance(theme.typography.subtitle1)
                    .setChosenDateTextColor(theme.palette.accent)
                    .setSeparatorColor(theme.palette.accent100)
                    .setTitleColor(theme.palette.accent)
                    .setTitleTextAppearance(theme.typography.name)
                    .setEmptyTimeSlotTextColor(theme.palette.accent500)
                    .setEmptyTimeSlotTextAppearance(theme.typography.text1)
            )
            schedulerBubbleStyle.setSlotStyle(
                TimeSlotItemStyle().setCornerRadius(20f).setBackground(theme.palette.background)
                    .setTimeColor(theme.palette.accent)
            )
            schedulerBubbleStyle.setSelectedSlotStyle(
                TimeSlotItemStyle().setCornerRadius(20f).setBackground(theme.palette.primary)
                    .setTimeColor(
                        Color.WHITE
                    )
            )
            schedulerBubbleStyle.setScheduleStyle(
                ScheduleStyle()
                    .setProgressBarTintColor(Color.WHITE)
                    .setButtonBackgroundColor(theme.palette.primary)
                    .setButtonTextColor(Color.WHITE)
                    .setCalendarIconTint(theme.palette.accent)
                    .setClockIconTint(theme.palette.accent)
                    .setTimeZoneIconTint(theme.palette.accent)
                    .setDurationTextColor(theme.palette.accent)
                    .setTimeTextColor(theme.palette.accent)
                    .setTimeZoneTextColor(theme.palette.accent)
                    .setErrorTextColor(theme.palette.error)
                    .setButtonTextAppearance(theme.typography.subtitle1)
                    .setErrorTextAppearance(theme.typography.caption1)
                    .setDurationTextAppearance(theme.typography.subtitle1)
                    .setTimeTextAppearance(theme.typography.subtitle1)
                    .setTimeZoneTextAppearance(theme.typography.subtitle1)
            )
            schedulerBubbleStyle.setTitleAppearance(theme.typography.heading)
            schedulerBubbleStyle.setNameAppearance(theme.typography.name)
            schedulerBubbleStyle.setNameColor(theme.palette.accent)
            schedulerBubbleStyle.setTitleColor(theme.palette.accent)
            schedulerBubbleStyle.setBackIconTint(theme.palette.primary)
            schedulerBubbleStyle.setSubtitleTextColor(theme.palette.accent600)
            schedulerBubbleStyle.setClockIconTint(theme.palette.accent600)
            schedulerBubbleStyle.setSubtitleTextAppearance(theme.typography.subtitle1)
            schedulerBubbleStyle.setSeparatorColor(theme.palette.accent100)
            schedulerBubbleStyle.setInitialSlotsItemStyle(
                TimeSlotItemStyle().setBackground(theme.palette.background)
                    .setTimeColor(theme.palette.primary)
                    .setTimeTextAppearance(theme.typography.subtitle2)
                    .setBorderColor(theme.palette.primary).setBorderWidth(2).setCornerRadius(25f)
            )
            schedulerBubbleStyle.setMoreTextColor(theme.palette.primary)
            schedulerBubbleStyle.setDurationTimeTextColor(theme.palette.accent500)
            schedulerBubbleStyle.setGlobeIconTint(theme.palette.accent)
            schedulerBubbleStyle.setTimeZoneTextColor(theme.palette.accent)
            schedulerBubbleStyle.setMoreTextAppearance(theme.typography.subtitle2)
            schedulerBubbleStyle.setDurationTimeTextAppearance(theme.typography.caption1)
            schedulerBubbleStyle.setTimeZoneTextAppearance(theme.typography.subtitle2)
            schedulerBubbleStyle.setQuickViewStyle(
                QuickViewStyle().setCornerRadius(16f).setBackground(theme.palette.background)
                    .setLeadingBarTint(theme.palette.primary).setTitleColor(theme.palette.accent)
                    .setTitleAppearance(theme.typography.text1)
                    .setSubtitleColor(theme.palette.accent500)
                    .setSubtitleAppearance(theme.typography.subtitle1)
            )
            schedulerBubbleStyle.setCornerRadius(10f)
            schedulerBubbleStyle.setQuickSlotAvailableAppearance(theme.typography.text1)
            schedulerBubbleStyle.setQuickSlotAvailableTextColor(theme.palette.accent500)
            schedulerBubbleStyle.setDisableColor(theme.palette.accent500)
            return schedulerBubbleStyle
        }
    private val schedulerMessage: SchedulerMessage
        get() {
            val schedulerMessage = SchedulerMessage()
            schedulerMessage.duration = 60
            schedulerMessage.isAllowSenderInteraction =
                true // true to set the sender as the scheduler
            schedulerMessage.title = "Meet Dr. Jackob"
            schedulerMessage.bufferTime = 15
            schedulerMessage.avatarUrl =
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRdRz0HEBl1wvncmX6rU8wFrRDxt2cvn2Dq9w&usqp=CAU"
            schedulerMessage.goalCompletionText = "Meeting Scheduled Successfully!!"
            val timeZone = TimeZone.getDefault()
            schedulerMessage.timezoneCode = timeZone.id
            schedulerMessage.dateRangeStart = "2024-01-01"
            schedulerMessage.dateRangeEnd = "2024-12-31"
            schedulerMessage.receiverUid = "superhero1"
            schedulerMessage.receiverType = CometChatConstants.RECEIVER_TYPE_USER
            schedulerMessage.sender = CometChatUIKit.getLoggedInUser()
            schedulerMessage.receiver = AppUtils.defaultUser
            val availability = HashMap<String, List<TimeRange>>()
            availability["monday"] = listOf(TimeRange("0000", "1359"))
            availability["tuesday"] = listOf(TimeRange("0000", "1559"))
            availability["wednesday"] = listOf(TimeRange("0000", "0659"))
            availability["thursday"] = listOf(TimeRange("0000", "0959"))
            availability["friday"] = listOf(TimeRange("0000", "1059"))
            schedulerMessage.availability = availability
            val clickAction = APIAction("https://www.example.com", "POST", "data")
            val scheduleElement = ButtonElement("21", "Submit", clickAction)
            schedulerMessage.scheduleElement = scheduleElement
            return schedulerMessage
        }
}