
/* 
 * PathName represents a Path and Name to an image
 * 
 * CPSC 224-02, Spring 2018
 * Final Project
 * 
 * @author Maxwell Chehab 
 *
 * @version v1.0 5/02/18 
 */

package com.yahtzee.components;

public class PathName {
    public final String path;
    public final String name;

    /*
     * PathName creates a pathname from a given path and name
     * 
     * @param String path, String name
     * 
     * @returns void
     * 
     * @throw null
     */
    public PathName(String path, String name) {
        this.path = path;
        this.name = name;
    }

    /*
     * getPath returns the PathName's path
     * 
     * @param null
     * 
     * @returns String
     * 
     * @throw null
     */
    public String getPath() {
        return path;
    }

    /*
     * getname returns the PathName's name
     * 
     * @param null
     * 
     * @returns String
     * 
     * @throw null
     */
    public String getName() {
        return path;
    }
}