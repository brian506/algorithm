import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        List<String> list = new ArrayList<>();
        
        for(int i = 0; i < numbers.length; i++) {
            list.add(String.valueOf(numbers[i]));
        }
        
        list.sort((a,b) -> {
            String case1 = a + b;
            String case2 = b + a;
            return case2.compareTo(case1);
        });
        if(list.get(0).equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        
        for(String str : list) {
            sb.append(str);
        }
        return sb.toString();
    }
}