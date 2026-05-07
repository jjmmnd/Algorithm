// 1. 단위를 늘려가면서 압축 -> 바깥 반복문 -> 가능한 최대길이는 절반
// 2. 그 중 가장 짧은 것
class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        
        for(int len = 1; len <= s.length()/2; len++){
            String str = "";
            // base가 몇번 반복되는지
            int cnt = 1;
            String next = "";
            String base = s.substring(0, len);
            for(int i = len; i<s.length(); i+=len){
                // 범위 오버플로 방지 ㅠㅠ
                int end = Math.min(i+len, s.length()); 
                next = s.substring(i, end);
                if(base.equals(next)){
                    cnt++;
                } else {
                    if(cnt>1){
                        str += Integer.toString(cnt);
                    }
                    str += base;
                    // System.out.println(base + " " + next);
                    // System.out.println(str);
                    base = next;
                    cnt = 1;
                }
            }
            if(cnt>1){
                str += Integer.toString(cnt);
            }
            str += next;
            // System.out.println(next);
            // System.out.println(str);
            answer = Math.min(str.length(), answer);
        }
        
        answer = Math.min(s.length(), answer);
        return answer;
    }
}