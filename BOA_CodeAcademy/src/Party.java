public class Party {
  String id, jurisdiction, clientType;
  boolean isSanctioned;

  Party(String id, String jurisdiction, String clientType, boolean isSanctioned) {
    this.id = id;
    this.jurisdiction = jurisdiction;
    this.clientType = clientType;
    this.isSanctioned = isSanctioned;
  }
}
