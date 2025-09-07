import java.util.Scanner;

    class Usuario{  
        String nombre;
        float salario;
        char sexo;
        String cargo;
    
        public Usuario (String  nombre, float salario, char sexo, String cargo) {

            this.nombre =nombre;
            this.salario=salario;
            this.sexo=sexo;
            this.cargo=cargo;
        }
    }

public class Registro {

    static Usuario [] usuarios = new Usuario[30];
    static int indice = 0;
    public static void main(String[]args){
            agregarDatos(0);
    }

    public static void agregarDatos(int indice){
        Scanner input = new Scanner(System.in);
        boolean ACTIVO = true;

        while (ACTIVO) {
            char opcion = menu();
            switch (opcion) {   
                case '1':
                    if (indice < 30) {
                        System.out.println("Ingrese su nombre completo.");
                        String nombre = input.nextLine();
                        System.out.println("Ingrese su salario (sin puntos.)");
                        float salario = input.nextFloat();
                        System.out.println("Ingrese su sexo.");
                        char sexo = input.next().charAt(0);
                        input.nextLine();
                        System.out.println("Ingrese su cargo.");
                        String cargo = input.nextLine();    
                        usuarios[indice] = new Usuario (nombre, salario, sexo, cargo);
                        indice ++;
                        System.out.println("Usuario registrado con éxito");
                    }
                    else {
                        System.out.println("Almacenamiento de usuarios lleno");
                    }
                break;

                case '2':
                    if (indice==0){
                        System.out.println("No hay usuarios registrados");
                    } else {System.out.println("Listado de usuarios:");
                        for (int i=0; i<indice; i++ ) {
                            System.out.print("----------------------\n");
                            System.out.print("Registro\n");
                            System.out.print(" \n");
                            System.out.println("Nombre: " + usuarios[i].nombre);
                            System.out.println("Salario: " + usuarios[i].salario);
                            System.out.println("Sexo: " + usuarios[i].sexo);
                            System.out.println("Cargo: " + usuarios[i].cargo);
                            System.out.print("----------------------\n");
                        }
                    }
                break;

                case '3':
                    if (indice == 0) {
                        System.out.println("No hay usuarios registrados");
                    } else {
                        System.out.println("Ingrese el número del usuario que desea editar (1 a " + indice + "):");
                        int posicion = input.nextInt()-1;
                        input.nextLine();
                        if (posicion >= 0 && posicion < indice) {
                            editarUsuario(posicion, input);
                        } else {
                            System.out.println("Posición no válida");
                        }
                    }
                break;
                
                case '4':
                    if (indice == 0){
                        System.out.println("No hay usuarios para eliminar");
                    } else {
                        System.out.println("Ingrese número de usuario que desea eliminar (1 a " + indice + "):");
                        int posicion = input.nextInt()-1;
                        input.nextLine();
                        if (posicion >= 0 && posicion <= indice){
                            for (int i = posicion; i < indice - 1; i++){
                                usuarios[i] = usuarios[i+1];
                            }
                            usuarios[indice - 1] = null;
                            indice--;
                            System.out.println("Usuario eliminado con éxito");
                        } else { 
                            System.out.println("Posici´ón no válida");
                        }
                    }
                break;

                case '5':
                    ACTIVO=false;
                break;

                default:
                    System.out.println("Opción no reconocida."); 
            }
        }
    }

    public static char  menu (){
        Scanner input = new Scanner(System.in);
        char opcion=0;
        System.out.print("----------------------\n");
        System.out.print("|                    |\n");
        System.out.print("|       Registro     |\n");
        System.out.print("|                    |\n");
        System.out.print("| 1. Crear Usuario   |\n");
        System.out.print("| 2. Ver Usuario     |\n");
        System.out.print("| 3. Editar Usuario  |\n");   
        System.out.print("| 4. Borrar Usuario  |\n");
        System.out.print("| 5. Terminar        |\n");
        System.out.print("----------------------\n");
        opcion = input.next().charAt(0);
        return opcion;}

    public static void editarUsuario (int indice, Scanner input) {
        System.out.println("Ingrese de nuevo su nombre completo.");   
        String nombre = input.nextLine();
        System.out.println("Ingrese su nuevo salario (sin puntos.)");
        float salario = input.nextFloat();
        input.nextLine();
        System.out.println("Ingrese su nuevo sexo.");
        char sexo = input.next().charAt(0);
        input.nextLine();
        System.out.println("Ingrese su cargo.");
        String cargo = input.nextLine();
        usuarios [indice] = new Usuario (nombre, salario, sexo, cargo);
        System.out.println("Usuario actualizado con éxito.");
    }
}









