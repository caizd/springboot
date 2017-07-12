package cn.caizhongdong.weixin;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 微信加密数据
 */
public class WxEncryptedData {
    private String rawData;

    private String iv;

    private String signature;

    private String encryptedData;
    
    public WxEncryptedData () {
    }
    
    public WxEncryptedData (String iv, String encryptedData) {
    	this.iv = iv;
    	this.encryptedData = encryptedData;
    }
    
    
    public WxUserInfoJson decrypt (String sessionKey) throws Exception {
    	//解密
    	String str = AESUtil.AESDecode(this.iv, sessionKey, this.encryptedData);
    	ObjectMapper mapper = new ObjectMapper();
    	return mapper.readValue(str, WxUserInfoJson.class);
    }


	public String getRawData() {
        return rawData;
    }

    public void setRawData(String rawData) {
        this.rawData = rawData;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }
}
