package it.polito.tdp.IndovinaNumero1.model;

import java.security.InvalidParameterException;
import java.util.*;

public class Model {
	
	private final int nMax=100;
	private final int tMax=8;
	
	private int segreto;
	private int tentativiFatti;
	private boolean inGioco;
	
	private Set<Integer>tentativi;
	
	
	
	public Model() {
		this.inGioco=false;
		this.tentativiFatti=0;
	}
	public void nuovaPartita() {
		this.segreto=(int)((Math.random())*nMax)+1;
    	this.tentativiFatti=0;
    	this.inGioco=true;	 
    	this.tentativi=new HashSet<Integer>();
	}
	
	public int tentativo(int tentativo) {
		//controllo se partita e' iniziata
		if(!inGioco) {
			throw new IllegalStateException("La partita e' gia' terminata\n");
		}
		//controllo input 
		if(!tentativoValido(tentativo)) {
			throw new InvalidParameterException
			("Numero sempre diverso. Devi inserire un numero tra 1 e "+nMax+"\n");
		}
		this.tentativiFatti++;
		
		this.tentativi.add(tentativo);
		
		if(this.tentativiFatti==tMax) {
			this.inGioco=false;
		}
		if(tentativo==segreto) {
			this.inGioco=false;
			return 0;
		}
		if(tentativo<this.segreto) {
			return -1;
		}else {
			return 1;
		}
		
	}
	private boolean tentativoValido(int tentativo) {
		if(tentativo<1||tentativo>nMax) {
			return false;
		}else {
			if(this.tentativi.contains(tentativo)) {
				return false;
			}
			return true;
		}
		
	}
	public int getSegreto() {
		return segreto;
	}
	public void setSegreto(int segreto) {
		this.segreto = segreto;
	}
	public int getTentativiFatti() {
		return tentativiFatti;
	}
	public void setTentativiFatti(int tentativiFatti) {
		this.tentativiFatti = tentativiFatti;
	}
	public boolean isInGioco() {
		return inGioco;
	}
	public void setInGioco(boolean inGioco) {
		this.inGioco = inGioco;
	}
	public int getnMax() {
		return nMax;
	}
	public int gettMax() {
		return tMax;
	}

}
