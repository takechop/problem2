import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;

class Command{
    Scanner scan = new Scanner(System.in);
    Board board = new Board();
    int index = 0;
    
    void selected(int operation, List<Rectangle> rectangle){
	try{
	    switch(operation){
	    case 1:
		//create
		board.create(rectangle);
		break;
	    
	    case 2:
		//move
	    
		Rectangle rect_move = this.selectRectangle(rectangle);
		System.out.print("移動方向x : ");
		int x0 = scan.nextInt();
		System.out.print("移動方向y : ");
		int y0 = scan.nextInt();
		//フィールドを動かす
		if(rect_move.move(x0,y0)){
		    this.replaceRectangle(rectangle, rect_move);
		}
	  
	
		break;
	    case 3:
	    case 4:
		//expand/shrink
		Rectangle rect_scale = this.selectRectangle(rectangle);
		System.out.print("縮尺x : ");
		float mx = scan.nextFloat();
		System.out.print("縮尺y : ");
		float my = scan.nextFloat();
		//拡大/縮小
		if(rect_scale.scale(mx,my)){
		    this.replaceRectangle(rectangle, rect_scale);
		}
		
		break;
	    case 5:
		board.delete(rectangle);
		break;
	    case 6:
		board.deleteAll(rectangle);
		break;
	    case 7:
		System.out.println("実装してないよ、ゴメンネ");
		break;
	    case 8:
		board.displayBoard(rectangle);
		break;
	    case 9:
		System.out.println("終了します");
		System.exit(0);
	    default:
		System.out.println("1~9から選んでください");
		break;
	    }
	}catch(InputMismatchException e){
	    scan.next();
	    System.out.println("数値を入力してください");
	}catch(IndexOutOfBoundsException e){
	    System.out.println("存在していません");
	}
    }
	

    //処理をする長方形を選ぶ
    Rectangle selectRectangle(List<Rectangle> rectangle){
	Rectangle rect_before = new Rectangle();
	System.out.println("操作したい長方形を選んでください");
	board.displayBoard(rectangle);
	System.out.print("操作したい長方形 : ");
	index = scan.nextInt();
	rect_before.setElement(rectangle.get(index-1).getW(), rectangle.get(index-1).getH(),rectangle.get(index-1).getX(), rectangle.get(index-1).getY());
	return rect_before;
    }
    

    //処理後の長方形の置き換え
    void replaceRectangle(List<Rectangle> rectangle, Rectangle rect_after){
	//移動後の長方形がかぶってないかチェック
	if(board.rectangleMatchCheck(rectangle, rect_after.getW(), rect_after.getH(),rect_after.getX(), rect_after.getY()) == true){
	    rectangle.set(index-1, rect_after);
	}
    }
}