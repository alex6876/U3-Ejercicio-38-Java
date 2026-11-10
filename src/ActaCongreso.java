import java.util.List;

public class ActaCongreso extends PublicacionAcademica {

    private String nombreSimposio;
    private String ciudadSede;

    public ActaCongreso(String titulo, String fechaPublicacion,
                        List<String> autores,
                        String nombreSimposio, String ciudadSede) {

        super(titulo, fechaPublicacion, autores);

        this.nombreSimposio = nombreSimposio;
        this.ciudadSede = ciudadSede;
    }

    @Override
    public String generarReferencia() {

        return String.join(", ", autores)
                + ", \"" + titulo + "\", en "
                + nombreSimposio + ", "
                + ciudadSede + ", "
                + fechaPublicacion + ".";
    }

    @Override
    public void mostrarInformacion() {

        super.mostrarInformacion();

        System.out.println("Nombre del simposio: " + nombreSimposio);
        System.out.println("Ciudad sede: " + ciudadSede);
    }
}