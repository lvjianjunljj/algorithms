package part22.section2;

import graph.archive.linkList.Graph;
import graph.archive.linkList.Vertex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class _Homework22_2_8 {

	public static void main(String[] args) {
		// 构造有向图（作为输入）
		int nVerts = 3;
		int c = 'A' - 1;
		Vertex[] vertexs = new Vertex[nVerts];
		Graph myGraph = new Graph(nVerts, true);
		for (int i = 0; i < nVerts; i++) {
			c++;
			vertexs[i] = new Vertex((char) (c));
			myGraph.addVertex(vertexs[i]);
		}
		myGraph.addEdge(0, 1);
		myGraph.addEdge(1, 0);
		myGraph.addEdge(0, 2);
		myGraph.addEdge(2, 0);
		myGraph.displayGraph();
		System.out.println("*************************************");
		System.out.println("该图的直径为：" + diameter(myGraph));
		myGraph.printBFS(vertexs[0]);
	}

	protected static int diameter(Graph g) {
		int diameter_result = Integer.MIN_VALUE;
		Vertex[] vertexList = g.getVertexList();
		for (Vertex s : g.getVertexList()) {
			g.bfs(s);
			for (Vertex v : vertexList) {
				if (v.d > diameter_result) {
					diameter_result = v.d;
				}
			}
		}
		return diameter_result;
	}

}
