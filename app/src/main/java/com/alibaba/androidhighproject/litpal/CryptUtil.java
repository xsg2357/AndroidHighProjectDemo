package com.alibaba.androidhighproject.litpal;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * *******************************************
 * 标题 :                                     *
 * 编辑 : 向绍谷                               *
 * 日期 : 2019/10/24                             *
 * 描述 :                                     *
 * *******************************************
 */
public class CryptUtil {
    private CryptUtil() {

    }

    // ---------------------
    // RSA密钥生成

    /**
     * RSA 加密，参数 key 可以是 公钥，或者 私钥；
     * <p/>
     * ！！！ 如果使用 私钥加密，那么只能够使用 公钥解密
     * 如果使用 公钥加密，那么只能够使用 私钥解密
     *
     * @param data
     * @param key
     * @return
     */
    public static byte[] rsaEncrypt(byte[] data, Key key) {
        byte[] ret = null;
        if (data != null && data.length > 0 && key != null) {
            try {
                Cipher cipher = Cipher.getInstance("RSA");

                cipher.init(Cipher.ENCRYPT_MODE, key);

                ret = cipher.doFinal(data);

            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (NoSuchPaddingException e) {
                e.printStackTrace();
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            } catch (BadPaddingException e) {
                e.printStackTrace();
            } catch (IllegalBlockSizeException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    public static byte[] rsaDecrypt(byte[] data, Key key) {
        byte[] ret = null;
        if (data != null && data.length > 0 && key != null) {
            try {
                Cipher cipher = Cipher.getInstance("RSA");

                cipher.init(Cipher.DECRYPT_MODE, key);

                ret = cipher.doFinal(data);

            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (NoSuchPaddingException e) {
                e.printStackTrace();
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            } catch (BadPaddingException e) {
                e.printStackTrace();
            } catch (IllegalBlockSizeException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    /**
     * 生成 RSA 密钥信息，参数就是生成的尺寸位数
     * 支持 1024, 2048, 4096
     *
     * @param keySize
     * @return
     */
    public static KeyPair generateRSAKey(int keySize) {
        KeyPair ret = null;

        // 1. 使用密钥生成器来创建
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA"); // RSA 算法

            // 设置密钥位数 也就是 n 的位数
            kpg.initialize(keySize);

            ret = kpg.generateKeyPair();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return ret;
    }


    // ---------------------
    // AES 加密，采用简单加密的算法，一个密码

    /**
     * AES 加密，采用一套密码的形式，密码长度支持 128bit
     *
     * @param data
     * @param password
     * @return
     */
    public static byte[] aesEncrypt(byte[] data, byte[] password) {
        byte[] ret = null;

        if (data != null && password != null) {
            if (data.length > 0 && password.length == 16) { // 128bit

                // 1. 创建 Cipher

                try {
                    Cipher cipher = Cipher.getInstance("AES");

                    // 2. 创建 AES 简单的密码 Key
                    SecretKeySpec key = new SecretKeySpec(password, "AES");

                    // 3. 初始化
                    cipher.init(Cipher.ENCRYPT_MODE, key);

                    ret = cipher.doFinal(data);

                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (NoSuchPaddingException e) {
                    e.printStackTrace();
                } catch (InvalidKeyException e) {
                    e.printStackTrace();
                } catch (BadPaddingException e) {
                    e.printStackTrace();
                } catch (IllegalBlockSizeException e) {
                    e.printStackTrace();
                }
            }
        }

        return ret;
    }

    public static byte[] aesDecrypt(byte[] data, byte[] password) {
        byte[] ret = null;

        if (data != null && password != null) {
            if (data.length > 0 && password.length == 16) { // 128bit

                // 1. 创建 Cipher

                try {
                    Cipher cipher = Cipher.getInstance("AES");

                    // 2. 创建 AES 简单的密码 Key
                    SecretKeySpec key = new SecretKeySpec(password, "AES");

                    // 3. 初始化
                    cipher.init(Cipher.DECRYPT_MODE, key);

                    ret = cipher.doFinal(data);

                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (NoSuchPaddingException e) {
                    e.printStackTrace();
                } catch (InvalidKeyException e) {
                    e.printStackTrace();
                } catch (BadPaddingException e) {
                    e.printStackTrace();
                } catch (IllegalBlockSizeException e) {
                    e.printStackTrace();
                }
            }
        }

        return ret;
    }

    // ---------------------

    /**
     * DESede 要求密码 24字节
     *
     * @param data
     * @param password
     * @return
     */
    public static byte[] desedeEncrypt(byte[] data, byte[] password) {
        // DESede 算法 Cipher
        // DESedeKeySpec

        byte[] ret = null;

        if (data != null && password != null) {
            // DESede
            if (data.length > 0 && password.length == 24) {

                // 1. 创建 Cipher ，用于加密和解密，就是一个内部的算法引擎
                // getInstance("加密的算法名称")
                try {

                    Cipher cipher = Cipher.getInstance("DESede");

                    // 3. 生成 Key 对象，根据不同的算法

                    DESedeKeySpec keySpec = new DESedeKeySpec(password);

                    // 3.2 使用密钥生成工具，来生成实际的 Key 对象
                    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");// 参数为算法名称

                    // 3.3 生成 Key

                    SecretKey secretKey = keyFactory.generateSecret(keySpec);

                    // 2. 初始化 Cipher，设置是加密模式还是解密模式，同时设置密码
                    // 通常第二个参数可以使用  Key 对象，每一种算法，Key对象的生成是不同的
                    cipher.init(Cipher.ENCRYPT_MODE, secretKey);

                    // 4. 进行加密或者解密的实际操作；
                    // 返回值就是最终的结果了
                    ret = cipher.doFinal(data);

                } catch (NoSuchAlgorithmException e) {  // 找不到算法的异常
                    e.printStackTrace();
                } catch (NoSuchPaddingException e) { //
                    e.printStackTrace();
                } catch (InvalidKeyException e) {  // 非法的密钥异常
                    e.printStackTrace();
                } catch (InvalidKeySpecException e) {
                    e.printStackTrace();
                } catch (BadPaddingException e) {
                    e.printStackTrace();
                } catch (IllegalBlockSizeException e) {
                    e.printStackTrace();
                }


            }
        }

        return ret;

    }

    public static byte[] desedeDecrypt(byte[] data, byte[] password) {
        byte[] ret = null;

        if (data != null && password != null) {
            // DESede 24字节
            if (data.length > 0 && password.length == 24) {

                // 1. 创建 Cipher ，用于加密和解密，就是一个内部的算法引擎
                // getInstance("加密的算法名称")
                try {

                    Cipher cipher = Cipher.getInstance("DESede");

                    // 3. 生成 Key 对象，根据不同的算法

                    DESedeKeySpec keySpec = new DESedeKeySpec(password);

                    // 3.2 使用密钥生成工具，来生成实际的 Key 对象
                    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");// 参数为算法名称

                    // 3.3 生成 Key

                    SecretKey secretKey = keyFactory.generateSecret(keySpec);

                    // 2. 初始化 Cipher，设置是加密模式还是解密模式，同时设置密码
                    // 通常第二个参数可以使用  Key 对象，每一种算法，Key对象的生成是不同的
                    cipher.init(Cipher.DECRYPT_MODE, secretKey);

                    // 4. 进行加密或者解密的实际操作；
                    // 返回值就是最终的结果了
                    ret = cipher.doFinal(data);

                } catch (NoSuchAlgorithmException e) {  // 找不到算法的异常
                    e.printStackTrace();
                } catch (NoSuchPaddingException e) { //
                    e.printStackTrace();
                } catch (InvalidKeyException e) {  // 非法的密钥异常
                    e.printStackTrace();
                } catch (InvalidKeySpecException e) {
                    e.printStackTrace();
                } catch (BadPaddingException e) {
                    e.printStackTrace();
                } catch (IllegalBlockSizeException e) {
                    e.printStackTrace();
                }


            }
        }

        return ret;
    }

    // ---------------------
    // 对称加密 DES 部分

    public static byte[] desEncrypt(byte[] data, byte[] password) {
        byte[] ret = null;

        if (data != null && password != null) {
            // DES 密码必须是8个字节；标准的描述是按位描述；必须是 64bit
            if (data.length > 0 && password.length == 8) {

                // 1. 创建 Cipher ，用于加密和解密，就是一个内部的算法引擎
                // getInstance("加密的算法名称")
                try {

                    Cipher cipher = Cipher.getInstance("DES");

                    // 3. 生成 Key 对象，根据不同的算法

                    DESKeySpec keySpec = new DESKeySpec(password);

                    // 3.2 使用密钥生成工具，来生成实际的 Key 对象
                    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");// 参数为算法名称

                    // 3.3 生成 Key

                    SecretKey secretKey = keyFactory.generateSecret(keySpec);

                    // 2. 初始化 Cipher，设置是加密模式还是解密模式，同时设置密码
                    // 通常第二个参数可以使用  Key 对象，每一种算法，Key对象的生成是不同的
                    cipher.init(Cipher.ENCRYPT_MODE, secretKey);

                    // 4. 进行加密或者解密的实际操作；
                    // 返回值就是最终的结果了
                    ret = cipher.doFinal(data);

                } catch (NoSuchAlgorithmException e) {  // 找不到算法的异常
                    e.printStackTrace();
                } catch (NoSuchPaddingException e) { //
                    e.printStackTrace();
                } catch (InvalidKeyException e) {  // 非法的密钥异常
                    e.printStackTrace();
                } catch (InvalidKeySpecException e) {
                    e.printStackTrace();
                } catch (BadPaddingException e) {
                    e.printStackTrace();
                } catch (IllegalBlockSizeException e) {
                    e.printStackTrace();
                }


            }
        }

        return ret;
    }


    public static byte[] desDecrypt(byte[] data, byte[] password) {
        byte[] ret = null;

        if (data != null && password != null) {
            // DES 密码必须是8个字节；标准的描述是按位描述；必须是 64bit
            if (data.length > 0 && password.length == 8) {

                // 1. 创建 Cipher ，用于加密和解密，就是一个内部的算法引擎
                // getInstance("加密的算法名称")
                try {

                    Cipher cipher = Cipher.getInstance("DES");

                    // 3. 生成 Key 对象，根据不同的算法

                    DESKeySpec keySpec = new DESKeySpec(password);

                    // 3.2 使用密钥生成工具，来生成实际的 Key 对象
                    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");// 参数为算法名称

                    // 3.3 生成 Key

                    SecretKey secretKey = keyFactory.generateSecret(keySpec);

                    // 2. 初始化 Cipher，设置是加密模式还是解密模式，同时设置密码
                    // 通常第二个参数可以使用  Key 对象，每一种算法，Key对象的生成是不同的
                    cipher.init(Cipher.DECRYPT_MODE, secretKey);

                    // 4. 进行加密或者解密的实际操作；
                    // 返回值就是最终的结果了
                    ret = cipher.doFinal(data);

                } catch (NoSuchAlgorithmException e) {  // 找不到算法的异常
                    e.printStackTrace();
                } catch (NoSuchPaddingException e) { //
                    e.printStackTrace();
                } catch (InvalidKeyException e) {  // 非法的密钥异常
                    e.printStackTrace();
                } catch (InvalidKeySpecException e) {
                    e.printStackTrace();
                } catch (BadPaddingException e) {
                    e.printStackTrace();
                } catch (IllegalBlockSizeException e) {
                    e.printStackTrace();
                }


            }
        }

        return ret;
    }


    // ---------------------
    // 编码解码部分；
    // Encode 编码
    // Decode 解码

    // Base64 -> 使用 android.util.Base64 就可以了，不需要

    // Hex 编码
    // 将字节数组每一个字节编码为十六进制字符串
    // 0x3C => "3c" "3C"
    // 0x5D => "5d" "5D"

    /**
     * Hex 编码
     *
     * @return
     */
    public static String hexEncode(byte[] data) {
        String ret = null;

        if (data != null) {

            StringBuilder sb = new StringBuilder();

            for (byte b : data) {

                int i = b & 0x0FF;

                String s = Integer.toHexString(i); // 消除符号，不用补码显示

                // 15 => "0F"

                if (i < 16) {
                    sb.append('0');
                }
                sb.append(s);

            }

            ret = sb.toString();

        }

        return ret;
    }

    public static byte[] hexDecode(String str) {
        byte[] ret = null;
        if (str != null) {
            int len = str.length();
            if (len > 0 && len % 2 == 0) {
                ret = new byte[len >> 1];
                int rLen = ret.length;

                for (int i = 0; i < rLen; i++) {
                    int start = i * 2;
                    // substring 第二个参数在 Android 中，代表 结束索引要求 + 1
                    // 因此 使用 start + 2 -> 包含了 start, start + 1;
                    String subStr = str.substring(start, start + 2); // start, end
                    int i1 = Integer.parseInt(subStr, 16);
                    ret[i] = (byte) i1;
                }
            }
        }
        return ret;
    }


    // ---------------------
}
