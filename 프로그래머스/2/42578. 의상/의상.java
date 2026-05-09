// 조합 
// 각 종류에서 0~max 고르고 set에 넣어서 개수
import java.util.*;
class Solution {
    // Set<String> set = new HashSet<>();
    Map<String, List<String>> map = new HashMap<>();
    public int solution(String[][] clothes) {
        for(int i=0; i<clothes.length; i++){
            List<String> v = map.get(clothes[i][1]);
            // String[] v = map.get(clothes[i][1]);
            if(v==null){
                List<String> str = new ArrayList<>();
                str.add(clothes[i][0]);
                map.put(clothes[i][1], str);
            } else{
                v.add(clothes[i][0]);
                map.put(clothes[i][1], v);
            }
        }
        
        int answer = 1;
        Set<String> keys = map.keySet();
        for(String key: keys){
            answer *= (map.get(key).size()+1);
        }
        // for(int i=0; i<map.size(); i++){
        //     answer *= map.get()
        // }
        // for(Map.Entry<String, List<String>> entry: map.entrySet()){
        //     answer *= (entry.get().length() + 1);
        // }
        
        
        // comb(clothes.length, 0, " ", clothes);
        
        return answer-1;
    }
    
//     public void comb(int types, int cnt, String com, String[][] clothes){
//         if(cnt == types){
//             set.add(com);
//             return;
//         }
        
//         for(int i=0; i<clothes[cnt].length; i++){
//             comb(types, cnt+1, com+clothes[cnt][i], clothes);
//         }
        
//         comb(types, cnt+1, com, clothes);
//     }
}