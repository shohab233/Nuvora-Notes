package com.nuvora.notes.activities

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CrashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val errorText = intent.getStringExtra("error_log") ?: "No error trace available."

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(32, 48, 32, 32)
            setBackgroundColor(0xFF1E1E2E.toInt())
        }

        val titleView = TextView(this).apply {
            text = "Nuvora Notes Diagnostic"
            textSize = 20f
            setTextColor(0xFFFFFFFF.toInt())
            setPadding(0, 0, 0, 24)
        }

        val copyButton = Button(this).apply {
            text = "Copy Error Log"
            setBackgroundColor(0xFF4F46E5.toInt())
            setTextColor(0xFFFFFFFF.toInt())
            setOnClickListener {
                val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clip = ClipData.newPlainText("Error Log", errorText)
                clipboard.setPrimaryClip(clip)
                Toast.makeText(this@CrashActivity, "Error copied to clipboard!", Toast.LENGTH_SHORT).show()
            }
        }

        val scrollView = ScrollView(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                0,
                1f
            )
        }

        val logView = TextView(this).apply {
            text = errorText
            textSize = 13f
            setTextColor(0xFFFAAFA9.toInt())
            setPadding(0, 24, 0, 24)
            setTextIsSelectable(true)
        }

        scrollView.addView(logView)
        layout.addView(titleView)
        layout.addView(copyButton)
        layout.addView(scrollView)

        setContentView(layout)
    }
}
