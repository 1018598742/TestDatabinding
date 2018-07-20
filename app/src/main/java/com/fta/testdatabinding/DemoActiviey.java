package com.fta.testdatabinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.fta.testdatabinding.databinding.ActivityDemoBinding;
import com.fta.testdatabinding.moudle.NameMoudle;

public class DemoActiviey extends AppCompatActivity {

    private NameMoudle nameMoudle = new NameMoudle("hello", "world");

    private ActivityDemoBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_demo);
        binding.setFta(nameMoudle);
        binding.setPresenter(new Presenter());
        binding.viewStub.getViewStub().inflate();
    }

    public class Presenter {

        //第一种绑定方式，方法引用
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            nameMoudle.setFirstName(s.toString());
            nameMoudle.setmIsFired(!nameMoudle.mIsFired.get());
        }

        public void onClick(View view) {
            Toast.makeText(DemoActiviey.this, "点到了", Toast.LENGTH_SHORT).show();
        }

        //第二种绑定方式，监听器绑定
        public void onClickListenerBinding(NameMoudle nameMoudle) {
            Toast.makeText(DemoActiviey.this, "点到了" + nameMoudle.getLastName(), Toast.LENGTH_SHORT).show();
        }
    }
}
