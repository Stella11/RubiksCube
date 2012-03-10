/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bunkdeath.cube;

import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author root
 */
public class RubikCube {

    boolean display = true;
    /** cube code input */
    private String cubeCode;
    /** size of cube 3*3*3 */
    private int N = 3;
    /** top face with values as indexed<br/>
     *  1 2 3<br/>
     *  4 5 6<br/>
     *  7 8 9
     */
    Vector<String> top = new Vector<String>();
    /** left face with values as indexed<br/>
     *  1 2 3<br/>
     *  4 5 6<br/>
     *  7 8 9
     */
    Vector<String> left = new Vector<String>();
    /** front face with values as indexed<br/>
     *  1 2 3<br/>
     *  4 5 6<br/>
     *  7 8 9
     */
    public Vector<String> front = new Vector<String>();
    /** right face with values as indexed<br/>
     *  1 2 3<br/>
     *  4 5 6<br/>
     *  7 8 9
     */
    Vector<String> right = new Vector<String>();
    /** back face with values as indexed<br/>
     *  1 2 3<br/>
     *  4 5 6<br/>
     *  7 8 9
     */
    Vector<String> back = new Vector<String>();
    /** bottom face with values as indexed<br/>
     *  1 2 3<br/>
     *  4 5 6<br/>
     *  7 8 9
     */
    Vector<String> bottom = new Vector<String>();

    /**
     * sets the cube code to process further
     * @param cubeCode code combination from input cube
     */
    public RubikCube(String cubeCode) {
        if (cubeCode.length() == N * N * 6) {
            this.cubeCode = cubeCode;
        } else {
            System.out.println("\t\t\tError in input string");
            System.exit(1);
        }
    }

    /**
     * convert cube code string to array(vector array in this case)
     */
    public void cubeToArray() {
        //System.out.println(cubeCode);
        top.add("");
        left.add("");
        front.add("");
        right.add("");
        back.add("");
        bottom.add("");
        int i = 1;
        for (; i <= 1 * 9; i++) {
            top.add(String.valueOf(cubeCode.charAt(i - 1)));
        }
        for (; i <= 2 * 9; i++) {
            left.add(String.valueOf(cubeCode.charAt(i - 1)));
        }
        for (; i <= 3 * 9; i++) {
            front.add(String.valueOf(cubeCode.charAt(i - 1)));
        }
        for (; i <= 4 * 9; i++) {
            right.add(String.valueOf(cubeCode.charAt(i - 1)));
        }
        for (; i <= 5 * 9; i++) {
            back.add(String.valueOf(cubeCode.charAt(i - 1)));
        }
        for (; i <= 6 * 9; i++) {
            bottom.add(String.valueOf(cubeCode.charAt(i - 1)));
        }
    }

    public void displayFaces() {
        if (!display) {
            return;
        }
        Object[] obj = getFaceObject();
        System.out.println();
        System.out.printf("       %s %s %s\n"
                + "       %s %s %s\n"
                + "       %s %s %s\n"
                + "%s %s %s  %s %s %s  %s %s %s  %s %s %s\n"
                + "%s %s %s  %s %s %s  %s %s %s  %s %s %s\n"
                + "%s %s %s  %s %s %s  %s %s %s  %s %s %s\n"
                + "       %s %s %s\n"
                + "       %s %s %s\n"
                + "       %s %s %s\n", obj);
    }

    public Object[] getFaceObject() {
        Object[] temp = new Object[9 * 6];
        int index = 0;
        Iterator i;
        i = top.iterator();
        i.next();
        while (i.hasNext()) {
            temp[index++] = i.next().toString();
        }
        Iterator l = left.iterator();
        Iterator f = front.iterator();
        Iterator r = right.iterator();
        Iterator b = back.iterator();

        l.next();
        f.next();
        r.next();
        b.next();

        while (l.hasNext()) {
            for (int j = 0; j < 3; j++) {
                temp[index++] = l.next().toString();
            }
            for (int j = 0; j < 3; j++) {
                temp[index++] = f.next().toString();
            }
            for (int j = 0; j < 3; j++) {
                temp[index++] = r.next().toString();
            }
            for (int j = 0; j < 3; j++) {
                temp[index++] = b.next().toString();
            }
        }

        i = bottom.iterator();
        i.next();
        while (i.hasNext()) {
            temp[index++] = i.next().toString();
        }
        return temp;
    }

    /**
     * Rotates the cube clockwise
     * @param position {top, bottom, left, right, front, back}
     */
    public void rotateClock(String position) {
        boolean initialCondition = false;
        String[] pos = {"left", "right", "top", "bottom", "front", "back"};
        for (int i = 0; i < pos.length; i++) {
            if (position.toLowerCase().equals(pos[i])) {
                initialCondition = true;
            }
        }
        if (!initialCondition) {
            System.out.println("\t\t\tError in position");
            System.exit(1);
        }


    }

    public void rotateLeftClock() {
        Vector<String> temp = clone(front);

        front.set(1, top.get(1));
        front.set(4, top.get(4));
        front.set(7, top.get(7));

        top.set(1, back.get(9));
        top.set(4, back.get(6));
        top.set(7, back.get(3));

        back.set(3, bottom.get(7));
        back.set(6, bottom.get(4));
        back.set(9, bottom.get(1));

        bottom.set(1, temp.get(1));
        bottom.set(4, temp.get(4));
        bottom.set(7, temp.get(7));

        rotateFaceClock(left);

        System.out.println("\t\t\tRotate left clock");
    }

    public void rotateLeftCounterClock() {
        Vector<String> temp = clone(front);

        front.set(1, bottom.get(1));
        front.set(4, bottom.get(4));
        front.set(7, bottom.get(7));

        bottom.set(1, back.get(9));
        bottom.set(4, back.get(6));
        bottom.set(7, back.get(3));

        back.set(3, top.get(7));
        back.set(6, top.get(4));
        back.set(9, top.get(1));

        top.set(1, temp.get(1));
        top.set(4, temp.get(4));
        top.set(7, temp.get(7));

        rotateFaceCounterClock(left);

        System.out.println("\t\t\tRotate left counter clock");
    }

    public void rotateRightClock() {
        Vector<String> temp = clone(front);

        front.set(3, bottom.get(3));
        front.set(6, bottom.get(6));
        front.set(9, bottom.get(9));

        bottom.set(3, back.get(7));
        bottom.set(6, back.get(4));
        bottom.set(9, back.get(1));

        back.set(1, top.get(9));
        back.set(4, top.get(6));
        back.set(7, top.get(3));

        top.set(3, temp.get(3));
        top.set(6, temp.get(6));
        top.set(9, temp.get(9));

        rotateFaceClock(right);

        System.out.println("\t\t\tRotate right clock");
    }

    public void rotateRightCounterClock() {
        Vector<String> temp = clone(front);

        front.set(3, top.get(3));
        front.set(6, top.get(6));
        front.set(9, top.get(9));

        top.set(3, back.get(7));
        top.set(6, back.get(4));
        top.set(9, back.get(1));

        back.set(1, bottom.get(9));
        back.set(4, bottom.get(6));
        back.set(7, bottom.get(3));

        bottom.set(3, temp.get(3));
        bottom.set(6, temp.get(6));
        bottom.set(9, temp.get(9));

        rotateFaceCounterClock(right);

        System.out.println("\t\t\tRotate right counter clock");
    }

    public void rotateTopClock() {
        Vector<String> temp = clone(front);

        front.set(1, right.get(1));
        front.set(2, right.get(2));
        front.set(3, right.get(3));

        right.set(1, back.get(1));
        right.set(2, back.get(2));
        right.set(3, back.get(3));

        back.set(1, left.get(1));
        back.set(2, left.get(2));
        back.set(3, left.get(3));

        left.set(1, temp.get(1));
        left.set(2, temp.get(2));
        left.set(3, temp.get(3));

        rotateFaceClock(top);

        System.out.println("\t\t\tRotate top clock");
    }

    public void rotateTopCounterClock() {
        Vector<String> temp = clone(front);

        front.set(1, left.get(1));
        front.set(2, left.get(2));
        front.set(3, left.get(3));

        left.set(1, back.get(1));
        left.set(2, back.get(2));
        left.set(3, back.get(3));

        back.set(1, right.get(1));
        back.set(2, right.get(2));
        back.set(3, right.get(3));

        right.set(1, temp.get(1));
        right.set(2, temp.get(2));
        right.set(3, temp.get(3));

        rotateFaceCounterClock(top);

        System.out.println("\t\t\tRotate top counter clock");
    }

    public void rotatebottomClock() {
        Vector<String> temp = clone(front);

        front.set(7, right.get(7));
        front.set(8, right.get(8));
        front.set(9, right.get(9));

        right.set(7, back.get(7));
        right.set(8, back.get(8));
        right.set(9, back.get(9));

        back.set(7, left.get(7));
        back.set(8, left.get(8));
        back.set(9, left.get(9));

        left.set(7, temp.get(7));
        left.set(8, temp.get(8));
        left.set(9, temp.get(9));

        rotateFaceClock(bottom);

        System.out.println("\t\t\tRotate bottom clock");
    }

    public void rotatebottomCounterClock() {
        Vector<String> temp = clone(front);

        front.set(7, left.get(7));
        front.set(8, left.get(8));
        front.set(9, left.get(9));

        left.set(7, back.get(7));
        left.set(8, back.get(8));
        left.set(9, back.get(9));

        back.set(7, right.get(7));
        back.set(8, right.get(8));
        back.set(9, right.get(9));

        right.set(7, temp.get(7));
        right.set(8, temp.get(8));
        right.set(9, temp.get(9));

        rotateFaceCounterClock(bottom);

        System.out.println("\t\t\tRotate bottom counter clock");
    }

    public void rotateFrontClock() {
        Vector<String> temp = clone(top);

        top.set(7, left.get(9));
        top.set(8, left.get(6));
        top.set(9, left.get(3));

        left.set(3, bottom.get(1));
        left.set(6, bottom.get(2));
        left.set(9, bottom.get(3));

        bottom.set(1, right.get(7));
        bottom.set(2, right.get(4));
        bottom.set(3, right.get(1));

        right.set(1, temp.get(7));
        right.set(4, temp.get(8));
        right.set(7, temp.get(9));

        rotateFaceClock(front);

        System.out.println("\t\t\tRotate front clock");
    }

    public void rotateFrontCounterClock() {
        Vector<String> temp = clone(top);

        top.set(7, right.get(1));
        top.set(8, right.get(4));
        top.set(9, right.get(7));

        right.set(1, bottom.get(3));
        right.set(4, bottom.get(2));
        right.set(7, bottom.get(1));

        bottom.set(1, left.get(3));
        bottom.set(2, left.get(6));
        bottom.set(3, left.get(9));

        left.set(3, temp.get(9));
        left.set(6, temp.get(8));
        left.set(9, temp.get(7));

        rotateFaceCounterClock(front);

        System.out.println("\t\t\tRotate front counter clock");
    }

    public void rotateBackClock() {
        Vector<String> temp = clone(top);

        top.set(1, left.get(7));
        top.set(2, left.get(4));
        top.set(3, left.get(1));

        left.set(1, bottom.get(7));
        left.set(4, bottom.get(8));
        left.set(7, bottom.get(9));

        bottom.set(7, right.get(9));
        bottom.set(8, right.get(6));
        bottom.set(9, right.get(3));

        right.set(3, temp.get(1));
        right.set(6, temp.get(2));
        right.set(9, temp.get(3));

        rotateFaceCounterClock(back);

        System.out.println("\t\t\tRotate back clock");
    }

    public void rotateBackCounterClock() {
        Vector<String> temp = clone(top);

        top.set(1, right.get(3));
        top.set(2, right.get(6));
        top.set(3, right.get(9));

        right.set(3, bottom.get(9));
        right.set(6, bottom.get(8));
        right.set(9, bottom.get(7));

        bottom.set(7, left.get(1));
        bottom.set(8, left.get(4));
        bottom.set(9, left.get(7));

        left.set(1, temp.get(3));
        left.set(4, temp.get(2));
        left.set(7, temp.get(1));

        rotateFaceClock(back);

        System.out.println("\t\t\tRotate back counter clock");
    }

    public void clock() {
        Vector<String> temp = clone(front);

        front = clone(right);
        right = clone(back);
        back = clone(left);
        left = clone(temp);

        rotateFaceClock(top);
        rotateFaceCounterClock(bottom);
    }

    public void rotateCubeClock() {
        clock();
        System.out.println("\t\t\tRotate cube clock");
    }

    public void rotateCubeCounterClock() {
        clock();
        clock();
        clock();
        System.out.println("\t\t\tRotate cube counter clock");
    }

    public void rotateFaceClock(Vector<String> face) {
        Vector<String> current = face;
        Vector<String> temp = clone(face);

        current.set(1, temp.get(7));
        current.set(2, temp.get(4));
        current.set(3, temp.get(1));
        current.set(4, temp.get(8));
        current.set(5, temp.get(5));
        current.set(6, temp.get(2));
        current.set(7, temp.get(9));
        current.set(8, temp.get(6));
        current.set(9, temp.get(3));
    }

    public void rotateFaceCounterClock(Vector<String> face) {
        Vector<String> current = face;
        Vector<String> temp = clone(face);

        current.set(1, temp.get(3));
        current.set(2, temp.get(6));
        current.set(3, temp.get(9));
        current.set(4, temp.get(2));
        current.set(5, temp.get(5));
        current.set(6, temp.get(8));
        current.set(7, temp.get(1));
        current.set(8, temp.get(4));
        current.set(9, temp.get(7));
    }

    /**
     * Clones the given vector face
     * @param face vector face
     * @return cloned vector face
     */
    public Vector<String> clone(Vector<String> face) {
        Vector<String> cloneVector = new Vector<String>();
        Iterator i = face.iterator();
        while (i.hasNext()) {
            cloneVector.add(i.next().toString());
        }
        return cloneVector;
    }

    public String getFaceColor(Vector<String> face) {
        return face.get(5).toString();
    }

    public void solve() {
        //display = false;
        SolveBottomCross btmCross = new SolveBottomCross(this);
        SolveFirstLayer first = new SolveFirstLayer(this);
        SolveSecondLayer second = new SolveSecondLayer(this);
        SolveTopFace topFace = new SolveTopFace(this);
        SolveLastLayer last = new SolveLastLayer(this);

        System.out.println("Bottom Cross");
        btmCross.solve();
        System.out.println("first layer");
        first.solve();
        System.out.println("second layer");
        second.solve();

        System.out.println("Top face");
        topFace.solve();

        System.out.println("\n\n\n\n\n\n\n\n\n\nLast Layer");
        last.solve();
    }
}
