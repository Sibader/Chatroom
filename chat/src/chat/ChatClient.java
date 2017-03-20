package chat;

import java.awt.*;

public class ChatClient extends Frame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChatClient chatClient =new ChatClient();
		chatClient.launchFrame();

	}
	public void launchFrame () {
		setLocation(800, 700);
		this.setSize(700, 700);
		setVisible(true);
		
	}

}
