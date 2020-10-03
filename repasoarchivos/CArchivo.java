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
}
