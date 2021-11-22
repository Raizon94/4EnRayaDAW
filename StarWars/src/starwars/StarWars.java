package starwars;

import java.util.Scanner;

/**
 *
 * @author William Atef Tadrous
 */
public class StarWars {

    public static void main(String[] args) {
        boolean gameOver = false; //Este booleano me indicará cuando el jugador ha perdido para poder finalizar la partida
        Scanner sc = new Scanner(System.in);
        long v1, v2, total, res; //Declaro cuatro variables de enteros las cuales reasignaré en todo el programa para ahorrar memoria.

        System.out.println("=== STAR WARS CÓDIGOS SECRETOS ===\n"
                + "Hace mucho tiempo, en una galaxia muy, muy lejana... La Princesa\n"
                + "Leia, Luke Skywalker, Han Solo, Chewbacca, C3PO y R2D2 viajan\n"
                + "en una nave imperial robada en una misión secreta para infiltrarse\n"
                + "en otra estrella de la muerte que el imperio está construyendo\n"
                + "para destruirla. (Presiona Intro para continuar)");
        sc.nextLine(); //Hacemos que el escáner lea una línea simplemente para bloquear al jugador hasta que pulse espacio.

        //NIVEL 1
        v1 = (long) (Math.random() * (10 + 1));
        v2 = (long) (20 + Math.random() * (30 - 20 + 1)); //Genero los números aleatorios entre 1 y 10 y entre 20 y 30 y los asigno a v1 y v2 respectivamente.
        total = 0;
        System.out.println("Los problemas empiezan cuando  deben realizar un salto\n"
                + "hiperespacial hasta el sistema estelar " + v1 + " en el sector " + v2 + ", pero el\n"
                + "control  de navegación está estropeado y el computador tiene\n"
                + "problemas para calcular parte de las coordenadas de salto.\n"
                + "Chewbacca, piloto experto, se da cuenta que falta el cuarto\n"
                + "número de la serie. Recuerda de sus tiempos en la academia de\n"
                + "pilotos que para calcularlo hay que calcular el sumatorio entre el\n"
                + "nº del sistema y el nº del sector (ambos inclusive). ¿Qué debe\n"
                + "introducir?");
        for (long i = v2; i >= v1; i--) {
            total += i;
        }
        res = sc.nextLong();

        if (res != total) { //Si el valor introducido no es el correcto, la variable gameOver será true
            gameOver = true;
        }

        //NIVEL 2
        if (!gameOver) {
            v1 = (long) (1 + Math.random() * (7 - 1 + 1)); //Reutilizo las variables para ahorrar memória y repito lo mismo que en el Nivel 1 a excepción de que en vez de sumar, multiplico.
            v2 = (long) (8 + Math.random() * (12 - 8 + 1));
            total = 1;
            System.out.println("Gracias a Chewbacca consiguen llegar al sistema correcto y ven a\n"
                    + "lo lejos la estrella de la muerte. Como van en una nave imperial\n"
                    + "robada se aproximan lentamente con la intención de pasar\n"
                    + "desapercibidos. De  repente suena el comunicador. “Aquí agente\n"
                    + "de espaciopuerto " + v1 + " contactando con nave imperial " + v2 + ". No están\n"
                    + "destinados en este sector. ¿Qué hacen aquí?”. Han Solo coge el\n"
                    + "comunicador e improvisa. “Eh... tenemos un fallo en el... eh...\n"
                    + "condensador de fluzo... Solicitamos permiso para atracar y\n"
                    + "reparar la nave”. El agente, que no se anda con tonterías,\n"
                    + "responde “Proporcione código de acceso o abriremos fuego”. Han\n"
                    + "Solo ojea rápidamente el manual del piloto que estaba en la\n"
                    + "guantera y da con la página correcta. El código es el productorio\n"
                    + "entre el nº del agente y el nº de la nave (ambos inclusive).\n"
                    + "¿Cuál es el código?");
            for (long i = v2; i >= v1; i--) {
                total *= i;
            }
            res = sc.nextLong();
            if (res != total) {
                gameOver = true;
            }
        }

        //NIVEL 3
        if (!gameOver) {
            v1 = (long) (50 + Math.random() * (100 - 50 + 1)); //v1 será un número aleatorio entre 50 y 100.
            total = 1;
            System.out.println("Han Solo proporciona el código correcto. Atracan en la estrella de\n"
                    + "la muerte, se equipan con trajes de soldados imperiales que\n"
                    + "encuentran en la nave para pasar desapercibidos y bajan. Ahora\n"
                    + "deben averiguar en qué nivel de los  " + v1 + " existentes se encuentra el\n"
                    + "reactor principal. Se dirigen al primer panel computerizado que\n"
                    + "encuentran y la Princesa Leia intenta acceder a los  planos de  la\n"
                    + "nave pero necesita introducir una clave de acceso. Entonces\n"
                    + "recuerda la información que le proporcionó Lando Calrissian “La\n"
                    + "clave de acceso a los planos de la nave es el factorial de " + v1 + "/10\n"
                    + "(redondeando N hacia abajo), donde N es el nº de niveles”.\n"
                    + "¿Cual es el nivel correcto?");
            v1 = (long) Math.floor(v1 / 10); //Dividimos y redondeamos hacia abajo v1 para calcular la respuesta correcta.
            for (long i = v1; i > 1; i--) {
                total *= i;
            }
            res = sc.nextLong();
            if (res != total) {
                gameOver = true;
            }
        }

        //NIVEL 4
        if (!gameOver) {
            v1 = (long) (10 + Math.random() * (100 - 10 + 1));
            v2 = 1; //Usaremos v2 a modo de booleano para determinar si ha detectado que es primo o no (1 y 0 respectivamente)

            System.out.println("Gracias a la inteligencia de Leia llegan al nivel correcto y\n"
                    + "encuentran la puerta acorazada que da al reactor principal. R2D2\n"
                    + "se conecta al panel de acceso para intentar hackear el sistema y\n"
                    + "abrir la puerta. Para desencriptar la clave necesita verificar si el\n"
                    + "número  " + v1 + "  es  primo  o  no.  Si es  primo  introduce  un 1,  si no lo  es\n"
                    + "introduce un 0.");

            int i = 2;
            while (i < v1 && v2 == 1) {
                if (v1 % i == 0) {
                    v2 = 0;

                }
                i++;
            }

            res = sc.nextLong();
            if (res != v2 || res > 1 || res < 0) { //Aquí validamos si la respuesta es incorrecta o no admitida
                gameOver = true;
            }
        }

        //NIVEL 5
        if (!gameOver) {
            v1 = (long) (5 + Math.random() * (10 - 5 + 1));
            v2 = (long) (5 + Math.random() * (10 - 5 + 1));
            total = 0;
            System.out.println("Consiguen entrar al reactor. Ya solo queda que Luke Skywalker\n"
                    + "coloque la bomba, programe el temporizador y salir de allí\n"
                    + "corriendo. Necesita programarlo para que explote en exactamente\n"
                    + "" + v1 + "  minutos y  " + v2 + "  segundos, el tiempo suficiente para escapar antes\n"
                    + "de que explote pero sin que el sistema de seguridad anti-\n"
                    + "explosivos detecte y desactive la bomba. Pero el temporizador\n"
                    + "utiliza un reloj Zordgiano un tanto peculiar. Para convertir los\n"
                    + "minutos y segundos al sistema Zordgiano hay que sumar el\n"
                    + "factorial de " + v1 + " y el factorial de " + v2 + ". ¿Qué valor debe introducir?");
            for (long i = (v1 - 1); i > 1; i--) { //Realizamos el factorial de v1 y v2 y los almacenamos en v1 y v2 respectivamente
                v1 *= i;
            }
            for (long i = (v2 - 1); i > 1; i--) {
                v2 *= i;
            }
            total = v1 + v2; 
            res = sc.nextLong();
            if (res != total) {
                gameOver = true;
            }
        }

        //Pantalla PERDER
        if (gameOver) { //Solo se ejecutará cuando el jugador pierda.
            System.out.println("Ese no era el código correcto... La misión ha sido un fracaso... :( :( :\n"
                    + "Todavía no eres un Maestro Jedi de las Matemáticas. ¡Vuelve a intentarlo!");
        } else { //En caso contrario, el jugador habrá ganado.
            System.out.println("Luke Skywalker introduce el tiempo correcto, activa el\n"
                    + "temporizador y empiezan a sonar las alarmas. Salen de allí\n"
                    + "corriendo, no hay tiempo que perder. La nave se convierte  en un\n"
                    + "hervidero de soldados de arriba a abajo y entre el caos que les\n"
                    + "rodea consiguen llegar a la nave y salir de allí a toda prisa. A\n"
                    + "medida que se alejan observan por la ventana la imagen de la\n"
                    + "colosal estrella de la muerte explotando en el silencio del espacio,\n"
                    + "desapareciendo para siempre junto a los restos del malvado\n"
                    + "imperio.\n"
                    + "¡Has salvado la galaxia gracias a la Fuerza Jedi de las matemáticas!\n"
                    + "Enhorabuena ;D");
        }

        //FIN
        System.out.println("Gracias por jugar :D");
    }

}
