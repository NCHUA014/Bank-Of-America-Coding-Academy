import java.util.Set;

public class Instrument {
  String id, type;
  Set<String> allowedJurisdictions;

  Instrument(String id, String type, Set<String> allowedJurisdictions) {
    this.id = id;
    this.type = type;
    this.allowedJurisdictions = allowedJurisdictions;
  }
}
