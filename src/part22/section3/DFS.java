package part22.section3;

import graph.archive.linkList.Graph;
import graph.archive.linkList.Vertex;

public class DFS {
	public static void main(String[] args) {
		// 构造有向图（作为输入）
		int nVerts = 10;
		int c = 'A' - 1;
		Vertex[] vertexs = new Vertex[nVerts];
		Graph myGraph = new Graph(nVerts, false);
		for (int i = 0; i < nVerts; i++) {
			c++;
			vertexs[i] = new Vertex((char) (c));
			myGraph.addVertex(vertexs[i]);
		}
		myGraph.addEdge(0, 1);
		myGraph.addEdge(2, 1);
		myGraph.addEdge(3, 2);
		myGraph.addEdge(3, 4);
		myGraph.addEdge(0, 3);
		myGraph.addEdge(0, 4);
		myGraph.addEdge(0, 5);
		myGraph.addEdge(0, 6);
		myGraph.addEdge(0, 7);
		myGraph.addEdge(0, 9);
		myGraph.displayGraph();
		System.out.println("*************************************");
		// 在part22.archive.linkList中根据算法导论上的思想自己封装的dfs方法
		myGraph.dfs();
	}
}
