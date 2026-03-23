import java.util.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static List<Long> list = new ArrayList<>();
    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // 최대 숫자는 9876543210 일 수밖에 없음. !!
        // 숫자 10개로 만들 수 있는 모든 부분집합의 개수 = 감소하는 수의 개수 = 2^10-1

        if(n > 1022){
            System.out.println(-1);
            return;
        }

        for(int i=0; i<=9; i++){
            dfs(i);
        }
        
        Collections.sort(list);

        // idx번째
        System.out.println(list.get(n));
    }

    public static void dfs(long num){
        list.add(num);
        long lastNum = num % 10;
        for(int i=0; i<lastNum; i++){
            dfs(num*10 + i);
        }
    }
}