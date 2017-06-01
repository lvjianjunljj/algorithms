package graph.archive.linkList;

import java.util.ArrayList;

public class Vertex implements Cloneable {
	// 因为在对图进行反置的时候，需要对点进行克隆，所以需要对Cloneable接口的实现
	public char label;
	public boolean isVisted = false;
	public int index;
	public Vertex p; // BFS中的父节点
	public int d; // BFS中的从源节点到节点u的距离
	public int b; // DFS中的时间戳——第一次被发现的时间
	public int f; // DFS中的时间戳——搜索完成对节点的邻接链表扫描的时间
	public int in = 0; // 用Queue实现拓扑排序所用到的入度属性
	public int out = 0;// 为了计算欧拉回路而封装的出度属性
	public String name = "";// 将图收收缩为分量图时各节点所代表的节点的总称（需要初始化一下，不然会最后输出的时候会成“null”）
	public Vertex cp;// 用于求分量图时多个节点收缩为一个节点时多个节点与收缩节点的对应关系（_Homework22_5_5）
	public ArrayList<Vertex> cc = new ArrayList<Vertex>();// 用于求分量图时多个节点收缩为一个节点时收缩节点与多个节点的对应关系
	// 属性本身在_Homework22_5_5中没什么用，但在_Homework22_5_6有用
	public int min = -1;//用于求可到达性而封装的min(u)参数，-1表示还未求得（_Homework22_4）
	private ArrayList<Vertex> next = null;

	public boolean good = true;// 默认该摔跤手为娃娃脸（好人）（_Homework22_2_7做题的需要，没有其他用途）

	public Vertex(char lab) // constructor
	{
		label = lab;
		isVisted = false;
	}

	public Vertex(String lab) // constructor
	{
		label = lab.charAt(0);// label属性只能是单字符
		isVisted = false;
	}

	// 为节点添加邻接点
	public void addAdj(Vertex ver) {
		if (next == null)
			next = new ArrayList<Vertex>();
		next.add(ver);
	}

	public ArrayList<Vertex> getAdj() {
		return next;
	}

	public void setAdj(ArrayList<Vertex> next) {
		this.next = next;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String toString() {
		return "顶点 " + label + ",下标：" + index + ".";
	}

	public Vertex clone() {
		Vertex o = null;
		try {
			o = (Vertex) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}
}
