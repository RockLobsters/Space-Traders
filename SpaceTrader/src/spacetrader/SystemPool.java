/*
 * Copyright (C) 2014 Kristen Lawrence
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package spacetrader;

/**
 *
 * @author Kristen Lawrence
 */
public enum SystemPool {

    A("Atlantia", 1, 6),
    B("Bardic Kingdom", 11, 2),
    C("Cyber Alliance", 5, 7),
    D("Disney System", 8, 3),
    E("Engles Union", 2, 4),
    F("Filigree Ltd.", 4, 5),
    G("Golding Barrier Rim", 0, 0),
    H("Hippee Settlements", 12, 1),
    I("iGalaxy", 15, 7),
    J("Judean People's Front", 16, 1),
    K("Kapital", 1, 3),
    L("Luder Planets", 3, 3),
    M("Mrydyn Cymru", 9, 2),
    N("New Caledonia", 7, 4),
    O("Otter Oligopoly", 4, 6),
    P("People's Front of Judea", 16, 1),
    Q("QI Panel Empire", 7, 5),
    R("Retrofuturistic Battle Corp", 10, 6),
    S("Samsong Galaxy", 15, 7),
    T("Tutt tribes", 0, 0),
    U("Utopia", 14, 0),
    V("Volpone Militia", 10, 3),
    W("Worlds of Wodehouse", 11, 3),
    X("Xerxes Democratic Republic", 6, 2),
    Y("Yelle", 13, 4),
    Z("Zcousers", 3, 3);
    String name;
    int govType;
    int techLevel;
    boolean highLevel = false;

    SystemPool(String name, int govType, int techLevel) {
        this.name = name;
        this.govType = govType;
        this.techLevel = techLevel;
        if (techLevel >= 4) {
            highLevel = true;
        }
    }
}
