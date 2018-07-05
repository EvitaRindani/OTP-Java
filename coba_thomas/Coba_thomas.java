
package coba_thomas;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
 

public class Coba_thomas {

   private final static String NAME = "Vernam Cipher";
	private final static char encryptionArr[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',' '};
    public Coba_thomas(){
    
    }
        
       public String generateKey(int length){
		if(length <= 0){
			return null;
		}
		String key = "";
		SecureRandom secureRandom = new SecureRandom();
		try {
			secureRandom = SecureRandom.getInstance("SHA1PRNG");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		//Builds the key.
		for(int i = 0; i < length; i++){
			int randomValue = secureRandom.nextInt(53);
			key += encryptionArr[randomValue];
		}
		return key;
	}

       
       
       
       
       
       
     public static String setNewKey(String s){
        int len = s.length();
        String x = "";
        int index = 0;
        for(int i = 0; i < len; i++){
            if(i >= len-5){
                x += s.charAt(i);
                index++;
            }
        }
        return x;
    }
    
    public static String setNewPlainText(String s){
        int len = s.length();
        String x = "";
        int index = 0;
        for(int i = 0; i < len; i++){
            if(i < 5){
                x += s.charAt(i);
                index++;
            }
        }
        return x;
    }  
       
       
       
       
       
       
       
       
       
       public String encrypt(String plainText, String key){
		//Make sure the key and the plainText are the same length.
		if(plainText.length() != key.length()){
			return null;
		}
		byte[] plainTextBytes = plainText.getBytes();
		byte[] keyBytes = key.getBytes();
		byte[] encryptedText = new byte[plainTextBytes.length];
		for(int i = 0; i < plainTextBytes.length; i++){
			encryptedText[i] = (byte) (keyBytes[i] ^ plainTextBytes[i]);
		}
		return new String(encryptedText);
	}
       public String decrypt(String cipherText, String key){
		//Make sure the key and the plainText are the same length.
		if(cipherText.length() != key.length()){
			return null;
		}
		byte[] cipherTextBytes = cipherText.getBytes();
		byte[] keyBytes = key.getBytes();
		byte[] decryptedText = new byte[cipherTextBytes.length];
		for(int i = 0; i < cipherTextBytes.length; i++){
			decryptedText[i] = (byte) (keyBytes[i] ^ cipherTextBytes[i]);
		}
		return new String(decryptedText);
       }
       public String getName(){
		return NAME;
	}
    
}
