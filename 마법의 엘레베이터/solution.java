package sample;

import java.util.Arrays;

public class solution {

	public static void main(String[] args) {
		
		int storey = 2554;
		int result = 0;
		
		while(storey > 0) {
			
			int remain = storey % 10; // 일의 자리 수
			int next = storey / 10; // 10으로 나눈 몫
			
			// 일의 자리 수가 5보다 클 경우, + 버튼으로 이동
			// 일의 자리 수가 5보다 작을 경우, - 버튼으로 이동
			if(remain > 5) {
				result += (10 - remain);
				storey += (10 - remain);
			} else if(remain < 5) {
				result += remain;
				storey -= remain;
			} else {
				// 일의 자리 수가 5일 경우
				// 십의 자리 수가 5보다 작을 경우는 - 버튼으로 이동
				// 십의 자리 수가 5보다 클 경우는 + 버튼으로 이동
				if(next % 10 < 5) {
					result += remain;
					storey -= remain;
				} else {
					result += (10 - remain);
					storey += (10 - remain);
				}
			}
			
			// 원래 수를 10으로 나눈 몫으로 반복문을 수행함
			storey /= 10;
		}
		
		System.out.println(result);
	}

}
