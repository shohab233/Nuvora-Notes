package com.nuvora.notes.view

import android.content.Context
import android.util.AttributeSet
import android.view.WindowInsets
import android.widget.LinearLayout
import androidx.core.view.children
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import com.nuvora.notes.R

class NavigationView(context: Context, attrs: AttributeSet) : MaterialCardView(context, attrs) {

    var onItemClickListener: ((Int) -> Unit)? = null
    private lateinit var linearLayout: LinearLayout
    private val items = ArrayList<NavigationViewItem>()

    fun setCheckedItem(id: Int) {
        items.forEach { item ->
            item.isChecked = (item.id == id)
        }
    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        linearLayout = findViewById(R.id.LinearLayout)
        linearLayout.children.forEach { child ->
            if (child is NavigationViewItem) {
                items.add(child)
                child.setOnClickListener {
                    onItemClickListener?.invoke(child.id)
                }
            }
        }
    }

    override fun onApplyWindowInsets(insets: WindowInsets): WindowInsets {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            val systemBars = insets.getInsets(WindowInsets.Type.systemBars())
            linearLayout.setPadding(0, systemBars.top, 0, 0)
            return WindowInsets.CONSUMED
        } else {
            @Suppress("DEPRECATION")
            linearLayout.setPadding(0, insets.systemWindowInsetTop, 0, 0)
            @Suppress("DEPRECATION")
            return insets.consumeSystemWindowInsets()
        }
    }
}

class NavigationViewItem(context: Context, attrs: AttributeSet) : MaterialButton(context, attrs) {

    // Toggling is handled by the parent
    override fun toggle() {}
}