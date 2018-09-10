package ip;

/*@developer Cristian Mitul, n¼33876 , P2
 *@docente	 Miguel Domingues 
 */
public class Torres {

	public static final int CELULAS = 5;
	private boolean existeTorre;
	private int contador;
	private int torreCorrente;
	private Torre[] torres;
	//----CONSTRUCTOR-----
	public Torres() {
		contador = 0;
		torres = new Torre[CELULAS];
	}

	// ----RETORNA A EXISTENCIA DA TORRE---
	public boolean existeTorre() {
		return existeTorre;
	}

	// ---------GUARDA TORRE-----
	public boolean guardarTorre(Torre t) {
		existeTorre = false;

		// -----DUPLICA O TAMANHO DO VECTOR--
		if (contador == torres.length) {
			Torre[] tmp = new Torre[torres.length * 2];
			for (int i = 0; i < torres.length; i++) {
				tmp[i] = torres[i];
			}
			torres = tmp;
		}
		// --------VERIFICA SE A TORRE EXISTE----
		for (int j = 0; j < contador; j++) {
			if (t.equals(torres[j].obterLocalizacao())
					&& (t.equals(torres[j].obterRede()))) {
				existeTorre = true;
			} else {
				existeTorre = false;
			}
		}
		// ---SE A TORRE NåO EXISTE -> é CRIADA------
		if (existeTorre == false) {
			torres[contador] = t;
			contador++;
			return true;
		}
		// -----RETORNA SE A TORRE JA EXISTE-----
		return false;
	}

	// --------ITERADOR--------
	public void initializeIterator() {
		if (contador > 0)
			torreCorrente = 0;
		else
			torreCorrente = -1;
	}
	//---VERIFICA SE EXISTE A TORRE SEGUINTE--
	public boolean hasNext() {
		return ((torreCorrente >= 0) && (torreCorrente < contador));
	}

	public Torre next() {
		Torre t = null;
		if (this.hasNext())
			t = torres[torreCorrente++];
		return t;

	}

}
