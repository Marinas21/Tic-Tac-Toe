import java.util.ArrayList;
import java.util.Collections;

// this class is the multy-player game between two players
public class MultiPlayer implements  Game{

    ArrayList<Integer> playerI=new ArrayList<>();
    ArrayList<Integer> playerII=new ArrayList<>();
    ArrayList<Integer> gameBord=new ArrayList<>();
    // all the possible commbinations for row, collumn and diagonals
    int[][] row={{1,2,3},{4,5,6},{7,8,9}};
    int[][] collumn={{1,4,7},{2,5,8},{3,6,9}};
    int[][] diagonal={{1,5,9},{3,5,7}};
    //this method is the main logic for write the X or 0 in the container or check if a player won or it's a tie
    @Override
    public String play(int index, int id) {
        //the returned value;
        String answer;
        //check if someone allready click on this space
        if(gameBord.contains(id)){
            return "is taken";
        }
        else{
            gameBord.add(id);
        }

        if(index==1){
            playerI.add(id);

            if(playerI.size()>=3){
                for(int i=0;i<3;i++){
                    if (playerI.contains(row[i][1])&&playerI.contains(row[i][0])&&playerI.contains(row[i][2])){
                        return "won";
                    }
                    else if (playerI.contains(collumn[i][1])&&playerI.contains(collumn[i][0])&&playerI.contains(collumn[i][2])){
                        return "won";
                    }
                    else if(i<2){
                        if (playerI.contains(diagonal[i][1])&&playerI.contains(diagonal[i][0])&&playerI.contains(diagonal[i][2])){
                        return "won";
                    }
                    }
                }
            }
            answer= "X";
        }
        else{
            playerII.add(id);
            Collections.sort(playerII);
            if(playerII.size()>=3){
                for(int i=0;i<3;i++){
                    if (playerII.contains(row[i][1])&&playerII.contains(row[i][0])&&playerII.contains(row[i][2])){
                        return "won";
                    }
                    else if (playerII.contains(collumn[i][1])&&playerII.contains(collumn[i][0])&&playerII.contains(collumn[i][2])){
                        return "won";
                    }
                    else if(i<2){
                        if (playerII.contains(diagonal[i][1])&&playerII.contains(diagonal[i][0])&&playerII.contains(diagonal[i][2])){
                            return "won";
                        }
                    }
                }
            }
            answer= "0";
        }
        if(gameBord.size()==9){
            answer="tie";
        }
        return answer;
    }
}
