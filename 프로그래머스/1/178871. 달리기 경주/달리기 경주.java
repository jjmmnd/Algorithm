import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        int total = players.length;
        String[] answer = new String[total];
        // players 순서 = 처음 등수
        Map<String, Integer> map = new HashMap<>();
        int idx = 0;
        for(String player: players){
            map.put(player, idx);
            answer[idx++] = player;
        }
        
        for(String cPlayer: callings){
            idx = map.get(cPlayer);
            String pPlayer = answer[idx-1]; // 앞선 주자
            
            answer[idx-1] = cPlayer;
            answer[idx] = pPlayer;
            
            map.put(cPlayer, idx-1);
            map.put(pPlayer, idx);
        }
        
        return answer;
    }
}