package huawei;

public class Vertex {
	public boolean isVisited;//节点是否被访问
    private int key = 0; //顶点索引
    private String name = null;//顶点相关信息
    private Edge adj = null; //和自己的邻接顶点之间的那条边
    
    public int getKey() {
        return key;
    }
    public void setKey(int key) {
        this.key = key;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Edge getAdj() {
        return adj;
    }
    public void setAdj(Edge adj) {
        this.adj = adj;
    }
}