/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacetrader;

import java.util.ArrayList;

/**
 *
 * @author addison
 */
public class Universe extends ArrayList<SolarSystem>
{
    @Override
    public String toString()
    {
        if(!this.isEmpty())
        {
            String out = "[ ( " + this.get(0).toString();
            for(int i = 1; i < this.size(); i++)
            {
                out = out + " ) , ( " + this.get(i).toString();
            }
            out = out + " ) ]";
            return out;
        }
        else
        {
            return "";
        }
    }
}
