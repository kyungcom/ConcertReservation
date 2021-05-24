import java.util.Scanner;

public class ConcertReservation {
    private Concert[] concerts = new Concert[4];
    private Scanner sc=new Scanner(System.in);

    public ConcertReservation(){
        concerts[0]=new Concert("맘마미아", 18);
        concerts[1]=new Concert("발레리노", 15);
        concerts[2]=new Concert("백엔드 개발자의 인생", 21);
        concerts[3]=new Concert("재밌는 자바",51);
    }

    public int findConcertIndex(String ConcertName){
        int indexConcert = -1;

        for (int i = 0; i < concerts.length; i++){
            if (concerts[i].getConcertName().equals(ConcertName)) {
                indexConcert = i;
            }
        }

        return indexConcert;
    }

    public void reservation(){
        System.out.println("예악을 원하는 콘서트 이름을 입력해주세요:");
        String inputConcertName = sc.nextLine();

        int indexConcert = findConcertIndex(inputConcertName);

        if (indexConcert == -1){
            System.out.println("잘못입력하셨습니다.");
        }
        else {
            concerts[indexConcert].searchSeats();
            System.out.println("예약을 원하시는 좌석의 알파벳과 숫자를 입력하세요(예:C10)");
            String inputSeat = sc.nextLine();
            char inputGroupName = inputSeat.charAt(0);
            int inputNumOfSeat = Integer.parseInt(inputSeat.substring(1));


            concerts[indexConcert].reserve(inputGroupName, inputNumOfSeat);

        }
    }

    public void search(){
        for (Concert concert : concerts){
            System.out.println(concert.getConcertName());
            concert.searchSeats();
            System.out.println();
        }
    }

    public void cancelReservation(){
        System.out.println("예악 취소를 원하는 콘서트 이름을 입력해주세요:");
        String inputConcertName = sc.nextLine();

        int indexConcert = findConcertIndex(inputConcertName);

        if (indexConcert == -1){
            System.out.println("잘못입력하셨습니다.");
        } else {
            concerts[indexConcert].searchSeats();
            System.out.println("예약 취소 원하시는 좌석의 알파벳과 숫자를 입력하세요");
            String inputSeat = sc.nextLine();
            char inputGroupName = inputSeat.charAt(0);
            int inputNumOfSeat = Integer.parseInt(inputSeat.substring(1));

            concerts[indexConcert].cancelReservation(inputGroupName, inputNumOfSeat);
        }
    }

    public void run(){
        System.out.println("콘서스 예약 시스템입니다.");

        while (true) {
            System.out.println("숫자를 입력해주세요 (1: 예약, 2:조회, 3:취소, 4:종료):");
            int num = Integer.parseInt(sc.nextLine());
            if (num == 1) {
                reservation();
            }
            else if (num == 2) {
                search();
            }
            else if (num == 3) {
                cancelReservation();
            }
            else if (num == 4) {
                break;
            }
            else {
                System.out.println("잘못입력하셨습니다.");
            }
        }
    }


}
