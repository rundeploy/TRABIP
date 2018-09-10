package ip;

/*@developer Cristian Mitul, n¼33876 , P2
 *@docente	 Miguel Domingues 
 */
public class Telemovel {
	private String rede;
	private int numtel;
	private String nomeutilizador;
	private Localizacao loc;
	private int estado;
	public static final int LIGADOLIVRE = 1;
	public static final int LIGADOOCUPADO = 2;
	public static final int DESLIGADO = 3;
	private int duracaoChamadas;

	// --CONSTRUCTOR--
	public Telemovel(String rede, int numtel, String nomeutilizador,
			Localizacao loc) {
		this.rede = rede;
		this.numtel = numtel;
		this.nomeutilizador = nomeutilizador;
		this.loc = loc;
		estado = DESLIGADO;
		this.duracaoChamadas = 0;
	}
	//--GETTERS--
	public int obterDuracaoChamadas() {
		return duracaoChamadas;
	}

	public void incDuracaoTotal(int incremento) {
		duracaoChamadas += incremento;
	}

	public String obterRede() {
		return rede;
	}

	public int obterNumTel() {
		return numtel;
	}

	public String obterNomeUtil() {
		return nomeutilizador;
	}

	public Localizacao obterLoc() {
		return loc;
	}

	public int obterEstado() {
		return estado;
	}
	//----------------
	//--TRANSOFRAM TUDO PARA STRING
	public String toString() {
		return (numtel + " " + rede + " " + nomeutilizador + " " + loc);
	}
	//--MODIFICA A LOCALIZACAO--
	public void modificarLocTel(Localizacao loc) {
		this.loc = loc;
	}
	//--MODIFICA O ESTADO DO TELEM--
	public void modificarEstado(int estado) {
		this.estado = estado;

	}
	//--RETORNA SE ESTA EM CONVERSACAO
	public boolean ocupado() {
		return estado == LIGADOOCUPADO;
	}
	//--RETORNA SE ESTA DESLIGADO
	public boolean desligado() {
		return estado == DESLIGADO;
	}
	//--RETORNA SE NAO ESTA EM CONVERSACAO
	public boolean livre() {
		return estado == LIGADOLIVRE;
	}
	//--RETORNA A LOCALIZACAO--
	public Localizacao obterLocalizacao() {
		return loc;
	}
}
