package observer;

import java.util.concurrent.Future;

public interface ObserverDeCapteur extends Observer<Capteur> {

	Future<Void> update(Capteur subject);

}
