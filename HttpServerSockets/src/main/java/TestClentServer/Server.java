package TestClentServer;

import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] ar) {
        int port = 1313; // Порт, который будет слушать сервер (от 1025 до 65535)
        try {
            ServerSocket ss = new ServerSocket(port); // создаем сокет сервера и привязываем его к вышеуказанному порту
            System.out.println("Ждем подключения клиента.");

            Socket socket = ss.accept(); // заставляем сервер ждать подключений и выводим сообщение когда кто-то связался с сервером
            System.out.println("Клиент подключен!");
            System.out.println("_______________________________________________________________________________________________________________________");
            System.out.println();

            InputStream sin = socket.getInputStream();       // Создаем входной поток сокета
            OutputStream sout = socket.getOutputStream();    // Создаем выходной поток сокета

            DataInputStream in = new DataInputStream(sin);       // Конвертируем входной поток в другой тип, дабы легче обработать текст
            DataOutputStream out = new DataOutputStream(sout);        // Конвертируем входной поток в другой тип, дабы легче обработать текст

            String line = null;  // Объявили строку, в которую будем записывать строку клиента

            while (true) {
                line = in.readUTF(); // ожидаем пока клиент пришлет строку текста.
                System.out.println("Оооо клиент прислал мне" + "    `" + line + "`");

                if (line.equals("") || line.equals("Port") || line.equals("Ip") || line.equals("Message")) {

                    switch (line) {
                        case "Port":
                            String Port = "Мой порт 1313";
                            System.out.println("Оооо это же запрос! Надо обязательно ему ответить!");
                            out.writeUTF(Port);
                            System.out.println("Ждем след. строку текста");
                            System.out.println("_______________________________________________________________________________________________________________________");
                            System.out.println();
                            break;
                        case "Ip":
                            String Ip = "Да чувак, у меня тоже порт 127.0.0.1";
                            System.out.println("Оооо это же запрос! Надо обязательно ему ответить!");
                            out.writeUTF(Ip);
                            System.out.println("Ждем след. строку текста");
                            System.out.println("_______________________________________________________________________________________________________________________");
                            System.out.println();
                            break;
                        case "Message":
                            String Message = "Приветствую тебя, я твой сервер";
                            System.out.println("Оооо это же запрос! Надо обязательно ему ответить!");
                            out.writeUTF(Message);
                            System.out.println("Ждем след. строку текста");
                            System.out.println("_______________________________________________________________________________________________________________________");
                            System.out.println();
                            break;
                        case "":
                            String lol1 = "Забирай назад свою пустую строку!";
                            System.out.println("Оооо это же запрос! Надо обязательно ему ответить!");
                            out.writeUTF(lol1);
                            System.out.println("Ждем след. строку текста");
                            System.out.println("_______________________________________________________________________________________________________________________");
                            System.out.println();
                        case " ":
                            String lol2 = "Забирай назад свой пробел!";
                            System.out.println("Оооо это же запрос! Надо обязательно ему ответить!");
                            out.writeUTF(lol2);
                            System.out.println("Ждем след. строку текста");
                            System.out.println("_______________________________________________________________________________________________________________________");
                            System.out.println();
                        case "Ты еще со мной??":
                            String lol3 = "Да, я тебя внимательно слушаю!";
                            System.out.println("Оооо это же запрос! Надо обязательно ему ответить!");
                            out.writeUTF(lol3);
                            System.out.println("Ждем след. строку текста");
                            System.out.println("_______________________________________________________________________________________________________________________");
                            System.out.println();
                    }
                } else {


                    System.out.println("Я пошлю ему это назад :)");
                    out.writeUTF(line); // отсылаем клиенту обратно ту самую строку текста.
                    out.flush(); // заставляем поток закончить передачу данных.
                    System.out.println("Ждем след. строку текста");
                    System.out.println("_______________________________________________________________________________________________________________________");
                    System.out.println();
                }
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}