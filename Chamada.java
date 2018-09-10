package ip;

/*@developer Cristian Mitul, n¼33876 , P2
 *@docente	 Miguel Domingues 
 */
public class Chamada {
	private Telemovel telini;
	private Telemovel telfin;
	private int duracao;
	private int tempoInic;
	private boolean chamadaTerminada;
	//--CONSTRUCTOR--
	public Chamada(Telemovel telini, Telemovel telfin, int tempoInic) {
		this.telini = telini;
		this.telfin = telfin;
		this.tempoInic=tempoInic;
		chamadaTerminada=false;
		duracao=0;
	}
	//OBTER O INSTANTE EM QUE FIZEMOS A CHAMADA
	public int obterTempoInic(){
		return tempoInic;
	}
	//--OBTER O NUMERO DO QUAL LIGAMOS--
	public Telemovel obterNumTelIni() {
		return telini;
	}
	//--OBTER O NUMERO AO QUAL LIGAMOS--
	public Telemovel obterNumTelFin() {
		return telfin;
	}
	//--OBTER A DURACAO DA CHAMADA
	public int obterDuracao() {
		return duracao;
	}
	//--AUMENTAR A DURACAO DA CHAMADA--
	public void aumentaDuracao(int tempo) {
		if(!chamadaTerminada)
			duracao+=tempo;
	}
	//--OBTER O ESTADO DA CHAMADA--
	public boolean obterEstadoChamada(){
		return chamadaTerminada;
	}
	//--TERMINAR A CHAMADA--
	public void terminarChamada() {
		chamadaTerminada = true;
		telini.incDuracaoTotal(duracao);
		telfin.incDuracaoTotal(duracao);
		telini.modificarEstado(Telemovel.LIGADOLIVRE);
		telfin.modificarEstado(Telemovel.LIGADOLIVRE);
	}
	
	public String toString(){
		return (telini + " " + telfin);
	}

}
