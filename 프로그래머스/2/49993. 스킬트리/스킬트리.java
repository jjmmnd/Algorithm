import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        // 이미 만들어진 순서를 단순 검증함
        for(String st: skill_trees){
            boolean valid = true;
            int idx = 0;
            
            for(char ch : st.toCharArray()){
                
                // 선행스킬과 관련있나
                if(skill.indexOf(ch) == -1){
                    continue;
                }
                
                // 중복이 불가능하니 현재배울스킬인지 아닌지만.
                if(idx >= skill.length() || skill.charAt(idx) != ch){
                    valid = false;
                    break;
                }
                
                idx++;
                
            }
            
            if(valid){
                answer++;
            }
            
            
        }
        
        return answer;
    }
}