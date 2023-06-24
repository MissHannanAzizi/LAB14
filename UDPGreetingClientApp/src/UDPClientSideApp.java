import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * An example of client-side application using UDP
 * @author nurulhannan
 */
public class UDPClientSideApp {

    public static void main(String[] args) {
        System.out.println("UDPClientSideApp: Demonstration of UDP Client-Side Application.");

        try {
            // 1. Define server port number and address
            int serverPort = 8081;
            InetAddress serverAddress = InetAddress.getLocalHost();

            // 2. Prepare and transform data into bytes
            String sentence = "Hello, how are you?";
            byte[] requestData = sentence.getBytes();

            // 3. Wrap data in a datagram packet
            DatagramPacket requestPacket = new DatagramPacket(requestData, requestData.length,
                    serverAddress, serverPort);

            // 4. Create the socket object to transmit the data
            DatagramSocket datagramSocket = new DatagramSocket();

            // 5. Send the request packet to the server
            datagramSocket.send(requestPacket);
            System.out.println("Request sent to server: " + sentence);

            // 6. Prepare a response packet to receive the result
            byte[] responseData = new byte[65535];
            DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length);

            // 7. Receive the response from the server
            datagramSocket.receive(responsePacket);

            // 8. Extract the response data
            responseData = responsePacket.getData();
            String response = new String(responseData, 0, responsePacket.getLength());

            // 9. Display the response from the server
            System.out.println("Response received from server:\n" + response);

            datagramSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("UDPClientSideApp: End of program.");
    }
}
