class Solution {
    public int solution(int n) {
		int cnt = Integer.bitCount(n);
		String binary = Integer.toBinaryString(n);
		int one = countChar(binary, '1');
		
		while(true) {
			n++;
			binary = Integer.toBinaryString(n);
			int o = countChar(binary, '1');
			
			if(one == o) return n;
		}
    }
    
    public static int countChar(String binary, char ch) {
        int count = 0;
		for(int i=0; i<binary.length(); i++) {
        	if(binary.charAt(i) == ch) count++;
        }
		return count;
    }
}
