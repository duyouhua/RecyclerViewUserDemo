package cn.zeffect.demo.recyclerviewuserdemo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;

import java.util.LinkedList;
import java.util.List;

import cn.zeffect.demo.recyclerviewuserdemo.adapter.RVAdapter;

public class MainActivity extends Activity implements MainContract.MainView {
    RVAdapter mAdapter;
    List<String> mDatas;
    RecyclerView mRecyclerView;
    SpringView mSpringView;
    MainPrestenerImp mPrestenerImp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        //
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mSpringView = (SpringView) findViewById(R.id.springview);
        //
        mDatas = new LinkedList<>();
        mAdapter = new RVAdapter(mDatas);
        mAdapter.addHeaderView(LayoutInflater.from(this).inflate(R.layout.header, null));
        mAdapter.addFooterView(LayoutInflater.from(this).inflate(R.layout.footer, null));
        //
        mRecyclerView.setAdapter(mAdapter);
        //
        mPrestenerImp = new MainPrestenerImp(this);
        mPrestenerImp.getOneMessage();
        //
        mSpringView.setHeader(new DefaultHeader(this));
        mSpringView.setFooter(new DefaultFooter(this));
        mSpringView.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                mPrestenerImp.getOneMessage();
            }

            @Override
            public void onLoadmore() {
                mPrestenerImp.getOneMessage();
            }
        });
    }

    @Override
    public void addOneMessage(String pMessage) {
        mDatas.add(pMessage);
        mAdapter.notifyDataSetChanged();
        mSpringView.onFinishFreshAndLoad();
    }
}
