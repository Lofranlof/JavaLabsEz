public class U0901Main 
{
    public static void main(String[] args) {
    Integer intArr[] = { 10, 20, 15 };
    Float floatArr[] = { 1.1f, 2.2f, 3.3f };
    // String stringArr[] = { "Hello", "World" };
    U0901WorkArray insWorkArrayInt = new U0901WorkArray<>(intArr);
    U0901WorkArray insWorkArrayFloat = new U0901WorkArray<>(floatArr);
    // U0901WorkArray stringArray = new U0901WorkArray<>(stringArr);
    System.out.println(insWorkArrayFloat.sum());
    System.out.println(insWorkArrayInt.sum());
    // System.out.println(stringArray.sum());

    }
}
