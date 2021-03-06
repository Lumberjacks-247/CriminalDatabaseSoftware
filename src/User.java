package src;
public class User {
	private int accessLevel;
	private String userName, firstName, lastName, userPassword;

  public User(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public User(String userName, String firstName, String lastName, int accessLevel, String userPassword) {
	  this.userName = userName;
	  this.firstName = firstName;
	  this.lastName = lastName;
	  this.accessLevel = accessLevel;
	  this.userPassword = userPassword;
  }
  
  public int getAccessLevel() {
    return this.accessLevel;
  }

  public void setAccessLevel(int accLevel) {
    this.accessLevel = accLevel;
  }
  
  public String getUserName() {
	  return this.userName;
  }
  public void setUserName(String userName) {
	  this.userName = userName;
  }

  public String getFirstName() {
    return this.firstName;
  }
  
  public void setFirstName(String name) {
    this.firstName = name;
  }

  public String getLastName() {
    return this.lastName;
  }
 

  public void setLastName(String name) {
    this.lastName = name;
  }
  
  public String getPassword() {
	  return userPassword;
  }
  public void setPassword(String userPassword) {
	  this.userPassword = userPassword;
  }


}