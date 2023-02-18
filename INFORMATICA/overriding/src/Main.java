class Mammifero {
    public void verso() {

    }
}

class Cane extends Mammifero {
    @Override
    public void verso() {
        System.out.println("Woof!");
    }
}

class Gatto extends Mammifero {
    @Override
    public void verso() {
        System.out.println("Weow!");
    }
}

public class Main {
    public static void main(String[] args) {
        Cane cane = new Cane();
        Gatto gatto = new Gatto();

        cane.verso();
        gatto.verso();
    }
}