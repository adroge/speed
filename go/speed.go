package main

import (
	"fmt"
	"math/rand"
	"sort"
	"strings"
	"time"
)

const ITERATIONS int = 50000000

func main() {

	v1 := make([]float64, 0)
	v2 := make([]float64, 0)
	vAdd := make([]float64, 0)
	vSub := make([]float64, 0)
	vMult := make([]float64, 0)
	vDiv := make([]float64, 0)

	startTime := time.Now()

	fmt.Printf("Hello, world!\n")

	for j := 0; j < 5; j++ {
		v1 = make([]float64, 0)
		v2 = make([]float64, 0)
		for i := 0; i < ITERATIONS; i++ {
			v1 = append(v1, getRandomDouble())
			v2 = append(v2, getRandomDouble())
		}
	}
	logTime("populate vectors 5x", startTime)

	for j := 0; j < 20; j++ {
		for i := 0; i < len(v1); i++ {
			vAdd = append(vAdd, v1[i]+v2[i])
		}
		vAdd = make([]float64, 0)

		for i := 0; i < len(v1); i++ {
			vSub = append(vSub, v1[i]-v2[i])
		}
		vSub = make([]float64, 0)

		for i := 0; i < len(v1); i++ {
			vMult = append(vMult, v1[i]*v2[i])
		}
		vMult = make([]float64, 0)

		for i := 0; i < len(v1); i++ {
			vDiv = append(vDiv, v1[i]/v2[i])
		}
		vDiv = make([]float64, 0)
	}
	logTime("float math 20x", startTime)

	bigmap := make(map[string]int)
	mapValues := make([]int, 0)
	vsKeys := make([]string, 0)

	for i := 0; i < ITERATIONS/10; i++ {
		bigmap[getRandomString(255)] = rand.Int()
	}
	logTime("populate map", startTime)

	for k, v := range bigmap {
		vsKeys = append(vsKeys, k)
		mapValues = append(mapValues, v)
	}
	bigmap = make(map[string]int)

	sort.Ints(mapValues)
	sort.Strings(vsKeys)
	mapValues = make([]int, 0)
	vsKeys = make([]string, 0)
	logTime("map lookup and sort vectors", startTime)

	// totalDuration := time.Since(startTime)
	// fmt.Printf("It took me %10.10f seconds.\n", float64(totalDuration)/float64(time.Second))

}

func getRandomString(length int) string {
	const characters = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
	var randomString strings.Builder
	const charactersLength int = len(characters)

	for i := 0; i < length; i++ {
		randomString.WriteByte(characters[rand.Int()%charactersLength])
	}

	return randomString.String()
}

func getRandomDouble() float64 {
	return rand.Float64()
}

func logTime(msg string, startTime time.Time) {
	fmt.Printf("%s %10.10f seconds\n", msg, float64(time.Since(startTime))/float64(time.Second))
}
