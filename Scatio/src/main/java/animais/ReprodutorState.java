package animais;

import dadosEPrintes.Printes;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class ReprodutorState implements InterfaceAnimalState, Serializable {
    @Override
    public void adicionarNaCriacao(Object criacao) {

    }

    @Override
    public void retirarDaCriacao() {

    }

    @Override
    public InterfaceAnimalState tentarMudarEstado(LocalDate nascimento, char sexo) {
        InterfaceAnimalState retorno = null;

        int idade = Period.between(nascimento, LocalDate.now()).getYears();

        if (idade < 5) {
            retorno = new FilhoteState();
            Printes.espaco();
            System.out.println("--> SEU ANIMAL AGORA ESTÁ NO ESTADO FILHOTE POIS TEM MENOS DE 5 ANOS.");
        } else if (idade >= 5 && idade < 10) {
            retorno = new DesmamadoState();
            Printes.espaco();
            System.out.println("--> SEU ANIMAL AGORA ESTÁ NO ESTADO DESMAMADO POIS TEM ENTRE 5 E 10 ANOS.");
        } else if (idade >= 10 && sexo == 'f') {
            retorno = new MatrizState();
            Printes.espaco();
            System.out.println("--> SEU ANIMAL AGORA ESTÁ NO ESTADO MATRIZ POR TER MAIS DE 10 ANOS E SER FÊMEA.");
        } else if (idade >= 10 && sexo == 'm') {
            retorno = new ReprodutorState();
            Printes.espaco();
            System.out.println("--> SEU ANIMAL CONTINUA COMO UM REPRODUTOR POR TER MAIS DE 10 ANOS E SER MACHO.");
        }
        return retorno;
    }

    @Override
    public String toString() {
        return "Reprodutor";
    }
}
