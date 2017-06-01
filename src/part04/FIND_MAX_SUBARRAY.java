package part04;

import java.util.ArrayList;

public class FIND_MAX_SUBARRAY {
	public static void main(String[] args) {
		float[] a = {1,2,3,-4,-3,-10,5,6,3};
		System.out.println(FIND_MAX_SUBARRAY(a, 1, 8).getLow());
		System.out.println(FIND_MAX_SUBARRAY(a, 1, 8).getHigh());
		System.out.println(FIND_MAX_SUBARRAY(a, 1, 8).getSum());
	}
	
	protected static FIND_MAX_SUBARRAY_RESULT FIND_MAX_SUBARRAY(float[] a,int low,int high){
		FIND_MAX_SUBARRAY_RESULT result = new FIND_MAX_SUBARRAY_RESULT();
		if(high == low){
			result.setLow(low);	
			result.setHigh(high);
			result.setSum(a[low-1]);
		}else{
			int mid = (low+high)/2;
			FIND_MAX_SUBARRAY_RESULT left = FIND_MAX_SUBARRAY(a,low,mid);
			FIND_MAX_SUBARRAY_RESULT right = FIND_MAX_SUBARRAY(a,mid+1,high);
			FIND_MAX_SUBARRAY_RESULT cross = FIND_MAX_CROSSING_SUBARRAY(a,low,mid,high);
			if(left.getSum()>=right.getSum() && left.getSum()>=cross.getSum()){
				result = left;
			}
			if(right.getSum()>=left.getSum() && right.getSum()>=cross.getSum()){
				result = right;
			}
			if(cross.getSum()>=left.getSum() && cross.getSum()>=right.getSum()){
				result = cross;
			}
			
		}
		return result;
	}
	
	protected static FIND_MAX_SUBARRAY_RESULT FIND_MAX_CROSSING_SUBARRAY(float[] a,int low,int mid,int high){
		float left_sum = Integer.MIN_VALUE;
		float sum = 0;
		int  max_left = 0;
		for (int i = mid-1; i > low-2 ; i--) {
			sum = sum + a[i];
			if(sum > left_sum){
				left_sum = sum;
				max_left = i+1;
			}
		}
		
		float right_sum = Integer.MIN_VALUE;
		int  max_right = 0;
		sum = 0;
		for (int i = mid; i < high; i++) {
			sum = sum + a[i];
			if(sum > right_sum){
				right_sum = sum;
				max_right = i+1;
			}
		}
		FIND_MAX_SUBARRAY_RESULT result = new FIND_MAX_SUBARRAY_RESULT();
		result.setLow(max_left);
		result.setHigh(max_right);
		result.setSum(left_sum + right_sum);
		return result;
	}
}
