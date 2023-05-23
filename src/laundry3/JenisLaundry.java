package laundry3;

import java.util.ArrayList;

public class JenisLaundry {

    private ArrayList<String> jenisLaundry = new ArrayList<String>();
    private ArrayList<Integer> durasi = new ArrayList<Integer>();
    private ArrayList<Integer> harga = new ArrayList<Integer>();

    public JenisLaundry() {

        this.jenisLaundry.add("Laundry Standar");
        this.durasi.add(30);
        this.harga.add(5000);

        this.jenisLaundry.add("Dry Clean");
        this.durasi.add(30);
        this.harga.add(5500);
        
        this.jenisLaundry.add("Self Service");
        this.durasi.add(20);
        this.harga.add(6000);
        
        this.jenisLaundry.add("On Demand");
        this.durasi.add(20);
        this.harga.add(6500);
    }

    public int getJmlJenisLaundry() {
        return this.jenisLaundry.size();
    }

    public void setJenisLaundry(String jenisLaundry) {
        this.jenisLaundry.add(jenisLaundry);
    }

    public String getJenisLaundry(int idJenisLaundry) {
        return this.jenisLaundry.get(idJenisLaundry);
    }

    public void setDurasi(int durasi) {
        this.durasi.add(durasi);
    }

    public int getDurasi(int idJenisLaundry) {
        return this.durasi.get(idJenisLaundry);
    }

    public void editDurasi(int idJenisLaundry, int durasi) {
        this.durasi.set(idJenisLaundry, durasi);
    }

    public void setHarga(int harga) {
        this.harga.add(harga);
    }

    public int getHarga(int idJenisLaundry) {
        return this.harga.get(idJenisLaundry);
    }
}
