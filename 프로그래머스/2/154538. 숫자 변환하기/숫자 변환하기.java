import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        int[] dp = new int[y+1]; // idx로 만들기 위한 최소 횟수 배열
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i=0; i<x; i++){
            dp[i] = -1;
        }
        dp[x] = 0;
        
        for(int i=x+1; i<=y; i++){
            if(i%2 == 0 && dp[i/2] != -1){
                dp[i] = Math.min(dp[i/2]+1, dp[i]);
            }
            if(i%3 == 0 && dp[i/3] != -1){
                dp[i] = Math.min(dp[i/3]+1, dp[i]);
            }
            if(i-n >= x && dp[i-n] != -1){
                dp[i] = Math.min(dp[i-n]+1, dp[i]);
            }
            if(dp[i] == Integer.MAX_VALUE){
                dp[i] = -1;
            }
        }
        
        answer = dp[y];
        return answer;
    }
}