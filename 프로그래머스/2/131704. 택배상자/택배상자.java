import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0; // 상자 개수
        
        // 보조 컨테이너: 양방향, 그러나 스택 구조
        // 주어진 순서대로 실을 수 없다면 그대로 종료
        int boxCnt = order.length;
        int[] origin = new int[boxCnt]; // 이 순서로 컨테이너에 삽입
        for(int i=1; i<=boxCnt; i++){
            origin[i-1] = i;
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0); // null pointer 방지
        
        int originIdx = 0;
        // 현재 order에 적합한 상자를 컨테이너에 놓을 수 있는지 판단
        for(int i=0; i<boxCnt; i++){
            int goal = order[i];
            // stack의 탑과 같다면 증가
            if(stack.peek() == goal){
                answer++;
                stack.pop();
                continue;
            }
            
            // goal을 찾을 때까지 보조 스택에 넣기
            boolean find = false;
            while(originIdx < boxCnt){
                if(goal == origin[originIdx]){
                    find = true;
                    originIdx++;
                    break;
                }
                stack.push(origin[originIdx++]);
            }

            // 찾았다면 증가
            if(find){
                answer++;
            } else {
                break;
            }
            // 못찾았다면 종료
            
        }
        
            
            
        return answer;
    }
}