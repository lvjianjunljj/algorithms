package part22.section1;

import graph.archive.matrix.City;
import graph.archive.matrix.Map;

import java.util.ArrayList;
import arrayOperate.Array;


/**
 * 如果A[i, j] = 1，即(i, j)∈E（1≤i≤|V|，1≤j≤|V|，E是G的边集）， 那么顶点i就不可能是通用汇点，因为它有一条出边。
 * 现在假设A[i, j] = 0，即(i, j)∉E，且i≠j。在这种情况下，顶点j就不可能是通用汇点，因为它的入度小于|V|-1
 * 因此，这个问题等价于：给定一个有向图Ｇ的|V|×|V|邻接矩阵A，在O(|V|)时间内判断是否存在一个整数j（1≤j≤|V|），
 * 使得对于所有的i（1≤i≤|V|且i≠j）都有A[i, j] = 1，对于所有的k（1≤k≤|V|）都有A[j, k] = 0。
 * 更形象地说，就是判断A里面是否有这样一个“十”字：这“十”字的横全是0，竖全是1（除了“十”字的中心）
 * */
public class _Homework22_1_6_matrix {
	public static void main(String[] args) {
		// 构造有向图（作为输入）
		int nCities = 10;
		int c = 'A' - 1;
		City[] cities = new City[nCities];
		Map M = new Map(nCities, true);
		for (int i = 0; i < nCities; i++) {
			c++;
			cities[i] = new City((char) (c));
			M.createCity(cities[i]);
		}
		M.createEdge(0, 1, 1);
		M.createEdge(2, 1, 1);
		M.createEdge(3, 1, 1);
		M.createEdge(4, 1, 1);
		M.createEdge(5, 1, 1);
		M.createEdge(6, 1, 1);
		M.createEdge(7, 1, 1);
		M.createEdge(8, 1, 1);
		M.createEdge(9, 1, 1);
		M.createEdge(2, 5, 1);
		M.createEdge(3, 6, 1);
		M.createEdge(7, 8, 1);
		M.createEdge(8, 9, 1);
		M.createEdge(4, 6, 1);
		M.createEdge(0, 9, 1);
		M.createEdge(1, 9, 1);
		System.out.println(universal_sink(M));

	}

	protected static boolean universal_sink(Map M) {
		// i指向有可能是汇的编号最小的点
		double[][] Map = M.A;
		int n = Map.length;
		int i = 0, j = 0;
		/**
		 * 通过这个while得到的i是唯一一个有可能是汇点的点，之后再进行判断
		 */
		while (j < n) {
			// map[i][j] = 0,那么j没有i的入，一定不是汇，i可能是汇
			if (Map[i][j] <= 0) {
				j++;
			}
			// 若map[i][j] = 1，则(1)i有出，i不是汇(2)map[i][i+1..j-1]=0，i+1..j-1都不是汇(3)j及j以后的点可能是汇
			// 若i=j，j也不是汇，j+1可能是汇
			/*我的封装都是默认map[i][j]为0，所以可以将这个判断去掉
			else if (i == j) {
				i++;
				j++;
			}
			*/
			// 若i!=j，j以前的点都不是汇，j可能是汇
			else
				i = j;
		}
		// 没有汇
		if (i > n - 1)
			return false;
		// 找到有可能是汇的点，但是还是需要验证一下
		else {
			// 汇的纵向都是1，除了map[i][i]
			for (j = 0; j < i; j++) {
				if (Map[i][j] > 0)
					return false;
			}
			// 汇的横向都是0
			for (j = 0; j < n; j++)
				if (i != j && Map[j][i] == -1)
					return false;
			return true;
		}

	}
}
