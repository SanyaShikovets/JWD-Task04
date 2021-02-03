package by.epam.task04.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    private final String PATH = "src\\main\\resources\\text.txt";

    public String read(){

        String data = "";
        File file = new File(PATH);

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        BufferedReader reader = new BufferedReader(fileReader);

        try {
            String line = reader.readLine();
            while (line != null) {
                if(!line.isEmpty())
                    data += line + " ";
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }
}
