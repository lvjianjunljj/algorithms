package part22.section4;

import graph.archive.linkList.Graph;
import graph.archive.linkList.Vertex;

import java.util.ArrayList;


public class TopologicalSort {
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
		myGraph.addEdge(1, 2);
		myGraph.addEdge(2, 3);
		myGraph.addEdge(3, 4);
		myGraph.addEdge(4, 5);
		myGraph.addEdge(5, 6);
		myGraph.addEdge(6, 7);
		myGraph.addEdge(7, 8);
		myGraph.addEdge(8, 9);
		myGraph.displayGraph();
		System.out.println("*************************************");
		// 书中对图进行拓扑排序已经封装在part22.archive.linkList
		myGraph.topologicalSort();
		for (Vertex u : myGraph.vertexList) {
			System.out.print(u.label + "\t");
		}
	}
}
