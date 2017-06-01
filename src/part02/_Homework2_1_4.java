package part02;

import java.util.ArrayList;

import javax.swing.text.html.FormSubmitEvent.MethodType;

public class _Homework2_1_4 {
	public static void main(String[] args) {
		String number1 = "11111";
		String number2 = "10000";
		System.out.println(method(number1, number2));
	}
	
	private static String method(String number1 ,String number2){
		int n = number1.length();
		int[] array1 = new int[n];
		int[] array2 = new int[n];
		int[] array3 = new int[n];
		int[] array4 = new int[n+1];
		array3[n-1] = 0;
		for (int i = 0; i < n; i++) {
			array1[i] = Integer.parseInt(number1.substring(i, i+1));
		}
		for (int i = 0; i < n; i++) {
			array2[i] = Integer.parseInt(number2.substring(i, i+1));
		}
		for (int i = n-1; i > 0; i--) {
			if((array1[i] + array2[i] + array3[i]) > 1 ){
				array3[i-1] = 1;
			}else {
				array3[i-1] = 0;
			}
		}
		for (int i = n; i > 0; i--) {
				array4[i] = (array1[i-1] + array2[i-1] + array3[i-1])%2;
		}
		if((array1[0] + array2[0] + array3[0]) > 1){
			array4[0] = 1;
		}
		
		String number3  = "";
		for (int i = 0; i < n+1; i++) {
			number3 += array4[i];
		}
		return number3;
		
	}
}
