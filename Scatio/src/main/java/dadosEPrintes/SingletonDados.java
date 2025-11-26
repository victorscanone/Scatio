package dadosEPrintes;

import animais.InterfaceAnimal;
import criacaoERacao.InterfaceTiposCriacoes;
import criacaoERacao.Racao;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class SingletonDados {

    private static SingletonDados uniqueInstance;
    private String nomeSitio;
    private String emailSitio;
    private String senhaSitio;

    private SingletonDados(){}

    public String getNomeSitio() {
        return nomeSitio;
    }

    public void setNomeSitio(String nomeSitio) {
        this.nomeSitio = nomeSitio;
    }

    public String getEmailSitio() {
        return emailSitio;
    }

    public void setEmailSitio(String emailSitio) {
        this.emailSitio = emailSitio;
    }

    public String getSenhaSitio() {
        return senhaSitio;
    }

    public void setSenhaSitio(String senhaSitio) {
        this.senhaSitio = senhaSitio;
    }

    public static String conferirNomeSitio(String nomeSitioAtual, String nomeSitioNovo) {
        boolean certo = true;

        for (char c: nomeSitioNovo.toCharArray()) {
            if (c == ' ' || c == '@' || c == ',') {
                certo = false;
                break;
            }
        }

        if (nomeSitioNovo.length() < 5) certo = false;

        Printes.espaco();

        if (certo) {
            return nomeSitioNovo;
        } else {
            System.out.println("--> O NOME PRECISA DE PELO MENOS 5 CARACTERES E NÃO PODE TER ESPAÇOS EM BRANCOS, @ OU VIRGULAS.");
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
            if (c == ' ' || c == ',') {
                certo = false;
                break;
            }
        }

        Printes.espaco();

        if (certo) {
            return emailSitioNovo;
        } else {
            System.out.println("--> O E-MAIL NÃO PODE TER ESPAÇOS EM BRANCO ou VIRGULA, E PRECISA DE UM DOMÍNIO COM @.");
            return emailSitioAtual;
        }
    }

    public static String conferirSenhaSitio(String senhaSitioAtual, String senhaSitioNovo) {
        boolean certo = true;

        if (senhaSitioNovo.length() < 8) certo = false;

        for (char c: senhaSitioNovo.toCharArray()) {
            if (c == ',') {
                certo = false;
                break;
            }
        }

        Printes.espaco();

        if (certo) {
            return senhaSitioNovo;
        } else {
            System.out.println("--> A SENHA NÃO PODE TER VIRGULA E PRECISA DE 8 OU MAIS CARACTERES.");
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

    public boolean existeSitio(String nome) {
        boolean certo = false;
        File diretorio = new File("src\\main\\java\\sitios");

        for (File file: Objects.requireNonNull(diretorio.listFiles())) {
            if (file.getName().equals(nome)) {
                certo = true;
                break;
            }
        }
        return certo;
    }

    public char criarSitio(String[] dados) {
        char resultado = 'n';

        if (!existeSitio(dados[0])) {
            Path caminho = Paths.get(String.format("src\\main\\java\\sitios\\%s", dados[0]));
            Path caminhoRacoes = Paths.get(String.format("src\\main\\java\\sitios\\%s\\racoes", dados[0]));
            Path caminhoAves = Paths.get(String.format("src\\main\\java\\sitios\\%s\\aves", dados[0]));
            Path caminhoBovinos = Paths.get(String.format("src\\main\\java\\sitios\\%s\\bovinos", dados[0]));
            Path caminhoCriacoesAves = Paths.get(String.format("src\\main\\java\\sitios\\%s\\criacoesAves", dados[0]));
            Path caminhoCriacoesBovinos = Paths.get(String.format("src\\main\\java\\sitios\\%s\\criacoesBovinos", dados[0]));

            try {
                Files.createDirectories(caminho);

                BufferedWriter writer = new BufferedWriter(new FileWriter(String.format("src\\main\\java\\sitios\\%s\\sitio.txt", dados[0])));
                writer.write(String.format("Nome: %s", dados[0]));
                writer.write(String.format("\nE-mail: %s", dados[1]));
                writer.write(String.format("\nSenha: %s", dados[2]));
                writer.close();

                Files.createDirectories(caminhoRacoes);
                Files.createDirectories(caminhoAves);
                Files.createDirectories(caminhoBovinos);
                Files.createDirectories(caminhoCriacoesAves);
                Files.createDirectories(caminhoCriacoesBovinos);


                resultado = 'l';
                Printes.espaco();
                System.out.println("--> SÍTIO CRIADO COM SUCESSO.");

            } catch (IOException e) {
                System.out.println("--> PROBLEMA AO CRIAR A PASTA COM OS DADOS DO SÍTIO.");
            }

        } else {
            Printes.espaco();
            System.out.println("--> ESSE SÍTIO JÁ EXISTE.");
        }


        return resultado;
    }

    public char logarNoSitio(String[] dados) {
        char resultado = 'n';
        String linha;

        if (existeSitio(dados[0])) {

            try {
                BufferedReader reader = new BufferedReader(new FileReader(String.format("src\\main\\java\\sitios\\%s\\sitio.txt", dados[0])));
                if (reader.readLine().equals(String.format("Nome: %s", dados[0]))) {
                    if (reader.readLine() != null) {
                        if (reader.readLine().equals(String.format("Senha: %s", dados[2]))) {
                            Printes.espaco();
                            resultado = 'l';
                        } else {
                            Printes.espaco();
                            System.out.println("--> SENHA INCORRETA.");
                        }
                    }
                }
                reader.close();

            } catch (IOException e) {
                Printes.espaco();
                System.out.println("--> PROBLEMA AO LOGAR NO SÍTIO.");
            }
        } else {
            Printes.espaco();
            System.out.println("--> SÍTIO INEXISTENTE.");
        }

        return resultado;
    }

    public void listas(String tipo) {
        boolean certo = false;
        int count = 1;
        File diretorio = new File(String.format("src\\main\\java\\sitios\\%s\\%s", getNomeSitio(), tipo));

        for (File file: Objects.requireNonNull(diretorio.listFiles())) {
            System.out.printf("     •[%d] %s\n", count, file.getName());
            count++;
        }
        Printes.linha();
    }

    public InterfaceTiposCriacoes desserializarCriacao(String nome, String tipo) {
        boolean certo = false;
        File diretorio = new File(String.format("src\\main\\java\\sitios\\%s\\%s", getNomeSitio(), tipo));

        for (File file: Objects.requireNonNull(diretorio.listFiles())) {
            String name2 = file.getName();
            String name3 = String.format("%s.byte", nome);

            if (name2.equals(name3)) {
                certo = true;
                break;
            }
        }
        InterfaceTiposCriacoes criacao = null;

        if (certo) {
            try {
                ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(String.format("src\\main\\java\\sitios\\%s\\%s\\%s.byte", getNomeSitio(), tipo, nome)));
                criacao = (InterfaceTiposCriacoes) objectInput.readObject();
                objectInput.close();

            } catch (IOException | ClassNotFoundException e) {
                Printes.espaco();
                System.out.println(e);
                if (tipo.equals("criacoesAves")) {
                    System.out.println("--> PROBLEMA AO DESSERIALIZAR A CRIAÇÃO DE AVES.");
                } else if (tipo.equals("criacoesBovinos")) {
                    System.out.println("--> PROBLEMA AO DESSERIALIZAR A CRIAÇÃO BOVINA.");
                }
                return null;
            }
        } else {
            Printes.espaco();
            if (tipo.equals("criacoesAves")) {
                System.out.println("--> CRIAÇÃO DE AVES INEXISTENTE.");
            } else if (tipo.equals("bovinos")) {
                System.out.println("--> CRIAÇÃO DE BOVINOS INEXISTENTE.");
            }
        }
        return criacao;
    }

    public Racao desserializarRacao(String nome) {
        boolean certo = false;
        File diretorio = new File(String.format("src\\main\\java\\sitios\\%s\\racoes", getNomeSitio()));

        for (File file: Objects.requireNonNull(diretorio.listFiles())) {
            String name2 = file.getName();
            String name3 = String.format("%s.byte", nome);

            if (name2.equals(name3)) {
                certo = true;
                break;
            }
        }
        Racao racao = null;

        if (certo) {
            try {
                ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(String.format("src\\main\\java\\sitios\\%s\\racoes\\%s.byte", getNomeSitio(), nome)));
                racao = (Racao) objectInput.readObject();
                objectInput.close();

            } catch (IOException | ClassNotFoundException e) {
                Printes.espaco();
                System.out.println(e);
                System.out.println("--> PROBLEMA AO DESSERIALIZAR A RAÇÃO.");

                return null;
            }
        } else {
            Printes.espaco();
            System.out.println("--> RAÇÃO INEXISTENTE.");
        }
        return racao;
    }

    public InterfaceAnimal desserializarAnimal(String nome, String tipo) {
        boolean certo = false;
        File diretorio = new File(String.format("src\\main\\java\\sitios\\%s\\%s", getNomeSitio(), tipo));

        for (File file: Objects.requireNonNull(diretorio.listFiles())) {
            String name2 = file.getName();
            String name3 = String.format("%s.byte", nome);

            if (name2.equals(name3)) {
                certo = true;
                break;
            }
        }
        InterfaceAnimal animal = null;

        if (certo) {
            try {
                ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(String.format("src\\main\\java\\sitios\\%s\\%s\\%s.byte", getNomeSitio(), tipo, nome)));
                animal = (InterfaceAnimal) objectInput.readObject();
                objectInput.close();

            } catch (IOException | ClassNotFoundException e) {
                Printes.espaco();
                System.out.println(e);
                if (tipo.equals("aves")) {
                    System.out.println("--> PROBLEMA AO DESSERIALIZAR A AVE.");
                } else if (tipo.equals("bovinos")) {
                    System.out.println("--> PROBLEMA AO DESSERIALIZAR O BOVINO.");
                }
                return null;
            }
        } else {
            Printes.espaco();
            if (tipo.equals("aves")) {
                System.out.println("--> AVE INEXISTENTE.");
            } else if (tipo.equals("bovinos")) {
                System.out.println("--> BOVINO INEXISTENTE.");
            }
        }
        return animal;
    }

    public boolean excluirSerializacao(String tipo, String nome) { // tipo (aves, bovinos, criacoes, racoes)
        File arquivo = new File(String.format("src\\main\\java\\sitios\\%s\\%s\\%s.byte", getNomeSitio(), tipo, nome));

        if (arquivo.delete()) {
            Printes.espaco();
            System.out.println("--> SERIALIZAÇÃO DELETADA.");
            return true;
        } else {
            Printes.espaco();
            System.out.println("--> FALHA EM DELETAR.");
            return false;
        }
    }
}
