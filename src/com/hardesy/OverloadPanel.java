/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hardesy;

import java.awt.Graphics;
import javax.swing.JPanel;


/**
 *
 * @author artemcherkasov
 */
public class OverloadPanel extends JPanel{
	private ArrayHelper array_helper;

	public void setArrayHelper(ArrayHelper array_helper) {
		this.array_helper = array_helper;
	}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
		this.array_helper.drawArray(g, this.getSize());
		//System.out.println(this.getSize().width + " " + this.getSize().height);
		//this.gets
    }
	
}