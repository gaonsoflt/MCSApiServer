package com.gaonsoft.mcs.common.util.gaonnova;

import java.io.IOException;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


public class SimpleCrypto {
	
	public static String getKey(String svid){
    	String key = "1234567890123456";  // 16 bit 
    	
    	if(ConstType.AESKEY_LOGIN.key.equals(svid)){ 
    		//key = UUID.randomUUID().toString().replace("-", "").substring(0, 16); 
    	    key = "gaonsoft.1234567";  // 16 bit 
    	}
    	
    	if(ConstType.AESKEY_USER.key.equals(svid)){
    		key = "user.12345678901";  // 16 bit 
    	}
    	
    	return key;
    }

	// AES Encrypt (�븫�샇�솕)
    public static String aesEncrypt(String svid, String value){
		String aeskey = getKey(svid);
		
	    Key skey = makeAESKey(aeskey); // 16 湲��옄 = 16 x 8 = 128 bit
	    while(value.length() < 16) value=value+" "; // space char padding 	
		byte[] enc = value.getBytes() ;
		byte[] dec = aesEncode(enc, skey);     // key �븫�샇�솕
		value = byte2hex(dec);
    	
    	return value;
    }
    
    
    // AES Decrypt (蹂듯샇�솕)
    public static String aesDecrypt(String svid, String value){
		String aeskey = getKey(svid);
		
	    Key skey = makeAESKey(aeskey); // 16 湲��옄 = 16 x 8 = 128 bit
        byte[] enc =  toBytes(value.toString() , 16);
        byte[] dec =  aesDecode(enc, skey);             // �븘�씠�뵒 蹂듯샇�솕
        value = new String(dec).trim();
    	
    	return value;
    }
    
    //諛붿씠�듃瑜� 16吏꾩닔濡�
    public static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }

            if (n < b.length - 1) {
            }
        }
        return hs;
    }

    //Key�깮�꽦
    public static  Key makeAESKey(String sKey) {
        final byte[] key = sKey.getBytes();
        return new SecretKeySpec(key, "Rijndael");
    }

    //AES�븫�샇�솕
    public static  byte[] aesEncode(byte[] src, Key skey) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            //Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, skey);
            return cipher.doFinal(src);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //"DES/ECB/NoPadding"�쓣 "DES/ECB/PKCS5Padding"�쓣 諛붽씔�떎�쓬 �떎�뻾�빐蹂댁옄. 
    }

    //AES蹂듯샇�솕
    public static  byte[] aesDecode(byte[] src, Key skey) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            //Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skey);
            return cipher.doFinal(src);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //16吏꾩닔瑜� 諛붿씠�듃濡�
    public static  byte[] toBytes(String digits, int radix)
            throws IllegalArgumentException, NumberFormatException {
        if (digits == null) {
            return null;
        }
        if (radix != 16 && radix != 10 && radix != 8) {
            throw new IllegalArgumentException("For input radix: \"" + radix
                    + "\"");
        }
        int divLen = (radix == 16) ? 2 : 3;
        int length = digits.length();
        if (length % divLen == 1) {
            throw new IllegalArgumentException("For input string: \"" + digits
                    + "\"");
        }
        length = length / divLen;
        byte[] bytes = new byte[length];
        for (int i = 0; i < length; i++) {
            int index = i * divLen;
            bytes[i] = (byte) (Short.parseShort(digits.substring(index, index
                    + divLen), radix));
        }
        return bytes;
    }
    
 
    // base64 encoding 
    public static String encode64(String unencryptedString) throws Exception {
 
	 	//BASE64Decoder decoder = new BASE64Decoder();
	    BASE64Encoder encoder = new BASE64Encoder();
	    
	    //System.out.println("encodedBytes " + unencryptedString);
	    if(unencryptedString.equals(null)){
	    	return "";
	    }
	    
	    String encodedBytes = encoder.encodeBuffer(unencryptedString.getBytes());
	       
	      //byte[] decodedBytes = decoder.decodeBuffer(encodedBytes);
	      //System.out.println("decodedBytes " + new String(decodedBytes));
	    return encodedBytes;
    }
    
    // base64 decoding 
    public static String decode64(String unencryptedString) throws Exception {
 
	 	BASE64Decoder decoder = new BASE64Decoder();
	    //BASE64Encoder encoder = new BASE64Encoder();
	    String str = null ;
	    try {
	      //String encodedBytes = encoder.encodeBuffer(unencryptedString.getBytes());
	      //System.out.println("encodedBytes " + encodedBytes);
	      byte[] decodedBytes = decoder.decodeBuffer(unencryptedString);
	      //System.out.println("decodedBytes " + new String(decodedBytes));
	      str = new String(decodedBytes);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    
	    return str;
    } 
}