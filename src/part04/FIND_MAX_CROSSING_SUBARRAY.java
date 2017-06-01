package part04;

import java.util.ArrayList;

public class FIND_MAX_CROSSING_SUBARRAY {
	public static void main(String[] args) {
		float[] a = {7,-5,1,9,7,-3,-5,9};
		ArrayList b = FIND_MAX_CROSSING_SUBARRAY(a, 1, 4, 8);
		for(Object value : b){
			System.out.println(value);
		}
	}
	protected static ArrayList FIND_MAX_CROSSING_SUBARRAY(float[] a,int low,int mid,int high){
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
		ArrayList result = new ArrayList();
		result.add(max_left);
		result.add(max_right);
		result.add(left_sum + right_sum);
		return result;
	}
}
