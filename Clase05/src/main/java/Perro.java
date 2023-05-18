public class Perro {

    public Perro(int tamanio, String nombre, String raza) {
        this.tamanio = tamanio;
        this.nombre = nombre;
        this.raza = raza;
    }

    public Perro(){

    }
    private int tamanio;
    private String nombre;
    private String raza;
    public int getTamanio() {
        return tamanio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public boolean equals(Object o) {
        //comparamos referencias
        if (this == o) return true;
        //comparamos clases
        if (!(o instanceof Perro perro)) return false;

        System.out.println("perro.getNombre() : "+perro.getNombre());
        System.out.println("getNombre(): "+getNombre());



        if (getTamanio() != perro.getTamanio()) return false;
        if (!getNombre().equals(perro.getNombre())) return false;
        return getRaza().equals(perro.getRaza());
    }

    @Override
    public int hashCode() {
        int result = getTamanio();
        result = 31 * result + getNombre().hashCode();
        result = 31 * result + getRaza().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Perro{" +
                "tamanio=" + tamanio +
                ", nombre='" + nombre + '\'' +
                ", raza='" + raza + '\'' +
                '}';
    }
}
