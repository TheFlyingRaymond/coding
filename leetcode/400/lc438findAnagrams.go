func findAnagrams(s string, p string) []int {
	slen, plen := len(s), len(p)
	if slen < plen {
		return []int{}
	}
	scount := make([]int, 26)
	pcount := make([]int, 26)

	for i := 0; i < plen; i++ {
		scount[s[i]-'a']++
		pcount[p[i]-'a']++
	}

	var ret []int
	if check(scount, pcount) {
		ret = append(ret, 0)
	}

	for i := 0; i < slen-plen; i++ {
		scount[s[i]-'a']--
		scount[s[i+plen]-'a']++
		if check(scount, pcount) {
			ret = append(ret, i+1)
		}
	}

	return ret
}

func check(a []int, b []int) bool {
	for i := 0; i < 26; i++ {
		if a[i] != b[i] {
			return false
		}
	}
	return true
}