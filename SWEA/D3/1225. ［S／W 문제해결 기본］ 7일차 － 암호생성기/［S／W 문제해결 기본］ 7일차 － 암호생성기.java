import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int k=1; k<=10; k++){
            int tc = Integer.parseInt(br.readLine());
            
            // 큐 이용
            ArrayDeque<Integer> q = new ArrayDeque<>();
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<8; i++) {
                q.offer(Integer.parseInt(st.nextToken()));
            }

            // 0보다 작아질 때까지 반복
            Integer num = 1;
            while(num > 0){
                // 한 사이클: 5번
                for(int i=1; i<=5; i++) {
                    num = q.poll();
                    num -= i;
                    if(num <= 0){
                        num = 0;
                        q.offer(num);
                        break;
                    }
                    q.offer(num);
                }
            }

            // 암호 출력
            System.out.print("#"+tc+" ");
            for(int i=0; i<8; i++)
                System.out.print(q.poll()+" ");
            System.out.println();
        }
    }
}