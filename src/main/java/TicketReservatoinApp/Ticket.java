package TicketReservatoinApp;

public class Ticket {
    //4- mesafe(KM), yolculuk tipi, kkoltuk no, bilet fiyati, otobus

    private double distance;
    private int typeNo; // 1 tek yon - 2 cift yon
    private String seatNo;
    private double price; // fiyat dinamik olarak hesaplanacak
    //composition:bir sınıfın başka bir sınıfın örneğine sahip olmasıdır,
    //HAS-A iliskisi uyguluyoruz
    private Bus bus;// bu bilet hangi otobuse ait oldugunu baglamak icin Bus tipinde tamalandi Bus ozelliklerini kullanacagiz. Baslangic degerinide vermedik

//    public Ticket(double distance, int typeNo, String seatNo, Bus bus){  //bunu kendimiz yaptik Genrate ksimindan otomatik olusturalim
//        this.distance=distance;
//        this.typeNo = typeNo;
//        this.seatNo = seatNo;
//        this.bus =bus;
//    }
    public Ticket(double distance, int typeNo, String seatNo, double price, Bus bus) {
        this.distance = distance;
        this.typeNo = typeNo;
        this.seatNo = seatNo;
        this.price = price;
        this.bus = bus;
    }
    //getter

    public double getDistance() {
        return distance;
    }

    public int getTypeNo() {
        return typeNo;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public double getPrice() {
        return price;
    }

    public Bus getBus() {
        return bus;
    }

    //setter

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setTypeNo(int typeNo) {
        this.typeNo = typeNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }
    //Bilet fiyatini Kurallara Gore Hesaplama Ve Set Edilmeli
    public void setPrice(int age) { // yasa gore indirim alacagim icin yas bilgisini aldim
        //buradaki hesaplamalar sonucunda ancak deger set edlebilir
        //mesafeye gore fiyati hesaplayacagiz
        double total = 0;
        int seatINT = Integer.valueOf(this.seatNo); // seatNo yu int turune degistirdik
        switch (this.typeNo) {// 1 veya 2 gelecek yolculuk tip cift yon mu tek yonmu kontrolunu yapacagiz
            case 1: //tek yon
                if (seatINT %3== 0){ // tekli koltugu tespit ettik
                    total = this.distance*1.2;
            }
                else {
                    total = this.distance*1;
                }
                System.out.println("Toplam Tutar: " + total); // aradegeri gormek icin boyle bir ekrana yadirma islemi yaptik
                break;
            case  2: //cift yon fiyatlandirmasi
                if (seatINT %3== 0){ // tekli koltugu tespit ettik
                    total = this.distance*2.4;
                }
                else {
                    total = this.distance*2;
                }
                System.out.println("Toplam Tutar: " + total); // aradegeri gormek icin boyle bir ekrana yadirma islemi yaptik
                total = total * 0.8; // %20 indirim uyguladik
                System.out.println("Cift Yon Indirimli Hali: " + total);
                break;
        }

        //yas indirimi uygulayalim
        if(age < 12){
            total = total*0.5;
            System.out.println("12 Yas Indirimli Tutar" + total);
        } else if (age > 65) {
            total = total * 0.7;
            System.out.println("65 yas Indirimi" + total);
        }
        this.price = total;

    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }
    //6-bilet dokumunu yazdiralim
    public void printTicket(String name){
        System.out.println("*".repeat(42)); //repeat yazdigin degeri verilen sayi kadar tekrarlar
        System.out.println("--- Bilet Detay ---");
        System.out.println("Sayin " + name);
        System.out.println("Otobus Plakasi: " + this.bus.getNumberPlate());
        System.out.println("Mesafe(KM)    : " + this.distance);
        System.out.println("Yolculuk Tipi : " + (this.typeNo == 1 ? "Tek Yon" : "Cift Yon"));
        System.out.println("Koltuk No     : " + this.seatNo);
        System.out.println("Toplam Tutar  : " + this.price);
        System.out.println("Keyifli Yolculuklar Dileriz...");
        System.out.println("*".repeat(42));

    }
}
