package com.alibaba.androidhighproject.websocket;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.ScrollingView;

import com.alibaba.androidhighproject.R;
import com.alibaba.androidhighproject.websocket.listener.WsStatusListener;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Response;
import okio.ByteString;

public class WsMainActivity extends AppCompatActivity {

    private final static String TAG = "MainActivity";
    private WsManager wsManager;
    private TextView btn_send, btn_clear, tv_content;
    private Button btn_connect, btn_disconnect;
    private EditText edit_url, edit_content;
    private ScrollingView scrollingView;
    private WsStatusListener wsStatusListener = new WsStatusListener() {
        @Override
        public void onOpen(Response response) {
            Log.d(TAG, "WsManager-----onOpen");
            tv_content.append(Spanny.spanText("服务器连接成功\n\n", new ForegroundColorSpan(
                    ContextCompat.getColor(getBaseContext(), R.color.colorPrimary))));
        }

        @Override
        public void onMessage(String text) {
            Log.d(TAG, "WsManager-----onMessage");
            tv_content.append(Spanny
                    .spanText("服务器 " + DateUtils.formatDateTime(getBaseContext(), System.currentTimeMillis(),
                            DateUtils.FORMAT_SHOW_TIME) + "\n",
                            new ForegroundColorSpan(
                                    ContextCompat.getColor(getBaseContext(), R.color.colorPrimary))));
            tv_content.append(fromHtmlText(text) + "\n\n");
        }

        @Override
        public void onMessage(ByteString bytes) {
            Log.d(TAG, "WsManager-----onMessage");
        }

        @Override
        public void onReconnect() {
            Log.d(TAG, "WsManager-----onReconnect");
            tv_content.append(Spanny.spanText("服务器重连接中...\n", new ForegroundColorSpan(
                    ContextCompat.getColor(getBaseContext(), android.R.color.holo_red_light))));
        }

        @Override
        public void onClosing(int code, String reason) {
            Log.d(TAG, "WsManager-----onClosing");
            tv_content.append(Spanny.spanText("服务器连接关闭中...\n", new ForegroundColorSpan(
                    ContextCompat.getColor(getBaseContext(), android.R.color.holo_red_light))));
        }

        @Override
        public void onClosed(int code, String reason) {
            Log.d(TAG, "WsManager-----onClosed");
            tv_content.append(Spanny.spanText("服务器连接已关闭\n", new ForegroundColorSpan(
                    ContextCompat.getColor(getBaseContext(), android.R.color.holo_red_light))));
        }

        @Override
        public void onFailure(Throwable t, Response response) {
            Log.d(TAG, "WsManager-----onFailure");
            tv_content.append(Spanny.spanText("服务器连接失败\n", new ForegroundColorSpan(
                    ContextCompat.getColor(getBaseContext(), android.R.color.holo_red_light))));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ws_test);

        btn_send = findViewById(R.id.btn_send);
        btn_clear = findViewById(R.id.btn_clear);
        tv_content = findViewById(R.id.tv_content);
        btn_connect = findViewById(R.id.btn_connect);
        btn_disconnect = findViewById(R.id.btn_disconnect);
        edit_url = findViewById(R.id.edit_url);
        edit_content = findViewById(R.id.edit_content);
        btn_connect.setOnClickListener(v -> {
            String url = edit_url.getText().toString();
            if (!TextUtils.isEmpty(url) && url.contains("ws")) {
                if (wsManager != null) {
                    wsManager.stopConnect();
                    wsManager = null;
                }
                //设置socket，开始连接
                wsManager = new WsManager.Builder(getBaseContext())
                        .client(
                                new OkHttpClient().newBuilder()
                                        .pingInterval(15, TimeUnit.SECONDS)
                                        .retryOnConnectionFailure(true)
                                        .build())
                        .needReconnect(true)
                        .wsUrl(url)
                        .build();
                wsManager.setWsStatusListener(wsStatusListener);
                wsManager.startConnect();
            } else {
                Toast.makeText(getBaseContext(), "请填写需要链接的地址", Toast.LENGTH_SHORT).show();
            }
        });

        btn_disconnect.setOnClickListener(v -> {
            if (wsManager != null) {
                //断开连接
                wsManager.stopConnect();
                wsManager = null;
            }
        });

        btn_send.setOnClickListener(v -> {//发送内容到socket服务器
            String content = edit_content.getText().toString();
            if (!TextUtils.isEmpty(content)) {
                if (wsManager != null && wsManager.isWsConnected()) {
                    boolean isSend = wsManager.sendMessage(content);
                    if (isSend) {
                        tv_content.append(Spanny.spanText(
                                "我 " + DateUtils.formatDateTime(getBaseContext(), System.currentTimeMillis(),
                                        DateUtils.FORMAT_SHOW_TIME) + "\n", new ForegroundColorSpan(
                                        ContextCompat.getColor(getBaseContext(), android.R.color.holo_green_light))));
                        tv_content.append(content + "\n\n");
                    } else {
                        tv_content.append(Spanny.spanText("消息发送失败\n", new ForegroundColorSpan(
                                ContextCompat.getColor(getBaseContext(), android.R.color.holo_red_light))));
                    }
                    showOrHideInputMethod();
                    edit_content.setText("");
                } else {
                    Toast.makeText(getBaseContext(), "请先连接服务器", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getBaseContext(), "请填写需要发送的内容", Toast.LENGTH_SHORT).show();
            }
        });

        btn_clear.setOnClickListener(v -> tv_content.setText(""));
    }

    @Override
    protected void onDestroy() {
        if (wsManager != null) {
            wsManager.stopConnect();
            wsManager = null;
        }
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//    getMenuInflater().inflate(R.menu.menu_ws_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
     /* if (item.getItemId() == R.id.menu_source) {//调起浏览器更新app
          Intent intent = new Intent();
          intent.setAction("android.intent.action.VIEW");
          Uri url = Uri.parse("https://github.com/Rabtman/WsManager");
          intent.setData(url);
          startActivity(intent);
      }*/
        return super.onOptionsItemSelected(item);
    }

    // 解析网页
    private Spanned fromHtmlText(String s) {
        Spanned result;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            result = Html.fromHtml(s, Html.FROM_HTML_MODE_LEGACY);
        } else {
            result = Html.fromHtml(s);
        }
        return result;
    }

    // 显示或者隐藏软键盘
    private void showOrHideInputMethod() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

}
