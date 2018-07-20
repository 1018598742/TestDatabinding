package com.fta.testdatabinding.twoway;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.fta.testdatabinding.R;
import com.fta.testdatabinding.databinding.ActivityTwowayBinding;
import com.fta.testdatabinding.moudle.FormModel;

/**
 * 双向绑定
 */
public class TwoWayActivity extends AppCompatActivity {

    private ActivityTwowayBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_twoway);
        mBinding.setModel(new FormModel("fta", "123456"));
    }
}
