package by.epam.task04.view;

import lombok.extern.java.Log;

import java.io.*;
import java.net.Socket;

@Log
public class Client {

    private static Socket clientSocket; //сокет для общения
    private static BufferedReader reader; // нам нужен ридер читающий с консоли, иначе как
    // мы узнаем что хочет сказать клиент?
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет

    public static void main(String[] args) {
        try {
            try {
                // адрес - локальный хост, порт - 4004, такой же как у сервера
                clientSocket = new Socket("localhost", 4004); // этой строкой мы запрашиваем
                //  у сервера доступ на соединение
                reader = new BufferedReader(new InputStreamReader(System.in));
                // читать соообщения с сервера
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                // писать туда же
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                while (true) {
                    log.info("Вы что-то хотели сказать? Введите это здесь:");
                    // если соединение произошло и потоки успешно созданы - мы можем
                    //  работать дальше и предложить клиенту что то ввести
                    // если нет - вылетит исключение
                    String word = reader.readLine(); // ждём пока клиент что-нибудь
                    if(word.equals("exit")){
                        out.write(word + "\n"); // отправляем сообщение на сервер
                        out.flush();
                        return;
                    }
                    // не напишет в консоль
                    out.write(word + "\n"); // отправляем сообщение на сервер
                    out.flush();
                    String serverWord = in.readLine(); // ждём, что скажет сервер
                    log.info(serverWord); // получив - выводим на экран
                }
            } finally { // в любом случае необходимо закрыть сокет и потоки
                log.info("Клиент был закрыт...");
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            log.info(e.getMessage());
        }

    }
}
