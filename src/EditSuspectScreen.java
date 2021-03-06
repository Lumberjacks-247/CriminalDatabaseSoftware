package src;

public class EditSuspectScreen extends Screen {
  
  
  private Suspect suspect;
  private int parentIndex;
  SuspectsListScreen parent;
  
  public EditSuspectScreen(SuspectsListScreen parent, Suspect suspect, int index) {
    this.parent = parent;
    this.suspect = suspect;
    this.parentIndex = index;
    this.title = "EditSuspectScreen";
  }

  public void display() {

    String title = UIConstants.center("Edit Suspect") + "\n";
    title += UIConstants.DIV;

    String out = "";
    out += "First Name: \t\t" +           suspect.getFirstName() + "\n";
    out += "Last Name: \t\t" +            suspect.getLastName() + "\n";
    out += "Gender: \t\t" +               suspect.getGender() + "\n";
    out += "Race: \t\t\t" +                 suspect.getRace() + "\n";
    out += "Hair Color: \t\t" +           suspect.getHairColor() + "\n";
    out += "Hair Style: \t\t" +           suspect.getHairStyle() + "\n";
    out += "Eye Color: \t\t" +            suspect.getEyeColor() + "\n";
    out += "Address: \t\t" +              suspect.getAddress() + "\n";
    out += "Age: \t\t\t" +                  suspect.getAge() + "\n";
    out += "Height: \t\t" +                  suspect.getHeight() + "\n";
    out += "Tattos: \t\t" +             suspect.getTattoos() + "\n";
    out += "Gang: \t\t\t" +                 suspect.getGang() + "\n";
    out += "Victim Relationship: \t" +  suspect.getVictimRelationship() + "\n";
    out += "Evidence Connection: \t" +  suspect.getEvidenceConnection() + "\n";
    out += "Repeat Offender: \t" +     (suspect.getIsRepeatOffender() ? "true" : "false") + "\n";
    out += "PrefClothes: \t\t" +          suspect.getPrefferedClothes() + "\n";
    out += UIConstants.DIV;

    String bot = "";
    bot += "(0) Cancel\n";
    bot += "(1) Set First Name\n";
    bot += "(2) Set Last Name\n";
    bot += "(3) Set Gender\n";
    bot += "(4) Set Race \n";
    bot += "(5) Set Hair Color\n";
    bot += "(6) Set Hair Style\n";
    bot += "(7) Set Eye Color\n";
    bot += "(8) Set Address\n";
    bot += "(9) Set Age\n";
    bot += "(10) Set Height\n";
    bot += "(11) Set Tattos\n";
    bot += "(12) Set Gang\n";
    bot += "(13) Set Victim Relationship\n";
    bot += "(14) Set Evidence Connection\n";
    bot += "(15) Change Repeat Offender\n";
    bot += "(16) Set Preffered Clothes\n";
    bot += "(17) Done";

    String disp = title + out + bot;
    disp += "\n>> ";
    System.out.print(disp);
  }


  public void setDataValue(int index,String value) {
    switch (""+index) {
      case "0":
        this.suspect.setFirstName(value);
        break;
      case "1":
        this.suspect.setLastName(value);
        break;
      case "2":
        this.suspect.setGender(value);
        break;
      case "3":
        this.suspect.setRace(value);
        break;
      case "4":
        this.suspect.setHairColor(value);
        break;
      case "5":
        this.suspect.setHairStyle(value);
        break;
      case "6":
        this.suspect.setEyeColor(value);
        break;
      case "7":
        this.suspect.setAddress(value);
        break;
      case "8":
        this.suspect.setAge(value);
        break;
      case "9":
        this.suspect.setHeight(value);
        break;
      case "10":
        this.suspect.setTattoos(value);
        break;
      case "11":
        this.suspect.setGang(value);
        break;
      case "12":
        this.suspect.setVictimRelationship(value);
        break;
      case "13":
        this.suspect.setEvidenceConnection(value);
        break;
      case "14":
        this.suspect.changeRepeatOffender();
        break;
      case "15":
        this.suspect.setPrefferedClothes(value);
      default:   
    }
  }

  public Screen next(String input) {
    
    switch (input) {
      case "0":
        return this.parent;
      case "1":
        return new EnterDataScreen(this,"First Name: ",this.suspect.getFirstName(),0);
      case "2":
        return new EnterDataScreen(this,"Last Name: ",this.suspect.getLastName(),1);
      case "3":
        return new EnterDataScreen(this,"Gender: ",this.suspect.getGender(),2);
      case "4":
        return new EnterDataScreen(this,"Race: ",this.suspect.getRace(),3);
      case "5":
        return new EnterDataScreen(this,"Hair Color: ",this.suspect.getHairColor(),4);
      case "6":
        return new EnterDataScreen(this,"Hair Style: ",this.suspect.getHairStyle(),5);
      case "7":
        return new EnterDataScreen(this,"Eye Color: ",this.suspect.getEyeColor(),6);
      case "8":
        return new EnterDataScreen(this,"Address: ",this.suspect.getAddress(),7);
      case "9":
        return new EnterDataScreen(this,"Age: ",this.suspect.getAge(),8);
      case "10":
        return new EnterDataScreen(this,"Height: ",this.suspect.getHeight(),9);
      case "11":
        return new EnterDataScreen(this,"Tattoos: ",this.suspect.getTattoos(),9);
      case "12":
        return new EnterDataScreen(this,"Gang: ",this.suspect.getGang(),10);
      case "13":
        return new EnterDataScreen(this,"Victim Relationship: ",this.suspect.getVictimRelationship(),11);
      case "14":
        return new EnterDataScreen(this,"Evidence Connection: ",this.suspect.getEvidenceConnection(),12);
      case "15":
        this.suspect.changeRepeatOffender();
        return this;
      case "16":
        return new EnterDataScreen(this,"Perffered Clothes: ",this.suspect.getPrefferedClothes(),14);
      case "17":
        this.parent.addSuspect(this.suspect, parentIndex);
        return this.parent;
      default:
        return this;

    }
  }
}
