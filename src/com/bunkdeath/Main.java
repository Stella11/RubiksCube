/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bunkdeath;

import com.bunkdeath.cube.RubikCube;

/**
 *
 * @author root
 */
public class Main {

    public static void main(String[] args) {

        String config = "";
        config = "ywbyyrogwgobbgwrrbyoororwbogbwgbggbrrorwryggyooyywwbyw";
        config = "bwbgyogbyowrogrobbwyrgoowbogbwybywgbrrygrwyyyowgrwogrr";
        config = "boooyobbywgwggrgbyrwobowrgrbyyrbggoogwowrywyybrwywbrrg";

        config = "booyywoygrrbogwwggybrgowoobwrybboybrgwwyrbygbwgrrwroyg";
        config = "wobgywywrryobgworrbrbgoryoowoogbbgybwbgrrwyogggyywbwyr";

        config = "goywyggbgwooybbrgryrwwryyrbowoogrwbybbrgogrrbgyoowywwb";


        config = "yoygyyyyygygggggggobooooooobrbbbbbbbryrrrrrrrwwwwwwwww";
        config = "oogoywrgwbbgrgwbrbyooboyobwggrbbybyywywrrwooryrrgwgywg";
        config = "rgowywwwwbrbygwrrboooboyobwggybbbbyggoyorrrywyrrgwggoy";

        RubikCube cube = new RubikCube(config);

        System.out.println(config);
        cube.cubeToArray();
        cube.displayFaces();
        cube.solve();
    }
}
