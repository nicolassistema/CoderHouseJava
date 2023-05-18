public class Desafio {



    public static void main(String[] args) {


        Desafio incremento = new Desafio();

        incremento.setEntero(5);

        //incremento.setEntero(incremento.incrementar(incremento.getEntero()));
       incremento.incrementar();

        System.out.println("incrementeo: " + incremento.getEntero());
        //imprimir el valor de la variable




    }


    private int  entero;

    public int getEntero() {
        return entero;
    }

    public void setEntero(int entero) {
        this.entero = entero;
    }


    public int incrementar() {

         return this.entero = this.entero + 1;
    }






}
