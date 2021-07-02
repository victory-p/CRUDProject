import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Management {
    BufferedReader br;

    FileService fileService = new FileService();

    public void readInfo(ArrayList<Member> list){
        if (list.size() == 0) {
            System.out.println(">>>조회할 데이터 없음<<<\n");
            return;
        }

        System.out.println("\nNo \t Name \t Gender \t Major \t\t Student Num \t Date");
        System.out.println("---------------------------------------------------------------");
        for (Member m : list) {
            System.out.println(m.toString());
        }
        System.out.println();
    }

    public Member createInfo(ArrayList<Member> list) throws IOException {
        int num;
        String name;
        String gender;
        String major;
        String studentnum;
        String regDate;

        num = list.size() + 1;

        System.out.print(("팀원 이름 : "));
        br = new BufferedReader(new InputStreamReader(System.in));
        name = br.readLine();

        System.out.print("성별 : ");
        gender = br.readLine();

        System.out.print("학부 : ");
        major = br.readLine();

        System.out.print("학번 : ");
        studentnum = br.readLine();

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        regDate = date.format(formatter);

        Member m = new Member(num, name, gender, major, studentnum, regDate);

        return m;
    }

    public void updateInfo(ArrayList<Member> list) {
        if (list.size() == 0) {
            System.out.println(">>>수정할 데이터 없음<<<\n");
            return;
        }

        try {
            System.out.print(">>> 수정할 팀원 번호 : ");
            br = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine());

            if(Management.valid(list, num)) {
                System.out.print(("팀원 이름 : "));
                list.get(num-1).setName(br.readLine());

                System.out.print("성별 : ");
                list.get(num-1).setGender(br.readLine());

                System.out.print("학부 : ");
                list.get(num-1).setMajor(br.readLine());

                System.out.print("학번 : ");
                list.get(num-1).setStudentNum(br.readLine());

                LocalDate date = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String regDate = date.format(formatter);
                list.get(num-1).setDate(regDate);
            } else {
                updateInfo(list);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
/*
    void updateInfo() {
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
 */

    public void deleteInfo(ArrayList<Member> list) {
        if (list.size() == 0) {
            System.out.println(">>>삭제할 데이터 없음<<<\n");
            return;
        }

        try {
            System.out.print(">>> 삭제할 팀원 번호 : ");
            br = new BufferedReader(new InputStreamReader(System.in));

            int num = Integer.parseInt(br.readLine());
            if(Management.valid(list, num)) {
                list.remove(num-1);
                for(int i=0; i<list.size(); i++){
                    list.get(i).setNum(i+1);
                }
            }else {
                deleteInfo(list);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean valid(ArrayList<Member> list, int num) {
        if (list.size() <= (num-1) || num == -1) {
            System.out.println("없는 번호 입니다.");
            return false;
        }
        return true;
    }


        /*try {
            String snum = br.readLine();
            boolean check = false;

            for (Member m : list) {
                if (m.getStudentNum().equals(snum)) {
                    if (!check) {
                        System.out.println("\nNo \t Name \t Gender \t Major \t\t Student Num \t Date");
                        System.out.println("---------------------------------------------------------------");
                        check = true;
                    }
                    System.out.println(m.toString());
                }
            }
            System.out.println();

            if (!check) {
                System.out.println(">>> 검색 결과 없음<<<\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }*/

    /*void saveFile(List<Member> list) throws IOException {
        String path = Paths.get(".").toAbsolutePath().toString();
        String filename = path + "/MemberList.txt";


        File myfile = new File(filename);
        FileUtils.touch(myfile);

        try {
            FileWriter fw = new FileWriter(myfile);
            PrintWriter pw = new PrintWriter(new FileWriter(filename));

            for (Member m : this.list) {
                pw.print(m.getName() + " / " + m.getGender() + " / " + m.getMajor() + " / " + m.getStudentNum() + " / " + m.getDate() + "\n");
            }
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(">>>파일 저장 완료<<<\n");
    }

    public ArrayList<Member> readFile() {
        ArrayList<Member> list = new ArrayList<>();

        try {
            File file = new File("MemberList.txt");
            FileReader filereader = null;
            try {
                filereader = new FileReader(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            BufferedReader bufReader = new BufferedReader(filereader);

            int i = 0;
            String line = "";
            while ((line = bufReader.readLine()) != null) {

                StringTokenizer st = new StringTokenizer(line, "/");

                String name = st.nextToken().trim();
                String gender = st.nextToken().trim();
                String major = st.nextToken().trim();
                String snum = st.nextToken().trim();
                String date = st.nextToken().trim();

                list.add(new Member(i, name, gender, major, snum, date));
                i++;
            }
            bufReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("data.txt 파일이 존재하지 않습니다.");
        } catch (IOException e) {
            System.out.println(e);
        }

        return list;
    }*/

}
