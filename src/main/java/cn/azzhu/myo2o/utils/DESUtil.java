package cn.azzhu.myo2o.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.SecureRandom;

/**
 * DES是一种对称加密算法
 * 所谓对称加密算法即：加密和解密使用相同密钥的算法
 * @author azzhu
 * @create 2019-08-26 20:54:49
 */
public class DESUtil {

    private static Key key;
    //设置密码key
    private static String KEY_STR = "myKey";
    private static String CHARSETNAME = "UTF-8";
    private static String ALGORITHM = "DES";

    static {
        try {
            //生成DES算法对象
            KeyGenerator generator = KeyGenerator.getInstance(ALGORITHM);
            //运用SHA1安全策略
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            //设置上密钥种子
            secureRandom.setSeed(KEY_STR.getBytes());
            //初始化基于SHA1的算法对象
            generator.init(secureRandom);
            //生成密钥对象
            key = generator.generateKey();
            generator = null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取加密后的信息
     * @param str
     * @return
     */
    public static String getEncryptString(String str) {
        //基于BASE64编码，接收byte[]并转换成String
        BASE64Encoder base64Encoder = new BASE64Encoder();
        try {
            //接收UTF编码
            byte[] bytes = str.getBytes(CHARSETNAME);
            //获取加密对象
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            //初始化密码信息
            cipher.init(Cipher.ENCRYPT_MODE,key);
            //加密
            byte[] doFinal = cipher.doFinal(bytes);
            //byte[] to encode好的String并返回
            return base64Encoder.encode(doFinal);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取解密之后的信息
     * @param str
     * @return
     */
    public static String getDecryptString(String str) {
        //基于BASE64编码，接收byte[]并转换成String
        BASE64Decoder base64Decoder = new BASE64Decoder();
        try {
            //将字符串decode成byte[]
            byte[] bytes = base64Decoder.decodeBuffer(str);
            //获取解密对象
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            //初始化解密信息
            cipher.init(Cipher.ENCRYPT_MODE,key);
            //解密
            byte[] doFinal = cipher.doFinal(bytes);
            //返回解密之后的信息
            return new String(doFinal,CHARSETNAME);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(getEncryptString("root"));
        System.out.println(getEncryptString("123456"));
    }
}
