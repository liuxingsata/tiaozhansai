package huawei;

public class Vertex {
	public boolean isVisited;//�ڵ��Ƿ񱻷���
    private int key = 0; //��������
    private String name = null;//���������Ϣ
    private Edge adj = null; //���Լ����ڽӶ���֮���������
    
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