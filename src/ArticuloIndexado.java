import java.util.List;

public class ArticuloIndexado extends PublicacionAcademica {

    private double factorImpacto;
    private String cuartil;

    public ArticuloIndexado(String titulo, String fechaPublicacion,
                            List<String> autores,
                            double factorImpacto, String cuartil) {

        super(titulo, fechaPublicacion, autores);

        this.factorImpacto = factorImpacto;
        this.cuartil = cuartil;
    }

    @Override
    public boolean validarIndexacion() {

        boolean cuartilValido =
                cuartil.equalsIgnoreCase("Q1") ||
                        cuartil.equalsIgnoreCase("Q2") ||
                        cuartil.equalsIgnoreCase("Q3") ||
                        cuartil.equalsIgnoreCase("Q4");

        return factorImpacto > 0 && cuartilValido;
    }

    @Override
    public String generarReferencia() {

        return String.join(", ", autores)
                + " (" + fechaPublicacion + "). "
                + titulo + ". Revista científica. "
                + "Factor de impacto: " + factorImpacto
                + ". Cuartil: " + cuartil + ".";
    }

    @Override
    public void mostrarInformacion() {

        super.mostrarInformacion();

        System.out.println("Factor de impacto: " + factorImpacto);
        System.out.println("Cuartil: " + cuartil);
    }
}
