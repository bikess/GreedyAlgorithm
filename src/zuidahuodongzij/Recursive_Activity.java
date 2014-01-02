package zuidahuodongzij;
// 此方法为利用贪心算法求解 最大活动子集问题，思想就是，每次选择最早结束的活动，作为最大活动子集的
// 其中一个活动，

public class Recursive_Activity {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//	活动已经按结束时间进行了排序。若没有排序，最少需要花费o（nlgn）的时间进行排序
		Activity my[] = new Activity[12];
//		虚拟的一个活动0
		my[0] = new Activity(0, 0, 0);
		
		my[1] = new Activity(1, 1, 4);
		my[2] = new Activity(2, 3, 5);
		my[3] = new Activity(3, 0, 6);
		my[4] = new Activity(4, 5, 7);
		my[5] = new Activity(5, 3, 9);
		my[6] = new Activity(6, 5, 9);
		my[7] = new Activity(7, 6, 10);
		my[8] = new Activity(8, 8, 11);
		my[9] = new Activity(9, 8, 12);
		my[10] = new Activity(10, 2,14);
		my[11] = new Activity(11, 12, 16);
		
		int n = my.length;
//		递归求解
		System.out.println("递归求解:");
		Recursive_Activity_Selector(my,0,n-1);
		
//		迭代求解
		System.out.println("迭代求解:");
		Greedy_Activity_Selector(my);
	}
	/**
	 * 对于已经排好序的活动，采用贪心算法求解最大活动子集，只需要o（n) 的时间复杂度
	 * @param my
	 * @param i
	 * @param n
	 */
//	算法，递归求解 最大活动子集
	private static void Recursive_Activity_Selector(Activity[] my, int i, int n) {
		// TODO Auto-generated method stub
		int m = i+1;
//		循环求解与已经得到的最大活动子集兼容，也就是该活动的开始时间要大于已经得到的最大活动子集的结束时间的活动
		while(m<=n&&my[m].begin<my[i].end){
			m=m+1;
		}
//		得到的第一个m（由于已经按结束时间排序），便是满足条件的活动
		if(m<=n){
			System.out.println(my[m].id);
			Recursive_Activity_Selector(my, m, n);//递归调用方法，求解以后的最大活动子集
		}else
			return;
	}
// 算法，迭代求解最大活动子集
	private static void Greedy_Activity_Selector(Activity [ ] my){
		int n = my.length;
		int k =1;
		System.out.println(my[k].id);
		for(int i = 2;i<n;i++){
			if(my[i].begin>my[k].end){
				System.out.println(my[i].id);
				k=i;
			}
		}
	}
}
