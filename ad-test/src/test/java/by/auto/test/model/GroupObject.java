package by.auto.test.model;

public class GroupObject {
  private String groupName;
  private String groupHeader;
  private String groupFooter;
  private int id = Integer.MAX_VALUE;

  public GroupObject withId(int id) {
    this.id = id;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupObject that = (GroupObject) o;

    if (id != that.id) return false;
    return groupName != null ? groupName.equals(that.groupName) : that.groupName == null;
  }

  @Override
  public int hashCode() {
    int result = groupName != null ? groupName.hashCode() : 0;
    result = 31 * result + id;
    return result;
  }

  public GroupObject withName(String groupName) {
    this.groupName = groupName;

    return this;
  }

  public GroupObject withHeader(String groupHeader) {
    this.groupHeader = groupHeader;
    return this;
  }

  public GroupObject withFooter(String groupFooter) {
    this.groupFooter = groupFooter;
    return this;
  }

   public String getGroupName() {
    return groupName;
  }

  public String getGroupHeader() {
    return groupHeader;
  }


  public String getGroupFooter() {
    return groupFooter;
  }

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return "GroupObject{" +
            "groupName='" + groupName + '\'' +
            ", id='" + id + '\'' +
            '}';
  }

}
