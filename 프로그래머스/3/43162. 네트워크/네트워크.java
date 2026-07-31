import java.io.*;
import java.util.*;

class Solution {
    boolean[] select;
    int num, answer;
    public int solution(int n, int[][] computers) {
        // int answer = 0;
        
        // 컴퓨터 개수
        int totalComs = computers.length;
        select = new boolean[totalComs];
        
        num = totalComs;
        while(num > 0){
            for(int i=0; i<totalComs; i++){
                if(select[i] == true)
                    continue;
                // i: 시작 컴퓨터
                num -= bfs(i, computers, totalComs);
                answer++;
            }
        }
        
        return answer;
    }
    
    public int bfs(int start, int[][] coms, int total){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        int cnt = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            select[cur] = true;
            cnt++;
            for(int i=0; i<total; i++){
                if(cur == i || select[i] == true)
                    continue;
                if(coms[cur][i] == 1){
                    q.offer(i);
                }  
            }
        }
        return cnt;
    }
}