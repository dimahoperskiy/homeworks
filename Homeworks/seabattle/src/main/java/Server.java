import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static Socket clientSocket;
    private static ServerSocket server;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        try {
            try {
                server = new ServerSocket(4004);
                System.out.println("Server started!");

                clientSocket = server.accept();

                try {
                    while (true) {
                        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                        String word = in.readLine();
                        System.out.println(word);

                        out.write("You send: " + word + "\n");
                        out.flush();

                        if (word.equals("exit"))
                            break;

                    }
                } finally {
                    clientSocket.close();
                }
            } finally {
                System.out.println("Server closed");
                server.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }

    }
}
