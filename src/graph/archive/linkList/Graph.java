package graph.archive.linkList;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
 
 
 




/**

*������������������������������������������������
*

*@authorxiayi

*

*/

public class Graph{

	public Vertex vertexList[];

	private boolean is=false;//������������������������������������������������������������������������������������������������������������������������
	private int nVerts=0;



	public Graph(){

	}



	public Graph(int n){

		vertexList=new Vertex[n];



	}



	public Graph(int n,boolean is){

		this.is=is;

		vertexList=new Vertex[n];

	}



	//////////////////////////////////////////////

	public boolean isIs(){

		return is;

	}



	public void setIs(boolean is){

		this.is=is;

	}



	public Vertex[]getVertexList(){

		return vertexList;

	}



	////////////////////////////////////////////////////

	/**

	*������������������������������������

	*/

	public void addVertex(Vertex vertex){

		vertex.setIndex(nVerts);

		vertexList[nVerts]=vertex;

		nVerts++;

	}



	/**

	*������������������������������
	*/

	public void addEdge(int start,int end){

		vertexList[start].addAdj(vertexList[end]);

		vertexList[start].out++;

		vertexList[end].in++;

		if(!is){

			vertexList[end].addAdj(vertexList[start]);

			vertexList[end].out++;

			vertexList[start].in++;

		}

	}



	/*

	*������������������������������������������������������������������������������������������������������������������������������������������������������������������Vertex������������������������������������������������������index������������������������������������������������������������������������������������������addEdge(int start,int 

	*end)������������������

	*/

	public void addEdge(Vertex start,Vertex end){

		start.addAdj(end);

		start.out++;

		end.in++;

		if(!is){

			end.addAdj(start);

			end.out++;

			start.in++;

		}

	}



	/**

	*������������������������������������������������������

	*

	*@return 

	*/

	public int getVertsCount(){

		return vertexList.length;

	}



	public void displayGraph(){

		ArrayList<Vertex>next=null;

		for(int i=0;i<vertexList.length;i++){

			printVertx(vertexList[i]);

		}

	}



	public void printVertx(Vertex vertex){

		ArrayList<Vertex>next=vertex.getAdj();

		if(next==null){

			System.out.println(vertex.toString()+"������������������������������������");

		}else{

			System.out.print (vertex.toString()+"������������������������������������:");

			for(int i=0;i<next.size();i++){

				System.out.print("������������������"+next.get(i).label+",");

			}

			System.out.println();

		}

	}



	public void displayGraph_componentFig(){

		ArrayList<Vertex>next=null;

		for(int i=0;i<vertexList.length;i++){

			printVertx_componentFig(vertexList[i]);

		}

	}



	public void printVertx_componentFig(Vertex vertex){

		ArrayList<Vertex>next=vertex.getAdj();

		if(next.size()==0){

			System.out.println("������������������"+vertex.name+",\t������������������������������+vertex.index"

					+",\t������������������������������������");

		}else{

			System.out.print ("������������������"+vertex.name+",\t������������������������������"+vertex.index

					+",\t������������������������������������:");

			for(int i=0;i<next.size();i++){

				System.out.print ("������������������"+next.get(i).name+",");

			}

			System.out.println();

		}

	}



	/**

	*������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������
	*/



	/**

	*������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������

	*������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������
	*/

	//������������������������������������������������������������������������������������������������������������������������������������������������������������������

	public void removeRepeat(Vertex v){

		ArrayList<Vertex>next=v.getAdj();

		//������������ashSet������������������

		Set set=new HashSet();//������������������������������������set������������
		List newList=new ArrayList();//������������������������������������ArrayLIst������������������

		if(next!=null){

			for(int i=0;i<next.size();i++){

				Object element=next.get(i);

				if(set.add(element))//������������������set������������������true������������������������������������������������������

					newList.add(element);

			}

			next.clear();//������������������������������������������������������

			next.addAll(newList);//������������������������������������������������������

		}

	}



	public void removeRing(Vertex v){

		ArrayList<Vertex>next=v.getAdj();

		if(next!=null){

			for(int i=0;i<next.size();i++){

				if(next.get(i).equals(v)){

					next.remove(i);

					i--;//������������������������������������������������������i������������������������������������������������������������������������������������������������������������������emove������������������������������������������������������������������ist������������������������������������������������������������������������������������������������������������������������
				}

			}

		}

	}



	//������������������������������������������������������������������������������������������������������������������������������������������fs������������������

	public void bfs(Vertex s){

		for(Vertex v:vertexList){

			v.d=Integer.MAX_VALUE;

		}

		s.isVisted=true;

		ArrayList<Vertex>adjs=s.getAdj();

		s.p=null;

		s.d=0;

		Queue Q=new LinkedList<Vertex>();

		Q.add(s);

		while(!Q.isEmpty()){

			Vertex u=(Vertex)Q.poll();

			if(u.getAdj()!=null){

				for(Vertex v:u.getAdj()){

					if(v.isVisted==false){

						v.isVisted=true;

						v.d=u.d+1;

						v.p=u;

						Q.add(v);

					}

				}

			}

		}

		//������������������������������������������������������v������������sVisted������������������������������������������������������������������������������������������������������������������������fs������������������������������������������������������������������������������������������

		for(Vertex v:vertexList){

			v.isVisted=false;

		}

	}



	public void printBFS(Vertex s){

		bfs(s);

		System.out.println("������������������"+s.label+"������������fs������������");

		for(Vertex v:vertexList){

			System.out.println("������������������"+v.label+","+"������������������������������������"+v.d);

		}

	}



	public int time=0;//������������������dfs_visit������������������������������������������������ime������������������������������������������������������������������������time������������������������������������������������������������������������������������fs_visit������������


	public void dfs(){

		for(Vertex u:vertexList){

			u.isVisted=false;

			u.p=null;

		}

		for(Vertex u:vertexList){

			if(u.isVisted==false){

				dfs_visit(u);

			}

		}

		for(Vertex v:vertexList){

			v.isVisted=false;

		}

		System.out.println();

		System.out.println("Thefinaltimeis"+time);

		time=0;

	}



	public void dfs_visit(Vertex u){

		time++;

		System.out.print ("("+u.label);//������������������������������������������������������������������������������������������������������������������������������������������
		u.b=time;

		u.isVisted=true;

		if(u.getAdj()!=null){

			for(Vertex v:u.getAdj()){

				if(v.isVisted==false){

					v.p=u;

					dfs_visit(v);

				}

			}

		}

		time++;

		System.out.print (u.label+")");

		u.f=time;

	}



	public void dfsStack(){

		for(Vertex u:vertexList){

			u.isVisted=false;

			u.p=null;

		}

		Stack stack=new Stack();

		for(Vertex s:vertexList){

			if(!s.isVisted){

				time++;

				s.b=time;

				s.isVisted=true;

				System.out.print ("("+s.label);

				stack.add(s);

				while(!stack.isEmpty()){

					Vertex u=(Vertex)stack.peek();

					if(whiteChild(u)!=null){

						stack.add(whiteChild(u));

						time++;

						whiteChild(u).b=time;

						System.out.print ("("+whiteChild(u).label);

						whiteChild(u).isVisted=true;

					}else{

						time++;

						u.f=time;

						stack.pop();

						if(u.getAdj()!=null){

							for(Vertex v:u.getAdj()){

								if(!v.isVisted){

									time++;

									v.b=time;

									System.out.print ("("+v.label);

									stack.add(v);

									v.isVisted=true;

								}

							}

						}

						System.out.print (u.label+")");

					}

				}

			}



		}

		for(Vertex v:vertexList){

			v.isVisted=false;

		}

		System.out.println();

		System.out.println("Thefinaltimeis"+time);

		time=0;

	}



	public Vertex whiteChild(Vertex s){

		if(s.getAdj()!=null){

			for(Vertex u:s.getAdj()){

				if(!u.isVisted){

					return u;

				}

			}

			return null;

		}else{

			return null;

		}

	}



	//������������������_Homework22_3_13������������������������������������������������������������������������������������������������������������������������������������������������������������
	public boolean isSingly=true;



	public void isSingly(){

		for(Vertex u:vertexList){

			u.isVisted=false;

			u.p=null;

		}

		for(Vertex u:vertexList){

			isSingly_visit(u);

			for(Vertex v:vertexList){

				v.isVisted=false;

			}

		}

		for(Vertex v:vertexList){

			v.isVisted=false;

		}

	}



	public void isSingly_visit(Vertex u){

		u.isVisted=true;

		if(u.getAdj()!=null){

			for(Vertex v:u.getAdj()){

				if(v.isVisted==false){

					isSingly_visit(v);

				}else{

					isSingly=false;

				}

			}

		}

	}



	//������������������������������������

	public void topologicalSort(){

		//������������������dfs������������������������������������������������������������������������������������������������������������������������������������������fs������������������������������������������������������������������������������������������������������������������������������dfs_visit������������������������������������������������������������������������������������������������������������������������������������������������������������������������������
		for(Vertex u:vertexList){

			u.isVisted=false;

		}

		for(Vertex u:vertexList){

			if(u.isVisted==false){

				topologicalSort_visit(u);

			}

		}

		Comparator c=new Comparator(){

			@Override

			public int compare(Object v1,Object v2){

				if(((Vertex)v1).f>((Vertex)v2).f){

					return -1;

				}else{

					return 1;

				}

			}

		};

		Arrays.sort(vertexList,c);

		for(Vertex u:vertexList){

			u.isVisted=false;

		}

	}



	//������������������������������������������������������������������������������������������������������������������������������

	public void indexSort(){

		Comparator c=new Comparator(){

			@Override

			public int compare(Object v1,Object v2){

				if(((Vertex)v1).index>((Vertex)v2).index){

					return 1;

				}else{

					return -1;

				}

			}

		};

		Arrays.sort(vertexList,c);

	}



	public void topologicalSort_visit(Vertex u){

		time++;

		u.isVisted=true;

		if(u.getAdj()!=null){

			for(Vertex v:u.getAdj()){

				if(v.isVisted==false){

					topologicalSort_visit(v);

				}

			}

		}

		time++;

		u.f=time;

	}



	/**

	*������������������������������������_Homework22_4_2������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������fs_visit������������������������������������������������������������������������������������
	*������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������sVisted������������������

	*/

	public int number=0;



	public void path_number(Vertex s,Vertex u){

		if(s.getAdj()!=null){

			for(Vertex v:s.getAdj()){

				if(v==u){

					number++;

				}

				path_number(v,u);

			}

		}

	}



	/**

	*������������������������������������_Homework22_4_3������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������dfs������������������������������������������������������������������������������������
	*������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������isSingly������������������������������������������������������������������sVisited������������������������������
	*������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������p������������������

	*������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������

	*/

	public boolean isContainRing=false;;



	public void containRing(){

		for(Vertex u:vertexList){

			u.isVisted=false;

		}

		for(Vertex u:vertexList){

			if(u.isVisted==false){

				ring_visit(u);

			}

		}

		for(Vertex v:vertexList){

			v.isVisted=false;

		}

	}



	public void ring_visit(Vertex u){

		u.isVisted=true;

		if(u.getAdj()!=null){

			for(Vertex v:u.getAdj()){

				if(v.isVisted==false){

					v.p=u;

					ring_visit(v);

				}else if(u.p!=v){

					isContainRing=true;

				}

			}

		}

	}



	/**

	*������������������������������������������������������������������������������������=(V,E)����������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������

	*������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������while������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������
	*������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������1,������������������������������������������������������������������������������������������������
	*/



	//Vertex������������������������������������������������������������������������������������������������������


	public ArrayList<Vertex>topologicalSortQueue(){

		ArrayList<Vertex> result=new ArrayList<Vertex>();

		Queue Q=new LinkedList<Vertex>();

		for(Vertex s:vertexList){

			if(s.in==0){

				Q.add(s);

			}

		}

		while(!Q.isEmpty()){

			Vertex u=(Vertex)Q.poll();

			result.add(u);

			if(u.getAdj()!=null){

				for(Vertex v:u.getAdj()){

					v.in--;

					if(v.in==0){

						Q.add(v);

					}

				}

			}

		}

		return result;

	}



	//������������2.5������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������

	public Graph graphTranspose(){

		Graph transposeGraph=new Graph(nVerts,is);

		for(Vertex u:vertexList){//������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������

			transposeGraph.addVertex(new Vertex(u.label));

		}

		for(Vertex u:vertexList){

			if(u.getAdj()!=null){

				for(Vertex v:u.getAdj()){

					transposeGraph.addEdge(v.index,u.index);

				}

			}

		}

		return transposeGraph;

	}



	//������������������������������������������������������������������������������������������������������������������������������������������������������������������������������
	public void graphTranspose_self(){

		Graph graph_aux=new Graph(nVerts,is);

		for(Vertex u:vertexList){

			graph_aux.addVertex(u.clone());

		}

		for(Vertex u:vertexList){

			u.setAdj(null);

		}

		for(Vertex u:graph_aux.vertexList){

			if(u.getAdj()!=null){

				for(Vertex v:u.getAdj()){

					addEdge(v.index,u.index);

				}

			}

		}

	}



	/**

	*Kosaraju_Algorithm:������������step1������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������
	*step2������������������������������������������������������������������������������������������������������������������������������������������������������������������GT������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������
	*step3����������������������������������������������������������������������������������������������������������������������������step2������������������������������������������������������������������
	*/

	public ArrayList<ArrayList<Vertex>>stronglyConnectedComponents(){

		//������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������

		ArrayList<ArrayList<Vertex>> result=new ArrayList<ArrayList<Vertex>>();

		ArrayList<Vertex> vertexlist=new ArrayList<Vertex>();

		ArrayList<Vertex> vertexlist_result=new ArrayList<Vertex>();

		sccdfs();

		graphTranspose_self();

		Vertex s=new Vertex("s");

		for(Vertex u:vertexList){

			vertexlist.add(u);

		}

		while(!vertexlist.isEmpty()){

			//������������������������������������while������������������������������������������������������������������������������������������������������ertexlist������������������f������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������
			//������������������������������������������������������������������������������������������������������������������������������

			s.f=Integer.MIN_VALUE;

			for(Vertex u:vertexlist){

				if(s.f<u.f){

					s=u;

				}

			}

			sccdfs_visit_reverse_remove(s,vertexlist,vertexlist_result);

			vertexlist_result.add(new Vertex("!"));//������������������������������������������������������������������������������������������

		}

		for(Vertex u:vertexList){

			u.isVisted=false;

		}

		int i=0;

		result.add(new ArrayList<Vertex>());

		for(Vertex u:vertexlist_result){

			if(("!".charAt(0))!=(u.label)){

				result.get(i).add(u);

			}else{

				result.add(new ArrayList<Vertex>());

				i++;

			}

		}

		//������������������������������������������������������������������
		graphTranspose_self();

		//������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������rrayList<Vertex>������������������

		result.remove(result.size()-1);

		return  result;

	}



	//������������������������������������������������������������������������������������������������������������������������
	public ArrayList<ArrayList<Vertex>>stronglyConnectedComponentsPriorityQueue(){

		//������������������isVisited������������������������������������������������
		for(Vertex u:vertexList){

			u.isVisted=false;

		}

		ArrayList<ArrayList<Vertex>> result=new ArrayList<ArrayList<Vertex>>();

		ArrayList<Vertex> vertexlist_result=new  ArrayList<Vertex>();

		sccdfs();

		graphTranspose_self();

		Comparator c=new Comparator(){

			@Override

			public int compare(Object v1,Object v2){

				if(((Vertex)v1).f>((Vertex)v2).f){

					return -1;

				}else{

					return  1;

				}

			}

		};

		PriorityQueue<Vertex>Q=new PriorityQueue<Vertex>(nVerts,c);

		for(Vertex u:vertexList){

			Q.add(u);

		}

		while(!Q.isEmpty()){

			Vertex s=Q.poll();

			sccdfs_visit_reverse_remove_Queue(s,Q,vertexlist_result);

			vertexlist_result.add(new Vertex("!"));//������������������������������������������������������������������������������������������

		}

		for(Vertex u:vertexList){

			u.isVisted=false;

		}

		int i=0;

		result.add(new ArrayList<Vertex>());

		for(Vertex u:vertexlist_result){

			if(("!".charAt(0))!=(u.label)){

				result.get(i).add(u);

			}else{

				result.add(new ArrayList<Vertex>());

				i++;

			}

		}

		//������������������������������������������������������������������������������������������������������������������������������������������������������������������������������
		graphTranspose_self();

		indexSort();

		result.remove(result.size()-1);

		return  result;

	}



	//������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������

	//������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������
	//public ArrayList<ArrayList<Vertex>>stronglyConnectedComponentsStack(){

	////������������������isVisited������������������������������������������������
	//for(Vertex u:vertexList){

	//u.isVisted=false;

	//}

	//ArrayList<ArrayList<Vertex>>result=new ArrayList<ArrayList<Vertex>>();

	//Queue<Vertex>Q=new LinkedList<Vertex>();

	//ArrayList<Vertex>vertexlist_result=new ArrayList<Vertex>();

	//sccdfs();

	//topologicalSort();

	//graphTranspose_self();

	//for(Vertex u:vertexList){

	//Q.add(u);

	//}

	//while(!Q.isEmpty()){

	//Vertexs=Q.poll();

	//sccdfs_visit_reverse_remove_Stack(s,Q,vertexlist_result);

	//vertexlist_result.add(new Vertex("!"));//������������������������������������������������������������������������������������������

	//}

	//for(Vertex u:vertexList){

	//u.isVisted=false;

	//}

	//int i=0;

	//result.add(new ArrayList<Vertex>());

	//for(Vertex u:vertexlist_result){

	//if(("!".charAt(0))!=(u.label)){

	//result.get(i).add(u);

	//}else{

	//result.add(new ArrayList<Vertex>());

	//i++;

	//}

	//}

	////������������������������������������������������������������������������������������������������������������������������������������������������������������������������������
	//graphTranspose_self();

	//indexSort();

	//result.remove(result.size()-1);

	//return  result;

	//}



	//������������������������������������������������fs������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������

	public void sccdfs(){

		for(Vertex u:vertexList){

			u.isVisted=false;

		}

		for(Vertex u:vertexList){

			if(u.isVisted==false){

				sccdfs_visit(u);

			}

		}

		for(Vertex u:vertexList){

			u.isVisted=false;

		}

		time=0;

	}



	public void sccdfs_visit(Vertex u){

		time++;

		u.isVisted=true;

		if(u.getAdj()!=null){

			for(Vertex v:u.getAdj()){

				if(v.isVisted==false){

					sccdfs_visit(v);

				}

			}

		}

		time++;

		u.f=time;

	}



	public void sccdfs_visit_reverse_remove(Vertex u,

			ArrayList<Vertex>vertexlist,ArrayList<Vertex>vertexlist_result){

		vertexlist.remove(u);

		u.isVisted=true;

		vertexlist_result.add(u);

		if(u.getAdj()!=null){

			for(Vertex v:u.getAdj()){

				if(v.isVisted==false){

					sccdfs_visit_reverse_remove(v,vertexlist,

							vertexlist_result);

				}

			}

		}

	}



	//public void sccdfs_visit_reverse_remove_Stack(Vertex u,Queue<Vertex>Q,

	//ArrayList<Vertex>vertexlist_result){

	//u.isVisted=true;

	//vertexlist_result.add(u);

	//if(u.getAdj()!=null){

	//for(Vertex v:u.getAdj()){

	//if(v.isVisted==false){

	//Q.remove(v);

	//sccdfs_visit_reverse_remove_Stack(v,Q,vertexlist_result);

	//}

	//}

	//}

	//}

	public void sccdfs_visit_reverse_remove_Queue(Vertex u,

			PriorityQueue<Vertex>Q,ArrayList<Vertex>vertexlist_result){

		u.isVisted=true;

		vertexlist_result.add(u);

		if(u.getAdj()!=null){

			for(Vertex v:u.getAdj()){

				if(v.isVisted==false){

					Q.remove(v);

					sccdfs_visit_reverse_remove_Queue(v,Q,vertexlist_result);

				}

			}

		}

	}



	/**

	*������������������������������������������������Homework22_5_5������������������������������������������������������������������������������������������������������������������������
	*������������������������������������������������������������������������stronglyConnectedComponents������������������������������������������������������

	*������������������������������������������������������������������������stronglyConnectedComponent������������������������������������������������������������������������������������������������������������

	*/

	public Graph componentFig(){

		ArrayList<ArrayList<Vertex>>result=stronglyConnectedComponents();

		Graph result_graph=new Graph(result.size(),is);

		for(Vertex u:vertexList){

			u.cp=null;

		}

		for(ArrayList<Vertex>array:result){

			Vertex s=new Vertex("s");

			result_graph.addVertex(s);

			for(Vertex u:array){

				s.name+=u.label;

				u.cp=s;

				s.cc.add(u);

			}

		}

		for(Vertex u:vertexList){

			if(u.getAdj()!=null){

				for(Vertex v:u.getAdj()){

					result_graph.addEdge(u.cp,v.cp);

				}

			}

		}

		for(Vertex u:result_graph.vertexList){

			result_graph.removeRepeat(u);

			result_graph.removeRing(u);

		}

		return  result_graph;

	}



	//������������������������������������������������Homework22_5_6������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������

	public Graph componentFigSimple(){

		ArrayList<ArrayList<Vertex>>result=stronglyConnectedComponents();

		Graph component=componentFig();

		Graph result_graph=new Graph(nVerts,is);

		for(int i=0;i<nVerts;i++){

			Vertex u=new Vertex(vertexList[i].label);

			result_graph.addVertex(u);

		}

		for(ArrayList<Vertex>list:result){

			result_graph.addEdge(list.get(list.size()-1).index,

					list.get(0).index);

			for(int i=0;i<list.size()-1;i++){

				result_graph.addEdge(list.get(i).index,list.get(i+1).index);

			}

		}

		for(Vertex s:component.vertexList){

			if(s.getAdj()!=null){

				for(Vertex u:s.getAdj()){

					result_graph.addEdge(s.cc.get(0).index,u.cc.get(0).index);

				}

			}

		}



		return  result_graph;

	}



	/**

	*������������������������������������������������Homework22_5_7������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������

	*������������������G������������������������������������������������������������������������������������������������������������������u������������������v������������������v������������������u������������������������������������G������������������������������������������������STEP1������������������������������2.5-5������������������������������������������������������componentFig������������
	*STEP2������������������SCC������������������������������������������������v1,v2,������������������,vk)

	*STEP3������������������������������������SCC������������������������������������(v1,v2),(v2,v3),������������������,(vk-1,vk)������������������������������������������������������������������������������
	*/

	public boolean isSemiCommunication(){

		Graph componentFig=componentFig();

		componentFig.topologicalSort();

		for(int i=0;i<componentFig.vertexList.length-1;i++){

			if(componentFig.vertexList[i].getAdj()!=null){

				if(componentFig.vertexList[i].getAdj().indexOf(

						componentFig.vertexList[i+1])==-1){

					return  false;

				}

			}else{

				return  false;

			}

		}

		return  true;

	}



	/**

	*������������Homework_22_3������������������������������������������������������������������������������������������������������������

	*������������������������������������������������������G����������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������v������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������
	*������������������������������������������������������������������������������������������u������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������C������������������������������������������������������x������������������������������������������������������������������������������������������

	*������������������������������������������������������x������������������������������������������������������������������������������������������������������C������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������G������������������������������������������������������������������������������������������������������������������������������

	*

	*������������������������������������������������������(1)������������������������������������������������������CList������������������������������������������������������������������������������������������������������(2)������������������������������������������������������L������������������������������������������������������������������������������������������������������������������������(3)������������������������������������������������������������������������G

	*

	*������������������������������������������������������������������������������������������������������������������������������������������������������������������O(E)(1)������������������G������������������������������������������������������������������L������������������������������������������������������

	*(2)����������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������v������������������������������

	*������������������������������������������������������L������������������������������������������������������������������������������������������C������������������CList������������������������������������������������������CList������������������������������������������������������������������������������������������������������������(3)

	*������������������������������������L����������������������������������������������������������������������������������������������������������������������������������������������L������������������������������������������������������������������������������������������������������2)

	*/

	public LinkedList eulerLoop(){

		/*

		*������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������

		*������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������stronglyConnectedComponents

		*()������������������������������������vertex������������n������������ut����������������������������������������������������

		*/

		for(Vertex u:vertexList){

			if(u.in!=u.out||u.in==0){

				System.out.println("ThereisnoeulerLoop!!!");

				return  null;

			}

		}

		Queue<Vertex>Q=new LinkedList<Vertex>();

		for(Vertex u:vertexList){

			Q.add(u);

		}

		LinkedList<Vertex>result=new LinkedList<Vertex>();

		result.add(Q.peek());

		while(!Q.isEmpty()){

			LinkedList<Vertex>branch=new LinkedList<Vertex>();

			Vertex s=Q.peek();

			s.out--;

			Vertex u=adjSearch(s);

			u.out--;

			branch.add(u);

			while(u!=s){

				u=u.getAdj().get(0);

				u.out--;

				branch.add(u);

			}

			for(Vertex v:vertexList){

				if(v.out<1){

					Q.remove(v);

				}

			}

			result.addAll(result.indexOf(s)+1,branch);

		}

		return   result;

	}



	//������������������������������������������������������s������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������
	public Vertex adjSearch(Vertex u){

		if(u.getAdj()!=null){

			for(Vertex v:u.getAdj()){

				if(v.out>0){

					return  v;

				}

			}

			return  null;

		}else{

			return  null;

		}

	}



	public void reachability(){

		Graph aux_graph=componentFig();

		for(Vertex s:aux_graph.vertexList){

			int min=Integer.MAX_VALUE;

			for(Vertex u:s.cc){

				if(min>u.index){

					min=u.index;

				}

			}

			s.min=min;

		}

		aux_graph.minSort();

		for(Vertex s:aux_graph.vertexList){

			if(s.getAdj()!=null){

				for(Vertex u:s.getAdj()){

					if(s.min>u.min){

						s.min=u.min;

					}

				}

			}

		}

		for(Vertex s:aux_graph.vertexList){

			for(Vertex u:s.cc){

				u.min=s.min;

			}

		}



	}



	public void minSort(){

		Comparator c=new Comparator(){

			public int compare(Object v1,Object v2){

				if(((Vertex)v1).min>((Vertex)v2).min){

					return  1;

				}else if(((Vertex)v1).min<((Vertex)v2).min){

					return  -1;

				}else{

					return  0;

				}

			}

		};

		Arrays.sort(vertexList,c);

	}

}


