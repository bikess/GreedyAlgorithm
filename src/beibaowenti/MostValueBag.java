package beibaowenti;

// 此算法是利用贪心算法来解决 0,1背包问题,且这里每个物品可以部分装包，此时可以采取某种贪心策略，
// 选择某种效益最高的物品进行装包。
public class MostValueBag {

	/**
	 * @param args
	 */
	private static int N = 4;//物品的数量
	private static float V = 9;//背包的体积
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		假如有容量为９(C=9)的背包，要装入４(n=4)种体积为２，３，４和５的物品，
//		它们的价值分别是３，４，５和７
		
//		初始化物品数组
		Good [] goods = new Good[N+1];
		goods[0] = new Good(0, 0, 0, 0);
		goods[1] = new Good(3, 2, 0, 1);
		goods[2] = new Good(4, 3, 0, 2);
		goods[3] = new Good(5, 4, 0, 3);
		goods[4] = new Good(7, 5, 0, 4);
		
//		将物品按照物品效益比值进行排序
		for(int i = 1;i<=N;i++){
			goods[i].w = goods[i].w/goods[i].c;
		}
		sortGoods(goods);
		
//		按照效益比进行装包操作
		float MaxValue = putPackage(goods);
		System.out.println("利用贪心算法求出的最大的价值为："+MaxValue);
		for(int i =1;i<=N;i++){
			if(goods[i].p!=0){
				System.out.println("物品"+goods[i].id+"的装包量为："+goods[i].p);
			}else{
				break;
			}
		}
	}
	private static float putPackage(Good[] goods) {
		// TODO Auto-generated method stub
		float MaxValue = 0;
		float j = V;
		int i =1;
		while(j>0&&i<=N){
			if(goods[i].c<=j){
//				若当前最大效益比的物品的容量小于当前背包的剩余容量
				goods[i].p = 1;
				j = j-goods[i].c;
				MaxValue = MaxValue + goods[i].w*goods[i].p*goods[i].c;
			}else{
				goods[i].p = (float)j/goods[i].c;
				j=0;
				MaxValue = MaxValue + goods[i].w*goods[i].p*goods[i].c;
			}
			i++;
		}
		return MaxValue;
	}
	private static void sortGoods(Good[] goods) {
		// TODO Auto-generated method stub
//		采取插入排序方法，将物品按照效益比从大到小的顺序进行排列
		for(int i=1;i<=N;i++){
			goods[0]=goods[i];
			for(int j=i+1;j<=N;j++){
				if(goods[j].w>goods[0].w){
					Good temp = new Good();
					temp = goods[j];
					goods[j] = goods[0];
					goods[0] = temp;
				}
			}
			goods[i]=goods[0];
			System.out.println(goods[i].id+"\t"+goods[i].w);
		}
	}

}
