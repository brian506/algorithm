import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) {
            return cities.length * 5;
        }
        int totalTime = 0;
        LinkedList<String> list = new LinkedList<>();
        
        for(String city : cities) {
            String lowerCity = city.toLowerCase();
            
            if(list.remove(lowerCity)) { // 캐시 히트
                list.addLast(lowerCity);
                totalTime += 1;
            } else {
                if(list.size() >= cacheSize) {
                    list.removeFirst();
                }
                list.addLast(lowerCity);
                totalTime += 5;
            }
        }
        return totalTime;
    }
}