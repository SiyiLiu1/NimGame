import java.util.Set;

public class Search {
	Game game;
	
	public Search(Game game) { this.game = game; }
	
	public State bestSuccessorState(int depth) {
		
		double max = Double.NEGATIVE_INFINITY;
		State max_state = null;
		
		for(State state : game.getSuccessors(game.currentState)) {
			// System.out.println("depth");
			// System.out.println(depth);
			double min_val = MinValue(state,depth);
			// System.out.println("for loop min_val");
			// System.out.println(min_val);
			if(max < min_val) {
				max = min_val;
				max_state = state;
			}
		}
			
		return max_state;
	}
	
	double MaxValue(State state, int depth) {
		Set<State> successors = game.getSuccessors(state);
		
		if (depth==0 || successors==null)
			return game.eval(state);
		
		double v = Double.NEGATIVE_INFINITY;
		
		for(State s : game.getSuccessors(state)) 
			v = Math.max(v, MinValue(s,depth-1));
		// System.out.println("MaxValue");
		// 	System.out.println(v);
		return v;
	}
	
	double MinValue(State state, int depth) {
		Set<State> successors = game.getSuccessors(state);
		
		if (depth==0 || successors==null)
			return game.eval(state);
		
		double v = Double.POSITIVE_INFINITY;
		
		for(State s : game.getSuccessors(state)) 
			v = Math.min(v, MaxValue(s,depth-1));
		// System.out.println("MinValue");
		// System.out.println(v);
		return v;
	}	
}
