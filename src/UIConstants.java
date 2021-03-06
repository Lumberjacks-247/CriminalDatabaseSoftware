package src;
//TODO - Add more Screens


/**
 * Contains constant information for use by UI and other UI involved classes.
 * @author Blake Seekings
 * @version 3.0 - Implement Telephone Call Structure
 * @since 3/18/2021
 * @see ScreenCalls
 */
public class UIConstants {
  
/*
##############################################################

                        Constants      

##############################################################
*/

  public static final String INDENT = "\t";
  private static final String DIV_SYMBOL = "-";
  public static final String DIV = makeDIV();
  public static final String PROMPT = ">> ";
  public static final String QUITFLAG = "-1";
  public static final int LINESIZE = 60;

/*
##############################################################

                      Display Methods         

##############################################################
*/

  private static String makeDIV() {
    String line = "";
    for (int i = 0; i < LINESIZE;i++) {
      line += DIV_SYMBOL;
    }
    line += "\n";
    return line;
  }

  public static String center(String line) {
    /* Makes String centered on Screen */
    int shiftSize = (LINESIZE-line.length())/2;
    String shift = "";
    for (;shiftSize > -1;shiftSize--)
      shift += " ";

    return shift + line;
  }
  
/*
##############################################################

                        UI Startup      

##############################################################
*/

  /**
   * Returns the initial Screen for UI to display.
   */
  public static Screen start() {
    // Person[] people = new Person[]{new Person("James","Seekings",null,"Male","Caucasian","Blond","Straight",null,null,null)};
    // Screen start = new ResScreen(ScreenCalls.START.call(null),people);
    //return start;
    return  ScreenCalls.START.call(null);
  }


/*
##############################################################

                      Screen Definitions

##############################################################
*/

/* Example TransScreen Construction
  public static Screen exampleTransScreen(Screen parent) {

    String titleString = "EMPTY";
    String choiceString = "EMPTY;EMPTY;EMPTY";
    String linkString = "EMPTY;EMPTY;EMPTY";


    Screen screen = new TransScreen(titleString,choiceString,linkString);
    screen.setParent(parent);
    return screen;

  }

*/
/* Example EditorScreen Construction

  public static Screen exampleEditorScreen(Screen parent) {

    String titleString = "EMPTY";
    String dataPromptString = "EMPTY;EMPTY";
    String choiceString = "Back;SET EMPTY;SET EMPTY;EMPTY"
    String linkString = "S:PARENT;ENTERDATA;ENTERDATA;F:EMPTY";

    Screen screen = new EditorScreen(titleString,dataPromptString,choiceString,linkString);
    screen.setParent(parent);
    return screen;
  }

*/

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
    String linkString = "S:PARENT;S:SEARCHCRIMINALS;S:SEARCHREPORTS";
  
    Screen screen = new TransScreen(titleString,choiceString,linkString);
    screen.setParent(parent);
    return screen;
  }

  /**
   * Creates the Search People Screen.
   * @param parent The Screen instance preceding the new Screen
   * @return The Search People Screen
   */
  public static Screen SearchCriminalScreen(Screen parent) {

    String titleString = "Search Criminals";
    String dataPromptString = "Firstname;Lastname;Gender;Race;Hair Color;Hair Style;Eye Color;Address;Age;Height;Tattoos;Gang;Victim Relation;Evidence Connection;isRepeatOffender;Clothes;Nicknames;Common Words;Hobbies;Job;Physical Traits;Sentence;In Custody;Status";
    
    String choiceString = "Back;Set Firstname;Set Lastname;Set gender;Set Race;";
    choiceString += "Set Hair Color;Set Hair Style;Set Eye Color;Set Address;Set Age;Set Height;Set Tattoos;Set Gang;Set Victim Relation;Set Evidence Connection;Set isRepeatOffender;Set Clothes;Set Nicknames;Set Common Words;Set Hobbies;Set Job;Set Physical Traits;Set Sentence;Set Status;Set Custody;Search";

    String linkString = "S:PARENT;ENTERDATA;ENTERDATA;ENTERDATA;ENTERDATA;ENTERDATA;";
    linkString +=       "ENTERDATA;ENTERDATA;ENTERDATA;ENTERDATA;ENTERDATA;ENTERDATA;ENTERDATA;ENTERDATA;ENTERDATA;ENTERDATA;ENTERDATA;ENTERDATA;ENTERDATA;ENTERDATA;ENTERDATA;ENTERDATA;ENTERDATA;ENTERDATA;ENTERDATA;F:SEARCHCRIMINALS";


     /* Extra Adjustments */
     Screen screen = new EditorScreen(titleString, dataPromptString, choiceString, linkString);
     screen.setParent(parent);
     return screen;
  }

  //TODO - Add JavaDoc
  public static Screen SearchReportsScreen(Screen parent) {
    
    String titleString = "Search Reports";
    
    String dataPromptString = "ID: ";
    
    String choiceString = "Back;Set ID;Search for Report";

    String linkString = "S:PARENT;ENTERDATA;F:SEARCHREPORTS";

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

    String titleString = "Main Menu";
    String choiceString = "Logout;Search;New";
    String linkString = "F:LOGOUT;S:SEARCH;S:NEWDATA";

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
    String dataPromptString = "Username;Password;First Name;Last Name;Access Level";
    String choiceString = "Back;Set Username;Set Password;Set First Name;Set Lastname;Set Access Level;Create Account";
    String linkString = "S:PARENT;ENTERDATA;ENTERDATA;ENTERDATA;ENTERDATA;ENTERDATA;F:CREATEACCOUNT";

    /* Extra Adjustments */
    Screen screen = new EditorScreen(titleString, dataPromptString, choiceString, linkString);
    screen.setParent(parent);
    return screen;


  }


  public static Screen NewDataScreen(Screen parent) {
    String titleString = "Enter New Data";
    String choiceString = "Back;Enter New Person;Enter New Crime";
    String linkString = "S:PARENT;S:ENTERPERSON;S:NEWCRIME";

    
    /* Extra Adjustments */
    Screen screen = new TransScreen(titleString,choiceString,linkString);
    screen.setParent(parent);
    return screen;
  }


  public static Screen NewCrimeScreen(Screen parent) {
    Screen screen = new EnterNewCrime();
    screen.setParent(parent);
    return screen;
  }



}
