import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if(cacheSize == 0){
            return cities.length*5;
        }
        
        // 캐시의 최대 크기는 30
        LinkedList<String> cache = new LinkedList<>();
        
        for(String city: cities){
            city = city.toLowerCase();
            
            if(cache.remove(city)){
                cache.add(city);
                answer += 1;
            } else {
                if(cache.size() >= cacheSize){
                    cache.poll(); // 앞에 애가 빠짐
                }
                cache.add(city);
                answer += 5;
            }
            
        }
        
        return answer;
    }
}