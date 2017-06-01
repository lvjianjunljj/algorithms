package part22.section2;

import graph.archive.linkList.Graph;
import graph.archive.linkList.Vertex;

public class PRINT_PATH {
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
		myGraph.addEdge(0, 8);
		myGraph.addEdge(0, 9);
		myGraph.displayGraph();
		System.out.println("*************************************");
		System.out.println("从节点 "+vertexs[0].label+"到节点"+vertexs[2].label+"的最短路径的结果是：");
		print_path(myGraph, vertexs[0], vertexs[2]);
	}

	protected static void print_path(Graph g, Vertex s, Vertex v) {
		g.bfs(s);
		if (v==s) {
			System.out.print(s.label);
		}
		else if (v.p == null) {
			System.out.println("no path from "+s.label+" to "+v.label);
		}
		else{
			print_path(g, s, v.p);
			System.out.print("-->"+v.label);
		}
	}
}
