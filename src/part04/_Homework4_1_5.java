package part04;

import java.util.ArrayList;

import javax.swing.text.html.FormSubmitEvent.MethodType;

public class _Homework4_1_5 {
	public static void main(String[] args) {
		float[] a = {1,2,-3,-4,-3,-10,-5,-6,4};
		System.out.println(method(a, 1, 9).getLow());
		System.out.println(method(a, 1, 9).getHigh());
		System.out.println(method(a, 1, 9).getSum());
	}
	
	protected static FIND_MAX_SUBARRAY_RESULT method(float[] a,int low,int high){
		FIND_MAX_SUBARRAY_RESULT result = new FIND_MAX_SUBARRAY_RESULT();
		int left=0,right=0;
		float sum = 0;
		float sum_right = 0;
		if(low == high){
			left = right = low;
			sum = a[low-1];
		}
		for (int j = low; j < high; j++) {
			sum = method(a,low,j).getSum();
			sum_right = 0;
			for (int i = j+1; i > low-1; i--) {
				sum_right += a[i-1];
				if(sum < sum_right){
					sum = sum_right;
					left = i;
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
