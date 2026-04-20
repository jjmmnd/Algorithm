import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        int s = score.length - 1;
        int e = s - m + 1;
        while(e >= 0){
            answer += score[e]*m;
            s = e - 1;
            e = s - m + 1;
        }
        return answer;
    }
}