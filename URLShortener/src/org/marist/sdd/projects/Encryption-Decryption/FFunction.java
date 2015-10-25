package cipher;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

     /**
     * Feistel Function Implementation
     *  
     *  Author:PRAVEEN TALLURI
     */

class FFunction
{
    private static final byte[] Ep =    //Expansion Permutation
    {
        32, 1,  2,  3,  4,  5,
        4,  5,  6,  7,  8,  9,
        8,  9,  10, 11, 12, 13,
        12, 13, 14, 15, 16, 17,
        16, 17, 18, 19, 20, 21,
        20, 21, 22, 23, 24, 25,
        24, 25, 26, 27, 28, 29,
        28, 29, 30, 31, 32, 1
    };
    
    /**
     * S boxes
     */
    
    private static DataInputStream din;
   	public static Object main;
    public FFunction(String filename) {
    	FileInputStream fin = null;
		try {
			fin = new FileInputStream(filename);
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		}
    	BufferedInputStream bin = new BufferedInputStream(fin);
    	din = new DataInputStream(bin);
    	int boxNo = 0;
    	int row = 0;
    	int col = 0;
    	
    	byte[][][] sbox = new byte[8][4][16];
    	try {
			while(din.available()!=0){
				
			    String str = "";
				try {
					str = Integer.toBinaryString((char)din.read());
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
			    if(str.length() < 8){
			    	for(int len = str.length();len<8;len++){
			    		str = "0"+str;
			    	}
			    }
			    
			    
			    sbox[boxNo][row][col] =  (byte) Integer.parseInt(str.substring(0, 4),2);
			    sbox[boxNo][row][col+1] =  (byte) Integer.parseInt(str.substring(4, 8),2);
			    
			    col = col + 2;
			    if(col == 16){
			    	col = 0;
			    	row++;
			    }
			    
			    if(row ==4){
			    	row=0;
			    	col=0;
			    	boxNo++;
			    }
			    
			   
			    
			}
		} catch (NumberFormatException e1) {
			
			e1.printStackTrace();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
    	try {
			din.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	   try {
			fin.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	   S_BOX = Arrays.copyOf(sbox,sbox.length);
    }
 
       
    private final static byte[] P_BOX =  // Permutation Box 
    {
        16, 7,  20, 21,
        29, 12, 28, 17,
        1,  15, 23, 26,
        5,  18, 31, 10,
        2,  8,  24, 14,
        32, 27, 3,  9,
        19, 13, 30, 6,
        22, 11, 4,  25
    };
	private static  byte[][][] S_BOX = null;

	/**
	 * Given the 32 bit input and getting the index offsets as per expansion permutation table.
	 */
	
    private long expansion(int input)
    {
        return DES.gp(input, Ep, 32);
    }

    private byte SBoxSubstitution(int SBoxNum, byte input)
    {
    	byte row, col;
    	
    	row = (byte) (((input & 0x20) >> 4) | input & 0x01);
    	col = (byte) ((input & 0x1E) >> 1);

        return S_BOX[SBoxNum][row][col];
    }

    /**
     * giving permuted according to the permutation box .
     */
    private int PBoxPermutation(int input)  //  32 bit input
    {
        return (int) DES.gp(input, P_BOX, 32);
    }

    /**
     * giving 48 bit product into the 8 S-Boxes and getting a 32 bit output 
     */
    int F(int input, long roundKey)
    {
        long out = expansion(input);
        out ^= roundKey;

        int SBoxOut = 0;
        for (int i = 0; i < 8; i++)
        {
            SBoxOut <<= 4;
            SBoxOut |= SBoxSubstitution(i, (byte) ((out & DES.M_6) >> 42));
            out = out << 6;
        }

        return PBoxPermutation(SBoxOut);     //32 bit output of the P-Box permutation step.
    }
}
