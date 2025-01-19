func groupAnagrams(strs []string) [][]string {
	m := map[string][]string{}

	for _, s := range strs {
		bytes := []byte(s)
		slices.Sort(bytes)
		key := string(bytes)
		m[key] = append(m[key], s)
	}

	return slices.Collect(maps.Values(m))
}