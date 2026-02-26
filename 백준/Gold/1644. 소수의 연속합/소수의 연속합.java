import java.util.*;

public class Main{
    public static boolean prime[];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
       
       // 연속된 소수의 합
       // 중복 안됨
       prime = new boolean[n+1];
       get_prime();
       
       int index = 0;
        
        // n 이하의 소수들을 배열에 순차적으로 삽입
       for(int i = 2;i <= n;i++){
            if(prime[i] == false){
                arr[index] = i;
                index++;
            }
       }

      int left = 0;
      int right = 0;
      int sum =0;
      int count = 0;
    
    while(right < n){
        
    if(sum < n){
        sum += arr[right];
        right++;
    }
    if(sum > n){
        sum -= arr[left];
        left++;
    }
    if(sum == n){
        count++;
        sum -= arr[left];
        left++;
    }
       }
       System.out.println(count);
    }

    public static void get_prime(){
        prime[0] = true;
        prime[1] = true;
        for(int i = 2;i < Math.sqrt(prime.length);i++){
            for(int j = i * i; j < prime.length ; j += i){
                prime[j] = true;
            }
        }
    }
}