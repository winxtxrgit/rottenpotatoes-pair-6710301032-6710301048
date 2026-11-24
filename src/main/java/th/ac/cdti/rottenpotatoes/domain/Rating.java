package th.ac.cdti.rottenpotatoes.domain;

public enum Rating {
  G("G"), PG("PG"), PG13("PG-13"), R("R"), NC17("NC-17");

  private final String label;
  Rating(String label) { this.label = label; }
  public String label() { return label; }

  public static Rating fromLabel(String label) {
    for (Rating r : values()) {
      if (r.label.equals(label)) { return r; }
    }
    throw new IllegalArgumentException("unknown rating: " + label);
  }
}
