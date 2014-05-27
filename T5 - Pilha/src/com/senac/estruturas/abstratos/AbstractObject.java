package com.senac.estruturas.abstratos;

import com.senac.estruturas.interfaces.Comparable;

public abstract class AbstractObject implements Comparable{

	protected abstract int compareTo (Comparable arg);
	
	public final boolean isLT(Comparable obj) {
		return compare (obj) < 0;
	}

	public boolean isLE(Comparable obj) {
		return compare (obj) <= 0;
	}

	public boolean isGT(Comparable obj) {
		return compare (obj) > 0;
	}

	public boolean isGE(Comparable obj) {
		return compare (obj) >= 0;
	}

	public boolean isEQ(Comparable obj) {
		return compare (obj) == 0;
	}

	public boolean isNE(Comparable obj) {
		return compare (obj) != 0;
	}
	
	public final boolean equals (Object obj) {
		if (obj instanceof Comparable) 
			return isEQ(( Comparable) obj);
		else
			return false;
	}
	
	public final int compare (Comparable arg) {
		if (getClass() == arg.getClass())
			return compareTo(arg);
		else
			return getClass().getName().compareTo( arg.getClass().getName() );
	}
	
}
