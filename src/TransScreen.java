package src;

/**
 * Displays text and allows transition to next Screen.
 * @author Blake Seekings
 * @version 4.0 - Implementing Telephone Call Structure
 * @since 3/18/2021
 */
public class TransScreen extends Screen {


  private String[] choices;

  /**
   * Creates a new Transition Screen.
   * @param title_    String title of Screen
   * @param choices_  String of ; delimited user choice prompts
   * @param links_    String of ; delimited links to next Screen
   */
  public TransScreen(String title_,String choices_, String links_) {
    this.name = this.title = title_;
    this.choices = choices_.split(";");
    this.links = links_.split(";");
  }

  public void display() {
    String top = UIConstants.center(this.title) + "\n";
    top += UIConstants.DIV;


    String bot = "";
    for (int i=0;i<choices.length;) {
      String line = "(" + i + ") " + this.choices[i++];
      bot += line + "\n";
    }

    String display = top + bot;
    display += "\n" + UIConstants.PROMPT;
    System.out.print(display);

  }

  public Screen next(String input) {

    /* Check for Invalid Input */
    int choice;
    if ((choice = isValid(input)) < 0)
      return this;

    /* Move to next screen */

    String phoneNumber = this.links[choice];
    return Telephone.call(this,phoneNumber);
  }
}