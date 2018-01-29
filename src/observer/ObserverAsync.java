package observer;

import java.util.concurrent.Future;

public interface ObserverAsync<T> {

	Future<Void> update(T subject);
}
