import java.io.*;
import java.util.*;

// 로봇이 특정 칸에 새롭게 등장하면 칸의 내구도 -1
// 컨베이어가 돌아가는 것과 로봇이 움직이는 것은 별개
// 내리는 위치에 도달하면 즉시 내리기 -> 루프 시작에는 항상 비워져있음

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 내리는 위치 (컨베이어 벨트 길이는 2n)
        int k = Integer.parseInt(st.nextToken()); // k개 칸의 내구도가 0이 되면 종료

        // 내구도 정보
        int[] belt = new int[2*n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<2*n; i++){
            belt[i] = Integer.parseInt(st.nextToken());
        }
        
        // 동일하게 idx로 관리함
        boolean[] robotExists = new boolean[2*n];

        int zeros = 0; // 내구도가 0인 칸의 개수
        int startIdx = 0, endIdx = n-1;

        int ans=0;
        // 4. 0인 애가 k개 이상되면 종료 (k 미만일 때만 반복)
        while(k-zeros>0){
            ans++;

            // 1. 로봇과 함께 한 칸 회전
            startIdx = (startIdx+(2*n-1))%(2*n);
            endIdx = (endIdx+(2*n-1))%(2*n);
            robotExists[endIdx] = false;


            // 2. 로봇 리스트에서 end에 가까운 로봇부터 이동할 수 있다면 end쪽으로, endIdx -> startIdx 순서
            int[] tmp = new int[n]; // 상단 컨베이어 벨트 idx 배열
            for(int i=0; i<n; i++){
                tmp[i] = (startIdx+i)%(2*n);
            }
//            System.out.println(Arrays.toString(tmp));
//            System.out.println(Arrays.toString(belt));
//            System.out.println(Arrays.toString(robotExists));
            for(int i=n-1; i>0; i--){
                if(!robotExists[tmp[i]] && belt[tmp[i]] > 0){
                    if(!robotExists[tmp[i-1]]) continue;
                    robotExists[tmp[i-1]] = false;
                    robotExists[tmp[i]] = true;
                    // 내구도 줄이고
                    if(--belt[tmp[i]]==0)
                        zeros++;
                    // 마지막이라면 즉시 내려
                    if(tmp[i]==endIdx)
                        robotExists[endIdx] = false;
                }
            }

            // 3. 매번 1번에서 로봇이 올라감 (내구도가 0보다 클 때만)
            if(belt[startIdx] > 0){
                robotExists[startIdx] = true;
                if(--belt[startIdx]==0)
                    zeros++;
            }

//            System.out.println(Arrays.toString(belt));
//            System.out.println(Arrays.toString(robotExists));

        }

        System.out.println(ans);
    }
}
