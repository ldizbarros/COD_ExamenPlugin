package org.miPlugin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
            Process pr = rt.exec("touch hola.txt");
 
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
            ex.printStackTrace();
        }
    }
}
