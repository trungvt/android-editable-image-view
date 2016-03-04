package com.trungvu.editableimageview.component;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
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

    private static final int INVALID_POINTER_ID = -1;

    protected int mActivePointerId = INVALID_POINTER_ID;
    protected ScaleGestureDetector mScaleGestureDetector;

    private ScaleListener mScaleListener;

    public EditableImageView(Context context) {
        this(context, null);
    }

    public EditableImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EditableImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mScaleListener = new ScaleListener();
        mScaleGestureDetector = new ScaleGestureDetector(context, mScaleListener);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mScaleGestureDetector.onTouchEvent(event);
        final int action = MotionEventCompat.getActionMasked(event);
        switch (action) {
            case MotionEvent.ACTION_POINTER_DOWN: {
                
                break;
            }
        }
        return true;
    }


    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            return super.onScale(detector);
        }
    }
}
