package part25;

import graph.archive.matrix.City;
import graph.archive.matrix.Map;

public class FloydWarshall {
	public static void main(String[] args) {
		 Map M = new Map(5,true);
		    City a = new City("a");
		    City b = new City("b");
		    City c = new City("c");
		    City d = new City("d");
		    City e = new City("e");
		    M.createCity(a);
		    M.createCity(b);
		    M.createCity(c);
		    M.createCity(d);
		    M.createCity(e);
		    M.createEdge(a,b,3);
		    M.createEdge(a,c,8);
		    M.createEdge(a,e,-4);
		    M.createEdge(b,d,1);
		    M.createEdge(b,e,7);
		    M.createEdge(c,b,4);
		    M.createEdge(d,a,2);
		    M.createEdge(d,c,-5);
		    M.createEdge(e,d,6);
		    double[][] ss = M.floyd_warshall();
		    for (int i = 0; i < ss.length; i++) {
				for (int j = 0; j < ss[0].length; j++) {
					System.out.print(ss[i][j]+"\t");
				}
				System.out.println();
			}
	}
}
