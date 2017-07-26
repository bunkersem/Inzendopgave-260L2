package app;

import java.io.*;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Sem on 25-Jul-17.
 */

public class Persistence {
    public static HashMap<String, String> getPersistentData() throws FileNotFoundException, URISyntaxException {
        HashMap<String, String> result = new HashMap<>();

        InputStream is = (new Main()).getClass().getResourceAsStream("/app/resources/data.dat");

        try (Scanner scanner = new Scanner(is))
        {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String name = line.split("=", 2)[0];
                String value = line.split("=", 2)[1];
                result.put(name, value);
            }
        }
        return result;
    }
}

