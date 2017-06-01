package part24;

import graph.archive.matrix.City;
import graph.archive.matrix.Map;


public class Dijkstra {
	public static void main(String[] args) {
		 Map M = new Map(12,true);
		    City a = new City("a");
		    City b = new City("b");
		    City c = new City("c");
		    City d = new City("d");
		    City e = new City("e");
		    City f = new City("f");
		    City g = new City("g");
		    City h = new City("h");
		    City i = new City("i");
		    City j = new City("j");
		    City k = new City("k");
		    City l = new City("l");
		    M.createCity(a);
		    M.createCity(b);
		    M.createCity(c);
		    M.createCity(d);
		    M.createCity(e);
		    M.createCity(f);
		    M.createCity(g);
		    M.createCity(h);
		    M.createCity(i);
		    M.createCity(j);
		    M.createCity(k);
		    M.createCity(l);
		    M.createEdge(a,b,3);
		    M.createEdge(a,c,5);
		    M.createEdge(a,d,4);
		    
		    M.createEdge(b,f,6);
		    
		    M.createEdge(c,d,2);
		    M.createEdge(c,g,4);
		    
		    M.createEdge(d,e,1);
		    M.createEdge(d,h,5);
		    
		    M.createEdge(e,f,2);
		    M.createEdge(e,i,4);
		    
		    M.createEdge(f,j,5);
		    
		    M.createEdge(g,h,3);
		    M.createEdge(g,k,6);
		    
		    M.createEdge(h,i,6);
		    M.createEdge(h,k,7);
		    
		    M.createEdge(i,j,3);
		    M.createEdge(i,l,5);
		    
		    
		    M.createEdge(b,k,8);
		    System.out.println(M);
		    //网上给的Dijkstra算法
		    M.dijkstra(a);
		    //自己写的Dijkstra算法
		    M.myDijkstra(a);
		    
	}
	
}
