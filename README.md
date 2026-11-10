Aquí tienes la estructura en formato Markdown lista para el `README.md` de este código de **Simulación de Repositorio de Publicaciones Académicas (Clases Abstractas, Herencia y Polimorfismo en Java)**, manteniendo el enfoque exclusivo de **Programación Orientada a Objetos en memoria** (sin bases de datos):

---

# 📚 Simulación de Repositorio de Publicaciones Académicas (Clases Abstractas y Polimorfismo en Java)

Este proyecto es una aplicación en Java que modela un sistema de gestión bibliográfica y científica, implementando una arquitectura basada en clases abstractas y herencia para administrar distintos tipos de producciones investigativas (artículos científicos indexados, actas de congresos y tesis doctorales) con reglas especializadas para la validación de indexación y la generación automatizada de referencias bibliográficas. Pone en práctica conceptos fundamentales de la **Programación Orientada a Objetos (POO)** como la **generalización de atributos protegidos (`protected`)**, la utilización de colecciones dinámicas (`List<String>`), constructores mediante `super`, la implementación obligatoria de contratos en clases abstractas (`abstract`), la sobrescritura polimórfica de comportamiento (`@Override`) y el procesamiento masivo mediante arreglos polimórficos en memoria.

---

## 🧩 Clases y Estructura del Sistema

El diseño del software se organiza a través de una clase base abstracta, sus respectivas subclases especializadas y un punto de ejecución:

* **`PublicacionAcademica` (Clase Abstracta)**: Centraliza los atributos y comportamientos comunes de cualquier documento científico o académico.
* **Atributos protegidos (`protected`)**: `titulo`, `fechaPublicacion` y `autores` (como una lista dinámica `List<String>`), permitiendo que las clases hijas accedan directamente a los datos fundamentales del trabajo.
* **Constructor**: Inicializa los metadatos comunes y realiza una copia defensiva de la lista de autores para preservar la encapsulación.
* **Métodos operativos**:
* `validarIndexacion()`: Método concreto con comportamiento por defecto (`false`), diseñado para ser sobrescrito opcionalmente por las publicaciones que lo requieran.
* `abstract String generarReferencia()`: Método abstracto que obliga a cada tipo de publicación a formatear su propia cita bibliográfica.
* `mostrarInformacion()`: Método compartido que despliega por consola el título, año y la lista unida de autores separados por comas.




* **`ArticuloIndexado`**: Extiende de `PublicacionAcademica` para modelar publicaciones en revistas científicas arbitradas.
* **Atributos privados (`private`)**: `factorImpacto` y `cuartil`.
* **Constructor**: Invoca a `super(...)` para configurar los datos base y asigna las métricas de impacto y cuartil.
* **Sobrescritura (`@Override`)**:
* `validarIndexacion()`: Valida que el factor de impacto sea mayor a cero y que el cuartil pertenezca legítimamente a los rangos Q1, Q2, Q3 o Q4.
* `generarReferencia()`: Compone una cita bibliográfica estructurada con el formato de revista científica incluyendo factor de impacto y cuartil.
* `mostrarInformacion()`: Extiende la visualización base (`super.mostrarInformacion()`) agregando el factor de impacto y el cuartil.




* **`ActaCongreso`**: Extiende de `PublicacionAcademica` para modelar ponencias presentadas en eventos y simposios.
* **Atributos privados (`private`)**: `nombreSimposio` y `ciudadSede`.
* **Constructor**: Utiliza `super(...)` para inicializar los atributos heredados y configura el simposio y la ciudad.
* **Sobrescritura (`@Override`)**:
* `generarReferencia()`: Genera la cita académica correspondiente a memorias de congresos, integrando autores, título, evento, ciudad y fecha.
* `mostrarInformacion()`: Reutiliza la lógica base e incorpora el nombre del simposio y la ciudad sede.




* **`TesisDoctoral`**: Extiende de `PublicacionAcademica` para modelar trabajos de posgrado de máxima titulación.
* **Atributos privados (`private`)**: `nombreDirector` y `universidadOtorgante`.
* **Constructor**: Utiliza `super(...)` y configura el director de tesis y la institución académica.
* **Sobrescritura (`@Override`)**:
* `generarReferencia()`: Diseña el formato de referencia bibliográfica específico para tesis doctorales con la etiqueta `[Tesis doctoral]`.
* `mostrarInformacion()`: Extiende el reporte mediante `super` para detallar el director y la universidad de origen.




* **`Main`**: Punto de entrada del programa. Instancia un artículo indexado, un acta de congreso y una tesis doctoral utilizando listas de autores mediante `Arrays.asList()`, los agrupa en un arreglo polimórfico de tipo `PublicacionAcademica[]`, y recorre la colección generando un reporte integral que evalúa dinámicamente la indexación y emite las referencias bibliográficas correspondientes por consola.

---

## ⚙️ Reglas de Negocio y Control de Validación

1. **Contrato Estricto de Referencias:** La clase abstracta obliga formalmente a todas las subclases a proveer su propia implementación del método `generarReferencia()`, adaptándose a las normas de citación de cada formato académico.
2. **Validación Rigurosa de Indexación:** El artículo indexado implementa reglas lógicas específicas para comprobar la validez de sus métricas (factor de impacto positivo y pertenencia a cuartiles Q1-Q4), mientras que el resto de las publicaciones heredan el comportamiento base estándar.
3. **Encapsulamiento de Colecciones:** La lista de autores se inicializa mediante una copia defensiva en el constructor (`new ArrayList<>(autores)`), previniendo modificaciones externas no controladas sobre los datos internos del objeto.

---

## 💻 Salida por Consola

Al ejecutar la clase `Main`, el programa genera el siguiente resultado:

```text
===== REPOSITORIO ACADEMICO =====

------------------------------
Titulo: Inteligencia artificial en la educacion
Fecha de publicacion: 2026
Autores: Carlos Perez, Maria Lopez
Factor de impacto: 4.5
Cuartil: Q1
Indexada: true

Referencia bibliografica:
Carlos Perez, Maria Lopez (2026). Inteligencia artificial en la educacion. Revista científica. Factor de impacto: 4.5. Cuartil: Q1.

------------------------------
Titulo: Avances en programacion
Fecha de publicacion: 2025
Autores: Juan Gomez, Laura Diaz
Nombre del simposio: Congreso Internacional de Informatica
Ciudad sede: Buenos Aires
Indexada: false

Referencia bibliografica:
Juan Gomez, Laura Diaz, "Avances en programacion", en Congreso Internacional de Informatica, Buenos Aires, 2025.

------------------------------
Titulo: Sistemas inteligentes aplicados a la medicina
Fecha de publicacion: 2024
Autores: Pedro Fernandez
Director: Dr. Roberto Martinez
Universidad: Universidad Nacional de Cuyo
Indexada: false

Referencia bibliografica:
Pedro Fernandez (2024). Sistemas inteligentes aplicados a la medicina [Tesis doctoral]. Universidad Nacional de Cuyo.

```

---

## 🚀 Conceptos de Programación Aplicados

* **Abstracción y Polimorfismo Científico:** Modelado de entidades documentales heterogéneas mediante una jerarquía basada en clases abstractas que unifican su tratamiento.
* **Ligadura Dinámica de Referencias:** Generación automática de citas bibliográficas diferenciadas en tiempo de ejecución según la naturaleza específica de la publicación académica.
* **Diseño Robusto y Modular:** Empleo de buenas prácticas de encapsulamiento con colecciones y separación de responsabilidades entre la capa de dominio y la ejecución cliente (`Main`).
