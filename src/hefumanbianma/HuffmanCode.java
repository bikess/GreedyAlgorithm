package hefumanbianma;

import java.util.Comparator;
import java.util.PriorityQueue;

// 此算法是对字符，利用贪心算法来进行编码，也就是赫夫曼编码，以实现最优编码
public class HuffmanCode {

	private static int num = 6;//需要编码的字符数
	/**
	 * @param args
	 */
//	初始化哈弗曼树
	private static ZiFu [] hutree = new ZiFu[2*num-1];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		定义字符类，用来存储字符与字符出现的频率
		ZiFu [] m = new ZiFu[num];
		m[0] = new ZiFu('a', 45);
		m[1] = new ZiFu('b', 13);
		m[2] = new ZiFu('c', 12);
		m[3] = new ZiFu('d', 16);
		m[4] = new ZiFu('e', 9);
		m[5] = new ZiFu('f', 5);
		
//		对字符对象，按照频率出现的高低，进行排序，或者建立堆，每次从堆中取值
		PriorityQueue<ZiFu> p = new PriorityQueue<>(num, new Comparator<ZiFu>(){
//			建立小顶推，也就是处于顶堆的是，出现频率最小的字符。
			@Override
			public int compare(ZiFu o1, ZiFu o2) {
				// TODO Auto-generated method stub
//				这o1>o2返回1，表明队列中的值按照从大到小排列。
				if(o1.p>o2.p){
					return 1;
				}
				else
					return -1;
			}
		});
//		初始化小顶堆
		for(int i =0;i<num;i++){
			p.add(m[i]);
		}
		
//		利用贪心算法对字符进行编码
		HuffmanGreedy(p);
		
//		输出编码后的节点
		for(int i =hutree.length-1;i>=0;i--){
			if(hutree[i].c!='-')
			{
				System.out.println("字符为："+hutree[i].c+"出现频率为:"+hutree[i].p+"编码为："+hutree[i].code);
			}
		}
////		 测试小顶堆的代码
//		for(int i = 0;i<num;i++){
//			ZiFu x = p.poll();
//			if(i==2){
//				ZiFu add = new ZiFu('T',3);
//				p.add(add);
//			}
//			System.out.println(x.c+"\t"+x.p);
//		}
	}
	private static void HuffmanGreedy(PriorityQueue<ZiFu> p) {
		// TODO Auto-generated method stub

		int n = 0;
		while(!p.isEmpty()){
//			队列中至少存在2个节点
			if(p.size()!=1){
				ZiFu left = p.poll();
				ZiFu right = p.poll();
//				分别对left，right 进行重新编码
				int lp =-1,rp=-1;
				int isleaf = HuffmanReCode(left,0);	
//				表示是叶节点
				if(isleaf==1){
					hutree[n] = left;
					lp = n;
					n++;
				}else{
					hutree[n] = left;
					lp = n;
					n++;
				}
				isleaf = HuffmanReCode(right, 1);
				if(isleaf==1){
					hutree[n] = right;
					rp = n;
					n++;
				}else{
					hutree[n] = right;
					rp = n;
					n++;
				}
//				重新构造节点，加入到堆中
				ZiFu noleaf = new ZiFu('-', left.p+right.p, lp, rp);
				p.add(noleaf);
			}else{
				ZiFu node =  p.poll();		
				hutree[n] = node;
				n++;
			}
		}
	}
	private static int HuffmanReCode(ZiFu node,int place) {
		
		if(node.left==-1&&node.right==-1){
			node.code = Integer.toString(place)+node.code;
//			表示此节点是一个叶节点
			return 1;
		}else{
			if(node.left==-1&&node.right!=-1){
				HuffmanReCode(hutree[node.right], place);
			}
			if(node.left!=-1&&node.right==-1){
				HuffmanReCode(hutree[node.left], place);
			}
			if(node.left!=-1&&node.right!=-1){
				HuffmanReCode(hutree[node.right], place);
				HuffmanReCode(hutree[node.left], place);
			}
			return 0;
		}
	}

}















