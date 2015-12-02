package TestClentServer;

import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] ar) {
        int serverPort = 1313; // ПО какому порту стоит Сервер?
        String address = "127.0.0.1"; // Наш ip address с которого отправляется зарпос

        try {
            InetAddress ipAddress = InetAddress.getByName(address); // создаем объект который отображает вышеописанный IP-адрес.
            System.out.println("Привт, попытаюсь подключиться к серверу " + address + " с портом " + serverPort);
            Socket socket = new Socket(ipAddress, serverPort); // создаем сокет используя IP-адрес и порт сервера.
            System.out.println("Да! У меня получилось!");

            InputStream sin = socket.getInputStream();     // Создаем входной поток сокета
            OutputStream sout = socket.getOutputStream();      // Создаем выходной поток сокета

            InputStream sin1 = socket.getInputStream();
            OutputStream sout1 = socket.getOutputStream();

            DataInputStream in1 = new DataInputStream(sin1);
            DataOutputStream out1 = new DataOutputStream(sout1);

            int i = 0;


            DataInputStream in = new DataInputStream(sin);  // Конвертируем входной поток в другой тип, дабы легче обработать текст
            DataOutputStream out = new DataOutputStream(sout);  // Конвертируем входной поток в другой тип, дабы легче обработать текст

            // Создаем поток для чтения с клавиатуры.
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            System.out.println("Введите что-нибудь и отправьте это на сервер");
            System.out.println("_______________________________________________________________________________________________________________________");
            System.out.println();

            while (true) {

                line = keyboard.readLine(); // Ждём ввода.
                System.out.println("Отправляем строку на сервер");
                out.writeUTF(line); // отсылаем введенную строку текста серверу.
                out.flush(); // заставляем поток закончить передачу данных.
                line = in.readUTF(); // ждем пока сервер отошлет строку текста.
                System.out.println("Ответ сервера: " + line);
                System.out.println("Хммм, может напишем что-нибудь ещё?:)");
                System.out.println("_____________________________________________________________________________________________________________");
                System.out.println();
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}