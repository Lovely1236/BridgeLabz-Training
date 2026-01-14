package cabBooking;
class User {
  private String name;
  private int id;

  User(String name, int id) {
    this.name = name;
    this.id = id;
  }

  // getter
  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

}