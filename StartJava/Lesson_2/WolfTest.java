public class WolfTest {
    public static void main(String[] args) {
        Wolf wolf = new Wolf();
        wolf.sex = "male";
        wolf.nickname = "Bob";
        wolf.weight = 90;
        wolf.age = 20;
        wolf.color = "red";

        System.out.println(wolf.sex);
        System.out.println(wolf.nickname);
        System.out.println(wolf.weight);
        System.out.println(wolf.age);
        System.out.println(wolf.color);

        wolf.go();
        wolf.sit();
        wolf.run();
        wolf.howl();
        wolf.hunts();
    }
}