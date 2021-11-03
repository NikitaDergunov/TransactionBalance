import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class BalanceMain {
     private static Map<String,Money> monies = new ConcurrentHashMap<>();
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("Use file? Leave empty if not:");
            String line = scanner.nextLine();
            //if user entered a path
            if(!line.equals("")){
                try {
                    //create input thread for file read
                Input fileInput = new Input(new FileInputStream(line),monies);
                fileInput.start();
                //wait for completion
                fileInput.join();
                } catch (FileNotFoundException | InterruptedException e) {
                    System.out.println("error in reading file");
                }
            }
            //create display thread
            Thread t = new MoneyThread(monies);
            t.start();
            //create console input thread
            Input consoleIn = new Input(System.in,monies);
            consoleIn.start();
            //wait for "quit"
            consoleIn.join();
            //stop display thread
            t.interrupt();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
