package observer;

import java.util.concurrent.Future;

public interface Observer<T> {
	
	Future<Void> update(T subject);
}
