/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasoarchivos;

import java.util.Scanner;

/**
 *
 * @author Xavier
 */
public class RepasoArchivos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc;
        String path,nomb;
        sc=new Scanner(System.in);
        System.out.println("Introducir una ruta absoluta:");
        path=sc.nextLine();
        if(CArchivo.esDirectorio(path)){
            System.out.println("Es directorio");
        }else{
            System.out.println("No es directorio");
        }
        if(CArchivo.esArchivo(path)){
            System.out.println("Es Archivo");
        }else{
            System.out.println("No es Archivo");
        }
        System.out.println("------------------");
        System.out.println("crear directorios y archivos");
        System.out.println("Introducir una direccion para crear un directorio");
        path=sc.nextLine();
        if(CArchivo.crearDirectorio(path)){
            System.out.println("Directorio creado");
        }else{
            System.out.println("Directorio no creado");
        }
        System.out.println("Introducir nombre del nuevo archivo");
        nomb=sc.nextLine();
        if(CArchivo.crearArchivo(path, nomb)){
            System.out.println("Archivo creado");
        }else{
            System.out.println("Archivo no creado");
        }
        
        System.out.println("------------------");
        System.out.println("permisos a archivos");
        System.out.println("Introducir un path absoluto:");
        path=sc.nextLine();
        System.out.println("Introducir nombre del archivo");
        nomb=sc.nextLine();
        System.out.println("Permisos inicial");
        CArchivo.modoAcceso(path, nomb);
        System.out.println("mLectura:");
        CArchivo.mLectura(path, nomb);
        System.out.println("Permisos despues mLectura");
        CArchivo.modoAcceso(path, nomb);
        System.out.println("mEscritura:");
        CArchivo.mEscritura(path, nomb);
        System.out.println("Permisos mEscritura");
        CArchivo.modoAcceso(path, nomb);
        System.out.println("Tamano: " + CArchivo.calcularLongitud(path, nomb));
        
        System.out.println("-----Borrar Archivo-----");
        System.out.println("Introducir una direccion:");
        path=sc.nextLine();
        System.out.println("Introducir nombre del archivo");
        nomb=sc.nextLine();
        CArchivo.borrarArchivo(path, nomb);
        CArchivo.mostrarDirectorio(path);
        CArchivo.borrarDirectorio(path);
    }
}
