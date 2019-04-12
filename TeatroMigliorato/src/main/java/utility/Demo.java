package utility;

import java.sql.SQLException;
import java.util.Scanner;

import java_bean.Biglietto;
import java_bean.Gruppo;
import java_bean.Posto;
import java_bean.Spettacolo;
import java_bean.Spettatori;
import manager.Manager;

public class Demo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		EntityMan em = new EntityMan();
		em.getEm();
		menu();
	
	}
	
	
	
	public static void menu() throws ClassNotFoundException, SQLException, NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("scelta 1: acquista biglietti");
		System.out.println("scelta 2: registra gruppo e programma spettacolo");
		System.out.println("scelta 3: conferma spettacolo");
		System.out.println("scelta 4: termina programma");
		int scelta;
		
		do {
			System.out.print("scegli dal menu > ");
			
			scelta = sc.nextInt();
			
			
			if(scelta<1 || scelta>3)
				System.out.println("scelta non valida");
			
			switch(scelta) {
			case 1: 
				Spettatori s = new Spettatori();
				System.out.print("inserisci nome > ");
				String a = sc.nextLine(); // non faceva aggiungere la stringa
				String nome = sc.nextLine();
				s.setNome(nome);
				System.out.print("inserisci cognome > ");
				String cognome = sc.nextLine();
				s.setCognome(cognome);
				Manager.aggiungi(s);
				System.out.print("botteghino genera codice del posto > ");
				String cod = sc.nextLine();
				Posto p = new Posto();
				
				p.setCodice(cod);
				Manager.aggiungi(p);
				
				Biglietto b = new Biglietto();
				//b.setId(6);
				b.setVenduto(true);
				b.setId_posto(p);
				// p.setId_biglietto(b);
				b.setId_spettatore(s);
				Manager.aggiungi(b);
				
				System.out.println("La persona "+s.getNome()+" "+s.getCognome()+" ha acquistato il biglietto con ID "+b.getId()+" e gli è stato assegnato "
						+ "il posto con codice "+p.getCodice());
				break;
			
			case 2:
				Gruppo g = new Gruppo();
				System.out.print("inserisci nome del gruppo > ");
				String nom = sc.nextLine(); // non faceva aggiungere la stringa
				String nomeG = sc.nextLine();
				g.setNome(nomeG);
				System.out.print("inserisci numero di componenti > ");
				int num = sc.nextInt();
				g.setNumeroPersone(num);
				Manager.aggiungi(g);
				Spettacolo spet = new Spettacolo();
				System.out.print("inserisci nome dello spettacolo > ");
				String n = sc.nextLine(); // non faceva aggiungere la stringa
				String nomeSpet = sc.nextLine();
				spet.setNome(nomeSpet);
				spet.setConfermato(false);
				spet.setId_gruppo(g);
				Manager.aggiungi(spet);
				
				break;
			case 3:
				System.out.print("inserisci nome dello spettacolo da confermare (lo spettacolo è confermato solo se"
						+ " il numero di iscritti è almeno 3 e massimo 5) > ");
				String nomee = sc.nextLine(); // non faceva aggiungere la stringa
				String nomeS = sc.nextLine();
				Manager.confermaSpettacolo(nomeS);
				 break;
			case 4:
				System.out.println("programma terminato");
				System.exit(0); break;
			default: ;
			}
			
			
		}while(scelta>= 1 || scelta<= 3);
	}

}
