package animais;

import java.time.LocalDate;

public interface InterfaceAnimalState {
    public void adicionarNaCriacao(Object criacao);

    public void retirarDaCriacao();

    public InterfaceAnimalState tentarMudarEstado(LocalDate nascimento, char sexo);
}
