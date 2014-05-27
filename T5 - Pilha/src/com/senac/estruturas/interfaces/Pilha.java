package com.senac.estruturas.interfaces;

import com.senac.estruturas.exceptions.ContainerEmptyException;
import com.senac.estruturas.exceptions.ContainerFullException;

public interface Pilha extends Container {

	Object getTop ();
	void push (Object obj) throws ContainerFullException;
	Object pop () throws ContainerEmptyException;
}
