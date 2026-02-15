import java.io.*;
import java.util.*;

// 같은 번호의 초밥 둘 이상 가능
// k 개의 연속된 구간 -> 할인가 -> 이 행사 참가 후 쿠폰 번호는 무료 제공
// n <= 300만

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 접시 수
        int d = Integer.parseInt(st.nextToken()); // 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속 구간의 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호 수

        // 쿠폰 없이 전부 다른 종류의 연속 k 가능한 경우 -> 가장 최대
        // 각 접시에서의 연속 k 구해서 다른 종류, 쿠폰 포함여부 -> 완탐은 너무 시간초과다

        int[] dishes = new int[n];
        for(int i=0; i<n; i++){
            dishes[i] = Integer.parseInt(br.readLine());
        }

        // k 구간 내에서 같은 수가 있는지 어케 판별하지 d<=3000
        // 배열 딱 하나 만들어서 개수만 저장하도록 ㅜ
        int[] visited = new int[d+1];
        int s = 0;
        int e = k-1;
        int types = 0;
        for(int i=s; i<=e; i++){
            visited[dishes[i]]++;
            if(visited[dishes[i]]==1) types++;
        }

        int maxTypes = types;
        if(visited[c] == 0) maxTypes++;

        for(int i=0; i<n-1; i++){
            visited[dishes[s%n]]--;
            if(visited[dishes[s%n]]==0) types--;
            s++;
            e++;
            visited[dishes[e%n]]++;
            if(visited[dishes[e%n]]==1) types++;

            int tmp = types;
            if(visited[c] == 0) tmp++;
            maxTypes = Math.max(maxTypes, tmp);
        }

        System.out.println(maxTypes);
    }
}
