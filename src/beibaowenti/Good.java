package beibaowenti;

public class Good {
	public float w;//物品的价值
	public float c;//物品的体积
	public float p;//物品该放的数量
	public int id; //物品的编号
	
	public Good(float w,float c,float p,int id){
		this.w = w;
		this.c = c;
		this.p = p;
		this.id = id;
	}

	public Good() {
		// TODO Auto-generated constructor stub
	}
}
