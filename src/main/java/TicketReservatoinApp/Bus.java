package TicketReservatoinApp;

import java.util.ArrayList;
import java.util.List;

public class Bus {
    //2- plaka - koltuk sayisi - koltuk numaralari : ozellikler, alan field olarak nitelndirilirler

    private String numberPlate;
    private int numberOfSeat;
    private List<String> seats = new ArrayList<>(); // icinde sitring olarak "1","2",....."33"

    // 3- parametreli constructor: otobus objesini olusturdugumda ozellikleri belli olsun - static blokta yapilabilirdi ancak direk olusacagi icin constructur daha mantikli
    public Bus (String plaka, int koltukSayisi){
        this.numberPlate = plaka; //34 TPE 789
        this.numberOfSeat = koltukSayisi;  //33
        for (int i = 1; i <= koltukSayisi; i++) {
            this.seats.add(String.valueOf(i)); // i yi Stringe donusturduk saklayacagimiz yer String oldugu icin
            this.seats.add(i + ""); // bu sekildede i degeri Stringmis gibi seats Listesi Icine kaydolacaktir.

        }
    }


    //getter: degerlerin okunmasini saglar
    public String getNumberPlate() {
        return numberPlate;
    }

    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public List<String> getSeats() {
        return seats;
    }

    //setter: baska class tan deger degistirmek istersem
    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public void setNumberOfSeat(int numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }

    public void setSeats(List<String> seats) {
        this.seats = seats;
    }
}
