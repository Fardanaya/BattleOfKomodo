package src.Node.Data;


public class Market {
    int harga;
    String id;
    
    public Market(int harga, String id) {
        this.id = id;
        this.harga = harga;
    }

    public int getHarga() {
        return harga;
    }

    public String getId() {
        return id;
    }
}
