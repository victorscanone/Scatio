package criacaoERacao;

import animais.InterfaceAnimal;

public interface InterfaceCriacaoReprodutor extends InterfaceTiposCriacoes {
    public void alimentar();

    public void adicionarNaCriacao(InterfaceAnimal animal);

    public void retirarDaCriacao(InterfaceAnimal animal);
}
