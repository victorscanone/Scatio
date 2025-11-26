package criacaoERacao;

import animais.InterfaceAnimal;
import dadosEPrintes.Printes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public interface InterfaceTiposCriacoes {

    public String getSetor();

    public void setSetor(String setor, String sitio);

    public String nomeRacao();

    public Racao getRacao();

    public void setRacao(Racao racao);

    public String getEspecie();

    public void setEspecie(String especie);

    public String getRaca();

    public void setRaca(String raca);

    public ArrayList<InterfaceAnimal> getAnimais();

    public void setAnimais(ArrayList<InterfaceAnimal> animais);

    public void alimentar();

    public void adicionarNaCriacao(InterfaceAnimal animal);

    public void retirarDaCriacao(InterfaceAnimal animal);

    public boolean serializar(String sitio);
}
