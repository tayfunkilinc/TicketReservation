package TicketReservatoinApp;

import java.util.Scanner;

/*
Project: Bilet Rezervasyon ve Bilet Fiyatı Hesaplama Uygulaması

    1- Uygulama mesafe ve kurallara göre otobüs bileti fiyatı hesaplar sonuç olarak bilet bilgisini verir
    2- Kullanıcıdan     mesafe (KM),
                        yolcu adı, yaşı ,
                        yolculuk tipi (Tek Yön, Gidiş-Dönüş)
                        ve koltuk no bilgilerini alınır.
             NOT: Koltuk numaraları her otobüs için dinamik olmalıdır.)
                  Kullanıcıdan alınan değerler geçerli (mesafe ve yaş değerleri pozitif sayı, yolculuk tipi ise 1 veya 2) olmalıdır.
                  Aksi halde kullanıcıya "Hatalı Veri Girdiniz !" şeklinde bir uyarı verilmelidir.

    3-Fiyat hesaplama kuralları:
       -Mesafe başına ücret:
                  Tek yön: 1 Lira / km       Çift Yön(Gidiş-Dönüş): 2 Lira/km
       -Tekli Koltuk ücreti:
                  Koltuk no 3 veya 3 ün katı ise fiyat %20 daha fazladır(Tek yön: 1.2 Lira/km, Çift Yön:2.4 Lira/km).
       -İlk olarak seferin mesafe, yön ve koltuk no bilgisine göre fiyatı hesaplanır,
        sonrasında koşullara göre aşağıdaki indirimler uygulanır ;
                   i)-Çift Yön indirimi:
                               "Yolculuk Tipi" gidiş dönüş seçilmiş ise son bilet fiyatı üzerinden %20 indirim uygulanır.
                   ii)-Yaş indirimi:
                                Kişi 12 yaşından küçükse son bilet fiyatı üzerinden %50 indirim uygulanır.
                                Kişi 65 yaşından büyük ise son bilet fiyatı üzerinden %30 indirim uygulanır.

 */
public class TickketReservationApp {
    public static void main(String[] args) {
        start(); // static methodlar normalde class ismi ile cagrilir fakat ayni class icindeyseniz class ismine gerek kalmaz


    }

    private static void start() {
        // 1- bilet ve otobus objelerini olusturalim.
        Bus bus = new Bus("34 TPE 789", 33);
        Ticket ticket; // parametreli bir constructor olusturdugumuz icin buda degerini set edemedim degerleri ayarladiktan sonra set edecegiz

        Scanner input = new Scanner(System.in);
        int select; // kulanici secimi kullanici 0 a basarsa cikis yaptiracagiz
        do {
            //kullanicidan bilgileri alalim
            System.out.println("Bilet Rezervasyon Sistemine Hos Geldiniz");

            System.out.println("Lutfen ad-soyad giriniz: ");
            String name = input.nextLine();

            System.out.println("Lutfen Yasinizi Giriniz: ");
            int age = input.nextInt();

            System.out.println("Lutfen gidilecek Mesafeyi(KM) Giriniz: ");
            double km = input.nextDouble();

            System.out.println("Yolculuk Tipini Seciniz: ");
            System.out.println("1-Tek Yon");
            System.out.println("2-Gidis - Donus");
            int type = input.nextInt();
            input.nextLine();  //burda bosta kalan \n karakteri bir sonraki next() methodunun veri okumasina engel olacagi icin bunu burda calistirdik
            // next int methodu \n  i okumaz bir daha veri alsan okumaz hata olusun bu sebeple

            System.out.println("Lutfen Koltuk No Giriniz: ");
            System.out.println("Tekli Koltuk Ucreti %20 Daha Fazladir!");
            System.out.println(bus.getSeats());
            String seat = input.next();

            //koltuk no rezerve edilmis mi veya listede var mi
            boolean isReserved = !bus.getSeats().contains(seat);  //contains obje alir icerisinde var mi yok mu diye kontrol yapar
            //True ise listede yoktur veya bu koltuk otobuste yok  --- dikkat et degilini aldik


            // Girilen Degerler Gecerlimi
            if(km> 0 && age>0 && (type == 1 || type ==2) && !isReserved){
                // todo: bileti hazirlama islemi yapacagiz..... devami gelecek // todo ile gunluk nerde kaldiginizi planlayabilrisiniz
            }else {
                if(isReserved){
                    System.out.println("Secilen Koltuk MEvcut degil Rezerve Edilmis Olabilri");
                }else {
                    System.out.println("Sayin " + name + " hatali kiris yaptiniz");
                }
            }
            System.out.println("Yeni Islem Icin herhangi Bir Sayi Giriniz: ");
            select = input.nextInt();
            input.nextInt(); // dongu basa donunce ekrandan yazi okunurken sorun olmasin diye DAMI kullaniyoruz

        }while (select != 0);
        System.out.println("Iyi Gunler Dileriz Yeniden Bekleriz");
    }

}
