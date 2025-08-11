#include <iostream>
#include <vector>
#include <queue>

using namespace std;

class Node {
public:
	char data;
	Node* left = NULL;
	Node* right = NULL;
};

void preorder(Node* n) {
	cout << n->data;
	if (n->left != NULL)
		preorder(n->left);
	if (n->right != NULL)
		preorder(n->right);
}

void inorder(Node* n) {
	if (n->left != NULL)
		inorder(n->left);
	cout << n->data;
	if (n->right != NULL)
		inorder(n->right);
}

void postorder(Node* n) {
	if (n->left != NULL)
		postorder(n->left);
	if (n->right != NULL)
		postorder(n->right);
	cout << n->data;
}

int main()
{
	int N;
	cin >> N;

	vector<Node> node(26);	// 0번:A ~ 25번:Z *아스키로 빼면 0부터 사용 가능
	Node* root;

	for (int i = 0; i < N; i++) {
		char me, left, right;
		cin >> me >> left >> right;
		node[me - 'A'].data = me;
		if (left != '.')
			node[me - 'A'].left = &node[left - 'A'];
		if (right != '.')
			node[me - 'A'].right = &node[right - 'A'];
	}

	// 항상 A가 root 노드로 시작
	preorder(&node[0]);
	cout << '\n';
	inorder(&node[0]);
	cout << '\n';
	postorder(&node[0]);
	cout << '\n';

}