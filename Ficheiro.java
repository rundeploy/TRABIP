package ip;

/*@developer Cristian Mitul, n¼33876 , P2
 *@docente	 Miguel Domingues 
 */
public class Ficheiro {
	public static final int COMANDOS = 10;

	private String comandos[];
	private int contador;
	private int numerodeComandos;
	//--CONSTRUCTOR--
	public Ficheiro() {
		contador = 0;
		numerodeComandos = 0;
		comandos = new String[COMANDOS];
	}
	//--GUARDA OS COMANDOS--
	public void guardarArgumento(String argumento) {
		if (contador == comandos.length) {
			duplicaTamVector();
		}

		comandos[contador] = argumento;
		contador++;
	}

	public void storeArgumento(double x) {
		String argument = "" + x;
		if (contador == comandos.length) {
			duplicaTamVector();
		}
		comandos[contador] = argument;
		contador++;
	}

	public void storeCommand(String comando) {
		guardarArgumento(comando);
		numerodeComandos++;
	}

	private void duplicaTamVector() {
		String[] tmp = new String[comandos.length * 2];
		for (int i = 0; i < contador; i++) {
			tmp[i] = comandos[i];
		}
		comandos = tmp;
	}

	public int obterNumerComandos() {
		return numerodeComandos;
	}

	public int obterNumerStrings() {
		return contador;
	}

	public String getString(int index) {
		return comandos[index];
	}
}
