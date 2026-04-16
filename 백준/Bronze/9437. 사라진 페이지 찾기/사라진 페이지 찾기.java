import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(true){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if(n==0){
                break;
            }
            int p = Integer.parseInt(st.nextToken());

            int[] arr = new int[n+1];
            for(int i=1; i<=n; i++){
                arr[i] = i;
            }

            int s = 1;
            int e = n;
        
            while(s < e){
                int s1 = arr[s++];
                int s2 = arr[s++];
                int e2 = arr[e--];
                int e1 = arr[e--];
                if(s1==p){
                    sb.append(s2).append(" ").append(e1).append(" ").append(e2).append("\n");
                    break;    
                }
                else if(s2==p){
                    sb.append(s1).append(" ").append(e1).append(" ").append(e2).append("\n");
                    break;    
                }
                else if(e1==p){
                    sb.append(s1).append(" ").append(s2).append(" ").append(e2).append("\n");
                    break;    
                }
                else if(e2==p){
                    sb.append(s1).append(" ").append(s2).append(" ").append(e1).append("\n");   
                    break;
                }
            }
        
        }
        System.out.println(sb);
        
    }
}