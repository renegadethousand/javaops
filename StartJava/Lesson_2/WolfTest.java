public class WolfTest {
    public static void main(String[] args) {
        Wolf wolf = new Wolf();
        wolf.setSex("male");
        wolf.setNickname("Bob");
        wolf.setWeight(90);
        wolf.setAge(20);
        wolf.setColor("red");

        System.out.println(wolf.getSex());
        System.out.println(wolf.getNickname());
        System.out.println(wolf.getWeight());
        System.out.println(wolf.getAge());
        System.out.println(wolf.getColor());

        wolf.go();
        wolf.sit();
        wolf.run();
        wolf.howl();
        wolf.hunt();
    }
}