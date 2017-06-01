package graph.archive.matrix;


public class City {
	public String name;
	public int id;
	public static int idCounter = 0;
	public City p;	//BFS中的父节点
	public double d;		//BFS中的从源节点到节点u的距离（在Dijkstra借用了一下）
	public boolean isVisted = false;
	public String path = "";

	public City(String name) {
		this.name = name;
		id = idCounter++;
	}

	// 通过char类型就能用for循环通过ascii码来快速定义多个city
	public City(char name) {
		this.name = String.valueOf(name);
		id = idCounter++;
	}

	public String toString() {
		return "顶点 " + name + ",下标：" + id + ".";
	}
}
