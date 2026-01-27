import java.io.*;
import java.util.*;

public class Main {
    
    static int[][] map;
    static int white = 0;
    static int blue = 0;

    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divide(0,0,n);
        System.out.println(white);
        System.out.println(blue);
    }
    
    private static void divide(int row, int col, int size) {
        
        
        if(isSame(row,col,size)) {
            int cur = map[row][col];
            if(cur == 0) white++;
            else blue++;
            return;
        }        
        
        int newSize = size / 2; 
        
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++){
                divide(row + i*newSize, col + j*newSize, newSize);
            }
        }
    }
     
    private static boolean isSame(int row, int col, int size) {
        int lastNum = map[row][col];
        
        for(int i = row; i < row +size; i++) {
            for(int j = col; j < col + size; j++) {
                if(map[i][j] != lastNum) return false;
            }
        }
        return true;
    }
}