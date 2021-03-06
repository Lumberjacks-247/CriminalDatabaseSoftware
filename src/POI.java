package src;
public class POI extends Person{

    protected String tattoos, gang, victimRelationship, evidenceConnection;
    protected boolean isRepeatOffender;

    /**
     * Creates POI object with passed in first and last names
     * @param firstName first name of POI
     * @param lastName last name of POI
     */
    public POI(String firstName,  String lastName) {
        super(firstName, lastName);
    }

    public POI(String firstName, String lastName, String id, String gender, String race, String hairColor, String hairStyle, 
    String eyeColor, String address, String age, String tattoos, String gang, String victimRelationShip, String evidenceConnection, boolean isRepeatOffender) {
        super(firstName, lastName, id, gender, race, hairColor, hairStyle, eyeColor, address, age);
        this.tattoos = tattoos == null ? "" : tattoos;
        this.gang = gang == null ? "" : gang;
        this.victimRelationship = victimRelationShip == null ? "" : victimRelationShip;
        this.evidenceConnection = evidenceConnection == null ? "" : evidenceConnection;
        this.isRepeatOffender = isRepeatOffender;
    }

    public POI(String tattoos, String gang, String victimRelationship, String evidenceConnection, boolean isRepeatOffender) {
        this.tattoos = tattoos;
        this.gang = gang;
        this.victimRelationship = victimRelationship;
        this.evidenceConnection = evidenceConnection;
        this.isRepeatOffender = isRepeatOffender;
    }

    public POI() {
      this.init(null,null,null,null,null,null,null,null,null,null,null,null,null,null,false);
    };

    public void setPersonInfo(String firstName, String lastName, String id, String gender, String race, String hairColor, String hairStyle, String eyeColor, String address, String age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.gender = gender;
        this.race = race;
        this.hairColor = hairColor;
        this.hairStyle = hairStyle;
        this.eyeColor = eyeColor;
        this.address = address;
        this.age = age;
    }


    protected void init(String firstName, String lastName, String id, String gender, String race, String hairColor, String hairStyle, String eyeColor, String address, String age, String tattoos, String gang, String victimRelationShip, String evidenceConnection, boolean isRepeatOffender) {
      super.init(firstName, lastName, id, gender, race, hairColor, hairStyle, eyeColor, address, age);
      this.tattoos = tattoos == null ? "" : tattoos;
      this.gang = gang == null ? "" : gang;
      this.victimRelationship = victimRelationShip == null ? "" : victimRelationShip;
      this.evidenceConnection = evidenceConnection == null ? "" : evidenceConnection;
      this.isRepeatOffender = isRepeatOffender;

    }

    /**
     * returns tattoos of the poi
     * @return tattoos of the poi as a String
     */
    public String getTattoos() {
        return this.tattoos;
    }

    /**
     * sets tattoos of the poi to passed in String
     * @param tattoos tattoos of the poi as a String
     */
    public void setTattoos(String tattoos) {
        this.tattoos = tattoos;
    }

    /**
     * returns the gang of the poi
     * @return gang of the poi as a String
     */
    public String getGang() {
        return this.gang;
    }

    /**
     * sets gang of poi to passed in gang
     * @param gang gang of poi as a String
     */
    public void setGang(String gang) {
        this.gang = gang;
    }

    /**
     * returns if poi is a repeat offender or not
     * @return boolean value for if poi is repeat offender
     */
    public boolean getIsRepeatOffender() {
        return this.isRepeatOffender;
    }

    /**
     * changes boolean value of isRepeatOffender from false to true
     */
    public void changeRepeatOffender() {
        this.isRepeatOffender = !this.isRepeatOffender;
    }

    /**
     * returns poi's relationship with victim
     * @return String value containing poi's relationship with victim
     */
    public String getVictimRelationship() {
        return this.victimRelationship;
    }

    /**
     * sets poi's victimRelationship to passed in String
     * @param relationship String that contains poi's relationship to victim
     */
    public void setVictimRelationship(String relationship) {
        this.victimRelationship = relationship;
    }

    /**
     * returns poi's connection to evidence
     * @return String value containing poi's connection to evidence
     */
    public String getEvidenceConnection() {
        return this.evidenceConnection;
    }


    @Override
    public String toString() {
      String[] details = new String[]{tattoos,gang,victimRelationship,evidenceConnection,isRepeatOffender+""};
      String[] prompts = new String[]{"Tattoos:","Gangs:","Relationship to Victim:","Connection to Evidence:","Repeat Offender:"};
      
      String out = super.toString();
      if (!out.equals("")) out += " | ";
      String buffer = "";
      for (int i = 0; i < details.length;++i) {
        String detail = details[i];
        String prompt = prompts[i];

        if (!detail.equals("")) {
          out += buffer + prompt + " " + detail;
          buffer = " | ";
        }
      }

      return out;
    }

    /**
     * CALLING OBJECT MUST BE PERSON WITH SEARCH INFO WHILE PARAMETER IS ALREADY CREATED PERSON
     * @param person suspect object to see if their info matches search info
     * @return true if partial match is found, false if not
     */
    public boolean partialCompare(POI poi) {
        if(!super.partialCompare((Person)poi)) return false;

        if(!this.getTattoos().equals(""))
          if(!this.getTattoos().equalsIgnoreCase(poi.getTattoos()))
            return false;

        if(!this.getGang().equals(""))
          if(!this.getGang().equalsIgnoreCase(poi.getGang()))
              return false;

        if(!this.getVictimRelationship().equals(""))
          if(!this.getVictimRelationship().equalsIgnoreCase(poi.getVictimRelationship()))
              return false;

        if(!this.getEvidenceConnection().equals(""))
          if(!this.getEvidenceConnection().equalsIgnoreCase(poi.getEvidenceConnection()))
              return false;
        
        if (this.getIsRepeatOffender())
          if(!poi.getIsRepeatOffender())
            return false;

        return true;
    }

    /**
     * sets poi's evidenceConnection to passed in String
     * @param evidenceConnection String that contains poi's connection to evidence
     */
    public void setEvidenceConnection(String evidenceConnection) {
        this.evidenceConnection = evidenceConnection;
    }

    public static void main(String[] args) { 
        POI james = new POI("james", "castle", null, null, "white", "black", null, "green", null, "22", null, null, null, null, true);
        System.out.println(james);
    }
    
}