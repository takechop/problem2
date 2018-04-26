import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;

class Command{
    Scanner scan = new Scanner(System.in);
    Board board = new Board();
    
    void selected(int operation, List<Rectangle> rectangle){
	switch(operation){
	case 1:
	    //create
	    Rectangle rect_tmp = new Rectangle();
	    int flag = 0;
	    try{
		System.out.print("width : ");
		int w = scan.nextInt();
		System.out.print("height : ");
		int h = scan.nextInt();
		System.out.print("x : ");
		int x = scan.nextInt();
		System.out.print("y : ");
		int y = scan.nextInt();
		rect_tmp.create(w,h,x,y);

		rectangle.add(rect_tmp);
	    }catch(InputMismatchException e){
		System.out.println("数値を入力してください");
		scan.next();
	    }
	    break;
	case 5:
	    board.delete(rectangle);
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
    }
}