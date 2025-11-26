package animais;

import dadosEPrintes.Printes;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public class Bovino implements InterfaceAnimal, Serializable {
    private String nome;
    private InterfaceAnimalState estado;
    private LocalDate nascimento;
    private char sexo;
    private String especie;
    private String raca;
    private String linhagem;
    private String descricao;
    private static final long serialVersionUID = 1L;

    public Bovino() {
        this.nome = "";
        this.estado = null;
        this.nascimento = null;
        this.sexo = ' ';
        this.especie = "";
        this.raca = "";
        this.linhagem = "";
        this.descricao = "";
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome, String sitio) {
        boolean certo = false;
        File diretorio = new File(String.format("src\\main\\java\\sitios\\%s\\bovinos", sitio));

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
            System.out.println("--> JÁ EXISTE UM BOVINO COM ESSE NOME.");
        } else {
            Printes.espaco();
            this.nome = nome;
        }
    }

    public InterfaceAnimalState pegarEstado() {
        return estado;
    }

    @Override
    public String getEstado() {
        if (estado == null) {
            return "";
        } else {
            return String.format("%s bovino",estado.toString());
        }
    }

    @Override
    public void setEstado(String estado) {
        if (sexo != ' ') {
            if (estado.equals("filhote")) {
                Printes.espaco();
                this.estado = new FilhoteState();
            } else if (estado.equals("desmamado")) {
                Printes.espaco();
                this.estado = new DesmamadoState();
            } else if (estado.equals("matriz") && sexo == 'f') {
                Printes.espaco();
                this.estado = new MatrizState();
            } else if (estado.equals("reprodutor") && sexo == 'm') {
                Printes.espaco();
                this.estado = new ReprodutorState();
            } else {
                Printes.espaco();
                Printes.opcaoInvalida();
            }
        } else {
            Printes.espaco();
            System.out.println("--> DEFINA O SEXO ANTES DE DEFINIR O ESTADO.");
        }
    }

    @Override
    public String getNascimento() {
        if (nascimento == null) {
            return "";
        } else {
            return nascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
    }

    @Override
    public void setNascimento(String nascimento) {
        try {
            this.nascimento = LocalDate.parse(nascimento,
                    DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            Printes.espaco();
        } catch (DateTimeParseException e) {
            Printes.espaco();
            Printes.opcaoInvalida();
        }
    }

    @Override
    public char getSexo() {
        return sexo;
    }

    @Override
    public void setSexo(String sexo) {
        if (sexo.length() == 1 && (sexo.equals("m") || sexo.equals("f"))) {
            this.sexo = sexo.charAt(0);
            Printes.espaco();
        } else {
            Printes.espaco();
            Printes.opcaoInvalida();
        }
    }

    @Override
    public String getEspecie() {
        return especie;
    }

    @Override
    public void setEspecie(String especie) {
        this.especie = especie;
        Printes.espaco();
    }

    @Override
    public String getRaca() {
        return raca;
    }

    @Override
    public void setRaca(String raca) {
        this.raca = raca;
        Printes.espaco();
    }

    @Override
    public String getLinhagem() {
        return linhagem;
    }

    @Override
    public void setLinhagem(String linhagem) {
        this.linhagem = linhagem;
        Printes.espaco();
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public void setDescricao(String descricao) {
        this.descricao = descricao;
        Printes.espaco();
    }

    @Override
    public boolean serializar(String sitio) {
        if (!this.nome.equals("")) {
            try {
                ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream(String.format("src\\main\\java\\sitios\\%s\\bovinos\\%s.byte", sitio, this.nome)));
                objectOutput.writeObject(this);
                objectOutput.close();
                Printes.espaco();
                System.out.println("--> BOVINO SALVO.");
                return true;
            } catch (IOException e) {
                Printes.espaco();
                System.out.println("--> PROBLEMA AO SERIALIZAR O BOVINO.");
                return false;
            }
        } else {
            Printes.espaco();
            System.out.println("--> COLOQUE UM NOME NO BOVINO ANTES DE SALVAR.");
            return false;
        }
    }

    @Override
    public void verificarTransicao() {
        if (nascimento == null || estado == null) {
            Printes.espaco();
            System.out.println("--> PRIMEIRO DEFINA A DATA DE NASCIMENTO E O ESTADO DO BOVINO.");
        } else {
            estado = estado.tentarMudarEstado(nascimento, sexo);
        }
    }

    @Override
    public void adicionarNaCriacao() {

    }

    @Override
    public void retirarDaCriacao() {

    }
}
