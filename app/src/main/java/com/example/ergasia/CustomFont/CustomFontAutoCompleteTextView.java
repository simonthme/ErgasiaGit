package com.example.ergasia.CustomFont;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

import com.example.ergasia.Helper.CustomFontHelper;

/**
 * Created by Margot on 13/05/2016.
 */
public class CustomFontAutoCompleteTextView extends AutoCompleteTextView {

    public CustomFontAutoCompleteTextView(Context context) {
        super(context);
    }

    public CustomFontAutoCompleteTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        CustomFontHelper.setCustomFont(this, context, attrs);
    }

    public CustomFontAutoCompleteTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        CustomFontHelper.setCustomFont(this, context, attrs);
    }
}
