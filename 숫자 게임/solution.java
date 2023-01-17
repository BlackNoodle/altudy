import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        // 배열 정렬 후, 뒤에서부터 비교
        int indexA = A.length - 1;
        int indexB = B.length - 1;
        
        for(int i=indexA; i>=0; i--) {
            // B의 값이 A보다 클 경우, 승점을 획득하고
            // B의 인덱스를 작은 숫자 방향으로 옮기며 반복적으로 비교한다.
            if(A[i] < B[indexB]) {
                answer++;
                indexB--;
            }
            
            // A = [1,3,5,7] B = [1,2,4,6]일 때
            // A[3] = 7, B[3] = 6은 B가 작으니 A의 인덱스를 작은 숫자 방향으로 옮겨 다시 비교한다.
            // A[2] = 5, B[3] = 6은 B가 크니 A와 B의 인덱스를 모두 작은 숫자 방향으로 옮긴다.
        }
        
        return answer;
    }
}
