/*
 * The MIT License
 *
 * Copyright 2020 Arno Elias Eskelinen.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package voxelrazr.render;

import JFUtils.Input;
import JFUtils.InputActivated;
import JFUtils.Range;
import JFUtils.point.Point3D;
import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Math.abs;
import java.util.HashMap;
import javax.swing.JPanel;
import voxelrazr.core.Globals;
import static voxelrazr.core.Globals.l;
import voxelrazr.core.logging.logStatus;
import static voxelrazr.render.Distance.box;

/**
 *
 * @author Jonnelafin
 */
public class Renderer extends JPanel implements voxelrazr.core.Graphics.Renderer{

    private Window window;

    int w = Globals.window_default_w;
    int h = Globals.window_default_h;
    int pixelsize = 12; 
    
    
    Input inp;
    
    public Renderer() {
        //Set the jpanel to be double buffered
        setDoubleBuffered(true);
    }
    
    
    @Override
    public void setupWindow(String windowName) {

        System.out.println(this.hashCode() + " setting up window...");
        window = new Window(true, this, windowName);      
        
        System.out.println("Setting up window input...");
        inp = new Input(new InputActivated());
        inp.addListener(Globals.input);
        //inp.verbodose = true;
        addMouseListener(inp);
        addMouseWheelListener(inp);
        addMouseMotionListener(inp);
        
        addKeyListener(inp);
        requestFocusInWindow();
    }

    @Override
    public boolean isWindowSet() {
        return window != null;
    }

    @Override
    public Object getWindow() {
        return window;
    }

    @Override
    public String getWindowType() {
        return "JFrame";
    }

    Point3D pos = new Point3D(Globals.window_default_w/2, w, w);
    Point3D nextpos = new Point3D();
    
    HashMap<String, Float[]> image;
    HashMap<String, Float[]> nextimage;
    
    private boolean vsync = true;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        repaint();
        
        w = getWidth();
        h = getHeight();
        
        g.setColor(Color.black);
        g.fillRect(0, 0, w, h);
        
        //g.setColor(Color.white);
        //g.fillRect((int) pos.x, 0, 30, 30);
        
        if(image != null){
            for(int y : new Range(h/pixelsize)){
                for(int x : new Range(w/pixelsize)){
                    try {
                        float val = image.get(y + "." + x)[0];
                        val = (float) Math.min(1.0, val);
                        val = (float) Math.max(0.0, val);
                        float val2 = image.get(y + "." + x)[1];
                        val2 = (float) Math.min(1.0, val2);
                        val2 = (float) Math.max(0.0, val2);
                        float val3 = image.get(y + "." + x)[2];
                        val3 = (float) Math.min(1.0, val3);
                        val3 = (float) Math.max(0.0, val3);
                        
                        g.setColor(new Color(val, val2, val3));
                        g.fillRect(x * pixelsize, y * pixelsize, pixelsize, pixelsize);
                    } catch (NullPointerException e) {
                    }
                }
            }
        }
        
        //Update parameters
        if(vsync){
            pos = Point3D.divide(nextpos, new Point3D(pixelsize));
            image = nextimage;
            render();
        }
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateContent(Point3D pos) {
        vsync = false;
        nextpos = pos;
        vsync = true;
    }
    
    boolean rendered = false;
    void render(){
        nextimage = new HashMap<>();
        for(int y : new Range(h/pixelsize)){
            for(int x : new Range(w/pixelsize)){
                //Ideally from 0 to 1
                float value = 0F;
                float value2 = 0F;
                value = (float) (x - pos.x)/20;
                value2 = (float) (y - pos.y)/20;
                
                float value3 = value * value2;
                nextimage.put(y + "." + x, new Float[]{value, value2, value3});
                
                if(!rendered){
                    rendered = false;
                    float valuez = castray(new Point3D(x, y, 0), new Point3D(0, 0, 1));
                    nextimage.put(y + "." + x, new Float[]{valuez, valuez, valuez});
                }
            }
        }
    }
    
    int ray_maxSteps = 200;
    float ray_minDist = .5F;
    Point3D ray_target = new Point3D(Globals.window_default_w, Globals.window_default_h, 10);
    float castray(Point3D from, Point3D dir){
        Point3D dir2 = new Point3D();
        if(!(dir.x < 1)){
            dir2.x = 1;
        }
        if(!(dir.y < 1)){
            dir2.y = 1;
        }
        if(!(dir.z < 1)){
            dir2.z = 1;
        }
        //l.log("Normalized toward dir: " + dir2, logStatus.INFO);
        
        float result = 0;
        Point3D pos = Point3D.add(from, new Point3D());
        for(int i : new Range(ray_maxSteps)){
            double min = 0;
            Point3D offset = Point3D.add(pos, new Point3D(-this.pos.x, -this.pos.y, 0));
            //min = box(offset, new Point3D(1));
            min = Distance.sphere(offset, 5F);
            if(abs(min) < ray_minDist){
                result = i/5.0F;
                //System.out.println(i);
                break;
            }
            pos = Point3D.add(pos, dir2);
        }
        return result;
    }
    
}
