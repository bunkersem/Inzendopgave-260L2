package app;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.HashMap;

public class Main {

    public static HashMap<String, String> persistenData;

    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        System.out.println("Hello World!");
        persistenData = Persistence.getPersistentData();

        RekenmachineWindow rw = new RekenmachineWindow();
    }
}
