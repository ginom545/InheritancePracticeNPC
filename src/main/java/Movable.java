/*

In retrospect, this was not the best example of interfaces! 🙁 

Here are two reasons why this was not the best example of interfaces:

1 - Interfaces typically should not suggest that a class uses certain properties
The interface will REQUIRE that a class uses certain methods
But unlike inheritance, interfaces really should not say anything about the properties that are involved (except perhaps a static constant)
In other words, interfaces should not suggest that you have certain object properties … it should be up to the class to decide how they implement an interface’s functions, and it should be up to the class to decide what properties are relevant to doing that

2 - Similarly, an interface typically should not contain getter/setter methods
As above, this is because this is suggesting certain properties

*/

interface Movable
{

  public void move();
  public void setSpeedX(double x);
  public void setSpeedY(double y);
  public void setSpeedZ(double z);
  public double getSpeedX();
  public double getSpeedY();
  public double getSpeedZ();  
  
}