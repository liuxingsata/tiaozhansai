package huawei;


class Edge {

    private int dest = 0;//�ڽӶ���
    private int cost = 0;//Ȩֵ
    private int EdgeID = 0;//����Ϣ
    private Edge link = null;//�����������ص����б����ڽӱ���
    //����һ����
   
    public int getDest() {
        return dest;
    }
    public void setDest(int dest) {
        this.dest = dest;
    }
    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
    public Edge getLink() {
        return link;
    }
    public void setLink(Edge link) {
        this.link = link;
    }
	public int getEdgeID() {
		return EdgeID;
	}
	public void setEdgeID(int edgeID) {
		EdgeID = edgeID;
	}
}