import java.io.*;
import java.util.*;

public class Main {    
    
    static int[][] map;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        int n = Integer.parseInt(br.readLine());
        
        map = new int[n][n];
        
        for(int i = 0; i < n; i++) {            
            String line = br.readLine();
            for(int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        divide(0,0,n);
        System.out.print(sb);
    }
    
    private static void divide(int row, int col, int size) {        
        
        if(isSame(row,col,size)) {            
            sb.append(map[row][col]);
            return;
        }
        
        sb.append("(");
        int newSize = size / 2;
        
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                divide(row + i * newSize, col + j * newSize, newSize);       
            }            
        }
        sb.append(")");
    }
    
    private static boolean isSame(int row, int col, int size) {
        int cur = map[row][col];
        
        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                if(cur != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}