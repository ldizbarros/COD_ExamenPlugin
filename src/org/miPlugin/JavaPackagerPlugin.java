/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.miPlugin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
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

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
    }
}
