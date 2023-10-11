public class Test { 

  public static void main(String[] args) {

    String s1 = new String("Welcome to Java!");

    String s2 = s1.toUpperCase();

 

    if (s1 == s2)

      System.out.println("s1 and s2 reference to the same String object");

    else if (s1.equals(s2))

      System.out.println("s1 and s2 have the same contents");

    else

      System.out.println("s1 and s2 have different contents");

  }

}