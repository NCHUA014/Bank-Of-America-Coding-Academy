import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main {

  static Map<String, List<String>> InstrumentPermissions = new HashMap<>();
  static ArrayList<Party> parties;
  static ArrayList<Instrument> instruments;

  public static Party callByName(String name){
    for (Party party: parties){
      if (Objects.equals(party.id, name))
        return party;
    }
    return null;
  }

  public static Instrument callByID(String ID){
    for (Instrument instrument: instruments){
      if (Objects.equals(instrument.id, ID))
        return instrument;
    }
    return null;
  }

  public static boolean isGoodToTrade(String partyID,String instrumentID) {
  Party p = callByName(partyID);
  Instrument i = callByID(instrumentID);
  if(p.isSanctioned) return false;
  //System.out.println("Passed 1");

  //Check Jurisdiction
  if(!i.allowedJurisdictions.contains(p.jurisdiction))  return false;
  //System.out.println("Passed 2");

  //Check Instrument Type
  if(InstrumentPermissions.get(p.clientType).contains(i.type)) return true;
  //System.out.println("Passed 3");

  return false;
}


//  {partyId=P001, jurisdiction=EU, clientType=Retail, isSanctioned=false}
//  {partyId=P002, jurisdiction=EU, clientType=Institutional, isSanctioned=false}
//  {partyId=P003, jurisdiction=US, clientType=Retail, isSanctioned=true}
//  {partyId=P010, jurisdiction=SG, clientType=Institutional, isSanctioned=false}


//  {instrumentId=I001, instrumentType=Derivatives, allowedJurisdiction=EU}
//  {instrumentId=I002, instrumentType=Bonds, allowedJurisdiction=US,EU}
//  {instrumentId=I003, instrumentType=Stocks, allowedJurisdiction=EU,SG}
//  {instrumentId=I004, instrumentType=Forex, allowedJurisdiction=EU,US}


  public static void main(String[] args) {
    parties = new ArrayList<>();
    instruments = new ArrayList<>();
    InstrumentPermissions.put("Institutional",Arrays.asList("Derivatives","Bonds","Stocks","Forex"));
    InstrumentPermissions.put("Retail",Arrays.asList("Bonds","Stocks"));


    parties.add(new Party("P001","EU","Retail",false));
    parties.add(new Party("P002","EU","Institutional",false));
    parties.add(new Party("P003","US","Retail",true));
    parties.add(new Party("P010","SG","Institutional",false));


    Set<String> set001 = new HashSet<>(Arrays.asList("EU"));
    Set<String> set002 = new HashSet<>(Arrays.asList("US","EU"));
    Set<String> set003 = new HashSet<>(Arrays.asList("EU","SG"));
    Set<String> set004 = new HashSet<>(Arrays.asList("EU","US"));


    instruments.add(new Instrument("I001", "Derivatives", set001) );
    instruments.add(new Instrument("I002", "Bonds", set002) );
    instruments.add(new Instrument("I003", "Stocks", set003) );
    instruments.add(new Instrument("I004", "Forex", set004) );


    System.out.println(isGoodToTrade("P001","I002"));
    System.out.println(isGoodToTrade("P003","I004"));
    System.out.println(isGoodToTrade("P010","I002"));


  }
}