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
public class SolveSecondLayer {

    RubikCube cube;

    public SolveSecondLayer(RubikCube cube) {
        this.cube = cube;
    }

    public void solve() {
        while (!isSecondLayerSolved()) {
            solveUnsolvedPiecesOnTop();
            solveUnsolvedPiecesOnSide();
        }
    }

    public void solveUnsolvedPiecesOnTop() {
        String faceColor = "";
        String topFaceColor = "";
        while (isSecondLayerUnsolvedPieceOnTop()) {
            faceColor = cube.front.get(5);
            topFaceColor = cube.top.get(5);
            if (cube.front.get(2).equals(faceColor) && !cube.top.get(8).equals(topFaceColor)) {
            } else if (cube.right.get(2).equals(faceColor) && !cube.top.get(6).equals(topFaceColor)) {
                cube.rotateTopClock();
            } else if (cube.back.get(2).equals(faceColor) && !cube.top.get(2).equals(topFaceColor)) {
                cube.rotateTopClock();
                cube.rotateTopClock();
            } else if (cube.left.get(2).equals(faceColor) && !cube.top.get(4).equals(topFaceColor)) {
                cube.rotateTopCounterClock();
            } else {
                cube.rotateCubeClock();
                continue;
            }
            solveSecondLayerFromTop();
            cube.displayFaces();
        }
    }

    /**
     * solves second layer when there is condition where the required cube piece
     * is aligned in cube.front face
     */
    public void solveSecondLayerFromTop() {
        if (cube.top.get(8).equals(cube.left.get(5))) {
            cube.rotateTopCounterClock();
            cube.rotateLeftCounterClock();
            cube.rotateTopClock();
            cube.rotateLeftClock();

            cube.rotateFrontCounterClock();
            cube.rotateLeftClock();
            cube.rotateFrontClock();
            cube.rotateLeftCounterClock();
        } else {
            cube.rotateTopClock();
            cube.rotateRightClock();
            cube.rotateTopCounterClock();
            cube.rotateRightCounterClock();

            cube.rotateTopCounterClock();
            cube.rotateFrontCounterClock();
            cube.rotateTopClock();
            cube.rotateFrontClock();
        }
    }

    public boolean isSecondLayerUnsolvedPieceOnTop() {
        String topFace = cube.top.get(5).toString();

        if (!cube.front.get(2).equals(topFace) && !cube.top.get(8).equals(topFace)) {
            return true;
        } else if (!cube.right.get(2).equals(topFace) && !cube.top.get(6).equals(topFace)) {
            return true;
        } else if (!cube.back.get(2).equals(topFace) && !cube.top.get(2).equals(topFace)) {
            return true;
        } else if (!cube.left.get(2).equals(topFace) && !cube.top.get(4).equals(topFace)) {
            return true;
        }
        return false;
    }

    public void solveUnsolvedPiecesOnSide() {
        String topFaceColor = cube.top.get(5);
        while (isSecondLayerUnsolvedPieceOnSide()) {
            if (!cube.front.get(4).equals(cube.front.get(5)) && !cube.front.get(4).equals(topFaceColor)
                    && !cube.left.get(6).equals(cube.left.get(5)) && !cube.left.get(6).equals(topFaceColor)) {

                cube.rotateLeftCounterClock();
                cube.rotateTopClock();
                cube.rotateLeftClock();

                cube.rotateTopClock();
                cube.rotateFrontClock();
                cube.rotateTopCounterClock();
                cube.rotateFrontCounterClock();

                solveUnsolvedPiecesOnTop();

                cube.displayFaces();
            }
            cube.rotateCubeClock();
            cube.displayFaces();
        }
    }

    public boolean isSecondLayerUnsolvedPieceOnSide() {
        String topFaceColor = cube.top.get(5);
//       if cube.front 6 and cube.right 4 are not face color and not cube.top color return true
        if (!cube.front.get(6).equals(cube.front.get(5)) && !cube.front.get(6).equals(topFaceColor)
                && !cube.right.get(4).equals(cube.right.get(5)) && !cube.right.get(4).equals(topFaceColor)) {
            System.out.println("Return true");
            return true;
        } else if (!cube.front.get(4).equals(cube.front.get(5)) && !cube.front.get(4).equals(topFaceColor)
                && !cube.left.get(6).equals(cube.left.get(5)) && !cube.left.get(6).equals(topFaceColor)) {
            System.out.println("Return true");
            return true;
        } else if (!cube.right.get(6).equals(cube.right.get(5)) && !cube.right.get(6).equals(topFaceColor)
                && !cube.back.get(4).equals(cube.back.get(5)) && !cube.back.get(4).equals(topFaceColor)) {
            System.out.println("Return true");
            return true;
        } else if (!cube.back.get(6).equals(cube.back.get(5)) && !cube.back.get(6).equals(topFaceColor)
                && !cube.left.get(4).equals(cube.left.get(5)) && !cube.left.get(4).equals(topFaceColor)) {
            System.out.println("Return true");
            return true;
        }
        return false;
    }

    public boolean isSecondLayerSolved() {
        boolean ret = true;
        String face1 = "";
        String face2 = "";

        face1 = cube.front.get(5).toString();
        face2 = cube.left.get(5).toString();
        if (isPositionFaceColor(cube.front, 4) && isPositionFaceColor(cube.left, 6)) {
            if (isPositionFaceColor(cube.front, 6) && isPositionFaceColor(cube.right, 4)) {
                if (isPositionFaceColor(cube.right, 6) && isPositionFaceColor(cube.back, 4)) {
                    if (isPositionFaceColor(cube.back, 6) && isPositionFaceColor(cube.left, 4)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isPositionFaceColor(Vector<String> face, int pos) {
        if (face.get(5).equals(face.get(pos))) {
            return true;
        }
        return false;
    }
}
