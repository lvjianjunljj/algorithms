package test;

import graph.archive.linkList.Vertex;

import java.util.Comparator;
import java.util.PriorityQueue;

 
public class PriorityQueueExample {
 
    public static void main(String[] args) {
    	Comparator c = new Comparator() {
			@Override
			public int compare(Object v1, Object v2) {
				if (((Vertex) v1).label > ((Vertex) v2).label) {
					return -1;
				} else if(((Vertex) v1).label < ((Vertex) v2).label){
					return 1;
				}else{
					return 0;
				}
			}
		};
    	PriorityQueue<Vertex> q = new PriorityQueue<Vertex>(11,c);
		q.add(new Vertex("a"));
		q.add(new Vertex("b"));
		q.add(new Vertex("c"));
		q.add(new Vertex("d"));
		q.add(new Vertex("e"));
		q.add(new Vertex("f"));
		for (int i = 0; i < 6; i++) {
			System.out.println(q.poll().label);
		}

    }
 
}
