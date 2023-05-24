package laundry3;

import java.util.*;

public class Transaksi extends Laporan {

    private ArrayList<Integer> idJenisLaundry = new ArrayList<Integer>();
    private ArrayList<Integer> banyak = new ArrayList<Integer>();
    private ArrayList<Integer> idClient = new ArrayList<Integer>();
    JenisLaundry jenis = new JenisLaundry();

//    public Transaksi() {
//        this.idClient.add(0);
//        this.idJenisLaundry.add(0);
//        this.banyak.add(2);
//
//        this.idClient.add(0);
//        this.idJenisLaundry.add(1);
//        this.banyak.add(3);
//
//        this.idClient.add(1);
//        this.idJenisLaundry.add(0);
//        this.banyak.add(1);
//
//        this.idClient.add(1);
//        this.idJenisLaundry.add(2);
//        this.banyak.add(2);
//    }
    public void prosesTransaksi(Client client, Transaksi transaksi, JenisLaundry laundry) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Selamat datang di C0in Laundry!");
        laporan(client);

        int i = 0, pilih1 = 0, kiloan = 0, total = 0, saldo = 0, sisa = 0, idClient = 0;
        String konfirmasi;
        ArrayList<Integer> idJenisLaundry = new ArrayList<Integer>();
        ArrayList<Integer> banyak = new ArrayList<Integer>();

        do {
            System.out.print("\nMasukkan ID Member = ");
            idClient = myObj.nextInt();

            if (idClient >= client.getJmlClient() || idClient < 0) {
                System.out.println("Masukkan input yang benar.");
            }
        } while (idClient >= client.getJmlClient() || idClient < 0);

        System.out.println("\nSelamat datang, " + client.getNama(idClient) + "!");

        laporan(laundry);

        int temp = 0;

        do {
            konfirmasi = "";
            do {
                System.out.print("\nMasukkan kode jenis layanan: ");
                pilih1 = myObj.nextInt();
                idJenisLaundry.add(pilih1);

                if (pilih1 >= jenis.getJmlJenisLaundry() || pilih1 < 0) {
                    System.out.println("Masukkan input yang benar.");
                }
            } while (pilih1 >= jenis.getJmlJenisLaundry() || pilih1 < 0);

            do {
                System.out.println("\nBerapa kilo yang akan anda cuci? 5 KG Maksimal");
                kiloan = myObj.nextInt();

                if (kiloan > 5 || kiloan < 1) {
                    System.out.println("Masukkan input yang benar.");
                }
            } while (kiloan > 5 || kiloan < 1);

            //        do {
            //            temp = myObj.nextInt();
            //            if (temp != 99) {
            //                idJenisLaundry.add(temp);
            //                System.out.print(laundry.getJenisLaundry(idJenisLaundry.get(i)) + ""
            //                        + "sebanyak : ");
            //                banyak.add(myObj.nextInt());
            //                i++;
            //            }
            //            System.out.println("Apakah anda ingin menambahkan barang? (Y/N)");
            //            konfirmasi = myObj.next();
            //            if (konfirmasi.equalsIgnoreCase("n")) {
            //                temp = 99;
            //            }
            //        } while (temp != 99);
            total =+ laundry.getHarga(pilih1) * kiloan;
            System.out.println("Total Transaksi belanja " + client.getNama(idClient) + ""
                    + " sebagai beriktt: " + total);

            this.idJenisLaundry.add(pilih1);

            //        int x = idJenisLaundry.size();
            //        for (int j = 0; j < x; j++) {
            //            int jumlah = banyak.get(j) * laundry.getHarga(idJenisLaundry.get(j));
            //            total += jumlah;
            //            System.out.println(laundry.getJenisLaundry(idJenisLaundry.get(j)) + "\t" + idJenisLaundry.get(j) + "\t" + laundry.getHarga(idJenisLaundry.get(j)) + "\t" + jumlah);
            //            transaksi.setTransaksi(laundry, idClient, idJenisLaundry.get(j), banyak.get(j));
            //        }
            if (total > client.getSaldo(idClient)) {
                sisa = total - client.getSaldo(idClient);
                System.out.println("\nSaldo anda kurang mencukupi, silahkan isi saldo anda.");
                System.out.println("Total uang yang anda butuhkan adalah: " + sisa);
                System.out.print("Tulis nominal saldo anda: ");
                do {
                    saldo = myObj.nextInt();

                    if (saldo < sisa || saldo <= 0) {
                        System.out.println("Masukkan input yang benar");
                    }
                    client.editSaldo(idClient, saldo);
                    System.out.println("Terimakasih karena sudah mengisi saldo, semoga harimu bahagia!");
                    System.out.println("Saldo anda sekarang = " + client.getSaldo(idClient));

                } while (saldo < sisa || saldo <= 0);
                
                System.out.println("\n Saldo anda " + (client.getSaldo(idClient) - total));
            }

            System.out.println("Apakah anda ingin melakukan transaksi lagi? [Y/N]");
            konfirmasi = myObj.next();
        } while (konfirmasi.equalsIgnoreCase("y"));

        laporan(transaksi, laundry);

//        System.out.println("Total Belanja : " + total);
//        client.editSaldo(idClient, client.getSaldo(idClient) - total);
    }

    public void setTransaksi(JenisLaundry laundry, int idClient, int idJenisLaundry, int banyaknya) {
        this.idClient.add(idClient);
        this.idJenisLaundry.add(idJenisLaundry);
        this.banyak.add(banyaknya);
        laundry.editDurasi(idJenisLaundry, laundry.getDurasi(idJenisLaundry) - banyaknya);
    }

    public int getIdJenisLaundry(int id) {
        return this.idJenisLaundry.get(id);
    }

    public int getBanyaknya(int id) {
        return this.banyak.get(id);
    }

    public int getIdClient(int id) {
        return this.idClient.get(id);
    }

    public int getJmlTransaksi() {
        return this.idClient.size();
    }
}
