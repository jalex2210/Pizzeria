/* Elvis Montoya  elvisam08@gmail.com  */
/* Johnnatan Benitez  nitez.ing@gmail.com  */
/* Luis E. Lopes luislopez73843@correo.itm.edu.co*/

package Controladores;

import Usuarios.clsClientes;
import Productos.clsProductos;
import Usuarios.clsEmpleados;
import Cola.Cola;
import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class clsControladores {

    clsClientes objClientes;
    clsProductos objProductos;
    clsEmpleados ObjEmpleado;
    Cola<clsClientes> colaClientes;
    Cola<clsClientes> colaClienteAux;
    Cola<clsProductos> colaProductos;
    Cola<clsProductos> colaProductosAux;
    Cola<clsEmpleados> colaempleado;
    Cola<clsEmpleados> auxempleado;
    String cadena = "", dni;
    int contClientes = 0;
    int contPedidos = 0;
    int contempleado = 0;
    private int Pizza;
    private int Bebida, Rol;
    private int Adicion;
    private int Precio;
    private int Preciob;
    private int PrecioA;
    boolean Banderita;

    public clsControladores() {
        objClientes = new clsClientes();
        objProductos = new clsProductos();
        ObjEmpleado = new clsEmpleados();
        colaClientes = new Cola();
        colaClienteAux = new Cola();
        colaProductos = new Cola();
        colaProductosAux = new Cola();
        colaempleado = new Cola();
        auxempleado = new Cola();
        cadena = "";
        contClientes = 0;
        contPedidos = 0;
        contempleado = 0;
        Banderita = false;
    }

//METODO PARA AGREGAR CLIENTE
    public String AgregarCliente() {
        try {
            while (JOptionPane.showConfirmDialog(null, "¿Desea agregar un Cliente?") == JOptionPane.YES_OPTION) {

                String nuevoDNI = Validar_Cedula();

                if (!existeCedula(nuevoDNI)) {
                    String nombre = Validar_Nombre();
                    String apellido = Validar_Apellido();
                    String nuevoCorreo = Validar_Correo();
                    String nuevaDireccion = JOptionPane.showInputDialog("Ingrese la direccion de la Residencia");
                    String nuevoTelefono = JOptionPane.showInputDialog("Ingrese el teléfono de contacto");
                    int fechaNacimiento = Validar_Fecha();
                    AgregarPedido();

                    colaClientes.Encolar(new clsClientes(
                            nuevoDNI,
                            nombre,
                            apellido,
                            nuevoCorreo,
                            nuevaDireccion,
                            nuevoTelefono,
                            fechaNacimiento
                    ));
                    contClientes++;
                } else {
                    JOptionPane.showMessageDialog(null, "Ya existe un cliente registrado con este DNI");
                }
            }
            // CUANDO FINALIZA DE AGREGAR MUESTRA EL MENSAJE DE EXITO, CON EL CONTADOR DE CLIENTES GLOBAL
            cadena = "Clientes registrados con éxito, fueron un total de " + contClientes;

            // RETORNAMOS EL ERROR
            return cadena;

        } catch (HeadlessException e) {
            // CAPTURAMOS EL ERROR DEL PROCESO Y LO ASIGNAMOS A CADENA
            cadena = "Error al agregar clientes en la COLA: " + e.getMessage();

            // RETORNAMOS EL ERROR
            return cadena;
        }

    }
    
//METODO PARA AGREGAR PEDIDO
    public String AgregarPedido() {
        try {
            while (JOptionPane.showConfirmDialog(null, "¿Desea agregar un Pedido?") == JOptionPane.YES_OPTION) {

                String nuevoDNI = Validar_Pedido();

                if (!existePedido(nuevoDNI)) {
                    String nuevapizza = Validar_Pizza();
                    int nuevotamano = METODO_ESCOGER_TAMANO();
                    int nuevoprecio = Precio;
                    String nuevabebida = Validar_Bebida();
                    int nuevotamanob = METODO_ESCOGER_TAMANOB();
                    int nuevopreciob = Preciob;
                    String nuevaadicion = Validar_Adicion();
                    int nuevoescogeradicion = METODO_ESCOGER_ADICION();
                    int nuevoprecioAd = PrecioA;

                    colaProductos.Encolar(new clsProductos(
                            nuevoDNI,
                            nuevapizza,
                            nuevotamano,
                            nuevoprecio,
                            nuevabebida,
                            nuevotamanob,
                            nuevopreciob,
                            nuevaadicion,
                            nuevoescogeradicion,
                            nuevoprecioAd
                    ));
                    contPedidos++;
                } else {
                    JOptionPane.showMessageDialog(null, "Ya existe un pedido registrado con este DNI");
                }
            }
            // CUANDO FINALIZA DE AGREGAR MUESTRA EL MENSAJE DE EXITO, CON EL CONTADOR DE CLIENTES GLOBAL
            cadena = "Pedido registrado con éxito, fueron un total de " + contPedidos;

            // RETORNAMOS EL ERROR
            return cadena;

        } catch (HeadlessException e) {
            // CAPTURAMOS EL ERROR DEL PROCESO Y LO ASIGNAMOS A CADENA
            cadena = "Error al agregar pedidos en la COLA: " + e.getMessage();

            // RETORNAMOS EL ERROR
            return cadena;
        }

    }
    

//METODO PARA MODIFICAR CLIENTE
    public String ModificarCliente(String IDCliente, int opc) {
        boolean banderita = false;
        String datoen = "";
        cadena = "";

        try {
            while (!colaClientes.EstaVacia()) {
                clsClientes objCliente;
                objCliente = colaClientes.getElementos();

                if (objCliente.getDNI().equalsIgnoreCase(IDCliente)) {
                    banderita = true;
                    switch (opc) {
                        case 1:
                            objCliente.setNombre(Validar_Nombre());
                            cadena = "Nombre modificado con éxito";
                            break;
                        case 2:
                            objCliente.setApellidos(Validar_Apellido());
                            cadena = "Apellido modificado con éxito";
                            break;
                        case 3:
                            objCliente.setCorreoE(Validar_Correo());
                            cadena = "Correo modificado con éxito";
                            break;
                        case 4:
                            objCliente.setDireccion(JOptionPane.showInputDialog("Ingrese la nueva direccion de la casa"));
                            cadena = "Direccion de la Residencia modificada con éxito";
                            break;
                        case 5:
                            objCliente.setTelefono(JOptionPane.showInputDialog("Ingrese el teléfono del Cliente"));
                            cadena = "Teléfono modificado con éxito";
                            break;
                        case 6:
                            objCliente.setFechaNac(Validar_Fecha());
                            cadena = "Fecha de Nacimiento modificada con éxito";
                            break;
                        default:
                            cadena = "Saliendo de modificar";
                            break;  // Agregar un break aquí para terminar el switch
                    }
                }

                colaClienteAux.Encolar(new clsClientes(
                        objCliente.getDNI(),
                        objCliente.getNombre(),
                        objCliente.getApellidos(),
                        objCliente.getCorreoE(),
                        objCliente.getDireccion(),
                        objCliente.getTelefono(),
                        objCliente.getFechaNac()
                        
                ));

                colaClientes.Desencolar();
            }

            if (banderita) {
                datoen = "Cliente Modificado!!!\n\n";
            } else {
                // El ID del Cliente no fue encontrado, ofrecer la opción de volver a intentar.
                int respuesta = JOptionPane.showConfirmDialog(null, "El ID del Cliente no fue encontrado. ¿Desea intentar de nuevo?", "ID no encontrado", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    return "Volver a intentar la modificación del Cliente.";
                }
                cadena = "El ID del Cliente no fue encontrado.";
            }
        } catch (Exception e) {
            // CAPTURAMOS EL ERROR DEL PROCESO Y LO ASIGNAMOS A CADENA
            cadena = "Error al insertar clientes en la COLA: " + e.getMessage();
            // RETORNAMOS EL ERROR
            return cadena;
        }
        returnColaClientes(colaClienteAux);
        return datoen + cadena;
    }
    
//METODO PARA MODIFICAR PEDIDO
    public String ModificarPedido(String IDProductos, int opc) {
        boolean banderita = false;
        String datoen = "";
        cadena = "";

        try {
            while (!colaProductos.EstaVacia()) {
                clsProductos objProductos;
                objProductos = colaProductos.getElementos();

                if (objProductos.getCodigoPedido().equalsIgnoreCase(IDProductos)) {
                    banderita = true;
                    switch (opc) {
                        case 1:
                            objProductos.setNombrePizza(Validar_Pizza());
                            cadena = "Pizza modificada con éxito";
                            break;
                        case 2:
                            objProductos.setTamanoP(METODO_ESCOGER_TAMANO());
                            cadena = "Tamaño de pizza modificado con éxito";
                            break;
                        case 3:
                            objProductos.setNombreBebida(Validar_Bebida());
                            cadena = "Bebida modificada con éxito";
                            break;
                        case 4:
                            objProductos.setTamanoB(METODO_ESCOGER_TAMANOB());
                            cadena = "Tamaño Bebida modificada con éxito";
                            break;
                        case 5:
                            objProductos.setAdicion(Validar_Adicion());
                            cadena = "Adición modificada con éxito";
                            break;
                        case 6:
                            objProductos.setTamanoAd(METODO_ESCOGER_ADICION());
                            cadena = "Tamaño Adición modificada con éxito";
                            break;
                        
                        default:
                            cadena = "Saliendo de modificar Pedido";
                            break;  // Agregar un break aquí para terminar el switch
                    }
                }
    

                colaProductosAux.Encolar(new clsProductos(
                        objProductos.getCodigoPedido(),
                        objProductos.getNombrePizza(),
                        objProductos.getTamanoP(),
                        objProductos.getPrecioPizza(),
                        objProductos.getNombreBebida(),
                        objProductos.getTamanoB(),
                        objProductos.getPrecioBebida(),
                        objProductos.getAdicion(),
                        objProductos.getTamanoAd(),
                        objProductos.getPrecioAd()
                        
                ));

                colaProductos.Desencolar();
            }

            if (banderita) {
                datoen = "Pedido Modificado!!!\n\n";
            } else {
                // El ID del Cliente no fue encontrado, ofrecer la opción de volver a intentar.
                int respuesta = JOptionPane.showConfirmDialog(null, "El Pedido no fue encontrado. ¿Desea intentar de nuevo?", "ID no encontrado", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    return "Volver a intentar la modificación del Pedido.";
                }
                cadena = "El ID del Pedido no fue encontrado.";
            }
        } catch (Exception e) {
            // CAPTURAMOS EL ERROR DEL PROCESO Y LO ASIGNAMOS A CADENA
            cadena = "Error al insertar Pedidos en la COLA: " + e.getMessage();
            // RETORNAMOS EL ERROR
            return cadena;
        }
        returnColaProductos(colaProductosAux);
        return datoen + cadena;
    }

//MENU QUE MUESTRA PARA LA OPCION A MODIFICAR
    public static int menuSeleccionarOpcionModificar() {
        String[] opciones = {
            "1. Modificar Nombre del Cliente",
            "2. Modificar Apellido del Cliente",
            "3. Modificar Correo del Cliente",
            "4. Modificar Direccion de la Casa",
            "5. Modificar Telefono del Cliente",
            "6. Modificar Fecha de Nacimiento",
            "0. Atras"
        };
        int seleccion;

        do {
            String input = JOptionPane.showInputDialog("Selecciona el numero:\n" + String.join("\n", opciones));
            try {
                seleccion = Integer.parseInt(input);
                if (seleccion < 0 || seleccion > opciones.length - 1) {
                    JOptionPane.showMessageDialog(null, "Por favor, elige una opción válida.");
                } else {
                    return seleccion;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error seleccione una opcion valida");
            }
        } while (true);
    }

//METODO PARA BUSCAR CLIENTE DNI
    public String BuscarCliente(String IDCliente) {
        boolean ClienteEncontrado = false;
        String resultado = "";
        Cola<clsClientes> auxCola = new Cola<>();

        while (!colaClientes.EstaVacia()) {
            clsClientes ClienteActual = colaClientes.getElementos();

            if (ClienteActual.getDNI().equalsIgnoreCase(IDCliente)) {
                ClienteEncontrado = true;
                // Imprimir la información del primer Cliente
                resultado += "INFORMACIÓN DEL CLIENTE:\n"
                        + "DNI del cliente: " + ClienteActual.getDNI() + "\n"
                        + "Nombres " + ClienteActual.getNombre() + "\n"
                        + "Apellidos: " + ClienteActual.getApellidos() + "\n"
                        + "Correo Electronico: " + ClienteActual.getCorreoE() + "\n"
                        + "Direccion: " + ClienteActual.getDireccion() + "\n"
                        + "Telefono: " + ClienteActual.getTelefono() + "\n"
                        + "Edad del Cliente: " + ClienteActual.getFechaNac() + "\n";
                break;
            }

            auxCola.Encolar(ClienteActual);
            colaClientes.Desencolar();
        }

        returnColaClientes(auxCola);

        if (ClienteEncontrado) {
            return "¡El Cliente fue encontrado exitosamente!\n\n" + resultado;
        } else {
            return "El Cliente no fue encontrado con este DNI.";
        }
    }
    
//METODO PARA BUSCAR PEDIDO DNI
    public String BuscarPedido(String IDProducto) {
        boolean PedidoEncontrado = false;
        String resultado = "";
        Cola<clsProductos> auxCola = new Cola<>();

        while (!colaProductos.EstaVacia()) {
            clsProductos PedidoActual = colaProductos.getElementos();

            if (PedidoActual.getCodigoPedido().equalsIgnoreCase(IDProducto)) {
                PedidoEncontrado = true;
                // Imprimir la información del primer Cliente
                resultado += "INFORMACIÓN DEL PEDIDO:\n"
                        + "DNI del Pedido: " + PedidoActual.getCodigoPedido()+ "\n"
                        + "Pizza " + PedidoActual.getNombrePizza()+ "\n"
                        + "Tamaño de Pizza: " + PedidoActual.getTamanoP()+ "\n"
                        + "Bebida: " + PedidoActual.getNombreBebida()+ "\n"
                        + "Tamaño de Bebida: " + PedidoActual.getTamanoB()+ "\n"
                        + "Adición: " + PedidoActual.getAdicion()+ "\n"
                        + "Tamaño de la Adición: " + PedidoActual.getTamanoAd()+ "\n";
                break;
            }

            auxCola.Encolar(PedidoActual);
            colaProductos.Desencolar();
        }

        returnColaProductos(auxCola);

        if (PedidoEncontrado) {
            return "¡El Pedido fue encontrado exitosamente!\n\n" + resultado;
        } else {
            return "El Pedido no fue encontrado con este ID.";
        }
    }    


//METODO PARA IMPRIMIR CLIENTE
    public String ImprimirPedido() {
        try {
            // INICIALIZAMOS A CADENA CON UNA VALOR NUEVO
            cadena = "LISTADO DE PEDIDOS REGISTRADOS EN EL SISTEMA\n\n";

            // VERIFICAMOS QUE LA COLA ESTE VACIA
            while (!colaClientes.EstaVacia()) {

                // CARGAMOS EL OBJETO DEL CLIENTE CON LOS DATOS DE LA COLA
                objClientes = colaClientes.getElementos();
                objProductos = colaProductos.getElementos();

                // LISTAMOS LOS DATOS EN LA CADENA
                cadena += "DNI: " + objClientes.getDNI() + "\n"
                        + "Nombre: " + objClientes.getNombre() + "\n"
                        + "Apellidos: " + objClientes.getApellidos() + "\n"
                        + "Correo electrónico: " + objClientes.getCorreoE() + "\n"
                        + "Dirección: " + objClientes.getDireccion() + "\n"
                        + "Teléfono: " + objClientes.getTelefono() + "\n"
                        + "Edad del Cliente: " + objClientes.getFechaNac() + " años " + "\n"
                        + "Sabor de pizza pedido: " + objProductos.getNombrePizza()+ "\n"
                        + "Tamaño  de la pizza: " + objProductos.getTamanoP()+ "\n"
                        + "Precio de la pizza: " + objProductos.getPrecioPizza()+ "\n"
                        + "Bebida: " + objProductos.getNombreBebida()+ "\n"
                        + "Tamaño  de la Bebida: " + objProductos.getTamanoB()+ "\n"
                        + "Precio de la Bebida: " + objProductos.getPrecioBebida()+ "\n"
                        + "Adición: " + objProductos.getAdicion()+ "\n"
                        + "Tamaño  de la Adición: " + objProductos.getTamanoAd()+ "\n"
                        + "Precio de la Adición: " + objProductos.getPrecioAd()+ "\n"
                        + "Valor total del Pedido: " + ((objProductos.getPrecioPizza()) + (objProductos.getPrecioBebida()) + (objProductos.getPrecioAd()))
                        + "\n\n";

                // ENCOLAMOS EN LA COLA AUXILIAR EL DATO QUE ACAMOS DE RECORRER
                colaClienteAux.Encolar(colaClientes.getElementos());
                // ELIMINAMOS EL DATO SIGUIENTE DE LA COLA
                colaClientes.Desencolar();
            }

            // RETORNA LA COLA AUXILIAR A LA COLA PRINCIPAL DE CLIENTES
            returnColaClientes(colaClienteAux);

            // VALIDA QUE SI EXISTAN DATOS EN COLA PARA MOSTRAR EL TOTAL
            if (contClientes != 0) {
                cadena += "TOTAL DE PEDIDOS REGISTRADOS " + contClientes;
            }

            // RETORNAMOS LA CADENA LLENA DE DATOS
            return cadena;
        } catch (Exception e) {
            // CAPTURAMOS EL ERROR DEL PROCESO Y LO ASIGNAMOS A CADENA
            cadena = "Error al leer clientes en la COLA: " + e.getMessage();

            // RETORNAMOS EL ERROR
            return cadena;
        }

    }

//METODO PARA ELIMINAR CLIENTE
    public String EliminarCliente(String DNI) {

        try {
            cadena = "";
            Banderita = false;

            while (!colaClientes.EstaVacia()) {

                objClientes = colaClientes.getElementos();

                if (objClientes.getDNI().equalsIgnoreCase(DNI)) {
                    Banderita = true;
                    contClientes--;
                    colaClientes.Desencolar();
                } else {
                    colaClienteAux.Encolar(colaClientes.getElementos());
                    colaClientes.Desencolar();
                }
            }

            if (Banderita) {
                cadena = "El registro del cliente  fue encontrado y eliminado";
            } else {
                cadena = "El DNI del cliente no fue encontrado";
            }

            returnColaClientes(colaClienteAux);
            return cadena;

        } catch (Exception e) {
            // CAPTURAMOS EL ERROR DEL PROCESO Y LO ASIGNAMOS A CADENA
            cadena = "Error al eliminar cliente en la COLA: " + e.getMessage();

            // RETORNAMOS EL ERROR
            return cadena;
        }

    }

    public String ContadorCliente() {
        return "El total de Clientes es: " + contClientes;
    }
    
    public String EliminarPedido(String DNI) {

        try {
            cadena = "";
            Banderita = false;

            while (!colaProductos.EstaVacia()) {

                objProductos = colaProductos.getElementos();

                if (objProductos.getCodigoPedido().equalsIgnoreCase(DNI)) {
                    Banderita = true;
                    contPedidos--;
                    colaProductos.Desencolar();
                } else {
                    colaProductosAux.Encolar(colaProductos.getElementos());
                    colaProductos.Desencolar();
                }
            }

            if (Banderita) {
                cadena = "El Pedido fue encontrado y eliminado";
            } else {
                cadena = "El DNI del Pedido no fue encontrado";
            }

            returnColaProductos(colaProductosAux);
            return cadena;

        } catch (Exception e) {
            // CAPTURAMOS EL ERROR DEL PROCESO Y LO ASIGNAMOS A CADENA
            cadena = "Error al eliminar Pedido en la COLA: " + e.getMessage();

            // RETORNAMOS EL ERROR
            return cadena;
        }

    }
    
    public String ContadorPedidos() {
        return "El total de Pedidos es: " + contPedidos;
    }

//METODOS ESCOGER PRODUCTOS
    public int METODO_ESCOGER_TAMANO() {
        try {

            Pizza = Integer.parseInt(JOptionPane.showInputDialog(""
                    + "INGRESE EL TAMAÑO DE LA PIZZA QUE DESEA" + "\n"
                    + "1. EXTRA GRANDE, PRECIO= 76.000" + "\n"
                    + "2. GRANDE, PRECIO=57.000" + "\n"
                    + "3. MEDIANO, PRECIO=36.000" + "\n"
                    + "4. PEQUEÑO, PRECIO=27.000" + "\n"
                    + "5. PORCION, PRECIO=14.000"));

            //Comprobamos que el numero entero este en el rango deseado en caso de que no lo este  usamos recursividad para volver a llamar al metodo
            if (Pizza < 1 || Pizza > 5) {
                JOptionPane.showMessageDialog(null, "OPCION INVALIDA INTENTELO NUEVAMENTE");
                METODO_ESCOGER_PIZZA();

                //Si el numero entero esta en el rango deseado se llena las variable valor que se usara en la isntancia del objeto y se imprime mensaje al usuario con estos mismos 
            } else {
                switch (Pizza) {
                    case 1:
                        Precio = 76000;
                        JOptionPane.showMessageDialog(null, ("HA ESCOGIDO EL TAMAÑO EXTRA SON " + Precio + " COP DE LA PIZZA"));
                        break;
                    case 2:
                        Precio = 57000;
                        JOptionPane.showMessageDialog(null, ("HA ESCOGIDO EL TAMAÑO GRANDE SON " + Precio + " COP DE LA PIZZA"));
                        break;
                    case 3:
                        Precio = 36000;
                        JOptionPane.showMessageDialog(null, ("HA ESCOGIDO EL TAMAÑO MEDIANO SON " + Precio + " COP DE LA PIZZA"));
                        break;
                    case 4:
                        Precio = 27000;
                        JOptionPane.showMessageDialog(null, ("HA ESCOGIDO EL TAMAÑO PEQUEÑO SON " + Precio + " COP DE LA PIZZA"));
                        break;
                    case 5:
                        Precio = 14000;
                        JOptionPane.showMessageDialog(null, ("HA ESCOGIDO LA PORCION DE PIZZA SON " + Precio + " COP DE LA PIZZA"));
                        break;
                }
            }

            //Retornamos el entero del disfraz
            return Pizza;
        } catch (Exception e) {
            // CAPTURAMOS EL ERROR DEL PROCESO Y RETORNAMOS EL ERROR

            JOptionPane.showMessageDialog(null, "ERROR AL ESCOJER EL PIZZA: " + e.getMessage());
            return 1;
        }
    }

    public int METODO_ESCOGER_TAMANOB() {
        try {

            Bebida = Integer.parseInt(JOptionPane.showInputDialog(""
                    + "INGRESE EL TAMAÑO DE LA BEBIDA QUE DESEA" + "\n"
                    + "1. MEGA, PRECIO= 10.000" + "\n"
                    + "2. 2,5 LITROS, PRECIO=8.000" + "\n"
                    + "3. 1,5 LITROS, PRECIO=5.000" + "\n"
                    + "4. ECONOLITRO, PRECIO=4.000" + "\n"
                    + "5. PERSONAL, PRECIO=2.000"));

            //Comprobamos que el numero entero este en el rango deseado en caso de que no lo este  usamos recursividad para volver a llamar al metodo
            if (Bebida < 1 || Bebida > 5) {
                JOptionPane.showMessageDialog(null, "OPCION INVALIDA INTENTELO NUEVAMENTE");
                METODO_ESCOGER_TAMANOB();

                //Si el numero entero esta en el rango deseado se llena las variable valor que se usara en la isntancia del objeto y se imprime mensaje al usuario con estos mismos 
            } else {
                switch (Bebida) {
                    case 1:
                        Preciob = 10000;
                        JOptionPane.showMessageDialog(null, ("HA ESCOGIDO EL TAMAÑO MEGA SON " + Preciob + " COP DE LA BEBIDA"));
                        break;
                    case 2:
                        Preciob = 8000;
                        JOptionPane.showMessageDialog(null, ("HA ESCOGIDO EL TAMAÑO 2,5 LITROS SON " + Preciob + " COP DE LA BEBIDA"));
                        break;
                    case 3:
                        Preciob = 5000;
                        JOptionPane.showMessageDialog(null, ("HA ESCOGIDO EL TAMAÑO 1,5 LITROS SON " + Preciob + " COP DE LA BEBIDA"));
                        break;
                    case 4:
                        Preciob = 4000;
                        JOptionPane.showMessageDialog(null, ("HA ESCOGIDO EL TAMAÑO ECONOLITRO SON " + Preciob + " COP DE LA BEBIDA"));
                        break;
                    case 5:
                        Preciob = 2000;
                        JOptionPane.showMessageDialog(null, ("HA ESCOGIDO LA PERSONALDE PIZZA SON " + Preciob + " COP DE LA BEBIDA"));
                        break;
                }
            }

            //Retornamos el entero del disfraz
            return Bebida;
        } catch (Exception e) {
            // CAPTURAMOS EL ERROR DEL PROCESO Y RETORNAMOS EL ERROR

            JOptionPane.showMessageDialog(null, "ERROR AL ESCOGER LA BEBIDA: " + e.getMessage());
            return 1;
        }
    }
    
    public int METODO_ESCOGER_ADICION() {
        try {

            Adicion = Integer.parseInt(JOptionPane.showInputDialog(""
                    + "INGRESELA ADICIÓN QUE DESEA" + "\n"
                    + "1. 600gr EXTRAADICIÓN, $ 17.000" + "\n"
                    + "2. 400gr GRANDE, $ 14.000" + "\n"
                    + "3. 200gr MEDIANA, $ 10.000" + "\n"
                    + "4. 100gr PEQUEñA, $ 7.000" + "\n"
                    + "5. NO ADICIÓN, $ 0"));

            //Comprobamos que el numero entero este en el rango deseado en caso de que no lo este  usamos recursividad para volver a llamar al metodo
            if (Adicion < 1 || Adicion > 5) {
                JOptionPane.showMessageDialog(null, "OPCION INVALIDA INTENTELO NUEVAMENTE");
                 METODO_ESCOGER_ADICION();

                //Si el numero entero esta en el rango deseado se llena las variable valor que se usara en la isntancia del objeto y se imprime mensaje al usuario con estos mismos 
            } else {
                switch (Adicion) {
                    case 1:
                        PrecioA = 17000;
                        JOptionPane.showMessageDialog(null, ("HA ESCOGIDO ADICIÓN EXTRAGRANDE  SON " + PrecioA + " COP DE LA ADICIÓN"));
                        break;
                    case 2:
                        PrecioA = 14000;
                        JOptionPane.showMessageDialog(null, ("HA ESCOGIDO ADICIÓN GRANDE SON " + PrecioA + " COP DE LA ADICIÓN"));
                        break;
                    case 3:
                        PrecioA = 10000;
                        JOptionPane.showMessageDialog(null, ("HA ESCOGIDO ADICIÓN MEDIANA SON " + PrecioA + " COP DE LA ADICIÓN"));
                        break;
                    case 4:
                        PrecioA = 7000;
                        JOptionPane.showMessageDialog(null, ("HA ESCOGIDO ADICIÓN PEQUEñA SON " + PrecioA + " COP DE LA ADICIÓN"));
                        break;
                    case 5:
                        PrecioA = 0;
                        JOptionPane.showMessageDialog(null, ("NO SELECCIONÓ ADICIÓN"));
                        break;
                    
                }
            }

            //Retornamos el entero del disfraz
            return Adicion;
        } catch (Exception e) {
            // CAPTURAMOS EL ERROR DEL PROCESO Y RETORNAMOS EL ERROR

            JOptionPane.showMessageDialog(null, "ERROR AL ESCOGER LA ADICIÓN: " + e.getMessage());
            return 1;
        }
    }
    
//VALIDACIONES DE LOS DATOS
    private String Validar_Nombre() {
        String nombre;
        boolean nombreValido = false; //inicializamos la variable para controlar el bucle
        do {
            nombre = JOptionPane.showInputDialog(null, "¿Cuál es el nombre del Cliente?"); //almacenando en la variable nombre
            if (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                JOptionPane.showMessageDialog(
                        null,
                        "El nombre no puede contener caractares especiales.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                nombreValido = true;
            }
        } while (!nombreValido);
        return nombre;
    }

    private String Validar_Apellido() {
        String apellido = "";

        while (true) {
            apellido = JOptionPane.showInputDialog(null, "¿Cuál es el Apellido del Cliente?");

            if (apellido.trim().isEmpty() || apellido.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]*$")) {
                break;
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "El apellido no puede contener caracteres especiales, excepto letras y espacios. Deja el campo en blanco o ingresa un apellido válido.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
        return apellido;
    }

    private String Validar_Cedula() {
        String cedula;
        boolean userInputValid = false;

        do {
            cedula = JOptionPane.showInputDialog(null, "Ingrese la cedula del Cliente \n");

            if (!esNumero(cedula)) {
                JOptionPane.showMessageDialog(
                        null,
                        "La cedula debe ser un número.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            } else {
                userInputValid = true;
            }
        } while (!userInputValid);

        return cedula;
    }
    
    private String Validar_Pedido() {
        String pedido;
        boolean userInputValid = false;

        do {
            pedido = JOptionPane.showInputDialog(null, "Ingrese el numero del pedido \n");

            if (!esNumero(pedido)) {
                JOptionPane.showMessageDialog(
                        null,
                        "El pedido debe ser un número.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            } else {
                userInputValid = true;
            }
        } while (!userInputValid);

        return pedido;
    }

    private boolean esNumero(String cadena) {
        try {
            // Intentar convertir la cadena en un número
            Long.parseLong(cadena);
            return true;
        } catch (NumberFormatException e) {
            // Si no se puede convertir, es porque no es un número
            return false;
        }
    }

    private int Validar_Fecha() {
        try {
            String fechaUser = JOptionPane.showInputDialog(null, "Ingrese la fecha de nacimiento DD-MM-AAAA");

            // Obtén la fecha ingresada por el usuario
            String userInput = fechaUser;

            // Define un formato para la fecha
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

            // Intenta parsear la fecha
            Date dateOfBirth = dateFormat.parse(userInput);

            // Calcula la fecha actual
            Date currentDate = new Date();

            // Calcula la diferencia en milisegundos
            long difference = currentDate.getTime() - dateOfBirth.getTime();

            // Convierte la diferencia a años
            int age = (int) (difference / (1000L * 60 * 60 * 24 * 365.25));

            // La variable 'age' contiene la edad del usuario
            return age;
        } catch (ParseException e) {
            // En caso de error en el formato de la fecha
            System.err.println("Formato de fecha incorrecto");
        }
        return 0;
    }

    private String Validar_Correo() {
        String correo = "";
        boolean correoValido = false;

        do {
            correo = JOptionPane.showInputDialog(null, "Ingrese el correo del Cliente:");

            if (correo.contains("@")) {
                correoValido = true;
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "El correo electrónico debe contener el símbolo '@'.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        } while (!correoValido);

        return correo;
    }

    public boolean existeCedula(String cedula) {
        Cola<clsClientes> tempCola = new Cola();
        boolean existe = false;

        while (!colaClientes.EstaVacia()) {
            clsClientes objCliente = colaClientes.getElementos();
            if (objCliente.getDNI().equalsIgnoreCase(cedula)) {
                existe = true;
            }
            tempCola.Encolar(colaClientes.getElementos());
            colaClientes.Desencolar();
        }

        // Restaurar la Cola original
        returnColaClientes(tempCola);
        return existe;
    }
    
    public boolean existePedido(String pedido) {
        Cola<clsProductos> tempCola = new Cola();
        boolean existe = false;

        while (!colaProductos.EstaVacia()) {
            clsProductos objProductos = colaProductos.getElementos();
            if (objProductos.getCodigoPedido().equalsIgnoreCase(pedido)) {
                existe = true;
            }
            tempCola.Encolar(colaProductos.getElementos());
            colaProductos.Desencolar();
        }

        // Restaurar la Cola original
        returnColaProductos(tempCola);
        return existe;
    }

    private void returnColaClientes(Cola<clsClientes> AuxCliente) {
        try {
            while (!AuxCliente.EstaVacia()) {
                colaClientes.Encolar(AuxCliente.getElementos());
                AuxCliente.Desencolar();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al devolver la Cola de Clientes: " + e.getMessage());
        }
    }
    
    private void returnColaProductos(Cola<clsProductos> AuxProductos) {
        try {
            while (!AuxProductos.EstaVacia()) {
                colaProductos.Encolar(AuxProductos.getElementos());
                AuxProductos.Desencolar();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al devolver la Cola de Productos: " + e.getMessage());
        }
    }

    private String Validar_Pizza() {
        String[] opcionesPizza = {"HAWAIANA", "CHAMPIÑONES", "POLLO", "MEXICANA", "VEGETARIANA"};
        int seleccion = JOptionPane.showOptionDialog(
                null,
                "Selecciona el sbor de pizza que deseas:",
                "Pizzas disponibles",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesPizza,
                opcionesPizza[0]
        );

        if (seleccion == -1) {
            return "Registro cancelado.";
        }
        String pizza = opcionesPizza[seleccion];
        return pizza;
    }

    private String Validar_Bebida() {
        String[] opcionesBebida = {"COCACOLA", "POSTOBON", "BAVARIA"};
        int seleccion = JOptionPane.showOptionDialog(
                null,
                "Selecciona la bebida que desea:",
                "Bebidas disponibles",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesBebida,
                opcionesBebida[0]
        );

        if (seleccion == -1) {
            return "Registro cancelado.";
        }
        String bebida = opcionesBebida[seleccion];
        return bebida;
    }

    private String Validar_Adicion() {
        String[] opcionesAdicion = {"NINGUNA", "QUESO", "EMBUTIDOS ITALIANOS", "EMBUTIDOS PICANTES",  "ACEITUNAS", "CHAMPIñONES"};
        int seleccion = JOptionPane.showOptionDialog(
                null,
                "Selecciona la adición que deseas:",
                "Adiciones disponibles",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesAdicion,
                opcionesAdicion[0]
        );

        if (seleccion == -1) {
            return "Registro cancelado.";
        }
        String adicion = opcionesAdicion[seleccion];
        return adicion;
    }

    private void METODO_ESCOGER_PIZZA() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object AgregarClientes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void METODO_ESCOGER_BEBIDA() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
//EMPLEADOS
    public String AgregarEmpleado() {

        try {
            while (JOptionPane.showConfirmDialog(null,
                    "¿DESEA AGREGAR UN EMPLEADO?")
                    == JOptionPane.YES_NO_OPTION) {

                COMPROBACION_DNI_EMPLEADOS();

                colaempleado.Encolar(new clsEmpleados(
                        dni,
                        JOptionPane.showInputDialog("INGRESE EL NOMBRE DEL EMPLEADO: "),
                        JOptionPane.showInputDialog("INGRESE EL APELLIDO DEL EMPLEADO: "),
                        JOptionPane.showInputDialog("INGRESE EL CORREO DEL EMPLEADO: "),
                        JOptionPane.showInputDialog("INGRESE LA DIRECCION DEL EMPLEADO: "),
                        JOptionPane.showInputDialog("INGRESE EL TELEFONO DEL EMPLEADO: "),
                        METODO_ESCOGER_ROL(),
                        Integer.parseInt(JOptionPane.showInputDialog("INGRESE LA CANTIDAD DE HORAS TRABAJADAS")),
                        Integer.parseInt(JOptionPane.showInputDialog("INGRESE EL VALOR DE LA HORA"))
                        
                ));
                contempleado++;
            }
            cadena = "SE AGREGARON " + contempleado + " EMPLEADOS AL SISTEMA";
            return cadena;
        } catch (HeadlessException e) {
            // CAPTURAMOS EL ERROR DEL PROCESO Y LO ASIGNAMOS A CADENA
            cadena = "ERROR AL INSERTAR EMPLEADOS EN LA COLA: " + e.getMessage();

            // RETORNAMOS EL ERROR
            return cadena;
        }
    }

    public String EliminarEmpleado(String dni) {
        try {
            boolean banderita = false;
            cadena = "";
            while (!colaempleado.EstaVacia()) {

                ObjEmpleado = colaempleado.getElementos();

                if (ObjEmpleado.getDNI().equalsIgnoreCase(dni)) {
                    banderita = true;
                    contempleado--;
                    colaempleado.Desencolar();
                } else {
                    auxempleado.Encolar(colaempleado.getElementos());
                    colaempleado.Desencolar();
                }
            }

            if (banderita) {
                cadena = "=======EL EMPLEADO FUE ENCONTRADO Y ELIMINADO=======";
            } else {
                cadena = "=======EL EMPLEADO NO FUE ENCONTRADO=======";

            }

            retColaEmpleado(auxempleado);
            return cadena;
        } catch (HeadlessException e) {
            // CAPTURAMOS EL ERROR DEL PROCESO Y LO ASIGNAMOS A CADENA
            cadena = "ERROR AL ELIMINAR EMPLEADOS DE LA COLA: " + e.getMessage();

            // RETORNAMOS EL ERROR
            return cadena;
        }
    }

    public String ImprimirEmpleado() {
        try {
            cadena = "LISTADO DE EMPLEADOS\n\n";
            while (!colaempleado.EstaVacia()) {

                ObjEmpleado = colaempleado.getElementos();
                cadena += "NOMBRE: " + ObjEmpleado.getNombre() + "\n"
                        + "APELLIDO: " + ObjEmpleado.getApellidos() + "\n"
                        + "DNI: " + ObjEmpleado.getDNI()+ "\n"
                        + "CORREO: " + ObjEmpleado.getCorreoE() + "\n"
                        + "DIRECCION: " + ObjEmpleado.getDireccion() + "\n"
                        + "TELEFONO: " + ObjEmpleado.getTelefono() + "\n"
                        + "SALARIO DE ESTE MES: " + (ObjEmpleado.getCantHTM() * ObjEmpleado.getValorHora()) + "\n"
                        + "ROL DEL EMPLEADO: " + ObjEmpleado.getRol() + "\n"
                        + "----------------------------------------------------------\n\n";

                auxempleado.Encolar(colaempleado.getElementos());
                colaempleado.Desencolar();

            }
            retColaEmpleado(auxempleado);

            return cadena;
        } catch (HeadlessException e) {
            // CAPTURAMOS EL ERROR DEL PROCESO Y LO ASIGNAMOS A CADENA
            cadena = "ERROR AL IMPRIMIR EMPLEADOS DE LA COLA: " + e.getMessage();

            // RETORNAMOS EL ERROR
            return cadena;
        }
    }

    public String ContadorEmpleado() {
        try {
            return "EL TOTAL DE EMPLEADOS ES " + contempleado;
        } catch (HeadlessException e) {
            // RETORNAMOS EL ERROR
            return "ERROR CON EL CONTADOR DE EMPLEADOS: " + e.getMessage();

        }
    }

    private void retColaEmpleado(Cola<clsEmpleados> auxempleado) {

        try {
            while (!auxempleado.EstaVacia()) {
                colaempleado.Encolar(auxempleado.getElementos());
                auxempleado.Desencolar();
            }
        } catch (HeadlessException e) {
            // RETORNAMOS EL ERROR
            JOptionPane.showMessageDialog(null, "ERROR AL DEVOLVER LA COLA DE EMPLEADOS: " + e.getMessage());

        }

    }

    public String BuscarEmpleado(String dni) {
        try {
            boolean banderita = false;
            String datoen = "";
            cadena = "";
            while (!colaempleado.EstaVacia()) {

                ObjEmpleado = colaempleado.getElementos();

                if (ObjEmpleado.getDNI().equalsIgnoreCase(dni)) {
                    banderita = true;
                    cadena += "NOMBRE: " + ObjEmpleado.getNombre() + "\n"
                            + "APELLIDO: " + ObjEmpleado.getApellidos() + "\n"
                            + "DNI: " + ObjEmpleado.getDNI() + "\n"
                            + "CORREO: " + ObjEmpleado.getCorreoE() + "\n"
                            + "DIRECCION: " + ObjEmpleado.getDireccion() + "\n"
                            + "TELEFONO: " + ObjEmpleado.getTelefono() + "\n"
                            + "SALARIO DE ESTE MES: " + (ObjEmpleado.getCantHTM() * ObjEmpleado.getValorHora()) + "\n"
                            + "ROL DEL EMPLEADO: " + ObjEmpleado.getRol() + "\n"
                            + "----------------------------------------------------------\n\n";

                    auxempleado.Encolar(colaempleado.getElementos());
                    colaempleado.Desencolar();
                } else {
                    auxempleado.Encolar(colaempleado.getElementos());
                    colaempleado.Desencolar();
                }
            }

            if (banderita) {
                datoen = "=======¡EL EMPLEADO FUE ENCONTRADO ÉXITOSAMENTE!=======\n";
            } else {
                cadena = "=======EL EMPLEADO NO FUE ENCONTRADO.=======";
            }

            retColaEmpleado(auxempleado);
            return datoen + cadena;
        } catch (HeadlessException e) {
            // CAPTURAMOS EL ERROR DEL PROCESO Y LO ASIGNAMOS A CADENA
            cadena = "ERROR AL BUSCAR EMPLEADO DE LA COLA: " + e.getMessage();

            // RETORNAMOS EL ERROR
            return cadena;
        }
    }

    public String ModificarEmpleado(String dni, int opc) {

        try {
            boolean banderita = false;
            String datoen = "";
            cadena = "";

            while (!colaempleado.EstaVacia()) {
                ObjEmpleado = colaempleado.getElementos();

                if (ObjEmpleado.getDNI().equalsIgnoreCase(dni)) {
                    banderita = true;
                    switch (opc) {
                        case 1:
                            ObjEmpleado.setNombre(JOptionPane.showInputDialog(
                                    "¿CUÁL ES EL NUEVO NOMBRE DE EL EMPLEADO?"));
                            cadena = "NOMBRE DE EL EMPLEADO MODIFICADO CON ÉXITO";
                            break;
                        case 2:
                            ObjEmpleado.setApellidos(JOptionPane.showInputDialog(
                                    "¿CUÁL ES EL NUEVO APELLIDO DE EL EMPLEADO?"));
                            cadena = "APELLIDO DE EL EMPLEADO MODIFICADO CON ÉXITO";
                            break;
                        case 3:
                            ObjEmpleado.setCorreoE(JOptionPane.showInputDialog(
                                    "¿CUÁL ES EL NUEVO CORREO DE EL EMPLEADO?"));
                            cadena = "CORREO DE EL EMPLEADO MODIFICADO CON ÉXITO";
                            break;
                        case 4:
                            ObjEmpleado.setDireccion(JOptionPane.showInputDialog(
                                    "¿CUÁL ES LA NUEVA DIRECCION DE EL EMPLEADO?"));
                            cadena = "DIRECCION DE EL EMPLEADO MODIFICADO CON ÉXITO";
                            break;
                        case 5:
                            ObjEmpleado.setTelefono(JOptionPane.showInputDialog(
                                    "¿CUÁL ES EL NUEVO TELEFONO DE EL EMPLEADO?"));
                            cadena = "TELEFONO DE EL EMPLEADO MODIFICADO CON ÉXITO";
                            break;
                        case 6:
                            ObjEmpleado.setRol(JOptionPane.showInputDialog(
                                    "¿CUAL ES EL NUEVO ROL DEL EMPLEADO?"));
                            cadena = "ROL DE EL EMPLEADO MODIFICADO CON ÉXITO";
                            break;
                        default:
                            cadena = "OPCION INVALIDA. INTENTELO NUEVAMENTE";
                    }

                    auxempleado.Encolar(colaempleado.getElementos());
                    colaempleado.Desencolar();
                } else {
                    auxempleado.Encolar(colaempleado.getElementos());
                    colaempleado.Desencolar();
                }
            }

            if (banderita) {
                datoen = "=======EL EMPLEADO FUE ENCONTRADO!!!=======\n\n";
            } else {
                cadena = "=======EL EMPLEADO NO FUE ENCONTRADO!!!=======";
            }

            retColaEmpleado(auxempleado);
            return datoen + cadena;
        } catch (HeadlessException e) {
            // CAPTURAMOS EL ERROR DEL PROCESO Y LO ASIGNAMOS A CADENA
            cadena = "ERROR AL MODIFICAR EMPLEADO DE LA COLA: " + e.getMessage();

            // RETORNAMOS EL ERROR
            return cadena;
        }

    }

    public void COMPROBACION_DNI_EMPLEADOS() {
        try {
            dni = JOptionPane.showInputDialog(null, "INGRESE EL DNI DEL EMPLEADO: ");
            while (!colaempleado.EstaVacia()) {
                ObjEmpleado = colaempleado.getElementos();

                if (ObjEmpleado.getDNI().equalsIgnoreCase(dni)) {
                    JOptionPane.showMessageDialog(null, "EL EMPLEADO YA ESTA REGISTRADO, INTENTELO NUEVAMENTE");
                    retColaEmpleado(auxempleado);
                    COMPROBACION_DNI_EMPLEADOS();

                } else {
                    auxempleado.Encolar(colaempleado.getElementos());
                    colaempleado.Desencolar();
                }
            }

            retColaEmpleado(auxempleado);
        } catch (HeadlessException e) {

            // RETORNAMOS EL ERROR
            JOptionPane.showMessageDialog(null, "ERROR AL COMPROBAR DNI DE EL EMPLEADO: " + e.getMessage());
        }
    }

    public String PAGAR_NOMINA() {
        
        try {
            cadena = "LISTADO DE EMPLEADOS\n\n";
            while (!colaempleado.EstaVacia()) {

                ObjEmpleado = colaempleado.getElementos();
                cadena += "NOMBRE: " + ObjEmpleado.getNombre() +  ObjEmpleado.getApellidos()+ "\n"
                         + "ROL DEL EMPLEADO: " + ObjEmpleado.getRol() + "\n"
//                        + "APELLIDO: " + ObjEmpleado.getApellidos() + "\n"
                        + "DNI: " + ObjEmpleado.getDNI()+ "\n"
                        + "SALARIO DE ESTE MES: " + (ObjEmpleado.getCantHTM() * ObjEmpleado.getValorHora()) + "\n"
                       
                        + "----------------------------------------------------------\n\n";

                auxempleado.Encolar(colaempleado.getElementos());
                colaempleado.Desencolar();

            }
            retColaEmpleado(auxempleado);

            return cadena;
        } catch (HeadlessException e) {
            // CAPTURAMOS EL ERROR DEL PROCESO Y LO ASIGNAMOS A CADENA
            cadena = "ERROR AL PAGAR NÓMINA: " + e.getMessage();

            // RETORNAMOS EL ERROR
            return cadena;
        }
 
    }
    
    public String METODO_ESCOGER_ROL() {
        String[] opcionesRol = {"ADMINISTRATIVO", "CAJERO", "OPERARIO", "MENSAJERO"};
        int seleccion = JOptionPane.showOptionDialog(
                null,
                "Selecciona el rol del empleado:",
                "Roles de empleados",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesRol,
                opcionesRol[0]
        );

        if (seleccion == -1) {
            return "Registro cancelado.";
        }
        String rol = opcionesRol[seleccion];
        return rol;
    }

}
