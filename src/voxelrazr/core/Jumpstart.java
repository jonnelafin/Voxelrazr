/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voxelrazr.core;

import voxelrazr.render.Renderer;

/**
 *
 * @author Elias
 */
public class Jumpstart {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Voxelrazr " + " starting up...");
        
        System.out.println("== INFO ==");
        System.out.println("Voxelrazr version: " + Globals.version);
        System.out.println("Voxelrazr friendly-version: " + Globals.version_friendly);
        System.out.println("");
        System.out.println("Needed JFUtils version: " + Globals.JFUtils_min_ver);
        System.out.println("JFUtils version: " + JFUtils.versionCheck.version);
        if(JFUtils.versionCheck.version != Globals.JFUtils_min_ver){
            JFUtils.versionCheck.throwException("Voxelrazr", Globals.JFUtils_min_ver);
        }
        System.out.println("== /INFO ==");
        
        System.out.println("Creating renderer...");
        Globals.renderer = new Renderer();
        System.out.println("Calling renderer to create window...");
        Globals.renderer.setupWindow();
        System.out.println("Creating logic...");
        Globals.Logic = new Logic();
    }
    
}
