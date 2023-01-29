class Solution {
    public long[] solution(long[] numbers) {
		long[] answer = new long[numbers.length];
		
		for(int i=0; i<numbers.length; i++) {
			String s1 = Long.toBinaryString(numbers[i]); // 2진수 변환
			
			if(numbers[i] % 2 == 0) { // 짝수일 경우, 무조건 일의 자리 수가 0이기에 1만 더함
                answer[i] = numbers[i] + 1;
                continue;
            } else {
            	int index = s1.lastIndexOf("0");
            	String s2;
            	
            	if(index != -1) { // 2진수에 0이 존재할 때, 가장 작은 자리 수의 0을 1로 변환
            		s2 = s1.substring(0, index) + "1" + s1.substring(index+1, s1.length());
            	} else { // 2진수에 0이 존재하지 않을 때, 맨 앞에 1을 붙여줌
            		s2 = "1" + s1;
            		index = 0;
            	}
            	
            	// 1을 변환하거나 붙여준 위치의 오른쪽(큰 자리 수에서 작은 자리 수) 방향으로 1을 찾아 0으로 변환
            	for(int j=index+1; j<s2.length(); j++) {
            		if(s2.substring(j, j+1).equals("1")) {
            			s2 = s2.substring(0, j) + "0" + s2.substring(j+1, s2.length());
            			break;
            		}
            	}
            	answer[i] = Long.valueOf(s2, 2);
            }
		}
		
		return answer;
    }
}
