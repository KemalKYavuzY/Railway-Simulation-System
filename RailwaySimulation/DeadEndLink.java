package RailwaySimulation;

import api.*;

/**
 * 
 * @author Kemal Yavuz
 *
 * Implementation of the AbstractLink class that represents a dead end link, which is a link with a single endpoint
 * that does not connect to any other links.
 * This class is a subclass of AbstractLink and implements the methods from the Link and Shape interfaces.
 */
public class DeadEndLink extends AbstractLink {
    	
		/**
		 * This static int instance variable is to determine the condition in AbstractLink
		 */
		private static int temp = 0;
	
	    /**
	     * Constructs a DeadEndLink object with no endpoint.
	     * This constructor calls the constructor of the AbstractLink class with null parameters for endpoints and path, 
 		 * and the integer value of "temp" for the condition of the link.
	     * @param path - the path on which this dead end is located
	     */
	    public DeadEndLink() {
	    	super(null, null, null, temp);
	    }
	    
	    /**
	     * Returns the number of paths connected to this link.
		 * 
		 * This method overrides the getNumPaths() method of the Link interface and returns 1, since a dead end link 
		 * has only one path.
		 * 
		 * @return the number of paths connected to this link
	     */
	    @Override
	    public int getNumPaths() {
	        return 1;
	    }
	    
	    /**
	     * Returns the connected point on this link.
		 * 
		 * This method overrides the getConnectedPoint(Point p) method of the Link interface and returns null, 
		 * since a dead end link does not have any connected points.
		 * 
		 * @param p - a point
		 *   
		 * @return null since a dead end link does not have any connected points.
	     */
	    @Override
	    public Point getConnectedPoint(Point p) {
	       return super.getConnectedPoint(p);
	    }
	    
	    /**
	     * Shifts the endpoints of this link by the given position vector.
		 * 
		 * This method overrides the shiftPoints(PositionVector pv) method of the Shape interface 
		 * and calls the same method in the superclass to shift the endpoints of the link by the given vector.
		 * 
		 * @param pv - the position vector by which to shift the endpoints of the link
	     */
		@Override
		public void shiftPoints(PositionVector pv) {
			super.shiftPoints(pv);
		}
}
