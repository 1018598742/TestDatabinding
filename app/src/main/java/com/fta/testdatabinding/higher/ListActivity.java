package com.fta.testdatabinding.higher;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.fta.testdatabinding.R;
import com.fta.testdatabinding.databinding.ActivityListBinding;
import com.fta.testdatabinding.moudle.NameMoudle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 对于recyclerview的数据绑定演示
 */
public class ListActivity extends AppCompatActivity {

    private ActivityListBinding mBinding;
    private FtaListAdapter ftaListAdapter;


    public class Presenter {
        public void onClickAddItem(View view) {
            Random random = new Random();
            int i = random.nextInt(100) + 4;
            ftaListAdapter.add(new NameMoudle("fta" + i, "hello" + i, false));
        }

        public void onClickRemoveItem(View view) {
            ftaListAdapter.remove();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_list);
        mBinding.setPresenter(new Presenter());

        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ftaListAdapter = new FtaListAdapter(this);
        mBinding.recyclerView.setAdapter(ftaListAdapter);
        ftaListAdapter.setOnItemClickListener(new FtaListAdapter.OnItemClickListener() {
            @Override
            public void onFtaClick(NameMoudle nameMoudle) {
                Toast.makeText(ListActivity.this, nameMoudle.getFirstName(), Toast.LENGTH_SHORT).show();
            }
        });

        List<NameMoudle> demoList = new ArrayList<>();
        demoList.add(new NameMoudle("fta1", "hello_1", false));
        demoList.add(new NameMoudle("fta2", "hello_2", false));
        demoList.add(new NameMoudle("fta3", "hello_3", true));
        demoList.add(new NameMoudle("fta4", "hello_4", false));

        ftaListAdapter.addAll(demoList);
    }
}
