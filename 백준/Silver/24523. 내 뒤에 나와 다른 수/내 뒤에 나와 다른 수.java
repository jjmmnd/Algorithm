import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 배열의 개수
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        
        // 투포인터로 시작점 다시 잡기
        int s = 0;
        int e = s+1;
        // 끝나는 조건은?
        while(e < n){
            if(arr[e] != arr[s]){
                for(int i=s; i<e; i++){
                    ans[i] = e + 1;
                }
                s = e;
            }
            e++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    }
}