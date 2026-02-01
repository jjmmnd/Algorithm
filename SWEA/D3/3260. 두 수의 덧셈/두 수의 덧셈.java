import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            
            // 두 수를 받고 큰 자리 수 배열에 넣기
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            String s2 = st.nextToken();

            // 배열의 길이 확정
            int len = (s1.length() > s2.length()) ? s1.length() : s2.length();
            int[] arr1 = new int[len+1];
            int[] arr2 = new int[len+1];
            int[] result = new int[len+1];

            // 뒤집어서 arr에 넣기
            for (int i = 0; i < s1.length(); i++)
                arr1[i] = s1.charAt(s1.length() - 1 - i) - '0';
            for (int i = 0; i < s2.length(); i++)
                arr2[i] = s2.charAt(s2.length() - 1 - i) - '0';

            // 순회하면서 계산
            int carry = 0;
            for (int i = 0; i <= len; i++) {
                int sum = arr1[i] + arr2[i] + carry;
                result[i] = sum%10;
                carry = sum/10;
            }

            // result의 뒤부터 출력
            System.out.print("#"+tc+" ");
            if(result[len] != 0)
                System.out.print(result[len]);
            for(int i=len-1; i>=0; i--)
                System.out.print(result[i]);
            System.out.println();
        }
    }
}