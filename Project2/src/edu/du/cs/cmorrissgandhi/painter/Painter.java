package edu.du.cs.cmorrissgandhi.painter;
import java.awt.*;
import java.awt.event.*;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.*;
import java.io.*;

public class Painter implements ActionListener, MouseListener, MouseMotionListener {

	Color temp = Color.RED;

	// 0 = line, 1 = circle
	int object = 0;

	PaintingPanel canvas;
	JTextArea text;
	JTextField name;

	Point startPoint = new Point();
	Point endPoint = new Point();

	String painterName;
	String tempMsg;
	painterSocket pSckt;

	final static int ServerPort = 1234;
	DataOutputStream oos;
	painterSocket p;
	String uName;
	String line1;
	String line2;
	String line3;

	Painter() throws IOException {

		// buttons
		JButton circleBut = new JButton();
		JButton lineBut = new JButton();

		// frame
		// close operation
		// resizes
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 575);

		// holder holds the information
		JPanel holder = new JPanel();
		JPanel leftPanel = new JPanel();
		holder.setLayout(new BorderLayout());
		leftPanel.setLayout(new GridLayout(3, 1)); // 3 by 1 grid

		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(1, 2)); // 3 by 1 grid
		frame.add(holder);

		// circle and line buttons

		circleBut.setText("Circle");
		lineBut.setText("Line");
		northPanel.add(circleBut);
		northPanel.add(lineBut);
		circleBut.setActionCommand("1");
		lineBut.setActionCommand("0");

		//
		holder.add(northPanel, BorderLayout.NORTH);

		// red
		JButton redPaint = new JButton();
		redPaint.setBackground(Color.RED);
		redPaint.setOpaque(true);
		redPaint.setBorderPainted(false);
		leftPanel.add(redPaint);
		redPaint.setActionCommand("red");

		// green
		JButton greenPaint = new JButton();
		greenPaint.setBackground(Color.GREEN);
		greenPaint.setOpaque(true);
		greenPaint.setBorderPainted(false);
		leftPanel.add(greenPaint);
		greenPaint.setActionCommand("green");

		// blue
		JButton bluePaint = new JButton();
		bluePaint.setBackground(Color.BLUE);
		bluePaint.setOpaque(true);
		bluePaint.setBorderPainted(false);
		leftPanel.add(bluePaint);
		bluePaint.setActionCommand("blue");

		holder.add(leftPanel, BorderLayout.WEST);

		canvas = new PaintingPanel();

		holder.add(canvas, BorderLayout.CENTER);

		circleBut.addActionListener(this);
		lineBut.addActionListener(this);
		redPaint.addActionListener(this);
		greenPaint.addActionListener(this);
		bluePaint.addActionListener(this);

		canvas.addMouseListener(this);
		canvas.addMouseMotionListener(this);

		// code below all pertains to the text functionalities

		JPanel south = new JPanel();
		south.setLayout(new BorderLayout());

		JPanel IOholder = new JPanel();
		IOholder.setLayout(new GridLayout(1, 2));

		// text is

		text = new JTextArea(6, 1);
		name = new JTextField();

		JScrollPane scroll = new JScrollPane(text);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		// Add TextArea in to middle panel
		// middlePanel.add(scroll);

		// text.setPreferredSize(new Dimension(3,1));
		text.setBackground(Color.GRAY);
		text.setEditable(false);

		name.setBackground(Color.LIGHT_GRAY);

		// original numbers 4,2

		holder.add(south, BorderLayout.SOUTH);
		// this said text before
		south.add(scroll, BorderLayout.CENTER);
		// middlePanel.add(scroll);

		JButton send = new JButton();

		send.setText("SEND");
		IOholder.add(name, BorderLayout.SOUTH);
		IOholder.add(send);
		south.add(IOholder, BorderLayout.SOUTH);

		send.addActionListener(this);
		send.setActionCommand("send");

		frame.setContentPane(holder);
		frame.setVisible(true);
		
		/* the code below was a little solution found from stack overflow
		 * that basically autoscrolls to the bottom, except when you
		 * change the value yourself!
		 * 
		 * Credit Krisztian Nagy Zsolt
		 */
		scroll.getVerticalScrollBar().addAdjustmentListener(
				e -> {
				    if ((e.getAdjustable().getValue() - e.getAdjustable().getMaximum()) > -scroll.getHeight() - 15){
				        e.getAdjustable().setValue(e.getAdjustable().getMaximum());
				    }   
				});
		
		//******************************
		
		uName = JOptionPane.showInputDialog("Enter a Gamertag");

	}

	public void setSocket(painterSocket s) {
		p = s;
	}

	public String getName() {
		return uName;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("red")) {
			temp = Color.RED;
			System.out.println("received r");
		} else if (e.getActionCommand().equals("green")) {
			temp = Color.GREEN;
			System.out.println("received g");
		} else if (e.getActionCommand().equals("blue")) {
			temp = Color.BLUE;
			System.out.println("received b");
		} else if (e.getActionCommand().equals("0")) {
			object = 0;
			System.out.println("received 0");
		} else if (e.getActionCommand().equals("1")) {
			object = 1;
			System.out.println("received 1");
		} else if (e.getActionCommand().equals("send")) {

			tempMsg = name.getText();
			name.setText("");
			p.sendMessage(tempMsg);

			// now, we have to do something with tempMsg

		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		//System.out.println("STOP DRAGGING THE MOUSE");
		endPoint = new Point(e.getPoint());
		if (object == 0) {
			canvas.tempPrim(new Line(startPoint, endPoint, temp));
		}
		if (object == 1) {
			canvas.tempPrim(new Circle(startPoint, endPoint, temp));
			//canvas.addPrimitive(new Circle(startPoint, endPoint, temp));
		}

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		startPoint = new Point(e.getPoint());

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		endPoint = new Point(e.getPoint());
		if (object == 0) {
			p.sendObject(new Line(startPoint, endPoint, temp));
			//canvas.addPrimitive(new Line(startPoint, endPoint, temp));
		}
		if (object == 1) {
			p.sendObject(new Circle(startPoint, endPoint, temp));
			//canvas.addPrimitive(new Circle(startPoint, endPoint, temp));
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		Painter game1 = new Painter();

		// connects the socket to the host
		System.out.println("About to call");
		Socket s = new Socket("localhost", ServerPort);
		System.out.println("Connected");

		ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
		ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());

		System.out.println("Thread started");
		painterSocket pSckt = new painterSocket(game1, ois, oos);
		Thread t = new Thread(pSckt);
		t.start();
		game1.setSocket(pSckt);
		game1.p.sendMessage(game1.getName());

	}

}

/*
 * this class is like my clienthandler, except for its for my painters
 */
class painterSocket implements Runnable {

	final ObjectInputStream ois;
	final ObjectOutputStream oos;
	Painter painter;
	String received2;

	public painterSocket(Painter painter, ObjectInputStream ois, ObjectOutputStream oos) {
		this.painter = painter;
		this.ois = ois;
		this.oos = oos;
	}

	/* this method runs in a thread to check for new input, and then
	 * puts that new input where it needs to go. thanks to alex, i discovered
	 * the instance of feature, which i implemented to make sending objects very easy
	 * if text is detected, it prints adds the message to the chat log box,
	 * 
	 * if an object is detected, it casts it to a primitive and adds it to the list
	 */
	@Override
	public void run() {
		Object p;
		String received;
		while (true) {

			try {
				// read the message sent to this client
				p = ois.readObject();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
				break;
			}

			if (p instanceof String) {

				received = (String) p;
				// System.out.println(received);
				painter.text.setText(painter.text.getText() + "\n" + received);
			} else {
				painter.canvas.addPrimitive((PaintingPrimitive)p);

			}

		}

	}
	
	/*
	 * allows the sending of a message, and prevents the user from
	 * sending a blank message to the other computers
	 */

	public void sendMessage(String msg) {
		if (!msg.equals("")) {
			try {
				oos.writeObject(msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	

	public void sendObject(PaintingPrimitive shape) {
		try {
			oos.writeObject(shape);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}