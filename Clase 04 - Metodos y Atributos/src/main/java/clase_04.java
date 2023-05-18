public class clase_04 {


    //main es un objeto estatico
    public static void main(String[] args) {

        imprimirColores();
        //los metodos que no son estaticos pirmero se tienen que instanciar

        clase_04 clase04 = new clase_04();
        clase_04.imprimirColores();

        System.out.println("La suma es : " + suma(1.5f, 6.9f));

        Edificio hilton = new Edificio();
        hilton.setPisos(25);


        System.out.println(hilton.getPisos());

    }


    static void imprimirColores() {
        System.out.println("Blanco, amarillo, azul, magenta, indigo");
    }

    void imprimirColoresDos() {
        System.out.println("Blanco, amarillo, azul, magenta, indigo");
    }

    static float suma(float numA, float numB) {
        return numA + numB;
    }

    //private solo va a ser accesible para la clase

//alt + insert definis el getter and setter
}

      class  Edificio{

        private  int pisos;
        public static final int CANTIDAD_MAXIMAS_PISOS = 100;


        public int getPisos() {
            return pisos;
        }

        public void setPisos(int pisos) {
            String message = "la cantidad de pisos no es la indicada";
           //validar que la cantidad de pisos sea la correcta
            if(pisos> CANTIDAD_MAXIMAS_PISOS){
                System.out.println(message);
            }else{
                this.pisos = pisos;
            }
        }



    }

