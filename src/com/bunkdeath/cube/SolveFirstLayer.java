/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bunkdeath.cube;

/**
 *
 * @author bunkdeath
 */
public class SolveFirstLayer {

    RubikCube cube;

    public SolveFirstLayer(RubikCube cube) {
        this.cube = cube;
    }

    public void solve() {
        /*
         *  find white piece on corner.
         *  find conguative face color piece
         *  put on the right place
         * repeat until there is a white piece
         *
         *
         */
        System.out.println("\n\n\nSolving first layer\n\n");
        System.out.println("\n\n\nSolving top coroner\n\n");
        solveIfInTopCornor(cube.bottom.get(5).toString());
        System.out.println("\n\n\nSolving bottom cornor\n\n");
        solveIfInBottomCornor(cube.bottom.get(5).toString());
        System.out.println("\n\n\nSolving bottom face cornor\n\n");
        solveIfInBottomFaceCornorUnsolved(cube.bottom.get(5).toString());
        System.out.println("\n\n\nSolving top face cornor\n\n");
        solveIfInTopFaceCornorUnsolved(cube.bottom.get(5).toString());
    }

    /**
     * just for bottom layer solve
     */
    public void solveIfInTopCornor(String bottomFaceColor) {
        /*
         * find face color.
         * if there is bottomFacecolor with faceColor, align
         */
        String faceColor = "";
        while (isBottomFaceOnTopCornor(bottomFaceColor)) {
            //System.out.println("true");
            if (cube.front.get(1).equals(bottomFaceColor)) {
                faceColor = cube.left.get(3).toString();
                if (cube.left.get(5).equals(faceColor)) {
                    cube.rotateCubeCounterClock();
                    cube.rotateTopCounterClock();
                    cube.rotateFrontCounterClock();
                    cube.rotateTopClock();
                    cube.rotateFrontClock();
                    cube.displayFaces();
                } else {
                    cube.rotateTopClock();
                }
            } else if (cube.front.get(3).equals(bottomFaceColor)) {
                faceColor = cube.right.get(1).toString();
                if (cube.right.get(5).equals(faceColor)) {
                    cube.rotateCubeClock();
                    cube.displayFaces();
                    cube.rotateTopClock();
                    cube.rotateFrontClock();
                    cube.rotateTopCounterClock();
                    cube.rotateFrontCounterClock();
                    cube.displayFaces();
                }
                cube.rotateTopClock();
            } else if (cube.left.get(1).equals(bottomFaceColor) || cube.left.get(3).equals(bottomFaceColor)) {
                cube.rotateCubeCounterClock();
                cube.displayFaces();
            } else if (cube.right.get(3).equals(bottomFaceColor) || cube.right.get(1).equals(bottomFaceColor)) {
                cube.rotateCubeClock();
                cube.displayFaces();
            } else if (cube.back.get(1).equals(bottomFaceColor) || cube.back.get(3).equals(bottomFaceColor)) {
                cube.rotateCubeClock();
                cube.rotateCubeClock();
                cube.displayFaces();
            }
        }
    }

    public void solveIfInBottomCornor(String bottomFaceColor) {
        while (isBottomFaceOnBottomCornor(bottomFaceColor)) {
            if (cube.front.get(7).equals(bottomFaceColor)) {
                cube.rotateLeftCounterClock();
                cube.rotateTopClock();
                cube.rotateLeftClock();
            } else if (cube.front.get(9).equals(bottomFaceColor)) {
                cube.rotateRightClock();
                cube.rotateTopCounterClock();
                cube.rotateRightCounterClock();
            } else if (cube.left.get(7).equals(bottomFaceColor) || cube.left.get(9).equals(bottomFaceColor)) {
                cube.rotateCubeCounterClock();
            } else if (cube.right.get(7).equals(bottomFaceColor) || cube.right.get(9).equals(bottomFaceColor)) {
                cube.rotateCubeClock();
            } else if (cube.back.get(7).equals(bottomFaceColor) || cube.back.get(9).equals(bottomFaceColor)) {
                cube.rotateCubeClock();
                cube.rotateCubeClock();
            }

            solveIfInTopCornor(bottomFaceColor);
        }
    }

    public void solveIfInBottomFaceCornorUnsolved(String bottomFaceColor) {
        while (isBottomFaceOnBottomFaceCornorUnsolved(bottomFaceColor)) {
            solveIfInTopCornor(bottomFaceColor);
        }
    }

    public void solveIfInTopFaceCornorUnsolved(String bottomFaceColor) {
        while (isBottomFaceOnTopFaceCornorUnsolved(bottomFaceColor)) {
            System.out.print(".");
            solveIfInTopCornor(bottomFaceColor);
        }
    }

    /**
     * searches for bottom face color at the top, not on top face.
     * @param bottomFaceColor bottom face color
     * @return true if present else false
     */
    public boolean isBottomFaceOnTopCornor(String bottomFaceColor) {
        if (cube.front.get(1).equals(bottomFaceColor)) {
            return true;
        } else if (cube.front.get(3).equals(bottomFaceColor)) {
            return true;
        } else if (cube.left.get(1).equals(bottomFaceColor)) {
            return true;
        } else if (cube.left.get(3).equals(bottomFaceColor)) {
            return true;
        } else if (cube.right.get(1).equals(bottomFaceColor)) {
            return true;
        } else if (cube.right.get(3).equals(bottomFaceColor)) {
            return true;
        } else if (cube.back.get(1).equals(bottomFaceColor)) {
            return true;
        } else if (cube.back.get(3).equals(bottomFaceColor)) {
            return true;
        }
        return false;
    }

    /**
     * searches for bottom face color at the bottom, not on bottom face.
     * @param bottomFaceColor bottom face color
     * @return true if present else false
     */
    public boolean isBottomFaceOnBottomCornor(String bottomFaceColor) {
        if (cube.front.get(7).equals(bottomFaceColor)) {
            return true;
        } else if (cube.front.get(9).equals(bottomFaceColor)) {
            return true;
        } else if (cube.left.get(7).equals(bottomFaceColor)) {
            return true;
        } else if (cube.left.get(9).equals(bottomFaceColor)) {
            return true;
        } else if (cube.right.get(7).equals(bottomFaceColor)) {
            return true;
        } else if (cube.right.get(9).equals(bottomFaceColor)) {
            return true;
        } else if (cube.back.get(7).equals(bottomFaceColor)) {
            return true;
        } else if (cube.back.get(9).equals(bottomFaceColor)) {
            return true;
        }
        return false;
    }

    public boolean isBottomFaceOnBottomFaceCornorUnsolved(String bottomFaceColor) {
        String face1 = "";
        String face2 = "";
        if (cube.bottom.get(1).equals(bottomFaceColor)) {
            face1 = cube.front.get(5);
            face2 = cube.left.get(5);
            if (!cube.front.get(7).equals(face1) || !cube.left.get(9).equals(face2)) {
                cube.rotateLeftCounterClock();
                cube.rotateTopClock();
                cube.rotateLeftClock();
                return true;
            }
        } else if (cube.bottom.get(3).equals(bottomFaceColor)) {
            face1 = cube.front.get(5);
            face2 = cube.right.get(5);
            if (!cube.front.get(9).equals(face1) || !cube.right.get(7).equals(face2)) {
                cube.rotateRightClock();
                cube.rotateTopCounterClock();
                cube.rotateRightCounterClock();
                return true;
            }

        } else if (cube.bottom.get(9).equals(bottomFaceColor)) {
            face1 = cube.right.get(5);
            face2 = cube.back.get(5);
            if (!cube.right.get(9).equals(face1) || !cube.back.get(7).equals(face2)) {
                cube.rotateCubeClock();
                cube.rotateRightClock();
                cube.rotateTopCounterClock();
                cube.rotateRightCounterClock();
                return true;
            }

        } else if (cube.bottom.get(7).equals(bottomFaceColor)) {
            face1 = cube.back.get(5);
            face2 = cube.left.get(5);
            if (!cube.back.get(9).equals(face1) || !cube.left.get(7).equals(face2)) {
                cube.rotateCubeClock();
                cube.rotateRightClock();
                cube.rotateTopCounterClock();
                cube.rotateRightCounterClock();
                return true;
            }
        }
        return false;
    }

    public boolean isBottomFaceOnTopFaceCornorUnsolved(String bottomFaceColor) {
        if (cube.top.get(7).equals(bottomFaceColor)) {
            if (!cube.bottom.get(1).equals(bottomFaceColor)) {
                cube.rotateLeftCounterClock();
                cube.rotateTopClock();
                cube.rotateLeftClock();
            } else {
                cube.rotateTopClock();
                cube.rotateCubeCounterClock();
            }
            return true;
        } else if (cube.top.get(9).equals(bottomFaceColor)) {
            if (!cube.bottom.get(3).equals(bottomFaceColor)) {
                cube.rotateRightClock();
                cube.rotateTopCounterClock();
                cube.rotateRightCounterClock();
            } else {
                cube.rotateTopClock();
            }
            return true;
        } else if (cube.top.get(3).equals(bottomFaceColor)) {
            cube.rotateCubeClock();
            return true;
        } else if (cube.top.get(1).equals(bottomFaceColor)) {
            cube.rotateCubeCounterClock();
            return true;
        }
        return false;
    }
}
