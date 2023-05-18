import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        //decalrar variables
        int randomIndexNombre;
        int randomIndexApellido;

        //Harcodeo listas de nombres y apellidos en arrays separados
        String[] nombresArray = {"Enrique","Carolina","María","José","Tomás","Marcela","Francisco","Antonio","Rocío","Nicolas","Gustavo","Alberto","Marta","Raúl","Felipe","Veronica","Agustin","Alejandro","Jorge","Leandro"};
        String[] apellidosArray = {"Gámez","Ruiz","Manríquez","Pérez","Navarro","Villanueva","Salvador","Jiménez","López","Rodriguez","Romero","Letticugna","Loenforte","Mendoza","Garcia","Ibarra","Villaseñor","Santos","Alvarez","Alonso"};

        //Declaro listas
        List<ListarPersonasLetticugna> listaPersonas = new ArrayList<>();
        List<String> listaNombresAux = new ArrayList<>();
        List<String> listaApellidosAux = new ArrayList<>();

       //Recorro el array de nombres para obtener cada uno de sus elementos y meterlos en la arrayList de nombres
        for (int i =0;i<nombresArray.length;i++){
            listaNombresAux.add(nombresArray[i]);
        }

        //Recorro el array de apellidos para obtener cada uno de sus elementos y meterlos en la arrayList de apellidos
        for (int i =0;i<apellidosArray.length;i++){
            listaApellidosAux.add(apellidosArray[i]);
        }

        //Declaro objetos del tipo random
        Random randomNombres = new Random();
        Random randomApellidos = new Random();

        for (int i = 0; i < 5; i++) {
            ListarPersonasLetticugna persona = new ListarPersonasLetticugna();//Inicializamos el objeto persona
            randomIndexNombre = randomNombres.nextInt(listaNombresAux.size());//obtiene un indice random de la lista de nombres a traves del  metodo nextInt() donde el parametro de entrada es el tamaño de la lista
            persona.setNombre(listaNombresAux.get(randomIndexNombre));//con ese indice se obtiene el nombre y luego lo seteamos al objeto Persona por medio del setNombre
            randomIndexApellido = randomApellidos.nextInt(listaApellidosAux.size());//obtiene un indice random de la lista de apellidos a traves del  metodo nextInt() donde el parametro de entrada es el tamaño de la lista
            persona.setApellido(listaApellidosAux.get(randomIndexApellido));//con ese indice se obtiene el apellido y luego lo seteamos al objeto Persona por medio del setApellido

            listaPersonas.add(persona);//agrego el objeto persona conformado con el nombre y apellido en la lista de personas
            listaNombresAux.remove(randomIndexNombre);//como el nombre de la lista listaNombresAux ya se uso para setear el nombre al objeto persona, lo eliminamos de listaNombresAux para no cargarlo de nuevo
            listaApellidosAux.remove(randomIndexApellido);//como el nombre de la lista listaApellidosAux ya se uso para setear el apellido al objeto persona, lo eliminamos de listaApellidosAux para no cargarlo de nuevo
        }

        System.out.println("***[Lista original sin ordenar]*** \n=====================================");
        listaPersonas.forEach(persona -> {
            persona.mostrar(persona);
        });

        List<ListarPersonasLetticugna> listaOrdenada = new ArrayList<>(listaPersonas);//genero un array list del objeto ListarPersonasLetticugna

        System.out.println("\n***[Lista original ordenada por nombre]*** \n==========================================");
        Collections.sort(listaOrdenada, Comparator.comparing(ListarPersonasLetticugna::getNombre));//comparo por nombre y lo ordeno
        for (ListarPersonasLetticugna persona : listaOrdenada) {
            persona.mostrar(persona);
        }
        System.out.println("\n***[Lista original ordenada por apellido]*** \n===========================================");
        Collections.sort(listaOrdenada, Comparator.comparing(ListarPersonasLetticugna::getApellido));//comparo por apellido y lo ordeno
        for (ListarPersonasLetticugna persona : listaOrdenada) {
            persona.mostrar(persona);
        }
        System.out.println("\n***[Lista original ordenada por apellido en forma descendente]*** \n=====================================================");
        Collections.sort(listaOrdenada, Comparator.comparing(ListarPersonasLetticugna::getApellido).reversed());//comparo por apellido y lo ordeno de forma descendente
        for (ListarPersonasLetticugna persona : listaOrdenada) {
            persona.mostrar(persona);
        }


    }

}
