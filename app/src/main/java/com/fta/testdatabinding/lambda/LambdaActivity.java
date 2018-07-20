package com.fta.testdatabinding.lambda;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.fta.testdatabinding.R;
import com.fta.testdatabinding.databinding.ActivityLambdaBinding;
import com.fta.testdatabinding.moudle.NameMoudle;

public class LambdaActivity extends AppCompatActivity {

    public class Presenter {
        public void onNameModleClick(NameMoudle nameMoudle) {
            Toast.makeText(LambdaActivity.this, "onNameModleClick", Toast.LENGTH_SHORT).show();
        }

        public void onNameModleLongClick(NameMoudle nameMoudle, Context context) {
            Toast.makeText(LambdaActivity.this, "onNameModleLongClick", Toast.LENGTH_SHORT).show();
        }

        public void onFocusChange(NameMoudle nameMoudle) {
            Toast.makeText(LambdaActivity.this, "onFocusChange", Toast.LENGTH_SHORT).show();
        }
    }

    private ActivityLambdaBinding lambdaBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lambdaBinding = DataBindingUtil.setContentView(this, R.layout.activity_lambda);
        lambdaBinding.setModel(new NameMoudle("hello", "world"));
        lambdaBinding.setPresenter(new Presenter());

    }
}
