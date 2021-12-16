public class Wolf {

    private String sex;
    private String nickname;
    private int weight;
    private int age;
    private String color;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void go() {
        System.out.println("Im go");
    }

    public void sit() {
        System.out.println("Im sit");
    }
    public void run() {
        System.out.println("Im run");
    }

    public void howl() {
        System.out.println("Im howl");
    }

    public void hunt() {
        System.out.println("Im hunts");
    }
}