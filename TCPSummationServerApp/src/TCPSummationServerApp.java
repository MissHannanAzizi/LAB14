import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import controller.NumberCalculator;

/**
 * 
 * @author nurulhannan
 *
 */
public class TCPSummationServerApp {

	public static void main(String[] args) {
		
		System.out.println("\n\tExecuting TCPSummationServerApp");
		
		try {
			
			// 1. Bind to a port
			int portNo = 8087;
			ServerSocket serverSocket = new ServerSocket(portNo);
			
			NumberCalculator numberCalculator  = new NumberCalculator();
			
			System.out.println("\tWaiting for request");
			
			// 2. Listen to request
			while (true) {
				
			// 3. Accept request
			Socket clientRequest = serverSocket.accept();
				
			// 4. Process client request - read two numbers from client
			InputStream inStream = clientRequest.getInputStream();
			DataInputStream dis = new DataInputStream(inStream);
			int number1 = dis.readInt();
			int number2 = dis.readInt();
			int number3 = dis.readInt();
			System.out.println("\tFrom client: " + number1 + ", " + number2 + ", " + number3);
			// From client: 101, 2001, 2101
				
			// Further processing
			int sumResult = numberCalculator.getSum(number1, number2, number3);
			int multiplicationResult = numberCalculator.getSum(number1, number2, number3);
				
			// 5. Respond to client - return total to client
			OutputStream outStream = clientRequest.getOutputStream();
			DataOutputStream dos = new DataOutputStream(outStream);
			dos.writeInt(sumResult);
			dos.writeInt(multiplicationResult);
			System.out.println("\tSUM | To client: " + sumResult);
			System.out.println("\tMULTIPLICATOIN | To client: " + multiplicationResult);
				
				
			System.out.println("\n\tWaiting for next request");
				
				
			}
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
			
		}

	}

}






