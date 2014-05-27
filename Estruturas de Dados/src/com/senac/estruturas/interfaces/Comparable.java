package com.senac.estruturas.interfaces;

public interface Comparable {
	
	boolean isLT (Comparable obj);
	boolean isLE (Comparable obj);
	boolean isGT (Comparable obj);
	boolean isGE (Comparable obj);
	boolean isEQ (Comparable obj);
	boolean isNE (Comparable obj);
	int compare (Comparable obj);
}
