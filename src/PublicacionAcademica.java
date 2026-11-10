import java.util.ArrayList;
import java.util.List;

public abstract class PublicacionAcademica {

    protected String titulo;
    protected String fechaPublicacion;
    protected List<String> autores;

    public PublicacionAcademica(String titulo, String fechaPublicacion,
                                List<String> autores) {

        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
        this.autores = new ArrayList<>(autores);
    }

    public boolean validarIndexacion() {
        return false;
    }

    public abstract String generarReferencia();

    public void mostrarInformacion() {
        System.out.println("Titulo: " + titulo);
        System.out.println("Fecha de publicacion: " + fechaPublicacion);
        System.out.println("Autores: " + String.join(", ", autores));
    }
}