package part22.section2;

import graph.archive.linkList.Graph;
import graph.archive.linkList.Vertex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class _Homework22_2_7 {

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
		printDivide(myGraph);
	}

	/**
	 * 没这么简单，不能直接调用封装的bfs方法，因为bfs只是找到对应点与源点的最短路径 应该是类比bfs对方法进行重写
	 * 其实没有这么麻烦，把图变为无向图就行了（但是bfs方法有初始化过程，多次循环会把之前的d属性置为Integer.MAX_VALUE）
	 * 最后的方法是不调用bfs而是对bfs进行修改直接放到方法中
	 */
	protected static void divide(Graph g) {
		ArrayList<Vertex> vertexs = new ArrayList<Vertex>();
		for (Vertex v : g.getVertexList()) {
			vertexs.add(v);
		}
		for (Vertex v : vertexs) {
			v.d = Integer.MAX_VALUE;
		}
		while (vertexs.size() != 0) {
			Vertex s = vertexs.get(0);
			ArrayList<Vertex> adjs = s.getAdj();
			s.d = 0;
			Queue Q = new LinkedList<Vertex>();
			Q.add(s);
			while (!Q.isEmpty()) {
				Vertex u = (Vertex) Q.poll();
				if (u.isVisted == false) {
					if (u.getAdj() != null) {
						for (Vertex v : u.getAdj()) {
							if (v.isVisted == false) {
								v.isVisted = true;
								v.d = u.d + 1;
								Q.add(v);
							}
						}
					}
				}
			}
			s.isVisted = true;
			for (int i = 0; i < vertexs.size(); i++) {
				if (vertexs.get(i).isVisted == true) {
					if (vertexs.get(i).d % 2 == 0) {
						vertexs.get(i).good = true;
					} else {
						vertexs.get(i).good = false;
					}
					vertexs.remove(i);
					i--;
				}
			}
		}
	}
	//最后的判断是否可以划分用到了3冲循环，暂时个人还没有找到可以降低时间复杂度的想法
	protected static void printDivide(Graph g) {
		divide(g);
		ArrayList<Vertex> good_person = new ArrayList<Vertex>();
		ArrayList<Vertex> bad_person = new ArrayList<Vertex>();
		for (Vertex v : g.getVertexList()) {
			if (v.good) {
				good_person.add(v);
			} else {
				bad_person.add(v);
			}
		}
		for (int i = 0; i < good_person.size(); i++) {
			ArrayList<Vertex> adj = good_person.get(i).getAdj();
			if (adj != null) {
				for (int j = 0; j < adj.size(); j++) {
					for (int k = 0; k < good_person.size(); k++) {
						if (adj.get(j) == good_person.get(k)) {
							System.out.println("无法划分。。。");
							return;
						}
					}
				}
			}
		}

		for (int i = 0; i < bad_person.size(); i++) {
			ArrayList<Vertex> adj = bad_person.get(i).getAdj();
			if (adj != null) {
				for (int j = 0; j < adj.size(); j++) {
					for (int k = 0; k < bad_person.size(); k++) {
						if (adj.get(j) == bad_person.get(k)) {
							System.out.println("无法划分。。。");
							return;
						}
					}
				}
			}
		}
		System.out.println("“娃娃脸”有：");
		for (int i = 0; i < good_person.size(); i++) {
			System.out.print(good_person.get(i).label + "\t");
		}
		System.out.println();
		System.out.println("“高跟鞋”有：");
		for (int i = 0; i < bad_person.size(); i++) {
			System.out.print(bad_person.get(i).label + "\t");
		}
	}
}
