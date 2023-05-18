public class NumeroFlotanteLetticugna {
    public static void main(String[] args) {
        //Defino variables
        float numero = 152.08f;
        int numeroEntero;
        int numeroParteDecimal;
        String numeroStr;

        numeroEntero = (int)numero;//convierto en entero el numero flotante para tomar solo su entero
        numeroStr = String.valueOf(numero);//convierto el numero flotante en string
        numeroParteDecimal = numeroStr.indexOf(".");//obtengo el numero de indice del caracter del string "."
        numeroStr = numeroStr.substring(numeroParteDecimal + 1);//piso el numero flotante convertido en string con la obtencion de si mismo partiendo del punto hacia la derecha sin incluir  el punto

        System.out.println("Partiendo del numero '" + numero + ",' su parte entera es '"+numeroEntero+ "' y su parte decimal es '" +numeroStr+"'" );
    }
}
