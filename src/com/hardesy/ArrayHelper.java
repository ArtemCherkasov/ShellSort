/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hardesy;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author artemcherkasov
 */
public class ArrayHelper implements Runnable{
	private int size;
	private List<Integer> array_list;
	private Random random;
	private Integer max_value = 500;
	private int i_iterator = 0;
	private int j_iterator = 0;

	public ArrayHelper(int size) {
		this.size = size;
		array_list = new ArrayList<Integer>();
		random = new Random();
		for(int i = 0; i < size; ++i){
			array_list.add(random.nextInt(max_value + 1));
		}
	}
	
	public void drawArray(Graphics g, Dimension size){
		//System.out.println(g.getClipBounds().width + " " + g.getClipBounds().height);
		int height = size.height*2/3;
		int factor = 1;
		int max_iterate = this.size;
		double step = (double)size.width/this.size;
		if (step < 1){
			step = 1;
			max_iterate = size.width;
			factor = this.size/size.width;
		}
		for(int i = 0; i < max_iterate; ++i){
			int x = (int)(i*step);
			if (i*factor < this.size)
				g.drawRect(x, height - this.array_list.get(i*factor), 1, this.array_list.get(i*factor));
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int N = array_list.size();
		int h = 1;
		while (h < N/3) {
			h = 3*h + 1;
		}
		int speed_index = 0;
		while (h >= 1) {
			for(int i = h; i < N; ++i){
				for(int j = i; j >= h && (this.array_list.get(j) < this.array_list.get(j - h)); j -= h){

					int v = this.array_list.get(j);
					this.array_list.set(j, this.array_list.get(j - h));
					this.array_list.set(j - h, v);
					
				}
				++speed_index;
				if (speed_index < 5000){
					speed_index = 0;
					sleep();
				}
			}
			h = h/3;
		}
	}
	
	private void sleep(){
		try {
			Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}