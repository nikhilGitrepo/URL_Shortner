package cipher;

import java.util.Arrays;
/**
 * Cipher Block Chaining Mode 
 * 
 *Author:PRAVEEN TALLURI  
 *
 */

public class CBCmain {

public static void main(String[] args){
	
	
	 BlockCipher bc = new DES("sboxes_default");
	
	 CBC des = new CBC(bc);
	
    byte[] key = { (byte)0x6a, (byte)0x92, (byte)0x6b, (byte)0xfe, (byte)0x2a, (byte)0x29, (byte)0xfa, (byte)0xc3 };
    byte[] plaintext = { (byte)0x01, (byte)0x23, (byte)0x45, (byte)0x67, (byte)0x89, (byte)0xab, (byte)0xcd,(byte)0xef,(byte)0x01, (byte)0x23, (byte)0x45, (byte)0x67, (byte)0x89, (byte)0xab, (byte)0xcd};
	des.setIV(key);
    System.out.println("plain original:" +Arrays.toString(plaintext));
    
	 byte[]  enc =  des.encrypt(key, plaintext);
	 System.out.println("enc:" +Arrays.toString(enc));
	byte[] dec = des.decrypt(key, enc);

	 System.out.println("plain:" +Arrays.toString(dec));
	 
}
   	 
}


	

	



