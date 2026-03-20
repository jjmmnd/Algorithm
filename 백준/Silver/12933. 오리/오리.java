import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final String sound = "quack";
		char[] str = br.readLine().toCharArray();
//		String str = br.readLine();
		
		// 주어진 문자열에서 순서에 맞는 quack을 몇번 찾을 수 잇는지..
		// quack 순서가 아니라면 -1 출력
		
		int cnt = 0;
		int remain = str.length;
		while(remain > 0) {
			int soundIdx = 0;
			boolean isDuck = false;
			int[] idxArr = new int[5]; // null 처리할 인덱스를 저장
			for(int i=0; i<str.length; i++) {
				char cur = str[i];
				if(cur == sound.charAt(soundIdx)) {
					idxArr[soundIdx] = i;
					soundIdx++;	
					if(soundIdx == 5) {
						isDuck = true;
						soundIdx = 0;
						remain -= 5;
						
						// null 처리
						for(int j=0; j<5; j++) {
							str[idxArr[j]] = '\0';
						}
					}
				}
			}
			
			if(isDuck)
				cnt++;
			else
				break;
		}
		
		if(remain != 0)
			cnt = -1;
		System.out.println(cnt);
	}
}
