package criacaoERacao;

import dadosEPrintes.Printes;

import java.io.*;
import java.util.Objects;

public class Racao implements Serializable {
    private String nome = "";
    private String marca = "";
    private String precoEmCentavos = "";
    private String quantasVezesAlimntar = "";
    private String quantidadeParaAlimentarGramas = "";
    private static final long serialVersionUID = 1L;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome, String sitio) {
        boolean certo = false;
        File diretorio = new File(String.format("src\\main\\java\\sitios\\%s\\racoes", sitio));

        for (File file: Objects.requireNonNull(diretorio.listFiles())) {
            String name2 = file.getName();
            String name3 = String.format("%s.byte", nome);
            if (name2.equals(name3)) {
                certo = true;
                break;
            }
        }

        if (certo) {
            Printes.espaco();
            System.out.println("--> JÁ EXISTE UMA RAÇÃO COM ESSE NOME.");
        } else {
            Printes.espaco();
            this.nome = nome;
        }
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        Printes.espaco();
        this.marca = marca.toLowerCase();
    }

    public String getPrecoEmCentavos() {
        return precoEmCentavos;
    }

    public void setPrecoEmCentavos(String precoEmCentavos) {
        boolean certo = true;
        for (char c:precoEmCentavos.toCharArray()) {
            if (!Character.isDigit(c)) {
                certo = false;
            }
        }

        if (certo) {
            Printes.espaco();
            this.precoEmCentavos = precoEmCentavos;
        } else {
            Printes.espaco();
            System.out.println("--> DIGITE UM VALOR NÚMERICO.");
            this.precoEmCentavos = "";
        }
    }

    public String getQuantasVezesAlimntar() {
        return quantasVezesAlimntar;
    }

    public void setQuantasVezesAlimentar(String quantasVezesAlimntar) {
        boolean certo = true;
        for (char c:quantasVezesAlimntar.toCharArray()) {
            if (!Character.isDigit(c)) {
                certo = false;
            }
        }

        if (certo) {
            Printes.espaco();
            this.quantasVezesAlimntar = quantasVezesAlimntar;
        } else {
            Printes.espaco();
            System.out.println("--> DIGITE UM VALOR NÚMERICO.");
            this.quantasVezesAlimntar = "";
        }
    }

    public String getQuantidadeParaAlimentarGramas() {
        return quantidadeParaAlimentarGramas;
    }

    public void setQuantidadeParaAlimentarGramas(String quantidadeParaAlimentarGramas) {
        boolean certo = true;
        for (char c:quantidadeParaAlimentarGramas.toCharArray()) {
            if (!Character.isDigit(c)) {
                certo = false;
            }
        }

        if (certo) {
            Printes.espaco();
            this.quantidadeParaAlimentarGramas = quantidadeParaAlimentarGramas;
        } else {
            Printes.espaco();
            System.out.println("--> DIGITE UM VALOR NÚMERICO.");
            this.quantidadeParaAlimentarGramas = "";
        }
    }

    public boolean serializar(String sitio) {
        if (!this.nome.equals("")) {
            try {
                ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream(String.format("src\\main\\java\\sitios\\%s\\racoes\\%s.byte", sitio, this.nome)));
                objectOutput.writeObject(this);
                objectOutput.close();
                Printes.espaco();
                System.out.println("--> RAÇÃO SALVA.");
                return true;
            } catch (IOException e) {
                Printes.espaco();
                System.out.println("--> PROBLEMA AO SERIALIZAR A RAÇÃO.");
                return false;
            }
        } else {
            Printes.espaco();
            System.out.println("--> COLOQUE UM NOME NA RAÇÃO ANTES DE SALVAR.");
            return false;
        }
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
