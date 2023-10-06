import entities.Audio;
import entities.Image;
import entities.Multimedia;
import entities.Video;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);


        System.out.println("Quanti elementi vuoi inserire?");
        final int numMultimedia = Integer.parseInt(input.nextLine());
        Multimedia[] multimedia = new Multimedia[numMultimedia];

        Esterno:
        for (int i = 0; i < numMultimedia; i++) {
            System.out.println("Quale elemento multimediale vuoi inserire? (0=AUDIO-1=VIDEO-2=IMMAGINE-9=ESCI");
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
            switch (input.nextLine()) {
                case "1": {
                    if (multimedia[0] instanceof Audio)
                        ((Audio) multimedia[0]).play();
                    else if (multimedia[0] instanceof Image)
                        ((Image) multimedia[0]).show();
                    else
                        ((Video) multimedia[0]).play();
                    break;
                }
                case "2": {
                    if (multimedia[1] instanceof Audio)
                        ((Audio) multimedia[1]).play();
                    else if (multimedia[1] instanceof Image)
                        ((Image) multimedia[1]).show();
                    else
                        ((Video) multimedia[1]).play();
                    break;
                }
                case "3": {
                    if (multimedia[2] instanceof Audio)
                        ((Audio) multimedia[2]).play();
                    else if (multimedia[2] instanceof Image)
                        ((Image) multimedia[2]).show();
                    else
                        ((Video) multimedia[2]).play();
                    break;
                }
                case "4": {
                    if (multimedia[3] instanceof Audio)
                        ((Audio) multimedia[3]).play();
                    else if (multimedia[3] instanceof Image)
                        ((Image) multimedia[3]).show();
                    else
                        ((Video) multimedia[3]).play();
                    break;
                }
                case "5": {
                    if (multimedia[4] instanceof Audio)
                        ((Audio) multimedia[4]).play();
                    else if (multimedia[4] instanceof Image)
                        ((Image) multimedia[4]).show();
                    else
                        ((Video) multimedia[4]).play();
                    break;
                }
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
                                System.out.println("Regola volume vu=v+1 vd=v-1 e=esci da modifica");
                                String str = input.nextLine();
                                if (Objects.equals(str, "vu")) {
                                    ((Audio) multimedia[n]).volumeUp();
                                } else if (Objects.equals(str, "vd")) {
                                    ((Audio) multimedia[n]).volumeDown();
                                } else break Modificatore;
                            }
                        } else if (multimedia[n] instanceof Image) {
                            Modificatore:
                            while (true) {
                                System.out.println("Regola volume lu=l+1 ld=l-1 e=esci da modifica");
                                String str = input.nextLine();
                                if (Objects.equals(str, "lu")) {
                                    ((Image) multimedia[n]).brightnessUp();
                                } else if (Objects.equals(str, "ld")) {
                                    ((Image) multimedia[n]).brightnessDown();
                                } else break Modificatore;
                            }
                        } else if (multimedia[n] instanceof Video) {
                            Modificatore:
                            while (true) {
                                System.out.println("Regola volume vu=volume+1 vd=volume-1 lu=luminosità+1 ld=luminosità-1 e=esci da modifica");
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
            }
        }
        input.close();
    }
}
