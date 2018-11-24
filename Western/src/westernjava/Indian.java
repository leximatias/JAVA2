/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package westernjava;

/**
 * caractérise l'Humain de type Indian
 *
 * @author Matias & Suarez
 */
public class Indian extends Human {

      int nbFeather;
      String totem;

      /**
       * construtor
       *
       * @param nbFeather nombre de plume sur sa coiffe
       * @param totem nom de son totem
       * @param name nom du personnage
       * @param favoriteDrink boisson favorite du personnage
       * @param place place actuel du personnage
       */
      public Indian(int nbFeather, String totem, String name, String favoriteDrink, Places place) {
            super(name, favoriteDrink, place);
            this.nbFeather = nbFeather;
            this.totem = totem;
      }

      /**
       * met en forme lors que le personnage parle
       *
       * @param say ce qu'il dit
       */
      @Override
      public void talk(String say) {
        System.out.println("Indian " + name + ": " + say);
      }

      /**
       * le personnage se présente
       */
      @Override
      public void introduceYourself() {
        action(this.name + "arrives..");
        talk("Greetings pale face! I am " + name + " " + totem + ". I am part of the tribe at the end of the city. ");
      }

}
