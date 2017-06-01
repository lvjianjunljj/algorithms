package part22.section1;

import graph.archive.matrix.City;
import graph.archive.matrix.Map;

import java.util.ArrayList;
import arrayOperate.Array;


public class _Homework22_1_5_matrix {
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

		// 构造新的图
		City[] cities_out = new City[nCities];
		Map M_out = new Map(nCities, true);
		for (int i = 0; i < nCities; i++) {
			cities_out[i] = new City(cities[i].name);
			M_out.createCity(cities_out[i]);
		}
		
		//思路是一样的
		for (int i = 0; i < M.A.length; i++) {
			for (int j = 0; j < M.A[i].length; j++) {
				if (M.A[i][j] >0) {
					M_out.A[i][j]=M.A[i][j];
					for (int k = 0; k < M.A[j].length; k++) {
						if (M.A[j][k] >0) {
							M_out.A[i][k]=M.A[j][k];
						}
					}
				}
			}
		}
		
		M_out.displayMap();
	}
}
