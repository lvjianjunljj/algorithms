package graph.archive.matrix;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

//图算法的邻接矩阵表示
public class Map {
	public double[][] A;
	public boolean direct;

	public Map(int n, boolean direct) {
		City.idCounter = 0;
		this.direct = direct;
		A = new double[n][n];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				if (i == j)
					A[i][j] = 0;
				else
					A[i][j] = -1;
			}
		}

	}

	public ArrayList<City> cities = new ArrayList<City>();

	private double[] D;

	private void relax(int u, int v) {
		if (D[v] > D[u] + A[u][v])
			D[v] = D[u] + A[u][v];
	}

	private double[][] DD = null;

	public void floydWarshall() {
		DD = new double[A.length][A.length];
		int i, j, k;
		for (i = 0; i < A.length; i++) {
			for (j = 0; j < A.length; j++) {
				if (A[i][j] > 0)
					DD[i][j] = A[i][j];
				else if (i == j)
					DD[i][j] = 0;
				else
					DD[i][j] = Integer.MAX_VALUE;

			}
		}
		for (k = 0; k < A.length; k++)
			for (i = 0; i < A.length; i++)
				for (j = 0; j < A.length; j++) {
					if (DD[i][j] > DD[i][k] + DD[k][j]) {
						DD[i][j] = DD[i][k] + DD[k][j];
					}
				}
	}

	// 输出某点到其他点的最短路径的值
	public void printFloydWarshallForOneCity(City city) {
		System.out.println("floydWarshall:");
		if (DD == null) {
			floydWarshall();
		}
		for (int i = 0; i < A.length; i++) {
			System.out.printf("from %s to %s shortest path is:%f\n", city.name,
					cities.get(i).name, DD[city.id][i]);
		}

	}

	public void dijkstra(City city) {
		dijkstra(city.id);
		System.out.println("dijkstra:");
		for (int i = 0; i < A.length; i++) {
			System.out.printf("from %s to %s shortest path is:%f\n", city.name,
					cities.get(i).name, D[i]);
		}
	}

	public void dijkstra(int srcId) {
		D = new double[A.length];
		for (int i = 0; i < A.length; i++) {
			D[i] = 999999999;
		}
		D[srcId] = 0;
		int[] q = new int[A.length];
		int ql = 0, qf = 0; // 队列

		for (int i = 0; i < A.length; i++)
			q[ql++] = i;
		while (qf != ql) {
			int min = qf;
			for (int i = qf; i < ql; i++) {
				if (D[q[i]] < D[q[min]]) {
					min = i;
				}
			}
			int id = q[qf];
			q[qf] = q[min];
			q[min] = id; // q[qf] is the min
			int u = q[qf++];
			for (int i = 0; i < A.length; i++) {
				if (A[u][i] > 0) {
					relax(u, i);
				}
			}
		}
	}

	public void bellmanFord(City city) {
		bellmanFord(city.id);
		System.out.println("bellmanFord:");
		for (int i = 0; i < A.length; i++) {
			System.out.printf("from %s to %s shortest path is:%f\n", city.name,
					cities.get(i).name, D[i]);
		}
	}

	public void bellmanFord(int srcId) {
		D = new double[A.length];
		for (int i = 0; i < A.length; i++) {
			D[i] = 99999999;// 无穷大
		}
		D[srcId] = 0;
		for (int i = 0; i < A.length; i++)// 外层循环次数
		{
			for (int j = 0; j < A.length; j++) {
				for (int k = 0; k < A.length; k++) {
					if (A[j][k] > 0) {
						relax(j, k);
					}
				}
			}

		}
	}

	Queue<Integer> bfsQueue = new LinkedList<Integer>();
	boolean[] bfsFlag;
	int[] bsfPre;

	public void findPathByBFS(City src, City dst) {
		System.out.printf("bfs find path between '%s' and '%s'!\n", src.name,
				dst.name);
		findPathByBFS(src.id, dst.id);
		printBFS(dst.id);

	}

	public void findPathByBFS(int srcId, int dstId) {
		bsfPre = new int[A.length];
		bfsQueue.clear();
		bfsFlag = new boolean[A.length];
		for (int i = 0; i < A.length; i++) {
			bfsFlag[i] = false;
			bsfPre[i] = -1;
		}

		bfsQueue.offer(srcId);
		bfsFlag[srcId] = true;

		while (!bfsQueue.isEmpty()) {
			int current = bfsQueue.poll();
			for (int index = 0; index < A.length; index++) {
				if (current == index)
					continue;
				if (A[current][index] > 0) // 两者相连
				{
					if (index == dstId)// 找到目标了
					{
						bfsFlag[index] = true;
						bsfPre[index] = current;
						return;// 直接返回
					}
					if (bfsFlag[index] == false)// 如果未访问过
					{
						bfsFlag[index] = true;
						bsfPre[index] = current;
						bfsQueue.offer(index);
					}
				}

			}
		}

	}

	public void printBFS(int dstId) {
		int index = dstId;
		do {
			System.out.printf("<-%s", cities.get(index).name);
			index = bsfPre[index];
		} while (index != -1);
		System.out.println();
	}

	ArrayList<Integer> dfsPath = new ArrayList<Integer>();
	boolean[] dfsFlag;

	private void printDFS() {
		for (Integer node : dfsPath) {
			System.out.printf("->%s", cities.get(node).name);
		}
		System.out.println();
	}

	public void findPathByDFS(City src, City dst) {
		System.out.printf("dfs find path between '%s' and '%s'!\n", src.name,
				dst.name);
		findPathByDFS(src.id, dst.id);
	}

	public void findPathByDFS(int srcId, int dstId) {
		dfsPath.clear();
		dfsFlag = new boolean[A.length];
		for (int i = 0; i < A.length; i++) {
			dfsFlag[i] = false;
		}
		dfsPath.add(srcId);
		dfsFlag[srcId] = true;
		dfs(srcId, dstId);
		printDFS();
	}

	private void dfs(int srcId, int dstId) {
		for (int index = 0; index < A[srcId].length; index++) {
			if (srcId == index)
				continue;
			if (A[srcId][index] > 0)// 两者连接
			{
				if (index == dstId)// 找到目标了
				{
					dfsFlag[index] = true;
					dfsPath.add(index);
					return;
				}
				if (dfsFlag[index] == false)// 如果该节点未访问过
				{
					dfsFlag[index] = true;
					dfsPath.add(index);
					dfs(index, dstId);
					if (dfsFlag[dstId] == false)// 目标没找到
						dfsPath.remove(index);
					else
						return;
				}

			}
		}
	}

	public void createEdge(City a, City b, double w) {
		if (direct) {
			A[a.id][b.id] = w;
		} else {
			A[a.id][b.id] = w;
			A[b.id][a.id] = w;// added by me!
		}
		// 先把这两句注释一下，我想要的暂时不需要这两句
		// cities.add(a.id, a);
		// cities.add(b.id, b);
	}

	public void createEdge(int i, int j, double w) {
		if (direct) {
			A[i][j] = w;
		} else {
			A[i][j] = w;
			A[j][i] = w;// added by me!
		}
	}

	public void createCity(City a) {
		cities.add(a);
	}

	public String toString() {
		String r = "I am a map of " + A.length + " cities.";
		r += " My connections are:\n";
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++)
				r += A[i][j] + "\t";
			r += "\n";
		}
		return r;
	}

	public boolean hasLink(City c) {
		for (int i = 0; i < A[0].length; i++) {
			if (A[c.id][i] > 0) {// 这里的判断还是写大于0而不是大于-1，因为矩阵中A[i][i]的值为0
				return true;
			}
		}
		return false;
	}

	/**
	 * 以下全是自己封装的一些方法
	 */

	/**
	 * 这两个方法是仿照part22.archive.linkList中的输出写的
	 * 这之后的方法都是我根据算法导论中的要求自己封装的，不是特别简炼，凑合看吧，之前的像bfs和dfs他封装的我看不懂了
	 */
	public void displayMap() {
		for (int i = 0; i < cities.size(); i++) {
			printCity(cities.get(i));
		}
	}

	public void printCity(City c) {
		if (hasLink(c)) {
			System.out.print(c.toString() + "有邻接点:");
			for (int i = 0; i < A[0].length; i++) {
				if (A[c.id][i] > 0) {
					System.out.print("顶点" + cities.get(i).name + ", ");
				}
			}
			System.out.println();
		} else {
			System.out.println(c.toString() + " 无连接点");
		}
	}

	// 根据算法导论上的思想自己封装的bfs方法
	public void bfs(City s) {
		for (City c : cities) {
			c.d = Integer.MAX_VALUE;
		}
		s.isVisted = true;
		s.p = null;
		s.d = 0;
		Queue<City> Q = new LinkedList<City>();
		Q.add(s);
		while (!Q.isEmpty()) {
			City u = (City) Q.poll();
			if (getAdj(u) != null) {
				for (City v : getAdj(u)) {
					if (v.isVisted == false) {
						v.isVisted = true;
						v.d = u.d + 1;
						v.p = u;
						Q.add(v);
					}
				}
			}
		}
		System.out.println("顶点" + s.name + "的bfs：");
		for (City v : cities) {
			System.out.println("顶点" + v.name + ", " + "距离为：" + v.d);
		}
	}

	public ArrayList<City> getAdj(City s) {
		ArrayList<City> adjs = new ArrayList<City>();
		for (int i = 0; i < A[s.id].length; i++) {
			if (A[s.id][i] > 0) {
				adjs.add(cities.get(i));
			}
		}
		return adjs;
	}

	// 自己封装的用java封装好的优先队列PriorityQueue来实现Dijkstra算法

	public void myDijkstra(City city) {
		myDijkstra(city.id);
		System.out.println("myDijkstra:");
		for (int i = 0; i < A.length; i++) {
			System.out.printf("from %s to %s shortest path is:%f\n", city.name,
					cities.get(i).name, cities.get(i).d);
		}
		for (int i = 0; i < A.length; i++) {
			cities.get(i).d = 0;
		}
	}

	public void myDijkstra(int srcId) {
		for (int i = 0; i < A.length; i++) {
			cities.get(i).d = 999999999;
		}
		cities.get(srcId).d = 0;
		// 定义Comparator类的时候，最好所有的返回情况都写一下（这里主要注意0的返回，即相等时返回0最好写一下，不要只写1和-1的返回）
		Comparator c = new Comparator() {
			@Override
			public int compare(Object v1, Object v2) {
				if (((City) v1).d > ((City) v2).d) {
					return 1;
				} else if (((City) v1).d < ((City) v2).d) {
					return -1;
				} else {
					return 0;
				}
			}
		};
		PriorityQueue<City> Q = new PriorityQueue<City>(A.length, c);
		for (City s : cities) {
			Q.add(s);
		}
		while (!Q.isEmpty()) {
			City s = Q.poll();
			for (City u : getAdj(s)) {
				// 这里就是松弛relax，但是原作者的松弛都是直接在D数组上进行，所以我只能自己进行松弛的封装（其实不是封装而是直接写出）
				if (u.d > s.d + A[s.id][u.id]) {
					u.d = s.d + A[s.id][u.id];
				}
			}
		}
	}

	public double[][] floyd_warshall() {
		int n = A.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (A[i][j] == -1) {
					A[i][j] = 99999999;
				}
			}
		}
		return floyd_warshall_aux(A);
	}

	public double[][] floyd_warshall_aux(double[][] W) {
		int n = W.length;
		double[][][] D = new double[n + 1][n][n];
		D[0] = W;
		for (int k = 1; k < n + 1; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					D[k][i][j] = Math.min(D[k - 1][i][j], D[k - 1][i][k - 1]
							+ D[k - 1][k - 1][j]);
				}
			}
		}
		return D[n];
	}

}
