/**
 * @author 
 * Johnnatan Benitez  nitez.ing@gmail.com
 * Elvis Montoya  elvisam08@gmail.com
 */
package pizzeria;

import Controladores.clsControladores;
import javax.swing.JOptionPane;


public class Pizzeria {


    public static void main(String[] args) {

        clsControladores objcontroladores = new clsControladores();

        int opcion = 0;
        int opcion1 = 0;
        boolean bandera;

        JOptionPane.showMessageDialog(null, "BIENVENIDOS\nA LA PIZZERIA\nDONPIZZ\n");

        try {
            while (opcion != 8) {

            opcion = Integer.parseInt(JOptionPane.showInputDialog("MENU PRINCIPAL\n"
                    + "1. CLIENTES\n"
                    + "2. EMPLEADOS\n"
                    + "0. SALIR DEL SISTEMA\n"));

            switch (opcion) {
                case 1:
                    bandera = false;

                    while (bandera == false) {
                opcion1 = Integer.parseInt(JOptionPane.showInputDialog(" MENU PRINCIPAL  \n"
                        + "1. AGREGAR CLIENTE/PEDIDO \n"
                        + "2. BUSCAR CLIENTE \n"
                        + "3. BUSCAR PEDIDO \n"
                        + "4. IMPRIMIR PEDIDOS \n"
                        + "5. MODIFICAR CLIENTE \n"
                        + "6. MODIFICAR PEDIDO \n"
                        + "7. CANTIDAD DE PEDIDOS \n"
                        + "8. CANTIDAD DE CLIENTES \n"
                        + "0. VOLVER AL MENU PRINCIPALA\n"));

                switch (opcion1) {
                    case 1:
                        JOptionPane.showMessageDialog(null,
                                objcontroladores.AgregarCliente());
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, objcontroladores.BuscarCliente(
                                JOptionPane.showInputDialog("¿CUÁL ES EL NÚMERO DE CEDULA DEL CLIENTE A BUSCAR?")
                       ));
                        break;
                   
                    case 3:
                        JOptionPane.showMessageDialog(null, objcontroladores.BuscarPedido(
                                JOptionPane.showInputDialog("¿CUÁL ES EL DNI DE EL PEDIDO QUE DESEA BUSCAR?")));
                        break;
                    case 4:
                
                        JOptionPane.showMessageDialog(null, objcontroladores.ImprimirPedido());
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null,objcontroladores.ModificarCliente(
                                JOptionPane.showInputDialog("¿CUÁL ES EL DNI DE EL CLIENTE QUE DESEA MODIFICAR?"),
                                        Integer.parseInt(JOptionPane.showInputDialog(
                                                "ELIJA CUALES DATOS DEL CLIENTE DESEA MODIFICAR:\n"
                                                + "1. NOMBRE DEL CLIENTE\n"
                                                + "2. APELLIDO DE EL CLIENTE\n"
                                                + "3. CORREO ELECTRONICO DEL CLIENTE\n"
                                                + "4. DIRECCION DEL CLIENTE\n"
                                                + "5. TELEFONO DEL CLIENTE\n"
                                                + "6. FECHA DE NACIMIENTO DEL CLIENTE\n\n"))
                        ));
                        break;
                    case 6:
                        JOptionPane.showMessageDialog(null,objcontroladores.ModificarPedido(
                                JOptionPane.showInputDialog("¿CUÁL ES EL DNI DEL PEDIDO QUE DESEA MODIFICAR?"),
                                        Integer.parseInt(JOptionPane.showInputDialog(
                                                "ELIJA CUALES DATOS DEL PEDIDO DESEA MODIFICAR:\n"
                                                + "1. SABOR DE LA PIZZA\n"
                                                + "2. TAMAñO DE LA PIZZA\n"
                                                + "3. MARCA DE LA BEBIDA\n"
                                                + "4. TAMAñO DE LA BEBIDA\n"
                                                + "5. TIPO DE ADICIÓN\n"
                                                + "6. TAMAñO DE LA ADICIÓN\n\n"))
                        ));
                        break;
                    case 7:
                        JOptionPane.showMessageDialog(null,
                                objcontroladores.ContadorPedidos());
                        break;
                    case 8:
                        JOptionPane.showMessageDialog(null,
                                objcontroladores.ContadorCliente());
                        break;
                    case 0:
                        bandera = true;
//                        JOptionPane.showMessageDialog(null, " GRACIAS \n");
//                        System.exit(0);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "OPCION INVALIDA. INTENTELO NUEVAMENTE");
                }

            }
                    
             break;
                case 2:
                    bandera = false;

                    while (bandera == false) {
                        opcion1 = Integer.parseInt(JOptionPane.showInputDialog("MENU EMPLEADOS\n"
                                + "1. AGREGAR EMPLEADOS\n"
                                + "2. ELIMINAR EMPLEADO\n"
                                + "3. MODIFICAR EMPLEADO\n"
                                + "4. BUSCAR EMPLEADO\n"
                                + "5. IMPRIMIR EMPLEADOS\n"
                                + "6. CANTIDAD DE EMPLEADOS\n"
                                + "7. PAGAR NOMINA MENSUAL\n"
                                + "0. VOLVER AL MENU PRINCIPAL\n"));

                        switch (opcion1) {
                            case 1:
                                JOptionPane.showMessageDialog(null,
                                        objcontroladores.AgregarEmpleado());
                                break;
                            case 2:
                                JOptionPane.showMessageDialog(null, objcontroladores.EliminarEmpleado(
                                        JOptionPane.showInputDialog("¿CUÁL ES EL DNI DEL EMPLEADO QUE DESEA ELIMINAR?")
                                ));
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(null, objcontroladores.ModificarEmpleado(
                                        JOptionPane.showInputDialog("¿CUÁL ES EL DNI DEL EMPLEADO QUE DESEA MODIFICAR?"),
                                        Integer.parseInt(JOptionPane.showInputDialog(
                                                "ELIJA CUALES DATOS DEL EMPLEADO DESEA MODIFICAR:\n"
                                                + "1. NOMBRE DE EL EMPLEADO\n"
                                                + "2. APELLIDO DE EL EMPLEADO\n"
                                                + "3. CORREO ELECTRONICO DE EL EMPLEADO\n"
                                                + "4. DIRECCION DE EL EMPLEADO\n"
                                                + "5. TELEFONO DE EL EMPLEADO\n"
                                                + "6. ROL DE EL EMPLEADO\n\n"))
                                ));
                                break;
                            case 4:
                                JOptionPane.showMessageDialog(null, objcontroladores.BuscarEmpleado(
                                        JOptionPane.showInputDialog("¿CUÁL ES EL DNI DEL EMPLEADO QUE DESEA BUSCAR?")));
                                break;
                            case 5:
                                JOptionPane.showMessageDialog(null,
                                        objcontroladores.ImprimirEmpleado());
                                break;
                            case 6:
                                JOptionPane.showMessageDialog(null,
                                        objcontroladores.ContadorEmpleado());
                                break;
                                 case 7:
                                JOptionPane.showMessageDialog(null,
                                objcontroladores.PAGAR_NOMINA());
                                break;
                            case 0:
                                bandera = true;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "OPCION INVALIDA. INTENTELO NUEVAMENTE");
                        }
                    }

                    break;

                
                case 0:
                    JOptionPane.showMessageDialog(null, "GRACIAS, HASTA PRONTO\n");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "OPCION INVALIDA. INTENTELO NUEVAMENTE");
            }

        }
                    
        } catch (Exception e) {

            // RETORNAMOS EL ERROR
            JOptionPane.showMessageDialog(null, "ERROR EN EL MENU PRINCIPAL: " + e.getMessage());
        }
    }

}