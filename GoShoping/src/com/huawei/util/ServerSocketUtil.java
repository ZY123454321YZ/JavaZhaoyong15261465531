package com.huawei.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerSocketUtil {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(5200);
		Socket socket = serverSocket.accept();
		BufferedReader bufferedReader =
				new BufferedReader(new InputStreamReader(System.in));
		Scanner scanner = new Scanner(System.in);
		String line =scanner.nextLine();
		PrintWriter pWriter = new PrintWriter(socket.getOutputStream());
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		line = bufferedReader.readLine();
		while(true){
			pWriter.println(line);
			System.out.println(line);
			pWriter.flush();
		}
			
	}

}
