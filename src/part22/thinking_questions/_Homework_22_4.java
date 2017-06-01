package part22.thinking_questions;

import graph.archive.linkList.Graph;
import graph.archive.linkList.Vertex;

import java.util.LinkedList;


public class _Homework_22_4 {
	public static void main(String[] args) {
		// 构造有向图（作为输入）
		int nVerts = 6;
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
		myGraph.addEdge(2, 0);
		myGraph.addEdge(0, 3);
		myGraph.addEdge(3, 4);
		myGraph.addEdge(4, 3);

		myGraph.displayGraph();
		System.out.println("*************************************");
		// 书中对_Homework22_4可到达性问题的求解已经封装在part22.archive.linkList
		myGraph.reachability();
		for (Vertex u : myGraph.vertexList) {
			System.out.println(u.min);
		}

	}
}
