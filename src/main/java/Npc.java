import java.util.ArrayList;
import java.util.Random;
public class Npc implements Movable
{

  // static properties
  public static ArrayList<Location> spawnLocations = new ArrayList<Location>();  

  // non-static properties (initialized by constructor parameters)
  public String name;
  public int age;
  public boolean isPassive;

  // non-static properties (initialized indirectly by constructor when it calls spawn)
  public double x;
  public double y;
  public double z;

  // add double speedX, speedY, speedZ properties
  public double speedX = 0;
  public double speedY = 0;
  public double speedZ = 0;
  
  // add Location to spawnLocations
  public static void addSpawnLocation(Location l)
  {
    spawnLocations.add(l);
  }
  
  public Npc(String name, int age, boolean isPassive)
  {
    this.name = name;
    this.age = age;
    this.isPassive = isPassive;
  }

  // randomly select any of the spawn locations 
  // then set coordinates to that location
  // NOTE this is private because it should only be used in this class
  public void spawn()
  {

    System.out.println("Npc spawn");
    
    Random r = new Random();
    int locIndex = r.nextInt(spawnLocations.size());

    Location randomLoc = spawnLocations.get(locIndex);

    this.x = randomLoc.x;
    this.y = randomLoc.y;
    this.z = randomLoc.z;
  }
  
  public String toString()
  {
    return "Name: " + name + "\nAge: " + age + "\nPassive NPC: " + isPassive;
  }

  public String speak()
  {
    if (isPassive)
    {
      return "Hello, Player!";
    }
    else
    {
      return "Prepare to die, Player!";
    }
    // i don't have time to code a whole dialogue system
    // LOL
  }

  // getter
  public String getName()
  {
    return name;
  }
  // setter
  public void setName(String newName)
  {
    name = newName;
  }

  public boolean equals(Object other)
  {
    if (other == null)
    {
      return false;
    }

    if (!(other instanceof Npc))
    {
      return false;
    }

    Npc otherNPC = (Npc) other;

    return this.name.equals(otherNPC.name) && this.age == otherNPC.age;
  }

  // getters and setters for all of the speed properties
  public double getSpeedX()
  {
    return speedX;
  }
  
  public double getSpeedY()
  {
    return speedY;
  }
  
  public double getSpeedZ()
  {
    return speedZ;
  }

  public void setSpeedX(double x)
  {
    speedX = x;
  }
  
  public void setSpeedY(double y)
  {
    speedY = y;
  }
  
  public void setSpeedZ(double z)
  {
    speedZ = z;
  }

  // add speedX to x, add speedY to y, add speedZ to z
  public void move()
  {
    x += speedX;
    y += speedY;
    z += speedZ;
  }
  
}