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
public class SolveLastLayer {

    RubikCube cube;

    public SolveLastLayer(RubikCube cube) {
        this.cube = cube;
    }

    public void solve() {
        int iterator = 0;
        while (!isCubeSolved() && iterator < 10) {
            iterator++;
            if (isFourPole()) {
                if (isAnySideFace()) {
                    solveFinal();
                } else {
                    solveFinal();
                }
            } else {
                align2CornorOnLeft();
                solveTwoCornorAlgo();
            }
        }
    }

    public void solveTwoCornorAlgo() {
        cube.rotateRightClock();
        cube.rotateTopClock();
        cube.rotateTopClock();
        cube.rotateRightCounterClock();
        cube.rotateTopCounterClock();
        cube.rotateRightClock();
        cube.rotateTopClock();
        cube.rotateTopClock();
        cube.rotateLeftCounterClock();
        cube.rotateTopClock();
        cube.rotateRightCounterClock();
        cube.rotateTopCounterClock();
        cube.rotateLeftClock();

        cube.displayFaces();
    }

    public void solveFinal() {
        if (cube.front.get(2).equals(cube.right.get(5))) {
            cube.rotateRightClock();
            cube.rotateTopCounterClock();
            cube.rotateRightClock();
            cube.rotateTopClock();
            cube.rotateRightClock();
            cube.rotateTopClock();
            cube.rotateRightClock();
            cube.rotateTopCounterClock();
            cube.rotateRightCounterClock();
            cube.rotateTopCounterClock();
            cube.rotateRightClock();
            cube.rotateRightClock();
        } else {
            //rr t r t r' t' r' t' r' t r'
            cube.rotateRightClock();
            cube.rotateRightClock();
            cube.rotateTopClock();
            cube.rotateRightClock();
            cube.rotateTopClock();
            cube.rotateRightCounterClock();
            cube.rotateTopCounterClock();
            cube.rotateRightCounterClock();
            cube.rotateTopCounterClock();
            cube.rotateRightCounterClock();
            cube.rotateTopClock();
            cube.rotateRightCounterClock();
        }

        cube.displayFaces();
    }

    public boolean isFourPole() {
        if (cube.front.get(1).equals(cube.front.get(3))
                && cube.right.get(1).equals(cube.right.get(3))
                && cube.back.get(1).equals(cube.back.get(3))
                && cube.left.get(1).equals(cube.left.get(3))) {
            alignFourPole();
            return true;
        }
        return false;
    }

    public void alignFourPole() {
        for (int i = 0; i < 4; i++) {
            if (cube.front.get(1).equals(cube.front.get(5)) && cube.front.get(3).equals(cube.front.get(5))
                    && cube.right.get(1).equals(cube.right.get(5)) && cube.right.get(3).equals(cube.right.get(5))
                    && cube.back.get(1).equals(cube.back.get(5)) && cube.back.get(3).equals(cube.back.get(5))
                    && cube.left.get(1).equals(cube.left.get(5)) && cube.left.get(3).equals(cube.left.get(5))) {
                return;
            }
            cube.rotateTopClock();
        }
    }

    public boolean isAnySideFace() {
        if (cube.front.get(1).equals(cube.front.get(2)) && cube.front.get(1).equals(cube.front.get(3))
                || cube.right.get(1).equals(cube.right.get(2)) && cube.right.get(1).equals(cube.right.get(3))
                || cube.back.get(1).equals(cube.back.get(2)) && cube.back.get(1).equals(cube.back.get(3))
                || cube.left.get(1).equals(cube.left.get(2)) && cube.left.get(1).equals(cube.left.get(3))) {
            alignSideFace();
            return true;
        }

        return false;
    }

    public void alignSideFace() {
        for (int i = 0; i < 4; i++) {
            if (isSideFaceSolved(cube.front)) {
                cube.rotateCubeClock();
                cube.rotateCubeClock();
                cube.displayFaces();
                return;
            } else if (isSideFaceSolved(cube.right)) {
                cube.rotateCubeCounterClock();
                cube.displayFaces();
                return;
            } else if (isSideFaceSolved(cube.back)) {
                return;
            } else if (isSideFaceSolved(cube.left)) {
                cube.rotateCubeClock();
                cube.displayFaces();
                return;
            }
            cube.rotateTopClock();
        }
    }

    public boolean isSideFaceSolved(Vector<String> face) {
        for (int i = 1; i <= 9; i++) {
            if (!face.get(i).equals(face.get(5))) {
                return false;
            }
        }
        return true;
    }

    public boolean isCubeSolved() {
        if (isSideFaceSolved(cube.top)
                && isSideFaceSolved(cube.left)
                && isSideFaceSolved(cube.front)
                && isSideFaceSolved(cube.right)
                && isSideFaceSolved(cube.back)
                && isSideFaceSolved(cube.bottom)) {
            return true;
        }
        return false;
    }

    public void align2CornorOnLeft() {
        for (int i = 0; i < 4; i++) {
            if (cube.left.get(1).equals(cube.left.get(5)) && cube.left.get(3).equals(cube.left.get(5))) {
                cube.displayFaces();
                return;
            } else if (cube.front.get(1).equals(cube.front.get(5)) && cube.front.get(3).equals(cube.front.get(5))) {
                cube.rotateCubeClock();
                cube.displayFaces();
                return;
            } else if (cube.right.get(1).equals(cube.right.get(5)) && cube.right.get(3).equals(cube.right.get(5))) {
                cube.rotateCubeClock();
                cube.rotateCubeClock();
                cube.displayFaces();
                return;
            } else if (cube.back.get(1).equals(cube.back.get(5)) && cube.back.get(3).equals(cube.back.get(5))) {
                cube.rotateCubeCounterClock();
                cube.displayFaces();
                return;
            }

            cube.rotateTopClock();
        }

        for (int i = 0; i < 4; i++) {
            if (cube.left.get(1).equals(cube.left.get(5)) || cube.left.get(3).equals(cube.left.get(5))) {
                cube.displayFaces();
                return;
            } else if (cube.front.get(1).equals(cube.front.get(5)) || cube.front.get(3).equals(cube.front.get(5))) {
                cube.rotateCubeClock();
                cube.displayFaces();
                return;
            } else if (cube.right.get(1).equals(cube.right.get(5)) || cube.right.get(3).equals(cube.right.get(5))) {
                cube.rotateCubeClock();
                cube.rotateCubeClock();
                cube.displayFaces();
                return;
            } else if (cube.back.get(1).equals(cube.back.get(5)) || cube.back.get(3).equals(cube.back.get(5))) {
                cube.rotateCubeCounterClock();
                cube.displayFaces();
                return;
            }

            cube.rotateTopClock();
        }
    }
}
