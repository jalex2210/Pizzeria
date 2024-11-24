/*
 * @author Luis E. Lopes luislopez73843@correo.itm.edu.co
 */
package Productos;


public class clsProductos {
    private String CodigoPedido;
    private String NombrePizza;
    private int TamanoP;
    private int PrecioPizza;
    private String NombreBebida;
    private int TamanoB;
    private int PrecioBebida;
    private String Adicion;
    private int TamanoAd;
    private int PrecioAd;
 
    
     public clsProductos(){
         this.CodigoPedido = "";
        this.NombrePizza = "";
        this.TamanoP = 0;
        this.NombreBebida = "";
        this.TamanoB = 0;
       this.PrecioBebida = 0;
        this.Adicion = "";
        this.TamanoAd = 0;
       this.PrecioAd = 0;
        

    }

    public clsProductos(String CodigoPedido, String NombrePizza, int TamanoP, int PrecioPizza, String NombreBebida, int TamanoB, int PrecioBebida, String Adicion, int TamanoAd, int PrecioAd) {
        this.CodigoPedido = CodigoPedido;
        this.NombrePizza = NombrePizza;
        this.TamanoP = TamanoP;
        this.PrecioPizza = PrecioPizza;
        this.NombreBebida = NombreBebida;
        this.TamanoB = TamanoB;
        this.PrecioBebida = PrecioBebida;
        this.Adicion = Adicion;
        this.TamanoAd = TamanoAd;
        this.PrecioAd = PrecioAd;
    }

    public String getCodigoPedido() {
        return CodigoPedido;
    }

    public void setCodigoPedido(String CodigoPedido) {
        this.CodigoPedido = CodigoPedido;
    }

    public String getNombrePizza() {
        return NombrePizza;
    }

    public void setNombrePizza(String NombrePizza) {
        this.NombrePizza = NombrePizza;
    }

    public int getTamanoP() {
        return TamanoP;
    }

    public void setTamanoP(int TamanoP) {
        this.TamanoP = TamanoP;
    }

    public int getPrecioPizza() {
        return PrecioPizza;
    }

    public void setPrecioPizza(int PrecioPizza) {
        this.PrecioPizza = PrecioPizza;
    }

    public String getNombreBebida() {
        return NombreBebida;
    }

    public void setNombreBebida(String NombreBebida) {
        this.NombreBebida = NombreBebida;
    }

    public int getTamanoB() {
        return TamanoB;
    }

    public void setTamanoB(int TamanoB) {
        this.TamanoB = TamanoB;
    }

    public int getPrecioBebida() {
        return PrecioBebida;
    }

    public void setPrecioBebida(int PrecioBebida) {
        this.PrecioBebida = PrecioBebida;
    }

    public String getAdicion() {
        return Adicion;
    }

    public void setAdicion(String Adicion) {
        this.Adicion = Adicion;
    }

    public int getTamanoAd() {
        return TamanoAd;
    }

    public void setTamanoAd(int TamanoAd) {
        this.TamanoAd = TamanoAd;
    }

    public int getPrecioAd() {
        return PrecioAd;
    }

    public void setPrecioAd(int PrecioAd) {
        this.PrecioAd = PrecioAd;
    }

}
