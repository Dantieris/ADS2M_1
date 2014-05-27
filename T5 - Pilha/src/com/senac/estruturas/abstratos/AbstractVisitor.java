package com.senac.estruturas.abstratos;

import com.senac.estruturas.interfaces.Visitor;

public abstract class AbstractVisitor implements Visitor {

	public void visit (Object obj) {
		
	}
	
	public boolean isDone() {
		return false;
	}
}
