package com.alibaba.androidhighproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.alibaba.androidhighproject.RxJava.binding.RxBindingTest1Act;
import com.alibaba.androidhighproject.adapter.MainContentAdapter;
import com.alibaba.androidhighproject.constraint.ConstraintMainAct;
import com.alibaba.androidhighproject.http.Api;
import com.alibaba.androidhighproject.http.ApiService;
import com.alibaba.androidhighproject.http.BaseObserver;
import com.alibaba.androidhighproject.jniStudy.JNIMenuActivity;
import com.alibaba.androidhighproject.litpal.ImageDercipActivity;
import com.alibaba.androidhighproject.recyclerrefresh.DiffRecyclerActivity;
import com.alibaba.androidhighproject.touchClick.TouchActivity;
import com.alibaba.androidhighproject.touchClick.TouchGroupActivity;
import com.alibaba.androidhighproject.websocket.WsMainActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private MainContentAdapter mAdapter;
    private List<String> mData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ListView lvMenu = findViewById(R.id.lv_menu);

        addMenu();
        mAdapter = new MainContentAdapter(this, mData);
        lvMenu.setAdapter(mAdapter);
        lvMenu.setOnItemClickListener(this);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
    }


    private void addMenu() {
        mData.add("touchClick:Android_View触摸事件传递机制");
        mData.add("touchClick:Android_ViewGroup触摸事件传递机制");
        mData.add("constraint（约束布局）");
        mData.add("RxBinding:RxBindingTest1Act");
        mData.add("OkHttp3:WebSocket");
        mData.add("RecyclerView最好的伙伴：AsyncListDiffer");
        mData.add("ImageDercip：图片解密");
        mData.add("JNI开发：入门");
        mData.add("JNI开发：入门1");
        mData.add("JNI开发：入门2");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (i == 0) {//touchClick:Android触摸事件传递机制
            startActivity(new Intent(this, TouchActivity.class));
        }
        if (i == 1) {//touchClick:Android_ViewGroup触摸事件传递机制
            startActivity(new Intent(this, TouchGroupActivity.class));
        }
        if (i == 2) {//constraint:相对位置 parent
            startActivity(new Intent(this, ConstraintMainAct.class));
        }
        if (i == 3) {//constraint:相对位置 parent
            startActivity(new Intent(this, RxBindingTest1Act.class));
        }
        if (i == 4) {//OkHttp3:WebSocket
            startActivity(new Intent(this, WsMainActivity.class));
        }
        if (i == 5) {//OkHttp3:Recycler_DIff
            startActivity(new Intent(this, DiffRecyclerActivity.class));
        }
        if (i == 6) {//OkHttp3:ImageDercip 图片解密
            startActivity(new Intent(this, ImageDercipActivity.class));
        }
        if (i == 7) {//JNI开发：入门
            startActivity(new Intent(this, JNIMenuActivity.class));
        }
        if (i == 8) {//JNI开发：入门
//            startActivity(new Intent(this, JNIMenuActivity.class));
            Map<String, Object> fl = new HashMap<>();

            Api instance = Api.getInstance();
            CompositeDisposable disposable = new CompositeDisposable();
            FormBody.Builder mBuild = new FormBody.Builder();
            mBuild
                    .add("scope", "order")
                    .add("grant_type", "client_credentials")
            ;
            RequestBody requestBodyPost = mBuild.build();
            Observable<JsonObject> login = instance.create(ApiService.class,0).login(requestBodyPost);
            disposable.add(login.subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new BaseObserver<JsonObject>() {
                        @Override
                        protected void onResultSuccess(JsonObject s) {
//                            Log.e("shit", "onResultSuccess: " + s);
                            Map<String, Object> fl = new HashMap<>();
                            Log.e("shit", "onResultSuccess: "+s.get("access_token") );
                            fl.put("access_token",s.get("access_token"));

                            Api instanceLL = Api.getInstance();
                            Observable<JsonObject> load = instanceLL.create(ApiService.class,1).load(fl);
                            disposable.add(load.subscribeOn(Schedulers.newThread())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribeWith(new BaseObserver<JsonObject>() {
                                        @Override
                                        protected void onResultSuccess(JsonObject s) {
                                            Log.e("shit", "onResultSuccess: " + s);
                                        }

                                        @Override
                                        protected void onResultError(Throwable e) {
                                            Log.e("shit", "onResultError: " + e.getLocalizedMessage());
                                        }
                                    }));
                        }

                        @Override
                        protected void onResultError(Throwable e) {
                            Log.e("shit", "onResultError: " + e.getLocalizedMessage());
                        }
                    }));
        }
        if (i == 9) {//JNI开发：入门
            startActivity(new Intent(this, JNIMenuActivity.class));
        }

    }
}
