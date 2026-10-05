import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder();

        try (FileReader fileReader = new FileReader("C:\\Users\\plotn\\OneDrive\\Desktop\\file.txt")) {
            int c;
            while ((c = fileReader.read()) != -1) {
                text.append((char) c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        while (text.indexOf("[") != -1) {
            int stop = text.indexOf("]");
            int start  = text.lastIndexOf("[", stop);

            int k = start - 1;
            while (k >= 0 && Character.isDigit(text.charAt(k))) {
                k--;
            }
            int count = Integer.parseInt(text.substring(k + 1, start));

            String inner = text.substring(start + 1, stop);

            StringBuilder replacement = new StringBuilder();
            for (int i = 0; i < count; i++) {
                replacement.append(inner);
            }

            text.replace(k + 1, stop + 1, replacement.toString());
        }

        try(FileWriter writer = new FileWriter("C:\\Users\\plotn\\OneDrive\\Desktop\\file.txt",false)){
            writer.write(text.toString());
            writer.flush();
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
