#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct Student{
	string name;
	int korean;
	int english;
	int math;
};

int main()
{
	int N;
	cin >> N;
	vector<Student> v(N);

	for (int i = 0; i < N; i++)
	{
		cin >> v[i].name >> v[i].korean >> v[i].english >> v[i].math;
	}

	sort(v.begin(), v.end(), [](const Student a, const Student b) {
		if (a.korean != b.korean) return a.korean > b.korean;
		if (a.english != b.english) return a.english < b.english;
		if (a.math != b.math) return a.math > b.math;
		return a.name < b.name;
		});
	
	for (int i = 0; i < N; i++)
	{
		cout << v[i].name;
		cout << "\n";
	}
}