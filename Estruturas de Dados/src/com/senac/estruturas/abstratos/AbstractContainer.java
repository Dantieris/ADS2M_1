package com.senac.estruturas.abstratos;

import com.senac.estruturas.interfaces.Container;
import com.senac.estruturas.interfaces.Visitor;

public abstract class AbstractContainer extends AbstractObject implements Container {

	protected int count;
	
	public int getCount() {
		return count;
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	public boolean isFull() {
		return false;
	}
	
	public String toString() {
		
		final StringBuffer buffer = new StringBuffer();
		
		Visitor visitor = new AbstractVisitor() {
			private boolean comma;
			
			public void visit( Object obj ) {
				if (comma)
					buffer.append(",");
				buffer.append(obj);
				comma = true;
			}
		};
		
		accept(visitor);
		return getClass().getName() + " } "+ buffer + " } ";
	}
}
