package com.senac.estruturas;

public class ListaDuplaEncadeadaOrdenadaIterativa<T extends Comparable<T>> {
	
		private NodoDuplaIterativa<T> head;
		private NodoDuplaIterativa<T> tail;


		public void insere (NodoDuplaIterativa<T> novo) {

			if (head == null) {
				head = novo;
				tail = novo;
			} else {
				NodoDuplaIterativa<T> nodo = procuraProx(novo.getValor());
				if (nodo != null) {
					NodoDuplaIterativa<T> previousNodo = nodo.getAnterior();
					NodoDuplaIterativa<T> nextNodo = nodo;

					novo.setProximo(nextNodo);
					novo.setAnterior(previousNodo);

					if (previousNodo != null)
						previousNodo.setProximo(novo);
					else 
						head = novo;

					nextNodo.setAnterior(novo);

				} else {
					NodoDuplaIterativa<T> previousNodo = tail;
					NodoDuplaIterativa<T> nextNodo = null;

					novo.setProximo(nextNodo);
					novo.setAnterior(previousNodo);

					tail.setProximo(novo);
					tail = novo;
				}
			}

		}

		public NodoDuplaIterativa<T> procura (T valor) {

			NodoDuplaIterativa<T> iter = head;
			while (iter != null) {
				// visitacao

				int cmp = valor.compareTo(iter.getValor());
				if (cmp == 0)
					return iter;
				if (cmp < 0) 
					return null;

				// iteracao

				iter = iter.getProximo();
			}
			return null;
		}


		public NodoDuplaIterativa<T> procuraProx (T valor) {
			NodoDuplaIterativa<T> iter = head;
			while (iter != null) {
				// visitacao

				int cmp = valor.compareTo(iter.getValor());
				if (cmp < 0) 
					return iter;

				// iteracao

				iter = iter.getProximo();
			}
			return null;
		}


		public void remove (T valor) {

		}
	
}
