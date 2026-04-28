import java.util.*;

// 한번 쓴 티켓 못 씀. 체크 

class Solution {
    boolean[] visit;
    int len;
    // List<List<String>> ans = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        len = tickets.length;
        visit = new boolean[len];
        
        // visit[0] = true;
        // List<String> rt = new ArrayList<>();
        // rt.add("ICN");
        btk("ICN", "ICN", 0, tickets);
        
        // 정렬..?
        Collections.sort(ans);
        answer = new String[len+1];
        StringTokenizer st = new StringTokenizer(ans.get(0));
        for(int i=0; i<len+1; i++){
            answer[i] = st.nextToken();
        }
        
        return answer;
    }
    
    void btk(String start, String route, int cnt, String[][] tickets){
        if(cnt == len){
            // ans.add(route);
            // System.out.println(route);
            ans.add(route);
            return;
        }
        
        for(int i=0; i<len; i++){
            if(!visit[i] && tickets[i][0].equals(start)){
                visit[i] = true;
                // route.add(tickets[i][1]);
                btk(tickets[i][1], route+" "+tickets[i][1], cnt+1, tickets);
                // route.remove(cnt);
                visit[i] = false;
            }
        }
    }
    
}