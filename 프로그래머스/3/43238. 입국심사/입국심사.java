import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        // 가능할 거 같은 시간을 계속 줄여나감;
        // 최대 시간은 미리 계산 가능
        long mxTime = 0;
        for(int t: times){
            mxTime = Math.max(mxTime, t);
        }
        long left = 0;
        long right = mxTime * n;
        
        while(left <= right){
            long mid = (left+right)/2;
            long people = 0;
            
            // mid 안에 몇명 처리 가능한지
            for(int t: times){
                people += mid/t;
            }
            
            if(people >= n){
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            
        }
        
        
        return answer;
    }
}