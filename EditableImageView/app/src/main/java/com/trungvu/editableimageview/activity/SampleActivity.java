package com.trungvu.editableimageview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.trungvu.editableimageview.R;

/**
 * Created by thanhtrung.vu on 3/4/16.
 */
public class SampleActivity extends Activity {

    @Override
    public void onCreate(Bundle savedBundleInstance) {
        super.onCreate(savedBundleInstance);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.sample_activity);
    }
}
