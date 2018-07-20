package com.fta.testdatabinding.animation;

import android.databinding.DataBindingUtil;
import android.databinding.OnRebindCallback;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

import com.fta.testdatabinding.R;
import com.fta.testdatabinding.databinding.ActivityAnimationBinding;

public class AnimationActivity extends AppCompatActivity {

    ActivityAnimationBinding animationBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        animationBinding = DataBindingUtil.setContentView(this, R.layout.activity_animation);

        animationBinding.addOnRebindCallback(new OnRebindCallback() {
            @Override
            public boolean onPreBind(ViewDataBinding binding) {
                ViewGroup viewGroup = (ViewGroup) binding.getRoot();
                TransitionManager.beginDelayedTransition(viewGroup);//api至少19
                return true;
            }
        });

        animationBinding.setPresenter(new Presenter());
    }

    public class Presenter {
        public void onCheckedChanged(View buttonView, boolean isChecked) {
            animationBinding.setShowImage(isChecked);
        }
    }
}
