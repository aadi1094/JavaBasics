package OOPS.Abstraction.AbstractClass;

/*
 =========================================================================
 PRACTICE PROBLEM 2  --  GAME CHARACTERS
 =========================================================================

 ShapeArea.java showed you abstract METHODS. This one is about the other
 half -- the thing an interface can never give you:

     SHARED STATE and a CONSTRUCTOR in the parent.

 Every character in a game has a name, health and a level. That data is
 identical for all of them, and the RULES about it are identical too
 (health never goes below 0, never above 100). Writing those rules once in
 an abstract parent means no subclass -- including one you write next
 month -- can break them.

 This is Abstraction/Notes PART 6, question 2: "do the implementations
 need to share state?" Yes. So: abstract class, not interface.


 THE CLASS INVARIANT -- must always be true for every character:

     "health is always between 0 and 100, and name is never empty"


 WRITE THE CLASSES

   1. abstract class Player

        FIELDS (all private)
            name     String
            health   int
            level    int

        CONSTRUCTOR  Player(String name, int level)
            - if name is null or empty, use "Unknown" instead
            - health always starts at 100
            - store the level
            - increment a private static int count

        CONCRETE METHODS
            getName()    getHealth()    getLevel()        plain getters

            void takeDamage(int amount)
                 amount <= 0  -> print "Damage must be positive", return
                 otherwise    -> subtract, but CLAMP at 0 (never negative)
                                 print "<name> takes <amt> damage. HP: <hp>"
                                 if health hits 0, also print "<name> is down!"

            void heal(int amount)
                 same shape, but CLAMP at 100 (never more)
                 print "<name> heals <amt>. HP: <hp>"

            final void status()                    <- note: final
                 prints "<name> [Lv<level>] HP:<health> | class: <type()>"

            static int getCount()
                 returns how many players were created

        ABSTRACT METHODS
            abstract String type();        -> "Warrior", "Mage", "Archer"
            abstract void attack();        -> each class fights differently
            abstract int  power();         -> a number, used for sorting later

   2. class Warrior extends Player
        type()   -> "Warrior"
        attack() -> prints "<name> swings a sword!"
        power()  -> level * 12

   3. class Mage extends Player
        type()   -> "Mage"
        attack() -> prints "<name> casts a fireball!"
        power()  -> level * 15
        EXTRA: add  private int mana = 50;  and a  castHeal()  method that
               spends 20 mana and calls heal(30). Print "Not enough mana"
               if mana < 20.

   4. class Archer extends Player
        type()   -> "Archer"
        attack() -> prints "<name> fires an arrow!"
        power()  -> level * 10


 CONSTRAINTS
     - every field private; the parent's fields are NOT protected this
       time, so subclasses must go through takeDamage()/heal()
     - the clamping rules live in the PARENT, exactly once
     - @Override on every implemented method
     - status() is final -- subclasses may call it, never redefine it


 TEST IN MAIN

     Player[] party = { new Warrior("Aditya", 5),
                        new Mage("Sneha", 6),
                        new Archer("Rahul", 6) };

     for (Player p : party) {
         p.status();
         p.attack();
     }

     System.out.println();
     Player w = party[0];
     w.takeDamage(30);
     w.takeDamage(200);       // clamps at 0, does not go negative
     w.heal(500);             // clamps at 100, does not go above
     w.takeDamage(-5);        // refused

     System.out.println();
     System.out.println("Strongest power: " + strongest(party));
     System.out.println("Players created: " + Player.getCount());

 Also write the helper, which is the real point of the exercise:

     static int strongest(Player[] party) {
         int max = 0;
         for (Player p : party) {
             if (p.power() > max) max = p.power();
         }
         return max;
     }

 Read that helper again. It calls power() on a Player, and Player.power()
 has NO BODY. It still works, for every class you have written and every
 class you will write later. That is programming against a contract.


 EXPECTED OUTPUT

     Aditya [Lv5] HP:100 | class: Warrior
     Aditya swings a sword!
     Sneha [Lv6] HP:100 | class: Mage
     Sneha casts a fireball!
     Rahul [Lv6] HP:100 | class: Archer
     Rahul fires an arrow!

     Aditya takes 30 damage. HP: 70
     Aditya takes 200 damage. HP: 0
     Aditya is down!
     Aditya heals 500. HP: 100
     Damage must be positive

     Strongest power: 90
     Players created: 3

 Check that by hand: Warrior 5*12=60, Mage 6*15=90, Archer 6*10=60.


 AFTER IT WORKS -- FIVE THINGS TO TRY

   A) Add  Player p = new Player("Ghost", 1);  -- must not compile.

   B) Write  class Healer extends Player  with ONLY type() implemented.
      Read the error listing the two methods you still owe. Then add
      `abstract` to Healer and watch it compile. Notes PART 4.

   C) Try to override status() in Warrior. It fails -- it is final. Then
      ask yourself why status() was made final but attack() abstract. The
      answer is the difference between "this is fixed for everyone" and
      "everyone decides this for themselves".

   D) In Mage, try  health = 999;  directly. It fails -- health is private
      in Player, and private members are not inherited. Change the field to
      protected and it compiles. Now the clamping rule you wrote once can
      be bypassed by any subclass. Change it back. That is the argument
      against protected fields, and it is Encapsulation/Notes PART 4.

   E) Add a  Player[] party2  containing 100 characters and call
      strongest() on it. Not one line of that method changes. Now add a
      new class Necromancer -- still not one line changes.


 A NAMING ASIDE

   Do not call the abstract class `Character`. java.lang.Character already
   exists and is imported into every file automatically. Your class would
   win the name lookup inside this package and confuse you badly the first
   time you need the real one. This is why the class is called Player.

 =========================================================================
*/

public class GameCharacter {

    public static void main(String[] args) {

        // TODO uncomment as you write the classes below
         Player[] party = { new Warrior("Aditya", 5),
                            new Mage("Sneha", 6),
                            new Archer("Rahul", 6) };

         for (Player p : party) {
             p.status();
             p.attack();
         }

         System.out.println();
         Player w = party[0];
         w.takeDamage(30);
         w.takeDamage(200);
         w.heal(500);
         w.takeDamage(-5);

         System.out.println();
         System.out.println("Strongest power: " + strongest(party));
         System.out.println("Players created: " + Player.getCount());
    }

    // TODO write the helper described in the spec above
     static int strongest(Player[] party) {
         int max = 0;
         for (Player p : party) {
             if (p.power() > max) {
                 max = p.power();
             }
         }
         return max;
     }
}


abstract class Player {

    private static int count = 0;

    private final String name;
    private int health;
    private final int level;

    Player(String name, int level) {
        if (name == null || name.isEmpty()) {
            name = "Unknown";
        }
        this.name = name;
        this.health = 100;
        this.level = level;
        count++;
    }

    public String getName()  { return name; }
    public int    getHealth(){ return health; }
    public int    getLevel() { return level; }

    void takeDamage(int amount) {
        if (amount <= 0) {
            System.out.println("Damage must be positive");
            return;
        }
        health -= amount;
        if (health < 0) {
            health = 0;
        }
        System.out.println(name + " takes " + amount + " damage. HP: " + health);
        if (health == 0) {
            System.out.println(name + " is down!");
        }
    }

    void heal(int amount) {
        if (amount <= 0) {
            System.out.println("Heal must be positive");
            return;
        }
        health += amount;
        if (health > 100) {
            health = 100;
        }
        System.out.println(name + " heals " + amount + ". HP: " + health);

    }

    final void status() {
        System.out.println(name + " [Lv" + level + "] HP:" + health
                + " | class: " + type());
    }


    static int getCount() {
        return count;
    }

          abstract String type();
          abstract void   attack();
          abstract int    power();
}


class Warrior extends Player {

    Warrior(String name, int level) {
        super(name, level);
    }

    // TODO @Override type(), attack(), power()
    @Override
    String type() {
        return "Warrior";
    }
    @Override
    void attack() {
        System.out.println(getName() + " swings a sword!");
    }
    @Override
    int power() {
        return getLevel() * 12;
    }
}


class Mage extends Player {

    private int mana = 50;

    Mage(String name, int level) {
        super(name, level);
    }

    @Override
    String type() {
        return "Mage";
    }
    @Override
    void attack() {
        System.out.println(getName() + " casts a fireball!");
    }
    @Override
    int power() {
        return getLevel() * 15;
    }

    void castHeal() {

        if (mana<20){
            System.out.println("Not enough mana");
            return;
        }else{
            mana-=20;
            heal(30);
        }
    }
}


class Archer extends Player {

    Archer(String name, int level) {
        super(name, level);
    }


    @Override
    String type() {
        return "Archer";
    }
    @Override
    void attack() {
        System.out.println(getName() + " fires an arrow!");
    }
    @Override
    int power() {
        return getLevel() * 10;
    }


}
