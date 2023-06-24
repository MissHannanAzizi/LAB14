import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import serverside.SentenceProcessor;

/**
 * An example of server-side application using UDP
 * @author nurulhannan
 */
public class UDPServerSideApp {

    public static void main(String[] args) {
        System.out.println("UDPServerSideApp: Demonstration of UDP Server-Side Application.");

        // Permissible port for this application
        int portNo = 8081;

        try {
            // 1. Bind a DatagramSocket's object to a port number
            DatagramSocket datagramSocket = new DatagramSocket(portNo);

            // Continually listen for request
            while (true) {
                // 2. Variable to receive data from the port
                byte[] receivedData = new byte[65535];

                // 3. Object represents packet from client
                DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);

                // 4. Receive packet
                datagramSocket.receive(receivedPacket);

                // 5. Extract data from packet
                receivedData = receivedPacket.getData();

                // 6. Further processing
                SentenceProcessor processor = new SentenceProcessor(receivedData);
                String sentence = processor.getSentence();
                System.out.println("\nMessage received: " + sentence + ".");

                // Perform analysis
                int vowelCount = processor.countVowels();
                int consonantCount = processor.countConsonants();
                int punctuationCount = processor.countPunctuation();

                // Prepare response message
                String response = "Analysis result:\n" +
                        "Vowels: " + vowelCount + "\n" +
                        "Consonants: " + consonantCount + "\n" +
                        "Punctuation: " + punctuationCount;

                // Get the client information
                InetAddress clientAddress = receivedPacket.getAddress();
                int clientPort = receivedPacket.getPort();
                byte[] responseData = response.getBytes();
                int responseDataLength = responseData.length;

                // Create a response packet
                DatagramPacket responsePacket = new DatagramPacket(responseData, responseDataLength,
                        clientAddress, clientPort);

                // Send the response to the client
                datagramSocket.send(responsePacket);
                System.out.println("Response sent to client.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("UDPServerSideApp: End of program.");
    }
}
