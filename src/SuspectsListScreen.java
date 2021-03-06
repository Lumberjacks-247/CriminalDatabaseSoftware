package src;

import java.io.File;
import java.io.FileWriter;



public class SuspectsListScreen extends Screen {




  private Suspect[] list;
  private int numSuspects;
  private boolean allowChange = true;
  public SuspectsListScreen(Screen parent, Suspect[] list, int numSuspects) {
    this.parent = parent;
    this.list = list;
    this.numSuspects = numSuspects;
    this.title = "SuspectListScreen";
  }

  public SuspectsListScreen(Screen parent, Suspect[] list, int numSuspects, boolean changeable) {
    this.parent = parent;
    this.list = list;
    this.numSuspects = numSuspects;
    this.allowChange = changeable;
    this.title = "SuspectListScreen";
  }


  public void display() {
    
    String title = UIConstants.center("Suspects") + "\n";
    title += UIConstants.DIV;

    
    int count = 0;
    String out = "(0) Back\n";
    for (;count < numSuspects;count++)
      out += "\n(" + (count+1) + ")\n " + list[count].toString() + "\n";
    

    if (this.allowChange)
      out += "(" + (count+1) + ")" + " Add Suspect"   + "\n";
    else
      out += "\n(" + (count+1) + ")" + " Print Results" + "\n";

    out += "\n>> ";
    System.out.println(title+out);
  }



  public int isValid(String input) {
    try {
      int i = Integer.parseInt(input);
      if (this.allowChange && i >= 0 && i <= this.numSuspects+1) {
        return i;
      } else if (i == 0 || i == this.numSuspects+1) {
        return i;
      }
      return -1;
    } catch (Exception e) {
      return -1;
    }
  }


  public void addSuspect(Suspect suspect,int index) {
    
    list[index] = suspect;
    if (index == numSuspects)
      numSuspects++;
  }

  public Screen next(String input) {

    int index;
    if ((index = isValid(input)) < 0) 
      return this;

    if (index == 0) {
      if (this.allowChange)
        this.parent.updateSuspectList(this.list,numSuspects);
      return this.parent;
    }
    
    Suspect suspect;

    if (this.allowChange) {
      if (index-1 == numSuspects) {
        suspect = new Suspect();
      } else {
        suspect = list[index-1];
      }

      return new EditSuspectScreen(this,suspect,index-1);
    } else {
      if (index == numSuspects+1) {
        try (FileWriter writer = new FileWriter(new File("output.txt"))) {
          for (Suspect sus : this.list)
            writer.write("\n" + sus.toString() + "\n");
        } catch ( Exception e) {

        }
        return this.parent;
      }

      return null;
    }
  }
  
}
