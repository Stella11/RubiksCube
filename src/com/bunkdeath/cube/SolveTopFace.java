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
public class SolveTopFace {

    RubikCube cube;

    public SolveTopFace(RubikCube cube) {
        this.cube = cube;
    }

    public void solve() {
        while (!isTopFaceSolved()) {
            if (crossOnTop()) {
                solveWhenCrossOnTop();
            } else if (lineOnTop()) {
                solveWhenDotOnTop();
            } else if (isLOnTop()) {
                alignLOnTop();
                solveWhenLOnTop();
            } else {
                solveWhenDotOnTop();
            }
        }
    }

    public void solveWhenCrossOnTop() {
        if (isFishShape()) {
            if (isSuneCondition()) {
                solveSune();
            } else if (!isSuneCondition()) {
                solveAntiSune();
            }
        } else {
            align2TopColorOnLeft();
            solveSune();
        }
        cube.displayFaces();
    }

    public void solveSune() {
        cube.rotateRightClock();
        cube.rotateTopClock();
        cube.rotateRightCounterClock();
        cube.rotateTopClock();
        cube.rotateRightClock();
        cube.rotateTopClock();
        cube.rotateTopClock();
        cube.rotateRightCounterClock();
        cube.displayFaces();
    }

    public void solveAntiSune() {
        cube.rotateLeftClock();
        cube.rotateTopCounterClock();
        cube.rotateTopCounterClock();
        cube.rotateLeftCounterClock();
        cube.rotateTopCounterClock();
        cube.rotateLeftClock();
        cube.rotateTopCounterClock();
        cube.rotateLeftCounterClock();
        cube.displayFaces();
    }

    public void solveWhenLOnTop() {
        cube.rotateFrontClock();
        cube.rotateTopClock();
        cube.rotateRightClock();

        cube.rotateTopCounterClock();
        cube.rotateRightCounterClock();
        cube.rotateFrontCounterClock();

        cube.displayFaces();
    }

    public void solveWhenDotOnTop() {
        cube.rotateFrontClock();
        cube.rotateRightClock();
        cube.rotateTopClock();

        cube.rotateRightCounterClock();
        cube.rotateTopCounterClock();
        cube.rotateFrontCounterClock();

        cube.displayFaces();
    }

    public void alignLOnTop() {
        int[] index = {2, 4, 5};
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < index.length; i++) {
                if (!cube.top.get(index[i]).equals(cube.top.get(5))) {
                    break;
                }
                cube.displayFaces();
                return;
            }
            cube.rotateCubeClock();
        }
    }

    public boolean isTopFaceSolved() {
        for (int i = 1; i <= 9; i++) {
            if (!cube.top.get(i).equals(cube.top.get(5))) {
                return false;
            }
        }
        return true;
    }

    public boolean crossOnTop() {
        int[] index = {2, 4, 5, 6, 8};
        for (int i = 0; i < index.length; i++) {
            if (!cube.top.get(index[i]).equals(cube.top.get(5))) {
                return false;
            }
        }
        return true;
    }

    public boolean isFishShape() {
        Vector<String> top = cube.clone(cube.top);
        String f1, f2, f3, f4, f5, f6, f7, f8, f9;

        for (int i = 0; i < 4; i++) {
            f1 = top.get(1);
            f2 = top.get(2);
            f3 = top.get(3);
            f4 = top.get(4);
            f5 = top.get(5);
            f6 = top.get(6);
            f7 = top.get(7);
            f8 = top.get(8);
            f9 = top.get(9);
            if (!f1.equals(f5) && f2.equals(f5) && !f3.equals(f5)
                    && f4.equals(f5) && f5.equals(f5) && f6.equals(f5)
                    && f7.equals(f5) && f8.equals(f5) && !f9.equals(f5)) {
                rotateCube(i);
                return true;
            }
            cube.rotateFaceClock(top);
        }
        return false;
    }

    public void rotateCube(int n) {
        for (int i = 0; i < n; i++) {
            cube.rotateCubeClock();
        }
    }

    public boolean isSuneCondition() {
        if (cube.front.get(3).equals(cube.top.get(5))) {
            return true;
        }
        return false;
    }

    public void align2TopColorOnLeft() {
        if (cube.left.get(1).equals(cube.top.get(5)) && cube.left.get(3).equals(cube.top.get(5))) {
            return;
        } else if (cube.front.get(1).equals(cube.top.get(5)) && cube.front.get(3).equals(cube.top.get(5))) {
            cube.rotateTopClock();
            return;
        } else if (cube.right.get(1).equals(cube.top.get(5)) && cube.right.get(3).equals(cube.top.get(5))) {
            cube.rotateTopClock();
            cube.rotateTopClock();
            return;
        } else if (cube.back.get(1).equals(cube.top.get(5)) && cube.back.get(3).equals(cube.top.get(5))) {
            cube.rotateTopCounterClock();
            return;
        } else if (cube.left.get(1).equals(cube.top.get(5)) || cube.left.get(3).equals(cube.top.get(5))) {
            return;
        } else if (cube.front.get(1).equals(cube.top.get(5)) || cube.front.get(3).equals(cube.top.get(5))) {
            cube.rotateTopClock();
            return;
        } else if (cube.right.get(1).equals(cube.top.get(5)) || cube.right.get(3).equals(cube.top.get(5))) {
            cube.rotateTopClock();
            cube.rotateTopClock();
            return;
        } else if (cube.back.get(1).equals(cube.top.get(5)) || cube.back.get(3).equals(cube.top.get(5))) {
            cube.rotateTopCounterClock();
            return;
        }
    }

    public boolean lineOnTop() {
        Vector<String> face = cube.clone(cube.top);
        String f1 = face.get(2);
        String f2 = face.get(5);
        String f3 = face.get(8);
//9841341745 maila  (no) ba. 1 ja. 7586
        String f4 = face.get(2);
        String f5 = face.get(5);
        String f6 = face.get(8);

        String f = face.get(5);

        if (f1.equals(f) && f2.equals(f) && f3.equals(f)) {
            cube.rotateTopClock();
            return true;
        }

        if (f4.equals(f) && f5.equals(f) && f6.equals(f)) {
            return true;
        }

        return false;
    }

    public boolean isLOnTop() {
        Vector<String> face = cube.clone(cube.top);
        int[] index = {2, 4, 5};
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < index.length; i++) {
                if (!face.get(index[i]).equals(face.get(5))) {
                    break;
                }
                return true;
            }
            cube.rotateFaceClock(face);
        }
        return false;
    }
}
