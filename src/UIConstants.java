package src.UI;
//TODO - Add more Screens


/**
 * Contains constant information for use by UI and other UI involved classes.
 * @author Blake Seekings
 * @version 3.0 - Implement Telephone Call Structure
 * @since 3/18/2021
 * @see ScreenCalls
 */
public class UIConstants {
  
  /* Public Constants */
  public static final String DIV = "-------------------------------";
  public static final String PROMPT = ">> ";
  public static final String QUITFLAG = "-1";

  /* UI Startup */

  /**
   * Returns the initial Screen for UI to display.
   */
  public static Screen start() {
    return  ScreenCalls.START.call(null);
  }

  /**
   * Returns the null element, this breaks the Screen sequence completly.
   * @param parent The Screen object which called this method.
   * @return The null element
   */
  public static Screen Null(Screen parent) {
    return null;
  }

  /**
   * Constructs an EnterDataScreen using parametrized data.
   * @param parent The Screen where change in data is requested.
   * @param dataIndex The index of the data in parent.
   * @return The EnterDataScreen which is linked to the parent and a field of data.
   */
  public static EnterDataScreen EnterData(Screen parent, int dataIndex) {
    return new EnterDataScreen(parent, dataIndex);
  }

  /**
   * When passed a given parameter and called, will return the parent of the parameter.
   * @param parent The object of Screen which called for a new screen
   * @return the parent of the parameter
   */
  public static Screen ParentScreen(Screen parent) {
    return parent.getParent();
  }

  /* 
  public static Screen exampleTransScreen(Screen parent) {

    String titleString = "EMPTY";
    String choiceString = "EMPTY;EMPTY;EMPTY";
    String linkString = "EMPTY;EMPTY;EMPTY";

    // Extra Adjustments 
    Screen screen = new TransScreen(titleString,choiceString,linkString);
    screen.setParent(parent);
    return screen;

  }


  /*

  public static Screen exampleEditorScreen(Screen parent) {

    String titleString = "EMPTY";
    String dataPromptString = "EMPTY;EMPTY";
    String choiceString = "Back;SET EMPTY;SET EMPTY;EMPTY"
    String linkString = "S:PARENT;ENTERDATA;ENTERDATA;F:EMPTY";
  }

  */

  /**
   * Creates the Welcome Screen
   * @param parent The Screen instance preceding the new Screen
   * @return The Welcome Screen
   */ 
  public static Screen WelcomeScreen(Screen parent) {

    String titleString = "Welcome";
    String choiceString = "Exit;Login;Create Account";
    String linkString = "S:NULL;S:LOGIN;S:CREATEACCOUNT";

      
    /* Extra Adjustments */
    Screen screen = new TransScreen(titleString,choiceString,linkString);
    screen.setParent(null);
    return screen;

  }
  /**
   * Creates the Search Screen.
   * @param parent The Screen instance preceding the new Screen
   * @return The Search Screen
   */ 
  public static Screen SearchScreen(Screen parent) {

    String titleString = "Search";
    String choiceString = "Back;Search People;Search Reports";
    String linkString = "S:PARENT;S:SEARCHPEOPLE;S:SEARCHREPORTS";
  
    Screen screen = new TransScreen(titleString,choiceString,linkString);
    screen.setParent(parent);
    return screen;
  }

  /**
   * Creates the Search People Screen.
   * @param parent The Screen instance preceding the new Screen
   * @return The Search People Screen
   */
  public static Screen SearchPeopleScreen(Screen parent) {

    String titleString = "Search People";
    String dataPromptString = "Firstname;Lastname;Id;Gender;Race;Hair Color;Hair Style;Eye Color;Address;Age";
    
    String choiceString = "Back;Set Firstname;Set Lastname;Set id;Set gender;Set Race;";
    choiceString += "Set Hair Color;Set Hair Style;Set Eye Color;Set Address;Set Age;Search";

    String linkString = "S:PARENT;ENTERDATA;ENTERDATA;ENTERDATA;ENTERDATA;ENTERDATA;";
    linkString +=       "ENTERDATA;ENTERDATA;ENTERDATA;ENTERDATA;ENTERDATA;F:SEARCHPEOPLE";


     /* Extra Adjustments */
     Screen screen = new EditorScreen(titleString, dataPromptString, choiceString, linkString);
     screen.setParent(parent);
     return screen;
  }

  public static Screen SearchReportsScreen(Screen parent) {
    
    String titleString = "Search Reports";
    
    String dataPromptString = "Author;Level of Charge;Jurisdiction;Type of Crime;Location";
    
    String choiceString = "Back;Set Author;Set Level of Charge;Set Jurisdiction;Set Type of Crime;Set Location;Search for Report";

    String linkString = "S:PARENT;ENTERDATA;ENTERDATA;ENTERDATA;ENTERDATA;ENTERDATA;F:SEARCHREPORTS";

    /* Extra Adjustments */
    Screen screen = new EditorScreen(titleString, dataPromptString, choiceString, linkString);
    screen.setParent(parent);
    return screen;

  }
  /**
   * Creates the Main Menu Screen.
   * @param parent The Screen instance preceding the new Screen
   * @return The Main Menu Screen
   */ 
  public static Screen MainMenuScreen(Screen parent) {

    String titleString = "Criminal Database Software";
    String choiceString = "Logout;Search;New";
    String linkString = "F:LOGOUT;S:SEARCH;S:NEW";

    /* Extra Adjustments */
    Screen screen = new TransScreen(titleString,choiceString,linkString);
    screen.setParent(null);
    return screen;
  }

  /**
   * Creates the Login Screen.
   * @param parent The Screen instance preceding the new Screen
   * @return The Login Screen
   */ 
  public static Screen LoginScreen(Screen parent) {

    String titleString = "Login";
    String dataPromptString = "Username;Password";
    String choiceString = "Back;Set Username;Set Password;Login";
    String linkString = "S:PARENT;ENTERDATA;ENTERDATA;F:LOGIN";

    /* Extra Adjustments */
    Screen screen = new EditorScreen(titleString, dataPromptString, choiceString, linkString);
    screen.setParent(parent);
    return screen;

  }

  /**
   * Creates the Create Account Screen.
   * @param parent The Screen instance preceding the new Screen
   * @return The Create Account Screen
   */ 
  public static Screen CreateAccountScreen(Screen parent) {
    
    String titleString = "Create Account";
    String dataPromptString = "Username;Password;First Name;Last Name;Age";
    String choiceString = "Back;Set Username;Set Password;Set First Name;Set Lastname;Set Age;Create Account";
    String linkString = "S:PARENT;ENTERDATA;ENTERDATA;ENTERDATA;ENTERDATA;ENTERDATA;F:CREATEACCOUNT";

    /* Extra Adjustments */
    Screen screen = new EditorScreen(titleString, dataPromptString, choiceString, linkString);
    screen.setParent(parent);
    return screen;


  }


}
