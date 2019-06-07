//-----------------------------------------------------------------------------
// HelloUser.java
// Prints greeting to stdout, then prints out some environment information.
//-----------------------------------------------------------------------------
class HelloUser2{
   public static void main( String[] args ){
      String huh = "record scratch \nfreeze frame\nYup, that’s me. \nNo, not that guy, that guy. \nYou’re probably wondering how I got into this situation. I failed last quarter that's pretty much it";
      long time  = System.currentTimeMillis();

      System.out.println("Hi \n"+ huh);
 
      System.out.printf("Time: %tc.%n", time);
   }
}