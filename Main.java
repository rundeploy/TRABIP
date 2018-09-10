package ip;

import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileReader;

/*@developer Cristian Mitul, n¼33876 , P2
 *@docente	 Miguel Domingues 
 */
public class Main {
	//--COMANDOS
	public static final String NOVA = "Nova";
	public static final String CARREGA = "Carrega";
	public static final String GRAVA = "Grava";
	public static final String NOVA_TORRE = "NovaTorre";
	public static final String NOVO_TELEMOVEL = "NovoTelemovel";
	public static final String MOVE_TELEMOVEL = "MoveTelemovel";
	public static final String INICIA_CHAMADA = "IniciaChamada";
	public static final String TERMINA_CHAMADA = "TerminaChamada";
	public static final String TIC_TAC = "TicTac";
	public static final String LISTA_TORRES = "ListaTorres";
	public static final String LISTA_TELEMOVEIS = "ListaTelemoveis";
	public static final String LISTA_CHAMADAS = "ListaChamadas";
	public static final String TOP_TAGARELA = "ListaTopTagarela";
	public static final String LISTA_OPERADORA = "ListaOperadora";
	public static final String AJUDA = "Ajuda";
	public static final String SAIR = "Sair";

	//--INFO DOS COMANDOS
	public static final String SIM_INIC = "Simulacao iniciada.";
	public static final String SIM_CARREG = "Simulacao carregada.";
	public static final String SIM_GRAV = "Simulacao gravada com sucesso.";
	public static final String TORR_ADIC = "Torre adicionada com sucesso.";
	public static final String TEL_ADIC = "Telemovel adicionado com sucesso.";
	public static final String TEL_MOV = "Telemovel movido para ";
	public static final String LIG_SUC = "Ligacao bem sucedida no instante: ";
	public static final String CHAM_TERMIN1 = "Chamada terminada ao fim de ";
	public static final String CHAM_TERMIN2 = " segundos.";
	public static final String ACT_TEMP = "Tempo actual: ";
	public static final String ZERO_TORR = "0 torres";
	public static final String ATE_BREVE = "Ate breve!";
	public static final String COM_EXIST = "Comandos existentes:";

	//--MENSAGENS DE ERRO
	public static final String ERR_LEIT = "Erro na leitura do ficheiro.";
	public static final String ERR_GRAV = "Erro na gravacao da simulacao.";
	public static final String ERR_TORR = "Erro na cria‹o da torre.";
	public static final String ERR_TEL = "Erro na cria‹o do telemovel.";
	public static final String NUM_INEXIST = "Numero do telemovel inexistente.";
	public static final String CHAM_PERD = "Chamada perdida ao fim de segundos.";
	public static final String NUM_INEXIST_X = "Numero inexistente ";
	public static final String NUM_OCUP_X = "Numero ocupado ";
	public static final String RED_INDIS_X = "rede indisponivel para o numero ";
	public static final String TEL_N_ENVOL = "Telefone n‹o estava envolvido em nenhuma chamada.";
	public static final String COM_INEXIST = "Comando n‹o existe ";

	public static final String MESM_NUM = "Impossivel ligar para o mesmo numero";
	public static final String ZERO_TEL = "0 telemoveis.";
	public static final String ERR_MOV = "Dados de movimentacao invalidos";
	//--AS DIRECCOES NORTE;ESTE;OESTE;SUL
	public static final String N = "N";
	public static final String S = "S";
	public static final String E = "E";
	public static final String W = "W";

	public static void main(String[] args) throws Exception {
		// leitura da consola
		Scanner in = new Scanner(System.in);
		Simulador s = new Simulador();
		Ficheiro fich = new Ficheiro();
		String comando;
		boolean exit = false;

		while (!exit) {
			comando = obterComando(in);

			// nova simulacao
			if (comando.equals(NOVA)) {
				s.novaSimulacao();
				System.out.println(SIM_INIC);
			}
			// se o comando introduzido for "Sair"
			else if (comando.equals(SAIR)) {
				System.out.println(ATE_BREVE);
				exit = true;
			}
			// ajuda
			else if (comando.equals(AJUDA)) {
				System.out.println(COM_EXIST);
				listarComandos();
			}
			// carregar do ficheiro
			else if (comando.equals(CARREGA)) {
				lerFich(s, in, fich);
				System.out.println(SIM_CARREG);
			}
			// gravar no ficheiro
			else if (comando.equals(GRAVA)) {
				String ficheiro = in.nextLine();
				guardarFich(ficheiro, fich);
				System.out.println(SIM_GRAV);
			}
			// nova torre
			else if (comando.equals(NOVA_TORRE)) {
				criarTorre(s, in);
			}
			// novo telemovel
			else if (comando.equals(NOVO_TELEMOVEL)) {
				criarTelemovel(s, in);
			}
			// mover telemovel
			else if (comando.equals(MOVE_TELEMOVEL)) {
				moverTelemovel(s, in);
				System.out.println(TEL_MOV);
			}
			// iniciar chamada
			else if (comando.equals(INICIA_CHAMADA)) {
				iniciarChamada(s, in);
			}
			// terminar chamada
			else if (comando.equals(TERMINA_CHAMADA)) {
				terminarChamada(s, in);
			}
			// passagem do tempo
			else if (comando.equals(TIC_TAC)) {
				System.out.println(ticTac(s, in));
			}
			// listar torres
			else if (comando.equals(LISTA_TORRES)) {
				System.out.println(s.listarTorres());
			}
			// listar telemoveis
			else if (comando.equals(LISTA_TELEMOVEIS)) {
				if (s.numTelemoveis() == 0)
					System.out.println(ZERO_TEL);
				else
					System.out.println(s.listarTelemoveis());
			}
			// listar chamadas
			else if (comando.equals(LISTA_CHAMADAS)) {
				listarChamadas(s, in);
			}
			// mostrar quem falou mais tempo
			else if (comando.equals(TOP_TAGARELA)) {
				System.out.println(s.obterTopTagarela());
			}
			// listar operadoras
			else if (comando.equals(LISTA_OPERADORA)) {
				listarOperadora(s, in);
			}
			// se o comando introduzido nao existir
			else {
				System.out.println(COM_INEXIST);
			}

		}
	}

	// ----------------------LISTAGEM DOS COMANDOS-----------------
	private static void listarComandos() {
		System.out.println(NOVA);
		System.out.println(CARREGA + " ficheiro");
		System.out.println(GRAVA + " ficheiro");
		System.out.println(NOVA_TORRE + " rede localizacao alcance capacidade");
		System.out.println(NOVO_TELEMOVEL + " nome rede numero localizacao");
		System.out.println(MOVE_TELEMOVEL + " numero deslocamento");
		System.out.println(INICIA_CHAMADA + " chamador chamado");
		System.out.println(TERMINA_CHAMADA + " numero");
		System.out.println(TIC_TAC + " tempo");
		System.out.println(LISTA_TORRES);
		System.out.println(LISTA_TELEMOVEIS);
		System.out.println(LISTA_CHAMADAS + " inicial final");
		System.out.println(TOP_TAGARELA);
		System.out.println(LISTA_OPERADORA);
		System.out.println(AJUDA);
		System.out.println(SAIR);

	}

	// --------------LE O COMANDO E RETORNA-O NO WHILE DE CIMA---------
	private static String obterComando(Scanner in) {
		String input = "NULL";
		System.out.print("> ");
		input = in.nextLine(); // guardamos o comando inserido
		return input;
	}

	// ---------------------------CRIAR A TORRE---------------------------
	private static void criarTorre(Simulador simul, Scanner in) {
		String rede = in.nextLine();
		String grausY = in.next();
		String minY = in.next();
		String segY = in.next();
		String y = in.next();
		String grausX = in.next();
		String minX = in.next();
		String segX = in.next();
		String x = in.next();
		in.nextLine();
		String alcance = in.next();
		String capacidade = in.next();
		in.nextLine();
		// ---------CONVERSAO DAS STRING PARA INTEIRO-------
		try {
			int grausYint = Integer.parseInt(grausY);
			int minYint = Integer.parseInt(minY);
			int segYint = Integer.parseInt(segY);
			int grausXint = Integer.parseInt(grausX);
			int minXint = Integer.parseInt(minX);
			int segXint = Integer.parseInt(segX);
			int alcanceInt = Integer.parseInt(alcance);
			int capacidadeInt = Integer.parseInt(capacidade);

			// ----SE O UTILIZADOR INTRODUZIR UM DADO INVALIDO--------
			if (rede.equals("") || grausYint < 0 || grausYint > 90
					|| minYint < 0 || minYint > 90 || segYint < 0
					|| segYint > 90 || grausXint < 0 || grausXint > 180
					|| minXint < 0 || minXint > 180 || segXint < 0
					|| segXint > 180 || (!y.equals(N) && !y.equals(S))
					|| (!x.equals(W) && !x.equals(E)) || alcanceInt <= 0
					|| capacidadeInt <= 0) {
				System.out.println(ERR_TORR);
			} else {
				// --SE PASSAR TODAS AS CONDICOES ANTERIORES -> CRIA A TORRE--
				if (simul.criarTorre(rede, grausYint, minYint, segYint, y,
						grausXint, minXint, segXint, x, alcanceInt,
						capacidadeInt)) {
					System.out.println(TORR_ADIC);
				} else {
					System.out.println(ERR_TORR);
				}
			}
			// -------SE OCORRER ALGUM ERRO NO TRY -> DEVOLVE ERRO-------------
		} catch (NumberFormatException e) {
			System.out.println(ERR_TORR);
		}

	}

	// --------------------------CRIAR TELEMOVEL----------------
	private static void criarTelemovel(Simulador simul, Scanner in) {
		String rede = in.nextLine();
		String numero = in.next();
		in.nextLine();
		String utilizador = in.nextLine();
		String grausY = in.next();
		String minY = in.next();
		String segY = in.next();
		String y = in.next();
		String grausX = in.next();
		String minX = in.next();
		String segX = in.next();
		String x = in.next();
		in.nextLine();
		// ------CONVERSAO DAS STRING PARA INTEIRO-------
		try {
			int numeroInt = Integer.parseInt(numero);
			int grausYint = Integer.parseInt(grausY);
			int minYint = Integer.parseInt(minY);
			int segYint = Integer.parseInt(segY);
			int grausXint = Integer.parseInt(grausX);
			int minXint = Integer.parseInt(minX);
			int segXint = Integer.parseInt(segX);
			// ---SE O UTILIZADOR INTRODUZIR UM DADO INVALIDO-------
			if (rede.equals("") || numeroInt < 100000000
					|| numeroInt > 999999999 || utilizador.equals("")
					|| grausYint < 0 || grausYint > 90 || minYint < 0
					|| minYint > 90 || segYint < 0 || segYint > 90
					|| grausXint < 0 || grausXint > 180 || minXint < 0
					|| minXint > 180 || segXint < 0 || segXint > 180
					|| (!y.equals(N) && !y.equals(S))
					|| (!x.equals(W) && !x.equals(E))) {
				System.out.println(ERR_TEL);
			} else {
				// ---SE PASSAR TODAS AS CONDICOES ANTERIORES -> CRIA O
				// TELEMOVEL--
				if (simul.criarTelemovel(rede, numeroInt, utilizador,
						grausYint, minYint, segYint, y, grausXint, minXint,
						segXint, x)) {
					System.out.println(TEL_ADIC);
				} else {
					System.out.println(ERR_TEL);
				}
			}
			// ----SE OCORRER ALGUM ERRO NO TRY -> DEVOLVE ERRO------
		} catch (NumberFormatException e) {
			System.out.println(ERR_TEL);
		}
	}

	// ------------------MANIPULARCAO DO TEMPO-----------------
	private static String ticTac(Simulador simul, Scanner in) {
		int tempo = in.nextInt();
		tempo = simul.ticTac(tempo);
		in.nextLine();
		return ACT_TEMP + tempo;
	}

	// ------------------------INICIAR A CHAMADA-----------------
	private static void iniciarChamada(Simulador simul, Scanner in) {
		String numeroInic = in.next();
		String numeroReceb = in.next();
		in.nextLine();
		try {
			int numeroInicInt = Integer.parseInt(numeroInic);
			int numeroRecebInt = Integer.parseInt(numeroReceb);

			if (numeroInicInt < 100000000 || numeroInicInt > 999999999
					|| numeroRecebInt < 100000000 || numeroRecebInt > 999999999) {
				System.out.println(NUM_INEXIST_X);
			} else if (numeroInicInt == numeroRecebInt) {
				System.out.println(MESM_NUM);
			} else if (simul.obterTelemovel(numeroInicInt) == null) {
				System.out.println(NUM_INEXIST_X);
			} else if (simul.obterTelemovel(numeroRecebInt) == null) {
				System.out.println(NUM_INEXIST_X);
			} else if (simul.obterTelemovel(numeroInicInt).ocupado()) {
				System.out.println(NUM_OCUP_X + numeroInicInt);
				if (simul.obterTelemovel(numeroRecebInt).ocupado()) {
					System.out.println(NUM_OCUP_X + numeroRecebInt);
				}
			} else if (simul.obterTelemovel(numeroInicInt).desligado()) {
				System.out.println(RED_INDIS_X + numeroInicInt);
			} else if (simul.obterTelemovel(numeroRecebInt).ocupado()) {
				System.out.println(NUM_OCUP_X + numeroRecebInt);
				if (simul.obterTelemovel(numeroInicInt).ocupado()) {
					System.out.println(NUM_OCUP_X + numeroInicInt);
				}
			} else if (simul.obterTelemovel(numeroRecebInt).desligado()) {
				System.out.println(RED_INDIS_X + numeroRecebInt);
			} else {
				simul.iniciarChamada(numeroInicInt, numeroRecebInt);
				System.out.println(LIG_SUC + simul.obterTempoGlobal());
			}
		} catch (NumberFormatException e) {
			System.out.println(NUM_INEXIST_X);
		}
	}

	// ---------------TERMINAR A CHAMADA-----------
	private static void terminarChamada(Simulador simul, Scanner in) {
		String numero = in.next();
		in.nextLine();
		try {
			int numeroInt = Integer.parseInt(numero);

			if (simul.obterTelemovel(numeroInt) == null) {
				System.out.println(NUM_INEXIST_X);
			} else if (simul.obterTelemovel(numeroInt).livre()) {
				System.out.println(TEL_N_ENVOL);
			} else {
				simul.terminarChamada(numeroInt);
				System.out
						.println(CHAM_TERMIN1
								+ simul.chamadas.obterDuracao(numeroInt)
								+ CHAM_TERMIN2);
			}
		} catch (NumberFormatException e) {
			System.out.println(ERR_TEL);
		}
	}

	// --------------LISTAR CHAMADAS--------------
	private static void listarChamadas(Simulador simul, Scanner in) {
		int tempInic = in.nextInt();
		int tempFin = in.nextInt();
		in.nextLine();
		System.out.println(simul.listarChamadas(tempInic, tempFin));
	}

	// ---------LISTAR OPERADORAS--------
	private static void listarOperadora(Simulador simul, Scanner in) {
		String rede = in.nextLine();
		System.out.println(simul.listarOperadora(rede));
	}

	// -----------GUARDAR NUM FICHEIRO-----
	public static void guardarFich(String filename, Ficheiro fich)
			throws Exception {
		PrintWriter out = new PrintWriter(filename);
		out.println(fich.obterNumerComandos());
		int scriptStr = fich.obterNumerStrings();
		for (int i = 0; i < scriptStr; i++) {
			out.println(fich.getString(i));
		}
		out.close();
	}
	// -----------LER DUM FICHEIRO-----
	private static void lerFich(Simulador simulad, Scanner in, Ficheiro fich)
			throws Exception {
		simulad.novaSimulacao();

		String nomdoFich = in.nextLine();
		FileReader fr = new FileReader(nomdoFich);
		Scanner file = new Scanner(fr);
		int numerodeComandos = file.nextInt();
		file.nextLine();
		String comando = "";

		for (int i = 0; i < numerodeComandos; i++) {
			comando = file.nextLine();
			if (comando.equals(NOVA_TORRE)) {
				criarTorre(simulad, in);
			} else if (comando.equals(NOVO_TELEMOVEL)) {
				criarTelemovel(simulad, in);
			} else if (comando.equals(MOVE_TELEMOVEL)) {

			} else if (comando.equals(INICIA_CHAMADA)) {
				iniciarChamada(simulad, in);
			} else if (comando.equals(TIC_TAC)) {
				ticTac(simulad, in);
			} else if (comando.equals(TERMINA_CHAMADA)) {
				terminarChamada(simulad, in);
			}
		}
	}
	//--DESLOCACAO DO TELEMOVEL--
	private static void moverTelemovel(Simulador simul, Scanner in) {
		String numero = in.next();
		String segY = in.next();
		String y = in.next();
		String segX = in.next();
		String x = in.next();
		in.nextLine();
		try {
			int numeroInt = Integer.parseInt(numero);
			int segYint = Integer.parseInt(segY);
			int segXint = Integer.parseInt(segX);
			
			if (numeroInt < 100000000 || numeroInt > 999999999) {
				System.out.println(NUM_INEXIST_X);
				if (!simul.existeTelemovel(numeroInt)) {
					System.out.println(NUM_INEXIST);}
				
			} else if (segYint < 0 || segXint < 0
					|| (!y.equals(N) && !y.equals(S))
					|| (!x.equals(W) && !x.equals(E))) {
				System.out.println(ERR_MOV);
				
			} else if (simul.obterTelemovel(numeroInt).livre()
					|| simul.obterTelemovel(numeroInt).desligado()) {
				// se estiver livre ou desligado muda de localizacao somente
				// ou seja se nao estiver envolvido em nenhuma chamada
			} else if (simul.obterTelemovel(numeroInt).ocupado()) {
				// se estiver em conversacao tenho de verificar se esta dentro
				// do alcance da torre
			}

		} catch (NumberFormatException e) {
			System.out.println(ERR_TORR);
		}
	}
}
