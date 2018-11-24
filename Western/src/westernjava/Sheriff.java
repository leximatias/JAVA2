package westernjava;

/**
 * caractérise l'Humain de type Sherif
 *
 * @author Matias & Suarez
 */
public class Sheriff extends Cowboy {

      int nbCaughtBandit;

      /**
       * constructor
       *
       * @param nbCaughtBandit nombre de méchant attrapés
       * @param popularity popularité
       * @param adjective adjectif
       * @param money argent gagné avec les récompenses
       * @param name nom du personnage
       * @param favoriteDrink boisson favorite du personnage
       * @param place place actuel du personnage
       */
      public Sheriff(int nbCaughtBandit, int popularity, String adjective, int money, String name, String favoriteDrink, Places place) {
            super(popularity, adjective, money, name, favoriteDrink, place);
            this.nbCaughtBandit = nbCaughtBandit;
      }

      /**
       * attraper un méchant et le mettre en prison
       *
       * @param badboy le méchant
       * @param places liste des places disponibles
       */
      public void catchABandit(Bandit badboy, Places[] places) {
            action(this.name + " captures " + badboy.name);
            badboy.getInJail(this, places);
      }

      /**
       * attraper un méchant et le mettre en prison
       *
       * @param badgirl la méchante
       * @param places liste des places disponibles
       */
      public void catchABandit(BanditLady badgirl, Places[] places) {
            action(this.name + " captures " + badgirl.name);
            talk("How could you do this " + badgirl.name + "...");
            badgirl.getInJail(this, places);
      }

      /**
       * attraper un méchant et le mettre en prison
       *
       * @param badcop le méchant
       * @param places liste des places disponibles
       */
      public void catchABandit(BadCop badcop, Places[] places) {
            action(this.name + " captures " + badcop.name);
            talk("I thought you were different " + badcop.name + "...");
            badcop.getInJail(this, places);
      }

      /**
       * mettre une récompense sur la tête d'un méchant
       *
       * @param badboy le méchant
       * @param money la récompense
       */
      public void searchABandit(Bandit badboy, int money) {
            action(this.name + " is giving out a reward to find " + badboy.name);
            badboy.addReward(money);
            talk("Listen everyone, " + badboy.name + " is sought for " + badboy.reward + " dollars!");
      }
      
       /**
       * mettre une récompense sur la tête d'un méchant
       *
       * @param badboy le méchant
       * @param money la récompense
       */
      public void searchABandit(BadCop badboy, int money) {
            action(this.name + " is giving out a reward to find " + badboy.name);
            badboy.addReward(money);
            talk("Listen everyone, " + badboy.name + " is sought for " + badboy.reward + " dollars!");
      }

      /**
       * se présenter
       */
      @Override
      public void introduceYourself() {
            action(this.name + " presents.");
            talk("Hello, I'm the new sheriff in town! I am " + name + " at your service!");
      }
      
//    public String whatIsYourName(){
//        return this.getName() + " the protector of this town!";
//    } 
}
