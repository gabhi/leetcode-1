import java.util.*;

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class ReadNCharacterGivenReadFour2 extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private char[] bufSm = new char[4];     // sm buf of size 4
    int ib = 0;                             // index of small buf
    int nb = 0;                             // number read into small buf
    public int read(char[] buf, int n) {
        int i = 0;                          // index of big buf
        while(i < n) {                      
            if(ib == 0) nb = read4(bufSm);  
            if(nb == 0) break;              // End if read all
            while(i < n && ib < nb) {       
                buf[i++] = bufSm[ib++];
            }
            if(ib == nb) ib = 0;            // Reset if sm buf is full
        }
        return i;
    }

    public static void main(String[] args) {}
}

class Reader4 {
	int read4(char[] buf) {
		return 0;
	}
}