import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;


public class ChatServer {

	public static void main(String[] args) {
		 
		boolean stared=false;
		ServerSocket ss =null;
		Socket socket =null;
		DataInputStream dis=null;
		
		try{		  
		   ss =new ServerSocket(8888);
		}catch(IOException e){
			e.printStackTrace(); 
		}
		try{
		   stared=true;		   
		   while (stared) {
			   boolean bconnected=false;
			   socket =ss.accept();			  
System.out.println("a Client connected");
              bconnected =true;
              dis=new DataInputStream(socket.getInputStream());              
              while(bconnected){
                 String str= dis.readUTF();
                 System.out.println(str);
               
              }
              dis.close();           
		   }
		}catch(IOException e){
			System.out.println("Client close!");
		}finally {
			try{
				if(dis != null ) dis.close();
				if(ss != null) ss.close();
			}catch(IOException e){
				e.printStackTrace();
			}

		}

	}

}
