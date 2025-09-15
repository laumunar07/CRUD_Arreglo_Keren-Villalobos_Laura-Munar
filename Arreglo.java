public class Arreglo {

    public static int NRO_USUARIOS = 10;
    public static String []nombre = new String [NRO_USUARIOS];
    public static float [] sueldo = new float [NRO_USUARIOS];
    static int proximoUsuario = 0;

    public static void main(String [] args){

        agregarUsuario("Maria",2137);
        agregarUsuario("José",2167);        
        agregarUsuario("Parrila",2367);
        ordenar();
        showUsers();

    }
     
    public static int borrarRegistro(int indice){
        if ((indice >= 0) && (indice < NRO_USUARIOS)){
             if(indice >= proximoUsuario){
                //salida por intento de borrar un usuario inexistente
                return -1;
            }else{
                //Borra un registro guardado entre el número actual de usuarios y else
                //indice a borrar
                for (int i = indice +1; i<proximoUsuario; i++){
                    nombre[i-1] = nombre[i];
                    sueldo[i-1] = sueldo[i];
                }
                proximoUsuario--;
                return 1;
            }
        }else{
            return 0;
        }
    }
    
    public static void agregarUsuario(String nombre, float salario){
        escribirRegistro(proximoUsuario, nombre, salario);
        proximoUsuario++;   
        if (proximoUsuario >= NRO_USUARIOS){
            proximoUsuario = NRO_USUARIOS -1;
            System.out.println("Se alcanzó el máximo de usuarios");
        }
    }

    public static void showUsers(){
        for (int i = 0; i < proximoUsuario; i++){
            imprimirUsuario(i);
        }
    }    
    
    public static void imprimirUsuario(int indice){
        if ((indice >= 0) && (indice < NRO_USUARIOS)){
            System.out.println("* " + nombre[indice] + "    " + sueldo[indice]);
        }else{
            System.out.println("Índice de usuario erroneo");
        }
    }
    public static int escribirRegistro(int indice, String n, float s) {
        if ((indice >= 0) && (indice < NRO_USUARIOS)){
            nombre[indice] = n;
            sueldo[indice] = s;
            return 1;
        } else {
            return 0;
        }
    }

    public static void ordenar(){
        for (int i = 0; i < proximoUsuario -1; i++){
            for (int j = 0; j < proximoUsuario -1 -i; j++){
                if (nombre[i].compareTo(nombre[j+1])>0) {
                    String tempNombre = nombre[i];
                    nombre[i] = nombre [j + 1];
                    nombre[j + 1] = tempNombre;

                    float tempSueldo = sueldo[i];
                    sueldo[i] = sueldo [j + 1];
                    sueldo [j + 1] = tempSueldo;
                }
            }
        }
    }
}

