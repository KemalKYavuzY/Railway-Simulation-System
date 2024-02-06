package RailwaySimulation;

import api.*;

/**
 * 
 * @author Kemal Yavuz
 * 
 * Implementation of the Crossable interface representing a switch between multiple paths,
 * allowing a train to proceed along any of the paths from a common entry point.
 *
 */
public class MultiSwitchLink extends AbstractLink {
	
	/**
	 * An array of PointPairs, where each pair represents the endpoints of a single path.
	 */
    private PointPair[] pairs;
    
    /**
     * The index of the active path in the array of pairs.
     */
    private int activeIndex;

    /**
     * Constructs a switch link between multiple paths with a common entry point.
     * @param pairs an array of PointPairs, where each pair represents the endpoints of a single path
     */
    public MultiSwitchLink(PointPair[] pairs) {
        super(pairs);
        this.pairs = pairs;
        this.activeIndex = 0;
    }
    
    /**
     * Returns the number of paths through this link.
     * @return the length of the array of PointPairs
     */
    @Override
    public int getNumPaths() {
        return pairs.length;
    }
    
    
    /**
     * Returns the point at the other end of the given path.
     * @param p the point at one end of the path
     * @return the point at the other end of the path
     */
    @Override
    public Point getConnectedPoint(Point p) {
        return super.getConnectedPoint(p);
    }
    
    /**
     * Shifts the position of the endpoints by the given vector.
     * @param pv the vector by which to shift the endpoints
     */
    @Override
    public void shiftPoints(PositionVector pv) {
        super.shiftPoints(pv);
    }

    /**
     * Switches the connection between two endpoints.
     * @param pair the endpoints to switch
     * @param pathIndex the index of the path that contains the first endpoint
     */
    public void switchConnection(PointPair pair, int pathIndex) {
    	
        if (pathIndex == activeIndex && pathIndex >= 0 && pathIndex < pairs.length) {
            if (pair.equals(pairs[pathIndex])) {
                activeIndex = pathIndex;
            }
            pairs[pathIndex] = pair;
        }
    }
}
