/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package westernjava;

/**
 * caractérise l'Humain de type Cowboy
 *
 * @author Matias & Suarez
 */
public class Cowboy extends Human implements PaleFace{

      int popularity;
      String adjective;
      int money;

      /**
       * constructor
       *
       * @param popularity popularité
       * @param adjective adjectif
       * @param money argent gagné avec les récompenses
       * @param name nom du personnage
       * @param favoriteDrink boisson favorite du personnage
       * @param place place actuel du personnage
       */
      public Cowboy(int popularity, String adjective, int money, String name, String favoriteDrink, Places place) {
            super(name, favoriteDrink, place);
            this.popularity = popularity;
            this.adjective = adjective;
            this.money = money;
      }

      /**
       * tirer sur un méchant et l'emprisonner
       *
       * @param badboy le méchant
       * @param cop le sherif qui va l'emprissoner
       * @param places liste des places disponibles
       */
      public void shoot(Bandit badboy, Sheriff cop, Places[] places) {
            action(this.name + "shot " + badboy.name);
            action("Bang!!!");
            talk("I have caught you " + badboy.name + ".");
            cop.catchABandit(badboy, places);
            getReward(badboy);
      }

      /**
       * tirer sur un méchant et l'emprisonner
       *
       * @param badboy le méchant
       * @param cop le sherif qui va l'emprissoner
       * @param places liste des places disponibles
       */
      public void shoot(BadCop badboy, Sheriff cop, Places[] places) {
            action(this.name + " shot " + badboy.name);
            action("Bang!!!");
            talk("I caught you " + badboy.name + ".");
            cop.catchABandit(badboy, places);
            getReward(badboy);
      }

      /**
       * liberer une fille kidnapper
       *
       * @param girl la fille kidnappée
       */
      public void freeTheLady(Lady girl) {
            if (girl.isKidnapped) {
                  action(this.name + " freed " + girl.name);
                  talk("You are free" + girl.name + "!!");
                  girl.getFree(this);
            }

      }

      /**
       * obtenir la récompense
       *
       * @param badboy le méchant d'où vient la récompense
       */
      public void getReward(Bandit badboy) {
            action(this.name + " gets reward from " + badboy.name);
            money += badboy.reward;
            badboy.reward = 0;
      }

      /**
       * obtenir la récompense
       *
       * @param badboy le méchant d'où vient la récompense
       */
      public void getReward(BadCop badboy) {
            action(this.name + " gets reward from " + badboy.name);
            money += badboy.reward;
            badboy.reward = 0;
      }

     
      @Override
      public void introduceYourself() {
            action(this.name + " presents.");
            talk("People call me  " + name + "the "+ this.adjective + ". I'm the new cowboy.");
      }
      
//      public void Scalp(Indian indian){
//        
//        }

}
