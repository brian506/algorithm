import java.util.*;
class Solution {
    public class Truck {
        int weight;
        int inTime; // 진입시간
        
        public Truck(int weight, int inTime) {
            this.weight = weight;
            this.inTime = inTime;
        }
              
    }    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> bridge = new LinkedList<>();
        
        int trucks = truck_weights.length;
        int idx = 0;
        int time = 0;
        int amount = 0;
        int truckCount = 0;
        
        while(idx < trucks || !bridge.isEmpty()) {
            time++;        
            
            // 다리에서 나갈 때
            if(!bridge.isEmpty() && time - bridge.peek().inTime == bridge_length) {
                Truck arrive = bridge.poll();
                amount -= arrive.weight;
                truckCount--;                
            }
            
            // 다리 들어갈 때
        if(idx < trucks) {
            if(amount + truck_weights[idx] <= weight && truckCount <= bridge_length) {
                bridge.add(new Truck(truck_weights[idx], time));
                amount += truck_weights[idx];
                truckCount++;
                idx++;            
            }                
        }
        }
        return time;
    }
}