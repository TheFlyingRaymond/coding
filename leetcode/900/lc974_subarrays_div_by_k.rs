impl Solution {
    pub fn subarrays_div_by_k(nums: Vec<i32>, k: i32) -> i32 {
        use std::collections::HashMap;

        let mut count = 0;
        let mut mod_count = HashMap::new();
        let mut sum = 0;

        mod_count.insert(0,1);

        for &num in nums.iter(){
            sum += num;

            let modV = (sum%k -k) %k;

            if let Some(&c) = mod_count.get(&modV){
                count +=c;
            }

            *mod_count.entry(modV).or_insert(0) += 1;
        }

        count
    }
}