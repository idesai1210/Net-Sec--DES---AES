import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;


public class simple_des {
	
	static final int[] S = {
		14,  4, 13,  1,  2, 15, 11,  8,  3, 10,  6, 12,  5,  9,  0,  7, // S1
		 0, 15,  7,  4, 14,  2, 13,  1, 10,  6, 12, 11,  9,  5,  3,  8,
		 4,  1, 14,  8, 13,  6,  2, 11, 15, 12,  9,  7,  3, 10,  5,  0,
		15, 12,  8,  2,  4,  9,  1,  7,  5, 11,  3, 14, 10,  0,  6, 13,
		15,  1,  8, 14,  6, 11,  3,  4,  9,  7,  2, 13, 12,  0,  5, 10, // S2
		 3, 13,  4,  7, 15,  2,  8, 14, 12,  0,  1, 10,  6,  9, 11,  5,
		 0, 14,  7, 11, 10,  4, 13,  1,  5,  8, 12,  6,  9,  3,  2, 15,
		13,  8, 10,  1,  3, 15,  4,  2, 11,  6,  7, 12,  0,  5, 14,  9,
		10,  0,  9, 14,  6,  3, 15,  5,  1, 13, 12,  7, 11,  4,  2,  8, // S3
		13,  7,  0,  9,  3,  4,  6, 10,  2,  8,  5, 14, 12, 11, 15,  1,
		13,  6,  4,  9,  8, 15,  3,  0, 11,  1,  2, 12,  5, 10, 14,  7,
		 1, 10, 13,  0,  6,  9,  8,  7,  4, 15, 14,  3, 11,  5,  2, 12,
		 7, 13, 14,  3,  0,  6,  9, 10,  1,  2,  8,  5, 11, 12,  4, 15, // S4
		13,  8, 11,  5,  6, 15,  0,  3,  4,  7,  2, 12,  1, 10, 14,  9,
		10,  6,  9,  0, 12, 11,  7, 13, 15,  1,  3, 14,  5,  2,  8,  4,
		 3, 15,  0,  6, 10,  1, 13,  8,  9,  4,  5, 11, 12,  7,  2, 14,
		 2, 12,  4,  1,  7, 10, 11,  6,  8,  5,  3, 15, 13,  0, 14,  9, // S5
		14, 11,  2, 12,  4,  7, 13,  1,  5,  0, 15, 10,  3,  9,  8,  6,
		 4,  2,  1, 11, 10, 13,  7,  8, 15,  9, 12,  5,  6,  3,  0, 14,
		11,  8, 12,  7,  1, 14,  2, 13,  6, 15,  0,  9, 10,  4,  5,  3,
		12,  1, 10, 15,  9,  2,  6,  8,  0, 13,  3,  4, 14,  7,  5, 11, // S6
		10, 15,  4,  2,  7, 12,  9,  5,  6,  1, 13, 14,  0, 11,  3,  8,
		 9, 14, 15,  5,  2,  8, 12,  3,  7,  0,  4, 10,  1, 13, 11,  6,
		 4,  3,  2, 12,  9,  5, 15, 10, 11, 14,  1,  7,  6,  0,  8, 13,
		 4, 11,  2, 14, 15,  0,  8, 13,  3, 12,  9,  7,  5, 10,  6,  1, // S7
		13,  0, 11,  7,  4,  9,  1, 10, 14,  3,  5, 12,  2, 15,  8,  6,
		 1,  4, 11, 13, 12,  3,  7, 14, 10, 15,  6,  8,  0,  5,  9,  2,
		 6, 11, 13,  8,  1,  4, 10,  7,  9,  5,  0, 15, 14,  2,  3, 12,
		13,  2,  8,  4,  6, 15, 11,  1, 10,  9,  3, 14,  5,  0, 12,  7, // S8
		 1, 15, 13,  8, 10,  3,  7,  4, 12,  5,  6, 11,  0, 14,  9,  2,
		 7, 11,  4,  1,  9, 12, 14,  2,  0,  6, 10, 13, 15,  3,  5,  8,
		 2,  1, 14,  7,  4, 10,  8, 13, 15, 12,  9,  0,  3,  5,  6, 11
		   };
	
	static final int[] PC1 = {
	      57, 49, 41, 33, 25, 17,  9,
	       1, 58, 50, 42, 34, 26, 18,
	      10,  2, 59, 51, 43, 35, 27,
	      19, 11,  3, 60, 52, 44, 36,
	      63, 55, 47, 39, 31, 23, 15,
	       7, 62, 54, 46, 38, 30, 22,
	      14,  6, 61, 53, 45, 37, 29,
	      21, 13,  5, 28, 20, 12,  4
	   };
	   static final int[] PC2 = {
	      14, 17, 11, 24,  1,  5,
	       3, 28, 15,  6, 21, 10,
	      23, 19, 12,  4, 26,  8,
	      16,  7, 27, 20, 13,  2,
	      41, 52, 31, 37, 47, 55,
	      30, 40, 51, 45, 33, 48,
	      44, 49, 39, 56, 34, 53,
	      46, 42, 50, 36, 29, 32
	   };
	   static final int[] SHIFTS = {
	      1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1
	   };
	   
	   static final int[] IP = {
		      58, 50, 42, 34, 26, 18, 10, 2,
		      60, 52, 44, 36, 28, 20, 12, 4,
		      62, 54, 46, 38, 30, 22, 14, 6,
		      64, 56, 48, 40, 32, 24, 16, 8,
		      57, 49, 41, 33, 25, 17,  9, 1,
		      59, 51, 43, 35, 27, 19, 11, 3,
		      61, 53, 45, 37, 29, 21, 13, 5,
		      63, 55, 47, 39, 31, 23, 15, 7
		   };
		   static final int[] E = {
		      32,  1,  2,  3,  4,  5,
		       4,  5,  6,  7,  8,  9,
		       8,  9, 10, 11, 12, 13,
		      12, 13, 14, 15, 16, 17,
		      16, 17, 18, 19, 20, 21,
		      20, 21, 22, 23, 24, 25,
		      24, 25, 26, 27, 28, 29,
		      28, 29, 30, 31, 32,  1
		   };
		   static final int[] P = {
		      16,  7, 20, 21,
		      29, 12, 28, 17,
		       1, 15, 23, 26,
		       5, 18, 31, 10,
		       2,  8, 24, 14,
		      32, 27,  3,  9,
		      19, 13, 30,  6,
		      22, 11,  4, 25
		   };
		   static final int[] INVP = {
		      40, 8, 48, 16, 56, 24, 64, 32,
		      39, 7, 47, 15, 55, 23, 63, 31,
		      38, 6, 46, 14, 54, 22, 62, 30,
		      37, 5, 45, 13, 53, 21, 61, 29,
		      36, 4, 44, 12, 52, 20, 60, 28,
		      35, 3, 43, 11, 51, 19, 59, 27,
		      34, 2, 42, 10, 50, 18, 58, 26,
		      33, 1, 41,  9, 49, 17, 57, 25
		   };
	
	
	public static void main(String[] args) throws UnsupportedEncodingException, NumberFormatException{
		
		try{
			Scanner sc = new Scanner(System.in);
		
		String string_message, string_key;
		//String h_intermediate;
		byte message[],key[];
		
		/*byte [] subKey1 = subKeys[0];
		for (int i=0; i<subKey1.length; i++) {
	         System.out.print(byteToBits(subKey1[i])+" ");
	      }
		*/
		System.out.println();
		System.out.println("--------------");
		int input = 0;
		do{
			
			System.out.println("Enter the text: ");
			string_message =  sc.next();
			//h_intermediate = stringToHex(string_message);
			message = parseBytes(string_message);
			String message_hex = hex(message);
			System.out.println("The message in hex is: "+message_hex);
			String message_bin = hexToBin(string_message);
			//System.out.println("The message in binary is:" +message_bin);
			
			System.out.println("Enter the key in hex: ");
			string_key = sc.next();
			key = parseBytes(string_key);
			String key_hex = hex(key);
			System.out.println("The key in hex is: "+key_hex );
			
			//long key_bin = getLongFromBytes(key,0);
			String key_bin = hexToBin(string_key);
			//System.out.println("The key in binary is:  "+key_bin);
			
			
			byte[][] subKeys = getSubkeys(key);
			
			
			
			System.out.println("1. Encrypt");
			System.out.println("2.Decrypt");
			System.out.println("3. Exit");
			System.out.println("Enter your choice: ");
			input = sc.nextInt();
			
			System.out.println("--------------");
			
			
			
			if(input == 1){
				
				byte[] final_message = cipher(message,subKeys,"encrypt");
				System.out.println();
				String final_ans = hex(final_message);
				System.out.println("The Final answer after encryption is: "+final_ans);
			}
			else if(input == 2){
				byte[] final_message = cipher(message,subKeys,"decrypt");
				System.out.println();
				String final_ans = hex(final_message);
				System.out.println("The Final answer decryption is: "+final_ans);
			}
			else{
				System.exit(0);
			}
			
		}while(input !=3);
		/*byte[] theCph = cipher(message,subKeys,"decrypt");
		for (int i=0; i<theCph.length; i++) {
	         System.out.print(byteToBits(theCph[i])+" ");
	      }
		*/

		
		}
		
		
		catch(Exception e){
			 e.printStackTrace();
		}
		
		
		
		//ArrayList<int[]>  subKeys= new ArrayList<int[]>();
	//	subKeys = createSubkeys(key_bin);
		
		/*int[] k1 = new int[48];
		k1 = subKeys.get(0);
		
		System.out.println();
		System.out.println("--------subkey1");
		for(int i = 0;i<k1.length;i++){
			System.out.print(k1[i]);
		}
		*/
		
		//encodeMessage(message_bin,subKeys);
		
	}
	private static String byteToBits(byte b) {
	      StringBuffer buf = new StringBuffer();
	      for (int i=0; i<8; i++)
	         buf.append((int)(b>>(8-(i+1)) & 0x0001));
	      return buf.toString();
	   }
	public static String stringToHex(String input) throws UnsupportedEncodingException
	{
	        if (input == null) throw new NullPointerException();
	        return asHex(input.getBytes());
	}
	
	public static String asHex(byte[] buf)
    {
		final char[] HEX_CHARS = "0123456789abcdef".toCharArray();
		char[] chars = new char[2 * buf.length];
        for (int i = 0; i < buf.length; ++i)
        {
            chars[2 * i] = HEX_CHARS[(buf[i] & 0xF0) >>> 4];
            chars[2 * i + 1] = HEX_CHARS[buf[i] & 0x0F];
        }
        return new String(chars);
    }
	
	public static int charToNibble(char c) {
	 
	 	if (c>='A' && c<='F') {
            return (10+c-'A');
        } 
        else if (c>='0' && c<='9') {
            return (c-'0');
        }
        else if (c>='a' && c<='f') {
            return (10+c-'a');
        }
        else 
        {
            return 0;
        }
    }
    public static byte[] parseBytes(String s) {
        s = s.replace(" ", "");
        int len = s.length()/2;
        byte[] ba;
        ba = new byte[len];
        if (s.length()%2 > 0) 
        { 
        	s = s+'0'; 
        }
        for (int i=0; i<s.length(); i+=2) 
        {
            ba[i/2] = (byte) (charToNibble(s.charAt(i+1)) | charToNibble(s.charAt(i))<<4  );
        }
        return ba;
    }
    public static String hex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<bytes.length; i++)
        {
            sb.append(String.format("%02X ",bytes[i]));
        }
        
        String hex_final = sb.toString();
        return hex_final;
    }
    
    public static long getLongFromBytes(byte[] byte_string, int offset) {
        long string_long_bin = 0;
        for (int i=0; i<8; i++) 
        {
            byte value;
            if ((offset+i) >= byte_string.length)
            {
            	value = 0;
            } 
            else 
            {
                
                value = byte_string[offset+i];
            }
            string_long_bin = string_long_bin<<8 | (value & 0xFFL);
        }
        return string_long_bin;
    }
	
    public static String hexToBin(String hex){
        String bin = "";
        String binFragment = "";
        int iHex;
        int check[] = {0};
        hex = hex.trim();
        hex = hex.replaceFirst("0x", "");

        for(int i = 0; i < hex.length(); i++){
            iHex = Integer.parseInt(""+hex.charAt(i),16);
            binFragment = Integer.toBinaryString(iHex);
            
            while(binFragment.length() < 4){
                binFragment = "0" + binFragment;
                
            }
            
            bin += binFragment;
           
        }
        
        return bin;
    }
    
    
    public static byte[][] getSubkeys(byte[] theKey)
    	      throws Exception {
    	      int activeKeySize = PC1.length;
    	      int numOfSubKeys = SHIFTS.length;
    	      byte[] activeKey = selectBits(theKey,PC1);
    	      int halfKeySize = activeKeySize/2;
    	      byte[] c = selectBits(activeKey,0,halfKeySize);
    	      byte[] d = selectBits(activeKey,halfKeySize,halfKeySize);
    	      byte[][] subKeys = new byte[numOfSubKeys][];
    	      for (int k=0; k<numOfSubKeys; k++) {
    	         c = rotateLeft(c,halfKeySize,SHIFTS[k]);
    	         d = rotateLeft(d,halfKeySize,SHIFTS[k]);
    	         byte[] cd = concatenateBits(c,halfKeySize,d,halfKeySize);
    	         subKeys[k] = selectBits(cd,PC2);
    	      }
    	      return subKeys;
    	   }
    
    private static byte[] rotateLeft(byte[] in, int len, int step) {
        int numOfBytes = (len-1)/8 + 1;
        byte[] out = new byte[numOfBytes];
        for (int i=0; i<len; i++) {
           int val = getBit(in,(i+step)%len);
           setBit(out,i,val);
        }
        return out;
     }
    
    private static byte[] concatenateBits(byte[] a, int aLen, byte[] b, 
    	      int bLen) {
    	      int numOfBytes = (aLen+bLen-1)/8 + 1;
    	      byte[] out = new byte[numOfBytes];
    	      int j = 0;
    	      for (int i=0; i<aLen; i++) {
    	         int val = getBit(a,i);
    	         setBit(out,j,val);
    	         j++;
    	      }
    	      for (int i=0; i<bLen; i++) {
    	         int val = getBit(b,i);
    	         setBit(out,j,val);
    	         j++;
    	      }
    	      return out;
    	   }
    
    private static byte[] selectBits(byte[] in, int pos, int len) {
    	      int numOfBytes = (len-1)/8 + 1;
    	      byte[] out = new byte[numOfBytes];
    	      for (int i=0; i<len; i++) {
    	         int val = getBit(in,pos+i);
    	         setBit(out,i,val);
    	      }
    	      return out;
    	   }
    
    private static byte[] selectBits(byte[] in, int[] map) {
    	      int numOfBytes = (map.length-1)/8 + 1;
    	      byte[] out = new byte[numOfBytes];
    	      for (int i=0; i<map.length; i++) {
    	         int val = getBit(in,map[i]-1);
    	         setBit(out,i,val);
    	      }
    	      return out;
    	   }
    
    private static int getBit(byte[] data, int pos) {
    	      int posByte = pos/8; 
    	      int posBit = pos%8;
    	      byte valByte = data[posByte];
    	      int valInt = valByte>>(8-(posBit+1)) & 0x0001;
    	      return valInt;
    	   }
    private static void setBit(byte[] data, int pos, int val) {
    	      int posByte = pos/8; 
    	      int posBit = pos%8;
    	      byte oldByte = data[posByte];
    	      oldByte = (byte) (((0xFF7F>>posBit) & oldByte) & 0x00FF);
    	      byte newByte = (byte) ((val<<(8-(posBit+1))) | oldByte);
    	      data[posByte] = newByte;
    	   }
    
    public static byte[] cipher(byte[] theMsg, byte[][] subKeys, 
    	      String mode) throws Exception {
    	      if (theMsg.length<8) 
    	         throw new Exception("Message is less than 64 bits.");
    	      theMsg = selectBits(theMsg,IP); // Initial Permutation
    	      int blockSize = IP.length;
    	      byte[] l = selectBits(theMsg,0,blockSize/2);
    	      byte[] r = selectBits(theMsg,blockSize/2,blockSize/2);
    	      int numOfSubKeys = subKeys.length;
    	      for (int k=0; k<numOfSubKeys; k++) {
    	      	 byte[] rBackup = r;
    	         r = selectBits(r,E); // Expansion
    	         if (mode.equalsIgnoreCase("encrypt")) 
    	            r = doXORBytes(r,subKeys[k]); // XOR with the sub key
    	         else 
    	            r = doXORBytes(r,subKeys[numOfSubKeys-k-1]);
    	         r = substitution6x4(r); // Substitution
    	         r = selectBits(r,P); // Permutation
    	         r = doXORBytes(l,r); // XOR with the previous left half
    	         l = rBackup; // Taking the previous right half
    	      }
    	      byte[] lr = concatenateBits(r,blockSize/2,l,blockSize/2);
    	      lr = selectBits(lr,INVP); // Inverse Permutation
    	      return lr;
    	   }
    
    private static byte[] doXORBytes(byte[] a, byte[] b) {
        byte[] out = new byte[a.length];
        for (int i=0; i<a.length; i++) {
           out[i] = (byte) (a[i] ^ b[i]);
        }
        return out;
     }
    
    private static byte[] substitution6x4(byte[] in) {
        in = splitBytes(in,6); // Splitting byte[] into 6-bit blocks
        byte[] out = new byte[in.length/2];
        int lhByte = 0;
        for (int b=0; b<in.length; b++) { // Should be sub-blocks
           byte valByte = in[b];
           int r = 2*(valByte>>7&0x0001)+(valByte>>2&0x0001); // 1 and 6
           int c = valByte>>3&0x000F; // Middle 4 bits
           int hByte = S[64*b+16*r+c]; // 4 bits (half byte) output
           if (b%2==0) lhByte = hByte; // Left half byte
           else out[b/2] = (byte) (16*lhByte + hByte);
        }
        return out;
     }
     private static byte[] splitBytes(byte[] in, int len) {
        int numOfBytes = (8*in.length-1)/len + 1;
        byte[] out = new byte[numOfBytes];
        for (int i=0; i<numOfBytes; i++) {
           for (int j=0; j<len; j++) {
              int val = getBit(in, len*i+j); 
              setBit(out,8*i+j,val);
           }
        }
        return out;
     }
    
	
   /* public static ArrayList<int[]> createSubkeys(String key_bin){
    		
    	String keystr[] = new String[]{key_bin};
		
		int[] ints = new int[key_bin.length()];
		for(int i=0; i<key_bin.length(); i++) {
		    ints[i] = Integer.parseInt(String.valueOf(key_bin.charAt(i)));
		}
		
				
		int[] pc1_key = pc1(ints);
		//System.out.print("In Creatsubkeys"+pc1_key);
    	
		int[] c = new int[28];
		int[] d =  new int[28];
		
		for(int i = 0; i < pc1_key.length/2;i++){
			c[i] = pc1_key[i];
			//System.out.print(c[i]);
			
			
		}
		//System.out.println();
		//System.out.println("----");
		
		for(int i = 0; i < pc1_key.length/2; i++){
			d[i] = pc1_key[pc1_key.length/2 + i];
		//	System.out.print(d[i]);
		}
		
		
		int[] c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16 = new int[28];
		int[] d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12,d13,d14,d15,d16 = new int[28];
		
		//System.out.println();
		//System.out.println("c1");
		c1 = leftShiftbyOne(c);
		//System.out.println();
		//System.out.println("d1");
		d1 = leftShiftbyOne(d);
		
		//System.out.println();
		//System.out.println("c2");
		c2 = leftShiftbyOne(c1);
		//System.out.println();
		//System.out.println("d2");
		d2 = leftShiftbyOne(d1);
		
		//System.out.println();
		//System.out.println("c3");
		c3 = leftShiftbyTwo(c2);
		//System.out.println();
		//System.out.println("d3");
		d3 = leftShiftbyTwo(d2);
		
		//System.out.println();
		//System.out.println("c4");
		c4 = leftShiftbyTwo(c3);
		//System.out.println();
		//System.out.println("d4");
		d4 = leftShiftbyTwo(d3);
		
		//System.out.println();
		//System.out.println("c5");
		c5 = leftShiftbyTwo(c4);
		//System.out.println();
		//System.out.println("d5");
		d5 = leftShiftbyTwo(d4);
		
		//System.out.println();
		//System.out.println("c6");
		c6 = leftShiftbyTwo(c5);
		//System.out.println();
		//System.out.println("d6");
		d6 = leftShiftbyTwo(d5);
		
		//System.out.println();
		//System.out.println("c7");
		c7 = leftShiftbyTwo(c6);
		//System.out.println();
		//System.out.println("d7");
		d7 = leftShiftbyTwo(d6);
		
		//System.out.println();
		//System.out.println("c8");
		c8 = leftShiftbyTwo(c7);
		//System.out.println();
		//System.out.println("d8");
		d8 = leftShiftbyTwo(d7);
		
		//System.out.println();
		//System.out.println("c9");
		c9 = leftShiftbyOne(c8);
		//System.out.println();
		//System.out.println("d9");
		d9 = leftShiftbyOne(d8);
		
		//System.out.println();
		//System.out.println("c10");
		c10 = leftShiftbyTwo(c9);
		//System.out.println();
		//System.out.println("d10");
		d10 = leftShiftbyTwo(d9);
		
		//System.out.println();
		//System.out.println("c11");
		c11 = leftShiftbyTwo(c10);
		//System.out.println();
		//System.out.println("d11");
		d11 = leftShiftbyTwo(d10);
		
		//System.out.println();
		//System.out.println("c12");
		c12 = leftShiftbyTwo(c11);
		//System.out.println();
		//System.out.println("d12");
		d12 = leftShiftbyTwo(d11);
		
		//System.out.println();
		//System.out.println("c13");
		c13 = leftShiftbyTwo(c12);
		//System.out.println();
		//System.out.println("d13");
		d13 = leftShiftbyTwo(d12);
		
		//System.out.println();
		//System.out.println("c14");
		c14 = leftShiftbyTwo(c13);
		//System.out.println();
		//System.out.println("d14");
		d14 = leftShiftbyTwo(d13);
		
		//System.out.println();
		//System.out.println("c15");
		c15 = leftShiftbyTwo(c14);
		//System.out.println();
		//System.out.println("d15");
		d15 = leftShiftbyTwo(d14);
		
		//System.out.println();
		//System.out.println("c16");
		c16 = leftShiftbyOne(c15);
		//System.out.println();
		//System.out.println("d16");
		d16 = leftShiftbyOne(d15);
		
		int[] k1,k2,k3,k4,k5,k6,k7,k8,k9,k10,k11,k12,k13,k14,k15,k16 = new int[48];
		
		k1 =  createKey(c1,d1);
		k2 =  createKey(c2,d2);
		k3 =  createKey(c3,d3);
		k4 =  createKey(c4,d4);
		k5 =  createKey(c5,d5);
		k6 =  createKey(c6,d6);
		k7 =  createKey(c7,d7);
		k8 =  createKey(c8,d8);
		k9 =  createKey(c9,d9);
		k10 =  createKey(c10,d10);
		k11 =  createKey(c11,d11);
		k12 =  createKey(c12,d12);
		k13 =  createKey(c13,d13);
		k14 =  createKey(c14,d14);
		k15 =  createKey(c15,d15);
		k16 =  createKey(c16,d16);
		
		ArrayList<int[]> subKeys = new ArrayList<int[]>();
		
		subKeys.add(k1);
		subKeys.add(k2);
		subKeys.add(k3);
		subKeys.add(k4);
		subKeys.add(k5);
		subKeys.add(k6);
		subKeys.add(k7);
		subKeys.add(k8);
		subKeys.add(k9);
		subKeys.add(k10);
		subKeys.add(k11);
		subKeys.add(k12);
		subKeys.add(k13);
		subKeys.add(k14);
		subKeys.add(k15);
		subKeys.add(k16);
		
		return subKeys;
		
		
		
		
    }
    
    public static int[] pc1(int[] ints){
    	int[] key_plus_pc1 = new int[56];
    	
    	int[] pc1 = { 57 ,  49 ,  41 , 33 , 25 , 17 ,  9,
                	   1 ,  58 ,  50 , 42 , 34 , 26 , 18,
                	  10 ,   2 ,  59 , 51 , 43 , 35 , 27,
                	  19 ,  11 ,   3 , 60 , 52 , 44 ,  36,
                	  63 ,  55 ,  47 , 39 , 31 , 23 ,  15,
                	   7 ,  62 ,  54 , 46 , 38 , 30 ,  22,
                	  14 ,   6 ,  61 , 53 , 45 , 37 ,  29,
                	  21 ,  13 ,   5 , 28 , 20 , 12 ,   4
                	};
    	//System.out.println();
    	//System.out.println("After PC1");
    	for(int i = 0;i< pc1.length;i++ ){
    		//System.out.println("Elements "+pc1[i]);
    		int temp = pc1[i];
    		key_plus_pc1[i] = ints[temp - 1];
    		//System.out.print(key_plus_pc1[i]);
    	}
    	
    	
    	return key_plus_pc1;
    }
    
    public static int[] leftShiftbyOne(int[] arr){
    	int[] c = new int[28];
    	for(int i = 0; i < arr.length; i++){
    		if( i == arr.length - 1){
    			c[i] = arr[0];
    		}
    		else{
    			c[i] = arr[i + 1];
    		}
    	}
    	
    	
    	return c;
    }
    public static int[] leftShiftbyTwo(int[] arr){
    	int[] c = new int[28];
    	for(int i = 0; i < arr.length; i++){
    		if( i == arr.length - 1){
    			c[i] = arr[1];
    		}
    		else if( i == arr.length - 2){
    			c[i] = arr[0];
    		}
    		else{
    			c[i] = arr[i + 2];
    		}
    	}
    	//System.out.println("c1------");
    	
    	return c;
    }
    
    public static int[] createKey(int[] c, int[] d){
    	int[] k = new int[48];
    	int[] _k = new int[56];
    	//System.out.println();
    	//System.out.println("CCCDDD");
    	for(int i = 0;i < _k.length ; i++){
    		if(i > 27){
    			_k[i] = d[i - 28];
    		}
    		else{
    			_k[i] = c[i];
    		}
    		//System.out.print(_k[i]);
    	}
    	
    	
    	
    	int[] pc2 = {
    			 14,  17,  11,  24,   1,   5,
                  3,  28,  15,   6,  21,  10,
                 23,  19,  12,   4,  26,   8,
                 16,   7,  27,  20,  13,   2,
                 41,  52,  31,  37,  47,  55,
                 30,  40,  51,  45,  33,  48,
                 44,  49,  39,  56,  34,  53,
                 46,  42,  50,  36,  29,  32
    	};
    	
    	//System.out.println();
    	//System.out.println("After PC2");
    	for(int i = 0;i< pc2.length;i++ ){
    		//System.out.println("Elements "+pc1[i]);
    		int temp = pc2[i];
    		k[i] = _k[temp - 1];
    		//System.out.print(k[i]);
    	}
    	
    	return k;
    }*/

   /* public static void encodeMessage(String message_bin, ArrayList<int[]> subKeys){
    	
    	String msgstr[] = new String[]{message_bin};
		
		int[] intsmsg = new int[message_bin.length()];
		for(int i=0; i<message_bin.length(); i++) {
		    intsmsg[i] = Integer.parseInt(String.valueOf(message_bin.charAt(i)));
		}
		
		int[] IP = {
				58,    50,   42,    34,    26,   18,    10,    2,
	            60,    52,   44,    36,    28,   20,    12,    4,
	            62,    54,   46,    38,    30,   22,    14,    6,
	            64,    56,   48,    40,    32,   24,    16,    8,
	            57,    49,   41,    33,    25,   17,     9,    1,
	            59,    51,   43,    35,    27,   19,    11,    3,
	            61,    53,   45,    37,    29,   21,    13,    5,
	            63,    55,   47,    39,    31,   23,    15,    7
		};
		int m[] = new int[64];
		System.out.println();
		System.out.println("IP1");
		for(int i = 0;i< IP.length;i++ ){
    		//System.out.println("Elements "+pc1[i]);
    		int temp = IP[i];
    		m[i] = intsmsg[temp - 1];
    		System.out.print(m[i]);
    	}
    	
    }*/
}
