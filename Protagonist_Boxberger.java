public class Protagonist_Boxberger {
    public static void main(String[] args) {
        Hero player1 = new Hero("Steve");
        for (int i = 0; i < 8; i++) {
         player1.update();
         System.out.println(player1);
        }
        player1.eat();
        player1.eat();
        System.out.println(player1);
        
        Hero player2 = new Hero();
        player2.update();
        System.out.println(player2);
        player2.eat();
        System.out.println(player2);
    }
    
    public static class Hero {
      private String name;
      private int hp = 100;
      
      //Constructors
      public Hero(String name) {
         this.name = name;
      }
      
      public Hero() {
         name = "Anonymous";
      }
      
      //Methods
      public void update() {
         hp -= (int)(Math.random()*10);
      }
      
      public void eat() {
         int healAmount = (int)(Math.random()*25);
         System.out.println(name + " ate and restored " + healAmount + " health \n");
         hp += healAmount;
      }
      
      public String toString() {
         return name + " is currently at " + hp + " health \n";
      } 
    }
}