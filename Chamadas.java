package ip;

/*@developer Cristian Mitul, n¼33876 , P2
 *@docente	 Miguel Domingues 
 */
public class Chamadas {
	public static final int CELULAS = 5;
	private boolean existeChamada;
	private int contador;
	private int chamadaCorrente;
	private Chamada[] chamadas;
	//-----Construtor-----
	public Chamadas() {
		contador = 0;
		chamadas = new Chamada[CELULAS];
	}
	public void terminarChamada(int numero){
		int index = searchIndex(numero);
		chamadas[index].terminarChamada();
		existeChamada=false;
	}
	private int searchIndex(int numero){
			for (int i = 0; i<=contador; i++){
			if (chamadas[i].obterNumTelFin().obterNumTel() == numero || chamadas[i].obterNumTelIni().obterNumTel() == numero)
				return i;
		}
			return -1;
	}
	// -------GUARDA CHAMADA------
	public boolean inicializarChamada(Chamada cham) {
		existeChamada = false;

		// -----DUPLICA O TAMANHO DO VECTOR-----
		if (contador == chamadas.length) {
			Chamada[] tmp = new Chamada[chamadas.length * 2];
			for (int i = 0; i < chamadas.length; i++) {
				tmp[i] = chamadas[i];
			}
			chamadas = tmp;
		}
		// ---VERIFICA SE A CHAMADA é POSSIVEL-----
		for (int j = 0; j < contador; j++) {
			if (cham.equals(chamadas[j].obterEstadoChamada())) {
				existeChamada = true;
			} else {
				existeChamada = false;
			}
		}
		// --SE A CHAMADA NåO EXISTE -> é POSSIVEL LIGAR--
		if (existeChamada == false) {
			chamadas[contador] = cham;
			contador++;
			return true;
		}
		// ---RETORNA SE CHAMADA JA EXISTE---
		return false;
	}

	// -------ITERADOR----------
	public void initializeIterator() {
		if (contador > 0)
			chamadaCorrente = 0;
		else
			chamadaCorrente = -1;
	}

	public boolean hasNext() {
		return ((chamadaCorrente >= 0) && (chamadaCorrente < contador));
	}

	public Chamada next() {
		Chamada cham = null;
		if (this.hasNext())
			cham = chamadas[chamadaCorrente++];
		return cham;

	}

	// ---AUMENTAR A DURACAO DAS CHAMADAS-----
	public void aumentaDuracao(int tempo) {
		for (int i = 0; i < contador; i++) {
			chamadas[i].aumentaDuracao(tempo);
		}
	}
	//---OBTER A DURACAO DE UM TELEMOVEL---
	public int obterDuracao(int num) {
		int duracao=0;
		for (int i = 0; i < contador; i++) {
			if (chamadas[i].obterNumTelFin().obterNumTel()==num || chamadas[i].obterNumTelIni().obterNumTel()==num)
			duracao = chamadas[i].obterDuracao();
		}
		return duracao;
	}
	
	


}
