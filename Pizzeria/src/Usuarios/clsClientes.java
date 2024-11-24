/* Elvis Montoya
 * elvisam08@gmail.com  */
package Usuarios;

public class clsClientes extends clsUsuarios{
    
    private int FechaNac;
    
    public clsClientes(){
        this.FechaNac = 0;
        
    }

    public clsClientes(int FechaNac) {
        this.FechaNac = FechaNac;
  
    }

    public clsClientes(String DNI, String Nombre, String Apellidos, String CorreoE, String Direccion, String Telefono, int FechaNac) {
        super(DNI, Nombre, Apellidos, CorreoE, Direccion, Telefono);
        this.FechaNac = FechaNac;
    }


    public int getFechaNac() {
        return FechaNac;
    }

    @Override
    public String toString() {
        return "clsClientes{" + "FechaNac=" + FechaNac + '}';
    }

    public void setFechaNac(int FechaNac) {
        this.FechaNac = FechaNac;
    }
 
          
}
