import java.io.*;
import java.util.*;

// 단어 조건: 알파벳 소문자와 숫자로 이루어진 부분 문자열 
// 태그: <>
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		// 1. 주어진 문자열을 순회
			// 공백 이나 <을 만나기 전까지가 단어.
			// >다음에 공백이 아닌 숫자나 문자를 만나면 단어 시작
		
		StringBuilder sb = new StringBuilder();
		ArrayDeque<Character> stack = new ArrayDeque<>();
		boolean word = true;
		boolean tag = false;
		for(int i=0; i<str.length(); i++) {
			char cur = str.charAt(i);
			if(cur == '<') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				tag = true;
				sb.append(cur);
				continue;
			}
			
			if(cur == '>') {
				tag = false;
				sb.append(cur);
				continue;
			}
			
			if(tag) {
				sb.append(cur);
				continue;
			}

			if(cur == ' ') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(cur);
				continue;
			}
			
			// 단어 시작
			stack.push(cur);
//			System.out.println(cur);
			
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb);
	}
}
