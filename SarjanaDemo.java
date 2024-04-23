class Orang {
    private String nama;
    private String alamat;

    public Orang() {}

    public Orang(String nama, String alamat) {
        this.nama = nama;
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void display() {
        System.out.println("Nama = " + nama);
        System.out.println("Alamat = " + alamat);
    }
}

class Murid extends Orang {
    private int noInduk;

    public Murid() {}

    public Murid(String nama, String alamat, int noInduk) {
        super(nama, alamat);
        this.noInduk = noInduk;
    }

    public int getNoInduk() {
        return noInduk;
    }

    public void setNoInduk(int noInduk) {
        this.noInduk = noInduk;
    }

    public void cetak() {
        super.display();
        System.out.println("No.Induk = " + noInduk);
    }
}

class Sarjana extends Murid {
    private double ipk;

    public Sarjana() {}

    public Sarjana(String nama, String alamat, int nim, double ipk) {
        super(nama, alamat, nim);
        this.ipk = ipk;
    }

    public double getIpk() {
        return ipk;
    }

    public void setIpk(double ipk) {
        if (ipk >= 0.0 && ipk <= 4.0) {
            this.ipk = ipk;
        } else {
            System.out.println("Invalid IPK value.");
        }
    }

    public void reset(String nama, String alamat, int nim, double ipk) {
        super.setNama(nama);
        super.setAlamat(alamat);
        super.setNoInduk(nim);
        setIpk(ipk);
    }

    public String predikat(double ipk) {
        if (ipk >= 2.0 && ipk <= 2.75) {
            return "Memuaskan";
        } else if (ipk >= 2.76 && ipk <= 3.5) {
            return "Sangat memuaskan";
        } else if (ipk >= 3.51 && ipk <= 4.0) {
            return "Dengan pujian";
        } else {
            return "-";
        }
    }

    public void cetak() {
        super.cetak();
        System.out.println("IPK = " + ipk);
        System.out.println("Predikat = " + predikat(ipk));
    }
}

public class SarjanaDemo {
    public static boolean isAlamatSama(Sarjana a1, Sarjana a2) {
        return a1.getAlamat().toLowerCase().equals(a2.getAlamat().toLowerCase());
    }

    public static double min2(double a, double b) {
        return Math.min(a, b);
    }

    public static void main(String[] args) {
        Sarjana s[] = new Sarjana[3];
        s[0] = new Sarjana("Dilan", "Bandung", 1, 3.51);
        s[1] = new Sarjana("Milea", "Jakarta", 2, 3.0);
        s[2] = new Sarjana();
        s[2].reset("Cinta", "Bandung", 3, 1.75);

        for (int i = 0; i < s.length; i++) {
            s[i].cetak();
            System.out.println("");
        }

        System.out.print("Alamat Dilan dan Cinta ");
        if (isAlamatSama(s[0], s[2])) {
            System.out.println("sama");
        } else {
            System.out.println("tidak sama");
        }

        double smallestIpk = min2(min2(s[0].getIpk(), s[1].getIpk()), s[2].getIpk());
        if (s[0].getIpk() == smallestIpk) {
            System.out.println("IPK terkecil adalah " + s[0].getIpk() + " milik " + s[0].getNama());
        } else if (s[1].getIpk() == smallestIpk) {
            System.out.println("IPK terkecil adalah " + s[1].getIpk() + " milik " + s[1].getNama());
        } else {
            System.out.println("IPK terkecil adalah " + s[2].getIpk() + " milik " + s[2].getNama());
        }
    }
}
