import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Management m = new Management();

        Scanner sc = new Scanner(System.in);

        while(true){
            m.printMenu();
            System.out.print(">>> ");
            int menu = sc.nextInt();

            if(m.selectMenu(menu) == false) break;
        }
    }
}