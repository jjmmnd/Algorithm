#include <iostream>
#include <map>
#include <vector>
#include <algorithm>

using namespace std;

/* 우선순위 */
/*
* 1. 자주 나오는 거 먼저
* 2. 길이 길수록
* 3. 알파벳 사전 순
*/

int main()
{
	// 1. 단어 개수 2. 최소 길이
	int N, M;
	cin >> N >> M;

	map<string, int> m_Word;

	string s_In;
	for (int i = 0; i < N; i++)
	{
		cin >> s_In;
		// M 이상인 경우만 맵에 삽입
		if (s_In.size() >= M)
			m_Word[s_In]++;
	}

	// 람다식을 이용
	vector<pair<string, int>> v_Word(m_Word.begin(), m_Word.end());
	sort(v_Word.begin(), v_Word.end(), [](pair<string, int> const& left, pair<string, int> const& right)
		{
			if (left.second != right.second)
				return left.second > right.second;
			else if (left.first.length() != right.first.length())
				return left.first.length() > right.first.length();
			else
				return left.first < right.first;	// 사전순
		}
	);

	for (auto& val : v_Word)
	{
		cout << val.first << '\n';
	}

}