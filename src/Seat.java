public class Seat {
    private int seatNum;
    private boolean reserved;

    public Seat() {
        seatNum = -1;
        reserved = false;
    }



    public Seat(int _seatNum, boolean _reserved) {
        this.seatNum = _seatNum;
        this.reserved = _reserved;
    }


    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean _reserved) {
        this.reserved = _reserved;
    }


}
