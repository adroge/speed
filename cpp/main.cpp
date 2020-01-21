#include <iostream>
#include <algorithm>
#include <chrono>
#include <vector>
#include <map>

using namespace std;
using namespace std::chrono;

const int ITERATIONS = 50000000;

double getRandomDouble();
string getRandomString(int length);
void logTime(string msg, steady_clock::time_point startTime);

int main(int argc, char** argv, char** arge) {

	steady_clock::time_point startTime = steady_clock::now();

	vector<double> v1, v2, vAdd, vSub, vMult, vDiv;

	cout << "Hello, world!\n";

	for (int j = 0; j < 5; ++j) {
		v1 = vector<double>();
		v2 = vector<double>();
		for (int i = 0; i < ITERATIONS; ++i) {
			v1.push_back(getRandomDouble());
			v2.push_back(getRandomDouble());
		}
	}
	logTime("populate vectors 5x", startTime);

	for (int j = 0; j < 20; ++j) {
		for (int i = 0; i < v1.size(); ++i) {
			vAdd.push_back(v1[i] + v2[i]);
		}
		vAdd = vector<double>();
		
		for (int i = 0; i < v1.size(); ++i) {
			vSub.push_back(v1[i] - v2[i]);
		}
		vSub = vector<double>();

		for (int i = 0; i < v1.size(); ++i) {
			vMult.push_back(v1[i] * v2[i]);
		}
		vMult = vector<double>();

		for (int i = 0; i < v1.size(); ++i) {
			vDiv.push_back(v1[i] / v2[i]);
		}
		vDiv = vector<double>();
	}
	logTime("float math 20x", startTime);

	map<string, int> bigmap;
	vector<int> mapValues;
	vector<string> vsKeys;

	for (int i = 0; i < ITERATIONS/10; ++i) {
		bigmap.insert(pair<string, int>(getRandomString(255), rand()));
	}
	logTime("populate map", startTime);

	for(map<string,int>::iterator it = bigmap.begin(); it != bigmap.end(); ++it) {
		mapValues.push_back(it->second);
		vsKeys.push_back(it->first);
	}
	bigmap = map<string, int>();

	sort(mapValues.begin(), mapValues.end());
	sort(vsKeys.begin(), vsKeys.end());
	mapValues = vector<int>();
	vsKeys = vector<string>();
	logTime("map lookup and sort vectors", startTime);
}

string getRandomString(int length) {
	const char characters[] = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    string randomString;
	const int len = sizeof(characters);

	for (int i = 0; i < length; ++i) {
		randomString += characters[rand() % len];
	}

	return randomString;
}

double getRandomDouble() {
	return (double)rand() / RAND_MAX;
}

void logTime(string msg, steady_clock::time_point startTime) {
	cout << msg << " " << duration_cast<duration<double>>(steady_clock::now() - startTime).count() << " seconds" << endl;
}
