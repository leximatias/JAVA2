package westernjava;

/**
 * characterizes the Indian type human
 *
 * @author Matias & Suarez
 */
public class Indian extends Human {

      int nbFeather;
      String totem;

      /**
        * construtor
        *
        * @param nbFeather number of feather on his headdress
        * @param totem name of his totem
        * @param name name of the character
        * @param favoriteDrink favorite drink of the character
        * @param place character's current place
       */
      public Indian(int nbFeather, String totem, String name, String favoriteDrink, Places place) {
            super(name, favoriteDrink, place);
            this.nbFeather = nbFeather;
            this.totem = totem;
      }

      /**
        * formats when the character speaks
        *
        * @param say what he says
       */
      @Override
      public void talk(String say) {
        System.out.println("Indian " + name + ": " + say);
      }

      /**
       * introduces indian
       */
      @Override
      public void introduceYourself() {
        action(this.name + " arrives..");
        talk("Greetings pale face! I am " + name + " " + totem + ". I am part of the tribe at the end of the city. ");
      }

}
