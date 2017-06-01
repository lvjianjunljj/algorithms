package graph.archive.linkList_fail;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Traversal_test {
	public Vertex dfs[];
	public Vertex bfs[];

	/* 深度优先遍历 */
	public void dfs(Graph graph) {
		int num = graph.ver_List.length;
		dfs = new Vertex[num];
		Stack<Vertex> dfs_stack = new Stack<Vertex>();
		dfs_stack.push(graph.ver_List[0]);
		graph.ver_List[0].isVisited = true;// 第一个节点访问
		int index = 0;
		dfs[0] = graph.ver_List[0];
		while (!dfs_stack.isEmpty()) {// 栈非空则持续遍历
			Vertex v = getAdjVertex(dfs_stack.peek());
			if (v == null) {
				dfs_stack.pop();
			} else {
				dfs[++index] = v;
				v.isVisited = true;
				dfs_stack.push(v);
			}

		}
	}

	/* 广度优先遍历 */
	public void bfs(Graph graph) {
		int num = graph.ver_List.length;
		bfs = new Vertex[num];
		ArrayDeque<Vertex> queue = new ArrayDeque<Vertex>();
		bfs[0] = graph.ver_List[0];
		queue.add(graph.ver_List[0]);
		graph.ver_List[0].isVisited = true;
		Vertex vv;
		int index = 0;
		while (!queue.isEmpty()) {
			Vertex v = queue.remove();
			while ((vv = getAdjVertex(v)) != null) {
				queue.add(vv);
				bfs[++index] = vv;
				vv.isVisited = true;
			}

		}
	}

	public static Vertex getAdjVertex(Vertex v) {
		ArrayList<Vertex> alv = v.getAdj();
		if (alv != null) {
			for (int k = 0; k < alv.size(); k++) {
				if (alv.get(k).isVisited == false) {
					alv.get(k);
					return alv.get(k);
				}
			}
		}
		return null;

	}

	public static void main(String[] args) {
//		最好熟练使用System.in操作
		System.out.println("Input the number of vertex:");
		Scanner scan = new Scanner(System.in);
		int node_num = scan.nextInt();
		System.out.println("Is this directed graph?");
		boolean flag = scan.nextBoolean();

		Graph graph = new Graph(node_num, flag);
		/* 构建图的节点 */
		for (int k = 0; k < node_num; k++) {
			graph.ver_List[k] = new Vertex(k);
		}

		/* 构建图的边 */
		System.out.println("Input the each node of each edge:-1 to exit");
		int i = 0, j = 0;
		while ((i = scan.nextInt()) != -1) {
			j = scan.nextInt();
			graph.addEdge(i, j);
		}

		Traversal_test dt = new Traversal_test();
		
		
		/* 深度优先遍历 */
		dt.dfs(graph);
		if (dt.dfs.length < graph.ver_List.length) {
			System.out.println("The graph is not a connected path!");
		} else {
			System.out.println("The depth-first traversal of this graph is:");
			for (int k = 0; k < dt.dfs.length; k++) {
//				System.out.println(dt.dfs[k].toString());
			}
		}

		/* 广度优先遍历 */
		/* 重新构图 */
		/* 将节点重置为未访问 */
		for (int k = 0; k < node_num; k++) {
			graph.ver_List[k].isVisited = false;

		}
		dt.bfs(graph);
		if (dt.bfs.length < graph.ver_List.length) {
			System.out.println("The graph is not a connected path!");
		} else {
			System.out.println("The breadth-first traversal of this graph is:");
			for (int k = 0; k < dt.bfs.length; k++) {
//				System.out.println(dt.bfs[k].toString());
			}
		}
	}

}