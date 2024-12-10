impl Solution {
    pub fn subarray_sum(nums: Vec<i32>, k: i32) -> i32 {
        let n = nums.len();
        let mut prefix_sums = vec![0;n+1];

        for i in 0..n{
            prefix_sums[i+1] = prefix_sums[i] + nums[i];
        }

        let mut count = 0;

        for i in 0..=n{
            for j in 0..i{
                if prefix_sums[i] - prefix_sums[j] == k{
                    count +=1;
                }
            }
        }

        count
    }


    pub fn subarray_sum2(nums: Vec<i32>, k: i32) -> i32 {
        use std::collections::HashMap;

        let mut count = 0;
        let mut sum = 0;
        let mut prefix_sum = HashMap::new():

        prefix_sum.insert(0,1);

        for &num in nums.iter(){
            sum += num;

            if let Some(&c) = prefix_sum.get(&(sum -k)){
                count += c;
            }

            *prefix_sum.entry(sum).or_insert(0) += 1;
        }

        count
    }
}