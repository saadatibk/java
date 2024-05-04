class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] prefix_balance = new int[n];
        int s = 0;
        int balance = 0;
    
    for (int i = 0; i < n; i++ ){
        if (nums[i] == 0 ) balance--;
        else balance++;

        prefix_balance[i] = balance;
    }

    int[] prefix_balance_value_first_seen_at = new int[2 * n +1];
    for (int i = 0; i < 2 * n + 1; i++){
        prefix_balance_value_first_seen_at[i] = -1;
    }
    for (int i = 0; i < n; i++){
        int value = prefix_balance[i];
        if(prefix_balance_value_first_seen_at[n + value] == -1){
            prefix_balance_value_first_seen_at[n + value] = i;
        }
    }
    int answer = 0;
    for (int i = 0; i < n; i++){
        int value = prefix_balance[i];
        int index = n + value;
        if (value == 0){
            answer = Math.max(answer,1);
        }
        answer = Math.max(answer, i - prefix_balance_value_first_seen_at[index]);
    }
    return answer;
}
}
