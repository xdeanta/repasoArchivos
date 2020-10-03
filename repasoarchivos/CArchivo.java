/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasoarchivos;

import java.io.File;

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
    
    public static void crearDirectorio(String path){
        File f;
        f=new File(path);
        if(f.isAbsolute()){
            if(f.exists()){
                System.out.println("El directorio ya existe");
            }else{
                f.mkdir();
            }
        }
    }
}
