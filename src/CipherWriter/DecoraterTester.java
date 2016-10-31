package CipherWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
//exercise 5.12
class DecoraterTester
{
   public static void main(String[] args) throws IOException
   {  
	  String message = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	  String encryptedMessage = "defghijklmnopqrstuvwxyzbcdDEFGHIJKLMNOPQRSTUVWXYZBCD";
	  System.out.println("Message: "+message);
	  
	  
	  System.out.println("Test Encrypting: ");
	  EncryptingWriter encrypter = new EncryptingWriter(new FileWriter("test.txt"));
	  encrypter.write("abcdefghijklmnopqrstuvwxyz",0,26);
	  encrypter.write("ABCDEFGHIJKLMNOPQRSTUVWXYZ",0,26);
	  encrypter.close();
	  
	  Scanner in = new Scanner(new File("test.txt"));
	  String line = in.nextLine();
	  System.out.println("Expected :"+encryptedMessage);
	  System.out.println("Result   :"+line);
	  
	  System.out.println("Test Decrypting: ");
	  char[] result = new char[100];
	  DecryptingReader decrypter = new DecryptingReader(new FileReader("test.txt"));
	  decrypter.read(result, 0, 52);
	  System.out.println("Expected: "+message);
	  System.out.printf("Result  : ");
	  for(int i = 0; i < 52; i++){
		  System.out.printf("%c",result[i]);
	  }
   } 
}