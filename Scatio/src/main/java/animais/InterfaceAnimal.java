package animais;

import java.io.Serializable;
import java.time.LocalDate;

public interface InterfaceAnimal extends Serializable {

    public String getNome();
    public void setNome(String nome, String sitio);

    public InterfaceAnimalState pegarEstado();

    public String getEstado();
    public void setEstado(String estado);

    public String getNascimento();
    public void setNascimento(String nascimento);

    public char getSexo();
    public void setSexo(String sexo);

    public String getEspecie();
    public void setEspecie(String especie);

    public String getRaca();
    public void setRaca(String raca);

    public String getLinhagem();
    public void setLinhagem(String linhagem);

    public String getDescricao();
    public void setDescricao(String descricao);

    public void verificarTransicao();

    public void adicionarNaCriacao();

    public void retirarDaCriacao();

    public boolean serializar(String sitio);
}
