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
    
    public void bigBang()
    {
        // ...:::  Put the instantiation code here  :::...
        SolarSystem aSystem = new SolarSystem("Atlantia", new CapitalistState(), 6);
        SolarSystem bSystem = new SolarSystem("Bardic Kingdom", new Monarchy(), 2);
        SolarSystem cSystem = new SolarSystem("Cyber Alliance", new Cybernetic(), 7);
        SolarSystem dSystem = new SolarSystem("Disney System", new FacistState(), 3);
        SolarSystem eSystem = new SolarSystem("Engles Union", new CommunistState(), 4);
        SolarSystem fSystem = new SolarSystem("FamCo Ltd", new Corporate(), 5);
        SolarSystem gSystem = new SolarSystem("Golding Barrier Rim", new Anarchy(), 0);
        SolarSystem hSystem = new SolarSystem("Hipee Settlements", new PacifistState(), 1);
        SolarSystem iSystem = new SolarSystem("iGalaxy", new Technocracy(), 7);
        
        Planet aPlanet1 = new Planet("Gatech");
        aPlanet1.setSolarSystem(aSystem);
        Planet aPlanet2 = new Planet("Peachtree Planet");
        aPlanet2.setSolarSystem(aSystem);
        Planet aPlanet3 = new Planet("Gastate Universe City");
        aPlanet3.setSolarSystem(aSystem);
        Planet aPlanet4 = new Planet("Ponce");
        aPlanet4.setSolarSystem(aSystem);
        
        aSystem.addPlanet(aPlanet1);
        aSystem.addPlanet(aPlanet2);
        aSystem.addPlanet(aPlanet3);
        aSystem.addPlanet(aPlanet4);
        
        Planet bPlanet1 = new Planet("Elsinor");
        bPlanet1.setSolarSystem(bSystem);
        Planet bPlanet2 = new Planet("Verona");
        bPlanet2.setSolarSystem(bSystem);
        Planet bPlanet3 = new Planet("Titus");
        bPlanet3.setSolarSystem(bSystem);
        Planet bPlanet4 = new Planet("The Scottish Planet");
        bPlanet4.setSolarSystem(bSystem);
        
        bSystem.addPlanet(bPlanet1);
        bSystem.addPlanet(bPlanet2);
        bSystem.addPlanet(bPlanet3);
        bSystem.addPlanet(bPlanet4);
        
        Planet cPlanet1 = new Planet("Asmio");
        cPlanet1.setSolarSystem(cSystem);
        Planet cPlanet2 = new Planet("Hein-Lein");
        cPlanet2.setSolarSystem(cSystem);
        Planet cPlanet3 = new Planet("Pohl");
        cPlanet3.setSolarSystem(cSystem);
        
        cSystem.addPlanet(cPlanet1);
        cSystem.addPlanet(cPlanet2);
        cSystem.addPlanet(cPlanet3);
        
        Planet dPlanet1 = new Planet("Disney Planet");
        dPlanet1.setSolarSystem(dSystem);
        Planet dPlanet2 = new Planet("Disney Resort");
        dPlanet2.setSolarSystem(dSystem);
        
        dSystem.addPlanet(dPlanet1);
        dSystem.addPlanet(dPlanet2);
        
        Planet ePlanet1 = new Planet("Marx Prime");
        ePlanet1.setSolarSystem(eSystem);
        Planet ePlanet2 = new Planet("People's Republic of Shina");
        ePlanet2.setSolarSystem(eSystem);
        Planet ePlanet3 = new Planet("Republic of Kuba");
        ePlanet3.setSolarSystem(eSystem);
        Planet ePlanet4 = new Planet("Goryeo");
        ePlanet4.setSolarSystem(eSystem);
        
        eSystem.addPlanet(ePlanet1);
        eSystem.addPlanet(ePlanet2);
        eSystem.addPlanet(ePlanet3);
        eSystem.addPlanet(ePlanet4);
        
        Planet fPlanet1 = new Planet("FamCo HQ");
        fPlanet1.setSolarSystem(fSystem);
        Planet fPlanet2 = new Planet("FamCo Moon Branch");
        fPlanet2.setSolarSystem(fSystem);
        Planet fPlanet3 = new Planet("FamCo Sattelite Branch");
        fPlanet3.setSolarSystem(fSystem);
        Planet fPlanet4 = new Planet("FamCo Warehouse");
        fPlanet4.setSolarSystem(fSystem);
        
        fSystem.addPlanet(fPlanet1);
        fSystem.addPlanet(fPlanet2);
        fSystem.addPlanet(fPlanet3);
        fSystem.addPlanet(fPlanet4);
        
        Planet gPlanet1 = new Planet("Castle Rock");
        gPlanet1.setSolarSystem(gSystem);
        Planet gPlanet2 = new Planet("Lotf");
        gPlanet2.setSolarSystem(gSystem);
        Planet gPlanet3 = new Planet("The Island");
        gPlanet3.setSolarSystem(gSystem);
        
        gSystem.addPlanet(gPlanet1);
        gSystem.addPlanet(gPlanet2);
        gSystem.addPlanet(gPlanet3);
        
        Planet hPlanet1 = new Planet("Peace");
        hPlanet1.setSolarSystem(hSystem);
        Planet hPlanet2 = new Planet("Flower");
        hPlanet2.setSolarSystem(hSystem);
        Planet hPlanet3 = new Planet("Dove");
        hPlanet3.setSolarSystem(hSystem);
        Planet hPlanet4 = new Planet("Peta");
        hPlanet4.setSolarSystem(hSystem);
        
        hSystem.addPlanet(hPlanet1);
        hSystem.addPlanet(hPlanet2);
        hSystem.addPlanet(hPlanet3);
        hSystem.addPlanet(hPlanet4);
        
        Planet iPlanet1 = new Planet("iPlanet 1");
        iPlanet1.setSolarSystem(iSystem);
        Planet iPlanet2 = new Planet("iPlanet 2");
        iPlanet2.setSolarSystem(iSystem);
        Planet iPlanet3 = new Planet("iPlanet 3");
        iPlanet3.setSolarSystem(iSystem);
        Planet iPlanet4 = new Planet("iPlanet 4");
        iPlanet4.setSolarSystem(iSystem);
        Planet iPlanet5 = new Planet("iPlanet 5");
        iPlanet5.setSolarSystem(iSystem);
        
        iSystem.addPlanet(iPlanet1);
        iSystem.addPlanet(iPlanet2);
        iSystem.addPlanet(iPlanet3);
        iSystem.addPlanet(iPlanet4);
        iSystem.addPlanet(iPlanet5);
    }
}
