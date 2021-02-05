package by.epam.task04.view;

import by.epam.task04.controller.Controller;
import by.epam.task04.model.entity.Sentence;
import lombok.extern.java.Log;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

@Log
public class Server {

    private static Socket clientSocket;
    private static ServerSocket server;
    private static BufferedReader in;
    private static ObjectOutputStream out;

    public static void main(String[] args) {
        try {
            try {
                server = new ServerSocket(4004);
                log.info("Сервер запущен!");
                clientSocket = server.accept(); // wait connecting
                Controller controller = new Controller();

                try {
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    out = new ObjectOutputStream(clientSocket.getOutputStream());
                    String word;
                    while (true) {
                        word = in.readLine();
                        if (word.equals("exit"))
                            return;
                        switch (word){
                            case "I":
                                out.writeObject(controller.getIncrementListOfSentences());
                                break;
                            case "A":
                                out.writeObject(controller.getAmountSentencesWithRepeatWords());
                                break;
                            case "C":
                                out.writeObject(controller.getChangedTextFirstAndLastWords());
                                break;
                            case "L":
                                out.writeObject(controller.getListOfWordsThatOnlyInFirstSentence());
                                break;
                            case "W":
                                out.writeObject(controller.getWordsGivenLengthInInterrogativeSentences(2));
                                break;
                        }
                        log.info("Выполнено!");
                        out.flush();
                    }
                } finally {
                    clientSocket.close();
                    in.close();
                    out.close();
                }
            } finally {
                log.info("Сервер закрыт!");
                server.close();
            }
        } catch (IOException e) {
            log.info(e.getMessage());
        }
    }
}