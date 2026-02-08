import java.io.*;
import java.util.*;

// N <= 6 && X,M <=10
// 완탐 dfs
// 다 채워보고 구간합 조건에 맞는다면 햄스터 수가 최대 + 사전순으로 갱신

public class Solution {

    static int N, X, M;
    static int[][] record;
    static int[] finalHams;
    static int[] tmpHams;
    static boolean isPossible;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            record = new int[M][3];
            finalHams = new int[N+1]; // N에 햄스터 수의 합 저장
            tmpHams = new int[N];
            isPossible = false;

            for(int m=0; m<M; m++) {
                st = new StringTokenizer(br.readLine());
                record[m][0] = Integer.parseInt(st.nextToken()); // l
                record[m][1] = Integer.parseInt(st.nextToken()); // r
                record[m][2] = Integer.parseInt(st.nextToken()); // s
            }

            countHam(0, 0);
            System.out.print("#"+tc+" ");
            if(!isPossible) {
                System.out.println(-1);
                continue;
            }
            for(int n=0; n<N; n++) {
                System.out.print(finalHams[n]+" ");
            }
            System.out.println();
        }

    }

    public static void countHam(int cnt, int totalHam){

        if(cnt == N){
            isPossible = true;

            if(totalHam > finalHams[cnt]) {
                finalHams = Arrays.copyOf(tmpHams, N+1);
                finalHams[cnt] = totalHam;
            } else if(totalHam == finalHams[cnt]) {
                // 사전순
                for(int n=0; n<N; n++){
                    if(tmpHams[n] < finalHams[n]) {
                        finalHams = Arrays.copyOf(tmpHams, N+1);
                        finalHams[cnt] = totalHam;
                        break;
                    }
                    else if(tmpHams[n] > finalHams[n]) {
                        break;
                    }
                }
            }
            return;
        }

        for(int x=0; x<=X; x++){
            tmpHams[cnt] = x;
            // 현재 cnt가 기록의 마지막 순간일 때만 호출 -> 가지치기
            if(!checkRecord(cnt)) continue;
            countHam(cnt+1, totalHam+x);
        }
    }

    private static boolean checkRecord(int cnt) {
        for(int m=0; m<M; m++){
            int end = record[m][1] - 1;
            if(end == cnt){
                int start = record[m][0] - 1;
                int sum = 0;
                for(int s = start; s <= end; s ++){
                    sum += tmpHams[s];
                }
                if(sum != record[m][2]){
                    return false;
                }
            }
        }
        return true;
    }
}