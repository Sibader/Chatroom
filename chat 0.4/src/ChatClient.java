
import java.awt.*;
import java.awt.event.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class ChatClient extends Frame{
	
	DataOutputStream dos =null;
	
	Socket s=null;
	
	TextField tfTextField=new TextField();//输入框
	
	TextArea tArea=new TextArea();//显示框

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChatClient chatClient =new ChatClient();
		chatClient.launchFrame();
	}
	
	public void launchFrame () {
		setLocation(400, 300);
		this.setSize(300, 300);//窗口大小
		add(tfTextField, BorderLayout.SOUTH);//添加输入框在下方
		add(tArea,BorderLayout.NORTH);//添加显示框在上方
		pack();
		/*
		 * 添加关闭窗口
		 */
		this.addWindowListener(new WindowAdapter(){
			
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
				disconnect();
			}
		});
		tfTextField.addActionListener(new tfListener());//添加回车键	
		setVisible(true);
		connected();		
	}
    
	public void disconnect(){
		try {
			dos.close();
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	public void connected(){
		
		try{ 
		     s = new Socket("127.0.0.1", 8888);
System.out.println("connected！");
             dos=new DataOutputStream(s.getOutputStream());
		}catch(UnknownHostException e){
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private class tfListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String str =tfTextField.getText().trim();
			tArea.setText(str);
			tfTextField.setText("");
			
			try{
			     
			     dos.writeUTF(str);
			     dos.flush();
			     //dos.close();
			}catch(IOException e1){
				e1.printStackTrace();
			}
		}
		
	}

}
