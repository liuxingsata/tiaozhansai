package huawei;

public class Main {

	public static void main(String[] args){
		long a=System.currentTimeMillis();
		String filename = "E:\\QQPCmgr\\Desktop\\HUAWEI Code Craft 2016 初赛赛题包\\test-case\\case0\\topo.csv";
		try {
			readFile rf = new readFile(filename);
			linkGraph lg = new linkGraph(rf.Pointnum,rf.Edgenum,rf.link);
			lg.outputGraph();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("\r执行耗时 : "+(System.currentTimeMillis()-a)+" ms ");

	}

	

}
