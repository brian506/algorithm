import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        List<String> list = new ArrayList<>();
        int totalTime = 0;
        
        
        for(int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            boolean cached = false;
            
            
           if(!list.isEmpty()) {
            for(int j = 0; j < list.size(); j++) {
                String cacheCity = list.get(j);
                
                if(cacheCity.equals(city)) {
                    cached = true;      
                    list.remove(j);
                    break;
                }                                                     
            }
           }
            if(cached) {
                totalTime += 1;                
            }  else {
                totalTime += 5;                                   
            }   
            
            list.add(city);
            
            if(list.size() > cacheSize) {
               list.remove(0);           
            } 
        }
        return totalTime;
    }
}