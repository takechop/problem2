import java.util.Scanner;

public class Rectangle{

    Scanner scan = new Scanner(System.in);
    
    Board board = new Board();

    private int width = 0;
    private int height = 0;
    private int x = 0;
    private int y = 0;
    private String color;

    //セッター
    void setElement(int w, int h, int x, int y){
	this.width = w;
	this.height = h;
	this.x = x;
	this.y = y;
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
	return board.rectangleSizeCheck(this.width,this.height,this.x+x0,this.y+y0);
    }
    boolean scale(float mx, float my){
	return board.rectangleSizeCheck(Math.round(this.width*mx),Math.round(this.height*my),this.x,this.y);
    }
}