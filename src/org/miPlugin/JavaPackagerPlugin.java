package org.miPlugin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "File",
        id = "org.miPlugin.JavaPackagerPlugin"
)
@ActionRegistration(
        iconBase = "org/miPlugin/plus.png",
        displayName = "#CTL_JavaPackagerPlugin"
)
@ActionReference(path = "Toolbars/File", position = 0)
@Messages("CTL_JavaPackagerPlugin=JavaPackager")
public final class JavaPackagerPlugin implements ActionListener {

    /**
     * Funcion actionPerformed donde se llevara a cabo la accion del plugin.
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Runtime rt = Runtime.getRuntime();
           
            String SO = JOptionPane.showInputDialog("Introduce el sistema operativo donde se ejecutara el plugin");
            
            String comando;
            
            if (SO.equalsIgnoreCase("Linux")){
               comando = "javapackager -deploy -native deb -Bcategory=Others -Bicon="+JOptionPane.showInputDialog("Introduce la direccion del icono del plugin")+" -BlicenseType=Propietary -outdir "+JOptionPane.showInputDialog("Introduce la direccion del directorio donde se creara el ejecutable")+" -outfile "+JOptionPane.showInputDialog("Introduce el nombre del ejecutable")+" -srcdir "+JOptionPane.showInputDialog("Introduce la direccion del archivo jar del programa que quieras crear")+" -srcfiles "+JOptionPane.showInputDialog("Introduce el nombre del archivo jar")+" -appclass "+JOptionPane.showInputDialog("Introduce el nombre de la clase principal")+" -name "+JOptionPane.showInputDialog("Introduce el nombre de la aplicacion")+" -title "+JOptionPane.showInputDialog("Introduce el titulo de la aplicacion");
                
            }else{
                comando = "javapackager -deploy -native exe -Bicon="+JOptionPane.showInputDialog("Introduce la direccion del icono del plugin")+" -BlicenseType=Propietary -outdir "+JOptionPane.showInputDialog("Introduce la direccion del directorio donde se creara el ejecutable")+" -outfile "+JOptionPane.showInputDialog("Introduce el nombre del ejecutable")+" -srcdir "+JOptionPane.showInputDialog("Introduce la direccion del archivo jar del programa que quieras crear")+" -srcfiles "+JOptionPane.showInputDialog("Introduce el nombre del archivo jar")+" -appclass "+JOptionPane.showInputDialog("Introduce el nombre de la clase principal")+" -name "+JOptionPane.showInputDialog("Introduce el nombre de la aplicacion")+" -title "+JOptionPane.showInputDialog("Introduce el titulo de la aplicacion");
            }

            Process pr = rt.exec(comando);
 
            BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
 
            String line=null;
 
            while((line=input.readLine()) != null) {
                System.out.println(line);
            }
 
            int exitVal = 0;
            try {
                exitVal = pr.waitFor();
            } catch (InterruptedException ex) {
                Exceptions.printStackTrace(ex);
            }
            System.out.println("Exited with error code "+exitVal);
 
        } catch(IOException ex) {
            System.out.println(e.toString());
        }
        
        JOptionPane.showMessageDialog(null, "El plugin se ha greado con exito!!");
    }
}
