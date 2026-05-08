// 동시 출발 -> 같은 시간에 같은 좌표에 있을 것 -> 시간 반복문?.. 
// -> 해당 시간에 각 로봇의 위치 확인 -> 2개 이상이면 +1
// 로봇마다 시간 grid를 갖게하면 100개의 grid 100번의 bfs 
// 벽x r먼저 c먼저
import java.util.*;
class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int x = routes.length; // 로봇 개수
        
        // 각 로봇이 a부터 b로 가는 경로를 1초단위로 리스트에 저장
        // 초마다 모든 로봇의 위치를 비교 -> 같은 위치인 로봇이 2이상이면 +1
        
        
        List<Queue<int[]>> posList = new ArrayList<>();
        for(int i=0; i<x; i++){
            posList.add(new ArrayDeque<>());
            
            // 시작점 먼저 넣기
            int start = routes[i][0];
            int curR = points[start-1][0];
            int curC = points[start-1][1];
            posList.get(i).add(new int[] {curR, curC});
            
            // 루트에 맞게 큐에 기록
            for(int dep=0; dep<routes[0].length-1; dep++){
                int end = routes[i][dep+1];
                int endR = points[end-1][0];
                int endC = points[end-1][1];

                // r 이동 (양수는 증가 음수는 감소)
                int dir = (endR - curR>=0)?1:-1;
                while(curR != endR){
                    curR += dir;
                    posList.get(i).add(new int[] {curR, curC});
                }

                dir = (endC-curC>=0)?1:-1;
                while(curC != endC){
                    curC += dir;
                    posList.get(i).add(new int[] {curR, curC});
                }
            }
        }
        
        
        // 배열에 기록
        // int[][] cnt = new int[101][101];
        int maxLen = 0;
        for(Queue<int[]> q: posList){
            maxLen = Math.max(maxLen, q.size());
        }

        for(int time=0; time<maxLen; time++){
            int[][] cnt = new int[101][101];
            for(int i=0; i<x; i++){
                if(posList.get(i).isEmpty())
                    continue;
                int[] rPos = posList.get(i).poll();
                cnt[rPos[0]][rPos[1]]++;
            }

            for(int i=0; i<101; i++){
                for(int j=0; j<101; j++){
                    if(cnt[i][j]>1){
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }
}