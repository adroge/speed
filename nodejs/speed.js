const ITERATIONS = 50000000

let v1 = [],
	v2 = [],
	vAdd = [],
	vSub = [],
	vMult = [],
	vDiv = []

let startTime = Date.now()

console.log("Hello, world!")

for (let j = 0; j < 5; j++) {
	v1 = []
	v2 = []
	for (let i = 0; i < ITERATIONS; i++) {
		v1.push(getRandomDouble())
		v2.push(getRandomDouble())
	}
}
logTime("populate vectors 5x", startTime)


for (let j = 0; j < 20; j++) {
	for (let i = 0; i < v1.length; i++) {
		vAdd.push(v1[i] + v2[i])
	}
	vAdd = []

	for (let i = 0; i < v1.length; i++) {
		vSub.push(v1[i] - v2[i])
	}
	vSub = []

	for (let i = 0; i < v1.length; i++) {
		vMult.push(v1[i] * v2[i])
	}
	vMult = []

	for (let i = 0; i < v1.length; i++) {
		vDiv.push(v1[i] / v2[i])
	}
	vDiv = []
}
logTime("float math 20x", startTime)

let bigmap = {}
let mapValues = [],
	vsKeys = []

for (let i = 0; i < ITERATIONS / 10; ++i) {
	bigmap[getRandomString(255)] = Math.floor(Math.random() * Number.MAX_SAFE_INTEGER)
}
logTime("populate map", startTime)

for (let item in Object.keys(bigmap)) {
	mapValues.push(bigmap[item])
	vsKeys.push(item)
}
bigmap = {}

mapValues.sort()
vsKeys.sort()
mapValues = []
vsKeys = []
logTime("map lookup and sort vectors", startTime)


function getRandomString(len) {
	let result = ''
	const characters = '1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz',
		charactersLength = characters.length

	for (let i = 0; i < len; i++) {
		result += characters.charAt(Math.floor(Math.random() * charactersLength))
	}
	return result
}

function getRandomDouble() {
	return Math.random()
}

function logTime(msg, startTime) {
	console.log(msg, (Date.now() - startTime)/1000, "seconds")
}