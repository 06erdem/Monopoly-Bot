package Bot;

public class Tiles {
        
        int price; //price of tile
        int tax; //tax applied to the tile from bank
        int position; //position on board
        int rent; //rent due from the tile
        boolean owned; //boolean to see if the tile is currently owned
        String name; //name of the tile
  
        public Tiles(int prices, int taxes, String names, int index, int rents){
                price = prices;
                tax = taxes;
                owned = false;
                position = index;
                name = names;
                rent = rents;
        }
  
        void buyProperty(){ //function to buy the property if the tile is unowned
                owned = true;
                player.addMoney(-(price));
        }
        
        void rentProperty(){ //function that subtracts rent from players money if the tile is owned by someone else
                player.addMoney(-(rent));
        }
      
        void payBankTax(){ //function that subtracts bank tax
                player.addMoney(-(tax));
        }
        
        
        void goToJail(){ //function that subtracts 200 when going to jail, might have to change player position from here?
                player.addMoney(-200);
        }
  
      
      
}
