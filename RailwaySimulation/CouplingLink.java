package RailwaySimulation;

import api.*;

/**
 * 
 * @author Kemal Yavuz
 *
 * Represents a coupling link that connects two paths at their endpoints, allowing a train to move from one path to the other.
 * Extends the AbstractLink class.
 */
public class CouplingLink extends AbstractLink {
	
	/**
	 * This static int instance variable is to determine the condition in AbstractLink
	 */
	private static int temp = 1;
	
	/**
	 * Constructs a CouplingLink that connects two paths at their endpoints, given the high and low endpoints.
	 * 
	 * @param highEndpoint - the endpoint of the path that is higher in the track
	 * @param lowEndpoint - the endpoint of the path that is lower in the track
	 */
    public CouplingLink(Point highEndpoint, Point lowEndpoint) {
    	super(highEndpoint, lowEndpoint, null, temp);
    }

    /**
     * Returns the number of paths that this coupling link connects.
     * 
     * @return - the number of paths that this coupling link connects
     */
    @Override
    public int getNumPaths() {
        return 2;
    }
    
    /**
     * Returns the connected point for the given point.
     * 
     * @param p - the point for which to find the connected point
     * @return - the connected point for the given point
     */
	@Override
	public Point getConnectedPoint(Point p) {
		return super.getConnectedPoint(p);
	}
	
	/**
	 * Shifts the high and low endpoints of this coupling link by the given position vector.
	 * 
	 * @param pv - the position vector by which to shift the endpoints of this coupling link
	 */
	@Override
	public void shiftPoints(PositionVector pv) {
		super.shiftPoints(pv);
	}
}
