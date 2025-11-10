package dadosEPrintes;

public class SingletonDados {

    private static SingletonDados uniqueInstance;
    private static String pastaDados;
    private String nomeSitio;
    private String emailSitio;
    private String senhaSitio;

    private SingletonDados(){}

    public static String conferirNomeSitio(String nomeSitioAtual, String nomeSitioNovo) {
        boolean certo = true;

        for (char c: nomeSitioNovo.strip().toCharArray()) {
            if (c == ' ' || c == '@') {
                certo = false;
                break;
            }
        }
        if (certo) {
            return nomeSitioNovo;
        } else {
            Printes.espaco();
            System.out.println("--> O NOME NÃO PODE TER ESPAÇOS EM BRANCOS OU @.");
            return nomeSitioAtual;
        }
    }

    public static String conferirSenhaSitio(String senhaSitioAtual, String senhaSitioNovo) {
        boolean certo = true;

        if (senhaSitioNovo.length() < 8) {
            certo = false;
        }

        if (certo) {
            return senhaSitioNovo;
        } else {
            Printes.espaco();
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

    public boolean criarSitio(String[] dados) {
        return false;
    }

    public char logarNoSitio(String[] infoConta) {
        return 'n';
    }
}
