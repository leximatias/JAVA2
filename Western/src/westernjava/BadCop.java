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
        * @param nbKidnappedLady number of kidnapped girls
        * @param reward reward on his head
        * @param look attitude
        * @param isInJail true if trapped
        * @param popularity popularity
        * @param adjective adjective
        * @param money money earned with the rewards
        * @param name name of the character
        * @param favoriteDrink favorite drink of the character
        * @param place character's current place
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
        * get put in jail
        *
        * @param boy the sheriff who puts you in prison
        * @param places list of places available
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
       * kidnapp a girl
       *
       * @param girl the girl to be kidnapped
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
       * escape from prison
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
