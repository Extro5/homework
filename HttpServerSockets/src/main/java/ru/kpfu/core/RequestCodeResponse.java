package ru.kpfu.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;


public class RequestCodeResponse {
    public RequestCodeResponse() throws IOException, InterruptedException {

        Socket socket = new Socket("localhost", 8080);  // указываем хост и порт (куда и отправится наш запрос)

        OutputStream os = socket.getOutputStream(); // создаем output поток "os"
        // os.write("GET / HTTP\\1.1\r\nHOST:study.istamendil.info.ru\r\n\r\n".getBytes());  // готовим запрос
        os.write("Hi!".getBytes());  // готовим запрос
        os.flush();  // отправили
        os.wait(1000);

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));  // считываем наш ответ
        while (true) {
            String s = br.readLine();
            if (s == null || s.trim().length() == 0) {
                break;
            }
            System.out.println(s);  // выводим ответ
        }
        os.close();  // закрываем сокет
    }

    public static void main(String[] args) throws Exception {
        new RequestCodeResponse();
    }
}