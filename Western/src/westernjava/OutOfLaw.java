
package westernjava;

/**
 * characterizes the Human belonging to the OutOfLaw interface
 *
 * @author Matias & Suarez
 */
public interface OutOfLaw {

      /**
        * allows to kidnap a girl
        *
        * @param girl Lady who is kidnapped
        */

      void kidnappedLady(Lady girl);

      /**
       * put the character in jail
        *
        * @param boy sheriff who puts in prison the character
        * @param places list of places available
       */
      void getInJail(Cowboy boy, Places[] places);

      /**
        *add money to the reward
        *
        * @param money int matching the money add to the reward
       */
      void addReward(int money);
      
      String getReward();
      String whatIsYourName();
      /**
       * the character escapes from prison
       */
      void escape();

}
