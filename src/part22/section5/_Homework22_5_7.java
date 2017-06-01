package part22.section5;

import graph.archive.linkList.Graph;
import graph.archive.linkList.Vertex;

import java.util.ArrayList;


public class _Homework22_5_7 {
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
		myGraph.addEdge(2, 3);
		myGraph.addEdge(3, 0);

		myGraph.displayGraph();
		System.out.println("*************************************");
		ArrayList<ArrayList<Vertex>> r = myGraph.stronglyConnectedComponents();
		for (int i = 0; i < r.size(); i++) {
			for (int j = 0; j < r.get(i).size(); j++) {
				System.out.print(r.get(i).get(j).label + "\t");
			}
			System.out.println();
		}
		// 书中对_Homework22_5_7的求解已经封装在part22.archive.linkList
		/**
		 * 根据课后题_Homework22_5_7的要求封装的求分量图相同的边数最少的等价图的方法——判断一个图是否是半连通的
		 * 若图G中任意两点u和v存在路径是的u到达v或者v到达u，则称图G是半连通的 STEP1：使用22.5-5中的算法得到componentFig。
		 * STEP2：对SCC求拓扑序列(v1, v2, ……, vk)
		 * STEP3：若在边SCC中存在边(v1,v2),(v2,v3),……,(vk-1,vk)，则图G为半连通。
		 */
		System.out.println(myGraph.isSemiCommunication());
	}
}
