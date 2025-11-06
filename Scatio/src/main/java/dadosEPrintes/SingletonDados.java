package dadosEPrintes;

public class SingletonDados {

    private SingletonDados uniqueInstance;
    private String pastaDados;

    private SingletonDados(){}

    public SingletonDados getInstance() {
        System.out.println();
    }

    public void setPastaDados(String pasta) {
        System.out.println();
    }

    public String getPastaDados() {
        return pastaDados;
    }

    public boolean criarSitio(String[] dados) {

    }

    public void logarNoSitio() {

    }
}
