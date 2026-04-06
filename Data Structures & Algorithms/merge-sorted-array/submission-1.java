class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        
        int last = nums1.length-1;
        int i1 = m-1;
        int i2 = n-1;

        while(i1 >= 0 && i2 >= 0){
            if(nums1[i1] > nums2[i2]){
                nums1[last--] = nums1[i1--];
            }else if(nums1[i1] <= nums2[i2]){
                nums1[last--] = nums2[i2--];
            }
        }

        while(i1 >= 0){
            nums1[last--] = nums1[i1--];
        }

        while(i2 >= 0){
            nums1[last--] = nums2[i2--];
        }

    }
}