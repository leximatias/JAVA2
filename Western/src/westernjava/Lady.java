package westernjava;

import java.util.Random;

/**
 * characterizes the Lady-type human
 *
 * @author Matias & Suarez
 */
public class Lady extends Human {

      boolean isKidnapped;
      String dressColor;
      String state;
      Random random = new Random();

      /**
       * constructor
       *
       * @param isKidnapped true si kidnapper
       * @param dressColor la couleur de sa culotte
       * @param name nom du personnage
       * @param favoriteDrink boisson favorite du personnage
       * @param place place actuel du personnage
       */
      public Lady(boolean isKidnapped, String dressColor, String name, String favoriteDrink, Places place, String state) {
            super(name, favoriteDrink, place);
            this.isKidnapped = isKidnapped;
            this.dressColor = dressColor;
      }

      /**
       * se fait kidnaper par badboy
       *
       * @param badboy le kidnappeur
       */
      public void getKidnapped(Bandit badboy) {
            action(badboy.name + " has kidnapped " + this.name);
            talk("Let me go " + badboy.name + "!");
            isKidnapped = true;
      }

      /**
       * se fait kidnaper par badgirl
       *
       * @param badgirl la kidnappeuse
       */
      public void getKidnapped(BanditLady badgirl) {
            action(badgirl.name + " has kidnapped " + this.name);
            talk("Let me go, " + badgirl.name + "!");
            isKidnapped = true;
      }

      /**
       * se fait kidnaper par badboy
       *
       * @param badboy le kidnappeur
       */
      public void getKidnapped(BadCop badboy) {
            action(badboy.name + " has kidnapped" + this.name);
            talk("Let me go,  " + badboy.name + "!!");
            isKidnapped = true;
      }

      /**
       * se faire liberer par hero
       *
       * @param hero le héro
       */
      public void getFree(Cowboy hero) {
            action(hero.name + " saves " + this.name);
            talk("AHH thank you so much " + hero.name + "!!!");
            isKidnapped = false;
      }

      /**
       * changer de culotte
       */
      public void getChanged() {
            String[] arrColors = {"rose", "black", "blue", "white"};
            int colors = random.nextInt(arrColors.length);
            dressColor = arrColors[colors];
            action(this.name + " changes dress");
            talk("I love my new " + this.dressColor + " dress.");     
      }

      /**
       * introduction
       */
      @Override
      public void introduceYourself() {
            action(this.name + " presents");
            talk("Hello! My name is " + name + ". I will show this town my beauty!");
      }

}
