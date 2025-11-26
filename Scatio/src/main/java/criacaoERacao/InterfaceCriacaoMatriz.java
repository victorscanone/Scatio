package criacaoERacao;

import animais.InterfaceAnimal;

import java.util.ArrayList;

public interface InterfaceCriacaoMatriz extends InterfaceTiposCriacoes {
    public void alimentar();

    public void adicionarNaCriacao(InterfaceAnimal animal);

    public void retirarDaCriacao(InterfaceAnimal animal);
}
