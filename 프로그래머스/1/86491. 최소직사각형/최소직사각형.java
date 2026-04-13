class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        // 긴 쪽이 전부 같은 방향이 있을 것
        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0]<sizes[i][1]){
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
        }
        int maxH = 0;
        int maxW = 0;
        for(int i=0; i<sizes.length; i++){
            maxH = Math.max(maxH, sizes[i][0]);
            maxW = Math.max(maxW, sizes[i][1]);
        }
        answer = maxH*maxW;
        return answer;
    }
}