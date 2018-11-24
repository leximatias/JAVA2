package westernjava;

/**
 * caractérise l'Humain de type ThugLady
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
       * @param nbKidnappedLady nombre de fille kidnapper
       * @param reward récompense sur sa tête
       * @param look attitude
       * @param isInJail true si emprisonné
       * @param isKidnapped true si kidnapper
       * @param dressColor la couleur de sa culotte
       * @param name nom du personnage
       * @param favoriteDrink boisson favorite du personnage
       * @param place place actuel du personnage
       */
      public BanditLady(int nbKidnappedLady, int reward, String look, Boolean isInJail,
               boolean isKidnapped, String dressColor, String name, String favoriteDrink, Places place) {
            super(isKidnapped, dressColor, name, favoriteDrink, place);
            this.nbKidnappedLady = nbKidnappedLady;
            this.reward = reward;
            this.look = look;
            this.isInJail = isInJail;
      }

      /**
       * kidnapper une fille
       *
       * @param girl la fille à kidnapper
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
       * ajoute money à la récompense déjà sur la tête du personnage
       *
       * @param money la récompense ajoutée
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
