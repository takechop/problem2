import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

class Board{
    Scanner scan = new Scanner(System.in);
    
    //ボードの大きさは一定なのでstatic変数にしちゃった
    final static int WIDTH = 500;
    final static int HEIGHT = 400;
    //ボードの色付け
    private String color = "white";

    //長方形の作成
    void create(List<Rectangle> rectangle){
	Rectangle rect_tmp = new Rectangle();
	try{
	    while(true){
		System.out.print("width : ");
		int w = scan.nextInt();
		System.out.print("height : ");
		int h = scan.nextInt();
		System.out.print("x : ");
		int x = scan.nextInt();
		System.out.print("y : ");
		int y = scan.nextInt();
		//長方形がボードに収まり
		if(rect_tmp.set(w,h,x,y) == true){
		    //長方形に被りがない
		    if(this.rectangleCheck(rectangle,w,h,x,y) == true){
			rectangle.add(rect_tmp);
			break;
		    }
		}
	    }
	}catch(InputMismatchException e){
	    System.out.println("数値を入力してください");
	    scan.next();
	}
    }

    //長方形に被りが存在するか確認
    boolean rectangleCheck(List<Rectangle> rectangle, int w, int h, int x, int y){
	for(Rectangle rect : rectangle){
	    if(rect.getW() == w && rect.getH() == h &&
	       rect.getX() == x && rect.getY() == y){
		System.out.println("その長方形は存在しています");
		return false;
	    }else{
		;
	    }
	}
	return true;
    }
    
    //リスト内にある長方形を表示
    void displayBoard(List<Rectangle> rectangle){
	int i = 1;
	for(Rectangle rect : rectangle){
	    System.out.println(i + "個目の長方形");
	    System.out.print("width : " + rect.getW() + ", ");
	    System.out.print("height : " + rect.getH() + ", ");
	    System.out.print("x : " + rect.getX() + ", ");
	    System.out.println("y : " + rect.getY());
	    i++;
	}
    }
    //選択した長方形を削除
    void delete(List<Rectangle> rectangle){
	if(rectangle.isEmpty() == true){
	    System.out.println("長方形は作成されていません");
	}else{
	    try{
		System.out.println("削除したい長方形は何個目ですか？");
		this.displayBoard(rectangle);
		System.out.print("削除したい長方形 : ");
		int index = scan.nextInt();
		rectangle.remove(index-1);
	    }catch(IndexOutOfBoundsException e){
		System.out.println("存在していません");
	    }
	}
    }
}