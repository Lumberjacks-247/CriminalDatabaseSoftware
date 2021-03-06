package src;

import java.text.DecimalFormat;

public class Evidence {

    private String id;
    private String description;
    private String dateOfDiscovery;
    private static int idCount = 0;
    DecimalFormat df = new DecimalFormat("000000");

    /**
     * creates an Evidence object with an id
     */
    public Evidence(String evidenceName, int id, String description, String dateCollected) {
        idCount++;
        this.setID();
    }


    public Evidence() {
      idCount++;
      this.setID();
      this.description = "";
      this.dateOfDiscovery = "";
    }
    /**
     * creates an Evidence object by reading in the parameters from a json file
     * @param id id of piece of evidence
     * @param description statement about evidence and how it relates to crime
     * @param dateOfDiscovery date the piece of evidence was found
     */
    public Evidence(String id, String description, String dateOfDiscovery) {
        this.id = id;
        this.description = description;
        this.dateOfDiscovery = dateOfDiscovery;
    }

    /**
     * return id of piece of evidence
     * @return id of evidence
     */
    public String getID() {
        return this.id;
    }

    /**
     * gives piece of evidence an id
     */
    private void setID() {
        this.id = "E" + df.format(idCount);
    }

    /**
     * returns description of piece of evidence
     * @return dicription of evidence
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * sets discription to passed in String
     * @param description description of evidence
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * returns date of discovery
     * @return date evidence was discoved as a String
     */
    public String getDateOfDiscovery() {
        return this.dateOfDiscovery;
    }

    /**
     * sets date of discovery to passed in String
     * @param dateOfDiscovery date evidence was discovered
     */
    public void setDateOfDiscovery(String dateOfDiscovery) {
        this.dateOfDiscovery = dateOfDiscovery;
    }


}