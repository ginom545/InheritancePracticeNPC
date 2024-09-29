import java.util.Random;
import java.util.ArrayList;

public class VendorNpc extends Npc
{
  
  public int numberOfProducts;
  public int levelRequired;

  public VendorNpc(String name, int age, boolean isPassive, int numberOfProducts, int levelRequired)
  {
    super(name, age, isPassive);
    this.numberOfProducts = numberOfProducts;
    this.levelRequired = levelRequired;
  }

  // create a public void method spawn
  // randomly select a non-hostile location from spawnLocations
  // set its coordinates to match as we did with Npc class
  // NOTE this is private because it should only be used in this class
  public void spawn()
  {

    System.out.println("VendorNpc spawn");

    // create list of non hostile locations
    ArrayList<Location> nonHostileLocations = new ArrayList<Location>();

    // go through list of all spawn locations, add non hostile locations to new list
    for (int i = 0; i < spawnLocations.size(); i++)
    {
      if (!(spawnLocations.get(i).isHostile))
      {
        nonHostileLocations.add(spawnLocations.get(i));
      }
    }

    // select random Location from non-hostile list
    Random r = new Random();
    int locIndex = r.nextInt(nonHostileLocations.size());
    Location randomLoc = nonHostileLocations.get(locIndex);

    // set this VendorNpc's coordinates to that of selected Location
    this.x = randomLoc.x;
    this.y = randomLoc.y;
    this.z = randomLoc.z;
    
  }
  
  // overrided toString
  public String toString()
  {
    String result = super.toString();
    return result + "\nNumber of Products: " + this.numberOfProducts + "\nLevel Required for Shop: " + this.levelRequired;
  }

  public String purchaseProduct()
  {
    if (numberOfProducts > 0)
    {
      numberOfProducts -= 1;
      levelRequired += 1;

      return "Number of products left after purchase: " + numberOfProducts + "\nNew level required: " + levelRequired;
    }
    else
    {
      return "There is no product left.";
    }
  }

  // getter
  public int getProductNum()
  {
    return numberOfProducts;
  }
  // setter
  public void setLevelRequired(int newLevel)
  {
    levelRequired = newLevel;
  }

  public boolean equals(Object other)
    {
      if (other == null)
      {
        return false;
      }

      if (!(other instanceof VendorNpc))
      {
        return false;
      }

      VendorNpc otherVendor = (VendorNpc) other;

      return super.equals(otherVendor) && this.numberOfProducts == otherVendor.numberOfProducts && this.levelRequired == otherVendor.levelRequired;
    }
}