/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bunkdeath.cube;

import java.util.Vector;

/**
 *
 * @author bunkdeath
 */
public class SolveBottomCross {

    RubikCube cube;

    public SolveBottomCross(RubikCube cube) {
        this.cube = cube;
    }

    public void solve() {
        if (bottomCrossCondition(cube.bottom.get(5), false)) {
            return;
        }
        /** traks if move is done */
        boolean move;
        /** counts one if a complete move that was expected is made */
        int packageMove = 0;
        int index = 0;
        int iteration = 0;

        String faceColor = cube.getFaceColor(cube.bottom);
        packageMove = matchedTopEdges(faceColor, cube.top);
        while (!bottomCrossCondition(faceColor, true) && packageMove < 20 && iteration < 20) {
            iteration++;
            index = findColorOnEdge(faceColor, cube.bottom);
            if (index != 0) {
                switch (index) {
                    case 2:
                        while (containsColorInIndexOfFace(faceColor, 8, cube.top)) {
                            cube.rotateTopClock();
                        }
                        cube.rotateFrontClock();
                        cube.rotateFrontClock();
                        packageMove++;
                        cube.displayFaces();
                        continue;
                    case 4:
                        while (containsColorInIndexOfFace(faceColor, 4, cube.top)) {
                            cube.rotateTopClock();
                        }
                        cube.rotateLeftClock();
                        cube.rotateLeftClock();
                        packageMove++;
                        cube.displayFaces();
                        continue;
                    case 6:
                        while (containsColorInIndexOfFace(faceColor, index, cube.top)) {
                            cube.rotateTopClock();
                        }
                        cube.rotateRightClock();
                        cube.rotateRightClock();
                        packageMove++;
                        cube.displayFaces();
                        continue;
                    case 8:
                        while (containsColorInIndexOfFace(faceColor, 2, cube.top)) {
                            cube.rotateTopClock();
                        }
                        cube.rotateBackClock();
                        cube.rotateBackClock();
                        packageMove++;
                        cube.displayFaces();
                        continue;
                }
            }
            index = findColorOnEdge(faceColor, cube.front);
            if (index != 0) {
                switch (index) {
                    case 2:
                        cube.rotateFrontClock();
                        cube.displayFaces();
                        move = false;
                        do {
                            if (!containsColorInIndexOfFace(faceColor, 6, cube.top)) {
                                cube.rotateRightClock();
                                packageMove++;
                                cube.displayFaces();
                                move = true;
                            } else {
                                cube.rotateTopClock();
                            }
                        } while (!move);
                        continue;
                    case 4:
                        move = false;
                        do {
                            if (!containsColorInIndexOfFace(faceColor, 4, cube.top)) {
                                cube.rotateLeftCounterClock();
                                packageMove++;
                                cube.displayFaces();
                                move = true;
                            } else {
                                cube.rotateTopClock();
                            }
                        } while (!move);
                        continue;
                    case 6:
                        move = false;
                        do {
                            if (!containsColorInIndexOfFace(faceColor, 6, cube.top)) {
                                cube.rotateRightClock();
                                packageMove++;
                                cube.displayFaces();
                                move = true;
                            } else {
                                cube.rotateTopClock();
                            }
                        } while (!move);
                        continue;
                    case 8:
                        move = false;
                        if (!containsColorInIndexOfFace(faceColor, 8, cube.top)) {
                            cube.rotateFrontClock();
                            while (containsColorInIndexOfFace(faceColor, 4, cube.top)) {
                                cube.rotateTopClock();
                            }
                            cube.rotateLeftCounterClock();
                            packageMove++;
                            cube.displayFaces();
                        }
                        continue;
                }
            }
            index = findColorOnEdge(faceColor, cube.left);
            if (index != 0) {
                cube.rotateCubeClock();
                cube.rotateCubeClock();
                cube.rotateCubeClock();
                cube.displayFaces();
                continue;
            }
            index = findColorOnEdge(faceColor, cube.right);
            if (index != 0) {
                cube.rotateCubeClock();
                continue;
            }
            index = findColorOnEdge(faceColor, cube.back);
            if (index != 0) {
                cube.rotateCubeClock();
                cube.rotateCubeClock();
                continue;
            }
        }

        /**
         * get front face color.
         * search for this face color in faces starting from front, left, right, back
         * get face
         * switch face
         *      front :
         *      left : rotate top counter clock
         *      right : rotate top clock
         *      back : rotate top clock twice
         *
         * rotate front clock twice
         */
        System.out.println("Number of iteration = " + iteration);

        String face = "";
        iteration = 0;
        while (!bottomCrossCondition(faceColor, false) && iteration < 10) {
            iteration++;
            face = cube.getFaceColor(cube.front);
            if (cube.front.get(2).equals(face) && cube.top.get(8).equals(faceColor)) {
            } else if (cube.right.get(2).equals(face) && cube.top.get(6).equals(faceColor)) {
                cube.rotateTopClock();
            } else if (cube.left.get(2).equals(face) && cube.top.get(4).equals(faceColor)) {
                cube.rotateTopCounterClock();
            } else if (cube.back.get(2).equals(face) && cube.top.get(2).equals(faceColor)) {
                cube.rotateTopClock();
                cube.rotateTopClock();
            }

            cube.rotateFrontClock();
            cube.rotateFrontClock();
            cube.displayFaces();

            cube.rotateCubeClock();
            cube.displayFaces();
        }
    }

    public boolean bottomCrossCondition(String faceColor, boolean topCross) {
        Vector<String> face = null;
        if (topCross) {
            face = cube.top;
        } else {
            face = cube.bottom;
        }
        int[] index = {2, 4, 6, 8};
        for (int i = 0; i < index.length; i++) {
            if (!face.get(index[i]).equals(faceColor)) {
                return false;
            }
        }
        return true;
    }

    public int matchedTopEdges(String colorCode, Vector<String> face) {
        int ret = 0;
        int[] index = {2, 4, 6, 8};
        for (int i = 0; i < index.length; i++) {
            if (face.get(index[i]).equals(colorCode)) {
                ret++;
            }
        }
        return ret;
    }

    public int findColorOnEdge(String colorCode, Vector<String> face) {
        int[] index = {4, 6, 2, 8};
        for (int i = 0; i < index.length; i++) {
            if (face.get(index[i]).equals(colorCode)) {
                return index[i];

            }
        }
        return 0;
    }

    public boolean containsColorInIndexOfFace(String colorCode, int index, Vector<String> face) {
        if (face.get(index).equals(colorCode)) {
            return true;
        }
        return false;
    }
}
