import java.io.IOException;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);

    public String printMenu() throws IOException {
        System.out.println("==========MENU==========");
        System.out.println("[1] 팀원 명단 조회하기");
        System.out.println("[2] 팀원 정보 추가하기");
        System.out.println("[3] 팀원 정보 수정하기");
        System.out.println("[4] 팀원 정보 삭제하기");
        System.out.println("[5] 팀원 학번 검색하기");
        System.out.println("[6] 팀원 명단 파일 저장하기");
        System.out.println("[0] 종료하기");
        System.out.println("========================");
        System.out.print(">>> ");

        String menu = sc.nextLine();

        return menu;
    }
}
