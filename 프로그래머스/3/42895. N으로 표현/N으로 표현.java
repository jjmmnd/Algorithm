import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = -1;
        
        HashSet<Integer>[] dp = new HashSet[9];
        dp[0] = new HashSet<>();
        dp[1] = new HashSet<>();
        dp[1].add(N);
        if(N == number){
            return 1;
        }
        // 8까지만 반복돌리면 됨
        for(int i=2; i<=8; i++){
            dp[i] = new HashSet<>();
            String str = Integer.toString(N).repeat(i);
            dp[i].add(Integer.parseInt(str));
            
            // 사칙연산 반복
            for(int j=1; j<i; j++){
                for(int a: dp[i-j]){
                    for(int b: dp[j]){
                        dp[i].add(a+b);
                        if(b!= 0)
                            dp[i].add(a/b);
                        dp[i].add(a*b);
                        dp[i].add(a-b);
                    }
                }
            }
            
            // System.out.println(dp[i].size());
            if(dp[i].contains(number)){
                answer = i;
                break;
            }
        }
        
        
        return answer;
    }
}