import entities.Audio;
import entities.Image;
import entities.Multimedia;
import entities.Video;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final int numMultimedia = 2;
        Scanner input = new Scanner(System.in);
        Multimedia[] multimedia = new Multimedia[numMultimedia];

        Esterno:
        for (int i = 0; i < numMultimedia; i++) {
            System.out.println("Quale elemento multimediale vuoi inserire? (0=AUDIO-1=VIDEO-2=IMMAGINE-9=INTERROMPI");
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
       
        OutWhile:
        while (true) {
            System.out.println("Inserisci un numero da 1 a " + numMultimedia + " per riprodurre (:q=quit)");
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
                case ":q": {
                    break OutWhile;
                }
            }
        }
        input.close();
    }
}
