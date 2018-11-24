/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package westernjava;

/**
 * caractérise l'Humain de type Barman
 *
 * @author Julie Robillart
 */
public class Bartender extends Human {

      /**
       * constructor
       *
       * @param name nom du personnage
       * @param favoriteDrink boisson favorite du personnage
       * @param place place actuel du personnage
       */
      public Bartender(String name, String favoriteDrink, Places place) { //string barName
            super(name, favoriteDrink, place);
            // this.barName=barName;
      }

      /**
       * ervir un verre à quelqu'un
       *
       * @param someone quelqu'un
       */
      public void serve(Human someone) {
            action(this.name + " serves a glass to " + someone.name);
            talk("Here is your drink," + someone.name +"." );
      }

      /**
       * mise en forme de sa parole dans la console
       *
       * @param say ce qu'il dit
       */
      @Override
      public void talk(String say) {
            System.out.println("Bartender " + name + ": " + say);
      }

      /**
       * se présenter
       */
      @Override
      public void introduceYourself() {
            action(this.name + " presents.");
            talk("Helo " + name + ", it is a pleasure to serve you!");
      }
}
