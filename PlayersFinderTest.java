package eg.edu.alexu.csd.datastructure.iceHockey.cs;

import java.awt.*;

import static org.junit.Assert.*;

public class PlayersFinderTest {

    @org.junit.Test
    public void findPlayers() {
     PlayersFinder play =  new PlayersFinder();
     //first test
        Point[] players1 = {new Point(4,5),new Point(13,9),new Point(14,2)};
        String[] test1 = {"33JUBU33", "3U3O4433", "O33P44NB", "PO3NSDP3", "VNDSD333", "OINFD33X"};
        assertArrayEquals(play.findPlayers(test1,3,16),players1);
    //second test
        Point[] players2 = {new Point(3,8),new Point(4,16 ),new Point(5,4),new Point(16,3),new Point(16,17),new Point(17,9)};
        String[] test2 ={"44444H44S4", "K444K4L444", "4LJ44T44XH", "444O4VIF44", "44C4D4U444", "4V4Y4KB4M4", "G4W4HP4O4W", "4444ZDQ4S4", "4BR4Y4A444", "4G4V4T4444"};
        assertArrayEquals(play.findPlayers(test2,4,16),players2);
   //third test
        Point[] players3 = {new Point(1,17),new Point(3,3 ),new Point(3,10),new Point(3,25),new Point(5,21),
                new Point(8,17),new Point(9,2),new Point(10,9),new Point(12,23),new Point(17,16),
                new Point(18,3),new Point(18,11),new Point(18,28),new Point(22,20),
                new Point(23,26),new Point(24,15),new Point(27,2),new Point(28,26),new Point(29,16)};
        String[] test3={"8D88888J8L8E888", "88NKMG8N8E8JI88", "888NS8EU88HN8EO", "LUQ888A8TH8OIH8", "888QJ88R8SG88TY", "88ZQV88B88OUZ8O", "FQ88WF8Q8GG88B8", "8S888HGSB8FT8S8", "8MX88D88888T8K8", "8S8A88MGVDG8XK8", "M88S8B8I8M88J8N", "8W88X88ZT8KA8I8", "88SQGB8I8J88W88", "U88H8NI8CZB88B8", "8PK8H8T8888TQR8"};
        assertArrayEquals(play.findPlayers(test3,8,9),players3);
        //fourth test
        Point[] players4 ={new Point(5,5),new Point(5,5)};
        String[] test4 ={"11111", "1AAA1", "1A1A1", "1AAA1", "11111"};
        assertArrayEquals(play.findPlayers(test4,1,3),players4);

      //fifth test
        String[] test5 ={" "};
        assertArrayEquals(play.findPlayers(test5,1,5),null);

    // sixth test
        String[] test6 ={"11111", "1AAA1", "1A1A1", "1AAA1", "11111"};
        assertArrayEquals(play.findPlayers(test6,1,0),null);

        //seventh test
        String[] test7 ={"11111", "1AAA1", "1A1A1", "1AAA1", "11111"};
        assertArrayEquals(play.findPlayers(test7,1,-1),null);

        //eigth test
        String[] test8 = {"JUBU", "UO44", "OP44", "PONS", "LIYG", "OINF"};
       assertArrayEquals(play.findPlayers(test8,3,2),null);

       //ninth test
       String[] test9 = {"33JUBU3a", "3U3O4433", "O33P44NB", "PO3NSDP3", "VNDSD333", "33JUBU3a", "3U3O4433", "O33P44NB", "PO3NSDP3", "VNDSD333", "33JUBU3a", "3U3O4433", "O33P44NB", "PO3NSDP3", "VNDSD333", "33JUBU3a", "3U3O4433", "O33P44NB", "PO3NSDP3", "VNDSD333", "33JUBU3a", "3U3O4433", "O33P44NB", "PO3NSDP3", "VNDSD333", "33JUBU3a", "3U3O4433", "O33P44NB", "PO3NSDP3", "VNDSD333", "33JUBU3a", "3U3O4433", "O33P44NB", "PO3NSDP3", "VNDSD333", "33JUBU3a", "3U3O4433", "O33P44NB", "PO3NSDP3", "VNDSD333", "33JUBU3a", "3U3O4433", "O33P44NB", "PO3NSDP3", "VNDSD333", "33JUBU3a", "3U3O4433", "O33P44NB", "PO3NSDP3", "VNDSD333", "33JUBU3a", "3U3O4433", "O33P44NB", "OINFD33X"};
       assertArrayEquals(play.findPlayers(test9,3,16),null);

     // tenth test
       String[] test10 = {"123456789123456789MLKJHHUHUGGHJGHGFHGFGGFHJGHJGHGHJGHJFGDHGYFRYTRFTY"," GJHUYTLOPO123456789MLKJHHUHUGGHJGHGFHGFGGFHJGHJGHGHJGHJFGDHGYFRYTRFTY"};
       assertArrayEquals(play.findPlayers(test10,3,16),null);

       //eleventh test
        String[] test11 ={"-164787479794987"};
        assertArrayEquals(play.findPlayers(test11,3,16),null);

      //twelth test
        String[] test12 ={" "," "," "};
        assertArrayEquals(play.findPlayers(test12,1,5),null);

        //thirteenth test
        String[] test13 = {"33JUBU33", "3U3O4433", "O33P44NB", "PO3NSDP3", "VNDSD333", "OINFD33X"};
        assertArrayEquals(play.findPlayers(test13,3,16),players1);
    }
}
//////////////////////note in case that one codition isnot agreed i return null to indicate there is error