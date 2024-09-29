public class Main 
{
  public static void main(String[] args) 
  {

    // create Locations
    Location loc1 = new Location(0, 50, 0, "Spawn Point", false);
    Location loc2 = new Location(40, 30, 20, "Forest", false);
    Location loc3 = new Location(60, 80, 45, "Castle", true);

    // setup initial NPC spawnLocations
    // note that I can do this before I create any Npc objects
    // the addSpawnLocation method is taken from the Npc class
    Npc.addSpawnLocation(loc1);
    Npc.addSpawnLocation(loc2);
    Npc.addSpawnLocation(loc3);

    // create NPCs
    Npc npc1 = new Npc("Jeff", 30, true);
    BossNpc npc2 = new BossNpc("Darth Vader", 40, false, 100.0, 10, 5);
    VendorNpc npc3 = new VendorNpc("Shopkeeper", 55, true, 100, 25);

    // spawn NPCs
    npc1.spawn();
    npc2.spawn();
    npc3.spawn();
    
    // calling NPC methods  
    System.out.println(npc1.speak());
    System.out.println(npc2.attack());
    System.out.println(npc3.purchaseProduct());

    // call overriden speak methods
    System.out.println();
    System.out.println(npc2.speak());
    System.out.println(npc3.speak());

    // print all of these objects (implicitly uses toString)
    System.out.println();
    System.out.println(npc1);
    System.out.println();
    System.out.println(npc2);
    System.out.println();
    System.out.println(npc3);

    // blank line
    System.out.println();

    // call getters / setters
    npc1.setName("Jeffery");
    npc1.getName();
    npc2.getCurrentHealth();
    npc2.setStrength(12);
    npc3.getProductNum();
    npc3.setLevelRequired(50);
    
  }
}