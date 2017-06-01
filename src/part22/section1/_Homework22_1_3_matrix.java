package part22.section1;

import graph.archive.matrix.City;
import graph.archive.matrix.Map;

import java.util.ArrayList;

import arrayOperate.Array;


public class _Homework22_1_3_matrix {
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
		M.createEdge(0, 2, 1);
		M.createEdge(0, 3, 1);
		M.createEdge(1, 4, 1);
		M.createEdge(2, 5, 1);
		M.createEdge(3, 6, 1);
		M.createEdge(7, 8, 1);
		M.createEdge(8, 9, 1);
		M.createEdge(4, 6, 1);
		M.createEdge(0, 9, 1);

		M.displayMap();
		System.out.println("*************************************");

		// 自己曾封装过矩阵的转置的方法，所以做起来很简单
		M.A = Array.transpose(M.A);

		M.displayMap();

	}
}
