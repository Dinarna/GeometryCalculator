public class App {
  /**
 * Kelas GeometryCalculator menyediakan metode untuk menghitung luas dan keliling
 * dari berbagai bangun datar seperti persegi, persegi panjang, dan lingkaran.
 */
public class GeometryCalculator {

    /**
     * Menghitung luas persegi.
     *
     * @param sisi panjang sisi persegi
     * @return luas persegi
     */
    public double hitungLuasPersegi(double sisi) {
        return sisi * sisi; // Menghitung luas persegi
    }

    /**
     * Menghitung keliling persegi.
     *
     * @param sisi panjang sisi persegi
     * @return keliling persegi
     */
    public double hitungKelilingPersegi(double sisi) {
        return 4 * sisi; // Menghitung keliling persegi
    }

    // Contoh peringatan penggunaan
    /**
     * Menghitung luas lingkaran. Pastikan jari-jari positif.
     *
     * @param jariJari jari-jari lingkaran
     * @return luas lingkaran
     */
    public double hitungLuasLingkaran(double jariJari) {
        return Math.PI * jariJari * jariJari; 
    }
}

}
