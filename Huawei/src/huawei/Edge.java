package huawei;


class Edge {

    private int dest = 0;//邻接顶点
    private int cost = 0;//权值
    private int EdgeID = 0;//边信息
    private Edge link = null;//与这个顶点相关的所有边在邻接表中
    //的下一条边
   
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