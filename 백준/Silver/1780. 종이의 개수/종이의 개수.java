import java.io.*;
import java.util.*;

public class Main {
    
    static int[][] paper;
    static int n;
    static int zero;
    static int one;
    static int minusOne;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());    
        paper = new int[n][n];        
        
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());    
            }
        }
        
        divide(0,0,n);
        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(one);
        
    }
    private static void divide(int r, int c, int size) {
        
        if(isSame(r,c,size)) {
            int cur = paper[r][c];
            if(cur == 0) zero++;
            else if(cur == 1) one++;
            else minusOne++;
            return;
        }
        
        int newSize = size /3;
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                divide(r + i*newSize, c+ j*newSize, newSize);
            }
        }
    }
    
    
    private static boolean isSame(int r, int c, int size) {
        int start = paper[r][c];
        
        for(int i = r; i < r + size; i++) {
            for(int j = c; j < c + size; j++) {
                if(start != paper[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
     
}