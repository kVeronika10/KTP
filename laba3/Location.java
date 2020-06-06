/**
 * This class represents a specific location in a 2D map.  Coordinates are
 * integer values.
 **/
public class Location
{
    /** X coordinate of this location. **/
    public int xCoord;

    /** Y coordinate of this location. **/
    public int yCoord;

    public int hashCode() {
        int result = 7;
        result *= 7 + xCoord;
        result *= 7 + yCoord;
        return result;
    }

    /** Creates a new location with the specified integer coordinates. **/
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    /** Creates a new location with coordinates (0, 0). **/
    public Location()
    {
        this.xCoord = 0;
        this.yCoord = 0;
    }


    public boolean equals(Object obj) {
        Location other = (Location) obj;
        return other.xCoord == xCoord && other.yCoord == yCoord; 
    }
}
