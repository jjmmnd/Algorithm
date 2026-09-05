import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        // 합을 저장하기. 각 층에서 내려올 때마다 최댓값 비교
        int hei = triangle.length;
        int[][] dp = new int[hei][hei];
        System.out.println(hei);
        
        dp[0][0] = triangle[0][0];
        dp[1][0] = triangle[1][0]+dp[0][0];
        dp[1][1] = triangle[1][1]+dp[0][0];
        for(int i=2; i<hei; i++){
            // 왼쪽
            dp[i][0] = triangle[i][0]+dp[i-1][0];
            // 오른쪽
            dp[i][i] = triangle[i][i]+dp[i-1][i-1];
            for(int j=1; j<i; j++){
                dp[i][j] = Math.max(triangle[i][j]+dp[i-1][j-1], triangle[i][j]+dp[i-1][j]);
            }
        }
        
        for(int n: dp[hei-1]){
            answer = Math.max(answer, n);
        }
        
        return answer;
    }
}