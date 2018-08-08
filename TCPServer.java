
import java.io.*; 
import java.net.*;
import java.util.stream.Stream; 

public class TCPServer { 

  public static void main(String argv[]) throws Exception 
    { 
	  System.out.println("Running TCP server...");
      String clientSentence; 
      String capitalizedSentence; 

      ServerSocket welcomeSocket = new ServerSocket(6789); 
  
      while(true) { 
  
            Socket connectionSocket = welcomeSocket.accept(); 

           BufferedReader inFromClient = 
              new BufferedReader(new
              InputStreamReader(connectionSocket.getInputStream())); 

           DataOutputStream  outToClient = 
             new DataOutputStream(connectionSocket.getOutputStream()); 

          
           //Stream clientInput = inFromClient.lines();
           
          System.out.println("here");
          boolean flag = true;
          clientSentence = inFromClient.readLine();
          String FileName = clientSentence;
          FileWriter outputFile = new FileWriter(clientSentence);
          //clientSentence = inFromClient.readLine();
         while(clientSentence != null){
        	 System.out.println(clientSentence);
        	 clientSentence = inFromClient.readLine();
        	 try{
        		 
        		 outputFile.write(clientSentence+"\n");
        		 System.out.println("Server wrote: " + clientSentence + " to file ");
        		
        	 }catch(Exception e){}
        	 
        	 outputFile.close();
         }
      }
    }
}
           
