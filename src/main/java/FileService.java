import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FileService {
    public ArrayList<Member> readFile(){
        ArrayList<Member> list = new ArrayList<>();

        try {
            File file = new File("MemberList.txt");
            FileReader filereader = new FileReader(file);
            BufferedReader bufReader = new BufferedReader(filereader);

            int i = 1;
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
            System.out.println(">>>MemberList.txt 파일 로딩 완료<<<\n");

        } catch (FileNotFoundException e) {
            System.out.println(">>>MemberList.txt 파일 없음<<<\n");
        } catch (IOException e) {
            System.out.println(e);
        }

        return list;
    }

    public void saveFile(ArrayList<Member> list) {
        try {
            File file = new File("MemberList.txt");
            FileUtils.write(file, "", false);
            for (Member m: list) {
                FileUtils.write (file,m.getName() + " / " + m.getGender() + " / " + m.getMajor() + " / " + m.getStudentNum() + " / " + m.getDate() + "\n", true);
            }
        }catch (FileNotFoundException e) {
            System.out.println("data.txt 파일이 존재하지 않습니다.");
        }catch(IOException e){
            System.out.println(e);
        }
    }

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
    }*/
}
