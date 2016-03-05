package com.trungvu.editableimageview.component;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.trungvu.editableimageview.R;

/**
 * Created by thanhtrung.vu on 3/4/16.
 * Features:
 * * Move and drag
 * * Pinch in & out
 * * Rotate around center point
 * * Flip left/right & up/down
 * * Cut/crop with various styles
 */
public class EditableImageView extends FrameLayout implements View.OnTouchListener {

    private final static int MIN_LAYOUT_MARGIN = -250;

    protected ImageView mEditableImageContainer;

    protected ScaleGestureDetector mScaleGestureDetector;
    protected float mLastTouchX, mLastTouchY;
    protected int mDeltaX, mDeltaY;

    private ScaleListener mScaleListener;

    public EditableImageView(Context context) {
        this(context, null);
        initView(context);
    }

    public EditableImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        initView(context);
    }

    public EditableImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(context);
    }

    protected void initView(Context context) {
        mScaleListener = new ScaleListener();
        mScaleGestureDetector = new ScaleGestureDetector(context, mScaleListener);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.editable_image_view, this, true);
        mEditableImageContainer = (ImageView) findViewById(R.id.editable_image_container_view);
    }

    public void loadImage(String url) {
        if (mEditableImageContainer != null) {
            Uri uri = Uri.parse(url);
            mEditableImageContainer.setImageURI(uri);
        }
    }

    public void loadImage(int resourceId) {
        if (mEditableImageContainer != null) {
            mEditableImageContainer.setImageResource(resourceId);
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        final int currentX = (int) motionEvent.getRawX();
        final int currentY = (int) motionEvent.getRawY();
        switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN: {
                // Drag & move - START
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                mDeltaX = currentX - layoutParams.leftMargin;
                mDeltaY = currentY - layoutParams.topMargin;
                // Drag & move - END
                mLastTouchX = currentX;
                mLastTouchY = currentY;
                break;
            }
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                break;
            case MotionEvent.ACTION_POINTER_UP:
                mLastTouchX = currentX;
                mLastTouchY = currentY;
                break;
            case MotionEvent.ACTION_MOVE: {
                // Drag & move - START
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                layoutParams.leftMargin = currentX - mDeltaX;
                layoutParams.topMargin = currentY - mDeltaY;
                layoutParams.rightMargin = MIN_LAYOUT_MARGIN;
                layoutParams.bottomMargin = MIN_LAYOUT_MARGIN;
                // Drag & move - END
                view.setLayoutParams(layoutParams);
                mLastTouchX = currentX;
                mLastTouchY = currentY;
                break;
            }
        }
        view.invalidate();
        return true;
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            return super.onScale(detector);
        }
    }
}
