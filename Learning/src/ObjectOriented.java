public class ObjectOriented{
    public static void main(String[] args){
        City Beijing = new City();
        Beijing.name = "北京";
        Beijing.latitude = 39.903;
        Beijing.longitude = 116.401;
        Beijing.setPopulation(114514);
        System.out.println(Beijing.name);
        System.out.println("location: " + Beijing.latitude + ", " + Beijing.longitude);
        System.out.println("人口" + Beijing.name);

        People ming = new People("xiao ming", 12);
        System.out.println(ming.getName() + " " + ming.getAge());
    }
}

/** 练习
 * 请定义一个City类，该class具有如下字段:
 * name: 名称，String类型
 * latitude: 纬度，double类型
 * longitude: 经度，double类型
 * 实例化几个City并赋值，然后打印。
 * 新建一个private属性，使用getter setter赋值访问
 */

class City{
    public String name;
    public double latitude;
    public double longitude;
    private int population;

    public void setPopulation(int population){
        if (population < 100000){
            this.population = population;
        } else {
            System.out.println("数值太小");
        }
    }

    public int getPopulation(){
        return this.population;
    }
 }


/**
 * 练习
 * 1. 请给Person类增加(String, int)的构造方法：
 * 2. 给Person增加重载方法setName(String, String):
 */

 class People{
    protected String name;
    protected int age;
    private static int count;
    public static void getCount(){
        System.out.println(count);
    }

    public People(){
        this("Lihua",18);
    }

    public People(String name){
        this(name, 18);
    }

    public People(int age){
        this("lihua", age);
    }

    public People(String name, int age){
        count++;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String firstName, String secondName){
        this.name = firstName + secondName;
    }

    public void setName(String fullName){
        this.name = fullName;
    }

 }


/**
 * Pratise:
 * 定义PrimaryStudent，从Student继承，并新增一个grade字段：
 */
 class Student extends People{
    protected int score;

    public Student(String name, int age, int score){
        super(name, age);
        this.score = score;
    }

    public int getScore(){
        return this.score;
    }
 }

 class PrimaryStudent extends Student{
    protected String grade;

    public PrimaryStudent(String name, int age, int score, String grade){
        super(name, age, score);
        this.grade = grade;
    }

    public String getGrade(){
        return this.grade;
    }
 }

