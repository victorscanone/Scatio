package criacaoERacao;

public class CriacaoAveFactory implements InterfaceCriacoes {
    @Override
    public InterfaceTiposCriacoes criarDesmamado() {
        return new CriacaoAveDesmamado();
    }

    @Override
    public InterfaceTiposCriacoes criarMatriz() {
        return new CriacaoAveMatriz();
    }

    @Override
    public InterfaceTiposCriacoes criarReprodutor() {
        return new CriacaoAveReprodutor();
    }
}
