package criacaoERacao;

public class CriacaoBovinoFactory implements InterfaceCriacoes {
    @Override
    public InterfaceTiposCriacoes criarDesmamado() {
        return new CriacaoBovinoDesmamado();
    }

    @Override
    public InterfaceTiposCriacoes criarMatriz() {
        return new CriacaoBovinoMatriz();
    }

    @Override
    public InterfaceTiposCriacoes criarReprodutor() {
        return new CriacaoBovinoReprodutor();
    }
}
