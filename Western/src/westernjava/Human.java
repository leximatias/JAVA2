package westernjava;

/**
 * characterizes a Human
 *
 * @author Matias & Suarez
 */
public class Human {

      String name;
      String favoriteDrink;
      Places place;

      /**
        * constructor
        *
        * @param name name of the character
        * @param favoriteDrink favorite drink of the character
        * @param place character's current place
       */
      public Human(String name, String favoriteDrink, Places place) {
            this.name = name;
            this.favoriteDrink = favoriteDrink;
            this.place = place;
            place.enter(this);
      }

      /**
        * put his speech in the console
        *
        * @param say what he says
        * /
       */
      public void talk(String say) {
            System.out.println(name + ": " + say);
      }

      /**
        * puts his action in the console
        *
        * @param act
       */
      public void action(String act) {
            System.out.println("***" + act + "***");
      }

      /**
       * allows you to introduce yourself
       */
      public void introduceYourself() {
            action(this.name + " presents.");
            talk("Hello! My name is " + name + ". I am a new citizen in town.");
      }

      /**
        * lets talk to someone
        *
        * @param someone the talk companion
       */
      public void talkToSomeone(Human someone) {
            introduceYourself();
            someone.introduceYourself();

      }

      /**
       * get the name of the character
        *
        * @return the name of the character
       */
      public String getName() {
            return name;
      }

      /**
       * lets go to a place
        *
        * @param places the destination
       */
      public void goTo(Places places) {
            place.exit(this);
            place = places;
            place.enter(this);
            action(name + " entered " + place.name);
      }

      /**
       * get out of place
       */
      public void goOut() {
            place.exit(this);
            action(name + " est sorti sur " + place.name);
      }

      /**
       * allows to order a glass to the bartender
        *
        * @param favoriteDrink the glass he will order
       */
      public void orderADrink(String favoriteDrink) {
            Bar bar = (Bar) this.place;
            Bartender barman = bar.getBarman();
            action(name + " orders a drink");
            talk("Hey " + barman.name + " can I order a glass of " + favoriteDrink+".");
            
            barman.serve(this);

      }

}
