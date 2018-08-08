import java.io.*; 
import java.net.*;
import java.util.stream.Stream; 
public class ClientDriver{
	
	    public static void main(String argv[]) throws Exception 
	    { 
	        String sentence; 
	        Stream<String> fileContents; 

	        BufferedReader inFromUser = 
	          new BufferedReader(new InputStreamReader(System.in)); 

	        Socket clientSocket = new Socket("localhost", 6789); 

	        DataOutputStream outToServer = 
	          new DataOutputStream(clientSocket.getOutputStream()); 

	        
	        BufferedReader inFromServer = 
	                new BufferedReader(new
	                InputStreamReader(clientSocket.getInputStream())); 
	        	System.out.println("Enter the filename below:");
	              sentence = inFromUser.readLine(); 
	              
	              try{
	           	   File f = new File(sentence);
	           	   //System.out.println(f.getName());
	           	   byte[] filebytes = new byte[(int) f.length()];
	           	   outToServer.writeBytes(sentence+"\n");
	           	   BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));
	                  bis.read(filebytes, 0, filebytes.length);
	                  outToServer.write(filebytes,0,filebytes.length);
	                  outToServer.flush();
	                  System.out.println("file sent!");
	           	   
	              }catch(Exception e){
	           	   System.out.println(e.toString());
	              }
	              clientSocket.close(); 
	                         
	          } 
	      
}
