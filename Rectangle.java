import java.util.Scanner;

public class Rectangle{

    Scanner scan = new Scanner(System.in);

    private int width = 0;
    private int height = 0;
    private int x = 0;
    private int y = 0;
    private String color;

    //セッター
    boolean set(int w, int h, int x, int y){
	//長方形がボードに収まる場合
	if(w > 0 && h > 0 && x >= 0 && y >= 0 &&
	   w+x > 0 && h+y > 0 && w+x <= Board.WIDTH && h+y <= Board.HEIGHT){
	    this.width = w;
	    this.height = h;
	    this.x = x;
	    this.y = y;
	    return true;
	}else{
	    System.out.println("長方形がボードに収まっていません");
	    return false;
	}
    }

    //ゲッター
    int getW(){
	return this.width;
    }
    int getH(){
	return this.height;
    }
    int getX(){
	return this.x;
    }
    int getY(){
	return this.y;
    }
    
    boolean move(int x0, int y0){
	return this.set(this.width,this.height,this.x+x0,this.y+y0);
    }
    boolean scale(float mx, float my){
	return this.set(Math.round(this.width*mx),Math.round(this.height*my),
			this.x, this.y);
    }
}