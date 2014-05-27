package com.senac.estruturas.interfaces;

import java.util.NoSuchElementException;

public interface Enumeration {
	
	boolean hasMoreElements();
	Object nextElement() throws NoSuchElementException;
}
