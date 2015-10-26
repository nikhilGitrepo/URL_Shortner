package cipher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Cipher Block Chaining Mode 
 * 
 *Author:PRAVEEN TALLURI  
 *
 */
public class CBC implements BlockCipherMode {
	 BlockCipher bc;
	byte[] ivVector = new byte[8];
	
	public void setIV(byte[] iv) {
		
		ivVector = iv;
	}

	public void randomIV() {
		Random r = new Random();
	    r.nextBytes(ivVector);
		
	}

	public byte[] getIV() {
		if(ivVector.length == 0)
		randomIV();
		return ivVector;
	}

	public byte[] encrypt(byte[] key, byte[] plaintext) {
		//padding
	    
	    int n=0;  // n - no of bits need to padd
	    if (plaintext.length%8==0){
	   	 
	   	 n=64;  //1 block 

	    }
	    else
	    {
	   	 n= (8-plaintext.length%8)*8;
	   	 
	    }
	   
	    String str = "1";
	    
	    	 for(int i=0;i<n-1;i++){
	    		 
	    		 str=str+"0";
	    	 
	    	 }
	     
	         ArrayList<Integer> aList = new ArrayList<>();

	    	 for(String x : str.split("(?<=\\G.{8})"))
	    	     
	    	 aList.add(Integer.parseInt(x, 2));
	    	 
	    
	         byte[] paddingString = new byte[aList.size()];
	         
	         for(int i=0; i<aList.size(); i++){
	        	 
	             paddingString[i] = aList.get(i).byteValue();           
	         }
	    	  
	  
	         
	         // result = plain + padding
	    	 byte[] result = new byte[plaintext.length +   paddingString.length];

	    	 System.arraycopy(plaintext, 0, result, 0, plaintext.length);

	    	 System.arraycopy(paddingString, 0, result,plaintext.length,  paddingString.length);
	    	
	    	 System.out.println("padded str:" +Arrays.toString(result));
	    	 
	    	 
	    	 int noOfBlocks = result.length / 8; 
	    	 
	    	 byte[] singleBlock = new byte[8];
	    	 byte[] singleEncBlock = new byte[8];
	    	 byte[] xorBlock = new byte[8];
	    	 int j=0;
	    	 
	    	 
	    	 byte[] cipherBlocks = new byte[result.length];
	    	 
	    	 
	    	 byte[] XORbyte = getIV();
	    	
	    	 
	    	 for(int i=0;i<noOfBlocks;i++){
	    		 
	    		 
	    		 singleBlock = Arrays.copyOfRange(result, j, j+8);
	    		 
	    		 xorBlock = xorBytes(singleBlock,XORbyte);
	    		 
	    		 singleEncBlock= bc.encrypt(key, xorBlock);
	    		 
	    		 XORbyte = singleEncBlock;
	    		 
	    		 System.arraycopy(singleEncBlock, 0, cipherBlocks, j, singleEncBlock.length);
	    	
	    		 j = j+8;
	    		 
	    	 }
	    	 
		  
	    	 
	    	byte[] cipherReturn = new byte[cipherBlocks.length+ivVector.length];
	    	 
	    	 System.arraycopy(ivVector, 0, cipherReturn, 0, ivVector.length);

	    	 System.arraycopy(cipherBlocks, 0, cipherReturn,ivVector.length,  cipherBlocks.length);
	    		    
	    	 return cipherReturn;
	}

	public byte[] decrypt(byte[] key, byte[] ciphertext) {
		
		byte[] paddIV  = Arrays.copyOfRange(ciphertext, 0,8);
		 System.out.println("IV:" +Arrays.toString(paddIV));
		 byte[] singleBlock = new byte[8];
    	 byte[] singleDecBlock = new byte[8];
    	 byte[] xorBlock = new byte[8];
    	 byte[] XORbyte = paddIV;
    	 int j =8;
    	 int k = 0;
    	 byte[] decStream = new byte[ciphertext.length-paddIV.length];
    	 int noOfBlocks = (decStream.length) / 8;
    	
		for(int i=0;i<noOfBlocks;i++) {
			
			 singleBlock = Arrays.copyOfRange(ciphertext, j, j+8);
			
			 singleDecBlock= bc.decrypt(key, singleBlock);
			  
    		 xorBlock = xorBytes(singleDecBlock,XORbyte);
    		 
    		 XORbyte = singleBlock;
    		 
    		 System.arraycopy(xorBlock, 0, decStream, k, singleDecBlock.length);
    		 k = k+8;
    		 j = j+8;
		}
		
        int length = decStream.length;
        int findAt=0;
        for(int x=length-1;x>length-9;x--){

                if((byte)-0x80 == decStream[x])
                        findAt = x;

                
        }
        byte[] finalDecStream = Arrays.copyOfRange(decStream,0,findAt);

        return finalDecStream;
		
	}

	
	 public static byte[] xorBytes(byte[] b, byte[] l) {
			byte[] xor = new byte[b.length];
			 
			for (int i = 0; i < b.length; i++) {
				xor[i] = (byte) (((int)b[i]) ^ ((int)l[i]));
			
			}
			return xor;
	 }
	
	public CBC(BlockCipher blockcipher){
		 
		 bc= blockcipher;
		 
	 }
	 
	 
}