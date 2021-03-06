package by.auto.test.model;

public class ContactObject {
  private String contactFN;
  private String contactMN;
  private String contactLN;
  private String contactNickName;
  private String contactTitle;
  private String contactCompany;
  private String contactAddress;
  private String contactHome;
  private String contactMobile;
  private String contactWork;
  private String contactFax;
  private String contactMarryYear;
  private String contactBirthYear;
  private String group;
  private String contactHome2;
  private String email1;
  private String email2;
  private String email3;
  private String allPhones;
  private String allEmails;

  public String getAllEmails() {
    return allEmails;
  }

  public ContactObject withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  private int id = Integer.MAX_VALUE;

  public String getAllPhones() {
    return allPhones;
  }

  public ContactObject withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }



  public ContactObject withEmail1(String email1) {
    this.email1 = email1;
    return this;
  }

  public ContactObject withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactObject withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public String getEmail1() {

    return email1;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }



  public ContactObject withFN(String contactFN) {
    this.contactFN = contactFN;
    return this;
  }

  public ContactObject withHome2(String contactHome2) {
    this.contactHome2 = contactHome2;
    return this;
  }

  public ContactObject withMN(String contactMN) {
    this.contactMN = contactMN;
    return this;
  }

  public ContactObject withLN(String contactLN) {
    this.contactLN = contactLN;
    return this;
  }

  public ContactObject withNickName(String contactNickName) {
    this.contactNickName = contactNickName;
    return this;
  }

  public ContactObject withTitle(String contactTitle) {
    this.contactTitle = contactTitle;
    return this;
  }

  public ContactObject withCompany(String contactCompany) {
    this.contactCompany = contactCompany;
    return this;
  }

  public ContactObject withAddress(String contactAddress) {
    this.contactAddress = contactAddress;
    return this;
  }

  public ContactObject withHome(String contactHome) {
    this.contactHome = contactHome;
    return this;
  }

  public ContactObject withMobile(String contactMobile) {
    this.contactMobile = contactMobile;
    return this;
  }

  public ContactObject withWork(String contactWork) {
    this.contactWork = contactWork;
    return this;
  }

  public ContactObject withFax(String contactFax) {
    this.contactFax = contactFax;
    return this;
  }

  public ContactObject withMarryYear(String contactMarryYear) {
    this.contactMarryYear = contactMarryYear;
    return this;
  }

  public ContactObject withBirthYear(String contactBirthYear) {
    this.contactBirthYear = contactBirthYear;
    return this;
  }

  public ContactObject withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactObject withId(int id) {
    this.id = id;
    return this;
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

  public String getContactHome2() {
    return contactHome2;
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
