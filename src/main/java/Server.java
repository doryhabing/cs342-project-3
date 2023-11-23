import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class Server {
	int port, count = 1;
	String current_letter;
	ArrayList<ClientThread> clients = new ArrayList<ClientThread>();
	TheServer server;
	private Consumer<Serializable> callback;
	Game game = new Game();
	GameLogic logic = new GameLogic();

	Server(Consumer<Serializable> call, String port_string) {
		callback = call;
		server = new TheServer();
		port = Integer.parseInt(port_string);
		server.start();
	}

	public class TheServer extends Thread {

		public void run() {

			try (ServerSocket mysocket = new ServerSocket(port)) {
				System.out.println("Server is waiting for a client!");

				while (true) {
					ClientThread c = new ClientThread(mysocket.accept(), count);
					callback.accept("client has connected to server: " + "client #" + count);
					clients.add(c);
					c.start();
					count++;
				}
			}//end of try
			catch (Exception e) {
				callback.accept("Server socket did not launch");
			}
		}//end of while
	}

	class ClientThread extends Thread {

		Socket connection;
		int count;
		ObjectInputStream in;
		ObjectOutputStream out;

		ClientThread(Socket s, int count) {
			this.connection = s;
			this.count = count;
		}

		public void updateClients(String message) {
			for (int i = 0; i < clients.size(); i++) {
				ClientThread t = clients.get(i);
				try {
					t.out.writeObject(message);
				} catch (Exception e) {
				}
			}
		}

		public void run() {

			try {
				in = new ObjectInputStream(connection.getInputStream());
				out = new ObjectOutputStream(connection.getOutputStream());
				connection.setTcpNoDelay(true);

				updateClients(logic.category1);
				updateClients(logic.category2);
				updateClients(logic.category3);

			} catch (Exception e) {
				System.out.println("Streams not open");
			}

			int i = 0;
			while (true) {
				try {
					String data = in.readObject().toString();
					callback.accept("client: " + count + " sent: " + data);

					if (i == 0 && data.length() >= 2) {
						System.out.println(data);
						String new_word = game.newWord(data);
						updateClients("length");
						updateClients(String.valueOf(new_word.length()));

					} else if (data.length() < 2){
						logic.guessed_letters.add(data);
						current_letter = data;
					}

					i++;
				} catch (Exception e) {
					callback.accept("OOOOPPs...Something wrong with the socket from client: " + count + "....closing down!");
					//updateClients("Client #" + count + " has left the server!");
					clients.remove(this);
					break;
				}
			}
		}//end of run
	}//end of client thread
}



	
	

	
