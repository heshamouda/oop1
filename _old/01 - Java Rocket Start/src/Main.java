
import java.io.IOException;

import lib.App;

public class Main {
	
	public static void main(String[] args) {
		try {
			new App();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
