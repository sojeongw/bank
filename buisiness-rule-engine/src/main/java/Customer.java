public class Customer {

  private final String name;
  private final String jobTitle;

  public String getName() {
    return name;
  }

  public String getJobTitle() {
    return jobTitle;
  }

  public Customer(String name, String jobTitle) {
    this.name = name;
    this.jobTitle = jobTitle;
  }
}
