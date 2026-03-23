import java.util.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static long a, b;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        Queue<long[]> q = new ArrayDeque<>();
        q.add(new long[] {a*2, 2});
        q.add(new long[] {a*10+1, 2});

        long min = -1;
        while(!q.isEmpty()){
            long[] cur = q.poll();
            long num = cur[0];
            long cnt = cur[1];
            if(num == b){
                min = cnt;
                break;
            }
            if(num > b){
                continue;
            }

            q.add(new long[]{num*2, cnt+1});
            q.add(new long[]{num*10+1, cnt+1});
        }

        System.out.println(min);
    }
}