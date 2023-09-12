package edu.du.cs.cmorrissgandhi.painter;
import java.io.*;
import java.util.*;
import java.net.*;

//Server class
public class Hub {

	// Vector to store active clients
	// this works much better than arrayLists for vectors
	static Vector<ClientHandler> ar = new Vector<>();
	static Vector<PaintingPrimitive> shapes = new Vector<>();

	// counter for clients

	public static void main(String[] args) throws IOException {
		// server is listening on port 1234
		ServerSocket ss = new ServerSocket(1234);

		Socket s;
		// running infinite loop for getting
		// client request
		while (true) {
			// Accept the incoming request
			s = ss.accept();

			System.out.println("New client request received : " + s);

			// obtain input and output streams

			System.out.println("Creating a new handler for this client...");

			// Create a new handler object for handling this request.
			ClientHandler mtch = new ClientHandler(s);

			// Create a new Thread with this object.
			Thread t = new Thread(mtch);

			System.out.println("Adding this client to active client list");

			ar.add(mtch);

			t.start();

		}

	}
}

//ClientHandler class
class ClientHandler implements Runnable {
	public String name;

	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	Socket s;
	boolean named;

	public ClientHandler(Socket s) throws IOException {
		this.s = s;
		named = false;

		System.out.println("creating clienthandler output streams in hub");
		oos = new ObjectOutputStream(s.getOutputStream());
		ois = new ObjectInputStream(s.getInputStream());
		System.out.println("finishing creating clienthandler output streams in hub");

	}

	@Override
	public void run() {

		String received = new String();

		// code below will send shapes to the class
		for (PaintingPrimitive shape : Hub.shapes) {
			// prints to all connected users the message that got sent
			try {
				oos.writeObject(shape);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		while (true) {
			try {
				// grabs the inputed object
				Object p = ois.readObject();

				// checks to see if what it got was a string
				if (p instanceof String) {
					received = (String) p;

					if (!named) {
						named = true;
						name = received;
						received = "joined the game";
					}

					// prints to the hub the message that was received
					System.out.println(received);

					// logs the user out if that is the command they sent

					// ar is the vector storing active users
					for (ClientHandler mc : Hub.ar) {
						// prints to all connected users the message that got sent
	
							mc.oos.writeObject(this.name + ": " + received);
						
					}
				} else {
					System.out.println("I received a shape.");
					System.out.println(p);
					Hub.shapes.add((PaintingPrimitive)p);
					
					for (ClientHandler mc : Hub.ar) {
						// prints to all connected users the message that got sent
						
							System.out.println("wrote to client");
							mc.oos.writeObject((PaintingPrimitive)p);
						
					}

				}
			} catch (IOException | ClassNotFoundException e) {
				try {
					this.ois.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					this.oos.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				// removes itself from the overall array
				System.out.println("Removing this client to active client list");
				Hub.ar.remove(this);
				return;
			}

		}
	}
}
