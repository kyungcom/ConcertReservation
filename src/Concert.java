import java.util.ArrayList;

public class Concert {
    private String concertName;
    private SeatGroup[] seatGroups = new SeatGroup[3];


    public Concert(String concertName, int numOfSeats){ //numOfSeat는 3이상이라고 가정한다.
        this.concertName = concertName;
        seatGroups[0] = new SeatGroup('A', numOfSeats/3);
        seatGroups[1] = new SeatGroup('B', numOfSeats/3);
        seatGroups[2] = new SeatGroup('C', numOfSeats-2*numOfSeats/3);

    }

    public int getGroupIndex(char groupName){
        for (int i = 0; i < seatGroups.length; i++){
            if (seatGroups[i].getGroupName() == groupName){
                return i;
            }
        }
        return -1;
    }

    public void reserve(char groupName, int seatNum){

        int groupIndex = getGroupIndex(groupName);

        if (groupIndex == -1 || seatNum > seatGroups[groupIndex].getNumOfSeats() || seatNum < 0){
            System.out.println("잘못입력하셨습니다.");
            return;
        }
        else{
            seatGroups[groupIndex].reserveSeat(seatNum-1);
        }

    }

    public void cancelReservation(char groupName, int seatNum){
        int groupIndex = getGroupIndex(groupName);

        if (groupIndex == -1 || seatNum > seatGroups[groupIndex].getNumOfSeats() || seatNum < 0){
            System.out.println("잘못입력하셨습니다.");
            return;
        }
        else{
            seatGroups[groupIndex].cancelSeat(seatNum-1);
        }
    }

    public void searchSeats(){

        int maxNumOfSeats = seatGroups[0].getNumOfSeats();
        System.out.print(String.format("%3s"," "));
        for (int i = 0; i < maxNumOfSeats; i++){
            System.out.print(String.format("%3s",i+1+" "));
        }

        System.out.println();

        for(SeatGroup group: seatGroups){
            System.out.print(String.format("%3s",group.getGroupName()+" "));
            char[] seatStatus = group.seatStatus();
            for (int i = 0; i < seatStatus.length; i++){
                System.out.print(String.format("%3s",seatStatus[i]+" "));
            }
            System.out.println();
        }
    }

    public String getConcertName() {
        return concertName;
    }

}
