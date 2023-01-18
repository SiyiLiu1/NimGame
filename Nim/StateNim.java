/*
 * For any game, the stateT structure records the current state
 * of the game.  
 *
 */


public class StateNim extends State {

    int curNum = 13;
    // public int curNum;
    // public int player;
    public StateNim() {
    	// curNum = 13;
        player = 1;
    }
    
    public StateNim(StateNim state) {
    	
        curNum = state.curNum;
        
        player = state.player;
    }
    
    public String toString() {
    	
    	String ret = Integer.toString(curNum);
    	
    	return ret;
    }
}
