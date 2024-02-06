package hw4;

import api.*;

/**
 * 
 * @author Kemal Yavuz
 *
 * Implementation of the AbstractLink class representing a switch between two paths,
 * allowing a train to proceed along either path from a common entry point.
 * 
 * This class represents a SwitchLink which is used to connect two paths that share a common entry point, 
 * enabling a train to travel along either path. This link has three points and three paths.
 * One endpoint of the link is connected to the first path, the second endpoint is connected to the second path,
 * and the middle point is the common entry point where both paths meet.
 * The switch can be set to either straight or turn position to allow a train to go straight or turn 
 * on to either path from the common entry point.
 */
public class SwitchLink extends AbstractLink {
	
	/**
	 * This static int instance variable is to determine the condition in AbstractLink
	 */
	private static int temp = 3;
	
    /**
     * Constructs a switch link between two paths with a common entry point.
     * 
     * @param endPointA the endpoint on the first path
     * @param endPointB the common entry point
     * @param endPointC the endpoint on the second path
     */
    public SwitchLink(Point endPointA, Point endPointB, Point endPointC) {
    	super(endPointA, endPointB, endPointC, temp);
    }
    
    /**
     * Returns the endpoint on the opposite path connected to the given point.
     * 
     * @param p a point connected to this switch link
     * @return the endpoint on the opposite path connected to the given point
     */
    @Override
    public Point getConnectedPoint(Point p) {
        return super.getConnectedPoint(p);
    }
    
    /**
     * Sets the switch to straight or turn position and notifies the crossing.
     * 
     * @param turn true if the switch is in the turn position, false if it is in the straight position
     */
    @Override
    public void setTurn(boolean turn) {
		super.setTurn(turn);
		if (turn == true) {
			trainEnteredCrossing();
		} else if (turn == false) {
			trainExitedCrossing();
		}
		
	}
    
    /**
     * Returns the number of paths connected to this switch link.
     * 
     * @return the number of paths connected to this switch link
     */
	@Override
	public int getNumPaths() {
		return 3;
	}
}

