/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package westernjava;

/**
 * caractérise l'Humain de type Thug
 *
 * @author Matias & Suarez
 */
public class Bandit extends Human implements OutOfLaw {

      int nbKidnappedLady;
      int reward;
      String look;
      boolean isInJail;

      /**
       * constructor
       *
       * @param nbKidnappedLady nombre de fille kidnappées
       * @param reward récompense sur sa tête
       * @param look attitude
       * @param isInJail true si emprisonné
       * @param name nom du personnage
       * @param favoriteDrink boisson favorite du personnage
       * @param place place actuel du personnage
       */
      public Bandit(int nbKidnappedLady, int reward, String look, boolean isInJail, String name, String favoriteDrink, Places place) {
            super(name, favoriteDrink, place);
            this.nbKidnappedLady = nbKidnappedLady;
            this.reward = reward;
            this.look = look;
            this.isInJail = isInJail;
      }

      /**
       * s'echapper de prison
       */
      @Override
      public void escape() {
            if (this.isInJail) {
                  isInJail = false;
                  action(this.name + " s'échappe");
                  talk("Je suis liiibre!!!");
                  this.goOut();
            }
      }

      /**
       * se présenter
       */
      @Override
      public void introduceYourself() {
            action(this.name + " presents");
            talk("I am " + name + ". I will destroy this city's dreams and hopes!!");
      }

      /**
       * kidnapper une fille
       *
       * @param girl la fille à kidnapper
       */
      @Override
      public void kidnappedLady(Lady girl) {
            if (!girl.isKidnapped) {
                  action(this.name + " kidnappe " + girl.name);
                  talk(girl.name + ", tu es à moi maintenant!");
                  nbKidnappedLady++;
                  girl.getKidnapped(this);
            }
      }

      /**
       * se faire mettre en prison
       *
       * @param boy le sherif qui te met en prison
       * @param places liste des places disponible
       */
      @Override
      public void getInJail(Cowboy boy, Places[] places) {
            action(boy.name + " a mis " + this.name + " en prison");
            talk("Merde! Je me vengerais " + boy.name + "!");
            isInJail = true;
            this.goTo(places[1]);
            boy.money += reward;
      }

      /**
       * ajoute money à la récompense déjà sur la tête du personnage
       *
       * @param money la récompense ajoutée
       */
      @Override
      public void addReward(int money) {
            reward += money;
            action("money = " + reward);
      }
    @Override
    public String getReward(){
       return "reward :" + this.reward; 
    }
    @Override
    public String whatIsYourName(){
        return this.getName() + " the " + this.look;
    }
}
