//
// 	@date 	04/11/2017
// 	@author Jecho Ricafrente
//
//	Given an array of integers, every element appears twice except for one. Find that single one.
//
//	Note:
//	Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
//
//	Time complexity: O(n), Space complexity: O(1)
//
package main

import (
	"fmt"
)

func singleNumberWithFor(arr[] int) int {
	res := 0
	if (arr == nil) {
		return res
	}

	sizeArr := len(arr)
	for i:= 0; i < sizeArr; i++ {
		res ^= arr[i]
	}

	return res
}

func singleNumberWithRange(arr[] int) int {
	res := 0
	if (arr == nil) {
		return res
	}

	for _, i := range arr {
		res ^= i
	}

	return res
}

func main() {

	arr := []int {1,2,3,4,2,1,3,6,6}
	arr2 := []int {0,0,3,4,5,7,4,3,5,2,2,1,1}
	result := singleNumberWithFor(arr)
	result2 := singleNumberWithRange(arr2)
	fmt.Println(result)
	fmt.Println(result2)
}