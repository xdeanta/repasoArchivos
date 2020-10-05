/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasoarchivos;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Xavier
 */
public class CArchivo {
    public static boolean esDirectorio(String path){   
        File f;
        boolean dir=false;
        f=new File(path);
        if(f.isAbsolute()){
            dir=f.isDirectory();
        }
        return dir;
    }
    
    public static boolean esArchivo(String path){
        File f;
        boolean isFile=false;
        f=new File(path);
        if(f.isAbsolute()){
            isFile=f.isFile();
        }
        return isFile;
    }
    
    public static boolean crearDirectorio(String path){
        File f;
        boolean creado=false;
        f=new File(path);
        if(f.isAbsolute()){
            if(f.exists()){
                System.out.println("El directorio ya existe");
            }else{
                creado=f.mkdir();
            }
        }
        return creado;
    }
    
    public static boolean crearArchivo(String path, String nombre){
        File pFile, nomb;
        boolean creado=false;
        pFile=new File(path);
        if(pFile.exists() && pFile.isDirectory()){
            nomb=new File(path + File.separator + nombre);
            if(nomb.exists()){
                System.out.println("El archivo ya existe");
            }else{
                try{
                    creado=nomb.createNewFile();
                }catch(IOException e){
                    System.out.println("Hubo un error al crear el archivo");
                }
            }
        }
        return creado;
    }
    public static void modoAcceso(String path, String Nombre){
        File fpath, fnomb;
        fpath=new File(path);
        if(fpath.exists() && fpath.isDirectory()){
            fnomb=new File(path + File.separator + Nombre);
            if(fnomb.exists() && fnomb.isFile()){
                System.out.print("Lectura:");
                if(fnomb.canRead()){
                    System.out.println(" SI");
                }else{
                    System.out.println(" NO");
                }
                System.out.print("Escritura:");
                if(fnomb.canWrite()){
                    System.out.println(" SI");
                }else{
                    System.out.println(" NO");
                }
            }
        }
    }
    
    public static void mLectura(String path, String Nombre){
        File fpath, fnomb;
        fpath=new File(path);
        if(fpath.exists() && fpath.isDirectory()){
            fnomb=new File(path + File.separator + Nombre);
            if(fnomb.exists() && fnomb.isFile()){
                if(fnomb.setReadOnly()){
                    System.out.println(fnomb.getName() + " Es de solo lectura");
                }
            }
        }
    }
    
    public static void mEscritura(String path, String Nombre){
        File fpath, fnomb;
        fpath=new File(path);
        if(fpath.exists() && fpath.isDirectory()){
            fnomb=new File(path + File.separator + Nombre);
            if(fnomb.exists() && fnomb.isFile()){
                if(!fnomb.canWrite()){
                    if(fnomb.setWritable(true)){
                        System.out.println(fnomb.getName() + " Se puede escribir");
                    }
                }else{
                    System.out.println("Ya tiene permiso de escritura");
                }
            }
        }
    }
    
    public static void borrarArchivo(String path, String nombre){
        File pFile, nomb;
        pFile=new File(path);
        if(pFile.exists() && pFile.isDirectory()){
            nomb=new File(path + File.separator + nombre);
            if(nomb.exists()){
                if(nomb.delete()){
                    System.out.println("Archivo Borrado");
                }
            }else{
                System.out.println("El archivo no existe");
            }
        }
    }
    public static void mostrarDirectorio(String path){
        File pDir;
        //String nomb;
        pDir=new File(path);
        if(pDir.exists() && pDir.isDirectory()){
            for(String nomb : pDir.list()){
                System.out.println(nomb);
            }
        }
    }
    
    public static void borrarDirectorio(String path){
        File pDir;
        //String nomb;
        pDir=new File(path);
        if(pDir.exists() && pDir.isDirectory()){
            if(pDir.delete()){
                System.out.println("Directorio borrado");
            }
        }
    }
    
    public static long calcularLongitud(String path, String Nombre){
        File pDir, fnomb;
        long tam=-1;
        pDir=new File(path);
        if(pDir.exists() && pDir.isDirectory()){
            fnomb=new File(path + File.separator + Nombre);
            if(fnomb.exists() && fnomb.isFile()){
                tam=fnomb.length();
            }
        }
        return tam;
    }
}
