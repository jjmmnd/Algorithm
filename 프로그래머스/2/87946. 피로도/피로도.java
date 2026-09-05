class Solution {
    boolean[] select;
    int num, maxCnt;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        
        // 던전은 최대 8개
        // 최대한 많이
        // 순열
        
        num = dungeons.length;
        select = new boolean[num];
        
        for(int i=0; i<num; i++){
            if(dungeons[i][0] <= k){
                select[i] = true;
                dfs(k-dungeons[i][1], 1, dungeons);
                select[i] = false;
            }
        }
        
        return maxCnt;
    }
    
    public void dfs(int left, int cnt, int[][] dungeons){

        for(int i=0; i<num; i++){
            if(!select[i] && dungeons[i][0] <= left){
                select[i] = true;
                dfs(left-dungeons[i][1], cnt+1, dungeons);
                select[i] = false;
            }
        }
        maxCnt = Math.max(maxCnt, cnt);
    }
}