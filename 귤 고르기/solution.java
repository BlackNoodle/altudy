import java.util.*;
import java.util.Map.Entry;

class Solution {
    public int solution(int k, int[] tangerine) {
        // 배열의 숫자별 개수를 hashMap에 저장
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<tangerine.length; i++) {
			int n = tangerine[i];
			if(map.containsKey(n)) {
				map.put(n, map.get(n) + 1);
			} else {
				map.put(n, 1);
			}
		}
		
		// 내림차순 정렬
		List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        
		int count = 1;
		// k의 개수만큼 개수가 많은 것부터 종류를 고름
		for(Entry<Integer, Integer> entry : entryList){
			if(entry.getValue() >= k) break;
			else {
				k = (k - entry.getValue());
				count++;
			}
		}
        return count;
    }
}
