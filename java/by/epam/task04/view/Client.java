package by.epam.task04.view;

import by.epam.task04.controller.Controller;
import by.epam.task04.model.entity.Sentence;
import lombok.extern.java.Log;

import java.io.*;
import java.net.Socket;
import java.util.List;

@Log
public class Client {

    private static Socket clientSocket;
    private static BufferedReader reader;
    //private static BufferedReader in;
    private static ObjectInputStream in;
    private static BufferedWriter out;

    public static void main(String[] args) {
        try {
            try {
                clientSocket = new Socket("localhost", 4004);
                reader = new BufferedReader(new InputStreamReader(System.in));
                in = new ObjectInputStream(clientSocket.getInputStream());
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));


                while (true) {
                    String word = reader.readLine();
                    if(word.equals("exit")){
                        out.write(word + "\n");
                        out.flush();
                        return;
                    }
                    out.write(word + "\n");
                    out.flush();
                    Object sentences = in.readObject();
                    System.out.println(sentences);
                    //log.info(serverWord);
                }
            } finally {
                log.info("Клиент был закрыт...");
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            log.info(e.getMessage());
        }

    }
}
