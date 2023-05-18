import java.util.ArrayList;
import java.util.List;

public class ArraysLoops {

    public static void main(String[] args) {
        //otra forma declarar y definir el array
        //char[] charArray = {'a','b','c','d','e',};


        /*char[] charArray;
        charArray = new char[5];

        charArray[0] = 'a';
        charArray[1] = 'b';
        charArray[2] = 'c';
        charArray[3] = 'd';
        charArray[4] = 'e';


        System.out.println("El indice muesta lo siguiente: " +charArray[0] );


        ///las interfaces son un conjunto de metodos no implementados
        //por ejemplo arrayList
        */
/*
        List<String> listaAmigos = new ArrayList<>();
        List<Integer> listaEdad = new ArrayList<>();

        listaAmigos.add("nico");
        listaAmigos.add("loly");
        listaAmigos.add("neko");
        listaAmigos.add("mona");

        listaEdad.add(37);
        listaEdad.add(39);

        System.out.println("le segunda posicioin develve: " +listaAmigos.get(1));

        listaEdad.set(0,38);
        System.out.println("le segunda posicioin develve edad : " +listaEdad.get(0));

       // listaEdad.remove(0);
       // System.out.println("le segunda posicioin develve: " +listaEdad.get(0));


        System.out.println("neko esta en la posicion: " + listaAmigos.indexOf("neko"));

        for (int nota: listaEdad){
            System.out.println(nota);
        }


       listaAmigos.forEach(nombre ->{
           System.out.println(nombre);
       });
*/
        List<Integer> listaAleatoria = new ArrayList<>();

        for (int i = 0; i<10 ; i++){

            listaAleatoria.add((int)(Math.random() * 100 +1));
        }


        System.out.println(listaAleatoria);

        for (int numeroLista: listaAleatoria
             ) {
            if(!(numeroLista % 3 ==0 && numeroLista % 5 == 0)){
                System.out.println(numeroLista);
            }else{
                break;
            }
        }







    }


}
