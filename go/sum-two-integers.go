//
// 	@date 	04/1/2017
// 	@author Jecho Ricafrente
//
//	Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
//	Time complexity: O(n), Space complexity: O(1)
//

package main

import (
	"fmt"
)

func sumNumbers(a int, b int) int {
	for {
		if b == 0 {
			break;
		}
		carry := a & b
		a ^= b
		b = carry << 1
	}

	return a
}

func main() {

	a1 := 5
	b1 := 6
	a2 := 4
	b2 := 5
	a3 := 0
	b3 := 2
	res1 := sumNumbers(a1, b1)
	res2 := sumNumbers(a2, b2)
	res3 := sumNumbers(a3, b3)

	fmt.Println("Is", a1, "and", b1, a1+b1, "=", res1, "?")
	fmt.Println("Is", a2, "and", b2, a2+b2, "=", res2, "?")
	fmt.Println("Is", a3, "and", b3, a3+b3, "=", res3, "?")
}