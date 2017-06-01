package part22.section5;

import graph.archive.linkList.Graph;
import graph.archive.linkList.Vertex;

import java.util.ArrayList;


public class _Homework22_5_6 {
	public static void main(String[] args) {
		// 构造有向图（作为输入）
		int nVerts = 5;
		int c = 'A' - 1;
		Vertex[] vertexs = new Vertex[nVerts];
		Graph myGraph = new Graph(nVerts, true);
		for (int i = 0; i < nVerts; i++) {
			c++;
			vertexs[i] = new Vertex((char) (c));
			myGraph.addVertex(vertexs[i]);
		}
		myGraph.addEdge(0, 1);
		myGraph.addEdge(0, 2);
		myGraph.addEdge(1, 0);
		myGraph.addEdge(1, 2);
		myGraph.addEdge(2, 1);
		myGraph.addEdge(2, 0);
		myGraph.addEdge(3, 4);
		myGraph.addEdge(4, 3);
		myGraph.addEdge(4, 1);
		
		myGraph.displayGraph();
		System.out.println("*************************************");
		ArrayList<ArrayList<Vertex>> r=myGraph.stronglyConnectedComponents();
		for (int i = 0; i < r.size(); i++) {
			for (int j = 0; j < r.get(i).size(); j++) {
				System.out.print(r.get(i).get(j).label+"\t");
			}
			System.out.println();
		}
		// 书中对_Homework22_5_6的求解已经封装在part22.archive.linkList
		Graph simle = myGraph.componentFigSimple();
		simle.displayGraph();
		
	}
}
