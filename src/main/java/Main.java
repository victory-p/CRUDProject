import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayList<Member> list;

        Menu m = new Menu();
        Management manage = new Management();
        SearchService searchService = new SearchService();
        FileService fileService = new FileService();

        list = fileService.readFile();

        while(true){
            try {
                String select = m.printMenu();

                switch (select){
                    case "1":
                        manage.readInfo(list);
                        break;

                    case "2":
                        list.add(manage.createInfo(list));
                        System.out.println(">>>추가 완료<<<\n");
                        break;

                    case "3":
                        manage.readInfo(list);
                        manage.updateInfo(list);
                        System.out.println(">>>수정 완료<<<\n");
                        break;

                    case "4":
                        manage.readInfo(list);
                        manage.deleteInfo(list);
                        System.out.println(">>>삭제 완료<<<\n");
                        break;

                    case "5":
                        searchService.searchStudentNum(list);
                        break;

                    case "6":
                        fileService.saveFile(list);
                        System.out.println(">>>저장 완료<<<\n");
                        break;

                    case "0":
                        System.out.println(">>>종료<<<\n");
                        return;

                    default:
                        System.out.println(">>>잘못된 접근<<<\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            /*m.printMenu();
            System.out.print(">>> ");
            int menu = sc.nextInt();

            if(m.selectMenu(menu) == false) break;*/
        }
    }

    public static boolean valid(ArrayList<Member> list, int num) {
        if (list.size() <= num || num == -1) {
            System.out.println(">>>잘못된 접근<<<\n");
            return false;
        }
        return true;
    }
}