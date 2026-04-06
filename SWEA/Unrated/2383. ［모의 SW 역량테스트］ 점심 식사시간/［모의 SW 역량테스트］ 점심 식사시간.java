import java.io.*;
import java.sql.Array;
import java.util.*;

public class Solution {

    // 계단까지의 거리
    static class Person{
        int h, w, dist;
        Person(int h, int w){
            this.h = h;
            this.w = w;
        }
    }

    static class Stair{
        int h, w, len;
        Stair(int h, int w, int len){
            this.h = h;
            this.w = w;
            this.len = len;
        }
    }

    static int n, grid[][], perCnt, min;
    static int select[];
    static Stair stairs[];
    static Person persons[];
    public static void main(String[] args) throws IOException{
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=t; tc++) {
            n = Integer.parseInt(br.readLine());
            grid = new int[n][n];
            stairs = new Stair[2];
            persons = new Person[n*n];
            min = Integer.MAX_VALUE;
            perCnt = 0;

            int stairCnt = 0;
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                    if(grid[i][j]==1) {
                        persons[perCnt++] = new Person(i, j);
                    } else if(grid[i][j]>1) {
                        stairs[stairCnt++] = new Stair(i, j,  grid[i][j]);
                    }
                }
            }

            select = new int[perCnt];
            comb(0);
            System.out.println("#"+tc+" "+min);
        }


        // 각 사람들은 2개의 계단 중 한 개를 선택
        // 각각의 계단은 동시에 3명까지 수용 가능
        // 부분집합의 기저에서 총 소요시간을 min에 갱신

    }

    static void comb(int cnt) {

        if(cnt == perCnt) {
            List<Person> list0 = new ArrayList<>();
            List<Person> list1 = new ArrayList<>();

            for(int i=0; i<perCnt; i++){
                int dist = Math.abs(persons[i].h-stairs[select[i]].h)+Math.abs(persons[i].w-stairs[select[i]].w);
                persons[i].dist = dist;
                if(select[i]==0){
                    list0.add(persons[i]);
                } else {
                    list1.add(persons[i]);
                }
            }

            // 먼저 도착한 애부터 빼서 처리
            Collections.sort(list0,(a, b)->Integer.compare(a.dist, b.dist));
            Collections.sort(list1,(a, b)->Integer.compare(a.dist, b.dist));

            int finishList0 = calc(list0, stairs[0].len);
            int finishList1 = calc(list1, stairs[1].len);
            int finish = Math.max(finishList0, finishList1);

            // min 갱신
            min = Math.min(min, finish);
            return;
        }

        // 계단 인덱스를 0을 고르거나 1을 고르거나
        select[cnt] = 0;
        comb(cnt+1);
        select[cnt] = 1;
        comb(cnt+1);
    }

    static int calc(List<Person> list, int stairLen){
        Queue<Integer> q = new ArrayDeque<>(); // 완료시간들
        int lastEndTime = 0;

        for(Person p: list){
            int arriveTime = p.dist; // 계단 도착 시간

            if(q.size()>=3){
                // 이미 3명이 차있으면 가장 빨리 나가는 사람의 시간 더해주기
                int tmp = q.poll();

                int startTime = Math.max(arriveTime + 1, tmp);
                int endTime = startTime + stairLen;

                q.offer(endTime);
                lastEndTime = endTime;

            } else{
                int endTime = arriveTime + 1 + stairLen;
                q.offer(endTime);
                lastEndTime = endTime;
            }
        }

        return lastEndTime;
    }

}
