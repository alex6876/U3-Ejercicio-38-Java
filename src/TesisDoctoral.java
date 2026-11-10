import java.util.List;

public class TesisDoctoral extends PublicacionAcademica {

    private String nombreDirector;
    private String universidadOtorgante;

    public TesisDoctoral(String titulo, String fechaPublicacion,
                         List<String> autores,
                         String nombreDirector,
                         String universidadOtorgante) {

        super(titulo, fechaPublicacion, autores);

        this.nombreDirector = nombreDirector;
        this.universidadOtorgante = universidadOtorgante;
    }

    @Override
    public String generarReferencia() {

        return String.join(", ", autores)
                + " (" + fechaPublicacion + "). "
                + titulo + " [Tesis doctoral]. "
                + universidadOtorgante + ".";
    }

    @Override
    public void mostrarInformacion() {

        super.mostrarInformacion();

        System.out.println("Director: " + nombreDirector);
        System.out.println("Universidad: " + universidadOtorgante);
    }
}
