package cipher;

/**
 *  Data Encryption Standard (DES) java
 *  	
 *
 *Author:PRAVEEN TALLURI  
 *
 */

public class DES extends BlockCipher64
{
	protected final static long M_6     = 0xFC0000000000L;
    protected final static long M_32  = 0xFFFFFFFFL;
    protected final static int  M_28    = 0x0FFFFFFF;
	protected final static int  Rounds  = 16;
	

    /**
     * Initial Permutation (IP) .
     */
    private final static byte[] IP =
    {
        58, 50, 42, 34, 26, 18, 10, 2,
        60, 52, 44, 36, 28, 20, 12, 4,
        62, 54, 46, 38, 30, 22, 14, 6,
        64, 56, 48, 40, 32, 24, 16, 8,
        57, 49, 41, 33, 25, 17, 9,  1,
        59, 51, 43, 35, 27, 19, 11, 3,
        61, 53, 45, 37, 29, 21, 13, 5,
        63, 55, 47, 39, 31, 23, 15, 7
    };

    /**
     *  Final Permutation (FP) .
     */
    private final static byte[] FP =
    {
        40, 8, 48, 16, 56, 24, 64, 32,
        39, 7, 47, 15, 55, 23, 63, 31,
        38, 6, 46, 14, 54, 22, 62, 30,
        37, 5, 45, 13, 53, 21, 61, 29,
        36, 4, 44, 12, 52, 20, 60, 28,
        35, 3, 43, 11, 51, 19, 59, 27,
        34, 2, 42, 10, 50, 18, 58, 26,
        33, 1, 41, 9, 49, 17, 57, 25
    };

    private final RoundKey k;
    private final FFunction f;

    /*
     * constructor
     */
     
    public DES(String sBoxesFileName)
    {
    	k = new RoundKey();
    	f = new FFunction(sBoxesFileName);
    }

    
    /**
     *  Encrypt the block using the given key
     */
    public long encrypt(long key, long block)
    {
    	return cipher(key, block, true);
    }

    /**
     * Decrypt the block using the given key
     */
    public long decrypt(long key, long block)
    {
    	return cipher(key, block, false);
    }


   

    /**
     * Operates on a 64 bit  block and generates round keys from 64 bit key.
     */
    private long cipher(long key, long block, boolean encrypt)
    {
    	long[] roundKeys = k.generateRoundKeys(key);
    	block = ip(block);

    	int left = (int) (block >> 32);	
    	int right = (int) block;		
    	int FOutput;

    
    	for (int i = 0; i < DES.Rounds; i++)
    	{
    		if (encrypt)
    			FOutput = f.F(right, roundKeys[i]);
    		else
    			FOutput = f.F(right, roundKeys[(DES.Rounds-1)-i]);
  
    		left ^= FOutput;
    		
  // swapping left and right halves 
    		left ^= right;
    		right ^= left;
    		left ^= right;
    	}

    	long join = ((right & M_32) << 32 | (left & M_32));

    	return fp(join);
    }

    /**
     * 64 bit permutation of input according to table IP.
     */
    private long ip(long input)
    {
    	return DES.gp(input, IP, 64);
    }

    /**
     *64 bit permutation of input according to table FP.
     */
    private long fp(long input)
    {
    	return DES.gp(input, FP, 64);
    }

    /**
     *  result of the permutation from the given table.
     */
    protected static long gp(long input, byte[] Table, int Length)
    {
        long output = 0;
        int index;

        for (byte anIndexTable : Table) {
            index = Length - anIndexTable;
            output = (output << 1) | ((input >> index) & 1);
        }

        return output;
    }
}