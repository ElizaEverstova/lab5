import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Lab5_V10 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
            DataOutputStream dout = null;
            DataInputStream din = null;
            DataOutputStream dout2 = null;
            DataInputStream din2 = null;
            File res;
            try {
                File file = new File("src.txt");
                if (!file.exists()) {
                    file.createNewFile();
                }
                dout = new DataOutputStream(new FileOutputStream(file));
                System.out.println("Input String in UTF");
                String str = sc.nextLine();
                dout.writeUTF(str);
                din = new DataInputStream(new FileInputStream(file));
                File file2 = new File("result.txt");
                file2.createNewFile();
                dout2 = new DataOutputStream(new FileOutputStream(file2));
                String stringWrite = din.readUTF();
                din2 = new DataInputStream(new FileInputStream(file2));
            } catch (IOException io) {
                io.printStackTrace();
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Ввод строки вместо числа");
            } finally {
                dout.flush();
                dout.close();
                din.close();
                dout2.flush();
                dout2.close();
                din2.close();
            }
        }
    }



