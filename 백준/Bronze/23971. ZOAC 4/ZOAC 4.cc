#include <iostream>
#include <cmath>

// 테이블은 행마다 W개씩 H행
// 세로로 N칸 or 가로로 M칸 이상 거리두기 
// 최대 수용할 수 있는 인원 구하기

using namespace std;

int main()
{
	// double 선언 필수 ..
	double H, W, N, M;
	cin >> H >> W >> N >> M;

	// 가로에 몇 명 둘지, 세로에 몇 명 둘지 구한 뒤 곱하기
	// 거리 + 1(사람)이 세트
	// e.g) 5/2 = 2.5 = 3으로 취급 -> 반올림, ceil
	int result = (int)ceil(H / (N + 1)) * (int)ceil(W / (M + 1));
	cout << result;

}