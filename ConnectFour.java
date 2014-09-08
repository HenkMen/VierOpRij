package vierOpRij;


public class ConnectFour {

  // het grid voor de spel layout 
  private int[][] grid; 
  // de actieve speler 
  private int activePlayer; 
  
  public ConnectFour() { 
    // creëert het grid 
    grid = new int[7][6]; 
    // initialiseer het grid 
    for (int row=0; row<6; row++) { 
      for (int column=0; column<7; column++) { 
        // default positie in het grid 
        grid[column][row] = 0; 
      }
    }   
    // speler 1 begint 
    activePlayer = 1; 
  }
  
  int drop(int column) { 
    if (hasWon()) { 
      return -1; 
    }
    
    for (int row =0;row<6;row++){
        if (row<6&&grid[column][row]== 0){
                grid[column][row] = activePlayer; 
    
        activePlayer = (activePlayer%2)+1; 
  
        return row; 
        }
    }
    return -1; 
  }
  
  public String toString() { 
  String returnString = ""; 
  for (int row=5; row>=0; row--) { 
    for (int column=0; column<7; column++) { 
      returnString = returnString + grid[column][row]; 
    }     
    returnString = returnString + "\n"; 
  }    
  return returnString; 
  }
  
  // methode die winnaar aangeeft
  public boolean hasWon() { 
  boolean status = false; 
   
  // check horizontale overwinning 
  for (int row=0; row<6; row++) { 
    for (int column=0; column<4; column++) { 
      if (grid[column][row]!= 0 && grid[column][row] == grid[column+1][row] && grid[column][row] == grid[column+2][row] && grid[column][row] == grid[column+3][row]) { 
        status = true; 
          }        
}      
}


  // check verticale overwinning 
  for (int row=0; row<3; row++) { 
    for (int column=0; column<7; column++) { 
      if (grid[column][row] != 0 && 
          grid[column][row] == grid[column][row+1] && 
          grid[column][row] == grid[column][row+2] && 
          grid[column][row] == grid[column][row+3]) { 
        status = true; 
          }        
}       }    
   
  // check diagonale overwinning 
  for (int row=0; row<3; row++) { 
    for (int column=0; column<4; column++) { 
      if (grid[column][row] != 0 && 
          grid[column][row] == grid[column+1][row+1] && 
          grid[column][row] == grid[column+2][row+2] && 
          grid[column][row] == grid[column+3][row+3]) { 
        status = true; 
          }        
}      
}    
   
  // check diagonale overwinning (andere kant op) 
  for (int row=3; row<6; row++) { 
    for (int column=0; column<4; column++) { 
      if (grid[column][row] != 0 && 
          grid[column][row] == grid[column+1][row-1] && 
          grid[column][row] == grid[column+2][row-2] && 
          grid[column][row] == grid[column+3][row-3]) { 
        status = true; 
          }        
}      
}    
   
  return status; 
}  
}
