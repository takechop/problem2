import java.util.Scanner;

public class Rectangle{

    Scanner scan = new Scanner(System.in);

    private int width = 0;
    private int height = 0;
    private int x = 0;
    private int y = 0;

    //セッター
    void create(int w, int h, int x, int y){
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
}