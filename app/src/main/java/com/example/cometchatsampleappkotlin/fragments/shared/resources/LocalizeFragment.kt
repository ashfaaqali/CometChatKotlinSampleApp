package com.example.cometchatsampleappkotlin.fragments.shared.resources

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.cometchat.chatuikit.shared.resources.Localise.CometChatLocalize
import com.cometchat.chatuikit.shared.resources.Localise.Language
import com.example.cometchatsampleappkotlin.AppUtils.changeTextColorToBlack
import com.example.cometchatsampleappkotlin.AppUtils.changeTextColorToWhite
import com.example.cometchatsampleappkotlin.AppUtils.isNightMode
import com.example.cometchatsampleappkotlin.R
import com.example.cometchatsampleappkotlin.activity.ComponentLaunchActivity

class LocalizeFragment : Fragment() {
    var parentView: LinearLayout? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_localize, container, false)
        val localizeIntro = view.findViewById<TextView>(R.id.localizeOverview)
        val language = view.findViewById<TextView>(R.id.language)
        val button = view.findViewById<AppCompatButton>(R.id.button)
        val radioGroup = view.findViewById<RadioGroup>(R.id.toggle)
        parentView = view.findViewById<LinearLayout>(R.id.parent_view)
        setUpUI(view)
        if (context != null) CometChatLocalize.setLocale(context, Language.Code.en)
        radioGroup.setOnCheckedChangeListener { radio: RadioGroup?, i: Int ->
            if (context != null) {
                if (i == R.id.english) {
                    localizeIntro.text = resources.getString(R.string.localize_english_overview)
                    language.text = resources.getString(R.string.language_english)
                    button.text = resources.getString(R.string.view_english)
                    CometChatLocalize.setLocale(
                        context,
                        Language.Code.en
                    ) //Localize UiKit to English
                } else if (i == R.id.hindi) {
                    localizeIntro.text = resources.getString(R.string.localize_hindi_overview)
                    language.text = resources.getString(R.string.language_hindi)
                    button.text = resources.getString(R.string.view_hindi)
                    CometChatLocalize.setLocale(
                        context,
                        Language.Code.hi
                    ) //Localize UiKit to Hindi
                }
            }
        }
        view.findViewById<View>(R.id.button).setOnClickListener { view1: View? ->
            val intent = Intent(
                activity,
                ComponentLaunchActivity::class.java
            )
            intent.putExtra("component", R.id.conversationWithMessages)
            startActivity(intent)
        }
        return view
    }

    private fun setUpUI(view: View) {
        if (isNightMode(requireContext())) {
            changeTextColorToWhite(context, view.findViewById<TextView>(R.id.localize_text))
            changeTextColorToWhite(context, view.findViewById<TextView>(R.id.localizeOverview))
            changeTextColorToWhite(context, view.findViewById<TextView>(R.id.language))
            parentView!!.setBackgroundTintList(
                ColorStateList.valueOf(
                    ContextCompat.getColor(
                        requireContext(), R.color.app_background_dark
                    )
                )
            )
        } else {
            changeTextColorToBlack(context, view.findViewById<TextView>(R.id.localize_text))
            changeTextColorToBlack(context, view.findViewById<TextView>(R.id.language))
            parentView!!.setBackgroundTintList(ColorStateList.valueOf(resources.getColor(R.color.app_background)))
        }
    }
}