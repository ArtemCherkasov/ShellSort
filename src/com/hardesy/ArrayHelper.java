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
	private Integer max_value = 300;
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
		double step = (double)size.width/this.size;
		for(int i = 0; i < this.size; ++i){
			int x = (int)(i*step);
			g.drawRect(x, height - this.array_list.get(i), 1, this.array_list.get(i));
		}
	}
	
	public void bubbleSortStep(){
		
		if (this.i_iterator < this.size){
			//System.out.println("---");
			//this.array_list.set(i_iterator, this.array_list.get(i_iterator)/2);
			if(this.array_list.get(i_iterator) < this.array_list.get(j_iterator)){
				int v = this.array_list.get(i_iterator);
				this.array_list.set(i_iterator, this.array_list.get(j_iterator));
				this.array_list.set(j_iterator, v);
				
			}
			++j_iterator;
				//System.out.println(j_iterator);
				if (j_iterator > i_iterator){
					++i_iterator;
					j_iterator = 0;
				}
		}
	}
	
	public void bubbleSort(){
		
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < this.size; ++i){
			for(int j = 0; j < i; ++j){
				if(this.array_list.get(i) < this.array_list.get(j)){
					int v = this.array_list.get(i);
					this.array_list.set(i, this.array_list.get(j));
					this.array_list.set(j, v);
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}