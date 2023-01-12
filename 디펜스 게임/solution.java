import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i<enemy.length; i++) {
            queue.add(enemy[i]); // 현재 적의 수를 큐에 넣음
        	
        	// 무적권 수보다 적 라운드가 많을 경우
        	if(queue.size() > k) {
        		// 적은 수의 적을 가진 라운드에서 병사 희생
        		n -= queue.poll();
        	}
        	
        	// 팀위 수가 모두 소멸되었을 때
        	if(n < 0) {
        		return i;
            }
        }
        return enemy.length;
    }
}
