package by.auto.test.model;

public class ContactObject {
  private final String contactFN;
  private final String contactMN;
  private final String contactLN;
  private final String contactNickName;
  private final String contactTitle;
  private final String contactCompany;
  private final String contactAddress;
  private final String contactHome;
  private final String contactMobile;
  private final String contactWork;
  private final String contactFax;
  private final String contactMarryYear;
  private final String contactBirthYear;
  private String group;
  private int id;

  public ContactObject(int id, String contactFN, String contactMN, String contactLN, String contactNickName, String contactTitle, String contactCompany, String contactAddress, String contactHome, String contactMobile, String contactWork, String contactFax, String contactMarryYear, String contactBirthYear, String group) {
    this.contactFN = contactFN;
    this.contactMN = contactMN;
    this.contactLN = contactLN;
    this.contactNickName = contactNickName;
    this.contactTitle = contactTitle;
    this.contactCompany = contactCompany;
    this.contactAddress = contactAddress;
    this.contactHome = contactHome;
    this.contactMobile = contactMobile;
    this.contactWork = contactWork;
    this.contactFax = contactFax;
    this.contactMarryYear = contactMarryYear;
    this.contactBirthYear = contactBirthYear;
    this.group = group;
    this.id = id;
  }

  public ContactObject(String contactFN, String contactMN, String contactLN, String contactNickName, String contactTitle, String contactCompany, String contactAddress, String contactHome, String contactMobile, String contactWork, String contactFax, String contactMarryYear, String contactBirthYear, String group) {
    this.contactFN = contactFN;
    this.contactMN = contactMN;
    this.contactLN = contactLN;
    this.contactNickName = contactNickName;
    this.contactTitle = contactTitle;
    this.contactCompany = contactCompany;
    this.contactAddress = contactAddress;
    this.contactHome = contactHome;
    this.contactMobile = contactMobile;
    this.contactWork = contactWork;
    this.contactFax = contactFax;
    this.contactMarryYear = contactMarryYear;
    this.contactBirthYear = contactBirthYear;
    this.group = group;
    this.id = Integer.MAX_VALUE;
  }

  public ContactObject(int id, String contactFN, String contactLN) {
    this.contactFN = contactFN;
    this.contactMN = null;
    this.contactLN = contactLN;
    this.contactNickName = null;
    this.contactTitle = null;
    this.contactCompany = null;
    this.contactAddress = null;
    this.contactHome = null;
    this.contactMobile = null;
    this.contactWork = null;
    this.contactFax = null;
    this.contactMarryYear = null;
    this.contactBirthYear = null;
    this.group = null;
    this.id = id;
  }

  public String getContactFN() {
    return contactFN;
  }

  public String getContactMN() {
    return contactMN;
  }

  public String getContactLN() {
    return contactLN;
  }

  public String getContactNickName() {
    return contactNickName;
  }

  public String getContactTitle() {
    return contactTitle;
  }

  public String getContactCompany() {
    return contactCompany;
  }

  public String getContactAddress() {
    return contactAddress;
  }

  public String getContactHome() {
    return contactHome;
  }

  public String getContactMobile() {
    return contactMobile;
  }

  public String getContactWork() {
    return contactWork;
  }

  public String getContactFax() {
    return contactFax;
  }

  public String getContactMarryYear() {
    return contactMarryYear;
  }

  public String getContactBirthYear() {
    return contactBirthYear;
  }

  public String getGroup() {
    return group;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactObject that = (ContactObject) o;

    if (contactFN != null ? !contactFN.equals(that.contactFN) : that.contactFN != null) return false;
    return contactLN != null ? contactLN.equals(that.contactLN) : that.contactLN == null;
  }

  @Override
  public int hashCode() {
    int result = contactFN != null ? contactFN.hashCode() : 0;
    result = 31 * result + (contactLN != null ? contactLN.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ContactObject{" +
            "contactFN='" + contactFN + '\'' +
            ", contactLN='" + contactLN + '\'' +
            '}';
  }

  public int getId() {
    return id;
  }
}
