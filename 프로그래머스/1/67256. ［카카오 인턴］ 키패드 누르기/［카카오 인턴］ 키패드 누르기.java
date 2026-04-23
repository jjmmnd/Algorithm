import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[][] phone = {{3,1}, {0,0}, {0,1}, {0,2},
                         {1,0}, {1,1}, {1,2},
                         {2,0}, {2,1}, {2,2}};
        int[] r = {3, 2};
        int[] l = {3, 0};
        for(int num: numbers){
            if(num==1 || num==4 || num==7){
                answer += "L";
                l[0] = phone[num][0];
                l[1] = phone[num][1];
            } else if(num==3 || num==6 || num==9){
                answer += "R";
                r[0] = phone[num][0];
                r[1] = phone[num][1];
            } else {
                // 2 5 8 0
                int rDiff = Math.abs(r[0]-phone[num][0])
                    +Math.abs(r[1]-phone[num][1]);
                int lDiff = Math.abs(l[0]-phone[num][0])
                    +Math.abs(l[1]-phone[num][1]);
                if(rDiff < lDiff){
                    answer += "R";
                    r[0] = phone[num][0];
                    r[1] = phone[num][1];
                }else if(rDiff > lDiff){
                    answer += "L";
                    l[0] = phone[num][0];
                    l[1] = phone[num][1];
                }else{
                    if(hand.equals("left")){
                        answer += "L";
                        l[0] = phone[num][0];
                        l[1] = phone[num][1];
                    } else{
                        answer += "R";
                        r[0] = phone[num][0];
                        r[1] = phone[num][1];
                    }
                }
            }
            
        }
        return answer;
    }
}