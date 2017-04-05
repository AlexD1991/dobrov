package by.auto.test.model;

public class GroupObject {
  private final String groupName;
  private final String groupHeader;
  private final String groupFooter;
  private int id;

  public GroupObject(int id, String groupName, String groupHeader, String groupFooter) {
    this.groupName = groupName;
    this.groupHeader = groupHeader;
    this.groupFooter = groupFooter;
    this.id = id;
  }

  public void setId(int id) {
    this.id = id;
  }



  public GroupObject(String groupName, String groupHeader, String groupFooter) {
    this.groupName = groupName;
    this.groupHeader = groupHeader;
    this.groupFooter = groupFooter;
    this.id = Integer.MAX_VALUE;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupObject that = (GroupObject) o;

    return groupName != null ? groupName.equals(that.groupName) : that.groupName == null;
  }

  @Override
  public int hashCode() {
    return groupName != null ? groupName.hashCode() : 0;
  }
}
