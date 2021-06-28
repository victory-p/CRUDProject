import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Management {
    BufferedReader br;
    private List<Member> list;

    public Management() {
        this.list = new ArrayList<>();
    }

    public void printMenu() {
        System.out.println("==========MENU==========");
        System.out.println("[1] 팀원 명단 조회하기");
        System.out.println("[2] 팀원 정보 추가하기");
        System.out.println("[3] 팀원 정보 수정하기");
        System.out.println("[4] 팀원 정보 삭제하기");
        System.out.println("[5] 팀원 학번 검색하기");
        System.out.println("[6] 종료하기");
        System.out.println("========================");
    }

    public boolean selectMenu(int menu) {
        switch (menu) {
            case 1:
                readInfo();
                break;

            case 2:
                createInfo();
                break;

            case 3:
                updateInfo();
                break;

            case 4:
                deleteInfo();
                break;

            case 5:
                searchStudentNum();
                break;

            case 6:
                System.out.println(">>>종료<<<");
                return false;

            default:
                System.out.println(">>>잘못된 접근<<<");
        }
        return true;
    }

    private void readInfo() {
        if (this.list.size() == 0) {
            System.out.println(">>>조회할 데이터 없음<<<\n");
            return;
        }

        System.out.println("\nNo \t Name \t Gender \t Major \t\t Student Num \t Date");
        System.out.println("---------------------------------------------------------------");
        for (Member m : this.list) {
            System.out.println(m.toString());
        }
        System.out.println();
    }

    private void createInfo() {
        Member m = new Member();

        try {
            System.out.print(("팀원 이름 : "));
            br = new BufferedReader(new InputStreamReader(System.in));
            m.setName(br.readLine());
            System.out.print("성별 : ");
            m.setGender(br.readLine());
            System.out.print("학부 : ");
            m.setMajor(br.readLine());
            System.out.print("학번 : ");
            m.setStudentNum(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        m.setNum(this.list.size() + 1);
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String regDate = date.format(formatter);
        m.setDate(regDate);

        this.list.add(m);

        System.out.println("\n>>>추가 완료<<<\n");
    }

    private void updateInfo() {
        if (this.list.size() == 0) {
            System.out.println(">>>수정할 데이터 없음<<<\n");
            return;
        }

        try {
            System.out.println("\nNo \t Name \t Gender \t Major \t\t Student Num \t Date");
            System.out.println("---------------------------------------------------------------");
            for (Member m : this.list) {
                System.out.println(m.toString());
            }
            System.out.println();

            System.out.print(">>> 수정할 팀원 번호 : ");
            br = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine());
            if (this.list.size() >= num) {
                System.out.print(("팀원 이름 : "));
                this.list.get(num - 1).setName(br.readLine());
                System.out.print("성별 : ");
                this.list.get(num - 1).setGender(br.readLine());
                System.out.print("학부 : ");
                this.list.get(num - 1).setMajor(br.readLine());
                System.out.print("학번 : ");
                this.list.get(num - 1).setStudentNum(br.readLine());
                LocalDate date = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String regDate = date.format(formatter);
                this.list.get(num - 1).setDate(regDate);

                System.out.println("\n>>>수정 완료<<<\n");
            } else {
                updateInfo();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteInfo() {
        if (this.list.size() == 0) {
            System.out.println(">>>삭제할 데이터 없음<<<\n");
            return;
        }

        try {
            System.out.println("\nNo \t Name \t Gender \t Major \t\t Student Num \t Date");
            System.out.println("---------------------------------------------------------------");
            for (Member m : this.list) {
                System.out.println(m.toString());
            }
            System.out.println();

            System.out.print(">>> 삭제할 팀원 번호 : ");
            br = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine());

            if (this.list.size() >= num) {
                this.list.remove(num-1);
                for (int i = 0; i < list.size(); i++) {
                    this.list.get(i).setNum(i+1);
                }

                System.out.println(">>> 삭제 완료");
            } else {
                deleteInfo();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchStudentNum() {
        if (this.list.size() == 0) {
            System.out.println(">>>검색할 데이터 없음<<<\n");
            return;
        }

        System.out.print(">>> 검색할 학번(8자리) 입력 : ");
        br = new BufferedReader(new InputStreamReader(System.in));

        try{
            String snum = br.readLine();
            boolean check = false;

            for(Member m: list){
                if(m.getStudentNum().equals(snum)){
                    if(!check){
                        System.out.println("\nNo \t Name \t Gender \t Major \t\t Student Num \t Date");
                        System.out.println("---------------------------------------------------------------");
                        check = true;
                    }
                    System.out.println(m.toString());
                }
            }
            System.out.println();

            if(!check){
                System.out.println(">>> 검색 결과 없음<<<\n");
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
