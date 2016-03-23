package huawei;

public class linkGraph {
    private int numEdges; //当前边数
    private int numVertice;
    private Vertex[] NodeTable = null;
   
    public int getNumVertices() {
		return numVertice;
	}

	public void setNumVertices(int numVertice) {
		this.numVertice = numVertice;
	}

	public int getNumEdges() {
		return numEdges;
	}

	public void setNumEdges(int numEdges) {
		this.numEdges = numEdges;
	}

	public linkGraph(int size,int edge,Link link) {
        //构造方法：建立一个邻接表
        setNumVertices(size);
        setNumEdges(edge);
         //创建顶点表数组
       // System.out.println(numVertice);
        NodeTable = new Vertex[numVertice];
        for(int i = 0;i < numVertice;i++){
        	Vertex v = new Vertex();
        	NodeTable[i] = v;
        }
        if (NodeTable == null) {
            System.out.println("GraphLink is failed to create");
           }
        for (int i = 0; i < size; i++){
        	NodeTable[i].setKey(i);
        	NodeTable[i].setAdj(null);
        }
        Node n = link.getHead();
        while(n!=null){
        	Edge ed = new Edge();
        	ed.setDest(n.getDestinationID());
			ed.setEdgeID(n.getLinkID());
			ed.setCost(n.getCost());
			if((NodeTable[n.getSourceID()].getAdj())==null){
				//System.out.println(n.getSourceID());
				NodeTable[n.getSourceID()].setAdj(ed);
			}else{
				linkEdge(NodeTable[n.getSourceID()].getAdj(),ed);
				
			}
			n = n.getNext();
        }
        
    }

	private void linkEdge(Edge adj, Edge ed) {
		while(adj.getLink()!=null){
			adj=adj.getLink();
			}
		adj.setLink(ed);
	}

	public void Destroy() {
        //删除一个邻接表
        for (int i = 0; i < getNumVertices(); i++) {
            Edge p = NodeTable[i].getAdj();
            while (p != null) {
                NodeTable[i].setAdj(p.getLink());
                p = NodeTable[i].getAdj();
            }
        }
    }

    public int getVertexPos(int vertx) {
        //给出顶点vertex在图中的位置
        for (int i = 0; i < getNumVertices(); i++)
            if (NodeTable[i].getKey() == vertx)
                return i;
        return -1;
    }

    public int getValue(int i) { //取顶点 i 的值
        return (i >= 0 && i < getNumVertices()) ? NodeTable[i].getKey() : 0;
    }

    public int getFirstNeighbor(int v) {
        //给出顶点位置为 v 的第一个邻接顶点的位置,
        //如果找不到, 则函数返回-1
    	
        if (v != -1) {
            //顶点v存在
            Edge p = NodeTable[v].getAdj(); //对应边链表第一个边结点
            if (p != null) {
                //存在, 返回第一个邻接顶点
            	
                return p.getDest();
            }
        }
        return -1; //第一个邻接顶点不存在
    }

    public int getNextNeighbor(int v, int w) {
        //给出顶点v的邻接顶点w的下一个邻接顶点的位置,
        //若没有下一个邻接顶点, 则函数返回-1
        if (v != -1) { //顶点v存在
            Edge p = NodeTable[v].getAdj();
            while (p != null && p.getDest() != w)
                p = p.getLink();
            if (p != null && p.getLink() != null) {
                //返回下一个邻接顶点
                return p.getLink().getDest();
            }
        }
        //下一邻接顶点不存在
        return -1;
    }

    public void outputGraph(){
    	
    	for (int j = 0; j < NodeTable.length; j++){
        	System.out.print(NodeTable[j].getKey());
        	if(NodeTable[j].getAdj()!=null){
        	Edge ed = NodeTable[j].getAdj();
        
        	for(;;){
        		System.out.print("-->"+ed.getDest()+"|");
        		System.out.print("id:"+ed.getEdgeID()+"|");
        		System.out.print("cost:"+ed.getCost());
				if(ed.getLink()==null){
					System.out.println();
					break;
				}else{
					ed = ed.getLink();
					System.out.print("   "+NodeTable[j].getKey());
				}
        	}
        	}else{System.out.println();}
			}
    	
    }
}

