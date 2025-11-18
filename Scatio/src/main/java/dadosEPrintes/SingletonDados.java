package dadosEPrintes;

public class SingletonDados {

    private static SingletonDados uniqueInstance;
    private static String pastaDados;
    private String nomeSitio;
    private String emailSitio;
    private String senhaSitio;

    private SingletonDados(){}

    public static String conferirNomeSitio(String nomeSitioAtual, String nomeSitioNovo) {
        System.out.println("Chegou!-!");
        boolean certo = true;

        for (char c: nomeSitioNovo.toCharArray()) {
            if (c == ' ' || c == '@') {
                certo = false;
                break;
            }
        }

        if (nomeSitioNovo.length() < 5) certo = false;

        Printes.espaco();

        if (certo) {
            System.out.println("Chegou!-!1");
            return nomeSitioNovo;
        } else {
            System.out.println("Chegou!-!2");
            System.out.println("--> O NOME PRECISA DE PELO MENOS 5 CARACTERES E NÃO PODE TER ESPAÇOS EM BRANCOS OU @.");
            return nomeSitioAtual;
        }
    }

    public static String conferiremailSitio(String emailSitioAtual, String emailSitioNovo) {
        boolean certo = false;

        for (char c: emailSitioNovo.strip().toCharArray()) {
            if (c == '@') {
                certo = true;
                break;
            }
        }

        for (char c: emailSitioNovo.strip().toCharArray()) {
            if (c == ' ') {
                certo = false;
                break;
            }
        }

        Printes.espaco();

        if (certo) {
            return emailSitioNovo;
        } else {
            System.out.println("--> O E-MAIL NÃO PODE TER ESPAÇOS EM BRANCOS, E PRECISA DE UM DOMÍNIO COM @.");
            return emailSitioAtual;
        }
    }

    public static String conferirSenhaSitio(String senhaSitioAtual, String senhaSitioNovo) {
        boolean certo = true;

        if (senhaSitioNovo.length() < 8) certo = false;

        Printes.espaco();

        if (certo) {
            return senhaSitioNovo;
        } else {
            System.out.println("--> A SENHA NÃO PODE TER MENOS DE 8 CARACTERES.");
            return senhaSitioAtual;
        }
    }

    public static synchronized SingletonDados getInstance(){
        if(uniqueInstance == null){
            synchronized(SingletonDados.class){
                if(uniqueInstance == null){
                    uniqueInstance = new SingletonDados();
                }
            }
        }
        return uniqueInstance;
    }

    public void setPastaDados(String pasta) {
        System.out.println();
    }

    public String getPastaDados() {
        return pastaDados;
    }

    public char criarSitio(String[] dados) {
        return 'l';
    }

    public char logarNoSitio(String[] infoConta) {
        return 'n';
    }
}
