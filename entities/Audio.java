package entities;

public class Audio extends Multimedia implements Volume {
    private int volume;
    private int time;

    public Audio(String title, int time) {
        super(title);
        this.volume = 3;
        this.time = time;
    }

    public void setVolume(int volume) {
        if (volume >= 0 && volume <= 100)
            this.volume = volume;
        else if (volume < 0)
            System.out.println("Volume al minimo");
        else System.out.println("Volume al massimo");
    }

    @Override
    public void play() {
        for (int i = 0; i < this.time; i++) {
            System.out.print(this.title + " ");
            for (int j = 0; j < this.volume; j++) {
                System.out.print("!");
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
}
