package ip;

/*@developer Cristian Mitul, n¼33876 , P2
 *@docente	 Miguel Domingues 
 */
public class Telemoveis {
	public static final int CELULAS = 5;
	private boolean existeTelemovel;
	private int contador;
	private int telemovelCorrente;
	private Telemovel[] telemoveis;
	//--CONSTRUCTOR--
	public Telemoveis() {
		contador = 0;
		telemoveis = new Telemovel[CELULAS];
	}
	//--DEVOLVE SE EXISTE TELEMOVEL--
	public boolean existeTelemovel() {
		return existeTelemovel;
	}

	// -----------------GUARDA TELEMOVEL--------------------------
	public boolean guardarTelemovel(Telemovel t) {
		existeTelemovel = false;

		// -----DUPLICA O TAMANHO DO VECTOR------------
		if (contador == telemoveis.length) {
			Telemovel[] tmp = new Telemovel[telemoveis.length * 2];
			for (int i = 0; i < telemoveis.length; i++) {
				tmp[i] = telemoveis[i];
			}
			telemoveis = tmp;
		}
		// --------VERIFICA SE O TELEMOVEL EXISTE-----------
		for (int j = 0; j < contador; j++) {
			if (t.equals(telemoveis[j].obterNumTel())) {
				existeTelemovel = true;
			} else {
				existeTelemovel = false;
			}
		}
		// -------SE O TELEMOVEL NåO EXISTE -> é CRIADO-----------
		if (existeTelemovel == false) {
			telemoveis[contador] = t;
			contador++;
			return true;
		}
		// -------------RETORNA SE O TELEMOVEL JA EXISTE------------
		return false;
	}

	// ---------------ITERADOR------------------------------
	public void initializeIterator() {
		if (contador > 0)
			telemovelCorrente = 0;
		else
			telemovelCorrente = -1;
	}

	public boolean hasNext() {
		return ((telemovelCorrente >= 0) && (telemovelCorrente < contador));
	}

	public Telemovel next() {
		Telemovel t = null;
		if (this.hasNext())
			t = telemoveis[telemovelCorrente++];
		return t;

	}
	//--RETORNA TELEMOVEL, SE EXISTIR--
	public Telemovel obterTelemovel(int num) {
		for (int i = 0; i < contador; i++) {
			if (telemoveis[i].obterNumTel() == num)
				return telemoveis[i];
		}
		return null;
	}
	//--RETORNA O NUMERO DE TELEMOVEIS--
	public int obterQuantidade() {
		return contador;
	}
	//--RETORNA A DURACAO DA CHAMADA MAXIMA--
	public String obterTopTagarela() {
		int top_chamada = 0;
		int top_index = 0;
		for (int i = 0; i < contador; i++) {
			if (telemoveis[i].obterDuracaoChamadas() > top_chamada) {
				top_chamada = telemoveis[i].obterDuracaoChamadas();
				top_index = i;
			}
		}

		return (telemoveis[top_index].obterNumTel() + " "
				+ telemoveis[top_index].obterRede() + " "
				+ telemoveis[top_index].obterNomeUtil() + " "
				+ telemoveis[top_index].obterLoc() + " " + telemoveis[top_index]
				.obterDuracaoChamadas());
	}

}
