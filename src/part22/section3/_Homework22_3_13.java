package part22.section3;

import graph.archive.linkList.Graph;
import graph.archive.linkList.Vertex;

public class _Homework22_3_13 {
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
		myGraph.addEdge(2, 1);
		myGraph.addEdge(3, 2);
		myGraph.addEdge(0, 4);
		myGraph.addEdge(0, 5);
		myGraph.addEdge(0, 6);
		myGraph.addEdge(0, 7);
		myGraph.addEdge(0, 9);
		myGraph.addEdge(1, 4);
		myGraph.addEdge(1, 5);
		myGraph.addEdge(1, 6);
		myGraph.addEdge(1, 7);
		myGraph.addEdge(1, 9);
		myGraph.displayGraph();
		System.out.println("*************************************");
		// 课后习题22.3-13中的判断是不是单连通图已经封装在part22.archive.linkList
		myGraph.isSingly();
		System.out.println("图myGraph是否是单连通图：" + myGraph.isSingly);
	}
}
