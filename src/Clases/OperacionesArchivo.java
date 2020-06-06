/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class OperacionesArchivo {

    String path = "C:\\Users\\ivanr\\Documents\\NetBeansProjects\\S2B-programacion\\5.- Archivos\\TareaArchivos2\\archivos";

    public OperacionesArchivo() {
        File archivo = new File("archivos/archivo.txt");
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                System.out.println("Archivo creado");

            } catch (IOException e) {
                System.out.println(e);
            }
        } else {
            System.out.println("Archivo ya existente");
        }
    }

    public void CrearProducto(Producto producto) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("archivos/archivo.txt", true));

            bw.write(
                    producto.getClaveProducto() + "," + producto.getNombreProducto() + ","
                    + producto.getDescripcion() + "," + producto.getHechoEn() + ","
                    + producto.getPrecioCompra() + "," + producto.getPrecioVenta() + "," + producto.getCompañiaFabricacion()
            );
            bw.flush();
            bw.newLine();
            bw.close();
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    public List<Producto> getProductos() {
        List<Producto> productos = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("archivos/archivo.txt"));
            String record;

            while ((record = br.readLine()) != null) {

                StringTokenizer st = new StringTokenizer(record, ",");

                String value1 = st.nextToken();
                String value2 = st.nextToken();
                String value3 = st.nextToken();
                String value4 = st.nextToken();
                String value5 = st.nextToken();
                String value6 = st.nextToken();
                String value7 = st.nextToken();

                Producto producto = new Producto(value1,
                        value2,
                        value3,
                        value4,
                        Double.parseDouble(value5),
                        Double.parseDouble(value6),
                        value7);

                productos.add(producto);
            }

            br.close();
        } catch (Exception e) {
            System.err.println(e);
        }

        return productos;
    }

    public void BorrarProductoByClave(String claveProducto) {

        String record;

        File newFile = new File("archivos/archivo_temp.txt");
        File file = new File("archivos/archivo.txt");
        try {

            BufferedReader br = new BufferedReader(new FileReader(file));
            BufferedWriter bw = new BufferedWriter(new FileWriter(newFile));

            while ((record = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(record, ",");
                String value1;

                value1 = st.nextToken();

                if (value1.equals(claveProducto)) {
                    continue;
                }

                bw.write(record);
                bw.flush();
                bw.newLine();
            }
            br.close();
            bw.close();
        } catch (Exception e) {
            System.err.println(e);
        }

        //delete file
        if (file.delete()) {
            System.out.println("Archivo borrado");
        } else {
            System.err.println("Error al borrar usuario");
        }
        boolean success = newFile.renameTo(file);

        if (!success) {
            System.err.println("File was not renamed");
        }
    }

    public Producto buscarProductoByClave(String claveProducto) {
        String record;
        Producto producto = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader("archivos/archivo.txt"));
            while ((record = br.readLine()) != null) {

                StringTokenizer st = new StringTokenizer(record, ",");
                String clave = st.nextToken();
                if (clave.equals(claveProducto)) {
                    String value1 = st.nextToken();
                    String value2 = st.nextToken();
                    String value3 = st.nextToken();
                    String value4 = st.nextToken();
                    String value5 = st.nextToken();
                    String value6 = st.nextToken();
                    String value7 = st.nextToken();

                    producto = new Producto(value1,
                            value2,
                            value3,
                            value4,
                            Double.parseDouble(value5),
                            Double.parseDouble(value6),
                            value7);

                }
            }
            br.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return producto;
    }

    public void ActualizarProductoByClave(Producto producto) {
        String record, record2;
        

        File file = new File("archivos/archivo.txt");
        File newFile = new File("archivos/archivo_temp.txt");
        String value1 = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            BufferedWriter bw = new BufferedWriter(new FileWriter(newFile));

            while ((record = br.readLine()) != null) {

                StringTokenizer st = new StringTokenizer(record, ",");
                value1 = st.nextToken();
                
                if (value1.equals(producto.getClaveProducto())) {
                    System.out.println(st.nextToken() + st.nextToken() + st.nextToken() + st.nextToken());
                } else {
                }

            }
            System.out.println("|	                                            	          |");
            System.out.println(" ------------------------------------------------------------- ");

            br.close();
            
            BufferedReader br2 = new BufferedReader(new FileReader(file));
            

            while ((record2 = br2.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(record2, ",");
                value1 = st.nextToken();
                if (value1.equals(producto.getClaveProducto())) {
                    bw.write(
                        producto.getClaveProducto() + "," + producto.getNombreProducto() + ","
                        + producto.getDescripcion() + "," + producto.getHechoEn() + ","
                        + producto.getPrecioCompra() + "," + producto.getPrecioVenta() + "," + producto.getCompañiaFabricacion()
                    );
                } else {
                    bw.write(record2);
                }
                bw.flush();
                bw.newLine();
            }

            bw.close();
            br2.close();
        } catch (Exception e) {
            System.err.println("Operaciones Archivo:  "+e);
        }
        file.delete();
        boolean success = newFile.renameTo(file);
        System.out.println(success);

    }
}
