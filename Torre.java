package ip;

/*@developer Cristian Mitul, n¼33876 , P2
 *@docente	 Miguel Domingues 
 */
public class Torre {
	private String rede;
	private Localizacao loc;
	private int alcance;
	private int capacidade;
	//--CONSTRUCTOR--
	public Torre(String rede, Localizacao loc, int alcance, int capacidade) {
		this.rede = rede;
		this.loc = loc;
		this.alcance = alcance;
		this.capacidade = capacidade;
	}
	//--RETORNA REDE--
	public String obterRede(){
		return rede;
	}
	//--RETORNA LOCALIZACAO--
	public Localizacao obterLocalizacao() {
		return loc;
	}
	//--RETORNA ALCANCE--
	public int obterAlcance(){
		return alcance;
	}
	//--RETORNA CAPACIDADE--
	public int oberCpacidade(){
		return capacidade;
	}
	//--TRANSFORMA A INFO NUMA STRING--
	public String toString(){
		return (rede + " " + loc + "" + alcance + " " + capacidade);
	}
	
}
