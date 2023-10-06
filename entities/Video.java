package entities;

public class Video extends Multimedia implements Volume, Brightness {

    private int volume;
    private int brightness;

    private int time;

    public Video(String title, int time) {
        super(title);
        this.volume = 3;
        this.brightness = 3;
        this.time = time;
    }

    public void setVolume(int volume) {
        if (volume >= 0 && volume <= 100)
            this.volume = volume;
        else if (volume < 0)
            System.out.println("Volume al minimo");
        else System.out.println("Volume al massimo");
    }

    public void setBrightness(int brightness) {
        if (brightness >= 0 && brightness <= 100)
            this.brightness = brightness;
        else if (brightness < 0)
            System.out.println("Luminosità al minimo");
        else System.out.println("Luminosità al massimo");
    }

    @Override
    public void play() {
        for (int i = 0; i < this.time; i++) {
            System.out.print(this.title + " ");
            for (int j = 0; j < this.volume; j++) {
                System.out.print("!");
            }
            System.out.print("  ");
            for (int j = 0; j < this.brightness; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }

    @Override
    public void volumeUp() {
        setVolume(this.volume + 1);
    }

    @Override
    public void volumeDown() {
        setVolume(this.volume - 1);
    }

    @Override
    public void brightnessUp() {
        setBrightness(this.brightness + 1);
    }

    @Override
    public void brightnessDown() {
        setBrightness(this.brightness - 1);
    }
}
