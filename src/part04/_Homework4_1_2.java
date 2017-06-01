package part04;

import java.util.ArrayList;

import javax.swing.text.html.FormSubmitEvent.MethodType;

public class _Homework4_1_2 {
	public static void main(String[] args) {
		float[] a = {-1,-2,-3,-4,-3,-10,-5,6,3};
		System.out.println(FIND_MAX_SUBARRAY(a, 1, 9).getLow());
		System.out.println(FIND_MAX_SUBARRAY(a, 1, 9).getHigh());
		System.out.println(FIND_MAX_SUBARRAY(a, 1, 9).getSum());
	}
	
	protected static FIND_MAX_SUBARRAY_RESULT FIND_MAX_SUBARRAY(float[] a,int low,int high){
		FIND_MAX_SUBARRAY_RESULT result = new FIND_MAX_SUBARRAY_RESULT();
		int left=0,right=0;
		float sum = Long.MIN_VALUE;
		float sum_value;
		for (int i = low-1; i < high; i++) {
			sum_value=0;
			for (int j = i; j < high; j++) {
				sum_value += a[j];
				if(sum < sum_value){
					sum = sum_value;
					left = i+1;
					right = j+1;
				}
			}
		}
		result.setLow(left);
		result.setHigh(right);
		result.setSum(sum);
		return result;
	}
}
