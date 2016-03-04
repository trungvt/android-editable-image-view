package com.trungvu.editableimageview.component;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by thanhtrung.vu on 3/4/16.
 * Features:
 * * Move and drag
 * * Pinch in & out
 * * Rotate around center point
 * * Flip left/right & up/down
 * * Cut/crop with various styles
 */
public class EditableImageView extends ImageView {

    public EditableImageView(Context context) {
        this(context, null);
    }

    public EditableImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EditableImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
