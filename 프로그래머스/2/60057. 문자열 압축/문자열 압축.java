class Solution {
    public int solution(String s) {
        int answer = s.length(); // 1인 경우를 고려. 어차피 최대길이는 문자열의 길이
        int cnt = 1;
        
        // 압축 가능한 길이는 최대가 절반. -> 점점 늘려가기
        for(int len = 1; len <= s.length()/2; len++){
            String tmp = "";
            // len만큼 자른 문자열이 뒤의 문자열과 같은가?
            String prev = s.substring(0, len);
            for(int i = len; i <= s.length(); i+=len){
                int end = Math.min(i+len, s.length()); // 미포함 인덱스
                String cur = s.substring(i, end);
                
                if(prev.equals(cur)){
                    cnt++;
                } else {
                    // 다르다면. 기록?
                    if(cnt > 1)
                        tmp += cnt;
                    tmp += prev;
                    prev = cur;
                    cnt = 1;
                }
            }
            tmp += prev;
            // System.out.println(len+": "+tmp);
            answer = Math.min(tmp.length(), answer);
        }
        
        return answer;
    }
}