package gestor;

import Models.Comentario;
import Models.ComentarioComp;
import Models.DTOComercioxRubro;
import Models.DTOValoracion;
import Models.DTOcantComentarioxComercio;
import Models.DTOcomentarioRta;
import Models.DTOdetallesOferta;
import Models.DTOofertaxComercio;

import Models.Login;
import Models.comercio;
import Models.listadoofertaxcomercio;
import Models.oferta;
import Models.respuestas;
import Models.rubro;
import java.sql.*;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Gestor {

    private String CONN = "jdbc:sqlserver://ALDANA-PC\\SQLEXPRESS:1433;databaseName=RedSocial";
    private String USER = "sa";
    private String PASS = "aldana97";

    public Gestor() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Gestor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //creacion de login 
    public void InsertarSesion(Login l) {
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("insert into Administradores ( nombre_usuario,contraseña ,email) values (?,?,?)");

            st.setString(1, l.getUsuario());
            st.setString(2, l.getPassword());
            st.setString(3, l.getEmail());
            st.executeUpdate();

            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
//

    public boolean ExisteLogin(String nombre, String contra) {
        boolean resultado = false;
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("select nombre_usuario, contrasena\n"
                    + "from Administradores\n"
                    + "where nombre_usuario = '" + nombre + "'\n"
                    + "and contrasena = '" + contra + "'");

            ResultSet rs = st.executeQuery();
            resultado = true;

            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }

    //portal listado de rubros 
    public ArrayList<rubro> obtenerTodoslosRubros() {
        ArrayList<rubro> lista = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement pr = conn.prepareStatement("select id_rubro , nombre, descripcion, estado, ruta \n"
                    + "                                                               from rubros ");

            ResultSet rs = pr.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                String descripcion = rs.getString(3);
                boolean estado = rs.getBoolean(4);
                String ruta = rs.getString(5);

                rubro r = new rubro(id, nombre, estado, descripcion, ruta);

                lista.add(r);
            }

            rs.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;

    }

    //listado de comercios 
    public ArrayList<DTOComercioxRubro> listadoComercio(int idRubroC) {
        ArrayList<DTOComercioxRubro> lista = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("select r.id_rubro, c.nombre, c.direccion, c.telefono, avg(co.valoracion) promedio, c.estado, c.id_comercio, c.ruta \n"
                    + "from Comercios c join rubros r on c.id_rubro = r.id_rubro\n"
                    + "left join Comentarios co on c.id_comercio = co.id_comercio\n"
                    + "where r.id_rubro = ? \n"
                    + "group by  r.id_rubro, c.nombre, c.direccion, c.telefono, c.estado, c.id_comercio, c.ruta");
            st.setInt(1, idRubroC);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String nombreO = rs.getString(2);
                String direccion = rs.getString(3);
                String telefono = rs.getString(4);
                int promedio = rs.getInt(5);
                boolean estado = rs.getBoolean(6);
                int idC = rs.getInt(7);
                String imagen = rs.getString(8);

                rubro r = new rubro(id, "", true, "", "");
                comercio c = new comercio(nombreO, direccion, telefono, idC, estado, "", "", r, imagen);
                DTOComercioxRubro o = new DTOComercioxRubro(r, c, promedio);

                lista.add(o);
            }

            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }

    //portal de comercio con toda la informacion (Datos personales)
    public comercio portalComercioDatos(int idcomer) {
        comercio o = null;
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("select nombre, Informacion, direccion, telefono, redSocial, id_comercio, ruta, id_rubro\n"
                    + "from Comercios \n"
                    + "where id_comercio = ?");
            st.setInt(1, idcomer);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {

                String nombre = rs.getString(1);
                String Informacion = rs.getString(2);
                String direccion = rs.getString(3);
                String telefono = rs.getString(4);
                String redsocial = rs.getString(5);
                int id = rs.getInt(6);
                String imagen= rs.getString(7);
                int idr = rs.getInt(8);
                rubro r = new rubro(idr, "", true, "", "");
                o = new comercio(nombre, direccion, telefono, id, true, Informacion, redsocial, r, imagen);

            }

            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return o;
    }
    //portal de comercio mostrando el listado de todas sus ofertas 

    public ArrayList<oferta> listadoOfertaxComercio(int idComercio) {
        ArrayList<oferta> lista = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("select o.nombre, o.cantidad, o.precio , c.id_comercio, id_oferta, descripcion, fecha, o.ruta, o.estado\n"
                    + "from Comercios c \n"
                    + "join Ofertas o on c.id_comercio = o.id_comercio \n"
                    + "where c.id_comercio = ?");
            st.setInt(1, idComercio);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                String nombreO = rs.getString(1);
                int cantidad = rs.getInt(2);
                Float precio = rs.getFloat(3);
                int id = rs.getInt(4);
                int ido = rs.getInt(5);
                String descripcion = rs.getString(6);
                String fecha = rs.getString(7);
                String ruta = rs.getString(8);
                boolean estado = rs.getBoolean(9);

                rubro rf = new rubro(0, "", true, "", "");
                comercio c = new comercio("", "", "", id, true, "", "", rf, "");
                oferta o = new oferta(ido, nombreO, cantidad, precio, c, estado, descripcion, fecha,ruta );

                lista.add(o);
            }

            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }
    //portal de comercio con listado de comentarios y respuestas. 

    public ArrayList<DTOcomentarioRta> listadoComentarioxComercio(int idComercio) {
        ArrayList<DTOcomentarioRta> lista = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("  select co.id_comercio, c.id_comentario, c.nombreUsuario, c.descripcion, c.valoracion, c.fecha, co.nombre , r.descripcion, r.fecha, r.id_rta, co.id_rubro\n"
                    + "                     from Comentarios c join Comercios co on c.id_comercio = co.id_comercio\n"
                    + "                     left join Respuestas r on r.id_comentario = c.id_comentario\n"
                    + "                    where co.id_comercio = ?");
            st.setInt(1, idComercio);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                int idcomentario = rs.getInt(2);
                String nombreU = rs.getString(3);
                String descripC = rs.getString(4);
                int valoracion = rs.getInt(5);
                String fechaC = rs.getString(6);
                String nombrecomercio = rs.getString(7);
                String descripcionR = rs.getString(8);
                String fechaR = rs.getString(9);
                int idR = rs.getInt(10);
                int rubro = rs.getInt(11);

                rubro rf = new rubro(rubro, "", true, "", "");
                comercio come = new comercio(nombrecomercio, "", "", id, true, "", "", rf, "");
                Comentario c = new Comentario(idcomentario, descripC, valoracion, nombreU, fechaC, come);
                respuestas r = new respuestas(idR, descripcionR, c, fechaR);
                DTOcomentarioRta cr = new DTOcomentarioRta(c, r);

                lista.add(cr);
            }

            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }

    // ver la oferta con sus datos completos
//    public boolean DatosOferta(int idoferta) {
//        boolean resultado = false;
//        try {
//            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
//
//            PreparedStatement st = conn.prepareStatement("select o.nombre, o.cantidad, o.precio, o.descripcion, o.fecha, c.telefono, c.direccion\n"
//                    + " from Comercios c \n"
//                    + " join Ofertas o on c.id_comercio = o.id_comercio\n"
//                    + "where o.id_oferta = ?");
//            st.setInt(1, idoferta);
//            ResultSet rs = st.executeQuery();
//
//            if (rs.next()) {
//                String nombre = rs.getString(1);
//                int cant = rs.getInt(2);
//                Float precio = rs.getFloat(3);
//                String descripcion = rs.getString(4);
//                String fecha = rs.getString(5);
//                String telefono = rs.getString(6);
//                String direccion = rs.getString(7);
//
//                DTOdetallesOferta d = new DTOdetallesOferta(nombre, cant, precio, descripcion, fecha, telefono, direccion);
//
//                resultado = true;
//            }
//
//            st.close();
//            conn.close();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return resultado;
//    }
    // listado de comentarios en oferta 
//    public ArrayList<DTOcomentarioRta> listadoComentarioxOferta(int idOferta) {
//        ArrayList<DTOcomentarioRta> lista = new ArrayList<>();
//        try {
//            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
//
//            PreparedStatement st = conn.prepareStatement("  select c.nombreUsuario, c.descripcion, c.fecha, co.nombre, r.descripcion, r.fecha\n"
//                    + " from Ofertas o join Comentarios c on o.id_oferta = c.id_oferta\n"
//                    + " join Comercios co on co.id_comercio = o.id_comercio\n"
//                    + " join Respuestas r on r.id_comercio = co.id_comercio\n"
//                    + " where o.id_oferta = ?");
//            st.setInt(1, idOferta);
//            ResultSet rs = st.executeQuery();
//
//            while (rs.next()) {
//                String nombreU = rs.getString(1);
//                String descripC = rs.getString(2);
//
//                String fechaC = rs.getString(3);
//                String nombrecomercio = rs.getString(4);
//                String descripcionR = rs.getString(5);
//                String fechaR = rs.getString(6);
//
//                DTOcomentarioRta cr = new DTOcomentarioRta(nombreU, descripC, 0, fechaC, nombrecomercio, descripcionR, fechaR);
//
//                lista.add(cr);
//            }
//
//            st.close();
//            conn.close();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//
//        return lista;
//    }
    public ArrayList<oferta> listaxbusqueda(String parameter) {
        ArrayList<oferta> lista = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement(" select o.id_oferta, o.nombre, precio, cantidad, fecha, c.nombre, o.estado, c.id_comercio, o.ruta\n"
                    + "from Ofertas o join Comercios c on c.id_comercio = o.id_comercio \n"
                    + "where o.nombre like '" + parameter + "%'");
          
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int ido = rs.getInt(1);
                String nombreO = rs.getString(2);
                int cant = rs.getInt(4);
                float precio = rs.getFloat(3);
                String nombre = rs.getString(6);
                boolean estado = rs.getBoolean(7);
                String fecha = rs.getString(5);
                int idc = rs.getInt(8);
                String imagen = rs.getString(9);

                rubro rf = new rubro(0, "", true, "", "");
                comercio c = new comercio(nombre, "", "", idc, true, "", "", rf, "");
                oferta o = new oferta(ido, nombreO, cant, precio, c, estado, "", fecha, imagen);
         

                lista.add(o);
            }

            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }

    //listado de comercios ordenados por la cantidad de comentarios 
    public ArrayList<DTOcantComentarioxComercio> listaOrdenadaxComentario() {
        ArrayList<DTOcantComentarioxComercio> lista = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select co.nombre, count (Comentarios.id_comercio) comentarios\n"
                    + "from Comentarios join Comercios co on co.id_comercio = Comentarios.id_comercio\n"
                    + "group by co.nombre\n"
                    + "order by comentarios");

            while (rs.next()) {
                String nombreO = rs.getString(1);
                int cant = rs.getInt(2);

                DTOcantComentarioxComercio oc = new DTOcantComentarioxComercio(nombreO, cant);

                lista.add(oc);
            }

            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }

    //listado de todos los comentarios no respondidos 
    public ArrayList<ComentarioComp> listaComentarioNoRespondido() {
        ArrayList<ComentarioComp> lista = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select  co.nombre, c.nombreUsuario, c.descripcion, c.fecha, c.valoracion\n" +
"from Comentarios c  join Comercios co on c.id_comercio = co.id_comercio\n" +
"where id_comentario not in (select id_comentario from  Respuestas r )");

            while (rs.next()) {
                String nombreC = rs.getString(1);
                String nombre = rs.getString(2);
                String descripcion = rs.getString(3);
                String fecha = rs.getString(4);
                int valoracion = rs.getInt(5);

                ComentarioComp c = new ComentarioComp(nombreC, nombre, descripcion, fecha, valoracion);

                lista.add(c);
            }

            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }

    //Cantidad de estrellas por valoracion 
    public ArrayList<DTOValoracion> listaValoraciones() {
        ArrayList<DTOValoracion> lista = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select valoracion, COUNT (valoracion) cantidad\n"
                    + "from Comentarios\n"
                    + "where valoracion is not null\n"
                    + "group by valoracion ");

            while (rs.next()) {

                int valoracion = rs.getInt(1);
                int cantidad = rs.getInt(2);

                DTOValoracion v = new DTOValoracion(valoracion, cantidad);

                lista.add(v);
            }

            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }
    //ABM OFERTAS 

    public void InsertarOferta(oferta o) {
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("insert into Ofertas (nombre, precio, estado, fecha, id_comercio, descripcion, cantidad, ruta) values (?, ?,?, GETDATE(), ?,?, ?, ?) ");
            st.setString(1, o.getNombre());
            st.setFloat(2, o.getPrecio());
            st.setBoolean(3, true);
            st.setInt(4, o.getC().getComercios_id());
            st.setString(5, o.getDescripcion());
            st.setInt(6, o.getCantidad());
            st.setString(7, o.getRuta());

            st.executeUpdate();

            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void ModificarOferta(oferta o) {
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("update Ofertas set nombre = ?, cantidad = ?, descripcion = ?, precio =?, ruta = ? where id_oferta = ? ");
            st.setString(1, o.getNombre());
            st.setInt(2, o.getCantidad());
            st.setString(3, o.getDescripcion());
            st.setFloat(4, o.getPrecio());
            st.setInt(6, o.getId_oferta());
            st.setString(5, o.getRuta());
            st.executeUpdate();

            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public oferta ObtenerOferta(int idOferta) {
        oferta o = null;
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("select *\n"
                    + "from Ofertas\n"
                    + "where id_oferta = ?");
            st.setInt(1, idOferta);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                int idr = rs.getInt(1);
                String nombre = rs.getString(2);
                Float precio = rs.getFloat(3);

                int comercio = rs.getInt(6);
                String descripcion = rs.getString(7);
                int cantidad = rs.getInt(8);
                String imagen = rs.getString(9);

                rubro rf = new rubro(0, "", true, "", "");
                comercio come = new comercio("", "", "", comercio, true, "", "", rf, "");
                o = new oferta(idr, nombre, cantidad, precio, come, true, "", descripcion,imagen);
            }

            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return o;
    }

    public void EliminarOferta(int id) {
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("update Ofertas set estado = 0 where id_oferta = ? ");
            st.setInt(1, id);

            st.executeUpdate();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //ABM RUBRO 
    public void InsertarRubro(rubro r) {
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("insert into rubros (nombre, estado, descripcion, ruta)values (?,?,?, ?) ");

            st.setString(1, r.getNombre());
            st.setBoolean(2, true);
            st.setString(3, r.getDescripcion());
            st.setString(4, r.getRuta());
            st.executeUpdate();

            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void modificarRubro(rubro r) {
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement pr = conn.prepareStatement("update rubros set nombre = ?, descripcion = ?, ruta = ? where id_rubro = ?");

            pr.setString(1, r.getNombre());
            pr.setString(2, r.getDescripcion());
            pr.setString(3, r.getRuta());
            pr.setInt(4, r.getId());

            pr.executeUpdate();
            pr.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public rubro ObtenerRubro(int idRubro) {
        rubro r = null;
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("select *\n"
                    + "from rubros\n"
                    + "where id_rubro = ? ");
            st.setInt(1, idRubro);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                int idr = rs.getInt(1);
                String nombre = rs.getString(2);
                //boolean estado = rs.getBoolean(3);
                String des = rs.getString(4);
                String ruta = rs.getString(5);

                r = new rubro(idr, nombre, true, des, ruta);
            }

            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return r;
    }

    public void EliminarRubro(int idRubro) {
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement pr = conn.prepareStatement("update rubros set estado = 0 where id_rubro = ? ");

            pr.setInt(1, idRubro);

            pr.executeUpdate();
            pr.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    //ABM COMERCIO 

    public void InsertarComercio(comercio c) {
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("insert into Comercios (nombre, direccion, telefono, estado, redSocial, Informacion, id_rubro, ruta) values (?, ?, ?, ?, ?, ?, ?, ?)");
            st.setString(1, c.getNombre());
            st.setString(2, c.getDireccion());
            st.setString(3, c.getNumero());
            st.setBoolean(4, true);
            st.setString(5, c.getRedSocial());
            st.setString(6, c.getInformacion());
            st.setInt(7, c.getR().getId());
            st.setString(8, c.getRuta());
            st.executeUpdate();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void EliminarComercio(int id) {
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("UPDATE Comercios set estado = 0 where id_comercio = ? ");

            st.setInt(1, id);

            st.executeUpdate();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public comercio ObtenerComercio(int idComercio) {
        comercio c = null;
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("select *\n"
                    + "from comercios\n"
                    + "where id_comercio = ? ");
            st.setInt(1, idComercio);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                int idC = rs.getInt(1);
                String nombre = rs.getString(2);
                String dire = rs.getString(3);
                String telefono = rs.getString(4);

                String red = rs.getString(6);
                String info = rs.getString(7);
                int id_rubro = rs.getInt(8);
                String ruta = rs.getString(9);

                rubro r = new rubro(id_rubro, "", true, "", "");
                c = new comercio(nombre, dire, telefono, idC, true, info, red, r, ruta);
            }

            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return c;
    }

    public void modificarComercio(comercio c) {
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("update Comercios set nombre= ?, direccion = ?, telefono = ?, redSocial= ?, Informacion= ?, id_rubro = ?, ruta = ? where id_comercio = ? ");

            st.setString(1, c.getNombre());
            st.setString(2, c.getDireccion());
            st.setString(3, c.getNumero());
            st.setString(4, c.getRedSocial());
            st.setString(5, c.getInformacion());
            st.setInt(6, c.getR().getId());
            st.setInt(8, c.getComercios_id());
            st.setString(7, c.getRuta());
            st.executeUpdate();
            st.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    //AB RESPUESTAS    
    public void InsertarRespuesta(respuestas r) {
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("insert into Respuestas (descripcion, fecha, id_comentario) values (?, GETDATE(), ?)");
            st.setString(1, r.getDescripcion());
            st.setInt(2, r.getCome().getId_comentarios());

            st.executeUpdate();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void EliminarRTA(int id) {
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("delete from Respuestas where id_rta  = ? ");

            st.setInt(1, id);

            st.executeUpdate();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // AB COMENTARIO 
    public void InsertarComentario(Comentario c) {
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("insert into Comentarios (descripcion, valoracion, fecha, id_comercio, nombreUsuario) values (?, ?, GETDATE(),? , ?)");
            st.setString(1, c.getDescripcion());
            st.setInt(2, c.getValoracion());
            st.setInt(3, c.getC().getComercios_id());
            st.setString(4, c.getNombreUsuario());

            st.executeUpdate();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void EliminarComentario(int id) {
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("delete from Comentarios where id_comentario = ? ");

            st.setInt(1, id);

            st.executeUpdate();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //para combo box
    public ArrayList<rubro> obtenerRubro() {
        ArrayList<rubro> lista = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select id_rubro, nombre, estado from rubros");

            while (rs.next()) // rever 
            {
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                boolean estado = rs.getBoolean(3);

                rubro p = new rubro(id, nombre, estado, "", "");

                lista.add(p);
            }

            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;

    }

    public ArrayList<comercio> listadoComercioMenu() {
        ArrayList<comercio> lista = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("select id_comercio, nombre, direccion, telefono, estado, id_rubro, ruta\n"
                    + "from Comercios ");

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String nombreO = rs.getString(2);
                String direccion = rs.getString(3);
                String telefono = rs.getString(4);
                boolean estado = rs.getBoolean(5);

                int idC = rs.getInt(6);
                String ruta = rs.getString(7);

                rubro r = new rubro(idC, "", true, "", "");
                comercio c = new comercio(nombreO, direccion, telefono, id, estado, "", "", r, ruta);

                lista.add(c);
            }

            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }

    public ArrayList<oferta> listadoOfertaMenu() {
        ArrayList<oferta> lista = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("select o.id_oferta, o.nombre, precio, cantidad, fecha, c.nombre, o.estado, c.id_comercio, o.ruta\n"
                    + "from Ofertas o \n"
                    + "join Comercios c on o.id_comercio = c.id_comercio ");

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int ido = rs.getInt(1);
                String nombreO = rs.getString(2);
                float precio  = rs.getFloat(3);
                int cantidad = rs.getInt(4);
                String fecha = rs.getString(5);
                String nombre = rs.getString(6);
                boolean estado = rs.getBoolean(7);
                int idc = rs.getInt(8);
                String ruta = rs.getString(9);

                rubro r = new rubro(0, "", true, "", "");
                comercio c = new comercio(nombre, "", "" , idc, true, "", "", r, "");
                oferta o = new oferta (ido, nombreO, cantidad, precio, c, estado, "", fecha, ruta); 
                         lista.add(o);
            }

            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }
    public respuestas RespuestaxComentario(int idComentario) {
      respuestas lista = null;
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement(" select r.*\n" +
"from Comentarios c right join Respuestas r on c.id_comentario = r.id_comentario\n" +
"where c.id_comentario = ?");
            st.setInt(1, idComentario);
            
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                int idcomentario = rs.getInt(2);
                String descripcionR = rs.getString(3);
                String fechaR = rs.getString(4);
                
                

                rubro rf = new rubro(0, "", true, "", "");
                comercio come = new comercio("", "", "", 0, true, "", "", rf, "");
                Comentario c = new Comentario(idcomentario, "",0, "", "", come);
                 lista= new respuestas(id, descripcionR, c, fechaR);
              

                
            }

            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }

}
