func lemonadeChange(bills []int) bool {
	five, ten := 0, 0
	for _, v := range bills {
		if v == 5 {
			five += 1
		} else if v == 10 {
			if five > 0 {
				ten += 1
				five -= 1
			} else {
				return false
			}
		} else {
			if five > 0 && ten > 0 {
				five -= 1
				ten -= 1
			} else if five >= 3 {
				five -= 3
			} else {
				return false
			}
		}
	}
	return true
}