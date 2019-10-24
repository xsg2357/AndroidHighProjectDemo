package com.alibaba.androidhighproject.litpal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.Base64;

import androidx.annotation.RequiresApi;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import sun.misc.BASE64Decoder;

/**
 * *******************************************
 * 标题 :                                     *
 * 编辑 : 向绍谷                               *
 * 日期 : 2019/10/23                             *
 * 描述 :                                     *
 * *******************************************
 */
public class Base64Util {
    //    static final String imageFile= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath()+"/CameraInit/my_photo.jpg";
    //图片转化成base64字符串
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static String GetImageStr(File imgFile) throws IOException {//将图片文件转化为字节数组字符串，并对其进行Base64编码处理
//        String imgFile = imageFile;//待处理的图片
        InputStream in = null;
        byte[] data = null;
        //读取图片字节数组
        try {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BASE64Decoder decoder = new BASE64Decoder();
        byte[] bytes = decoder.decodeBuffer(new String(data, StandardCharsets.UTF_8));

        //对字节数组Base64编码
//        BASE64Encoder encoder = new BASE64Encoder();
        return new String(bytes, StandardCharsets.UTF_8);//返回Base64编码过的字节数组字符串
//        return null;
    }

    //Bitmap—》Base64
    public static String Bitmap2StrByBase64(Bitmap bit) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bit.compress(Bitmap.CompressFormat.JPEG, 40, bos);//参数100表示不压缩
        byte[] bytes = bos.toByteArray();
        return Base64.encodeToString(bytes, Base64.DEFAULT);
    }


    public static boolean GenerateImage(String imageFile, String imgStr, Handler handler) {   //对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) //图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            //Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {//调整异常数据
                    b[i] += 256;
                }
            }
            File dir = new File(imageFile, "");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            //生成jpeg图片
            String imgFilePath = "22234.jpg";//新生成的图片
            File file = new File(dir, imgFilePath);
            OutputStream out = new FileOutputStream(file);
            Bitmap bitmap = BitmapFactory.decodeByteArray(b, 0, b.length);
            if (bitmap != null) {
                Message msg = new Message();
                msg.what = 123;
                msg.obj = bitmap;
                handler.sendMessage(msg);
            }

            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * bitmap转为base64
     *
     * @param bitmap
     * @return
     */
    public static String bitmapToBase64(Bitmap bitmap) {

        String result = null;
        ByteArrayOutputStream baos = null;
        try {
            if (bitmap != null) {
                baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);

                baos.flush();
                baos.close();

                byte[] bitmapBytes = baos.toByteArray();
                result = Base64.encodeToString(bitmapBytes, Base64.DEFAULT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.flush();
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * base64转为bitmap
     *
     * @param base64Data
     * @return
     */
    public static Bitmap base64ToBitmap(String base64Data) {
        byte[] bytes = Base64.decode(base64Data, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }

}
