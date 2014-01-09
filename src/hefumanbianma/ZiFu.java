package hefumanbianma;

public class ZiFu {
	char c;
	int p;
	String code;
	int left;
	int right;
	
	public ZiFu(char c,int p){
		this.c = c;
		this.p = p;
		this.code="";
		this.left=-1;
		this.right=-1;
	}
	public ZiFu(char c,int p,int left,int right){
		this.c = c;
		this.p = p;
		this.code="";
		this.left=left;
		this.right=right;
	}
	public String getCode(){
		return this.code;
	}
	public void setCode(String code){
		this.code = code;
	}
	public void setLeft(int left){
		this.left = left;
	}
	public void setRight(int right){
		this.right = right;
	}
}
