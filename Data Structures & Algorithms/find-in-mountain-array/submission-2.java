/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        

        int peakIdx = findPeak(mountainArr);

        int leftFound = searchLeft(0, peakIdx, target, mountainArr);
        int rightFound = searchRight(peakIdx, mountainArr.length()-1, target, mountainArr);

        if(leftFound == -1 && rightFound == -1){
            return -1;
        }else if(leftFound != -1){
            return leftFound;
        }else {
            return rightFound;
        }


    }

    int searchLeft(int left, int right, int target, MountainArray arr){

        int l = left, r = right;
        while(l <= r){
            int mid = l + (r - l) / 2;
            int midVal = arr.get(mid);
            if(midVal == target){
                return mid;
            }else if(midVal < target){
                l = mid + 1;
            }else if(midVal > target){
                r = mid - 1;
            }
        }

        return -1;
    }

    int searchRight(int left, int right, int target, MountainArray arr){

        int l = left, r = right;
        while(l <= r){
            int mid = l + (r - l) / 2;
            int midVal = arr.get(mid);
            if(midVal == target){
                return mid;
            }else if(midVal < target){
                r = mid - 1;
            }else if(midVal > target){
                l = mid + 1;
            }
        }

        return -1;
    }


    int findPeak(MountainArray arr){
        int left = 0, right = arr.length()-1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            int l = arr.get(mid-1);
            int m = arr.get(mid);
            int r = arr.get(mid+1);
            if(l > m && m > r){
                right = mid - 1;
            }else if(l < m && m < r){
                left = mid + 1;
            }else{
                return mid;
            }
        }

        return 0;
    }
}