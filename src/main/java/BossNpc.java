import java.util.ArrayList;
import java.util.Random;

public class BossNpc extends Npc
{
  public double bossHealth;
  public int strength;
  public int defense;

  public BossNpc(String name, int age, boolean isPassive, double bossHealth, int strength, int defense)
  {
    super(name, age, isPassive);
    this.bossHealth = bossHealth;
    this.strength = strength;
    this.defense = defense;
  }
  
  // NOTE this is private because it should only be used in this class
  public void spawn()
  {

    System.out.println("BossNpc spawn");
    
    // create list of non hostile locations
    ArrayList<Location> hostileLocations = new ArrayList<Location>();

    // go through list of all spawn locations, add non hostile locations to new list
    for (int i = 0; i < spawnLocations.size(); i++)
    {
      if (spawnLocations.get(i).isHostile)
      {
        hostileLocations.add(spawnLocations.get(i));
      }
    }

    // select random Location from non-hostile list
    Random r = new Random();
    int locIndex = r.nextInt(hostileLocations.size());
    Location randomLoc = hostileLocations.get(locIndex);

    // set this VendorNpc's coordinates to that of selected Location
    this.x = randomLoc.x;
    this.y = randomLoc.y;
    this.z = randomLoc.z;
  }

  public String toString()
  {
    String result = super.toString();
    return result + "\nHealth: " + this.bossHealth + "\nStrength: " + this.strength + "\nDefense: " + this.defense;
  }

  public String attack()
  {
    if (this.bossHealth > 0)
    {
      return "You have taken " + strength + " damage from this boss.";
    }
    else
    {
      return "This boss has no health left to attack.";
    }
  }
  // getter
  public double getCurrentHealth()
  {
    return bossHealth;
  }
  // setter
  public void setStrength(int newStrength)
  {
    strength = newStrength;
  }

  public boolean equals(Object other)
    {
      if (other == null)
      {
        return false;
      }

      if (!(other instanceof BossNpc))
      {
        return false;
      }

      BossNpc otherBoss = (BossNpc) other;

      return super.equals(otherBoss) && this.strength == otherBoss.strength && this.defense == otherBoss.defense;
    }
}