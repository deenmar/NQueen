public class Queen {

    private int row;
    private int col;
    
    public Queen(int row, int col){
        this.row = row;
        this.col = col;
        
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

   public boolean conflict(Queen current){
       if(this.getRow()==current.getRow()||this.getCol()==current.getCol()||Math.abs(this.getRow())-current.getRow()== Math.abs(this.getCol()-current.getCol())){
           return true;
       }
       else {
           return false;
       }

   }
    @Override
    public String toString() {
        return "row = " + row + " col = " + col;
    }  
}
