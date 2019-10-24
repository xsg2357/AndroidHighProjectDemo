package com.alibaba.androidhighproject.litpal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Base64;
import android.util.Base64InputStream;
import android.util.Base64OutputStream;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.androidhighproject.R;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * *******************************************
 * 标题 :                                     *
 * 编辑 : 向绍谷                               *
 * 日期 : 2019/10/12                             *
 * 描述 :                                     *
 * *******************************************
 */
public class ImageDercipActivity extends AppCompatActivity {

    private ImageView iv_decode;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decode_image);
        iv_decode = findViewById(R.id.iv_decode);

        try {
            new Thread(
                    () -> DownloadUtil.get().download("http://img.ytztgj.cn/uploads/20191014/9e93d9cfcf93a65e87d20c431aa792f3.jpg?m=b",
                            Environment.getExternalStorageDirectory().getAbsolutePath() + "/highImage", "test.jpg", new OnDownloadListener() {
                                @Override
                                public void onDownloadSuccess(File dataFile) {
                                    Log.e("shit", "onDownloadSuccess0: " + dataFile.getAbsolutePath());

                                    try {
                                        String  str = Base64Util.GetImageStr(dataFile);
                                        Log.e("shit", "onDownloadSuccess1: " + str);
                                        if (str.contains("ba2be2ef5db30c83b48d76109643a07d")) {
                                            str = str.replace("ba2be2ef5db30c83b48d76109643a07d", "");
                                        }
                                        Base64Util.GenerateImage(Environment.getExternalStorageDirectory().getAbsolutePath() + "/highImage1", str,handler);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }


                                    //                                    generateImage(dataFile.getAbsolutePath());
//                                     byte[] buffer = new byte[1024];
//
//
//                                    //            URL url = new URL(pathName);
//                                    //            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//                                    //            conn.setConnectTimeout(5 * 1000);
//                                    //            conn.setRequestMethod("GET");
//                                    //            InputStream is = conn.getInputStream();
//                                    //                                    InputStream is = getAssets().open(pathName);
//                                    try {
//                                        FileInputStream isf = new FileInputStream(dataFile);
//                                        Base64InputStream is = new Base64InputStream(isf,Base64.DEFAULT);
//
//                                        FileOutputStream fosf = new FileOutputStream(dataFile);
//                                        Base64OutputStream fos = new Base64OutputStream(fosf,Base64.DEFAULT);
//
//
//
////                                        java.util.Base64.Decoder decoder = java.util.Base64.getDecoder();
//                                        int byteCount;
//                                        while ((byteCount = is.read(buffer)) != -1) {
//                                            fos.write(buffer, 0, byteCount);
//                                        }
//
//
//
//                                      /*  String str;
//                                        StringBuilder strS = new StringBuilder();
//                                        BufferedReader bre ;
////                                      String file = "D:/test/test.txt";
//                                        bre = new BufferedReader(new FileReader(dataFile));//此时获取到的bre就是整个文件的缓存流
//                                        while ((str = bre.readLine()) != null) // 判断最后一行不存在，为空结束循环
//                                        {
//                                            System.out.println(str);//原样输出读到的内容
//                                            strS.append(str);
//                                        }
//                                        bre.close();*/
//                                        //            OutputStreamWriter oStreamWriter = new OutputStreamWriter(new FileOutputStream(dataFile), "utf-8");
//                                        //            oStreamWriter.append(desFirst);
////                                        String key = "9fua63ms0vcsdc04";
//                                        Log.e("shit", "filePath10:" + new String(buffer, StandardCharsets.UTF_8));
////                                        Log.e("shit", "filePath10:" + strS);
//                                        //            String key = "ba2be2ef5db30c83b48d76109643a07d";
//                                        //            String trans = "AES/CBC/PKCS5Padding";
//                                        //            String trans = "AES/ECB/PKCS5Padding";
//                                        //            byte[] bytes = EncryptUtil.decryptBase64EncodeData(buffer, key.getBytes(), key.getBytes(), trans);
//
//
//                                        byte[] decode = Base64.decode(buffer, Base64.DEFAULT);
////                                        byte[] decode = Base64.decode(strS.toString().getBytes(), Base64.DEFAULT);
////                                        byte[] decode = decoder.decode(buffer);
////                                        byte[] decode = MyBase64.decode(buffer);
////                                        byte[] decode = org.apache.commons.codec.binary.Base64.decodeBase64(buffer);
//                                        String desFirst = new String(decode, StandardCharsets.UTF_8);
//                                        Log.e("shit", "filePath1:" + desFirst);
//                                        //            oStreamWriter.close();
//                                        if (desFirst.contains("ba2be2ef5db30c83b48d76109643a07d")) {
//                                            desFirst = desFirst.replace("ba2be2ef5db30c83b48d76109643a07d", "");
//                                        }
//                                        Log.e("shit", "filePath12:" + desFirst);
////                                        byte[] decodeSecond = MyBase64.decode(desFirst.getBytes());
////                                        byte[] decodeSecond = org.apache.commons.codec.binary.Base64.decodeBase64(desFirst.getBytes());
//                                        byte[] decodeSecond = Base64.decode(desFirst.getBytes(), Base64.DEFAULT);
//
////                                        byte[] decodeSecond = decoder.decode(desFirst);
//                                        Log.e("shit", "filePath13:" + new String(decodeSecond, StandardCharsets.UTF_8));
//                                        Bitmap bitmap = BitmapFactory.decodeByteArray(decodeSecond, 0, decodeSecond.length);
//                                        if (bitmap != null) {
//                                            Message msg = new Message();
//                                            msg.what = 123;
//                                            msg.obj = bitmap;
//                                            handler.sendMessage(msg);
//                                        }
//
//                                        isf.close();
//                                        fosf.close();
//                                        is.close();
//                                        fos.close();

                                        //                                        iv_decode.setImageBitmap(bitmap);
//                                    } catch (FileNotFoundException e) {
//                                        e.printStackTrace();
//
//                                    } catch (IOException e) {
//                                        e.printStackTrace();
//                                    }

                                }

                                @Override
                                public void onDownloading(int progress) {
//                                    Log.e("shit", "onDownloading: " + progress);
                                }

                                @Override
                                public void onDownloadFailed(Exception e) {
                                    Log.e("shit", "onDownloading: " + e.getMessage());
                                }
                            })
            ).start();

            //获取asserts 某个文件路径的方法
//        String pathName = "9e93d9cfcf93a65e87d20c431aa792f3(1).jpg";
            String pathName = "9e93d9cfcf93a65e87d20c431aa792f3.jpg";
//        String pathName = "6221a66ab2c81bbd10e922b2e473356f_B.txt";
//        String pathName = "http://img.ytztgj.cn/uploads/20191014/9e93d9cfcf93a65e87d20c431aa792f3.jpg?m=b";
            File dataFile = new File(getCacheDir(), pathName);
//            Log.e("shit", "filePath:" + dataFile.getAbsolutePath());
//        String filePath = dataFile.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("shit", "Exception:" + e.getMessage());
        }


        //        Log.e("shit","fileEry:" + dataFile.getAbsolutePath());

        //        Resources resources = getResources();
//        AssetManager am = resources.getAssets();
//            String[] files = am.getLocales();
//            for (String file : files) {
//                Log.e("shit", file);
//            }

    }


    private boolean copyAssetAndWrite(String fileName) {
        try {
            File cacheDir = getCacheDir();
            if (!cacheDir.exists()) {
                cacheDir.mkdirs();
            }
            File outFile = new File(cacheDir, fileName);
            if (!outFile.exists()) {
                boolean res = outFile.createNewFile();
                if (!res) {
                    return false;
                }
            } else {
                if (outFile.length() > 10) {//表示已经写入一次
                    return true;
                }
            }
            InputStream is = getAssets().open(fileName);
            FileOutputStream fos = new FileOutputStream(outFile);
            byte[] buffer = new byte[1024];
            int byteCount;
            while ((byteCount = is.read(buffer)) != -1) {
                fos.write(buffer, 0, byteCount);
            }
            fos.flush();
            is.close();
            fos.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean generateImage(String imgStr) {
        if (imgStr == null) {
            return false;
        }

        // 文件输出流对象
        FileOutputStream outputStream = null;
        // 创建BufferedOutputStream对象
        BufferedOutputStream bufferedOutputStream = null;

        try {
//            byte[] decodeByteFirst = Base64.decode(imgStr, Base64.DEFAULT);
            byte[] decodeByteFirst = MyBase64.decode(imgStr);

            String desFirst = new String(decodeByteFirst);
            Log.e("shit", "filePath1:" + desFirst);
            if (desFirst.contains("ba2be2ef5db30c83b48d76109643a07d")) {
                desFirst = desFirst.replace("ba2be2ef5db30c83b48d76109643a07d", "");
            }


//            byte[] decodeByte = Base64.decode(desFirst, Base64.DEFAULT);
            byte[] decodeByte = MyBase64.decode(desFirst);

            File photoFile = new File(Environment.getExternalStorageDirectory() + "/myphoto");
            if (!photoFile.exists()) {
                photoFile.mkdirs();
            }

            File f = new File(photoFile, "uplpad.jpg");
            if (f.exists()) {
                f.delete();
            }
            // 在文件系统中根据路径创建一个新的空文件
            f.createNewFile();
            // 获取FileOutputStream对象
            outputStream = new FileOutputStream(f);
            // 获取BufferedOutputStream对象
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            // 往文件所在的缓冲输出流中写byte数据
            bufferedOutputStream.write(decodeByte);
            // 刷出缓冲输出流，该步很关键，要是不执行flush()方法，那么文件的内容是空的。
            bufferedOutputStream.flush();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭创建的流对象
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return false;
    }

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == 123) {
                Bitmap bitmap = (Bitmap) msg.obj;
                iv_decode.setImageBitmap(bitmap);
            }
            return false;
        }
    });

}
