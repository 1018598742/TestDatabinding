package com.fta.testdatabinding.custom;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.fta.testdatabinding.R;
import com.fta.testdatabinding.databinding.ActivityExpressionBinding;
import com.fta.testdatabinding.moudle.NameMoudle;

import java.util.Random;

/**
 * 自定义属性的绑定
 * 链式更新
 * 隐式更新
 */
public class ExpressionActivity extends AppCompatActivity {

    ActivityExpressionBinding mBinding;

    Random random = new Random(System.currentTimeMillis());

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expression);

        NameMoudle nameMoudle = new NameMoudle("hello", "world", false);
        nameMoudle.setmIsFired(random.nextBoolean());
        nameMoudle.setAvatar("http://one89hcrr.bkt.clouddn.com/fashion0001.jpg");
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_expression);
        mBinding.setImage(nameMoudle);
    }
}
