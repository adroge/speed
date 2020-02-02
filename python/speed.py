import time
import random

def logTime(message, startTime):
	print (message , time.time() - startTime, "seconds")

def getRandomDouble():
		return random.random()

def getRandomString(length):
	characters = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
	randomString = ""
	LEN = len(characters) - 1
	
	for index in range(0, length):
		index = random.randint(0, LEN)
		randomString += characters[index]

	return randomString

ITERATIONS = 50000000

v1 = []
v2 = []
vAdd = []
vSub = []
vMult = []
vDiv = []

startTime = time.time()

print("Hello world!")

for i in range(0, 5):
	v1 = []
	v2 = []
	for j in range(ITERATIONS):
		v1.append(getRandomDouble())
		v2.append(getRandomDouble())

logTime("populate vectors 5x", startTime)

for j in range(0, 20):
	for i in range(0, len(v1)):
		vAdd.append(v1[i]+v2[i])
	
	vAdd = []

	for i in range(0, len(v1)):
		vSub.append(v1[i]-v2[i])
	
	vSub = []

	for i in range(0, len(v1)):
		vMult.append(v1[i]*v2[i])
	
	vMult = []

	for i in range(0, len(v1)):
		vDiv.append(v1[i]/v2[i])
	
	vDiv = []

logTime("float math 20x", startTime)

bigmap = dict()
mapValues = []
vsKeys = []

for i in range(0, int(ITERATIONS/10)):
	bigmap[getRandomString(255)] = random.randint(0, 2147483647)

logTime("populate map", startTime)

for key, value in bigmap.items():
	vsKeys.append(key)
	mapValues.append(value)

bigmap = dict()

mapValues.sort()
vsKeys.sort()
mapValues = []
vsKeys = []
logTime("map lookup and sort vectors", startTime)
