package huawei;

public class linkGraph {
    private int numEdges; //��ǰ����
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
        //���췽��������һ���ڽӱ�
        setNumVertices(size);
        setNumEdges(edge);
         //�������������
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
        //ɾ��һ���ڽӱ�
        for (int i = 0; i < getNumVertices(); i++) {
            Edge p = NodeTable[i].getAdj();
            while (p != null) {
                NodeTable[i].setAdj(p.getLink());
                p = NodeTable[i].getAdj();
            }
        }
    }

    public int getVertexPos(int vertx) {
        //��������vertex��ͼ�е�λ��
        for (int i = 0; i < getNumVertices(); i++)
            if (NodeTable[i].getKey() == vertx)
                return i;
        return -1;
    }

    public int getValue(int i) { //ȡ���� i ��ֵ
        return (i >= 0 && i < getNumVertices()) ? NodeTable[i].getKey() : 0;
    }

    public int getFirstNeighbor(int v) {
        //��������λ��Ϊ v �ĵ�һ���ڽӶ����λ��,
        //����Ҳ���, ��������-1
    	
        if (v != -1) {
            //����v����
            Edge p = NodeTable[v].getAdj(); //��Ӧ�������һ���߽��
            if (p != null) {
                //����, ���ص�һ���ڽӶ���
            	
                return p.getDest();
            }
        }
        return -1; //��һ���ڽӶ��㲻����
    }

    public int getNextNeighbor(int v, int w) {
        //��������v���ڽӶ���w����һ���ڽӶ����λ��,
        //��û����һ���ڽӶ���, ��������-1
        if (v != -1) { //����v����
            Edge p = NodeTable[v].getAdj();
            while (p != null && p.getDest() != w)
                p = p.getLink();
            if (p != null && p.getLink() != null) {
                //������һ���ڽӶ���
                return p.getLink().getDest();
            }
        }
        //��һ�ڽӶ��㲻����
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

