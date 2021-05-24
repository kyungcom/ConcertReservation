public class SeatGroup {
    private char groupName;
    private Seat seats[];


    public SeatGroup(char groupName, int numOfSeats){
        this.groupName = groupName;
        this.seats = new Seat[numOfSeats];

        for (int i = 0; i < numOfSeats; i++){
            seats[i] = new Seat(i, false);
        }
    }

    public void reserveSeat(int seatNum){
        if (seats[seatNum].isReserved()){
            System.out.println("이미 예약된 좌석입니다.");
        } else {
            System.out.println("예약되었습니다.");
            seats[seatNum].setReserved(true);
        }
    }

    public void cancelSeat(int seatNum){
        if (!seats[seatNum].isReserved()){
            System.out.println("비어있는 좌석 입니다.");
        } else {
            System.out.println("예약 취소 되었습니다.");
            seats[seatNum].setReserved(false);
        }
    }

    public char[] seatStatus(){
        char[] seatStatus = new char[getNumOfSeats()];

        for (int i = 0; i < getNumOfSeats(); i++){
            if (seats[i].isReserved()){
              seatStatus[i] = 'O';
            } else {
              seatStatus[i] = 'X';
            }
        }

        return seatStatus;
    }

    public int getNumOfSeats(){
        return seats.length;
    }

    public char getGroupName(){
        return groupName;
    }
}
