/*
 * @author Johnnatan Benitez  Nitez.ing@gmail.com
 */
package Usuarios;

public class clsEmpleados extends clsUsuarios{
    private String Rol;
    private int CantHTM;
    private int ValorHora;
    
    
    public clsEmpleados(){
        this.Rol = "";
        this.CantHTM = 0;
        this.ValorHora = 0;
        
    }

    public clsEmpleados(String Rol, int CantHTM, int ValorHora) {
        this.Rol = Rol;
        this.CantHTM = CantHTM;
        this.ValorHora = ValorHora;
        
    }

    public clsEmpleados(String DNI, String Nombre, String Apellidos, String CorreoE, String Direccion, String Telefono, String Rol, int CantHTM, int ValorHora) {
        super(DNI, Nombre, Apellidos, CorreoE, Direccion, Telefono);
        this.Rol = Rol;
        this.CantHTM = CantHTM;
        this.ValorHora = ValorHora;
        
    }

    public int getCantHTM() {
        return CantHTM;
    }

    public void setCantHTM(int CantHTM) {
        this.CantHTM = CantHTM;
    }

    public int getValorHora() {
        return ValorHora;
    }

    public void setValorHora(int ValorHora) {
        this.ValorHora = ValorHora;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

    @Override
    public String toString() {
        return "clsEmpleados{" + "CantHTM=" + CantHTM + ", ValorHora=" + ValorHora + ", Rol=" + Rol + '}';
    }
   
}