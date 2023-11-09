class Solution {

    public void nextPermutation(int[] nums) {
        //1. 뒤에서부터 오름차순인 위치를 찾는다. st == 바꿀 위치
        int st = nums.length - 2;
        while(st >= 0 && nums[st] >= nums[st+1]){
            st--;
        }

        if(st < 0){
            Arrays.sort(nums);
            return;
        }
        
        int greater = nums.length -1; // st 보다 1 더 큰 위치
        //최소의 경우 맨 끝 위치, 최악의 경우에는 st + 1 위치가 선택된다.
        // st보다 다음 지점이 뒤에 있고, 현재 greater가 st보다 작은 경우에는 greater를 더 큰 곳으로 옮긴다.
        while( greater - 1 > st && nums[greater] <= nums[st] ){ 
            greater--;
        }
        //greater value를 st 기준점으로 옮긴 후, 오름차순 정렬
        swap(st, greater, nums);

        reverse(st+1, nums);
    }

    void reverse(int start, int [] arr){
        int L = start;
        int R = arr.length -1;
        while(L < R){
            swap(L++, R--, arr);
        }
    }
    void swap( int a, int b, int [] arr){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}