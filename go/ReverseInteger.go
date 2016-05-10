 
// 	Date 05/09/2016
// 	@author Jecho Ricafrente
// 
// 	Reverse an Integer
// 
// 	Time complexity is O(n)
//	Space complexity is O(1)

func reverseInt(x int) int {
	sign := false
	if (x < 0) {
		sign = true
		x *= -1
	}

	rev := 0
	for ; x > 0; {
		mod := x % 10
		rev = rev * 10 + mod
		x /= 10
	}

	if (sign) {
        rev *= -1
    }

    return rev;
}