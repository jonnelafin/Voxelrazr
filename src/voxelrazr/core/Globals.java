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

package voxelrazr.core;

import java.util.HashMap;

/**
 *
 * @author Jonnelafin
 */
public class Globals {
    //Change these
    public static final int version = 20200729;
    public static final String version_friendly = "dev 0.0";
    
    //JFUtils
    public static final double JFUtils_min_ver = 3.5;
    
    //Window, Logic, Renderer
    public static voxelrazr.core.Graphics.Renderer renderer;
    public static voxelrazr.core.Logic Logic;
    
    //Logger
    public static voxelrazr.core.logging.Logger l = new Logger();
    
    //Graphics
    public static int window_default_w = 500;
    public static int window_default_h = 500;
    
    //Input
    public static Input input = new Input();
    
    //Custom
    public static HashMap<String, Object> custom;
    public static HashMap<String, Object> custom_graphics;
}
