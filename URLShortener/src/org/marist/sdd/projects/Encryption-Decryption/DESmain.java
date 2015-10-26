
package cipher;


/**
 * Class to provide a interface to the DES algorithm.
 * 
 * Author:PRAVEEN TALLURI
 */
public class DESmain
{
    public static void main(String[] args)
    {
    		DES des = new DES("sboxes_default");
    		
    		long plaintext = 0x0123456789abcdefL;
    		
    		long key = 0x6a926bfe2a29fac3L;
    		
    		System.out.format("key: %016x%n", key);
    		
            long cipherText = des.encrypt(key,plaintext);
    
            System.out.format("cipher Text: %016x%n", cipherText);
            
            long  plainText = des.decrypt(key,cipherText);
           
            System.out.format("plain Text: %016x%n", plainText);
    
    
    }
}
