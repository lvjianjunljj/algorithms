package part22.section1;

import graph.archive.linkList.Graph;
import graph.archive.linkList.Vertex;

import java.util.ArrayList;


public class _Homework22_1_5_linkList {
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

		/**
		 * 答案给的思路是遍历每一条边，然后将其起点和终点对调 我的思路是遍历每一个点的邻接点然后对调保存在新的图中
		 */
		// 构造新的图
		Vertex[] vertexs_out = new Vertex[nVerts];
		Graph myGraph_out = new Graph(nVerts, true);
		for (int i = 0; i < nVerts; i++) {
			vertexs_out[i] = new Vertex(vertexs[i].label);
			myGraph_out.addVertex(vertexs_out[i]);
		}

		//个人只能用三层遍历来做了
		//先遍历一遍所有的点，再遍历与其相连的点集组成next，再遍历与其相连的点相连的点集组成next_next
		for (int i = 0; i < vertexs_out.length; i++) {
			ArrayList<Vertex> next = vertexs[i].getAdj();
			if (next != null) {
				for (int j = 0; j < next.size(); j++) {
					myGraph_out.addEdge(i, next.get(j).index);
					ArrayList<Vertex> next_next = next.get(j).getAdj();
					if (next_next != null) {
						for (int k = 0; k < next_next.size(); k++) {
							myGraph_out.addEdge(i, next_next.get(k).index);
						}
					}
				}
			}
		}
		myGraph_out.displayGraph();
	}
}
