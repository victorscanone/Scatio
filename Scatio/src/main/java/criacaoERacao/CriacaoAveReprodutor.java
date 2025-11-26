package criacaoERacao;

import animais.FilhoteState;
import animais.InterfaceAnimal;
import animais.MatrizState;
import animais.ReprodutorState;
import dadosEPrintes.Printes;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class CriacaoAveReprodutor implements InterfaceCriacaoReprodutor, Serializable {
    private String setor = "";
    private Racao racao = null;
    private String especie = "";
    private String raca = "";
    private ArrayList<InterfaceAnimal> animais = new ArrayList<>();

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor, String sitio) {
        boolean certo = false;
        File diretorio = new File(String.format("src\\main\\java\\sitios\\%s\\criacoesAves", sitio));

        for (File file: Objects.requireNonNull(diretorio.listFiles())) {
            String name2 = file.getName();
            String name3 = String.format("%s.byte", setor);
            if (name2.equals(name3)) {
                certo = true;
                break;
            }
        }

        if (certo) {
            Printes.espaco();
            System.out.println("--> JÁ EXISTE UMA CRIAÇÃO DE AVE COM ESSE NOME.");
        } else {
            Printes.espaco();
            this.setor = setor;
        }
    }

    public String nomeRacao() {
        return racao.toString();
    }

    public Racao getRacao() {
        return racao;
    }

    public void setRacao(Racao racao) {
        Printes.espaco();
        this.racao = racao;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        Printes.espaco();
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        Printes.espaco();
        this.raca = raca;
    }

    public ArrayList<InterfaceAnimal> getAnimais() {
        return animais;
    }

    public void setAnimais(ArrayList<InterfaceAnimal> animais) {
        Printes.espaco();
        this.animais = animais;
    }

    @Override
    public void alimentar() {

    }

    @Override
    public void adicionarNaCriacao(InterfaceAnimal animal) {
        Printes.espaco();

        if (animal.pegarEstado() instanceof ReprodutorState) {
            animais.add(animal);
        } else {
            Printes.espaco();
            System.out.println("--> ESSE ANIMAL NÃO É UM ADULTO REPRODUTOR PARA FAZER PARTE DA CRIAÇÃO.");
        }

    }

    @Override
    public void retirarDaCriacao(InterfaceAnimal animal) {
        if (animais.contains(animal)) {
            animais.remove(animal);
        } else {
            Printes.espaco();
            System.out.println("--> ANIMAL NÃO CONSTA NA CRIAÇÃO.");
        }
    }

    @Override
    public boolean serializar(String sitio) {
        if (!this.getSetor().equals("")) {
            try {
                ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream(String.format("src\\main\\java\\sitios\\%s\\criacoesAves\\%s.byte", sitio, this.setor)));
                objectOutput.writeObject(this);
                objectOutput.close();
                Printes.espaco();
                System.out.println("--> CRIAÇÃO SALVA.");
                return true;
            } catch (IOException e) {
                Printes.espaco();
                System.out.println("--> PROBLEMA AO SERIALIZAR A CRIAÇÃO.");
                return false;
            }
        } else {
            Printes.espaco();
            System.out.println("--> COLOQUE UM NOME NA CRIAÇÃO ANTES DE SALVAR.");
            return false;
        }
    }
}
