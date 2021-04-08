package Bot;
/* 
 * Control Center for game that handles interaction between board and receiver class.
 * Receiver : 
 *      take message from users
 *       call appropriate functions of controller according to message  (such as start new game, next move info 
 *                (trade, rolll dice, next turn, buy property ,... ) , reset game ,.... )
 *       take action result from controller
 *        return appropriate message to chat depend on that action result 
 *
 * Controller:
 * 		  keep track of game status (GameState)
 *        take message from receiver
 *        manage logic and run the game. manipulate Board info as necessary
 *        update game state (if a person wins or they decide to concede the game early ->> here we calculate wealth 
 *                    and decides the winner)
 *        return  action result to receiver
 *
 *        Note : controller should have all access to board variables and handles the game logic
 *
 * Board: 
 *             Update board states and player states
 *             functions in board when called should only perform its task such as move player, add properties, 
 *                       add/subtract money, all logic whether an action is valid should be done in controller
 * 
 * 
 **/
public class Game_Control_Center {
	
	private int 	gameState = 0 ; // 0 = uninitialized , 1 = running , 2 = finished or not running
	private String 	rollArray[];  // take the output of roll dice function and split string into 2 numbers
	
	private String	instruction;  // instruction received from receiver class.
	private Board 	board;
	
	public Game_Control_Center() {
		gameState = 1 ;
		board = new Board();
	}
	
	/* Receive corresponding action from message received in Receiver. 
	 * Call appropriate function in Control Center to handle instruction.
	 * Return result message to receiver.
	 * 
	 * actionID : 
	 * 1-4 = player join, correspondingly to position in array of players
	 * 5   = next turn
	 * 6   = buy properties
	 * 7   = invoke trades
	 * */
	public String gameAction(int actionID) {
		String resultMessage = "success";
		
		if ( (actionID >=1) && (actionID <= 4))
			resultMessage = join(actionID);
			
		return resultMessage;
	}
	
	
	/*  
	   *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *
	 * ALL PRIVATE HELPER METHODS for gameAction function go down here  * 
	   *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  
	 * */
	private String join(int playerNumber) {
		String resultMessage = "success"; // default String of a successful operation
		if (board.playerList[playerNumber - 1] != null);
		return String.format("Cant join game ! Player %d already exist", playerNumber);
		board.addPlayer(playerId, emoji);
				
	}
}






























