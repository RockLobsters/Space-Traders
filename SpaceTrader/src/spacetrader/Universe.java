/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacetrader;

import java.util.ArrayList;
import java.io.Serializable;

/**
 *
 * @author addison
 */
public class Universe extends ArrayList<SolarSystem> implements Serializable
{
    @Override
    public String toString()
    {
        if(!this.isEmpty())
        {
            String out = "[ ( " + this.get(0).toString();
            for(int i = 1; i < this.size(); i++)
            {
                out = out + " ) ,\n  ( " + this.get(i).toString();
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
        SolarSystem jSystem = new SolarSystem("Judean People's Front", new Theocracy(), 1);
        SolarSystem kSystem = new SolarSystem("Das Kapital", new CapitalistState(), 5);
        SolarSystem lSystem = new SolarSystem("Luder Planets", new Confederacy(), 4);
        SolarSystem mSystem = new SolarSystem("Myrddin Emyrs", new FeudalState(), 2);
        SolarSystem nSystem = new SolarSystem("New Caledonia", new Dictatorship(), 4);
        SolarSystem oSystem = new SolarSystem("Otter Oligopoly", new Corporate(), 6);
        SolarSystem pSystem = new SolarSystem("People's Front of Judea", new Theocracy(), 1);
        SolarSystem qSystem = new SolarSystem("Qi Empire", new Dictatorship(), 5);
        SolarSystem rSystem = new SolarSystem("Rebel Militia", new MilitaryState(), 6);
        SolarSystem sSystem = new SolarSystem("Samsong Galaxy", new Technocracy(), 7);
        SolarSystem tSystem = new SolarSystem("Tutu Tribes", new Anarchy(), 0);
        SolarSystem uSystem = new SolarSystem("Utopia", new Satori(), 0);
        SolarSystem vSystem = new SolarSystem("Volpone Militia", new MilitaryState(), 6);
        SolarSystem wSystem = new SolarSystem("Worlds of Wodehosse", new Monarchy(), 3);
        SolarSystem xSystem = new SolarSystem("Xerxes Democratic Republic", new Democracy(), 2);
        SolarSystem ySystem = new SolarSystem("Yelle", new SocialistState(), 4);
        SolarSystem zSystem = new SolarSystem("Zcousers", new Confederacy(), 3);
        
        Planet aPlanet1 = new Planet("Gatech");
        Planet aPlanet2 = new Planet("Peachtree Planet");
        Planet aPlanet3 = new Planet("Gastate Universe City");
        Planet aPlanet4 = new Planet("Ponce");
        Planet aPlanet5 = new Planet("Turner Station");
        
        Planet[] aPlanets = new Planet[5];
        
        for(Planet aPlanet : aPlanets) {
            aPlanet.setSolarSystem(aSystem);
            //aSystem.addPlanet(aPlanet);
        }
        
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
        
        Planet jPlanet1 = new Planet("Judea");
        jPlanet1.setSolarSystem(jSystem);
        Planet jPlanet2 = new Planet("Bethly");
        jPlanet2.setSolarSystem(jSystem);
        Planet jPlanet3 = new Planet("Hym");
        jPlanet3.setSolarSystem(jSystem);
        
        jSystem.addPlanet(jPlanet1);
        jSystem.addPlanet(jPlanet2);
        jSystem.addPlanet(jPlanet3);
        
        Planet kPlanet1 = new Planet("Freiheit");
        kPlanet1.setSolarSystem(kSystem);
        Planet kPlanet2 = new Planet("Sehnsucht");
        kPlanet2.setSolarSystem(kSystem);
        Planet kPlanet3 = new Planet("Freude");
        kPlanet3.setSolarSystem(kSystem);
        Planet kPlanet4 = new Planet("Schönheit");
        kPlanet4.setSolarSystem(kSystem);
        
        kSystem.addPlanet(kPlanet1);
        kSystem.addPlanet(kPlanet2);
        kSystem.addPlanet(kPlanet3);
        kSystem.addPlanet(kPlanet4);
        
        Planet lPlanet1 = new Planet("Killnaskully");
        lPlanet1.setSolarSystem(lSystem);
        Planet lPlanet2 = new Planet("Billnahinch");
        lPlanet2.setSolarSystem(lSystem);
        Planet lPlanet3 = new Planet("Tippnarary");
        lPlanet3.setSolarSystem(lSystem);
        
        lSystem.addPlanet(lPlanet1);
        lSystem.addPlanet(lPlanet2);
        lSystem.addPlanet(lPlanet3);
        
        Planet mPlanet1 = new Planet("Emrys");
        mPlanet1.setSolarSystem(mSystem);
        Planet mPlanet2 = new Planet("Wylit");
        mPlanet2.setSolarSystem(mSystem);
        Planet mPlanet3 = new Planet("Port Talbot");
        mPlanet3.setSolarSystem(mSystem);
        
        mSystem.addPlanet(mPlanet1);
        mSystem.addPlanet(mPlanet2);
        mSystem.addPlanet(mPlanet3);
        
        Planet nPlanet1 = new Planet("Newkirk");
        nPlanet1.setSolarSystem(nSystem);
        Planet nPlanet2 = new Planet("Dunkirk");
        nPlanet2.setSolarSystem(nSystem);
        Planet nPlanet3 = new Planet("Dundee");
        nPlanet3.setSolarSystem(nSystem);
        
        nSystem.addPlanet(nPlanet1);
        nSystem.addPlanet(nPlanet2);
        nSystem.addPlanet(nPlanet3);
        
        Planet oPlanet1 = new Planet("Clam");
        oPlanet1.setSolarSystem(oSystem);
        Planet oPlanet2 = new Planet("Tummy");
        oPlanet2.setSolarSystem(oSystem);
        
        oSystem.addPlanet(oPlanet1);
        oSystem.addPlanet(oPlanet2);
        
        Planet pPlanet1 = new Planet("People's Judea");
        oPlanet1.setSolarSystem(pSystem);
        Planet pPlanet2 = new Planet("Jeroo");
        oPlanet2.setSolarSystem(pSystem);
        Planet pPlanet3 = new Planet("Salemn");
        pPlanet3.setSolarSystem(pSystem);
        
        pSystem.addPlanet(pPlanet1);
        pSystem.addPlanet(pPlanet2);
        pSystem.addPlanet(pPlanet3);
        
        Planet qPlanet1 = new Planet("Bebesee");
        qPlanet1.setSolarSystem(qSystem);
        Planet qPlanet2 = new Planet("Klaxxon");
        qPlanet2.setSolarSystem(qSystem);
        
        qSystem.addPlanet(qPlanet1);
        qSystem.addPlanet(qPlanet2);
        
        Planet rPlanet1 = new Planet("Brando");
        rPlanet1.setSolarSystem(rSystem);
        Planet rPlanet2 = new Planet("Dean");
        rPlanet2.setSolarSystem(rSystem);
        Planet rPlanet3 = new Planet("Marlon");
        rPlanet3.setSolarSystem(rSystem);
        Planet rPlanet4 = new Planet("Djames");
        rPlanet4.setSolarSystem(rSystem);
        
        rSystem.addPlanet(rPlanet1);
        rSystem.addPlanet(rPlanet2);
        rSystem.addPlanet(rPlanet3);
        rSystem.addPlanet(rPlanet4);
        
        Planet sPlanet1 = new Planet("Nexus");
        sPlanet1.setSolarSystem(sSystem);
        Planet sPlanet2 = new Planet("Tab 2");
        sPlanet2.setSolarSystem(sSystem);
        Planet sPlanet3 = new Planet("S6");
        sPlanet3.setSolarSystem(sSystem);
        
        sSystem.addPlanet(sPlanet1);
        sSystem.addPlanet(sPlanet2);
        sSystem.addPlanet(sPlanet3);
        
        Planet tPlanet1 = new Planet("Fonteyn");
        tPlanet1.setSolarSystem(tSystem);
        Planet tPlanet2 = new Planet("Baryshnikov");
        tPlanet2.setSolarSystem(tSystem);
        Planet tPlanet3 = new Planet("Nureyev");
        tPlanet3.setSolarSystem(tSystem);
        Planet tPlanet4 = new Planet("Bussel");
        tPlanet4.setSolarSystem(tSystem);
        
        tSystem.addPlanet(tPlanet1);
        tSystem.addPlanet(tPlanet2);
        tSystem.addPlanet(tPlanet3);
        tSystem.addPlanet(tPlanet4);
        
        Planet uPlanet1 = new Planet("Eden");
        uPlanet1.setSolarSystem(uSystem);
        Planet uPlanet2 = new Planet("Olympus");
        uPlanet2.setSolarSystem(uSystem);
        Planet uPlanet3 = new Planet("Nirvana");
        uPlanet3.setSolarSystem(uSystem);
        Planet uPlanet4 = new Planet("Valhalla");
        uPlanet4.setSolarSystem(uSystem);
        
        uSystem.addPlanet(uPlanet1);
        uSystem.addPlanet(uPlanet2);
        uSystem.addPlanet(uPlanet3);
        uSystem.addPlanet(uPlanet4);
        
        Planet vPlanet1 = new Planet("Volpone");
        vPlanet1.setSolarSystem(vSystem);
        Planet vPlanet2 = new Planet("Mosca");
        vPlanet2.setSolarSystem(vSystem);
        Planet vPlanet3 = new Planet("Voltore");
        vPlanet3.setSolarSystem(vSystem);
        Planet vPlanet4 = new Planet("Corbaccio");
        vPlanet4.setSolarSystem(vSystem);
        
        vSystem.addPlanet(vPlanet1);
        vSystem.addPlanet(vPlanet2);
        vSystem.addPlanet(vPlanet3);
        vSystem.addPlanet(vPlanet4);
        
        Planet wPlanet1 = new Planet("Threepwood");
        wPlanet1.setSolarSystem(wSystem);
        Planet wPlanet2 = new Planet("Wooster");
        wPlanet2.setSolarSystem(wSystem);
        Planet wPlanet3 = new Planet("Twistleton");
        wPlanet3.setSolarSystem(wSystem);
        
        wSystem.addPlanet(wPlanet1);
        wSystem.addPlanet(wPlanet2);
        wSystem.addPlanet(wPlanet3);
        
        Planet xPlanet1 = new Planet("Serses");
        xPlanet1.setSolarSystem(xSystem);
        Planet xPlanet2 = new Planet("Atriedes");
        xPlanet2.setSolarSystem(xSystem);
        Planet xPlanet3 = new Planet("Plutarch");
        xPlanet3.setSolarSystem(xSystem);
        
        xSystem.addPlanet(xPlanet1);
        xSystem.addPlanet(xPlanet2);
        xSystem.addPlanet(xPlanet3);
        
        Planet yPlanet1 = new Planet("Yelle");
        yPlanet1.setSolarSystem(ySystem);
        Planet yPlanet2 = new Planet("Grand Marnier");
        yPlanet2.setSolarSystem(ySystem);
        Planet yPlanet3 = new Planet("Tepr");
        yPlanet3.setSolarSystem(ySystem);
        
        ySystem.addPlanet(yPlanet1);
        ySystem.addPlanet(yPlanet2);
        ySystem.addPlanet(yPlanet3);
        
        Planet zPlanet1 = new Planet("Jhon");
        zPlanet1.setSolarSystem(zSystem);
        Planet zPlanet2 = new Planet("Pall");
        zPlanet2.setSolarSystem(zSystem);
        Planet zPlanet3 = new Planet("Geo");
        zPlanet3.setSolarSystem(zSystem);
        Planet zPlanet4 = new Planet("Ringo");
        
        zSystem.addPlanet(zPlanet1);
        zSystem.addPlanet(zPlanet2);
        zSystem.addPlanet(zPlanet3);
        zSystem.addPlanet(zPlanet4);

        this.add(aSystem);
        this.add(bSystem);
        this.add(cSystem);
        this.add(dSystem);
        this.add(eSystem);
        this.add(fSystem);
        this.add(gSystem);
        this.add(hSystem);
        this.add(iSystem);
    }
}
