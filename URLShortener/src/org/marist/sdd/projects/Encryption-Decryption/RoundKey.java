package cipher;

/**
 * Round Keys Generation
 * 
 * Author:PRAVEEN TALLURI
 */

class RoundKey
{
    
    private final static byte[] P1 =      //Permutation Choice 1
    {
        57, 49, 41, 33, 25, 17, 9,
        1,  58, 50, 42, 34, 26, 18,
        10, 2,  59, 51, 43, 35, 27,
        19, 11, 3,  60, 52, 44, 36,
        63, 55, 47, 39, 31, 23, 15,
        7,  62, 54, 46, 38, 30, 22,
        14, 6,  61, 53, 45, 37, 29,
        21, 13, 5,  28, 20, 12, 4
    };

    private final static byte[] P2=   //Permutation Choice 2
    {
        14, 17, 11, 24, 1,  5,
        3,  28, 15, 6,  21, 10,
        23, 19, 12, 4,  26, 8,
        16, 7,  27, 20, 13, 2,
        41, 52, 31, 37, 47, 55,
        30, 40, 51, 45, 33, 48,
        44, 49, 39, 56, 34, 53,
        46, 42, 50, 36, 29, 32
    };

    /**
     *  no of left circular shifts 
     */
    private final static byte[] ncs =
    {
        1, 1, 2, 2,
        2, 2, 2, 2,
        1, 2, 2, 2,
        2, 2, 2, 1
    };


    /**
     *  circular left shift  implementation
     */
    private int CLS(int input, int s)
    {
    	return ((input << s) & DES.M_28) | (input >> (28 - s));
    }

    /**
     * taken 64 bit key input and return 56 bit selection of the original 64 bits.
     */
    private long PC1(long input)
    {
    	return DES.gp(input, P1, 64);
    }

    /**
     *  taken 56 bit of the original key input and return 48 bit selection of the 56 bit input.
     */
    private long PC2(long input)
    {
    	return DES.gp(input, P2, 56);
    }

    /**
     *generation of 58 bit round keys and stores in an array
     */
    long[] generateRoundKeys(long input)
    {
    	input = PC1(input);
    	int A = (int) (input >> 28);			
    	int B = (int) (input & DES.M_28);

    	long[] Keys = new long[DES.Rounds];
    	
    	for (int i = 0; i < DES.Rounds; i++)
    	{
    		A = CLS(A, ncs[i]);
    		B = CLS(B, ncs[i]);

    		long join = ((A & DES.M_32) << 28) | (B & DES.M_32);
    		Keys[i] = PC2(join);
    	}
    	return Keys;
    }
}
