import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class RectangleEditor{
    public static void main(String[] args){
	Scanner scan = new Scanner(System.in);
	Command command = new Command();
	//初期値はサイズ10
	List<Rectangle> rectangle = new ArrayList<Rectangle>();
	
	while(true){
	    try{
		//選択画面
		System.out.println("1:create");
		System.out.println("2:move");
		System.out.println("3:expand");
		System.out.println("4:shrink");
		System.out.println("5:delete");
		System.out.println("6:deleteAll");
		System.out.println("7:intersect");
		System.out.println("8:displayBoard");
		System.out.println("9:exit");
		
		int choices = scan.nextInt();
		
		//Commandクラスに選択した操作とリストを送る
		command.selected(choices, rectangle);
	    }catch(InputMismatchException e){
		System.out.println("操作番号を入力してください");
		scan.next();
	    }
	}
    }
}