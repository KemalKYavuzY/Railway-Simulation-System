package RailwaySimulation;

import api.*;

/**
 * 
 * @author Kemal Yavuz
 * 
 * Implementation of the Crossable interface representing a fixed link between multiple paths,
 * allowing a train to proceed along each path in sequence without the ability to switch paths.
 *
 */
public class MultiFixedLink extends AbstractLink {
	
	/**
	 * Array of PointPair objects representing the entry and exit points for each path in order.
     * The exit point of one pair should be the entry point of the next.
     * For example, if there are three paths, pairs[0] connects the first two paths, pairs[1] connects
     * the second and third paths, and so on.
	 */
	private PointPair[] pairs;
	
	
    /**
     * Constructs a fixed link between multiple paths.
     * @param pairs an array of PointPair objects representing the entry and exit points for each path in order.
     *              The exit point of one pair should be the entry point of the next.
     *              For example, if there are three paths, pairs[0] connects the first two paths, pairs[1] connects
     *              the second and third paths, and so on.
     */
    public MultiFixedLink(PointPair[] pairs) {
    	super(pairs);
    	this.pairs = pairs;
    }

    /**
     * Returns the number of paths associated with this object.
     * In a MultiFixedLink, the number of paths is equal to the number of pairs in the input array plus one.
     * @return number of paths
     */
    @Override
    public int getNumPaths() {
        return pairs.length + 1;
    }
    
    /**
     * Returns the Point on the other side of the link that is connected to the specified point.
     * If the input Point is not one of the endpoints of the link, the behavior of this method is undefined.
     * @param p one of the two endpoints of the link
     * @return the other endpoint of the link
     */
    @Override
    public Point getConnectedPoint(Point p) {
        return super.getConnectedPoint(p);
    }

    
    /**
     * Shifts the position of the link by the specified vector.
     * This method does not change the position of any endpoints; rather, it changes the position of the entire link
     * in such a way that the relative position of each endpoint to the others remains the same.
     * @param pv PositionVector by which to shift this object
     */
    @Override
    public void shiftPoints(PositionVector pv) {
        super.shiftPoints(pv);
    }
}

