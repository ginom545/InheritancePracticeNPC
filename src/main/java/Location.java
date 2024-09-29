class Location
{
  public double x;
  public double y;
  public double z;
  public String name;
  public boolean isHostile;

  public Location(double x, double y, double z, String name, boolean isHostile)
  {
    this.x = x;
    this.y = y;
    this.z = z;
    this.name = name;
    this.isHostile = isHostile;
  }
}