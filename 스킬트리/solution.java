import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(int i=0; i<skill_trees.length; i++) {
			String select = skill_trees[i];
            
			// 스킬에 존재하지 않는 알파벳은 모두 삭제
			for(int j=0; j<skill_trees[i].length(); j++) {
				String alpha = skill_trees[i].substring(j, j+1);
				if(skill.indexOf(alpha) == -1) {
					select = select.replace(alpha, "");
				}
			}
			
			// 삭제된 스킬트리가 순서대로 스킬에 존재하는지 확인
			if(skill.indexOf(select) == 0) {
				answer++;
			}
		}
        
        return answer;
    }
}
