package cn.caizhongdong.weixin;

import java.security.AlgorithmParameters;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;

public class AESUtil {
	//算法名
    public static final String KEY_ALGORITHM = "AES";  
    //ECB模式只用密钥即可对数据进行加密解密，CBC模式需要添加一个参数iv
    public static final String CIPHER_ALGORITHM = "AES/CBC/PKCS7Padding";//加解密算法/模式/填充方式
	/**
	 * 微信密文解码，AES/CBC/PKCS7Padding
	 * @param iv
	 * @param sessionKey
	 * @param encryptedData
	 * @return
	 */
	public static String AESDecode(String iv, 
			String sessionKey,
			String encryptedData) throws Exception {
		// 用以支持AES/CBC/PKCS7Padding解码
		Security.addProvider(new BouncyCastleProvider());
		// 秘钥
		byte[] key = Base64.decode(sessionKey);
		// iv
		byte[] b = Base64.decode(iv);
		AlgorithmParameters ap = AlgorithmParameters.getInstance(KEY_ALGORITHM);
		ap.init(new IvParameterSpec(b));
		// 目标密文
		byte[] bData = Base64.decode(encryptedData);
		// 解码
		byte[] data = decrypt(bData, key, ap);
		return new String(data, "utf-8");
	}
      
    //解密
    private static byte[] decrypt(byte[] encryptedData,byte[] keyBytes,AlgorithmParameters iv) throws Exception{
    	SecretKey secretKey = new SecretKeySpec(keyBytes,KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);  
        //设置为解密模式  
        cipher.init(Cipher.DECRYPT_MODE, secretKey,iv);  
        return cipher.doFinal(encryptedData);  
    }  
      
}
