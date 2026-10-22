import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        
        // 차량별 누적 주차 시간
        // 기본시간 이하 / 초과
        
        Map<String, String> inMap = new HashMap<>(); // 번호-입차시간
        
        Map<String, Integer> outMap = new HashMap<>(); // 번호-누적시간
        
        Map<String, Integer> resultMap = new HashMap<>(); // 번호-주차요금
        
        StringTokenizer st;
        for(String record: records){
            st = new StringTokenizer(record);
            
            // 번호 기준으로 찾아야함
            // 여러번 in out 가능 (한 쌍 ㄴㄴ)
            // 해시에 번호 기준으로 넣어놓고 있으면 계산해서 저장.
            
            String time = st.nextToken();
            String carNum = st.nextToken();
            String cont = st.nextToken();
            
            if(cont.equals("IN")){
                inMap.put(carNum, time);
            } else {
                // 누적
                int totalTime = 0;
                // 주차요금 계산
                String inTime = inMap.get(carNum);
                // 분단위로 변환
                st = new StringTokenizer(inTime, ":");
                int ihh = Integer.parseInt(st.nextToken());
                int imm = Integer.parseInt(st.nextToken());
                st = new StringTokenizer(time, ":");
                int ohh = Integer.parseInt(st.nextToken());
                int omm = Integer.parseInt(st.nextToken());
                int inTime_m = ihh*60 + imm;
                int outTime_m = ohh*60 + omm;
                totalTime = outTime_m - inTime_m;
                
                outMap.put(carNum, outMap.getOrDefault(carNum, 0) + totalTime);
                inMap.remove(carNum);

            }
        }
        
        // 출차 표시 없는애들도 누적맵에 갱신
        if(inMap.size() > 0){
            for(Map.Entry<String, String> entry: inMap.entrySet()){
                String carNum = entry.getKey();
                String inTime = entry.getValue();
                
                st = new StringTokenizer(inTime, ":");
                int ihh = Integer.parseInt(st.nextToken());
                int imm = Integer.parseInt(st.nextToken());
                int totalTime = (23*60+59) - (ihh*60 + imm);
                
                outMap.put(carNum, outMap.getOrDefault(carNum, 0) + totalTime);
            }
        }
        
        // 각 비용 계산해서 result에 정리
        for(Map.Entry<String, Integer> entry: outMap.entrySet()){
            String carNum = entry.getKey();
            Integer totalTime = entry.getValue();
            
            
            if(totalTime <= fees[0]){
                resultMap.put(carNum, fees[1]);
            } else {
                resultMap.put(carNum, fees[1] + (int)(Math.ceil((double)(totalTime-fees[0])/fees[2])) * fees[3]);
            }
        }
        
 
        // 차량 번호 작은순으로 리턴
        Map<String, Integer> sortedMap = new TreeMap<>(resultMap);
        answer = new int[resultMap.size()];
        int i = 0;
        for(int result : sortedMap.values()){
            answer[i++] = result;
        }
        
        return answer;
    }
}