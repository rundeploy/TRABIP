package ip;

/*@developer Cristian Mitul, n¼33876 , P2
 *@docente	 Miguel Domingues 
 */
public class Localizacao {
	private int grausY;
	private int minY;
	private int segY;
	private String y;
	private int grausX;
	private int minX;
	private int segX;
	private String x;

	// --CONSTRUCTOR--
	public Localizacao(int grausY, int minY, int segY, String y, int grausX,
			int minX, int segX, String x) {
		this.grausY = grausY;
		this.minY = minY;
		this.segY = segY;
		this.y = y;

		this.grausX = grausX;
		this.minX = minX;
		this.segX = segX;
		this.x = x;

	}

	// --GETTERS--
	// --TRANSFORMA A INFO NUMA STRING--
	public String toString() {
		return (grausY + " " + minY + " " + segY + " " + y + " " + grausX + " "
				+ minX + " " + segX + " " + x + " ");
	}

	public int obterGrausY() {
		return grausY;
	}

	public int obterGrausX() {
		return grausX;
	}

	public int obterMinutosY() {
		return minY;
	}

	public int obterMinutosX() {
		return minX;
	}

	public int obterSegundosY() {
		return segY;
	}

	public int obterSegundosX() {
		return segX;
	}

	// --RETORNA LATITUDE--
	public String obterY() {
		return y;
	}

	// --RETORNA LONGITUDE--
	public String obterX() {
		return x;
	}

	// ------SETTERS----
	public void modificarGrausY(int grausY) {
		this.grausY = grausY;
	}

	public void modificarGrausX(int grausX) {
		this.grausX = grausX;
	}

	public void modificarMinutosY(int minY) {
		this.minY = minY;
	}

	public void modificarMinutosX(int minX) {
		this.minX = minX;
	}

	public void modificarSegundosY(int segY) {
		this.segY = segY;
	}

	public void modificarSegundosX(int segX) {
		this.segX = segX;
	}

	// --MODIFICA LATITUDE--
	public void modificarLatitude(String y) {
		this.y = y;
	}

	// --MODIFICA LONGITUDE--
	public void modificarLongitude(String x) {
		this.x = x;
	}

	// --CALCULA A DISTANCIA ENTRE 2 PONTOS--
	public double calcularDistancia(Localizacao outra) {
		double coordX = this.obterCoordX();
		double coordY = this.obterCoordY();
		double coordXoutra = outra.obterCoordX();
		double coordYoutra = outra.obterCoordY();
		return Math.sqrt(Math.pow(coordX - coordXoutra, 2)
				+ Math.pow(coordY - coordYoutra, 2));
		}
	//--RETORNA COORDENADA X NEGATIVA SE -> SUL
	private double obterCoordX() {
		double coordX = segX + 60 * minX + 3600 * grausX;
		if (x.equals("S")) {
			coordX = -coordX;
		}
		return coordX;
	}
	//--RETORNA COORDENADA Y NEGATIVA SE -> WEST
	public double obterCoordY() {

		double coordY = segY + 60 * minY + 3600 * grausY;
		if (y.equals("W")) {
			coordY = -coordY;
		}
		return coordY;
	}

}
