package part22.thinking_questions;

import graph.archive.linkList.Graph;
import graph.archive.linkList.Vertex;

import java.util.LinkedList;


public class _Homework_22_3 {
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
		myGraph.addEdge(1, 2);
		myGraph.addEdge(2, 0);
		myGraph.addEdge(2, 3);
		myGraph.addEdge(3, 4);
		myGraph.addEdge(4, 2);
		
		myGraph.displayGraph();
		System.out.println("*************************************");
		/**
		 * 为_Homework_22_3的欧拉回路问题封装的方法
		 * 前提是假设图G存在欧拉回路，即有向图任意点的出度和入度相同。从任意一个起始点v开始遍历，直到再次到达点v，即寻找一个环，这会保证一定可以到达点v，
		 * 因为遍历到任意一个点u，由于其出度和入度相同，故u一定存在一条出边，所以一定可以到达v。将此环定义为C，如果环C中存在某个点x，其有出边不在环中，
		 * 则继续以此点x开始遍历寻找环C’，将环C、C’连接起来也是一个大环，如此往复，直到图G中所有的边均已经添加到环中。
		 * 
		 * 数据结构如下 (1) 使用循环链表CList存储当前已经发现的环； (2) 使用一个链表L保存当前环中还有出边的点； (3) 使用邻接表存储图G
		 * 
		 * 使用如下的步骤可以确保算法的复杂度为O(E) (1) 将图G中所有点入L，取L的第一个结点
		 * (2)直接取其邻接表的第一条边，如此循环往复直到再次到达点v构成环C
		 * ，此过程中将L中无出边的点删除。环C与环CList合并，只要将CList中的点v使用环C代替即可。 (3)
		 * 如果链表L为空表示欧拉回路过程结束，否则取L的第一个结点，继续步骤(2)
		 */
		LinkedList<Vertex> a =myGraph.eulerLoop();
		for (Vertex u:a) {
			System.out.println(u.label);
		}
	}
}
