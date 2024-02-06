package hw4;

import api.*;

/**
 * 
 * @author Kemal Yavuz
 *
 * Implementation of the Crossable interface representing a link between two paths that involves a turn.
 * A train entering one of the connected paths will turn onto a third path before continuing straight across the link to the other path.
 * This class extends the AbstractLink class and implements the Crossable interface.
 */
public class TurnLink extends AbstractLink {
	
	/**
	 * This static int instance variable is to determine the condition in AbstractLink
	 */
	private static int temp = 4;
	
	/**
	 * Constructs a TurnLink with the given endpoints.
	 * 
	 * @param highEndpoint the higher endpoint
	 * @param lowEndpoint the lower endpoint
	 * @param thirdPoint the third point at which the link turns
	 */
    public TurnLink(Point highEndpoint, Point lowEndpoint, Point thirdPoint) {
    	
        super(highEndpoint, lowEndpoint, thirdPoint, temp);
    }
    
    /**
     * Gets the number of paths in this TurnLink.
     * 
     * @return the number of paths, which is 3
     */
    @Override
    public int getNumPaths() {
        return 3;
    }
    
    /**
     * Gets the connected point on this TurnLink.
     * 
     * @param p the point from which to get the connected point
     * @return the connected point on this TurnLink
     */
    @Override
    public Point getConnectedPoint(Point p) {
       return super.getConnectedPoint(p);
    }
    
    /**
     * Shifts the endpoints of this TurnLink by the given PositionVector.
     * 
     * @param pv the PositionVector by which to shift the endpoints of this TurnLink
     */
    @Override
    public void shiftPoints(PositionVector pv) {
    	super.shiftPoints(pv);
    }
}