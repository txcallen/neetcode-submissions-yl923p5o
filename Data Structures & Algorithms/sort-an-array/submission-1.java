class Solution {
    public int[] sortArray(int[] nums) {
        

        mergeSort(nums, 0, nums.length-1);

        return nums;
    }


    void mergeSort(int[] nums, int left, int right){
        if(left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid+1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] arr, int l, int m, int r) {
        ArrayList<Integer> tmp = new ArrayList<>();

        int i = l, j = m+1;

        while(i <= m && j <= r){
            if(arr[i] < arr[j]){
                tmp.add(arr[i]);
                i++;
            }else{
                tmp.add(arr[j]);
                j++;
            }
        }

        while(i <= m){
            tmp.add(arr[i++]);
        }

        while(j <= r){
            tmp.add(arr[j++]);
        }

        for(i = l; i <= r; i++){
            arr[i] = tmp.get(i - l);
        }
    }
}