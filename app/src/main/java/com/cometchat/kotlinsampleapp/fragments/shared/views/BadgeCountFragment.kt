package com.cometchat.javasampleapp.fragments.shared.views

import android.content.res.ColorStateList
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.cometchat.chatuikit.shared.views.CometChatBadge.CometChatBadge
import com.cometchat.kotlinsampleapp.AppUtils
import com.cometchat.kotlinsampleapp.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class BadgeCountFragment : Fragment() {
    private var count = 1
    private lateinit var badgeCountLayout: TextInputLayout
    private lateinit var badgeCountEdt: TextInputEditText
    private lateinit var parentView: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_badge_count, container, false)
        val badgeCount = view.findViewById<CometChatBadge>(R.id.badgeCount)
        badgeCountLayout = view.findViewById<TextInputLayout>(R.id.badgeCountLayout)
        badgeCountEdt = view.findViewById<TextInputEditText>(R.id.badgeCountEdt)
        parentView = view.findViewById<LinearLayout>(R.id.parent_view)
        badgeCountEdt.setText(1.toString())
        badgeCountEdt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (charSequence.length > 0 && charSequence.length < 7) {
                    count = charSequence.toString().toInt()
                    badgeCount.count = count
                }
            }

            override fun afterTextChanged(editable: Editable) {}
        })
        view.findViewById<View>(R.id.bdRed).setOnClickListener {
            badgeCount.setBackground(
                resources.getColor(R.color.red)
            )
        }
        view.findViewById<View>(R.id.bdYellow).setOnClickListener {
            badgeCount.setBackground(
                resources.getColor(R.color.yellow)
            )
        }
        view.findViewById<View>(R.id.bdPurple).setOnClickListener {
            badgeCount.setBackground(
                resources.getColor(R.color.purple)
            )
        }
        view.findViewById<View>(R.id.bdGreen).setOnClickListener {
            badgeCount.setBackground(
                resources.getColor(R.color.green)
            )
        }
        view.findViewById<View>(R.id.bdBlue).setOnClickListener {
            badgeCount.setBackground(
                resources.getColor(R.color.blue)
            )
        }
        view.findViewById<View>(R.id.bdViolet).setOnClickListener {
            badgeCount.setBackground(
                resources.getColor(R.color.violet)
            )
        }
        setUpUI(view)
        return view
    }

    private fun setUpUI(view: View) {
        if (AppUtils.isNightMode(requireContext())) {
            AppUtils.changeTextColorToWhite(requireContext(), view.findViewById(R.id.badge_count_text_desc))
            AppUtils.changeTextColorToWhite(requireContext(), view.findViewById(R.id.badge_count_text))
            badgeCountLayout.setBoxStrokeColorStateList(
                ColorStateList.valueOf(
                    resources.getColor(
                        R.color.white
                    )
                )
            )
            badgeCountLayout.hintTextColor =
                ColorStateList.valueOf(resources.getColor(R.color.white))
            badgeCountLayout.editText!!.setTextColor(ColorStateList.valueOf(resources.getColor(R.color.white)))
            parentView.setBackgroundTintList(
                ColorStateList.valueOf(
                    ContextCompat.getColor(
                        requireContext(), R.color.app_background_dark
                    )
                )
            )
        } else {
            AppUtils.changeTextColorToBlack(requireContext(), view.findViewById(R.id.avatar_text))
            AppUtils.changeTextColorToBlack(requireContext(), view.findViewById(R.id.avatar_text_toggle))
            AppUtils.changeTextColorToBlack(requireContext(), view.findViewById(R.id.loggedInUserName))
            parentView.setBackgroundTintList(ColorStateList.valueOf(resources.getColor(R.color.app_background)))
        }
    }
}
