import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.*;

public class ChatServer extends JFrame {
	private SpellManager spellManager = null;
	private JTextArea log = new JTextArea();
	private Vector<String> wordList = new Vector<String>();
	public ChatServer() {
		super("영어 스펠 체크 서버");
		setSize(250, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 종료 버튼(X)을 클릭하면 프로그램 종료
		Container c = getContentPane();
		c.add(new JLabel("영어 스펠 체크 서버입니다"));
		c.add(new JScrollPane(log), BorderLayout.CENTER);
		setVisible(true);
		
		spellManager = new SpellManager("C:\\Users\\syesh\\eclipse-workspace\\SpellCheck\\words.txt");
		if(spellManager.isFileRead()) { // 단어 파일이 읽혀졌을 경우 서비스 시작
			log.setText("words.txt 읽기 완료\n");
			new ServerThread().start(); // 서비스 시작
		}
	}
	
	class ServerThread extends Thread {
		@Override
		public void run() {
			ServerSocket listener = null;
			Socket socket = null;
			try {
				listener = new ServerSocket(9998);
				while(true) {
					socket = listener.accept();
					log.append("클라이언트 연결됨\n");
					new ServiceThread(socket).start();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				if(listener != null)
					listener.close();
				if(socket != null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	class SpellManager {
		
		private boolean fileOn = false;
		
		public SpellManager(String fileName) {
			try {
				Scanner reader = new Scanner(new FileReader(fileName));
				while(reader.hasNext()) {
					String word = reader.next();
					wordList.add(word);
				}
				reader.close();
				fileOn = true;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				fileOn = false;
			}
		}
		
		public boolean isFileRead() {
			return fileOn;
		}
		
	}
	
	class ServiceThread extends Thread {
		private Socket socket = null;
		private BufferedReader in = null;
		private BufferedWriter out = null;
		
		public ServiceThread(Socket socket) { // 클라이언트와 통신할 소켓을 전달받음
			this.socket = socket;
			try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			while(true) {
				try {
					String name = in.readLine(); // 클라이언트로부터 이름 받음
					if(wordList.contains(name)==false) {
						out.write("NO\n");
						log.append(name + "=NO\n");
					}
					else { 
						out.write("YES" + "\n");
						log.append(name + "=YES\n");				
					}
					out.flush();
				} catch (IOException e) {
					log.append("연결 종료\n");
					System.out.println("연결 종료");
					try {
						socket.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					return; // 스레드 종료
					//e.printStackTrace();
				}

			}
		}
	}
	public static void main(String[] args) {
		new ChatServer();
	}

}
