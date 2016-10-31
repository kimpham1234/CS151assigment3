package CipherWriter;

import java.io.IOException;
import java.io.Reader;

public class DecryptingReader extends Reader {
	private Reader reader;
	
	public DecryptingReader(Reader reader){
		this.reader = reader;
	}
	
	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		int result = reader.read(cbuf, off, len);
		decrypt(cbuf, off, len);
		return result;
	}

	@Override
	public void close() throws IOException {
		reader.close();
		
	}
	
	public void decrypt(char[] cbuf, int off, int len){
		for(int i = off; i < off + len; i++){
			char c = cbuf[i];
			if(Character.isLetter(c)){
				int d = (int) c - 3;
				if(Character.isLowerCase(c)){
					if(d < 97)
						d = 90 - (65-d);
				}else{
					if(d < 65)
						d = 122- (97-d);
				}
				cbuf[i] = (char) d;
			}
		}
	}

}
