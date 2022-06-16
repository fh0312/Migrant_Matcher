package com.projeto2.sistema.observer;

public interface Observable {
	
	public void registaObserver(Observer obs);
	public void notificaObservers();
	public void removeObserver(Observer obs);
}
