import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class Board{
    Scanner scan = new Scanner(System.in);
    
    //ボードの大きさは一定なのでstatic変数にしちゃった
    final static int WIDTH = 500;
    final static int HEIGHT = 400;
    
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