import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        int n = numbers.length;
        List<String> list = new ArrayList<>();
                
        for(int i = 0; i < n; i++) {
            list.add(String.valueOf(numbers[i]));   
        }
        
        list.sort((a,b) -> {
            String case1 = a + b;
            String case2 = b + a;
            return case2.compareTo(case1);                    
        });
        
        String answer = "";
        for(String num : list) {
            sb.append(num);
        }
        
        if(list.get(0).equals("0")) {
            return "0";
        }
        return sb.toString();
    }
}

