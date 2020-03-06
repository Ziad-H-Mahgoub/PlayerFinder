package eg.edu.alexu.csd.datastructure.iceHockey.cs;

import java.awt.*;

public class PlayersFinder implements IPlayersFinder {
    private  int Maxi;
    private int Maxj;
    private int leastI;
    private int Leastj;
    private int myTherhold;


    @Override
    public java.awt.Point[] findPlayers(String[] photo,int team,int threshold){
        int xLimit = cols(photo);
        int yLimit = rows(photo);
        if (threshold<1||threshold>1000||yLimit>50||xLimit>50){
            return null;
        }
        else {
            int manNumPlayers = 100000;
            Point[] players = new Point[manNumPlayers];
            boolean[][] myArray;
            myArray = changeToSparse(photo, team, xLimit, yLimit);
            int numPlayers = 0;
            int i, j;
            for (i = 0; i < xLimit; i++) {
                for (j = 0; j < yLimit; j++) {
                    Maxj = j;
                    Maxi = i;
                    Leastj = j;
                    leastI = i;
                    myTherhold = 0;
                    findTotalBox(myArray, xLimit, yLimit, i, j);
                    if (myTherhold >= threshold) {
                        players[numPlayers] = new Point();
                        players[numPlayers].setLocation((Maxi + leastI + 1), (Maxj + Leastj + 1));
                        numPlayers++;
                    }
                }
            }
            Point[] outPlayers = new Point[numPlayers];
            mySort(players, numPlayers);
            if (numPlayers == 0)
                return null;
            for (i = 0; i < numPlayers; i++) {
                outPlayers[i] = new Point();
                outPlayers[i].setLocation(players[i]);
            }
            return outPlayers;
        }
    }

    // make array spars array

    boolean[][] changeToSparse(String[] photo, int team, int Xmax, int Ymax) {
        int i,j;
        boolean[][] sparseArray = new boolean[Xmax][Ymax];
        for(i=0;i<Xmax;i++) {
            for(j=0;j<Ymax;j++) {
                sparseArray[i][j]= (Character.getNumericValue(photo[j].charAt(i))) == team;
            }
        }
        return sparseArray;
    }
     //sort the array of points
    void mySort(Point[] players, int noPlayers) {
        int i,j;Point temp = new Point();
        for(i=0;i<noPlayers;i++) {
            for(j=0;j<noPlayers-i-1;j++) {
                if(players[j].getX()>players[j+1].getX()||((players[j].getX()==players[j+1].getX())&&players[j].getY()>players[j+1].getY())) {
                    temp.setLocation(players[j+1]);
                    players[j+1].setLocation(players[j]);
                    players[j].setLocation(temp);
                }
            }
        }
    }

    // remove the box that doesnot fit the threshold
    //array to return the value of indexs
    //check the number of characters in threshold or not

    void findTotalBox(boolean[][] sparesarray, int Xmax, int Ymax, int i, int j){
        if(sparesarray[i][j]) {
            sparesarray[i][j]=false;
            if(i> Maxi)
                Maxi =i;
            else if(j> Maxj)
                Maxj =j;
            else if(j< Leastj)
                Leastj =j;
            else if(i< leastI)
                leastI =i;
            myTherhold +=4;
            if(i+1<Xmax)
                findTotalBox(sparesarray,Xmax,Ymax,i+1,j);
            if(i-1>-1)
                findTotalBox(sparesarray,Xmax,Ymax,i-1,j);
            if(j+1<Ymax)
                findTotalBox(sparesarray,Xmax,Ymax,i,j+1);
            if((j-1)>-1)
                findTotalBox(sparesarray,Xmax,Ymax,i,j-1);
        }
    }

    //calculte number of rows
    public int rows (String[] arr){
        int rows = 0;
        for(int i=0;i<arr.length;i++){
            rows++;
        }
        return rows;
    }

    //calculate number of colums
    public int cols (String[] arr){
        String string = arr[0];
        return string.length();
    }
}
