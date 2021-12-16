public class JaegerTest {

    public static void main(String[] args) {
        Jaeger alphaJaeger = new Jaeger();
        alphaJaeger.setModelName("Cherno Alpha");
        alphaJaeger.setMark("Mark-1");
        alphaJaeger.setOrigin("Russia");
        alphaJaeger.setHeight(280);
        alphaJaeger.setWeight(2.412f);
        alphaJaeger.setStrength(10);
        alphaJaeger.setArmor(10);

        System.out.println("Jaeger " + alphaJaeger.getModelName() + ":");
        System.out.println(alphaJaeger.scanKaiju());
        alphaJaeger.move();
        alphaJaeger.userVortexCannon();
        System.out.println("Strenght: " + alphaJaeger.getArmor());

        Jaeger typhoonJaeger = new Jaeger("Crimson Typhoon", "Mark-4", "China", 250, 1.722f, 8, 6);

        System.out.println("Jaeger " + typhoonJaeger.getModelName() + ":");
        System.out.println(typhoonJaeger.scanKaiju());
        typhoonJaeger.move();
        typhoonJaeger.userVortexCannon();

        typhoonJaeger.setArmor(10);
        System.out.println("Armor: " + typhoonJaeger.getArmor());

    }
}