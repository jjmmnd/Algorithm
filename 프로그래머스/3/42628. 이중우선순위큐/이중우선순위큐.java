import java.util.*;

class Solution {

    public int[] solution(String[] operations) {

        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq =
                new PriorityQueue<>(Collections.reverseOrder());

        Map<Integer, Integer> count = new HashMap<>();

        for (String op : operations) {

            StringTokenizer st = new StringTokenizer(op);

            String command = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            if (command.equals("I")) {

                minPq.offer(num);
                maxPq.offer(num);

                count.put(num,
                        count.getOrDefault(num, 0) + 1);

            } else {

                // 삭제된 값들을 먼저 정리
                clean(minPq, count);
                clean(maxPq, count);

                if (num == -1) {

                    if (!minPq.isEmpty()) {
                        int removed = minPq.poll();
                        count.put(removed,
                                count.get(removed) - 1);
                    }

                } else {

                    if (!maxPq.isEmpty()) {
                        int removed = maxPq.poll();
                        count.put(removed,
                                count.get(removed) - 1);
                    }
                }
            }
        }

        // 마지막으로 stale 데이터 제거
        clean(minPq, count);
        clean(maxPq, count);

        if (minPq.isEmpty() || maxPq.isEmpty()) {
            return new int[]{0, 0};
        }

        return new int[]{
                maxPq.peek(),
                minPq.peek()
        };
    }

    private void clean(
            PriorityQueue<Integer> pq,
            Map<Integer, Integer> count) {

        while (!pq.isEmpty() && count.get(pq.peek()) == 0) {
            pq.poll();
        }
    }
}