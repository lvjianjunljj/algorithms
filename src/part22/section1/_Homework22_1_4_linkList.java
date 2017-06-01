package part22.section1;

import graph.archive.linkList.Graph;
import graph.archive.linkList.Vertex;

import java.util.ArrayList;


public class _Homework22_1_4_linkList {
	public static void main(String[] args) {
		// 构造有向图（作为输入）
		int nVerts = 10;
		int c = 'A' - 1;
		Vertex[] vertexs = new Vertex[nVerts];
		Graph myGraph = new Graph(nVerts, true);
		for (int i = 0; i < nVerts; i++) {
			c++;
			vertexs[i] = new Vertex((char) (c));
			myGraph.addVertex(vertexs[i]);
		}
		myGraph.addEdge(0, 1);
		myGraph.addEdge(0, 0);
		myGraph.addEdge(0, 0);
		myGraph.addEdge(0, 0);
		myGraph.addEdge(0, 1);
		myGraph.addEdge(0, 4);
		myGraph.addEdge(1, 2);
		myGraph.addEdge(2, 3);
		myGraph.addEdge(4, 5);
		myGraph.addEdge(4, 6);
		myGraph.addEdge(5, 8);
		myGraph.addEdge(6, 7);
		myGraph.addEdge(7, 8);
		myGraph.displayGraph();
		System.out.println("***********************");
		
		//剔除重复边和环的方法已经封装在Graph类中了
		myGraph.removeRepeat(vertexs[0]);
		myGraph.displayGraph();
		System.out.println("***********************");
		myGraph.removeRing(vertexs[0]);
		myGraph.displayGraph();
		
	}
}
