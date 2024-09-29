import java.net.*;
import java.io.*;
import java.util.*;

public class PortScanner {
	
	public static void main(String[] args)throws Exception {
			
			
			int count = 0;
			
		for(int j = 1 ; j<257 ; j++) {
			String web_IP = "8.8.8.4."+j;
			for(int i = 0 ; i<65536 ; i++ ) {
				try(Socket cserver = new Socket(web_IP,i)){
					
					InputStream input = cserver.getInputStream();
					OutputStream output = cserver.getOutputStream();
					BufferedWriter headerwriter = new BufferedWriter(new OutputStreamWriter(output));
					BufferedReader headerreader = new BufferedReader(new InputStreamReader(input));
					
					String header = "http://" + web_IP + ":" +i;
					
					
					headerwriter.write(header);
					headerwriter.flush();
					
					// We assume that the Web server RESPONSE is GET:200
					//header response 200
					header = headerreader.readLine();
					
					
					StringTokenizer strk = new StringTokenizer(header, ":");
					
					String command = strk.nextToken();
					String value = strk.nextToken();
					int response = Integer.parseInt(value);
					
					if(response == 200) {
						count = count + 1;
					}else {
						count = count + 0;
					}
					
					connectionfromServer.close();
					
				}
					
			}
		}
			
			
		
			
		
	}
	

}
