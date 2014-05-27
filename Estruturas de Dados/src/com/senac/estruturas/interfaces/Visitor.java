package com.senac.estruturas.interfaces;

public interface Visitor {
	
	void visit (Object obj);
	boolean isDone();
}
