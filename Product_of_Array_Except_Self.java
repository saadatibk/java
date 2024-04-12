class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pref_mul = new int[n];
        int[] suf_mul = new int[n];

        for (int i = 0; i < n; i++){
            pref_mul[i] = 1;
            suf_mul[i] = 1;
        }

        pref_mul[0] = nums[0];
        for (int i = 1; i < n; i++){
            pref_mul[i] = pref_mul[i - 1] * nums[i];
        } 

        suf_mul[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0 ; i--){
            suf_mul[i] = suf_mul[i + 1] * nums[i];
        }

        int[] answer = new int[n];
        answer[0] = suf_mul[1];
        answer[n - 1] = pref_mul[n-2];
        for(int i = 1 ; i < n - 1; i++){
            answer[i] = pref_mul[i - 1] * suf_mul[i + 1];
        }

        return answer;
    }
}
