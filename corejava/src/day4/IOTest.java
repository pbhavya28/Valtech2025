package day4;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.io.BufferedReader;





import org.junit.jupiter.api.Test;

class IOTest {
	
	@Test
	public void testBufferedReader() {
		
		try(BufferedReader br = new BufferedReader(new FileReader(new File("data.txt")))){
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testReaders() {
		
		try(Reader reader = new FileReader(new File("data.txt"))){
			try(Writer writer = new FileWriter(new File("dataOut.txt"))){
			char[] buff = new char[4];
			int i = -1;
			while((i=reader.read(buff))!=-1) {
				writer.write(buff,0,i);
			}
			writer.flush();
		}} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	
	@Test
	public void testChainingStreams() {
		try(InputStream is = new BufferedInputStream(new FileInputStream(new File("data.txt")))){
			 try(OutputStream os = new FileOutputStream("dataCopy.text")){	
					byte[] buff = new byte[4]; //8192 or 16768
					int i=0;
					while((i = is.read(buff))!= -1) {
						System.out.println(new String(buff,0,i));
						os.write(buff,0,i);
					}
					os.flush();
				 }
		}  catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	@Test
	public void testSecondReadTryWithResourses() {
		try(InputStream is = new FileInputStream(new File("data.txt"))){
		 try(OutputStream os = new FileOutputStream("dataCopy.text")){	
			byte[] buff = new byte[4]; //8192 or 16768
//			while((is.read(buff)!= -1)) {
//				System.out.println(new String(buff));
//			}
//			int i=0;
//			while((i = is.read(buff))!= -1) {
//				System.out.println(new String(buff,0,i));
//			}
			
			int i=0;
			while((i = is.read(buff))!= -1) {
				System.out.println(new String(buff,0,i));
				os.write(buff,0,i);
			}
			os.flush();
		 }
//			int bytesRead = is.read(buff);
//			assertEquals(4,bytesRead);
//			System.out.println(new String(buff));
//			assertEquals(4,is.read(buff));
//			System.out.println(new String(buff));
//			assertEquals(3,is.read(buff));
//			System.out.println(new String(buff));
//			assertEquals(-1,is.read(buff));
//			System.out.println(new String(buff));


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testReadTryWithResourses() {
		try(InputStream is = new FileInputStream(new File("data.txt"))){
			 assertEquals('H',((byte)is.read()));
			 assertEquals('e',((byte)is.read()));
			 assertEquals('l',((byte)is.read()));
			 assertEquals('l',((byte)is.read()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@Test
	void testRead() {
	 InputStream is = null;
	try {
	  is = new FileInputStream(new File("data.txt"));
	
	 assertEquals('H',((byte)is.read()));
	 assertEquals('e',((byte)is.read()));
	 assertEquals('l',((byte)is.read()));
	 assertEquals('l',((byte)is.read()));

	 is.close();
	}
	catch (IOException e) {
		e.printStackTrace();
	}
	finally {
		 try {
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	}

}
