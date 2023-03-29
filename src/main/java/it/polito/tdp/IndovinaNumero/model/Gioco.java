package it.polito.tdp.IndovinaNumero.model;

public class Gioco {
	
	public enum OutcomeGioco{
		Vinto,
		Perso,
		TroppoAlto,
		TroppoBasso
	}
	
	//Dati di funzionamento dell'applicazione
		
	private int TMax = 8;
	private int NMax = 100;
	private int NTentativiFatti;
	private int numeroSegreto;
	
		
	
	public int getNTentativiFatti() {
		return NTentativiFatti;
	}



	public void setNTentativiFatti(int nTentativiFatti) {
		NTentativiFatti = nTentativiFatti;
	}



	public int getNumeroSegreto() {
		return numeroSegreto;
	}



	public void setNumeroSegreto(int numeroSegreto) {
		this.numeroSegreto = numeroSegreto;
	}



	public int getTMax() {
		return TMax;
	}



	public int getNMax() {
		return NMax;
	}

	
	public void iniziaGioco(Difficolta livello) {
		
		this.NMax = livello.getNMax();
		this.TMax = livello.getTMax();
		this.NTentativiFatti = 0;
    	this.numeroSegreto = (int)(Math.random()*this.NMax) + 1;
    	
	}
	
	/**
	 * Funzione che esegue un tentativo di indovinare il numero segreto
	 * @param tentativo: il numero che tiriamo per indovinare
	 * @return un intero: Vinto se indovinato; Perso se abbiamo esaurito i tentativi senza indovinare;
	 * TroppoAlto se non abbiamo indovinato ed il numero è troppo alto; TroppoBasso se è troppo basso;
	 */
	public OutcomeGioco faiTentativo(int tentativo) {
		
		this.NTentativiFatti++;
		
		//caso 0: vittoria
    	if (tentativo == this.numeroSegreto) {
    		return OutcomeGioco.Vinto;
    	}
    	//caso 1: sconfitta
    	if (this.NTentativiFatti == this.TMax) {
    		return OutcomeGioco.Perso;
    	}
    	//casi 2 e 3: non abbiamo indovinato, il numero è troppo alto o troppo basso
    	if(tentativo>this.numeroSegreto) {
    		return OutcomeGioco.TroppoAlto;
    	}else  {
    		return OutcomeGioco.TroppoBasso;
    	}
		
	}

}
