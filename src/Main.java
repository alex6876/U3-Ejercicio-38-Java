import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        ArticuloIndexado articulo = new ArticuloIndexado(
                "Inteligencia artificial en la educacion",
                "2026",
                Arrays.asList("Carlos Perez", "Maria Lopez"),
                4.5,
                "Q1"
        );

        ActaCongreso acta = new ActaCongreso(
                "Avances en programacion",
                "2025",
                Arrays.asList("Juan Gomez", "Laura Diaz"),
                "Congreso Internacional de Informatica",
                "Buenos Aires"
        );

        TesisDoctoral tesis = new TesisDoctoral(
                "Sistemas inteligentes aplicados a la medicina",
                "2024",
                Arrays.asList("Pedro Fernandez"),
                "Dr. Roberto Martinez",
                "Universidad Nacional de Cuyo"
        );

        PublicacionAcademica[] publicaciones = {
                articulo,
                acta,
                tesis
        };

        System.out.println("===== REPOSITORIO ACADEMICO =====");

        for (PublicacionAcademica publicacion : publicaciones) {

            System.out.println("\n------------------------------");

            publicacion.mostrarInformacion();

            System.out.println("Indexada: "
                    + publicacion.validarIndexacion());

            System.out.println("\nReferencia bibliografica:");

            System.out.println(publicacion.generarReferencia());
        }
    }
}