import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        int r = board.length;
        int c = board[0].length;
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        for(int pos: moves){
            pos -= 1;
            int cur = 0;
            for(int i=0; i<r; i++){
                if(board[i][pos] != 0){
                    cur = board[i][pos];
                    board[i][pos] = 0;
                    break;
                }
            }
            
            if(cur == 0)
                continue;
            
            // 바구니로 옮겨
            if(stack.size() > 0){
                if(stack.peek() == cur){
                    stack.pop();
                    answer += 2;
                }else{
                    stack.push(cur);
                }
            }else{
                stack.push(cur);
            }
        }
        
        return answer;
    }
}