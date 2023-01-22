package Abstract.Interface;

import java.io.Serializable;

public interface Saving <T> extends Serializable {
	public <T> T getSave();
	public void getAutoStart() throws InterruptedException;
	
}
