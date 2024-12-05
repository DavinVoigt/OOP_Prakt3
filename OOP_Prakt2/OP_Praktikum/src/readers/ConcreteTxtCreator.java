package readers;

import java.io.IOException;

public class ConcreteTxtCreator extends Creator{

	@Override
	public Product factoryMethod() throws IOException {
		// TODO Auto-generated method stub
		return new ConcreteTxtProduct();
	}

}
