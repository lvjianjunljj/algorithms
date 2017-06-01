package part04;

import java.util.ArrayList;

import javax.swing.text.html.FormSubmitEvent.MethodType;

public class _Homework4_2_2_Strassen {
	public static void main(String[] args) {
		float[][] a = {{1,1,1,1},{2,3,4,5},{6,7,8,9},{1,1,1,1}};
		float[][] b = {{1,1,1,1},{2,3,4,5},{6,7,8,9},{1,1,1,1}};
	}
	
	protected static float[][] strassen(float[][] a,float[][] b){
		int n = a.length;
		if(n >1){
			strassen(a,b);
		}else {
			
		}
		return a;
	}
}
