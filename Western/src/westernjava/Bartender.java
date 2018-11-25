/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package westernjava;

/**
 * characterizes the Bartender Human type
 *
 * @author Matias & Suarez
 */
public class Bartender extends Human {

      /**
       * constructor
        *
        * @param name name of the character
        * @param favoriteDrink favorite drink of the character
        * @param place character's current place
        * /
       */
      public Bartender(String name, String favoriteDrink, Places place, String barName) { 
            super(name, favoriteDrink, place);
            // this.barName=barName;
      }

      /**
        * serve a drink to someone
        *
        * @param someone someone
       */
      public void serve(Human someone) {
            action(this.name + " serves a glass to " + someone.name);
            talk("Here is your drink," + someone.name +"." );
      }

      /**
        * formatting his speech in the console
        *
        * @param say what he says
       */
      @Override
      public void talk(String say) {
            System.out.println("Bartender " + name + ": " + say);
      }

      /**
       * introduces himself
       */
      @Override
      public void introduceYourself() {
            action(this.name + " presents.");
            talk("Helo " + name + ", it is a pleasure to serve you!");
      }
}
