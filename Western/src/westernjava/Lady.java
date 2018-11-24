/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package westernjava;

import java.util.Random;

/**
 * caractérise l'Humain de type Lady
 *
 * @author Matias & Suarez
 */
public class Lady extends Human {

      boolean isKidnapped;
      String dressColor;
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
      public Lady(boolean isKidnapped, String dressColor, String name, String favoriteDrink, Places place) {
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
            action(hero.name + " a sauvé " + this.name);
            talk("Oooh merci " + hero.name + "!");
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
       * se présenter
       */
      @Override
      public void introduceYourself() {
            action(this.name + " se présente.");
            talk("Hello! My name is " + name + ". I will show this town my beauty!");
      }

}
