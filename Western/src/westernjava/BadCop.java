package westernjava;

/**
 * caractérise l'Humain de type BadCop
 *
 * @author Matias & Suarez
 */
public class BadCop extends Sheriff implements OutOfLaw {

      int nbKidnappedLady;
      int reward;
      String look;
      Boolean isInJail;

      /**
       * constructor
       *
       * @param nbKidnappedLady nombre de fille kidnappées
       * @param reward récompense sur sa tête
       * @param look attitude
       * @param isInJail true si emprisonné
       * @param popularity popularité
       * @param adjective adjectif
       * @param money argent gagné avec les récompenses
       * @param name nom du personnage
       * @param favoriteDrink boisson favorite du personnage
       * @param place place actuel du personnage
       */
      public BadCop(int nbKidnappedLady, int reward, String look, Boolean isInJail,
               int popularity, String adjective, int money, String name, String favoriteDrink, Places place, int nbCaughtBandit) { // int nbCaughtBandits
            super(nbCaughtBandit, popularity, adjective, money, name, favoriteDrink, place); //nbCaughtBandit,
            this.nbKidnappedLady = nbKidnappedLady;
            this.reward = reward;
            this.look = look;
            this.isInJail = isInJail;
      }

      /**
       * se faire mettre en prison
       *
       * @param boy le sherif qui te met en prison
       * @param places liste des places disponible
       */
      @Override
      public void getInJail(Cowboy boy, Places[] places) {
            talk("I will get my revenge " + boy.name + "!");
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
      }

      /**
       * kidnapper une fille
       *
       * @param girl la fille à kidnapper
       */
      @Override
      public void kidnappedLady(Lady girl) {
            if (!girl.isKidnapped) {
                  talk("You are mine now " + girl.name + "!");
                  nbKidnappedLady++;
                  girl.getKidnapped(this);
            }
      }

      /**
       * s'echapper de prison
       */
      @Override
      public void escape() {
            if (this.isInJail) {
                  isInJail = false;
                  action(this.name + " escapes");
                  talk("I am free!!!!!");
                  this.goOut();
            }
      }
      public void getReward(BadCop badboy) {
            action(this.name + " get the reward on the head of " + badboy.name);
            money += badboy.reward;
            badboy.reward = 0;
      }
        
     @Override
    public String whatIsYourName(){
        return this.getName() + " the " + this.look;
    }
     @Override
    public String getReward(){
       return "reward :" + this.reward; 
    }

}
