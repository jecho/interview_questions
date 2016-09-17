
/*
 *  Date 09/16/2016
 *  @author Jecho Ricafrente
 *
 *  iterative version;
 *	rotate array by a number that acts as a pivot, allocates a new array 
 *  copying elements after pivot, and then appending elements before pivot at end of arr
 *
 *	time complexity O(n)
 *	space complexity O(n)
 *
 */

package main

import "fmt"

func main() {
	generate()
}

// where n is the acting pivot to rotate at
func rotate(arr []int, n int) []int {
	size := len(arr)
	mod := n % size
	tmp := make([]int, size)
	
	for i:=0; i<size-mod; i++ {
		//tmp = append(tmp, arr[i])
		tmp[i] = arr[i + mod]
	}

	for i:=0; i<mod; i++ {
		tmp[size-mod+i] = arr[i]
	}

	return tmp
}

func print_array(arr []int) {
	fmt.Println("printing...")
	for _, element := range arr {
		fmt.Println(element)
	}
	fmt.Println("")
}

func generate() {
	mock_up := []int { 1,2,3,4,5,6 }

	// test cases
	new_arr := rotate(mock_up, 0)
	print_array(new_arr)
	new_arr = rotate(mock_up, 1)
	print_array(new_arr)
	new_arr = rotate(mock_up, 2)
	print_array(new_arr)
	new_arr = rotate(mock_up, 3)
	print_array(new_arr)
	new_arr = rotate(mock_up, 4)
	print_array(new_arr)
	new_arr = rotate(mock_up, 5)
	print_array(new_arr)
	new_arr = rotate(mock_up, 6)
	print_array(new_arr)
}
