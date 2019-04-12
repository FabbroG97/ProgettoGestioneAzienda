package manager;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;

import java_bean.Biglietto;
import java_bean.MasterEntity;
import utility.EntityMan;
// un unico manager per tutte le classi
public class Manager {
 
	public static boolean aggiungi(MasterEntity m) throws ClassNotFoundException, SQLException, NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException {
        boolean result = false;
        EntityManager em = EntityMan.getEm();
        Class <? extends MasterEntity> cls = m.getClass();
        //getClassName(c);
        getStringFields(m);
        //System.out.println(cls.getTypeName());
        //Field field = cls.getDeclaredField("id"); 
        //db= cls.newInstance();

        MasterEntity db = em.find(cls, m.getId());
        if (db == null) {
            em.getTransaction().begin();
            em.persist(m);
            em.getTransaction().commit();
            System.out.println("ho aggiunto un record alla tabella "+m.getClass());
            result = true;
        } else {
            System.out.println("l'oggetto con ID " +cls.getDeclaredField("id")  + " è già presente nella tabella "+m.getClass());
        }
        return result;
    }
    
	

    public static boolean rimuovi(int id) {
        boolean result = false;
        EntityManager em = EntityMan.getEm();
        
        MasterEntity db = (MasterEntity)em.find(MasterEntity.class, id);
        if (db != null) {
            em.getTransaction().begin();
            em.remove(db);
            em.getTransaction().commit();
            System.out.println("ho rimosso il record con ID "+db.getId()+" dalla tabella "+db.getClass());
            result = true;
        } else {
            System.out.println("l'ID inserito non è stato trovato");
        }
        return result;
    }
    
    public static void confermaSpettacolo(String nome) throws SQLException, ClassNotFoundException {
    	Statement comandoSql = dammiConnessione().createStatement(); 
		ResultSet controlloBiglietti = comandoSql.executeQuery("select DTYPE from MasterEntity where DTYPE = \"Biglietto\""); // mi permette di ciclare ogni volta sui record
		
		int contBiglietti = 0;
		boolean confermato = false;
		while (controlloBiglietti.next()) {
			contBiglietti++;
			if((contBiglietti >= 3) && (contBiglietti <= 5)) {
				ResultSet dati = comandoSql.executeQuery("select * from MasterEntity where DTYPE = \"Spettacolo\""); // mi permette di ciclare ogni volta sui record
				while(dati.next()) {
					if(nome.equalsIgnoreCase(dati.getString("nome"))) {
						String query = "UPDATE MasterEntity "
								+ "SET confermato ="+ true +""
								+ " WHERE confermato ="+false+" AND nome=\"" + nome +"\""; //nome=\"" + nome +"\" --> quando quel campo + un varchar
						System.out.println("Lo spettacolo è stato confermato");
						confermato = true;
						PreparedStatement comandoSqlUpdate = dammiConnessione().prepareStatement(query);
						comandoSqlUpdate.executeUpdate(query);
					}
				}
			}
		}
		
		if (confermato == false) {
			if(contBiglietti<3)
				System.out.println("numero di persone non sufficiente");
			else 
				System.out.println("numero di persone superato");
		}
    }	
    public static String getClassName(Object aClass)
	{
		return aClass.getClass().getSimpleName();
	}
    
    
    // Tramite l'oggetto di cui non conosco la classe mi faccio
 	// restituire i suoi attributi in un array di stringhe
 	public static String[] getStringFields(Object aClass)
 	{

 		Field []  campi = aClass.getClass().getDeclaredFields();
 		String[] campiStringa = new String[campi.length];
 		for (int i = 0; i < campi.length; i++)
 		{
 			campiStringa[i] = campi[i].getName();
 		}
 		
 		 System.out.println("Declared Fields: " );
 		 for (Field field : campi) {
 			 System.out.println(field);
 		 }
 		
 		
 		return campiStringa;
 	}
 	
 	public static Connection dammiConnessione() throws ClassNotFoundException, SQLException {
        Class.forName("org.mariadb.jdbc.Driver");
        Connection conn = DriverManager.getConnection("connection");
        // ho creato un file di configurazione chiamato config.properties nella cartella config. Dentro ci ho messo 
        // la mia stringa di connessione e l'ho chiamata connection e l'ho richiamata nel codice. I file di configurazione sono
        // formati da chiave-valore.
        return conn;
    }
}
