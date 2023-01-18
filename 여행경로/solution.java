import java.util.*;

class Solution {
    static ArrayList<String> al = new ArrayList<String>(); // 경로 리스트
    
    public String[] solution(String[][] tickets) {
        boolean[] visited = new boolean[tickets.length]; 
		
		dfs(0, "ICN", "ICN", tickets, visited); // 인천에서 출발
		Collections.sort(al); // 오름차순 정렬
		
		return al.get(0).split("/"); // 가장 알파벳 순이 앞서는 경로 선택
    }
    
    public static void dfs(int length, String depart, String route, String[][] tickets, boolean[] visited) {
		if(length == tickets.length) {
			al.add(route);
			return;
		}
		
		for(int i=0; i<tickets.length; i++) {
			// 다음 출발지 탐색하여 경로 데이터를 String 하나에 구분자(/)와 함께 축적함
			if(tickets[i][0].equals(depart) && visited[i] == false) {
				visited[i] = true; // 현재 경로 방문
				dfs(length + 1, tickets[i][1], route + "/" + tickets[i][1], tickets, visited);
				visited[i] = false; // 현재 경로 방문 해제
			}
		}
	}
}
