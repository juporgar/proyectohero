package proyectojj;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        int turnoDefensaHero = 0;
        int turnoFuerza= 0;
        boolean salir = false;
        int victoria=0;
        int derrota=0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Bienvenido al juego se un heroe y mata a los villanos");
            System.out.println("¿Que te apetece hacer?");
            System.out.println("1º Iniciar");
            System.out.println("2º Estadisticas");
            System.out.println("0º Salir");
            int decision = sc.nextInt();

            if (decision == 1) {
                //Definición de personajes

                Meta villain = new Meta();
                villain.setName("Doctor Nefasto");
                villain.setDef(3);
                villain.setStr(12);

                //Presentación de la escena

                System.out.println(villain.name + " está haciendo de las suyas.");
                sc.nextLine();
                Hero superhero = new Hero();
                System.out.println("¡Pero aquí viene " + superhero.name + " para salvar el día!");
                sc.nextLine();
                System.out.println("Fuerza: " + superhero.str);
                System.out.println("Defensa: " + superhero.def);
                System.out.println("Puntos de vida: " + superhero.hp);
                System.out.println("Experiencia: " + superhero.exp);
                System.out.println("Nivel: " + superhero.lv);
                System.out.println("Puntos para siguiente nivel: " + superhero.nextlv);
                System.out.println("Posibilidad de crítico: " + superhero.crit);
                System.out.println("Índice de evasión: " + superhero.ev);
                sc.nextLine();

                //Turno del héroe

                while (villain.hp > 0 && superhero.hp > 0) {
                    System.out.println("1º Atacar");
                    System.out.println("2º Defenderte");
                    System.out.println("3º Inventario");
                    System.out.println("4º Pasar turno");
                    int combate = sc.nextInt();
                    if(combate==1){
                    //Atacar
                        if (superhero.str > villain.def) {
                            System.out.println("¡Bam! " + superhero.name + " le arrea un soplamocos a " + villain.name + " de " + (superhero.str - villain.def) * 3 + " puntos de daño");
                            villain.hp -= ((superhero.str - villain.def) * 3);
                        } else {
                            System.out.println(superhero.name + " pega como una niña y no hace ná");

                        }
                        sc.nextLine();
                        System.out.println(villain.name + " : " + villain.hp + " de vida restante.");
                        //Duración de Poción de fuerza
                        if(turnoFuerza>0){
                        turnoFuerza = turnoFuerza -1;
                            if(turnoFuerza==0){
                                superhero.str= superhero.str - 5;
                                System.out.println("Se te acabo la poción de fuerza y tu fuerza actual es: " + superhero.str);
                            }
                        }
                        //Turno del villano
                        sc.nextLine();
                        if (villain.str > superhero.def) {
                            System.out.println("¡Bam! " + villain.name + " le arrea un soplamocos a " + superhero.name + " de " + (villain.str - superhero.def) * 1 + " puntos de daño");
                            superhero.hp -= ((villain.str - superhero.def) * 3);
                        } else {
                            System.out.println(villain.name + " pega como una niña y no hace ná");
                        }
                        sc.nextLine();
                        System.out.println(superhero.name + " : " + superhero.hp + " de vida restante.");
                    }else if(combate == 2){
                // Defensa
                        System.out.println("Te pones en modo defensivo en este turno.");
                        System.out.println("Tu defensa era: " + superhero.def);
                        superhero.def= superhero.def + 2;
                        System.out.println("Tu defensa es: " + superhero.def);
                        turnoDefensaHero = turnoDefensaHero + 1;
                        //Turno del villano poniendote en defensivo
                        sc.nextLine();
                        if (villain.str > superhero.def) {
                            System.out.println("¡Bam! " + villain.name + " le arrea un soplamocos a " + superhero.name + " de " + (villain.str - superhero.def) * 1 + " puntos de daño");
                            superhero.hp -= ((villain.str - superhero.def) * 3);
                        } else {
                            System.out.println(villain.name + " pega como una niña y no hace ná");
                        }
                        sc.nextLine();
                        System.out.println(superhero.name + " : " + superhero.hp + " de vida restante.");
                        if(turnoDefensaHero>0){
                            turnoDefensaHero = turnoDefensaHero -1;
                            if(turnoDefensaHero == 0){
                                superhero.def = superhero.def - 2;
                                System.out.println("Tu defensa vuelve a ser " + superhero.def);
                            }
                        }
                    }else if(combate == 3){
                //Inventario
                        System.out.println("Rebuscar entre los objetos de tu inventario. ¿Cual quieres usar?");
                        System.out.println("1º Poción de Vida");
                        System.out.println("2º Poción de Fuerza");
                        int inventario = sc.nextInt();
                        if(inventario==1){
                            System.out.println("Te tomas una poción de salud que te ayuda a curarte de tus pupas.");
                            System.out.println("Tenias " + superhero.hp + " de vida");
                            superhero.hp= superhero.hp +5;
                            System.out.println("y ahora tienes: " + superhero.hp);
                        }else if(inventario==2){
                            System.out.println("Te tomas una poción de fuerza que hace sentirte como su fueras hulk con hormonas");
                            System.out.println("Tu fuerza base es de " + superhero.str);
                            superhero.str= superhero.str+5;
                            turnoFuerza= 1;
                            System.out.println("Y ahora tu fuerza actual es de: " + superhero.str);
                        }
                //Pasar turno
                    }else if(combate==4){
                        System.out.println("Ignoras al enemigo y pasas turno.");
                    }
                }
                //Resolución

                if (villain.hp <= 0) {
                    System.out.println(villain.name + " se tambalea y cae al suelo, lamentando el día en que se enfrentó a " + superhero.name);
                    System.out.println("¡" + superhero.name + " vuelve a triunfar!");
                    victoria= victoria + 1;
                }

                if (superhero.hp <= 0) {
                    System.out.println("Game over, el mundo está en el caos, eres un manta");
                    derrota= derrota + 1;
                }
            } else if (decision == 2) {
                System.out.println("Bienvenido a las estadisticas:");
                System.out.println("Has ganado " + victoria + " combates.");
                System.out.println("Has perdido " + derrota + " combates.");
            } else if (decision == 0) {
                System.out.println("Gracias por tu participación");
                salir=true;
            }
        }while(salir == false);
    }
}
