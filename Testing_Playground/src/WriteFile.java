import java.io.*;
public class WriteFile {
    public static void main(String[] args) throws FileNotFoundException{
    File numbers = new File("numbers.txt");
    PrintWriter write = new PrintWriter(numbers);
    for (int i = 1; i < 50; i++){
        write.println(i);
        }
    write.close();
    }
}