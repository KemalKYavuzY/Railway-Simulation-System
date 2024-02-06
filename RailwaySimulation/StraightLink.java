package RailwaySimulation;

import api.*;

/**
 * 
 * @author Kemal Yavuz
 * 
 * Implementation of the Crossable interface representing a link between two paths that are straight and continuous.
 * A train entering one of the connected paths will be able to continue straight across the link to the other path.
 */
public class StraightLink extends AbstractLink {
	
	/**
	 * This static int instance variable is to determine the condition in AbstractLink
	 */
	private static int temp = 2;
	
	/**
	 * Constructs a StraightLink with the given endpoints and a third point.
	 * 
	 * @param highEndpoint - the endpoint of the path that has the higher y-coordinate
	 * @param lowEndpoint - the endpoint of the path that has the lower y-coordinate
	 * @param thirdPoint - a point on the link that is neither of the endpoints
	 */
    public StraightLink(Point highEndpoint, Point lowEndpoint, Point thirdPoint) {
    	super(highEndpoint, lowEndpoint, thirdPoint, temp);
    }
    
    /**
     * Returns the connected point on the other side of this link for the given point.
     * 
     * @param p - the point for which to find the connected point
     * @return the connected point on the other side of this link for the given point
     */
    @Override
    public Point getConnectedPoint(Point p) {
    	return super.getConnectedPoint(p);
    }
    
    /**
     * Shifts the position of the endpoints and third point of this link by the given vector.
     * 
     * @param pv
     *            the vector by which to shift the position of the endpoints and third point
     */
    @Override
    public void shiftPoints(PositionVector pv) {
    	super.shiftPoints(pv);
    }
    
    /**
     * Returns the number of paths that this link connects.
     * 
     * @return the number of paths that this link connects
     */
	@Override
	public int getNumPaths() {
		return 3;
	}
}

