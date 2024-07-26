package ozgurp;

import java.util.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class siparis {
    int siparisId;
    int malNo;
    int miktar;
    double fiyat;

    public siparis(int siparisId, int malNo, int miktar, double fiyat) {
        this.siparisId = siparisId;
        this.malNo = malNo;
        this.miktar = miktar;
        this.fiyat = fiyat;
    }

}

public class Main {
    public static void main(String[] args) {
        List<siparis> siparisler = Arrays.asList(
            new siparis(1000, 2000, 12, 100.51),
            new siparis(1000, 2001, 31, 200),
            new siparis(1000, 2002, 22, 150.86),
            new siparis(1000, 2003, 41, 250),
            new siparis(1000, 2004, 55, 244),
            new siparis(1001, 2001, 88, 44.531),
            new siparis(1001, 2002, 121, 88.11),
            new siparis(1001, 2004, 74, 211),
            new siparis(1001, 2002, 14, 88.11),
            new siparis(1002, 2003, 2, 12.1),
            new siparis(1002, 2004, 3, 22.3),
            new siparis(1002, 2003, 8, 12.1),
            new siparis(1002, 2002, 16, 94),
            new siparis(1002, 2005, 9, 44.1),
            new siparis(1002, 2006, 19, 90)
        );

        double toplamTutar = 0.0;

        for (Iterator<siparis> iter = siparisler.iterator(); iter.hasNext(); ) {
            siparis sip = iter.next();
            toplamTutar += (sip.fiyat * sip.miktar);
        }

        // 1.a
        System.out.println("-------1.a-------");
        System.out.println("Tüm malların toplam tutarı: " + toplamTutar);

        // 1.b
        System.out.println("-------1.b-------");
        System.out.println("Tüm malların ortalama fiyatı: " + siparisler.stream().mapToDouble(siparis -> siparis.fiyat).average().getAsDouble());

        double [][]arr = new double[7][3];
        for (Iterator<siparis> iter = siparisler.iterator(); iter.hasNext(); ) {
            siparis sip = iter.next();
            arr[sip.malNo-2000][0] += 1.0;
            arr[sip.malNo-2000][1] += sip.fiyat;
        }

        // 1.c
        System.out.println("-------1.c-------");
        for(int i=0; i<arr.length; i++){
            System.out.println((i+1) + ".malın fiyatı:" + arr[i][1] / arr[i][0]);
        }

        double [][]sipadetleri = new double[3][1];
        for (Iterator<siparis> iter = siparisler.iterator(); iter.hasNext(); ) {
            siparis sip = iter.next();
            sipadetleri[sip.siparisId-1000][0] += sip.miktar;
        }

        // 1.d
        System.out.println("-------1.d-------");
        for(int i=0; i<sipadetleri.length; i++){
            System.out.println(i + ". sipariş için " + sipadetleri[i][0] + " adet mal sipariş edildi.");
        }
    }
}