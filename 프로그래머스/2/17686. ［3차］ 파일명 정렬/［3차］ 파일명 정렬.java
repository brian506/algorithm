import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        
        List<String> list = new ArrayList<>();
        for(int i = 0; i < files.length; i++) {
            list.add(files[i]);
        }
        
        list.sort((a,b) -> {
            String head1 = getHead(a);
            String head2 = getHead(b);
            
            int compare = head1.toLowerCase().compareTo(head2.toLowerCase());
            
            if(compare == 0) {
                int number1 = getNumber(head1.length(),a);
                int number2 = getNumber(head2.length(),b);
                compare = number1 - number2;
            }
            return compare;
        });
        String[] ans = new String[list.size()];
        for(int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
    
    private String getHead(String file) {
        String head = "";
        for(int i = 0; i < file.length(); i++) {
            if(0 <= file.charAt(i) -'0' && file.charAt(i) -'0' <= 9) {
                break;
            }
            head += file.charAt(i);
        }
        return head;
    }
    
    private int getNumber(int headLength, String file) {
        String number = "";
        for(int i = headLength; i < file.length(); i++) {
            if(0 > file.charAt(i) -'0' || file.charAt(i) -'0' > 9) {
                break;
            }
            number += file.charAt(i);
        }
        return Integer.parseInt(number);
    }
}