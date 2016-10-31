package CipherWriter;

import java.io.IOException;
import java.io.Writer;

public class EncryptingWriter extends Writer {
	
	private Writer writer;
	
	public EncryptingWriter(Writer writer){
		this.writer = writer;
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		encrypt(cbuf, off, len);
		writer.write(cbuf, off, len);
	}

	@Override
	public void flush() throws IOException {
		writer.flush();
	}

	@Override
	public void close() throws IOException {
		writer.close();
	}
	
	public void encrypt(char[] cbuf, int off, int len){
		for(int i = off; i < off + len; i++){
			char c = cbuf[i];
			if(Character.isLetter(c)){
				int d = (int) c + 3;
				if(Character.isLowerCase(c)){
					if(d > 122)
						d = 65 + (d-90);
				}else{
					if(d > 90)
						d = 97 + (d-122);
				}
				cbuf[i] = (char) d;
			}
		}
	}
	

}
