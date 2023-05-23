package laundry3;

public class Run {

    public static void main(String[] args) {
        Client client = new Client();
        JenisLaundry laundry = new JenisLaundry();
        Laporan laporan = new Laporan();
        Petugas petugas = new Petugas();
        Transaksi transaksi = new Transaksi();
        
        transaksi.prosesTransaksi(client, transaksi, laundry);
        
    }
    
}
