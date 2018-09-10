package ip;

/*@developer Cristian Mitul, n¼33876 , P2
 *@docente	 Miguel Domingues 
 */

public class Simulador {

	Torres torres = new Torres();
	Telemoveis telemoveis = new Telemoveis();
	Chamadas chamadas = new Chamadas();
	private int tempoglobal;

	// ------------------CRIAR TORRE------------------
	public boolean criarTorre(String rede, int grausY, int minY, int segY,
			String y, int grausX, int minX, int segX, String x, int alcance,
			int capacidade) {
		Localizacao loc = new Localizacao(grausY, minY, segY, y, grausX, minX,
				segX, x);
		Torre novaTorre = new Torre(rede, loc, alcance, capacidade);

		telemoveis.initializeIterator();
		while (telemoveis.hasNext()) {
			Telemovel telem = telemoveis.next();
			Localizacao locTelemvel = telem.obterLocalizacao();
			double dist = locTelemvel.calcularDistancia(loc);
			if (dist <= novaTorre.obterAlcance()
					&& rede.equals(telem.obterRede())) {
				telem.modificarEstado(Telemovel.LIGADOLIVRE);
			}
		}

		return torres.guardarTorre(novaTorre);
	}

	// ------------------LISTAR AS TORRES-------------------
	public String listarTorres() {
		String list = "";
		torres.initializeIterator();
		while (torres.hasNext()) {
			list += torres.next().toString() + "\n";
		}
		return list;
	}

	// ------------------CRIAR TELEMOVEL-----------------------
	public boolean criarTelemovel(String rede, int numero, String nome,
			int grausY, int minY, int segY, String y, int grausX, int minX,
			int segX, String x) {
		Localizacao loc = new Localizacao(grausY, minY, segY, y, grausX, minX,
				segX, x);
		Telemovel novoTelemovel = new Telemovel(rede, numero, nome, loc);
		torres.initializeIterator();
		while (torres.hasNext()) {
			Torre t = torres.next();
			Localizacao locTorre = t.obterLocalizacao();
			double dist = locTorre.calcularDistancia(loc);
			if (dist <= t.obterAlcance() && rede.equals(t.obterRede())) {
				novoTelemovel.modificarEstado(Telemovel.LIGADOLIVRE);
			}
		}
		return telemoveis.guardarTelemovel(novoTelemovel);
	}

	// ------------------LISTAR OS TELEMOVEIS-------------------
	public String listarTelemoveis() {
		String list = "";
		telemoveis.initializeIterator();
		while (telemoveis.hasNext()) {
			list += telemoveis.next().toString() + "\n";
		}

		return list;
	}

	public String obterTopTagarela() {
		return telemoveis.obterTopTagarela();
	}

	// ---------MANIPULACAO DO TEMPO--------
	public int ticTac(int tempo) {
		tempoglobal += tempo;
		chamadas.aumentaDuracao(tempo);
		return tempoglobal;
	}

	// ---------OBTER O TEMPO GLOBAL--------
	public int obterTempoGlobal() {
		return tempoglobal;
	}

	// -------------INICIAR A CHAMADA------------
	public void iniciarChamada(int numeroInicInt, int numeroRecebInt) {
		Telemovel inic = telemoveis.obterTelemovel(numeroInicInt);
		Telemovel receb = telemoveis.obterTelemovel(numeroRecebInt);
		if (inic.obterEstado() == Telemovel.LIGADOLIVRE
				&& receb.obterEstado() == Telemovel.LIGADOLIVRE) {
			Chamada novaChamada = new Chamada(inic, receb, tempoglobal);
			chamadas.inicializarChamada(novaChamada);
			inic.modificarEstado(Telemovel.LIGADOOCUPADO);
			receb.modificarEstado(Telemovel.LIGADOOCUPADO);
		}

	}

	// -----------TERMINA A CHAMADA------
	public void terminarChamada(int numero) {
		chamadas.terminarChamada(numero);
	}

	// --------LISTAR AS CHAMADAS-------
	public String listarChamadas(int tempInic, int tempFin) {
		String list = "";
		chamadas.initializeIterator();
		while (chamadas.hasNext()) {
			Chamada c = chamadas.next();
			if (c.obterTempoInic() >= tempInic && c.obterTempoInic() <= tempFin) {
				int durFinal = c.obterTempoInic() + c.obterDuracao();
				list += c.obterNumTelIni().obterNumTel() + " "
						+ c.obterNumTelFin().obterNumTel() + " "
						+ c.obterTempoInic() + " " + durFinal + "\n";
			}
		}
		return list;
	}

	// --------LISTAR AS REDES-------
	public String listarOperadora(String rede) {
		String list = "";
		torres.initializeIterator();
		while (torres.hasNext()) {
			Torre t = torres.next();
			if (t.obterRede().equals(rede)) {
				list += t.obterRede() + " " + t.obterLocalizacao() + " "
						+ t.obterAlcance() + " " + t.oberCpacidade() + "\n";
			}

		}
		telemoveis.initializeIterator();
		while (telemoveis.hasNext()) {
			Telemovel tel = telemoveis.next();
			if (tel.obterRede().equals(rede)) {
				list += +tel.obterNumTel() + " " + tel.obterRede() + " "
						+ tel.obterNomeUtil() + " " + tel.obterLoc() + " "
						+ tel.obterDuracaoChamadas() + "\n";
			}
		}
		return list;

	}

	// ------VER SE O TELEMOVEL JA FOI CRIADO-------
	public Telemovel obterTelemovel(int num) {
		return telemoveis.obterTelemovel(num);
	}

	// ---OBTER O NUMERO DE TELEMOVEIS CRIADOS---
	public int numTelemoveis() {
		return telemoveis.obterQuantidade();
	}

	// ---INICIAR A NOVA SIMULACAO---
	public void novaSimulacao() {
		torres = new Torres();
		telemoveis = new Telemoveis();
		chamadas = new Chamadas();
		tempoglobal = 0;
	}

	public boolean existeTelemovel(int numeroInt) {
		if (telemoveis.obterTelemovel(numeroInt)==null)
			return false;
		else
			return true;
	}

}
