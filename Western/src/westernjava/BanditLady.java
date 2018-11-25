package westernjava;

/**
 * characterizes BanditLady human
 *
 * @author Matias & Suarez
 */
public class BanditLady extends Lady implements OutOfLaw {

      int nbKidnappedLady;
      int reward;
      String look;
      Boolean isInJail;

      /**
        * constructor
        *
        * @param nbKidnappedLady number of girl kidnap
        * @param reward reward on his head
        * @param look 
        * @param isInJail true if trapped
        * @param isKidnapped true if kidnapped
        * @param dressColor the color of her panties
        * @param name name of the character
        * @param favoriteDrink favorite drink of the character
        * @param place character's current place
       */
      public BanditLady(int nbKidnappedLady, int reward, String look, Boolean isInJail,
               boolean isKidnapped, String dressColor, String name, String favoriteDrink, Places place,String state) {
            super(isKidnapped, dressColor, name, favoriteDrink, place,state);
            this.nbKidnappedLady = nbKidnappedLady;
            this.reward = reward;
            this.look = look;
            this.isInJail = isInJail;
      }

      /**
       * kidnap a girl
       *
       * @param girl the girl to kidnap
       */
      @Override
      public void kidnappedLady(Lady girl) {
            nbKidnappedLady++;
            talk("I caught you " + girl.name +"!");
            
            girl.getKidnapped(this);
      }

      /**
       * s'echapper de prison
       */
      @Override
      public void escape() {
            if (this.isInJail) {
                  isInJail = false;
                  action(this.name + " escapes");
                  talk("Oh yes!!");
                  this.goOut();
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
            talk("Ugh! I will hunt you down for revenge " + boy.name + "!");
            isInJail = true;
            this.goTo(places[1]);
            boy.money += reward;
      }

      /**
       ** adds money to the reward
        *
        * @param money the reward added
        */
      @Override
      public void addReward(int money) {
            reward += money;
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
