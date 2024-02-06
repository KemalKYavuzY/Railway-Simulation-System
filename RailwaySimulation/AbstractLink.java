package hw4;

import api.*;

/**
 * 
 * @author Kemal Yavuz
 * 
 * Abstract base class for implementations of the Crossable interface.
 * Provides default implementations of methods getNumPaths() and 
 * shiftPoints(PositionVector) that are appropriate for classes
 * that have a single entry and exit point and do not rotate.
 *
 */
public abstract class AbstractLink implements Crossable {
  
	  /**
	   * First point of the link.
	   */
	  private Point PointA;
	  
	  /**
	   * Second point of the link.
	   */
	  private Point PointB;
	  
	  /**
	   * Third point of the link (used only for certain link types). 
	   */
	  private Point PointC;
	  
	  /**
	   * Array of point pairs, where each pair represents the endpoints of a single path.
	   */
	  private PointPair[] pairs;
	  
	  /**
	   * Flag indicating whether the link is a CoupleLink.
	   */
	  private boolean Couple;
	  
	  /**
	   * Flag indicating whether the link is a StraightLink.
	   */
	  private boolean Straigth;
	  
	  /**
	   * Flag indicating whether the link is a MultiFixedLink or MultiSwitchLink.
	   */
	  private boolean Multi;
	  
	  /**
	   * Flag indicating whether the link is a TurnLink.
	   */
	  private boolean Turn;
	  
	  /**
	   * Flag indicating whether the link is a SwitchLink.
	   */
	  private boolean Switch;
	  
	  /**
	   * Flag indicating whether the link has turned.
	   */
	  private boolean turn;
	  
	  /**
	   * Flag indicating whether a train is currently crossing the link.
	   */
	  private boolean isCrossing;
	
	  /**
	   * Constructs a link between multiple paths with a common entry point.
	   * Used for MultiFixedLink and MultiSwitchLink classes.
	   * @param pairs an array of PointPairs, where each pair represents the endpoints of a single path
	   */
	  protected AbstractLink(PointPair[] pairs) {
		  this.PointA = pairs[0].getPointA();
		  this.PointB = pairs[0].getPointB();
	      this.pairs = pairs;
	      Multi = true;
	  }
	  
	  /**
	   * Constructs a link between two points (used for CoupleLink, StraightLink, TurnLink, and SwitchLink classes).
	   * @param highEndpoint the higher of the two endpoints
	   * @param lowEndpoint the lower of the two endpoints
	   * @param thirdPoint the third point (used only for TurnLink and SwitchLink classes)
	   * @param temp an integer flag indicating the type of link (1 for CoupleLink, 2 for StraightLink, 3 for SwitchLink, 4 for TurnLink)
	   */
	  protected AbstractLink(Point highEndpoint, Point lowEndpoint, Point thirdPoint, int temp) {
		 if (highEndpoint != null) {
			 this.PointA = highEndpoint;
		 }
		 
		 if (lowEndpoint != null) {
			 this.PointB = lowEndpoint;
		 }
		 
		 if (thirdPoint != null) {
			 this.PointC = thirdPoint;
		 }
		 
		 if (temp == 1) {
			 Couple = true;
		 } else if (temp == 2) {
			 Straigth = true;
		 } else if (temp == 3) {
			 Switch = true;
		 } else if (temp == 4) {
			 Turn = true;
		 }
			 
	  }
	
		/**
		 * Sets isCrossing to true when the train enters crossing.
		 */
	    @Override
		public void trainEnteredCrossing() {
			isCrossing = true;		
		}
		
	    /**
	     * Sets isCrossing to false when the train exits crossing.
	     */
		@Override
		public void trainExitedCrossing() {
			isCrossing = false;
	
		}
		
		/**
		 * Gets isCrossing
		 * @return isCrossing
		 */
		protected boolean getIsCrossing() {
			return isCrossing;
		}
	  
	  /**
	   * Returns the connected point for a given point.
	   * @param p the point to get the connected point for
	   * @return the connected point
	   */
	  @Override
	  public Point getConnectedPoint(Point p) {
		  if (Straigth || Turn) {						// If it's a straight or turn track segment
		  	  if (p == PointA && Straigth) {			// If p is the starting point and it's a straight segment
		          return PointB;						// Return the ending point
		      } else if (p == PointA && Turn) {			// If p is the starting point and it's a turn segment
		          return PointC;						// Return the connecting point
		      } else if (p == PointB) {					// If p is the ending point
		          return PointA;						// Return the starting point
		      } else if (p == PointC) {					// If p is the connecting point
			        return PointA;						// Return the starting point
		      }
		  } else if (Couple) { 							// If it's a coupling track segment
			  if (p == PointA) {						// If p is the first point
		          return PointB;						// Return the second point
		      } else {									// Otherwise
		          return PointA;						// Return the first point
		      }
		  } else if (Switch) { 							// If it's a switch track segment
			  if (p == PointA && !turn) {				// If p is the starting point and the switch is not turned
		          return PointB;						// Return the ending point
		      } else if (p == PointA && turn) {			// If p is the starting point and the switch is turned
		    	  return PointC;						// Return the connecting point
		      } else if (p == PointB) {					// If p is the ending point
		          return PointA;						// Return the starting point
		      } else if (p == PointC) {					// If p is the connecting point
			        return PointA;						// Return the starting point
		      }
		  } else if (Multi) {							// If it's a multi-track segment
			  for (int i = 0; i < pairs.length; ++i) {									
		            if (pairs[i].getPointA().equals(p)) {								// If the first point in the pair matches p
		                return pairs[i].getPointB();									// Return the second point in the pair
		            }		
		        }
		  }
		  
		  return null;
	  }
	  
	  /**
	   * Shifts the points of this track segment by the given position vector.
	   * @param pv the position vector to shift by
	   */
	  @Override
	  public void shiftPoints(PositionVector pv) {
	      Point a = pv.getPointA(); 			  // Get the starting point of the position vector
	      Point b = pv.getPointB(); 			 // Get the ending point of the position vector
	      Point c = getConnectedPoint(b); 		// Get the connected point of the ending point
	      
	      if (Couple || Straigth || Turn || Switch || Multi) {		//If one of these flags are true the Point c is not going to be null.
	    	  if (a.getPath() == b.getPath()) {					   // If the starting and ending points are on the same path
	    		  if (c.getPath().getLowpoint() == c) {		      // If the connected point is the low point
	    			  pv.setPointA(c);						     // Set the starting point to the connected point
		  	          pv.setPointB(c.getPath().getPointByIndex(1));
		      	  } else if (c.getPath().getHighpoint() == c) {
		      		  pv.setPointA(c);
		  	          pv.setPointB(c.getPath().getPointByIndex(c.getPointIndex() - 1));
		      	  }
	    	  }
	      }
	  }
	  
	  /**
	   * Sets the turn direction of this track segment.
 	   * @param turn the turn direction (true for left, false for right)
	   */
	  protected void setTurn(boolean turn) {
		  this.turn = turn;
	  }
}