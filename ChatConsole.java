package default_package;
import java.io.IOException;
import java.util.Scanner;

public class ChatConsole {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		boolean isServer = (args[0].equals("true")? true : false);
		Chat chat = new Chat( isServer , 1723);
		
		if(isServer){//permet de déterminer un logiciel prioritaire
			String msg = chat.waitForMessage();
			System.out.println(msg);
		}
		while(true){
			System.out.print(">");
			String msg = sc.nextLine();
			if(msg.equals("STOP")){
				chat.sendMessage("END");
				sc.close();
				System.exit(0);
			}
			chat.sendMessage(msg);
			msg = chat.waitForMessage();
			System.out.println(msg);
			
		}
		
	}

}
