/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package westernjava;

/**
 * caractérise un Humain
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
       * @param name nom du personnage
       * @param favoriteDrink boisson favorite du personnage
       * @param place place actuel du personnage
       */
      public Human(String name, String favoriteDrink, Places place) {
            this.name = name;
            this.favoriteDrink = favoriteDrink;
            this.place = place;
            place.enter(this);
      }

      /**
       * mets en forme sa parole dans la console
       *
       * @param say ce qu'il dit
       */
      public void talk(String say) {
            System.out.println(name + ": " + say);
      }

      /**
       * mets en forme son action dans la console
       *
       * @param act
       */
      public void action(String act) {
            System.out.println("***" + act + "***");
      }

      /**
       * permet de se présenter
       */
      public void introduceYourself() {
            action(this.name + " presents.");
            talk("Hello! My name is " + name + ". I am a new citizen in town.");
      }

      /**
       * permet de parler à quelqu'un
       *
       * @param someone le compagnon de parole
       */
      public void talkToSomeone(Human someone) {
            introduceYourself();
            someone.introduceYourself();

      }

      /**
       * permet d'obtenir le nom du personnage
       *
       * @return le nom du personnage
       */
      public String getName() {
            return name;
      }

      /**
       * permet d'aller à un endroit
       *
       * @param places la destination
       */
      public void goTo(Places places) {
            place.exit(this);
            place = places;
            place.enter(this);
            action(name + " entered " + place.name);
      }

      /**
       * permet de sortir d'un endroit
       */
      public void goOut() {
            place.exit(this);
            action(name + " est sorti sur " + place.name);
      }

      /**
       * permet de commander un verre au barman
       *
       * @param favoriteDrink le verre qu'il va commander
       */
      public void orderADrink(String favoriteDrink) {
            Bar bar = (Bar) this.place;
            Bartender barman = bar.getBarman();
            action(name + " orders a drink");
            talk("Hey " + barman.name + " can I order a glass of " + favoriteDrink+".");
            
            barman.serve(this);

      }

}
