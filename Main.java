import entities.Audio;
import entities.Image;
import entities.Multimedia;
import entities.Video;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);


        System.out.println("Quanti elementi vuoi inserire?");
        final int numMultimedia = Integer.parseInt(input.nextLine());
        Multimedia[] multimedia = new Multimedia[numMultimedia];

        Esterno:
        for (int i = 0; i < numMultimedia; i++) {
            System.out.println("Quale elemento multimediale vuoi inserire? (0=AUDIO-1=VIDEO-2=IMMAGINE-9=ESCI)");
            switch (Integer.parseInt(input.nextLine())) {
                case 0: {
                    System.out.println("Inserisci il titolo dell'audio");
                    String title = input.nextLine();
                    System.out.println("inserisci un numero intero per la durata");
                    int t = Integer.parseInt(input.nextLine());
                    multimedia[i] = new Audio(title, t);
                    break;
                }
                case 1: {
                    System.out.println("Inserisci il titolo del video");
                    String title = input.nextLine();
                    System.out.println("inserisci un numero intero per la durata");
                    int t = Integer.parseInt(input.nextLine());
                    multimedia[i] = new Video(title, t);
                    break;
                }
                case 2: {
                    System.out.println("Inserisci il titolo dell'immagine");
                    String title = input.nextLine();
                    multimedia[i] = new Image(title);
                    break;
                }
                case 9: {
                    return;
                }
                default: {
                    System.out.println("Valore non valido");
                    i--;
                    break;
                }
            }
        }
        System.out.println("-----------------------------------------");
        OutWhile:
        while (true) {
            System.out.println("Inserisci un numero da 1 a " + numMultimedia + " per riprodurre (0=quit & :m=modifica)");

            String str = input.nextLine();
            switch (str) {

                case "0": {
                    break OutWhile;
                }
                case ":m": {
                    System.out.println("Inserisci un numero da 1 a " + (numMultimedia) + " per selezionare l'elemento da modificare");
                    int n = Integer.parseInt(input.nextLine()) - 1;
                    if (n >= 0 && n < numMultimedia) {
                        if (multimedia[n] instanceof Audio) {
                            Modificatore:
                            while (true) {
                                System.out.println("Regola volume vu=volume+1 vd=volume-1 e=esci ");
                                switch (input.nextLine()) {
                                    case "vu": {
                                        ((Audio) multimedia[n]).volumeUp();
                                        break;
                                    }
                                    case "vd": {
                                        ((Audio) multimedia[n]).volumeDown();
                                        break;
                                    }
                                    default:
                                        break Modificatore;
                                }
                            }
                        } else if (multimedia[n] instanceof Image) {
                            Modificatore:
                            while (true) {
                                System.out.println("Regola luminosità lu=luminosità+1 ld=luminosità-1 e=esci ");
                                switch (input.nextLine()) {
                                    case "lu": {
                                        ((Image) multimedia[n]).brightnessUp();
                                        break;
                                    }
                                    case "ld": {
                                        ((Image) multimedia[n]).brightnessDown();
                                        break;
                                    }
                                    default:
                                        break Modificatore;
                                }
                            }
                        } else if (multimedia[n] instanceof Video) {
                            Modificatore:
                            while (true) {
                                System.out.println("Regola volume e luminosità vu=volume+1 vd=volume-1 lu=luminosità+1 ld=luminosità-1 e=esci ");
                                switch (input.nextLine()) {
                                    case "vu": {
                                        ((Video) multimedia[n]).volumeUp();
                                        break;
                                    }
                                    case "vd": {
                                        ((Video) multimedia[n]).volumeDown();
                                        break;
                                    }
                                    case "lu": {
                                        ((Video) multimedia[n]).brightnessUp();
                                        break;
                                    }
                                    case "ld": {
                                        ((Video) multimedia[n]).brightnessDown();
                                        break;
                                    }
                                    default:
                                        break Modificatore;
                                }

                            }
                        }
                    } else System.out.println("Elemento inesistente");

                    break;
                }
                default: {
                    int n = Integer.parseInt(str) - 1;
                    if (n < multimedia.length) {
                        if (multimedia[n] instanceof Audio)
                            ((Audio) multimedia[n]).play();
                        else if (multimedia[n] instanceof Image)
                            ((Image) multimedia[n]).show();
                        else if (multimedia[n] instanceof Video)
                            ((Video) multimedia[n]).play();
                    } else System.out.println("Elemento inesistente");
                }
            }
        }
        input.close();
    }
}
