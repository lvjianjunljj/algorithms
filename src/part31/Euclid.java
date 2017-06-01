package part31;

public class Euclid {
	public static void main(String[] args) {
		double a = 12;
		double b = 123;
		double c = euclid(a, b);
		System.out.println(a+"和"+b+"的最大公约数是："+c);
	}
	
	//求两个数a和b的最大公约数d
	protected static double euclid(double a,double b){
		if(b==0){
			return a;
		}
		return euclid(b, a%b);
	}
}
