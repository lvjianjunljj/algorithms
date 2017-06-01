package part22.section4;

import graph.archive.linkList.Graph;
import graph.archive.linkList.Vertex;

public class _Homework22_4_1 {
	public static void main(String[] args) {
		// 构造有向图（作为输入）
		int nVerts = 14;
		int c = 'm' - 1;
		Vertex[] vertexs = new Vertex[nVerts];
		Graph myGraph = new Graph(nVerts, true);
		for (int i = 0; i < nVerts; i++) {
			c++;
			vertexs[i] = new Vertex((char) (c));
			myGraph.addVertex(vertexs[i]);
		}
		myGraph.addEdge(0, 4);
		myGraph.addEdge(0, 5);
		myGraph.addEdge(0, 11);
		myGraph.addEdge(1, 2);
		myGraph.addEdge(1, 4);
		myGraph.addEdge(1, 8);
		myGraph.addEdge(2, 5);
		myGraph.addEdge(2, 6);
		myGraph.addEdge(2, 9);
		myGraph.addEdge(3, 2);
		myGraph.addEdge(3, 6);
		myGraph.addEdge(3, 13);
		myGraph.addEdge(4, 7);
		myGraph.addEdge(5, 8);
		myGraph.addEdge(5, 12);
		myGraph.addEdge(6, 5);
		myGraph.addEdge(8, 7);
		myGraph.addEdge(9, 10);
		myGraph.addEdge(9, 11);
		myGraph.addEdge(10, 13);
		myGraph.addEdge(12, 9);
		myGraph.displayGraph();
		System.out.println("*************************************");
		myGraph.topologicalSort();
		for (Vertex u : myGraph.vertexList) {
			System.out.print(u.label + "\t");
		}
	}
}
