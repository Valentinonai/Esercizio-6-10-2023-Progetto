package entities;

public class Image extends Multimedia implements Brightness {
    private int brightness;

    public Image(String title) {
        super(title);
        this.brightness = 3;
    }

    public void setBrightness(int brightness) {
        if (brightness >= 0 && brightness <= 100)
            this.brightness = brightness;
        else if (brightness < 0)
            System.out.println("Luminosità al minimo");
        else System.out.println("Luminosità al massimo");
    }

    public void show() {
        System.out.print(this.title + " ");
        for (int i = 0; i < this.brightness; i++) {
            System.out.print("*");
        }
        System.out.println("\n");
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
