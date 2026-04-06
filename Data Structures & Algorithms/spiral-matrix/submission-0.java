class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int top = 0, bot = matrix.length-1;
        int left = 0, right = matrix[0].length-1;

        List<Integer> list = new ArrayList<>();

        while(top <= bot && left <= right){
            
            for(int i = left; i <= right; i++){
                list.add(matrix[top][i]);
            }
            top++;

            for(int i = top; i <= bot; i++){
                list.add(matrix[i][right]);
            }
            right--;

            if(top <= bot && left <= right){
                for(int i = right; i >= left; i--){
                    list.add(matrix[bot][i]);
                }
                bot--;

                for(int i = bot; i >= top; i--){
                    list.add(matrix[i][left]);
                }
                left++;
            }
            
        }

        return list;
    }
}
