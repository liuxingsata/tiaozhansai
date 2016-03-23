package huawei;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class readFile {
	int Pointnum=0,Edgenum=0;
	Link link = new Link();
	public readFile(String filename) throws IOException{
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(
				   new InputStreamReader(
				    new FileInputStream(filename)
				   )
				);
		String line;

		while ( (line = br.readLine()) != null ) {
			   Edgenum++;
			   String[] info = line.split(",");
			   link.insert(Integer.parseInt(info[0].trim()),Integer.parseInt(info[1].trim()),Integer.parseInt(info[2].trim()),Integer.parseInt(info[3].trim()));
			   }
		/*
		Node n = link.getHead();
		while(n!=null){
			System.out.println(n.getLinkID()+"\t"+n.getSourceID()+"\t"+n.getDestinationID()+"\t"+n.getCost()); 
			n = n.getNext();}
			*/
		Pointnum = pointCal(link.getHead());
		}
	public int pointCal(Node hedge){
		int num = 0,i=0;
		pointcal[] p = new pointcal[Edgenum*2];
		for(int a = 0;a < p.length;a++)p[a] = new pointcal();
		while(hedge.getNext()!=null){
			p[i].setId(hedge.getSourceID());
			p[i+1].setId(hedge.getDestinationID());
			hedge = hedge.getNext();
			i=i+2;
		}
		for(int a=0;a<p.length;a++){
			for(int b=a+1;b<p.length;b++){
				if(p[a].getId()==p[b].getId())p[b].setFlag(true);;
			}
			}
		for(pointcal P2:p)if(!P2.isFlag())num++;
		return num;
	}
	}
class Node {
	private int LinkID;
	private int SourceID;
	private int DestinationID;
	private int Cost;
	private Node next;
	public Node(){
		this(0, 0, 0, 0, null);
	}
	public Node(int LinkID,int SourceID,int DestinationID,int Cost){
		this(LinkID,SourceID,DestinationID,Cost,null);
	}
	public Node(int LinkID,int SourceID,int DestinationID,int Cost,Node next){
		this.setLinkID(LinkID);
		this.setSourceID(SourceID);
		this.setDestinationID(DestinationID);
		this.setCost(Cost);
		this.setNext(next);
	}

	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public int getLinkID() {
		return LinkID;
	}
	public void setLinkID(int linkID) {
		LinkID = linkID;
	}
	public int getSourceID() {
		return SourceID;
	}
	public void setSourceID(int sourceID) {
		SourceID = sourceID;
	}
	public int getDestinationID() {
		return DestinationID;
	}
	public void setDestinationID(int destinationID) {
		DestinationID = destinationID;
	}
	public int getCost() {
		return Cost;
	}
	public void setCost(int cost) {
		Cost = cost;
	}
	
}
class Link{
	private Node head;
	
	public Node getHead() {
		return head;
	}
	public void setHead(Node hea) {
		this.head = hea;
	}
	public Link(){}
	void insert(int a,int b,int c,int d) {
		if (head == null) {
			head = new Node(a,b,c,d);
		} else {
			Node temp = head;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			Node newNode = new Node(a,b,c,d);
			temp.setNext(newNode);
		}
	}
}
class pointcal{
	private boolean flag;
	private int id;
	public pointcal(){
		this(false,0);
	}
	public pointcal(int id){
		this.id = id;
	}
	public pointcal(boolean flag,int id){
		this.id = id;
		this.flag = false;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
