package utility;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.annotations.common.util.impl.Log;


public class EntityMan {
	private static EntityManagerFactory emf;
	private static Logger log = Logger.getLogger("TeatroMigliorato");
	
	public static EntityManager getEm() {
		if (emf == null)
			emf = Persistence.createEntityManagerFactory("TeatroMigliorato");
		
	//	Log.log(Level.FINE, "richiesto nuovo EntityManager");
		return emf.createEntityManager();
	}
}
