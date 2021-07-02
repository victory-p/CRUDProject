import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SearchService {
    BufferedReader br;

    public void searchStudentNum(ArrayList<Member> list) throws IOException {

        System.out.print(">>> 검색할 학번(8자리) 입력 : ");
        br = new BufferedReader(new InputStreamReader(System.in));
        String snum = br.readLine();

        System.out.println("\nNo \t Name \t Gender \t Major \t\t Student Num \t Date");
        System.out.println("---------------------------------------------------------------");

        for (Member m : list) {
            if (m.getStudentNum().equals(snum)) {
                System.out.println(m.toString());
            }
        }
        System.out.println();
    }
}
