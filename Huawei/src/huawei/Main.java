package huawei;

public class Main {

	public static void main(String[] args){
		long a=System.currentTimeMillis();
		String filename = "E:\\QQPCmgr\\Desktop\\HUAWEI Code Craft 2016 ���������\\test-case\\case0\\topo.csv";
		try {
			readFile rf = new readFile(filename);
			linkGraph lg = new linkGraph(rf.Pointnum,rf.Edgenum,rf.link);
			lg.outputGraph();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("\rִ�к�ʱ : "+(System.currentTimeMillis()-a)+" ms ");

	}

	

}
