package westernjava;

/**
 * characterizes the type Sherif
 *
 * @author Matias & Suarez
 */
public class Sheriff extends Cowboy {

      int nbCaughtBandit;

      /**
       * constructor
       *
        * @param nbCaughtBandit number of  caught bandits
        * @param popularity popularity
        * @param adjective adjective
        * @param money money earned with the rewards
        * @param name name of the character
        * @param favoriteDrink favorite drink of the character
        * @param place character's current place
       */
      public Sheriff(int nbCaughtBandit, int popularity, String adjective, int money, String name, String favoriteDrink, Places place) {
            super(popularity, adjective, money, name, favoriteDrink, place);
            this.nbCaughtBandit = nbCaughtBandit;
      }

      /**
       * catch a bad guy and put him in jail
        *
        * @param badboy the bad guy
        * @param places list of places available
       */
      public void catchABandit(Bandit badboy, Places[] places) {
            action(this.name + " captures " + badboy.name);
            badboy.getInJail(this, places);
      }

      /**
        *catch a bad guy and put him in jail
        *
        * @param badgirl the wicked
        * @param places list of places available
       */
      public void catchABandit(BanditLady badgirl, Places[] places) {
            action(this.name + " captures " + badgirl.name);
            talk("How could you do this " + badgirl.name + "...");
            badgirl.getInJail(this, places);
      }

      /**
       * catch a bad guy and put him in jail
        *
        * @param badcop the bad guy
        * @param places list of places available
       */
      public void catchABandit(BadCop badcop, Places[] places) {
            action(this.name + " captures " + badcop.name);
            talk("I thought you were different " + badcop.name + "...");
            badcop.getInJail(this, places);
      }

      /**
        * put a reward on the head of a villain
        *
        * @param badboy the bad guy
        * @param money the reward
        * 
       */
      public void searchABandit(Bandit badboy, int money) {
            action(this.name + " is giving out a reward to find " + badboy.name);
            badboy.addReward(money);
            talk("Listen everyone, " + badboy.name + " is sought for " + badboy.reward + " dollars!");
      }
      
       /**
        *put a reward on the head of a villain
        *
        * @param badboy the bad guy
        * @param money the reward
       */
    public void searchABandit(BadCop badboy, int money) {
        action(this.name + " is giving out a reward to find " + badboy.name);
        badboy.addReward(money);
        talk("Listen everyone, " + badboy.name + " is sought for " + badboy.reward + " dollars!");
      }

      /**
       * presents
       */
    @Override
    public void introduceYourself() {
        action(this.name + " presents.");
        talk("Hello, I'm the new sheriff in town! I am " + name + " at your service!");
    }
      
    public String whatIsYourName(){
        return this.getName() + " the protector of this town!";
    } 
}
