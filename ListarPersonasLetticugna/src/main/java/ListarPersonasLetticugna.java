public class ListarPersonasLetticugna {

    public ListarPersonasLetticugna(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public ListarPersonasLetticugna() {

    }

    String nombre;
    String apellido;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public void mostrar(ListarPersonasLetticugna persona){
        System.out.println("Nombre: " + persona.getNombre() + " | Apellido: "+persona.getApellido());
    }





}
