// 최소 일수 -> bfs -> queue

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int main()
{
	int width;	// 가로 칸
	int height;	// 세로 칸
	cin >> width >> height;

	vector<vector<int>> box(width, vector<int>(height));
	queue<pair<int, int>> boxQ;	// (x, y) 순으로 들어감

	int temp;
	vector<int> tomato;
	for (int i = 0; i < width * height; i++)
	{
		cin >> temp;
		tomato.push_back(temp);
	}

	int curX;
	int curY;
	int zeroTomato = 0;
	int day = 1;

	int k = 0;
	for (int i = 0; i < height; i++)
	{
		for (int j = 0; j < width; j++)
		{
			box[j][i] = tomato[k];
			if (tomato[k] == 1)
			{
				//curX = j;
				//curY = i;
				boxQ.push(make_pair(j, i));

			}
			else if (tomato[k] == 0)
			{
				zeroTomato++;
			}

			k++;
		}
	}


	while (boxQ.size() > 0)
	{
		curX = boxQ.front().first;
		curY = boxQ.front().second;
		boxQ.pop();

		// 상
		if (curY - 1 >= 0 && box[curX][curY - 1] == 0)
		{
			boxQ.push(make_pair(curX, curY - 1));
			box[curX][curY - 1] = box[curX][curY] + 1;

			zeroTomato--;
		}
		
		// 하
		if (curY + 1 < height && box[curX][curY + 1] == 0)
		{
			boxQ.push(make_pair(curX, curY + 1));
			box[curX][curY + 1] = box[curX][curY] + 1;
			zeroTomato--;
		}

		// 좌
		if (curX - 1 >= 0 && box[curX - 1][curY] == 0)
		{
			boxQ.push(make_pair(curX - 1, curY));

			box[curX - 1][curY] = box[curX][curY] + 1;
			zeroTomato--;
		}

		// 우
		if (curX + 1 < width && box[curX + 1][curY] == 0)
		{
			boxQ.push(make_pair(curX + 1, curY));

			box[curX + 1][curY] = box[curX][curY] + 1;
			zeroTomato--;
		}

		if (boxQ.size() == 0)
		{
			day = box[curX][curY] - 1;
			break;
		}
	}

	if (zeroTomato != 0)
		cout << -1;
	else
		cout << day;
}
