package com.example.cometchatsampleappkotlin.fragments.shared.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cometchat.chatuikit.shared.resources.theme.CometChatTheme
import com.cometchat.chatuikit.shared.views.mediarecorder.CometChatMediaRecorder
import com.cometchat.chatuikit.shared.views.mediarecorder.MediaRecorderStyle
import com.example.cometchatsampleappkotlin.R

class MediaRecorderFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_media_recorder, container, false)
        val mediaRecorder = view.findViewById<CometChatMediaRecorder>(R.id.recorder)
        val cometChatTheme = CometChatTheme.getInstance(context)
        mediaRecorder.setStyle(
            MediaRecorderStyle()
                .setBackground(cometChatTheme.palette.background)
                .setBackground(cometChatTheme.palette.background)
                .setRecordedContainerColor(cometChatTheme.palette.accent100)
                .setPlayIconTint(cometChatTheme.palette.accent)
                .setPauseIconTint(cometChatTheme.palette.accent)
                .setStopIconTint(cometChatTheme.palette.error)
                .setVoiceRecordingIconTint(cometChatTheme.palette.error)
                .setRecordingChunkColor(cometChatTheme.palette.primary)
                .setTimerTextColor(cometChatTheme.palette.accent)
                .setTimerTextAppearance(cometChatTheme.typography.text1)
        )
        mediaRecorder.cardElevation = 10f
        mediaRecorder.radius = 16f
        return view
    }
}