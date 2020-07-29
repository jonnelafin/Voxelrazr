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

package voxelrazr.core.math;

import JFUtils.point.Point3D;

/**
 *
 * @author Jonnelafin
 */
public class Points {
    public static Point3D abs(Point3D p){
        return new Point3D(Math.abs(p.x), Math.abs(p.y), Math.abs(p.z));
    }
    public static Point3D min(Point3D p, Point3D m){
        return new Point3D(Math.min(p.x, m.x), Math.min(p.y, m.y), Math.min(p.z, m.z));
    }
    public static Point3D max(Point3D p, Point3D m){
        return new Point3D(Math.max(p.x, m.x), Math.max(p.y, m.y), Math.max(p.z, m.z));
    }
    public static double lenght(Point3D p){
        return Math.sqrt( Math.pow(p.x, 2) + Math.pow(p.y, 2) + Math.pow(p.z, 2) );
    }
    
    public static void main(String[] args) {
        System.out.println("Len 2,2,2: " + lenght(new Point3D(2)));
        System.out.println("Len 2,2,0: " + lenght(new Point3D(2,2,0)));
        System.out.println("Len 2,0,0: " + lenght(new Point3D(2,0,0)));
    }
}
