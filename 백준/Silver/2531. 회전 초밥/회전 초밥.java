import java.io.*;
import java.util.*;

// 초밥 가짓수의 최댓값 구하기

public class Main {
    public static void main(String[] args) throws IOException{
        // k개를 연속해서 먹으면 할인 가격
        // 1번 행사에 참가하면 쿠폰 번호는 무료 (레일에 없어도 만들어서 제공)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken()); // 쿠폰번호

        int[] sushi = new int[d+1]; // idx 스시를 몇 번 만났는지

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;
        int uniqCnt = 0;

        // 초기 윈도우
        for(int i=0; i<k; i++){
            if(sushi[arr[i]]==0){
                uniqCnt++;
            }
            sushi[arr[i]]++;
        }
        ans = uniqCnt;
        if(sushi[c]==0)
            ans++;

        // 1 ~ n-1 까지
        for(int s=1; s<n; s++){
            int e = (s+k-1)%n;

            if(--sushi[arr[s-1]]==0){
                uniqCnt--;
            }

            if(sushi[arr[e]]++==0){
                uniqCnt++;
            }

            int tmp = uniqCnt;
            if(sushi[c]==0)
                tmp++;

            ans = Math.max(tmp, ans);
        }

        System.out.println(ans);
    }
}
