package com.fta.testdatabinding;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.fta.testdatabinding.animation.AnimationActivity;
import com.fta.testdatabinding.custom.ExpressionActivity;
import com.fta.testdatabinding.databinding.ActivityMainBinding;
import com.fta.testdatabinding.higher.ListActivity;
import com.fta.testdatabinding.lambda.LambdaActivity;
import com.fta.testdatabinding.twoway.TwoWayActivity;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setPrenster(new Prenster());
    }


    public class Prenster {

        public void clickButton(View view) {
            switch (view.getId()) {
                case R.id.button1:
                    startActivity(new Intent(MainActivity.this, DemoActiviey.class));
                    break;
                case R.id.button2:
                    startActivity(new Intent(MainActivity.this, TwoWayActivity.class));
                    break;
                case R.id.button3:
                    startActivity(new Intent(MainActivity.this, ExpressionActivity.class));
                    break;
                case R.id.button5:
                    startActivity(new Intent(MainActivity.this, ListActivity.class));
                    break;
                case R.id.button6:
                    startActivity(new Intent(MainActivity.this, LambdaActivity.class));
                    break;
                case R.id.button7:
                    startActivity(new Intent(MainActivity.this, AnimationActivity.class));
                    break;

            }
        }
    }
}
