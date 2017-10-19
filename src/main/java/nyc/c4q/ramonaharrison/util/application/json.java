package nyc.c4q.ramonaharrison.util.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class json {
    public static String findWebHook() {

        String WebHook = "";

        File file = new File("json");
        System.out.println(file.getAbsolutePath());

        try {

            Scanner scanner = new Scanner(file);

            WebHook = scanner.next();

            scanner.close();

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        }

        return WebHook;
    }
}
