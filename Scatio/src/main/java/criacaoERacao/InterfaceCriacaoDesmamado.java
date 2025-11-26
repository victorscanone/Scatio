package criacaoERacao;

import animais.InterfaceAnimal;

public interface InterfaceCriacaoDesmamado extends InterfaceTiposCriacoes {
    public void alimentar();

    public void adicionarNaCriacao(InterfaceAnimal animal);

    public void retirarDaCriacao(InterfaceAnimal animal);
}
