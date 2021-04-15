import java.util.ArrayList;

class OrganizationTester_5BoxbergerSpencer {
  public static void main(String[] args) {
    Organization testOrg = new Organization("test");
    testOrg.addMember("John");
    testOrg.addMember("Steve");
    System.out.println(testOrg);

    Club recyclingClub = new Club("Recycling Club", "Recycling");
    recyclingClub.addMember("Billy");
    recyclingClub.addMember("Sarah");
    System.out.println(recyclingClub);

    Company apple = new Company("Apple", "Phones");
    apple.addMember("Bob");
    
    System.out.println(apple);
  }
}

class Organization {
  ArrayList<String> members = new ArrayList();
  private String organizationName;
  int memberCount;

  public Organization(String name) {
    organizationName = name;
  }

  public Organization() {
    organizationName = "N/A";
    memberCount = 0;
  }

  public void addMember(String name) {
    members.add(name);
    memberCount = members.size();
  }

  public String toString() {
    String memberNames = "";
    for(String name:members) {
      memberNames += name + ", ";
    }
    return "Organization Name: " + organizationName + ", Members: [" + memberNames + "] (Size: " + memberCount + ")";
  }
}

class Club extends Organization {
  private String clubTopic;

  public Club(String name, String topic) {
    super(name);
    clubTopic = topic;
  }

  public Club() {
    super();
    clubTopic = "N/A";
  }

  @Override
  public String toString() {
    return super.toString() + " Club Topic: " + clubTopic;
  }
}

class Company extends Organization {
  private String product;
  
  public Company(String name, String companyProduct) {
    super(name);
    product = companyProduct;
  }

  public Company() {
    super();
    product = "N/A";
  }
  
  @Override
  public String toString() {
    return super() + " Company Product: " + product;
  }
}

