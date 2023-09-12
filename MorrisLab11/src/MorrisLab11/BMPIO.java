package MorrisLab11;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.awt.Color;

public class BMPIO {
	
	
	
	public static Color[][] readBMPFile(String file) {
		Color[][] color1 = null;
		int width = 0;
		int height = 0;
		
		
		 try {
			 RandomAccessFile raf = new RandomAccessFile(file,"r");
			 
			 try {
				 //0
				 System.out.println(raf.readByte());
				 
				 //1
				 System.out.println(raf.readByte());
				 
				 //10-13
				 raf.seek(10);
				 System.out.println(raf.readByte());
				 
				 //14-17
				 raf.seek(14);
				 System.out.println(raf.readByte());
				 
				 //18-21
				 raf.seek(18);
				 width = Integer.reverseBytes(raf.readInt());
				 
				 height = Integer.reverseBytes(raf.readInt());
				 
				 raf.seek(28);
				 System.out.println(raf.readByte());
				 
				 raf.seek(54);
				 color1 = new Color[width][height];
				 
				 for (int i = 0; i < height; i++) {					 
					 for (int j = 0; j < width; j++) {
						 try {
							 int blue = raf.readUnsignedByte();
							 int green = raf.readUnsignedByte();
							 int red = raf.readUnsignedByte();
							 
							 
							 color1[j][i] = new Color(red, green, blue);
						 
						 }catch (IOException e) {
							 System.out.println(e);
						 }	 
					 }
				 }		 
			 } catch (IOException e) {
				 System.out.println(e);
			 }
			 
		 } catch(FileNotFoundException e) {
			 System.out.println(e);
		 }
		return color1;
	}
}
