public class Test {

    public static void main(String[] args) {


        Perro dogui = new Perro();
        dogui.setNombre("pepe");
        dogui.setRaza("lala");
        dogui.setTamanio(25);


        Perro doguiDuplicado = new Perro();
        doguiDuplicado.setNombre("pepe");
        doguiDuplicado.setRaza("lala");
        doguiDuplicado.setTamanio(25);


        Perro doguiTriplicado = new Perro(3,"triplicado","lala");





        System.out.println(doguiDuplicado.getNombre());
        System.out.println(dogui.equals(doguiDuplicado) );
        System.out.println(dogui.hashCode() );
        System.out.println(doguiDuplicado.hashCode() );

        System.out.println(doguiTriplicado.getNombre());
        System.out.println(dogui.toString());


        //Metodo hashcode en objetos (ver salida antes y después de sobreescribirlo)
        Gato michi = new Gato();
        michi.setAlimentoPreferido("Gati");
        System.out.println("El alimento preferido de mi gato es: " + michi.getAlimentoPreferido());

        Animal tigre = new Animal();
        tigre.setAmistoso(false);
        tigre.setCantidadPatas(4);
        System.out.println(tigre.toString());



    }
}
