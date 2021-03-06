/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paint;

import java.awt.Color;
import java.awt.Graphics;


/**
 *
 * @author Nick and Kendra
 */
public class Ellipse extends Shape
{
    protected int x1, y1 ,width , height;
 
    public Ellipse()
    {
        x1 = 0;
        y1 = 0;
        width = 0;
        height = 0;
    }
    public Ellipse( int x1, int y1, int x2, int y2, Color fillColor)
    {
        //user gives upper left hand corner first
        if( x1 < x2 && y1 < y2)
        {
            this.x1 = x1;
            this.y1 = y1;
            this.width = x2-x1;
            this.height = y2-y1;
        }
        
        //user gives lower right hand corner first
        else if (x1 > x2 && y1 > y2 )
        {
            this.x1 = x2;
            this.y1 = y2;
            this.width = x1-x2;
            this.height = y1-y2;
        }
        
        //user gives upper right hand corner first
        else if(x1 > x2 && y1 < y2)
        {
            this.x1 = x2;
            this.y1 = y1;
            this.width = x1 - x2;
            this.height = y2 - y1;
        }
        
        //user gives lower left hand corner first
        else if(x1 < x2 && y1 > y2)
        {
            this.x1 = x1;
            this.y1 = y2;
            this.width = x2 - x1;
            this.height = y1 - y2;           
        }
        
        this.name = "Ellispe";
        this.fillColor = fillColor;
        findCenter();
    }
    protected void draw( Graphics g)
    {
        super.paintComponent(g);
        g.setColor( fillColor );
        g.drawOval(x1,y1,width,height);
    }
    
    public String toString()
    {
        return "shape: "+ name + " (" + x1 + "," + y1 + ") & (" + width + "," + height + ")" ;
    }
    
    public void move(int newx, int newy)
    {           
        //set new x and y values
        x1 = newx - width/2;
        y1 = newy - height/2;    
    }
    

    protected void findCenter()
    {
        this.centerx = x1 + width/2;
        this.centery = y1 + height/2;    
    }
}
