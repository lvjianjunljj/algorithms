package graph.archive.linkList_fail;
//对于这位封装的邻接链表图算法，我暂时只能说呵呵了。。。
public class Graph {
	public Vertex ver_List[];
	public boolean direct;// true为有向图，false为无向图
	public static int v_index = 0;// 计算当前点在数组内的下标

	/* Graph构造 */
	public Graph(int num, boolean flag) {
		direct = flag;
		ver_List = new Vertex[num];
	}

	/* 添加节点 */
	public void addVertex(Vertex v) {
		ver_List[v_index++] = v;
	}

	/* 添加边 */
	public void addEdge(int from, int to) {
//		我不知道为什么会有这句话
		ver_List[from].setLabel(from);
		ver_List[from].add_adjacent(ver_List[to]);
		if (!direct) {
			ver_List[to].setLabel(to);
			ver_List[to].add_adjacent(ver_List[from]);
		}
	}

}
